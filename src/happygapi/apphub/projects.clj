(ns happygapi.apphub.projects
  "App Hub API: projects.
  
  See: https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-lookupServiceProjectAttachment$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/lookupServiceProjectAttachment
  
  Required parameters: name
  
  Optional parameters: none
  
  Lists a service project attachment for a given service project. You can call this API from any project to find if it is attached to a host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+name}:lookupServiceProjectAttachment"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-detachServiceProjectAttachment$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/detachServiceProjectAttachment
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Detaches a service project from a host project. You can call this API from any service project without needing access to the host project that it is attached to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+name}:detachServiceProjectAttachment"
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

(defn locations-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apphub.googleapis.com/"
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
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://apphub.googleapis.com/"
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

(defn locations-serviceProjectAttachments-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/serviceProjectAttachments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists service projects attached to the host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/serviceProjectAttachments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceProjectAttachments-create$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/serviceProjectAttachments/create
  
  Required parameters: parent
  
  Optional parameters: serviceProjectAttachmentId, requestId
  
  Body: 
  
  {:name string,
   :serviceProject string,
   :createTime string,
   :uid string,
   :state string}
  
  Attaches a service project to the host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/serviceProjectAttachments"
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

(defn locations-serviceProjectAttachments-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/serviceProjectAttachments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a service project attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-serviceProjectAttachments-delete$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/serviceProjectAttachments/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a service project attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-discoveredServices-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredServices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Discovered Services that can be added to an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/discoveredServices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveredServices-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredServices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Discovered Service in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-discoveredServices-lookup$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredServices/lookup
  
  Required parameters: parent
  
  Optional parameters: uri
  
  Lists a Discovered Service in a host project and location, with a given resource URI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/discoveredServices:lookup"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveredWorkloads-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredWorkloads/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Discovered Workloads that can be added to an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/discoveredWorkloads"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveredWorkloads-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredWorkloads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Discovered Workload in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-discoveredWorkloads-lookup$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/discoveredWorkloads/lookup
  
  Required parameters: parent
  
  Optional parameters: uri
  
  Lists a Discovered Workload in a host project and location, with a given resource URI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/discoveredWorkloads:lookup"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-applications-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Applications in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/applications"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-applications-create$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/create
  
  Required parameters: parent
  
  Optional parameters: applicationId, requestId
  
  Body: 
  
  {:description string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :scope {:type string},
   :updateTime string,
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Creates an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/applications"
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

(defn locations-applications-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-patch$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :scope {:type string},
   :updateTime string,
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Updates an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-delete$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes an Application in a host project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-setIamPolicy$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/setIamPolicy
  
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
     "https://apphub.googleapis.com/"
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

(defn locations-applications-getIamPolicy$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-testIamPermissions$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/testIamPermissions
  
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
     "https://apphub.googleapis.com/"
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

(defn locations-applications-services-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/services/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Services in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-applications-services-create$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId, requestId
  
  Body: 
  
  {:description string,
   :serviceProperties {:gcpProject string,
                       :location string,
                       :zone string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :serviceReference {:uri string},
   :discoveredService string,
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Creates a Service in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/services"
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

(defn locations-applications-services-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Service in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-services-patch$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :serviceProperties {:gcpProject string,
                       :location string,
                       :zone string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :serviceReference {:uri string},
   :discoveredService string,
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Updates a Service in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-services-delete$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/services/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Service from an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-workloads-list$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/workloads/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Workloads in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/workloads"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-applications-workloads-create$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/workloads/create
  
  Required parameters: parent
  
  Optional parameters: workloadId, requestId
  
  Body: 
  
  {:description string,
   :displayName string,
   :workloadProperties {:gcpProject string,
                        :location string,
                        :zone string},
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :discoveredWorkload string,
   :updateTime string,
   :workloadReference {:uri string},
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Creates a Workload in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apphub.googleapis.com/"
     "v1/{+parent}/workloads"
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

(defn locations-applications-workloads-get$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/workloads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Workload in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-workloads-patch$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/workloads/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :displayName string,
   :workloadProperties {:gcpProject string,
                        :location string,
                        :zone string},
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :discoveredWorkload string,
   :updateTime string,
   :workloadReference {:uri string},
   :attributes {:criticality Criticality,
                :environment Environment,
                :developerOwners [ContactInfo],
                :operatorOwners [ContactInfo],
                :businessOwners [ContactInfo]}}
  
  Updates a Workload in an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apphub.googleapis.com/"
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

(defn locations-applications-workloads-delete$
  "https://cloud.google.com/app-hub/docs/api/reference/rest/v1/projects/locations/applications/workloads/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Workload from an Application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apphub.googleapis.com/"
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
