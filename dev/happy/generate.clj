(ns happy.generate
  "Writes to src/happygapi generated namespaces of function wrappers"
  (:require [happy.monkey :as monkey]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [fipp.clojure :as pprint]))

(def out-ns "happygapi")

(defn pprint-str [x]
  (with-out-str (pprint/pprint x)))

(defn ns-str [{:keys [documentationLink title description] :as api} resource-name methods]
  (str/replace
   (str
    (pprint-str
     (list 'ns (symbol (str out-ns \. (:name api) \. resource-name))
           (str title \newline
                description \newline
                "See: " documentationLink)
           '(:require
             [cheshire.core :as json]
             [clj-http.client :as http]
             [clojure.edn :as edn]
             [clojure.java.io :as io]
             [happy.util :as util]
             [json-schema.core :as json-schema])))
    \newline
    (pprint-str
     (list 'def 'schemas (list 'edn/read-string (list 'slurp (list 'io/resource (str (:name api) "_schema.edn"))))))
    \newline
    (str/join \newline (map pprint-str methods)))
   #"\\n"
   "\n  "))

(defn write-api-ns [api]
  (println "Writing" (:name api) (:version api))
  (spit (io/file "resources" (str (:name api) "_schema.edn"))
        (pprint-str (:schemas api)))
  (doseq [[k methods] (monkey/build-methods api)
          :let [dir (io/file "src" out-ns (:name api))
                resource-name (name k)]]
    (.mkdirs dir)
    (spit (io/file dir (str resource-name ".clj"))
          (ns-str api resource-name methods))))

#_(defonce sheets-api
  (monkey/fetch "https://sheets.googleapis.com/$discovery/rest?version=v4"))
#_(write-api-ns sheets-api)

(defn write-all []
  (doseq [api (monkey/fetch-all-apis)]
    (write-api-ns api)))

(defn -main [& args]
  (write-all))

#_(-main)
