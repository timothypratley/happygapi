(ns happygapi.androidpublisher.users
  "Google Play Android Developer API: users.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/users/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :email string,
   :accessState string,
   :expirationTime string,
   :partial boolean,
   :developerAccountPermissions [string],
   :grants [{:name string,
             :packageName string,
             :appLevelPermissions [string]}]}
  
  Grant access for a user to the given developer account."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+parent}/users"
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

(defn list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/users/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all users with access to a developer account."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+parent}/users"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/users/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :email string,
   :accessState string,
   :expirationTime string,
   :partial boolean,
   :developerAccountPermissions [string],
   :grants [{:name string,
             :packageName string,
             :appLevelPermissions [string]}]}
  
  Updates access for the user to the developer account."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+name}"
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

(defn delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/users/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes all access for the user to the given developer account."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
