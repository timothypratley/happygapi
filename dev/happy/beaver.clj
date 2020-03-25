(ns happy.beaver
  "Builds code forms for calling the remote APIs."
  (:require [clojure.string :as str]
            [fipp.clojure :as pprint]
            [meander.strategy.epsilon :as s]
            [meander.epsilon :as m]
            [meander.syntax.epsilon :as r.syntax]))

(def out-ns "happygapi")

(defn method-name
  "To avoid collisions with clojure.core, methods are named like `get$`.
  Where they are a sub-resource, they are named like `parent-get$`."
  [id]
  (str (str/join \- (drop 2 (str/split id #"\."))) \$))

(defn doc-path
  "Google doc pages follow naming convention."
  [id]
  (str/join \/ (rest (str/split id #"\."))))

(defn summarize-schema [schema request depth]
  "Given a json-schema of type definitions,
  and a request that is a $ref to one of those types,
  resolves $ref(s) to a depth of 3,
  discards the distracting information,
  and returns a pattern for constructing the required input."
  (m/rewrite request
    {:type                 "object"
     :id                   ?id
     :additionalProperties ?ap
     :properties           (m/seqable [!property !item] ...)}
    ;;>
    {& ([!property (m/app #(summarize-schema schema % depth) !item)] ...)}

    {:type  "array"
     :items ?item}
    ;;>
    [~(summarize-schema schema ?item depth)]

    {:type (m/pred string? ?type)}
    ;;>
    (m/app symbol ?type)

    {:$ref (m/pred string? ?ref)}
    ;;>
    ~(if (> depth 2)
       (symbol ?ref)
       (summarize-schema schema (get schema (keyword ?ref)) (inc depth)))))

(def extract-method
  "Given an api definition, and an api method definition,
  produces a defn form."
  (s/rewrite
    [{:baseUrl           ?base-url
      :schemas           ?schemas
      :documentationLink ?documentationLink
      :version           ?version}
     {:id          ?id
      :path        ?path
      :parameters  (m/seqable (m/or [!required-parameters {:required true}]
                                    [!optional-parameters {}]) ...)
      :description ?description
      :scopes      ?scopes
      :httpMethod  ?httpMethod
      :request     ?request}]
    ;;>
    (defn ~(symbol (method-name ?id))
      ~(str ?documentationLink "api/reference/rest/" ?version "/" (doc-path ?id)
            \newline \newline
            "Required parameters: " (if (seq !required-parameters)
                                      (str/join ", " (map name !required-parameters))
                                      "none")
            \newline \newline
            "Optional parameters: " (if (seq !optional-parameters)
                                      (str/join ", " (map name !optional-parameters))
                                      "none")
            \newline \newline
            (when (seq ?request)
              (str "Body: " \newline \newline
                   (with-out-str (pprint/pprint (summarize-schema ?schemas ?request 1)))
                   \newline))
            ?description)
      {:scopes ?scopes}
      ~(if ?request
         '[auth parameters body]
         '[auth parameters])
      {:pre [(util/has-keys? parameters ~(set !required-parameters))]}
      (util/get-response
        (~(symbol "http" (str/lower-case ?httpMethod))
          (util/get-url ?base-url ?path ~(set !required-parameters) parameters)
          (merge-with merge
                      {:throw-exceptions false
                       :query-params     parameters
                       :accept           :json
                       :as               :json
                       &                 ~(when ?request
                                            '{:content-type :json
                                              :body         (json/generate-string body)})}
                      auth))))
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))


(m/defsyntax rec [reference pattern]
  `(m/with [~reference ~pattern]
     ~reference))

(def extract-resource-methods
  "Given an api definition and a resource,
  discovers all the methods,
  and methods of sub-resources."
  (s/rewrite
    [?api (rec %resource {:methods   (m/seqable [_ !methods] ...)
                          :resources (m/seqable [_ %resource] ...)})]
    ;;>
    ((m/app extract-method [?api !methods]) ...)
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-ns
  "Takes an API description, resource-name, and resource.
  Returns a namespace form."
  (s/rewrite
    [{:as                ?api
      :name              ?api-name
      :title             ?title
      :description       ?description
      :documentationLink ?documentationLink
      :version           ?version
      :id                ?id}
     ?resource-name
     ?resource]
    ;;>
    [?resource-name
     ((ns ~(symbol (str out-ns \. ?api-name \. ?resource-name))
        ~(str ?title ": " ?resource-name "." \newline
              ?description \newline
              "See: " ?documentationLink "api/reference/rest/" ?version "/" ?resource-name)
        (:require
          [cheshire.core ~:as json]
          [clj-http.client ~:as http]
          [happy.util ~:as util]))
      & ~(extract-resource-methods [?api ?resource]))]
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))

(def build-nss
  "Takes an API definition and returns multiple namespace forms,
  one for each resource in the API."
  (s/rewrite
    {:resources {& (m/seqable [!resource-names !resources] ...)}
     :as        ?api}
    ;;>
    ((m/app build-ns [?api (m/app name !resource-names) !resources]) ...)
    ;;
    ?else ~(throw (ex-info "FAIL" {:input ?else}))))
