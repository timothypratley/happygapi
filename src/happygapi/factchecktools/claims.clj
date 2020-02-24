(ns happygapi.factchecktools.claims
  "Fact Check Tools API
  
  See: https://developers.google.com/fact-check/tools/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn search$
  "Required parameters: none
  
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
