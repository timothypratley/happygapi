(ns happygapi.servicemanagement.services
  "Service Management API: services.
  Google Service Management allows service producers to publish their services on Google Cloud Platform so that they can be discovered and used by service consumers.
  See: https://cloud.google.com/service-management/api/reference/rest/v1/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/get
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Gets a managed service. Authentication is required unless the service is public."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn generateConfigReport$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/generateConfigReport
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:newConfig {}, :oldConfig {}}
  
  Generates and returns a report (errors, warnings and changes from existing configurations) associated with GenerateConfigReportRequest.new_value If GenerateConfigReportRequest.old_value is specified, GenerateConfigReportRequest will contain a single ChangeReport based on the comparison between GenerateConfigReportRequest.new_value and GenerateConfigReportRequest.old_value. If GenerateConfigReportRequest.old_value is not specified, this method will compare GenerateConfigReportRequest.new_value with the last pushed service configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services:generateConfigReport"
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

(defn testIamPermissions$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:serviceName string, :producerProjectId string}
  
  Creates a new managed service. A managed service is immutable, and is subject to mandatory 30-day data retention. You cannot move a service or recreate it within 30 days after deletion. One producer project can own no more than 500 services. For security and reliability purposes, a production service should be hosted in a dedicated producer project. Operation"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services"
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

(defn delete$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/delete
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Deletes a managed service. This method will change the service to the `Soft-Delete` state for 30 days. Within this period, service producers may call UndeleteService to restore the service. After 30 days, the service will be permanently deleted. Operation"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn undelete$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/undelete
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Revives a previously deleted managed service. The method restores the service using the configuration at the time the service was deleted. The target service must exist and must have been deleted within the last 30 days. Operation"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}:undelete"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getConfig$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/getConfig
  
  Required parameters: serviceName
  
  Optional parameters: configId, view
  
  Gets a service configuration (version) for a managed service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/config"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/list
  
  Required parameters: none
  
  Optional parameters: consumerId, pageSize, pageToken, producerProjectId
  
  Lists managed services. Returns all public services. For authenticated users, also returns all services the calling user has \"servicemanagement.services.get\" permission for."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn consumers-testIamPermissions$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/consumers/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn consumers-getIamPolicy$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/consumers/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn consumers-setIamPolicy$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/consumers/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
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

(defn configs-submit$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/configs/submit
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:configSource {:id string, :files [ConfigFile]},
   :validateOnly boolean}
  
  Creates a new service configuration (version) for a managed service based on user-supplied configuration source files (for example: OpenAPI Specification). This method stores the source configurations as well as the generated service configuration. To rollout the service configuration to other services, please call CreateServiceRollout. Only the 100 most recent configuration sources and ones referenced by existing service configurtions are kept for each service. The rest will be deleted eventually. Operation"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs:submit"
     #{:serviceName}
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

(defn configs-get$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/configs/get
  
  Required parameters: configId, serviceName
  
  Optional parameters: view
  
  Gets a service configuration (version) for a managed service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName :configId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs/{configId}"
     #{:serviceName :configId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configs-list$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/configs/list
  
  Required parameters: serviceName
  
  Optional parameters: pageToken, pageSize
  
  Lists the history of the service configuration for a managed service, from the newest to the oldest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configs-create$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/configs/create
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:monitoring {:consumerDestinations [MonitoringDestination],
                :producerDestinations [MonitoringDestination]},
   :systemParameters {:rules [SystemParameterRule]},
   :logs [{:name string,
           :displayName string,
           :description string,
           :labels [LabelDescriptor]}],
   :name string,
   :billing {:consumerDestinations [BillingDestination]},
   :producerProjectId string,
   :quota {:metricRules [MetricRule], :limits [QuotaLimit]},
   :title string,
   :documentation {:summary string,
                   :overview string,
                   :documentationRootUrl string,
                   :rules [DocumentationRule],
                   :serviceRootUrl string,
                   :pages [Page]},
   :types [{:name string,
            :sourceContext SourceContext,
            :options [Option],
            :fields [Field],
            :syntax string,
            :oneofs [string]}],
   :logging {:producerDestinations [LoggingDestination],
             :consumerDestinations [LoggingDestination]},
   :endpoints [{:name string, :allowCors boolean, :target string}],
   :configVersion integer,
   :sourceInfo {:sourceFiles [{}]},
   :usage {:rules [UsageRule],
           :producerNotificationChannel string,
           :requirements [string]},
   :authentication {:providers [AuthProvider],
                    :rules [AuthenticationRule]},
   :id string,
   :control {:environment string},
   :http {:rules [HttpRule], :fullyDecodeReservedExpansion boolean},
   :context {:rules [ContextRule]},
   :monitoredResources [{:labels [LabelDescriptor],
                         :type string,
                         :launchStage string,
                         :name string,
                         :description string,
                         :displayName string}],
   :apis [{:syntax string,
           :name string,
           :sourceContext SourceContext,
           :mixins [Mixin],
           :methods [Method],
           :options [Option],
           :version string}],
   :customError {:rules [CustomErrorRule], :types [string]},
   :systemTypes [{:name string,
                  :sourceContext SourceContext,
                  :options [Option],
                  :fields [Field],
                  :syntax string,
                  :oneofs [string]}],
   :enums [{:options [Option],
            :sourceContext SourceContext,
            :enumvalue [EnumValue],
            :name string,
            :syntax string}],
   :backend {:rules [BackendRule]},
   :metrics [{:description string,
              :labels [LabelDescriptor],
              :valueType string,
              :monitoredResourceTypes [string],
              :unit string,
              :displayName string,
              :name string,
              :type string,
              :metricKind string,
              :launchStage string,
              :metadata MetricDescriptorMetadata}]}
  
  Creates a new service configuration (version) for a managed service. This method only stores the service configuration. To roll out the service configuration to backend systems please call CreateServiceRollout. Only the 100 most recent service configurations and ones referenced by existing rollouts are kept for each service. The rest will be deleted eventually."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/configs"
     #{:serviceName}
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

(defn rollouts-create$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/rollouts/create
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:serviceName string,
   :createTime string,
   :trafficPercentStrategy {:percentages {}},
   :rolloutId string,
   :createdBy string,
   :status string,
   :deleteServiceStrategy {}}
  
  Creates a new service configuration rollout. Based on rollout, the Google Service Management will roll out the service configurations to different backend services. For example, the logging configuration will be pushed to Google Cloud Logging. Please note that any previous pending and running Rollouts and associated Operations will be automatically cancelled so that the latest Rollout will not be blocked by previous Rollouts. Only the 100 most recent (in any state) and the last 10 successful (if not already part of the set of 100 most recent) rollouts are kept for each service. The rest will be deleted eventually. Operation"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts"
     #{:serviceName}
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

(defn rollouts-get$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/rollouts/get
  
  Required parameters: rolloutId, serviceName
  
  Optional parameters: none
  
  Gets a service configuration rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName :rolloutId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts/{rolloutId}"
     #{:serviceName :rolloutId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rollouts-list$
  "https://cloud.google.com/service-management/api/reference/rest/v1/services/rollouts/list
  
  Required parameters: serviceName
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the history of the service configuration rollouts for a managed service, from the newest to the oldest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/service.management"
            "https://www.googleapis.com/auth/service.management.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/services/{serviceName}/rollouts"
     #{:serviceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
