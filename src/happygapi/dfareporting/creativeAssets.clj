(ns happygapi.dfareporting.creativeAssets
  "DCM/DFA Reporting And Trafficking API: creativeAssets.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creativeAssets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creativeAssets/insert
  
  Required parameters: advertiserId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:counterCustomEvents [{:advertiserCustomEventName string,
                          :popupWindowProperties PopupWindowProperties,
                          :artworkType string,
                          :artworkLabel string,
                          :videoReportingId string,
                          :advertiserCustomEventId string,
                          :id string,
                          :targetType string,
                          :exitClickThroughUrl CreativeClickThroughUrl,
                          :advertiserCustomEventType string}],
   :richMedia boolean,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :timerCustomEvents [{:advertiserCustomEventName string,
                        :popupWindowProperties PopupWindowProperties,
                        :artworkType string,
                        :artworkLabel string,
                        :videoReportingId string,
                        :advertiserCustomEventId string,
                        :id string,
                        :targetType string,
                        :exitClickThroughUrl CreativeClickThroughUrl,
                        :advertiserCustomEventType string}],
   :detectedFeatures [string],
   :exitCustomEvents [{:advertiserCustomEventName string,
                       :popupWindowProperties PopupWindowProperties,
                       :artworkType string,
                       :artworkLabel string,
                       :videoReportingId string,
                       :advertiserCustomEventId string,
                       :id string,
                       :targetType string,
                       :exitClickThroughUrl CreativeClickThroughUrl,
                       :advertiserCustomEventType string}],
   :warnedValidationRules [string],
   :id string,
   :kind string,
   :clickTags [{:name string,
                :eventName string,
                :clickThroughUrl CreativeClickThroughUrl}],
   :assetIdentifier {:name string, :type string}}
  
  Inserts a new creative asset."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeAssets/{advertiserId}/creativeAssets"
     #{:advertiserId :profileId}
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
