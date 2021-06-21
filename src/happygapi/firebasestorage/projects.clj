(ns happygapi.firebasestorage.projects
  "Cloud Storage for Firebase API: projects.
  The Cloud Storage for Firebase API enables programmatic management of Cloud Storage buckets for use in Firebase projects
  See: https://firebase.google.com/docs/storageapi/reference/rest/v1beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn buckets-list$
  "https://firebase.google.com/docs/storageapi/reference/rest/v1beta/projects/buckets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the linked storage buckets for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasestorage.googleapis.com/"
     "v1beta/{+parent}/buckets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-get$
  "https://firebase.google.com/docs/storageapi/reference/rest/v1beta/projects/buckets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single linked storage bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasestorage.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-addFirebase$
  "https://firebase.google.com/docs/storageapi/reference/rest/v1beta/projects/buckets/addFirebase
  
  Required parameters: bucket
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Links a Google Cloud Storage bucket to a Firebase project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasestorage.googleapis.com/"
     "v1beta/{+bucket}:addFirebase"
     #{:bucket}
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

(defn buckets-removeFirebase$
  "https://firebase.google.com/docs/storageapi/reference/rest/v1beta/projects/buckets/removeFirebase
  
  Required parameters: bucket
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Unlinks a linked Google Cloud Storage bucket from a Firebase project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasestorage.googleapis.com/"
     "v1beta/{+bucket}:removeFirebase"
     #{:bucket}
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
