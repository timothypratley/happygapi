(ns happygapi.dfareporting.conversions
  "DCM/DFA Reporting And Trafficking API: conversions.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/conversions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchinsert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/conversions/batchinsert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
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
                  :floodlightActivityId string}],
   :encryptionInfo {:encryptionEntityType string,
                    :kind string,
                    :encryptionEntityId string,
                    :encryptionSource string}}
  
  Inserts conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/conversions/batchupdate
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
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
                  :floodlightActivityId string}],
   :encryptionInfo {:encryptionEntityType string,
                    :kind string,
                    :encryptionEntityId string,
                    :encryptionSource string}}
  
  Updates existing conversions."
  {:scopes ["https://www.googleapis.com/auth/ddmconversions"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
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
