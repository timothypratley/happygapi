(ns happygapi.dfareporting.conversions
  "Campaign Manager 360 API: conversions.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/conversions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchinsert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/conversions/batchinsert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :conversions [{:encryptedUserId string,
                  :childDirectedTreatment boolean,
                  :adUserDataConsent string,
                  :treatmentForUnderage boolean,
                  :floodlightConfigurationId string,
                  :nonPersonalizedAd boolean,
                  :dclid string,
                  :value number,
                  :ordinal string,
                  :encryptedUserIdCandidates [string],
                  :impressionId string,
                  :kind string,
                  :timestampMicros string,
                  :mobileDeviceId string,
                  :limitAdTracking boolean,
                  :userIdentifiers [UserIdentifier],
                  :matchId string,
                  :customVariables [CustomFloodlightVariable],
                  :quantity string,
                  :gclid string,
                  :floodlightActivityId string}],
   :encryptionInfo {:encryptionEntityType string,
                    :encryptionEntityId string,
                    :encryptionSource string,
                    :kind string}}
  
  Inserts conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{profileId}/conversions/batchinsert"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/conversions/batchupdate
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :conversions [{:encryptedUserId string,
                  :childDirectedTreatment boolean,
                  :adUserDataConsent string,
                  :treatmentForUnderage boolean,
                  :floodlightConfigurationId string,
                  :nonPersonalizedAd boolean,
                  :dclid string,
                  :value number,
                  :ordinal string,
                  :encryptedUserIdCandidates [string],
                  :impressionId string,
                  :kind string,
                  :timestampMicros string,
                  :mobileDeviceId string,
                  :limitAdTracking boolean,
                  :userIdentifiers [UserIdentifier],
                  :matchId string,
                  :customVariables [CustomFloodlightVariable],
                  :quantity string,
                  :gclid string,
                  :floodlightActivityId string}],
   :encryptionInfo {:encryptionEntityType string,
                    :encryptionEntityId string,
                    :encryptionSource string,
                    :kind string}}
  
  Updates existing conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{profileId}/conversions/batchupdate"
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
