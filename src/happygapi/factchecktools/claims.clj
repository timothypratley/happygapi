(ns happygapi.factchecktools.claims
  "Fact Check Tools API: claims.
  
  See: https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/claims"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/claims/search
  
  Required parameters: none
  
  Optional parameters: maxAgeDays, offset, pageToken, reviewPublisherSiteFilter, pageSize, query, languageCode
  Search through fact-checked claims."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
