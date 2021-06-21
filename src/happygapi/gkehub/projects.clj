(ns happygapi.gkehub.projects
  "GKE Hub: projects.
  
  See: https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn locations-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
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

(defn locations-operations-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
  
  {:updateMask string,
   :policy {:auditConfigs [AuditConfig],
            :etag string,
            :bindings [Binding],
            :version integer}}
  
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
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :deleteTime string,
   :name string,
   :authority {:workloadIdentityPool string,
               :issuer string,
               :oidcJwks string,
               :identityProvider string},
   :createTime string,
   :state {:code string},
   :lastConnectionTime string,
   :updateTime string,
   :externalId string,
   :uniqueId string,
   :endpoint {:kubernetesMetadata KubernetesMetadata,
              :gkeCluster GkeCluster}}
  
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
   :name string,
   :authority {:workloadIdentityPool string,
               :issuer string,
               :oidcJwks string,
               :identityProvider string},
   :createTime string,
   :state {:code string},
   :lastConnectionTime string,
   :updateTime string,
   :externalId string,
   :uniqueId string,
   :endpoint {:kubernetesMetadata KubernetesMetadata,
              :gkeCluster GkeCluster}}
  
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
  
  Optional parameters: requestId
  
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
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
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
  
  Optional parameters: registry, imagePullSecretContent, isUpgrade, version, proxy, namespace
  
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

(defn locations-features-patch$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :name string,
   :membershipStates {},
   :createTime string,
   :state {:state FeatureState},
   :updateTime string,
   :resourceState {:state string},
   :spec {:multiclusteringress MultiClusterIngressFeatureSpec},
   :membershipSpecs {}}
  
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

(defn locations-features-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize, orderBy
  
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

(defn locations-features-delete$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
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

(defn locations-features-setIamPolicy$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [AuditConfig],
            :etag string,
            :bindings [Binding],
            :version integer}}
  
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

(defn locations-features-create$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/projects/locations/features/create
  
  Required parameters: parent
  
  Optional parameters: featureId, requestId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :name string,
   :membershipStates {},
   :createTime string,
   :state {:state FeatureState},
   :updateTime string,
   :resourceState {:state string},
   :spec {:multiclusteringress MultiClusterIngressFeatureSpec},
   :membershipSpecs {}}
  
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
