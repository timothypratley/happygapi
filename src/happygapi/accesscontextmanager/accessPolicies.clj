(ns happygapi.accesscontextmanager.accessPolicies
  "Access Context Manager API: accessPolicies.
  An API for setting attribute based access control to requests to Google Cloud services. *Warning:* Do not mix *v1alpha* and *v1* API usage in the same access policy. The v1alpha API supports new Access Context Manager features, which may have different attributes or behaviors that are not supported by v1. The practice of mixed API usage within a policy may result in the inability to update that policy, including any access levels or service perimeters belonging to it. It is not recommended to use both v1 and v1alpha for modifying policies with critical service perimeters. Modifications using v1alpha should be limited to policies with non-production/non-critical service perimeters.
  See: https://cloud.google.com/access-context-manager/docs/reference/rest/docs/reference/rest/v1/accessPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/list
  
  Required parameters: none
  
  Optional parameters: parent, pageSize, pageToken
  
  Lists all access policies in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns an access policy based on the name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :parent string,
   :title string,
   :scopes [string],
   :etag string}
  
  Creates an access policy. This method fails if the organization already has an access policy. The long-running operation has a successful status after the access policy propagates to long-lasting storage. Syntactic and basic semantic errors are returned in `metadata` as a BadRequest proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
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

(defn patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :parent string,
   :title string,
   :scopes [string],
   :etag string}
  
  Updates an access policy. The long-running operation from this RPC has a successful status after the changes to the access policy propagate to long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an access policy based on the resource name. The long-running operation has a successful status after the access policy is removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn setIamPolicy$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy for the specified Access Context Manager access policy. This method replaces the existing IAM policy on the access policy. The IAM policy controls the set of users who can perform specific operations on the Access Context Manager access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn getIamPolicy$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy for the specified Access Context Manager access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn testIamPermissions$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, accessLevelFormat
  
  Lists all access levels for an access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accessLevels-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/get
  
  Required parameters: name
  
  Optional parameters: accessLevelFormat
  
  Gets an access level based on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :title string,
   :description string,
   :basic {:conditions [Condition], :combiningFunction string},
   :custom {:expr Expr}}
  
  Creates an access level. The long-running operation from this RPC has a successful status after the access level propagates to long-lasting storage. If access levels contain errors, an error response is returned for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
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

(defn accessLevels-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :title string,
   :description string,
   :basic {:conditions [Condition], :combiningFunction string},
   :custom {:expr Expr}}
  
  Updates an access level. The long-running operation from this RPC has a successful status after the changes to the access level propagate to long-lasting storage. If access levels contain errors, an error response is returned for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an access level based on the resource name. The long-running operation from this RPC has a successful status after the access level has been removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-replaceAll$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/replaceAll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:accessLevels [{:name string,
                   :title string,
                   :description string,
                   :basic BasicLevel,
                   :custom CustomLevel}],
   :etag string}
  
  Replaces all existing access levels in an access policy with the access levels provided. This is done atomically. The long-running operation from this RPC has a successful status after all replacements propagate to long-lasting storage. If the replacement contains errors, an error response is returned for the first error encountered. Upon error, the replacement is cancelled, and existing access levels are not affected. The Operation.response field contains ReplaceAccessLevelsResponse. Removing access levels contained in existing service perimeters result in an error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels:replaceAll"
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

(defn accessLevels-testIamPermissions$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all service perimeters for an access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn servicePerimeters-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a service perimeter based on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :title string,
   :description string,
   :perimeterType string,
   :status {:resources [string],
            :accessLevels [string],
            :restrictedServices [string],
            :vpcAccessibleServices VpcAccessibleServices,
            :ingressPolicies [IngressPolicy],
            :egressPolicies [EgressPolicy]},
   :spec {:resources [string],
          :accessLevels [string],
          :restrictedServices [string],
          :vpcAccessibleServices VpcAccessibleServices,
          :ingressPolicies [IngressPolicy],
          :egressPolicies [EgressPolicy]},
   :useExplicitDryRunSpec boolean}
  
  Creates a service perimeter. The long-running operation from this RPC has a successful status after the service perimeter propagates to long-lasting storage. If a service perimeter contains errors, an error response is returned for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
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

