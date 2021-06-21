(ns happygapi.iam.projects
  "Identity and Access Management (IAM) API: projects.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls. 
  See: https://cloud.google.com/iam/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn roles-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the definition of a Role."
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
  
  {:name string,
   :includedPermissions [string],
   :description string,
   :etag string,
   :deleted boolean,
   :title string,
   :stage string}
  
  Updates the definition of a custom Role."
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

(defn roles-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/list
  
  Required parameters: parent
  
  Optional parameters: view, pageToken, showDeleted, pageSize
  
  Lists every predefined Role that IAM supports, or every custom role that is defined for an organization or project."
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
  
  {:role {:name string,
          :includedPermissions [string],
          :description string,
          :etag string,
          :deleted boolean,
          :title string,
          :stage string},
   :roleId string}
  
  Creates a new custom Role."
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

(defn roles-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
  Undeletes a custom Role."
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

(defn roles-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/roles/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a custom Role. When you delete a custom role, the following changes occur immediately: * You cannot bind a member to the custom role in an IAM Policy. * Existing bindings to the custom role are not changed, but they have no effect. * By default, the response from ListRoles does not include the custom role. You have 7 days to undelete the custom role. After 7 days, the following changes occur: * The custom role is permanently deleted and cannot be recovered. * If an IAM policy contains a binding to the custom role, the binding is permanently removed."
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

(defn serviceAccounts-disable$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disables a ServiceAccount immediately. If an application uses the service account to authenticate, that application can no longer call Google APIs or access Google Cloud resources. Existing access tokens for the service account are rejected, and requests for new access tokens will fail. To re-enable the service account, use EnableServiceAccount. After you re-enable the service account, its existing access tokens will be accepted, and you can request new access tokens. To help avoid unplanned outages, we recommend that you disable the service account before you delete it. Use this method to disable the service account, then wait at least 24 hours and watch for unintended consequences. If there are no unintended consequences, you can delete the service account with DeleteServiceAccount."
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
  
  {:updateMask string,
   :policy {:auditConfigs [AuditConfig],
            :version integer,
            :etag string,
            :bindings [Binding]}}
  
  Sets the IAM policy that is attached to a ServiceAccount. Use this method to grant or revoke access to the service account. For example, you could grant a member the ability to impersonate the service account. This method does not enable the service account to access other resources. To grant roles to a service account on a resource, follow these steps: 1. Call the resource's `getIamPolicy` method to get its current IAM policy. 2. Edit the policy so that it binds the service account to an IAM role for the resource. 3. Call the resource's `setIamPolicy` method to update its IAM policy. For detailed instructions, see [Granting roles to a service account for specific resources](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts)."
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
  
  Enables a ServiceAccount that was disabled by DisableServiceAccount. If the service account is already enabled, then this method has no effect. If the service account was disabled by other means—for example, if Google disabled the service account because it was compromised—you cannot use this method to enable the service account."
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
  
  {:updateMask string,
   :serviceAccount {:description string,
                    :oauth2ClientId string,
                    :email string,
                    :disabled boolean,
                    :displayName string,
                    :name string,
                    :etag string,
                    :uniqueId string,
                    :projectId string}}
  
  Patches a ServiceAccount."
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
  
  Tests whether the caller has the specified permissions on a ServiceAccount."
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
  
  Creates a ServiceAccount."
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
  
  **Note:** We are in the process of deprecating this method. Use PatchServiceAccount instead. Updates a ServiceAccount. You can update only the `display_name` and `description` fields."
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
  
  Deletes a ServiceAccount. **Warning:** After you delete a service account, you might not be able to undelete it. If you know that you need to re-enable the service account in the future, use DisableServiceAccount instead. If you delete a service account, IAM permanently removes the service account 30 days later. Google Cloud cannot recover the service account after it is permanently removed, even if you file a support request. To help avoid unplanned outages, we recommend that you disable the service account before you delete it. Use DisableServiceAccount to disable the service account, then wait at least 24 hours and watch for unintended consequences. If there are no unintended consequences, you can delete the service account."
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
  
  Gets the IAM policy that is attached to a ServiceAccount. This IAM policy specifies which members have access to the service account. This method does not tell you whether the service account has been granted any roles on other resources. To check whether a service account has role grants on a resource, use the `getIamPolicy` method for that resource. For example, to view the role grants for a project, call the Resource Manager API's [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy) method."
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
  
  Restores a deleted ServiceAccount. **Important:** It is not always possible to restore a deleted service account. Use this method only as a last resort. After you delete a service account, IAM permanently removes the service account 30 days later. There is no way to restore a deleted service account that has been permanently removed."
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
  
  Lists every ServiceAccount that belongs to a specific project."
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
  
  **Note:** This method is deprecated. Use the [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt) method in the IAM Service Account Credentials API instead. If you currently use this method, see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for instructions. Signs a JSON Web Token (JWT) using the system-managed private key for a ServiceAccount."
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
  
  **Note:** This method is deprecated. Use the [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob) method in the IAM Service Account Credentials API instead. If you currently use this method, see the [migration guide](https://cloud.google.com/iam/help/credentials/migrate-api) for instructions. Signs a blob using the system-managed private key for a ServiceAccount."
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

(defn serviceAccounts-keys-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServiceAccountKey. Deleting a service account key does not revoke short-lived credentials that have been issued based on the service account key."
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

(defn serviceAccounts-keys-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:keyAlgorithm string, :privateKeyType string}
  
  Creates a ServiceAccountKey."
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
  
  Creates a ServiceAccountKey, using a public key that you provide."
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

(defn serviceAccounts-keys-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/get
  
  Required parameters: name
  
  Optional parameters: publicKeyType
  
  Gets a ServiceAccountKey."
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

(defn serviceAccounts-keys-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/serviceAccounts/keys/list
  
  Required parameters: name
  
  Optional parameters: keyTypes
  
  Lists every ServiceAccountKey for a service account."
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

(defn locations-workloadIdentityPools-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/list
  
  Required parameters: parent
  
  Optional parameters: showDeleted, pageSize, pageToken
  
  Lists all non-deleted WorkloadIdentityPools in a project. If `show_deleted` is set to `true`, then deleted pools are also listed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/workloadIdentityPools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloadIdentityPools-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes a WorkloadIdentityPool, as long as it was deleted fewer than 30 days ago."
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

(defn locations-workloadIdentityPools-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a WorkloadIdentityPool. You cannot use a deleted pool to exchange external credentials for Google Cloud credentials. However, deletion does not revoke credentials that have already been issued. Credentials issued for a deleted pool do not grant access to resources. If the pool is undeleted, and the credentials are not expired, they grant access again. You can undelete a pool for 30 days. After 30 days, deletion is permanent. You cannot update deleted pools. However, you can view and list them."
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

(defn locations-workloadIdentityPools-patch$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:state string,
   :displayName string,
   :name string,
   :description string,
   :disabled boolean}
  
  Updates an existing WorkloadIdentityPool."
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

(defn locations-workloadIdentityPools-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/create
  
  Required parameters: parent
  
  Optional parameters: workloadIdentityPoolId
  
  Body: 
  
  {:state string,
   :displayName string,
   :name string,
   :description string,
   :disabled boolean}
  
  Creates a new WorkloadIdentityPool. You cannot reuse the name of a deleted pool until 30 days after deletion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/workloadIdentityPools"
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

(defn locations-workloadIdentityPools-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an individual WorkloadIdentityPool."
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

(defn locations-workloadIdentityPools-providers-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an individual WorkloadIdentityPoolProvider."
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

(defn locations-workloadIdentityPools-providers-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/list
  
  Required parameters: parent
  
  Optional parameters: showDeleted, pageSize, pageToken
  
  Lists all non-deleted WorkloadIdentityPoolProviders in a WorkloadIdentityPool. If `show_deleted` is set to `true`, then deleted providers are also listed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/providers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloadIdentityPools-providers-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/create
  
  Required parameters: parent
  
  Optional parameters: workloadIdentityPoolProviderId
  
  Body: 
  
  {:description string,
   :aws {:accountId string},
   :disabled boolean,
   :oidc {:allowedAudiences [string], :issuerUri string},
   :displayName string,
   :name string,
   :state string,
   :attributeCondition string,
   :attributeMapping {}}
  
  Creates a new WorkloadIdentityPoolProvider in a WorkloadIdentityPool. You cannot reuse the name of a deleted provider until 30 days after deletion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/providers"
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

(defn locations-workloadIdentityPools-providers-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a WorkloadIdentityPoolProvider. Deleting a provider does not revoke credentials that have already been issued; they continue to grant access. You can undelete a provider for 30 days. After 30 days, deletion is permanent. You cannot update deleted providers. However, you can view and list them."
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

(defn locations-workloadIdentityPools-providers-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes a WorkloadIdentityPoolProvider, as long as it was deleted fewer than 30 days ago."
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

(defn locations-workloadIdentityPools-providers-patch$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :aws {:accountId string},
   :disabled boolean,
   :oidc {:allowedAudiences [string], :issuerUri string},
   :displayName string,
   :name string,
   :state string,
   :attributeCondition string,
   :attributeMapping {}}
  
  Updates an existing WorkloadIdentityPoolProvider."
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

(defn locations-workloadIdentityPools-providers-operations-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/providers/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
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

(defn locations-workloadIdentityPools-operations-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/projects/locations/workloadIdentityPools/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
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
