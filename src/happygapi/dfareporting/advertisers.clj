(ns happygapi.dfareporting.advertisers
  "Campaign Manager 360 API: advertisers.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/advertisers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertisers/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one advertiser by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertisers/{+id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertisers/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
   :measurementPartnerLink {:measurementPartner string,
                            :linkStatus string,
                            :partnerAdvertiserId string},
   :clickThroughUrlSuffix string,
   :floodlightConfigurationId string,
   :name string,
   :advertiserGroupId string,
   :suspended boolean,
   :status string,
   :id string,
   :kind string,
   :defaultEmail string,
   :defaultClickThroughEventTagId string,
   :subaccountId string,
   :accountId string,
   :originalFloodlightConfigurationId string}
  
  Inserts a new advertiser."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertisers"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertisers/list
  
  Required parameters: profileId
  
  Optional parameters: includeAdvertisersWithoutGroupsOnly, floodlightConfigurationIds, ids, searchString, advertiserGroupIds, pageToken, sortField, status, sortOrder, onlyParent, subaccountId, maxResults
  
  Retrieves a list of advertisers, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertisers"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertisers/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
   :measurementPartnerLink {:measurementPartner string,
                            :linkStatus string,
                            :partnerAdvertiserId string},
   :clickThroughUrlSuffix string,
   :floodlightConfigurationId string,
   :name string,
   :advertiserGroupId string,
   :suspended boolean,
   :status string,
   :id string,
   :kind string,
   :defaultEmail string,
   :defaultClickThroughEventTagId string,
   :subaccountId string,
   :accountId string,
   :originalFloodlightConfigurationId string}
  
  Updates an existing advertiser."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertisers"
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertisers/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
   :measurementPartnerLink {:measurementPartner string,
                            :linkStatus string,
                            :partnerAdvertiserId string},
   :clickThroughUrlSuffix string,
   :floodlightConfigurationId string,
   :name string,
   :advertiserGroupId string,
   :suspended boolean,
   :status string,
   :id string,
   :kind string,
   :defaultEmail string,
   :defaultClickThroughEventTagId string,
   :subaccountId string,
   :accountId string,
   :originalFloodlightConfigurationId string}
  
  Updates an existing advertiser. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertisers"
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
