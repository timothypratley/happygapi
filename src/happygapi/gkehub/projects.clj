(ns happygapi.gkehub.projects
  "GKE Hub API: projects.
  
  See: https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-memberships-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-setIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :deleteTime string,
   :monitoringConfig {:projectId string,
                      :location string,
                      :cluster string,
                      :kubernetesMetricsPrefix string,
                      :clusterHash string},
   :name string,
   :authority {:issuer string,
               :workloadIdentityPool string,
               :identityProvider string,
               :oidcJwks string},
   :createTime string,
   :state {:code string},
   :lastConnectionTime string,
   :updateTime string,
   :externalId string,
   :uniqueId string,
   :endpoint {:gkeCluster GkeCluster,
              :onPremCluster OnPremCluster,
              :multiCloudCluster MultiCloudCluster,
              :edgeCluster EdgeCluster,
              :applianceCluster ApplianceCluster,
              :kubernetesMetadata KubernetesMetadata,
              :kubernetesResource KubernetesResource,
              :googleManaged boolean}}
  
  Updates an existing Membership."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-testIamPermissions$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/create
  
  Required parameters: parent
  
  Optional parameters: membershipId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :deleteTime string,
   :monitoringConfig {:projectId string,
                      :location string,
                      :cluster string,
                      :kubernetesMetricsPrefix string,
                      :clusterHash string},
   :name string,
   :authority {:issuer string,
               :workloadIdentityPool string,
               :identityProvider string,
               :oidcJwks string},
   :createTime string,
   :state {:code string},
   :lastConnectionTime string,
   :updateTime string,
   :externalId string,
   :uniqueId string,
   :endpoint {:gkeCluster GkeCluster,
              :onPremCluster OnPremCluster,
              :multiCloudCluster MultiCloudCluster,
              :edgeCluster EdgeCluster,
              :applianceCluster ApplianceCluster,
              :kubernetesMetadata KubernetesMetadata,
              :kubernetesResource KubernetesResource,
              :googleManaged boolean}}
  
  Creates a new Membership. **This is currently only supported for GKE clusters on Google Cloud**. To register other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/registering-a-cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/memberships"
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

(defn locations-memberships-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Removes a Membership. **This is currently only supported for GKE clusters on Google Cloud**. To unregister other clusters, follow the instructions at https://cloud.google.com/anthos/multicluster-management/connect/unregistering-a-cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-getIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Memberships in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/memberships"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-memberships-generateConnectManifest$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/generateConnectManifest
  
  Required parameters: name
  
  Optional parameters: namespace, proxy, version, isUpgrade, registry, imagePullSecretContent
  
  Generates the manifest for deployment of the GKE connect agent. **This method is used internally by Google-provided libraries.** Most clients should not need to call this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+name}:generateConnectManifest"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-memberships-bindings-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/bindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the details of a MembershipBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-bindings-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/bindings/create
  
  Required parameters: parent
  
  Optional parameters: membershipBindingId
  
  Body: 
  
  {:scope string,
   :name string,
   :uid string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :state {:code string},
   :labels {}}
  
  Creates a MembershipBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/bindings"
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

(defn locations-memberships-bindings-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/bindings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:scope string,
   :name string,
   :uid string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :state {:code string},
   :labels {}}
  
  Updates a MembershipBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-bindings-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/bindings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a MembershipBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-memberships-bindings-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/memberships/bindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists MembershipBindings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/bindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-scopes-listMemberships$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/listMemberships
  
  Required parameters: scopeName
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists Memberships bound to a Scope. The response includes relevant Memberships from all regions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scopeName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+scopeName}:listMemberships"
     #{:scopeName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-scopes-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the details of a Scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-setIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :uid string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :state {:code string},
   :namespaceLabels {},
   :labels {}}
  
  Updates a scopes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-testIamPermissions$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/create
  
  Required parameters: parent
  
  Optional parameters: scopeId
  
  Body: 
  
  {:name string,
   :uid string,
   :createTime string,
   :updateTime string,
   :deleteTime string,
   :state {:code string},
   :namespaceLabels {},
   :labels {}}
  
  Creates a Scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/scopes"
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

(defn locations-scopes-listPermitted$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/listPermitted
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists permitted Scopes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/scopes:listPermitted"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-scopes-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-getIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Scopes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/scopes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-scopes-namespaces-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/namespaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the details of a fleet namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-namespaces-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/namespaces/create
  
  Required parameters: parent
  
  Optional parameters: scopeNamespaceId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :scope string,
   :updateTime string,
   :namespaceLabels {}}
  
  Creates a fleet namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/namespaces"
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

