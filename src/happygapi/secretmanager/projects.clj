(ns happygapi.secretmanager.projects
  "Secret Manager API: projects.
  Stores API keys, passwords, certificates, and other sensitive data. Provides convenience while improving security.
  
  See: https://cloud.google.com/secret-manager/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
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

(defn secrets-get$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metadata for a given Secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
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

(defn secrets-setIamPolicy$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on the specified secret. Replaces any
  existing policy.
  
  Permissions on SecretVersions are enforced according
  to the policy set on the associated Secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn secrets-patch$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :replication {:automatic Automatic, :userManaged UserManaged},
   :createTime string,
   :labels {}}
  
  Updates metadata of an existing Secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://secretmanager.googleapis.com/"
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

(defn secrets-testIamPermissions$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has for the specified secret.
  If the secret does not exist, this call returns an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn secrets-create$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/create
  
  Required parameters: parent
  
  Optional parameters: secretId
  
  Body: 
  
  {:name string,
   :replication {:automatic Automatic, :userManaged UserManaged},
   :createTime string,
   :labels {}}
  
  Creates a new Secret containing no SecretVersions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+parent}/secrets"
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

(defn secrets-addVersion$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/addVersion
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:payload {:data string}}
  
  Creates a new SecretVersion containing secret data and attaches
  it to an existing Secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+parent}:addVersion"
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

(defn secrets-delete$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://secretmanager.googleapis.com/"
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

(defn secrets-getIamPolicy$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a secret.
  Returns empty policy if the secret exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn secrets-list$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists Secrets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+parent}/secrets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn secrets-versions-enable$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/enable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enables a SecretVersion.
  
  Sets the state of the SecretVersion to
  ENABLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+name}:enable"
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

(defn secrets-versions-list$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists SecretVersions. This call does not return secret
  data."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn secrets-versions-destroy$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/destroy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Destroys a SecretVersion.
  
  Sets the state of the SecretVersion to
  DESTROYED and irrevocably destroys the
  secret data."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+name}:destroy"
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

(defn secrets-versions-disable$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disables a SecretVersion.
  
  Sets the state of the SecretVersion to
  DISABLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+name}:disable"
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

(defn secrets-versions-get$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metadata for a SecretVersion.
  
  `projects/*/secrets/*/versions/latest` is an alias to the `latest`
  SecretVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
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

(defn secrets-versions-access$
  "https://cloud.google.com/secret-manager/api/reference/rest/v1/projects/secrets/versions/access
  
  Required parameters: name
  
  Optional parameters: none
  
  Accesses a SecretVersion. This call returns the secret data.
  
  `projects/*/secrets/*/versions/latest` is an alias to the `latest`
  SecretVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://secretmanager.googleapis.com/"
     "v1/{+name}:access"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
