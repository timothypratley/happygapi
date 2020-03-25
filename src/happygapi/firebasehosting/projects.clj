(ns happygapi.firebasehosting.projects
  "Firebase Hosting API: projects.
  The Firebase Hosting REST API enables programmatic and customizable deployments to your Firebase-hosted sites. Use this REST API to deploy new or updated hosting configurations and content files.
  See: https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn operations-get$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-releases-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects/sites/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the releases that have been created on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-releases-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects/sites/releases/create
  
  Required parameters: parent
  
  Optional parameters: versionName
  
  Body: 
  
  {:message string,
   :releaseUser {:imageUrl string, :email string},
   :releaseTime string,
   :name string,
   :type string,
   :version {:labels {},
             :deleteTime string,
             :deleteUser ActingUser,
             :fileCount string,
             :config ServingConfig,
             :name string,
             :createTime string,
             :preview PreviewConfig,
             :status string,
             :createUser ActingUser,
             :versionBytes string,
             :finalizeTime string,
             :finalizeUser ActingUser}}
  
  Creates a new release which makes the content of the specified version
  actively display on the appropriate URL(s)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
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

(defn sites-channels-releases-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects/sites/channels/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the releases that have been created on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-channels-releases-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/projects/sites/channels/releases/create
  
  Required parameters: parent
  
  Optional parameters: versionName
  
  Body: 
  
  {:message string,
   :releaseUser {:imageUrl string, :email string},
   :releaseTime string,
   :name string,
   :type string,
   :version {:labels {},
             :deleteTime string,
             :deleteUser ActingUser,
             :fileCount string,
             :config ServingConfig,
             :name string,
             :createTime string,
             :preview PreviewConfig,
             :status string,
             :createUser ActingUser,
             :versionBytes string,
             :finalizeTime string,
             :finalizeUser ActingUser}}
  
  Creates a new release which makes the content of the specified version
  actively display on the appropriate URL(s)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
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