(defn locations-scopes-namespaces-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/namespaces/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :scope string,
   :updateTime string,
   :namespaceLabels {}}
  
  Updates a fleet namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-namespaces-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/namespaces/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a fleet namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-namespaces-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/namespaces/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists fleet namespaces."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/namespaces"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-scopes-rbacrolebindings-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/rbacrolebindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the details of a Scope RBACRoleBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-rbacrolebindings-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/rbacrolebindings/create
  
  Required parameters: parent
  
  Optional parameters: rbacrolebindingId
  
  Body: 
  
  {:role {:predefinedRole string},
   :labels {},
   :deleteTime string,
   :group string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :updateTime string,
   :user string}
  
  Creates a Scope RBACRoleBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/rbacrolebindings"
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

(defn locations-scopes-rbacrolebindings-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/rbacrolebindings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:role {:predefinedRole string},
   :labels {},
   :deleteTime string,
   :group string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :updateTime string,
   :user string}
  
  Updates a Scope RBACRoleBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-rbacrolebindings-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/rbacrolebindings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Scope RBACRoleBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-scopes-rbacrolebindings-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/scopes/rbacrolebindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all Scope RBACRoleBindings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/rbacrolebindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-features-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Features in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/features"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-features-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-features-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/create
  
  Required parameters: parent
  
  Optional parameters: featureId, requestId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :scopeSpecs {},
   :name string,
   :membershipStates {},
   :createTime string,
   :state {:appdevexperience AppDevExperienceFeatureState,
           :fleetobservability FleetObservabilityFeatureState,
           :clusterupgrade ClusterUpgradeFleetState,
           :state FeatureState},
   :updateTime string,
   :resourceState {:state string},
   :spec {:multiclusteringress MultiClusterIngressFeatureSpec,
          :appdevexperience AppDevExperienceFeatureSpec,
          :fleetobservability FleetObservabilityFeatureSpec,
          :clusterupgrade ClusterUpgradeFleetSpec,
          :dataplanev2 DataplaneV2FeatureSpec},
   :membershipSpecs {},
   :scopeStates {},
   :fleetDefaultMemberConfig {:mesh ServiceMeshMembershipSpec,
                              :configmanagement ConfigManagementMembershipSpec,
                              :identityservice IdentityServiceMembershipSpec,
                              :policycontroller PolicyControllerMembershipSpec}}
  
  Adds a new Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/features"
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

(defn locations-features-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/delete
  
  Required parameters: name
  
  Optional parameters: force, requestId
  
  Removes a Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-features-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :scopeSpecs {},
   :name string,
   :membershipStates {},
   :createTime string,
   :state {:appdevexperience AppDevExperienceFeatureState,
           :fleetobservability FleetObservabilityFeatureState,
           :clusterupgrade ClusterUpgradeFleetState,
           :state FeatureState},
   :updateTime string,
   :resourceState {:state string},
   :spec {:multiclusteringress MultiClusterIngressFeatureSpec,
          :appdevexperience AppDevExperienceFeatureSpec,
          :fleetobservability FleetObservabilityFeatureSpec,
          :clusterupgrade ClusterUpgradeFleetSpec,
          :dataplanev2 DataplaneV2FeatureSpec},
   :membershipSpecs {},
   :scopeStates {},
   :fleetDefaultMemberConfig {:mesh ServiceMeshMembershipSpec,
                              :configmanagement ConfigManagementMembershipSpec,
                              :identityservice IdentityServiceMembershipSpec,
                              :policycontroller PolicyControllerMembershipSpec}}
  
  Updates an existing Feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-features-setIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-features-getIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-features-testIamPermissions$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-fleets-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/fleets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :updateTime string,
   :defaultClusterConfig {:securityPostureConfig SecurityPostureConfig,
                          :binaryAuthorizationConfig BinaryAuthorizationConfig}}
  
  Creates a fleet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/fleets"
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

(defn locations-fleets-get$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/fleets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the details of a fleet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-fleets-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/fleets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state {:code string},
   :updateTime string,
   :defaultClusterConfig {:securityPostureConfig SecurityPostureConfig,
                          :binaryAuthorizationConfig BinaryAuthorizationConfig}}
  
  Updates a fleet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-fleets-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/fleets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a Fleet. There must be no memberships remaining in the Fleet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkehub.googleapis.com/"
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

(defn locations-fleets-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/fleets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns all fleets within an organization or a project that the caller has access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/fleets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
