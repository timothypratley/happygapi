(ns happygapi.dfareporting.creativeGroups
  "Campaign Manager 360 API: creativeGroups.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one creative group by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeGroups/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :name string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :id string,
   :subaccountId string,
   :groupNumber integer,
   :kind string,
   :accountId string}
  
  Updates an existing creative group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups/list
  
  Required parameters: profileId
  
  Optional parameters: groupNumber, ids, searchString, pageToken, sortField, advertiserIds, sortOrder, maxResults
  
  Retrieves a list of creative groups, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeGroups"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :name string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :id string,
   :subaccountId string,
   :groupNumber integer,
   :kind string,
   :accountId string}
  
  Inserts a new creative group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeGroups/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :name string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :id string,
   :subaccountId string,
   :groupNumber integer,
   :kind string,
   :accountId string}
  
  Updates an existing creative group. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeGroups"
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