(defn servicePerimeters-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :title string,
   :description string,
   :perimeterType string,
   :status {:resources [string],
            :accessLevels [string],
            :restrictedServices [string],
            :vpcAccessibleServices VpcAccessibleServices,
            :ingressPolicies [IngressPolicy],
            :egressPolicies [EgressPolicy]},
   :spec {:resources [string],
          :accessLevels [string],
          :restrictedServices [string],
          :vpcAccessibleServices VpcAccessibleServices,
          :ingressPolicies [IngressPolicy],
          :egressPolicies [EgressPolicy]},
   :useExplicitDryRunSpec boolean}
  
  Updates a service perimeter. The long-running operation from this RPC has a successful status after the service perimeter propagates to long-lasting storage. If a service perimeter contains errors, an error response is returned for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a service perimeter based on the resource name. The long-running operation from this RPC has a successful status after the service perimeter is removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-replaceAll$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/replaceAll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:servicePerimeters [{:name string,
                        :title string,
                        :description string,
                        :perimeterType string,
                        :status ServicePerimeterConfig,
                        :spec ServicePerimeterConfig,
                        :useExplicitDryRunSpec boolean}],
   :etag string}
  
  Replace all existing service perimeters in an access policy with the service perimeters provided. This is done atomically. The long-running operation from this RPC has a successful status after all replacements propagate to long-lasting storage. Replacements containing errors result in an error response for the first error encountered. Upon an error, replacement are cancelled and existing service perimeters are not affected. The Operation.response field contains ReplaceServicePerimetersResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:replaceAll"
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

(defn servicePerimeters-commit$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/commit
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
  Commits the dry-run specification for all the service perimeters in an access policy. A commit operation on a service perimeter involves copying its `spec` field to the `status` field of the service perimeter. Only service perimeters with `use_explicit_dry_run_spec` field set to true are affected by a commit operation. The long-running operation from this RPC has a successful status after the dry-run specifications for all the service perimeters have been committed. If a commit fails, it causes the long-running operation to return an error response and the entire commit operation is cancelled. When successful, the Operation.response field contains CommitServicePerimetersResponse. The `dry_run` and the `spec` fields are cleared after a successful commit operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:commit"
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

(defn servicePerimeters-testIamPermissions$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the IAM permissions that the caller has on the specified Access Context Manager resource. The resource can be an AccessPolicy, AccessLevel, or ServicePerimeter. This method does not support other resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn authorizedOrgsDescs-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/authorizedOrgsDescs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all authorized orgs descs for an access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/authorizedOrgsDescs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedOrgsDescs-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/authorizedOrgsDescs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an authorized orgs desc based on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn authorizedOrgsDescs-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/authorizedOrgsDescs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :authorizationType string,
   :assetType string,
   :authorizationDirection string,
   :orgs [string]}
  
  Creates an authorized orgs desc. The long-running operation from this RPC has a successful status after the authorized orgs desc propagates to long-lasting storage. If a authorized orgs desc contains errors, an error response is returned for the first error encountered. The name of this `AuthorizedOrgsDesc` will be assigned during creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/authorizedOrgsDescs"
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

(defn authorizedOrgsDescs-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/authorizedOrgsDescs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :authorizationType string,
   :assetType string,
   :authorizationDirection string,
   :orgs [string]}
  
  Updates an authorized orgs desc. The long-running operation from this RPC has a successful status after the authorized orgs desc propagates to long-lasting storage. If a authorized orgs desc contains errors, an error response is returned for the first error encountered. Only the organization list in `AuthorizedOrgsDesc` can be updated. The name, authorization_type, asset_type and authorization_direction cannot be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn authorizedOrgsDescs-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/authorizedOrgsDescs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an authorized orgs desc based on the resource name. The long-running operation from this RPC has a successful status after the authorized orgs desc is removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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
