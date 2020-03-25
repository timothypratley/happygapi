(ns happygapi.iam.projects
  "Identity and Access Management (IAM) API: projects.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn serviceAccounts-disable$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  DisableServiceAccount is currently in the alpha launch stage.
  
  Disables a ServiceAccount,
  which immediately prevents the service account from authenticating and
  gaining access to APIs.
  
  Disabled service accounts can be safely restored by using
  EnableServiceAccount at any point. Deleted service accounts cannot be
  restored using this method.
  
  Disabling a service account that is bound to VMs, Apps, Functions, or
  other jobs will cause those jobs to lose access to resources if they are
  using the disabled service account.
  
  To improve reliability of your services and avoid unexpected outages, it
  is recommended to first disable a service account rather than delete it.
  After disabling the service account, wait at least 24 hours to verify there
  are no unintended consequences, and then delete the service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-setIamPolicy$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the Cloud IAM access control policy for a
  ServiceAccount.
  
  Note: Service accounts are both
  [resources and
  identities](/iam/docs/service-accounts#service_account_permissions). This
  method treats the service account as a resource. Use it to grant members
  access to the service account, such as when they need to impersonate it.
  
  This method does not grant the service account access to other resources,
  such as projects. To grant a service account access to resources, include
  the service account in the Cloud IAM policy for the desired resource, then
  call the appropriate `setIamPolicy` method on the target resource. For
  example, to grant a service account access to a project, call the
  [projects.setIamPolicy](/resource-manager/reference/rest/v1/projects/setIamPolicy)
  method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-enable$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/enable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  EnableServiceAccount is currently in the alpha launch stage.
  
   Restores a disabled ServiceAccount
   that has been manually disabled by using DisableServiceAccount. Service
   accounts that have been disabled by other means or for other reasons,
   such as abuse, cannot be restored using this method.
  
   EnableServiceAccount will have no effect on a service account that is
   not disabled.  Enabling an already enabled service account will have no
   effect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-patch$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount {:description string,
                    :oauth2ClientId string,
                    :email string,
                    :disabled boolean,
                    :displayName string,
                    :name string,
                    :etag string,
                    :uniqueId string,
                    :projectId string},
   :updateMask string}
  
  Patches a ServiceAccount.
  
  Currently, only the following fields are updatable:
  `display_name` and `description`.
  
  Only fields specified in the request are guaranteed to be returned in
  the response. Other fields in the response may be empty.
  
  Note: The field mask is required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-testIamPermissions$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests the specified permissions against the IAM access control policy
  for a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :serviceAccount {:description string,
                    :oauth2ClientId string,
                    :email string,
                    :disabled boolean,
                    :displayName string,
                    :name string,
                    :etag string,
                    :uniqueId string,
                    :projectId string}}
  
  Creates a ServiceAccount
  and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/serviceAccounts"
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

(defn serviceAccounts-update$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :oauth2ClientId string,
   :email string,
   :disabled boolean,
   :displayName string,
   :name string,
   :etag string,
   :uniqueId string,
   :projectId string}
  
  Note: This method is in the process of being deprecated. Use
  PatchServiceAccount instead.
  
  Updates a ServiceAccount.
  
  Currently, only the following fields are updatable:
  `display_name` and `description`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-getIamPolicy$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Returns the Cloud IAM access control policy for a
  ServiceAccount.
  
  Note: Service accounts are both
  [resources and
  identities](/iam/docs/service-accounts#service_account_permissions). This
  method treats the service account as a resource. It returns the Cloud IAM
  policy that reflects what members have access to the service account.
  
  This method does not return what resources the service account has access
  to. To see if a service account has access to a resource, call the
  `getIamPolicy` method on the target resource. For example, to view grants
  for a project, call the
  [projects.getIamPolicy](/resource-manager/reference/rest/v1/projects/getIamPolicy)
  method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restores a deleted ServiceAccount.
  This is to be used as an action of last resort.  A service account may
  not always be restorable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn serviceAccounts-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
  Lists ServiceAccounts for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/serviceAccounts"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-signJwt$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/signJwt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:payload string}
  
  **Note**: This method is in the process of being deprecated. Call the
  [`signJwt()`](/iam/credentials/reference/rest/v1/projects.serviceAccounts/signJwt)
  method of the Cloud IAM Service Account Credentials API instead.
  
  Signs a JWT using a service account's system-managed private key.
  
  If no expiry time (`exp`) is provided in the `SignJwtRequest`, IAM sets an
  an expiry time of one hour by default. If you request an expiry time of
  more than one hour, the request will fail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:signJwt"
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

(defn serviceAccounts-signBlob$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/signBlob
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:bytesToSign string}
  
  **Note**: This method is in the process of being deprecated. Call the
  [`signBlob()`](/iam/credentials/reference/rest/v1/projects.serviceAccounts/signBlob)
  method of the Cloud IAM Service Account Credentials API instead.
  
  Signs a blob using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:signBlob"
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

(defn serviceAccounts-keys-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:keyAlgorithm string, :privateKeyType string}
  
  Creates a ServiceAccountKey
  and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys"
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

(defn serviceAccounts-keys-upload$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/upload
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:publicKeyData string}
  
  Upload public key for a given service account.
  This rpc will create a
  ServiceAccountKey that has the
  provided public key and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys:upload"
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

(defn serviceAccounts-keys-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServiceAccountKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn serviceAccounts-keys-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/list
  
  Required parameters: name
  
  Optional parameters: keyTypes
  
  Lists ServiceAccountKeys."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-keys-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/get
  
  Required parameters: name
  
  Optional parameters: publicKeyType
  
  Gets the ServiceAccountKey
  by key id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-patch$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:title string,
   :includedPermissions [string],
   :description string,
   :etag string,
   :stage string,
   :name string,
   :deleted boolean}
  
  Updates a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
  Undelete a Role, bringing it back in its previous state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn roles-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Soft deletes a role. The role is suspended and cannot be used to create new
  IAM Policy Bindings.
  The Role will not be included in `ListRoles()` unless `show_deleted` is set
  in the `ListRolesRequest`. The Role contains the deleted boolean set.
  Existing Bindings remains, but are inactive. The Role can be undeleted
  within 7 days. After 7 days the Role is deleted and all Bindings associated
  with the role are removed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view, showDeleted
  
  Lists the Roles defined on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn roles-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:roleId string,
   :role {:title string,
          :includedPermissions [string],
          :description string,
          :etag string,
          :stage string,
          :name string,
          :deleted boolean}}
  
  Creates a new Role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
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
