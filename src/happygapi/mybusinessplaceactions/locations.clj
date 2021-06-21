(ns happygapi.mybusinessplaceactions.locations
  "My Business Place Actions API: locations.
  The My Business Place Actions API provides an interface for managing place action links of a location on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn placeActionLinks-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/placeActionLinks/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the place action links for the specified location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/{+parent}/placeActionLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn placeActionLinks-get$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/placeActionLinks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified place action link."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn placeActionLinks-patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/placeActionLinks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :name string,
   :createTime string,
   :isEditable boolean,
   :uri string,
   :providerType string,
   :isPreferred boolean,
   :placeActionType string}
  
  Updates the specified place action link and returns it."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn placeActionLinks-delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/placeActionLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a place action link from the specified location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn placeActionLinks-create$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/placeActionLinks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateTime string,
   :name string,
   :createTime string,
   :isEditable boolean,
   :uri string,
   :providerType string,
   :isPreferred boolean,
   :placeActionType string}
  
  Creates a place action link associated with the specified location, and returns it. The request is considered duplicate if the `parent`, `place_action_link.uri` and `place_action_link.place_action_type` are the same as a previous request."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/{+parent}/placeActionLinks"
     #{:parent}
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
