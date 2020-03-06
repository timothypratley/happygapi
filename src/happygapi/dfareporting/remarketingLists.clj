(ns happygapi.dfareporting.remarketingLists
  "DCM/DFA Reporting And Trafficking API: remarketingLists.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one remarketing list by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingLists/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :lifeSpan string,
   :advertiserId string,
   :active boolean,
   :id string,
   :kind string,
   :listSize string,
   :subaccountId string,
   :accountId string}
  
  Inserts a new remarketing list."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingLists"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists/list
  
  Required parameters: advertiserId, profileId
  
  Optional parameters: name, pageToken, sortField, active, sortOrder, maxResults, floodlightActivityId
  Retrieves a list of remarketing lists, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:advertiserId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingLists"
     #{:advertiserId :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :lifeSpan string,
   :advertiserId string,
   :active boolean,
   :id string,
   :kind string,
   :listSize string,
   :subaccountId string,
   :accountId string}
  
  Updates an existing remarketing list. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingLists"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/remarketingLists/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :lifeSpan string,
   :advertiserId string,
   :active boolean,
   :id string,
   :kind string,
   :listSize string,
   :subaccountId string,
   :accountId string}
  
  Updates an existing remarketing list."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/remarketingLists"
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
