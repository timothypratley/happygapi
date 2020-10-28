(ns happygapi.cloudshell.users
  "Cloud Shell API: users.
  Allows users to start, configure, and connect to interactive shell sessions running in the cloud. 
  See: https://cloud.google.com/shell/docs/api/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn environments-get$
  "https://cloud.google.com/shell/docs/api/reference/rest/v1/users/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an environment. Returns NOT_FOUND if the environment does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudshell.googleapis.com/"
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

(defn environments-addPublicKey$
  "https://cloud.google.com/shell/docs/api/reference/rest/v1/users/environments/addPublicKey
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:key string}
  
  Adds a public SSH key to an environment, allowing clients with the corresponding private key to connect to that environment via SSH. If a key with the same content already exists, this will error with ALREADY_EXISTS."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudshell.googleapis.com/"
     "v1/{+environment}:addPublicKey"
     #{:environment}
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

(defn environments-start$
  "https://cloud.google.com/shell/docs/api/reference/rest/v1/users/environments/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:accessToken string, :publicKeys [string]}
  
  Starts an existing environment, allowing clients to connect to it. The returned operation will contain an instance of StartEnvironmentMetadata in its metadata field. Users can wait for the environment to start by polling this operation via GetOperation. Once the environment has finished starting and is ready to accept connections, the operation will contain a StartEnvironmentResponse in its response field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudshell.googleapis.com/"
     "v1/{+name}:start"
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

(defn environments-authorize$
  "https://cloud.google.com/shell/docs/api/reference/rest/v1/users/environments/authorize
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:idToken string, :accessToken string, :expireTime string}
  
  Sends OAuth credentials to a running environment on behalf of a user. When this completes, the environment will be authorized to run various Google Cloud command line tools without requiring the user to manually authenticate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudshell.googleapis.com/"
     "v1/{+name}:authorize"
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

(defn environments-removePublicKey$
  "https://cloud.google.com/shell/docs/api/reference/rest/v1/users/environments/removePublicKey
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:key string}
  
  Removes a public SSH key from an environment. Clients will no longer be able to connect to the environment using the corresponding private key. If a key with the same content is not present, this will error with NOT_FOUND."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudshell.googleapis.com/"
     "v1/{+environment}:removePublicKey"
     #{:environment}
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
