(ns happygapi.datafusion.projects
  "Cloud Data Fusion API: projects.
  Cloud Data Fusion is a fully-managed, cloud native, enterprise data integration service for
      quickly building and managing data pipelines. It provides a graphical interface to increase
      time efficiency and reduce complexity, and allows business users, developers, and data
      scientists to easily and reliably build scalable data integration solutions to cleanse,
      prepare, blend, transfer and transform data without having to wrestle with infrastructure.
  See: https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: includeUnrevealedLocations, pageToken, pageSize, filter
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}/locations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}:cancel"
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

(defn locations-operations-delete$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-get$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets details of a single Data Fusion instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-setIamPolicy$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-instances-restart$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/restart
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restart a single Data Fusion instance.
  At the end of an operation instance is fully restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}:restart"
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

(defn locations-instances-patch$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :gcsBucket string,
   :zone string,
   :displayName string,
   :name string,
   :apiEndpoint string,
   :createTime string,
   :type string,
   :serviceEndpoint string,
   :state string,
   :availableVersion [{:versionNumber string}],
   :networkConfig {:ipAllocation string, :network string},
   :updateTime string,
   :enableStackdriverMonitoring boolean,
   :enableStackdriverLogging boolean,
   :options {},
   :version string,
   :privateInstance boolean,
   :stateMessage string}
  
  Updates a single Data Fusion instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-instances-testIamPermissions$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-instances-create$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :gcsBucket string,
   :zone string,
   :displayName string,
   :name string,
   :apiEndpoint string,
   :createTime string,
   :type string,
   :serviceEndpoint string,
   :state string,
   :availableVersion [{:versionNumber string}],
   :networkConfig {:ipAllocation string, :network string},
   :updateTime string,
   :enableStackdriverMonitoring boolean,
   :enableStackdriverLogging boolean,
   :options {},
   :version string,
   :privateInstance boolean,
   :stateMessage string}
  
  Creates a new Data Fusion instance in the specified project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+parent}/instances"
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

(defn locations-instances-delete$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a single Date Fusion instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-getIamPolicy$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-upgrade$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/upgrade
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Upgrade a single Data Fusion instance.
  At the end of an operation instance is fully upgraded."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+name}:upgrade"
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

(defn locations-instances-list$
  "https://cloud.google.com/data-fusion/docsapi/reference/rest/v1beta1/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  Lists Data Fusion instances in the specified project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datafusion.googleapis.com/"
     "v1beta1/{+parent}/instances"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
