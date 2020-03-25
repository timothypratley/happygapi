(ns happygapi.dfareporting.dynamicTargetingKeys
  "DCM/DFA Reporting And Trafficking API: dynamicTargetingKeys.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dynamicTargetingKeys"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dynamicTargetingKeys/delete
  
  Required parameters: name, objectId, objectType, profileId
  
  Optional parameters: none
  
  Deletes an existing dynamic targeting key."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:name :objectId :objectType :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/dynamicTargetingKeys/{objectId}"
     #{:name :objectId :objectType :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dynamicTargetingKeys/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :name string, :objectId string, :objectType string}
  
  Inserts a new dynamic targeting key. Keys must be created at the advertiser level before being assigned to the advertiser's ads, creatives, or placements. There is a maximum of 1000 keys per advertiser, out of which a maximum of 20 keys can be assigned per ad, creative, or placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/dynamicTargetingKeys"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/dynamicTargetingKeys/list
  
  Required parameters: profileId
  
  Optional parameters: advertiserId, names, objectId, objectType
  
  Retrieves a list of dynamic targeting keys."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/dynamicTargetingKeys"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
