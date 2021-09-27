(ns happygapi.dfareporting.floodlightActivityGroups
  "Campaign Manager 360 API: floodlightActivityGroups.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one floodlight activity group by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivityGroups/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :floodlightConfigurationIdDimensionValue {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :type string,
   :advertiserId string,
   :id string,
   :kind string,
   :subaccountId string,
   :accountId string}
  
  Updates an existing floodlight activity group. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivityGroups"
     #{:id :profileId}
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :floodlightConfigurationIdDimensionValue {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :type string,
   :advertiserId string,
   :id string,
   :kind string,
   :subaccountId string,
   :accountId string}
  
  Updates an existing floodlight activity group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivityGroups"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:tagString string,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :floodlightConfigurationIdDimensionValue {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
   :floodlightConfigurationId string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :type string,
   :advertiserId string,
   :id string,
   :kind string,
   :subaccountId string,
   :accountId string}
  
  Inserts a new floodlight activity group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivityGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightActivityGroups/list
  
  Required parameters: profileId
  
  Optional parameters: floodlightConfigurationId, ids, type, searchString, pageToken, sortField, advertiserId, sortOrder, maxResults
  
  Retrieves a list of floodlight activity groups, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightActivityGroups"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
