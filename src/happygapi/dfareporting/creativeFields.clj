(ns happygapi.dfareporting.creativeFields
  "Campaign Manager 360 API: creativeFields.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one creative field by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:subaccountId string,
   :id string,
   :name string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :accountId string,
   :kind string,
   :advertiserId string}
  
  Updates an existing creative field. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/list
  
  Required parameters: profileId
  
  Optional parameters: searchString, sortField, pageToken, maxResults, advertiserIds, ids, sortOrder
  
  Retrieves a list of creative fields, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/delete
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Deletes an existing creative field."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:subaccountId string,
   :id string,
   :name string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :accountId string,
   :kind string,
   :advertiserId string}
  
  Updates an existing creative field."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/creativeFields/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:subaccountId string,
   :id string,
   :name string,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :accountId string,
   :kind string,
   :advertiserId string}
  
  Inserts a new creative field."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/creativeFields"
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
