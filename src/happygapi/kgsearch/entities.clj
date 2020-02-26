(ns happygapi.kgsearch.entities
  "Knowledge Graph Search API
  Searches the Google Knowledge Graph for entities.
  See: https://developers.google.com/knowledge-graph/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "kgsearch_schema.edn"))))

(defn search$
  "Required parameters: none
  
  Optional parameters: types, indent, languages, ids, limit, prefix, query
  
  Searches Knowledge Graph for entities that match the constraints.
  A list of matched entities will be returned in response, which will be in
  JSON-LD format and compatible with http://schema.org"
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kgsearch.googleapis.com/"
     "v1/entities:search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
