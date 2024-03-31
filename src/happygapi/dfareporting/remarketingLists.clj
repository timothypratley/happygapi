(ns happygapi.dfareporting.remarketingLists
  "Campaign Manager 360 API: remarketingLists.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :lifeSpan string,
   :advertiserId string,
   :active boolean,
   :id string,
   :kind string,
   :listSize string,
   :subaccountId string,
   :accountId string}
  
  Updates an existing RemarketingList. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/remarketingLists"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one remarketing list by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/remarketingLists/{+id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/remarketingLists"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists/list
  
  Required parameters: advertiserId, profileId
  
  Optional parameters: name, pageToken, sortField, active, sortOrder, maxResults, floodlightActivityId
  
  Retrieves a list of remarketing lists, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/remarketingLists"
     #{:advertiserId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/remarketingLists/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :listSource string,
   :listPopulationRule {:floodlightActivityId string,
                        :floodlightActivityName string,
                        :listPopulationClauses [ListPopulationClause]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/remarketingLists"
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
