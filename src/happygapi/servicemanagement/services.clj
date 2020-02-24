(ns happygapi.servicemanagement.services
  "Service Management API
  Google Service Management allows service producers to publish their services on Google Cloud Platform so that they can be discovered and used by service consumers.
  See: https://cloud.google.com/service-management/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn disable$
  "Required parameters: serviceName
  
  Disables a service for a project, so it can no longer be
  be used for the project. It prevents accidental usage that may cause
  unexpected billing charges or security leaks.
  
  Operation<response: DisableServiceResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}:disable"
     #{"serviceName"}
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

(defn get$
  "Required parameters: serviceName
  
  Gets a managed service. Authentication is required unless the service is
  public."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}"
     #{"serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn generateConfigReport$
  "Required parameters: none
  
  Generates and returns a report (errors, warnings and changes from
  existing configurations) associated with
  GenerateConfigReportRequest.new_value
  
  If GenerateConfigReportRequest.old_value is specified,
  GenerateConfigReportRequest will contain a single ChangeReport based on the
  comparison between GenerateConfigReportRequest.new_value and
  GenerateConfigReportRequest.old_value.
  If GenerateConfigReportRequest.old_value is not specified, this method
  will compare GenerateConfigReportRequest.new_value with the last pushed
  service configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services:generateConfigReport"
     #{}
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

(defn enable$
  "Required parameters: serviceName
  
  Enables a service for a project, so it can be used
  for the project. See
  [Cloud Auth Guide](https://cloud.google.com/docs/authentication) for
  more information.
  
  Operation<response: EnableServiceResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}:enable"
     #{"serviceName"}
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

(defn testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn create$
  "Required parameters: none
  
  Creates a new managed service.
  Please note one producer project can own no more than 20 services.
  
  Operation<response: ManagedService>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services"
     #{}
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

(defn delete$
  "Required parameters: serviceName
  
  Deletes a managed service. This method will change the service to the
  `Soft-Delete` state for 30 days. Within this period, service producers may
  call UndeleteService to restore the service.
  After 30 days, the service will be permanently deleted.
  
  Operation<response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}"
     #{"serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn undelete$
  "Required parameters: serviceName
  
  Revives a previously deleted managed service. The method restores the
  service using the configuration at the time the service was deleted.
  The target service must exist and must have been deleted within the
  last 30 days.
  
  Operation<response: UndeleteServiceResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}:undelete"
     #{"serviceName"}
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

(defn getConfig$
  "Required parameters: serviceName
  
  Gets a service configuration (version) for a managed service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/config"
     #{"serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Lists managed services.
  
  Returns all public services. For authenticated users, also returns all
  services the calling user has \"servicemanagement.services.get\" permission
  for.
  
  **BETA:** If the caller specifies the `consumer_id`, it returns only the
  services enabled on the consumer. The `consumer_id` must have the format
  of \"project:{PROJECT-ID}\"."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn configs-list$
  "Required parameters: serviceName
  
  Lists the history of the service configuration for a managed service,
  from the newest to the oldest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs"
     #{"serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn configs-get$
  "Required parameters: configId,serviceName
  
  Gets a service configuration (version) for a managed service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"configId" "serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs/{configId}"
     #{"configId" "serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn configs-create$
  "Required parameters: serviceName
  
  Creates a new service configuration (version) for a managed service.
  This method only stores the service configuration. To roll out the service
  configuration to backend systems please call
  CreateServiceRollout.
  
  Only the 100 most recent service configurations and ones referenced by
  existing rollouts are kept for each service. The rest will be deleted
  eventually."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs"
     #{"serviceName"}
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

(defn configs-submit$
  "Required parameters: serviceName
  
  Creates a new service configuration (version) for a managed service based
  on
  user-supplied configuration source files (for example: OpenAPI
  Specification). This method stores the source configurations as well as the
  generated service configuration. To rollout the service configuration to
  other services,
  please call CreateServiceRollout.
  
  Only the 100 most recent configuration sources and ones referenced by
  existing service configurtions are kept for each service. The rest will be
  deleted eventually.
  
  Operation<response: SubmitConfigSourceResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs:submit"
     #{"serviceName"}
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

(defn consumers-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn consumers-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn consumers-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn rollouts-create$
  "Required parameters: serviceName
  
  Creates a new service configuration rollout. Based on rollout, the
  Google Service Management will roll out the service configurations to
  different backend services. For example, the logging configuration will be
  pushed to Google Cloud Logging.
  
  Please note that any previous pending and running Rollouts and associated
  Operations will be automatically cancelled so that the latest Rollout will
  not be blocked by previous Rollouts.
  
  Only the 100 most recent (in any state) and the last 10 successful (if not
  already part of the set of 100 most recent) rollouts are kept for each
  service. The rest will be deleted eventually.
  
  Operation<response: Rollout>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts"
     #{"serviceName"}
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

(defn rollouts-list$
  "Required parameters: serviceName
  
  Lists the history of the service configuration rollouts for a managed
  service, from the newest to the oldest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts"
     #{"serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rollouts-get$
  "Required parameters: serviceName,rolloutId
  
  Gets a service configuration rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"rolloutId" "serviceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts/{rolloutId}"
     #{"rolloutId" "serviceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
