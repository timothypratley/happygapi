(ns happygapi.iam.projects
  "Identity and Access Management (IAM) API
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "iam_schema.edn"))))

(defn serviceAccounts-disable$
  "Required parameters: name
  
  Optional parameters: none
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:disable"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-enable$
  "Required parameters: name
  
  Optional parameters: none
  
  EnableServiceAccount is currently in the alpha launch stage.
  
   Restores a disabled ServiceAccount
   that has been manually disabled by using DisableServiceAccount. Service
   accounts that have been disabled by other means or for other reasons,
   such as abuse, cannot be restored using this method.
  
   EnableServiceAccount will have no effect on a service account that is
   not disabled.  Enabling an already enabled service account will have no
   effect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:enable"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Patches a ServiceAccount.
  
  Currently, only the following fields are updatable:
  `display_name` and `description`.
  
  Only fields specified in the request are guaranteed to be returned in
  the response. Other fields in the response may be empty.
  
  Note: The field mask is required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Tests the specified permissions against the IAM access control policy
  for a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-create$
  "Required parameters: name
  
  Optional parameters: none
  
  Creates a ServiceAccount
  and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/serviceAccounts"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Note: This method is in the process of being deprecated. Use
  PatchServiceAccount instead.
  
  Updates a ServiceAccount.
  
  Currently, only the following fields are updatable:
  `display_name` and `description`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServiceAccount."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-getIamPolicy$
  "Required parameters: resource
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-undelete$
  "Required parameters: name
  
  Optional parameters: none
  
  Restores a deleted ServiceAccount.
  This is to be used as an action of last resort.  A service account may
  not always be restorable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-list$
  "Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Lists ServiceAccounts for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/serviceAccounts"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-signJwt$
  "Required parameters: name
  
  Optional parameters: none
  
  **Note**: This method is in the process of being deprecated. Call the
  [`signJwt()`](/iam/credentials/reference/rest/v1/projects.serviceAccounts/signJwt)
  method of the Cloud IAM Service Account Credentials API instead.
  
  Signs a JWT using a service account's system-managed private key.
  
  If no expiry time (`exp`) is provided in the `SignJwtRequest`, IAM sets an
  an expiry time of one hour by default. If you request an expiry time of
  more than one hour, the request will fail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:signJwt"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-signBlob$
  "Required parameters: name
  
  Optional parameters: none
  
  **Note**: This method is in the process of being deprecated. Call the
  [`signBlob()`](/iam/credentials/reference/rest/v1/projects.serviceAccounts/signBlob)
  method of the Cloud IAM Service Account Credentials API instead.
  
  Signs a blob using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:signBlob"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-keys-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServiceAccountKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-keys-list$
  "Required parameters: name
  
  Optional parameters: keyTypes
  
  Lists ServiceAccountKeys."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-keys-get$
  "Required parameters: name
  
  Optional parameters: publicKeyType
  
  Gets the ServiceAccountKey
  by key id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccounts-keys-create$
  "Required parameters: name
  
  Optional parameters: none
  
  Creates a ServiceAccountKey
  and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn serviceAccounts-keys-upload$
  "Required parameters: name
  
  Optional parameters: none
  
  Upload public key for a given service account.
  This rpc will create a
  ServiceAccountKey that has the
  provided public key and returns it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}/keys:upload"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn roles-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new Role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn roles-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-undelete$
  "Required parameters: name
  
  Optional parameters: none
  
  Undelete a Role, bringing it back in its previous state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn roles-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-delete$
  "Required parameters: name
  
  Optional parameters: etag
  
  Soft deletes a role. The role is suspended and cannot be used to create new
  IAM Policy Bindings.
  The Role will not be included in `ListRoles()` unless `show_deleted` is set
  in the `ListRolesRequest`. The Role contains the deleted boolean set.
  Existing Bindings remains, but are inactive. The Role can be undeleted
  within 7 days. After 7 days the Role is deleted and all Bindings associated
  with the role are removed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn roles-list$
  "Required parameters: parent
  
  Optional parameters: showDeleted, pageToken, pageSize, view
  
  Lists the Roles defined on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
