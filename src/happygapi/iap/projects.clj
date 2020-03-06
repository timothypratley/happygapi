(ns happygapi.iap.projects
  "Cloud Identity-Aware Proxy API: projects.
  Controls access to cloud applications running on Google Cloud Platform.
  See: https://cloud.google.com/iapapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn brands-list$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/list
  
  Required parameters: parent
  
  Optional parameters: none
  Lists the existing brands for the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+parent}/brands"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn brands-get$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves the OAuth brand of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn brands-create$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:orgInternalOnly boolean,
   :name string,
   :applicationTitle string,
   :supportEmail string}
  
  Constructs a new OAuth brand for the project if one does not exist.
  The created brand is \"internal only\", meaning that OAuth clients created
  under it only accept requests from users who belong to the same G Suite
  organization as the project. The brand is created in an un-reviewed status.
  NOTE: The \"internal only\" status can be manually changed in the Google
  Cloud console. Requires that a brand does not already exist for the
  project, and that the specified support email is owned by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+parent}/brands"
     #{:parent}
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

(defn brands-identityAwareProxyClients-create$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/identityAwareProxyClients/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :secret string, :displayName string}
  
  Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned
  by IAP. Requires that the brand for the project exists and that it is
  set for internal-only use."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+parent}/identityAwareProxyClients"
     #{:parent}
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

(defn brands-identityAwareProxyClients-resetSecret$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/identityAwareProxyClients/resetSecret
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the
  secret was compromised. Requires that the client is owned by IAP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}:resetSecret"
     #{:name}
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

(defn brands-identityAwareProxyClients-delete$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/identityAwareProxyClients/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing
  obsolete clients, managing the number of clients in a given project, and
  cleaning up after tests. Requires that the client is owned by IAP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn brands-identityAwareProxyClients-list$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/identityAwareProxyClients/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists the existing clients for the brand."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+parent}/identityAwareProxyClients"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn brands-identityAwareProxyClients-get$
  "https://cloud.google.com/iapapi/reference/rest/v1/projects/brands/identityAwareProxyClients/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves an Identity Aware Proxy (IAP) OAuth client.
  Requires that the client is owned by IAP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
