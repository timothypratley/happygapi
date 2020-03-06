(ns happygapi.dfareporting.dimensionValues
  "DCM/DFA Reporting And Trafficking API: dimensionValues.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dimensionValues"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dimensionValues/query
  
  Required parameters: profileId
  
  Optional parameters: maxResults, pageToken
  
  Body: 
  
  {:dimensionName string,
   :endDate string,
   :filters [{:dimensionName string, :kind string, :value string}],
   :kind string,
   :startDate string}
  
  Retrieves list of report dimension values for a list of filters."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/dimensionvalues/query"
     #{:profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
