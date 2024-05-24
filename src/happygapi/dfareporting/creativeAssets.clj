(ns happygapi.dfareporting.creativeAssets
  "Campaign Manager 360 API: creativeAssets.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/creativeAssets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeAssets/insert
  
  Required parameters: profileId, advertiserId
  
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
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
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
   :assetIdentifier {:type string, :name string}}
  
  Inserts a new creative asset."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeAssets/{+advertiserId}/creativeAssets"
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
