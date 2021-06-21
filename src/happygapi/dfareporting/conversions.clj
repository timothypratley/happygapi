(ns happygapi.dfareporting.conversions
  "Campaign Manager 360 API: conversions.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/conversions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchinsert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/conversions/batchinsert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :encryptionInfo {:kind string,
                    :encryptionEntityId string,
                    :encryptionEntityType string,
                    :encryptionSource string},
   :conversions [{:encryptedUserId string,
                  :childDirectedTreatment boolean,
                  :treatmentForUnderage boolean,
                  :floodlightConfigurationId string,
                  :nonPersonalizedAd boolean,
                  :dclid string,
                  :value number,
                  :ordinal string,
                  :encryptedUserIdCandidates [string],
                  :kind string,
                  :timestampMicros string,
                  :mobileDeviceId string,
                  :limitAdTracking boolean,
                  :matchId string,
                  :customVariables [CustomFloodlightVariable],
                  :quantity string,
                  :gclid string,
                  :floodlightActivityId string}]}
  
  Inserts conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/conversions/batchinsert"
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

(defn batchupdate$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/conversions/batchupdate
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :encryptionInfo {:kind string,
                    :encryptionEntityId string,
                    :encryptionEntityType string,
                    :encryptionSource string},
   :conversions [{:encryptedUserId string,
                  :childDirectedTreatment boolean,
                  :treatmentForUnderage boolean,
                  :floodlightConfigurationId string,
                  :nonPersonalizedAd boolean,
                  :dclid string,
                  :value number,
                  :ordinal string,
                  :encryptedUserIdCandidates [string],
                  :kind string,
                  :timestampMicros string,
                  :mobileDeviceId string,
                  :limitAdTracking boolean,
                  :matchId string,
                  :customVariables [CustomFloodlightVariable],
                  :quantity string,
                  :gclid string,
                  :floodlightActivityId string}]}
  
  Updates existing conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/conversions/batchupdate"
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
