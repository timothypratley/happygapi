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
  
  {:customEvents [{:annotateClickEvent CustomEventClickAnnotation,
                   :customVariables [CustomVariable],
                   :eventType string,
                   :floodlightConfigurationId string,
                   :insertEvent CustomEventInsert,
                   :kind string,
                   :ordinal string,
                   :timestampMicros string}],
   :kind string}
  
  Inserts custom events."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/customEvents/batchinsert"
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
