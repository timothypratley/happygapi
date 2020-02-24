(ns happygapi.kgsearch.entities
  "Knowledge Graph Search API
  Searches the Google Knowledge Graph for entities.
  See: https://developers.google.com/knowledge-graph/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn search$
  "Required parameters: none
  
  Searches Knowledge Graph for entities that match the constraints.
  A list of matched entities will be returned in response, which will be in
  JSON-LD format and compatible with http://schema.org"
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
