(ns happygapi.factchecktools.claims
  "Fact Check Tools API
  
  See: https://developers.google.com/fact-check/tools/api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "factchecktools_schema.edn"))))

(defn search$
  "Required parameters: none
  
  Optional parameters: maxAgeDays, offset, pageToken, reviewPublisherSiteFilter, pageSize, query, languageCode
  
  Search through fact-checked claims."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/claims:search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
