(ns happygapi.dfareporting.customEvents
  "DCM/DFA Reporting And Trafficking API: customEvents.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/customEvents"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchinsert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/customEvents/batchinsert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:customEvents [{:eventType string,
                   :floodlightConfigurationId string,
                   :annotateImpressionEvent CustomEventImpressionAnnotation,
                   :ordinal string,
                   :annotateClickEvent CustomEventClickAnnotation,
                   :kind string,
                   :insertEvent CustomEventInsert,
                   :timestampMicros string,
                   :customVariables [CustomVariable]}],
   :kind string}
  
  Inserts custom events."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/customEvents/batchinsert"
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
