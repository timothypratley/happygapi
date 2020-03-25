(ns happygapi.dfareporting.regions
  "DCM/DFA Reporting And Trafficking API: regions.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/regions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/regions/list
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Retrieves a list of regions."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/regions"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
