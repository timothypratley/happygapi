(ns happygapi.dfareporting.creativeFieldValues
  "Campaign Manager 360 API: creativeFieldValues.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/delete
  
  Required parameters: profileId, creativeFieldId, id
  
  Optional parameters: none
  
  Deletes an existing creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:id :creativeFieldId :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues/{+id}"
     #{:id :creativeFieldId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/get
  
  Required parameters: profileId, creativeFieldId, id
  
  Optional parameters: none
  
  Gets one creative field value by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:id :creativeFieldId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues/{+id}"
     #{:id :creativeFieldId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/insert
  
  Required parameters: profileId, creativeFieldId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :id string, :value string}
  
  Inserts a new creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeFieldId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues"
     #{:creativeFieldId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/list
  
  Required parameters: profileId, creativeFieldId
  
  Optional parameters: maxResults, searchString, ids, pageToken, sortField, sortOrder
  
  Retrieves a list of creative field values, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeFieldId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues"
     #{:creativeFieldId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/update
  
  Required parameters: profileId, creativeFieldId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :id string, :value string}
  
  Updates an existing creative field value."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeFieldId :profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues"
     #{:creativeFieldId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/creativeFieldValues/patch
  
  Required parameters: profileId, creativeFieldId, id
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :id string, :value string}
  
  Updates an existing creative field value. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:id :creativeFieldId :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/creativeFields/{+creativeFieldId}/creativeFieldValues"
     #{:id :creativeFieldId :profileId}
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
