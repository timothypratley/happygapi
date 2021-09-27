(ns happygapi.dfareporting.dimensionValues
  "Campaign Manager 360 API: dimensionValues.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/dimensionValues"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/dimensionValues/query
  
  Required parameters: profileId
  
  Optional parameters: pageToken, maxResults
  
  Body: 
  
  {:kind string,
   :startDate string,
   :endDate string,
   :dimensionName string,
   :filters [{:kind string, :dimensionName string, :value string}]}
  
  Retrieves list of report dimension values for a list of filters."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/dimensionvalues/query"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
