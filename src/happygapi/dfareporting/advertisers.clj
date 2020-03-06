(ns happygapi.dfareporting.advertisers
  "DCM/DFA Reporting And Trafficking API: advertisers.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one advertiser by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertisers/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertisers"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers/list
  
  Required parameters: profileId
  
  Optional parameters: includeAdvertisersWithoutGroupsOnly, floodlightConfigurationIds, ids, searchString, advertiserGroupIds, pageToken, sortField, status, sortOrder, onlyParent, subaccountId, maxResults
  Retrieves a list of advertisers, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertisers"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertisers"
     #{:id :profileId}
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertisers/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :floodlightConfigurationIdDimensionValue {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertisers"
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
