(ns happygapi.appengine.apps
  "App Engine Admin API
  Provisions and manages developers' App Engine applications.
  See: https://cloud.google.com/appengine/docs/admin-api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "appengine_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates an App Engine application for a Google Cloud Platform project. Required fields:
  id - The ID of the target Cloud Platform project.
  location - The region (https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.For more information about App Engine applications, see Managing Projects, Applications, and Billing (https://cloud.google.com/appengine/docs/standard/python/console/)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps"
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

(defn repair$
  "Required parameters: appsId
  
  Optional parameters: none
  
  Recreates the required App Engine features for the specified App Engine application, for example a Cloud Storage bucket or App Engine service account. Use this method if you receive an error message about a missing feature, for example, Error retrieving the App Engine service account. If you have deleted your App Engine service account, this will not be able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B\"name\"%3A\"projects%2F-%2FserviceAccounts%2Funique_id\"%2C\"resource\"%3A%7B%7D%7D . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}:repair"
     #{"appsId"}
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
  "Required parameters: appsId
  
  Optional parameters: none
  
  Gets information about an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: appsId
  
  Optional parameters: updateMask
  
  Updates the specified Application resource. You can update the following fields:
  auth_domain - Google authentication domain for controlling user access to the application.
  default_cookie_expiration - Cookie expiration policy for the application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-delete$
  "Required parameters: authorizedCertificatesId, appsId
  
  Optional parameters: none
  
  Deletes the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"authorizedCertificatesId" "appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{"authorizedCertificatesId" "appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-list$
  "Required parameters: appsId
  
  Optional parameters: pageToken, pageSize, view
  
  Lists all SSL certificates the user is authorized to administer."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-get$
  "Required parameters: authorizedCertificatesId, appsId
  
  Optional parameters: view
  
  Gets the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"authorizedCertificatesId" "appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{"authorizedCertificatesId" "appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-patch$
  "Required parameters: authorizedCertificatesId, appsId
  
  Optional parameters: updateMask
  
  Updates the specified SSL certificate. To renew a certificate and maintain its existing domain mappings, update certificate_data with a new certificate. The new certificate must be applicable to the same domains as the original certificate. The certificate display_name may also be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"authorizedCertificatesId" "appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{"authorizedCertificatesId" "appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-create$
  "Required parameters: appsId
  
  Optional parameters: none
  
  Uploads the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates"
     #{"appsId"}
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

(defn services-delete$
  "Required parameters: servicesId, appsId
  
  Optional parameters: none
  
  Deletes the specified service and all enclosed versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{"appsId" "servicesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-list$
  "Required parameters: appsId
  
  Optional parameters: pageToken, pageSize
  
  Lists all the services in the application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-get$
  "Required parameters: servicesId, appsId
  
  Optional parameters: none
  
  Gets the current configuration of the specified service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{"appsId" "servicesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-patch$
  "Required parameters: servicesId, appsId
  
  Optional parameters: updateMask, migrateTraffic
  
  Updates the configuration of the specified service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{"appsId" "servicesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-delete$
  "Required parameters: servicesId, appsId, versionsId
  
  Optional parameters: none
  
  Deletes an existing Version resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId" "versionsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{"appsId" "servicesId" "versionsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-list$
  "Required parameters: appsId, servicesId
  
  Optional parameters: pageToken, pageSize, view
  
  Lists the versions of a service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions"
     #{"appsId" "servicesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-get$
  "Required parameters: versionsId, servicesId, appsId
  
  Optional parameters: view
  
  Gets the specified Version resource. By default, only a BASIC_VIEW will be returned. Specify the FULL_VIEW parameter to get the full resource."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId" "versionsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{"appsId" "servicesId" "versionsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-patch$
  "Required parameters: servicesId, appsId, versionsId
  
  Optional parameters: updateMask
  
  Updates the specified Version resource. You can specify the following fields depending on the App Engine environment and type of scaling that the version resource uses:Standard environment
  instance_class (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)automatic scaling in the standard environment:
  automatic_scaling.min_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
  automatic_scaling.max_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
  automaticScaling.standard_scheduler_settings.max_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
  automaticScaling.standard_scheduler_settings.min_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
  automaticScaling.standard_scheduler_settings.target_cpu_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)
  automaticScaling.standard_scheduler_settings.target_throughput_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)basic scaling or manual scaling in the standard environment:
  serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)Flexible environment
  serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)automatic scaling in the flexible environment:
  automatic_scaling.min_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
  automatic_scaling.max_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
  automatic_scaling.cool_down_period_sec (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)
  automatic_scaling.cpu_utilization.target_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId" "versionsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{"appsId" "servicesId" "versionsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-create$
  "Required parameters: servicesId, appsId
  
  Optional parameters: none
  
  Deploys code and resource files to a new version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId" "servicesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions"
     #{"appsId" "servicesId"}
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

(defn services-versions-instances-delete$
  "Required parameters: servicesId, appsId, instancesId, versionsId
  
  Optional parameters: none
  
  Stops a running instance.The instance might be automatically recreated based on the scaling settings of the version. For more information, see \"How Instances are Managed\" (standard environment (https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) | flexible environment (https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).To ensure that instances are not re-created and avoid getting billed, you can stop all instances within the target version by changing the serving status of the version to STOPPED with the apps.services.versions.patch (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch) method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"appsId" "servicesId" "versionsId" "instancesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}"
     #{"appsId" "servicesId" "versionsId" "instancesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-list$
  "Required parameters: servicesId, appsId, versionsId
  
  Optional parameters: pageToken, pageSize
  
  Lists the instances of a version.Tip: To aggregate details about instances over time, see the Stackdriver Monitoring API (https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list)."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "servicesId" "versionsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances"
     #{"appsId" "servicesId" "versionsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-get$
  "Required parameters: servicesId, appsId, instancesId, versionsId
  
  Optional parameters: none
  
  Gets instance information."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"appsId" "servicesId" "versionsId" "instancesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}"
     #{"appsId" "servicesId" "versionsId" "instancesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-debug$
  "Required parameters: servicesId, appsId, instancesId, versionsId
  
  Optional parameters: none
  
  Enables debugging on a VM instance. This allows you to use the SSH command to connect to the virtual machine where the instance lives. While in \"debug mode\", the instance continues to serve live traffic. You should delete the instance when you are done debugging and then allow the system to take over and determine if another instance should be started.Only applicable for instances in App Engine flexible environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"appsId" "servicesId" "versionsId" "instancesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}:debug"
     #{"appsId" "servicesId" "versionsId" "instancesId"}
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

(defn authorizedDomains-list$
  "Required parameters: appsId
  
  Optional parameters: pageToken, pageSize
  
  Lists all domains the user is authorized to administer."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedDomains"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "Required parameters: appsId
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.NOTE: the name binding allows API services to override the binding to use different resource name schemes, such as users/*/operations. To override the binding, API services can add a binding such as \"/v1/{name=users/*}/operations\" to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/operations"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "Required parameters: operationsId, appsId
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "operationsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/operations/{operationsId}"
     #{"appsId" "operationsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-list$
  "Required parameters: appsId
  
  Optional parameters: pageToken, pageSize
  
  Lists the domain mappings on an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-get$
  "Required parameters: appsId, domainMappingsId
  
  Optional parameters: none
  
  Gets the specified domain mapping."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "domainMappingsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{"appsId" "domainMappingsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-patch$
  "Required parameters: appsId, domainMappingsId
  
  Optional parameters: updateMask
  
  Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update certificate_id to point to an AuthorizedCertificate resource. A user must be authorized to administer the associated domain in order to update a DomainMapping resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "domainMappingsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{"appsId" "domainMappingsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-create$
  "Required parameters: appsId
  
  Optional parameters: overrideStrategy
  
  Maps a domain to an application. A user must be authorized to administer a domain in order to map it to an application. For a list of available authorized domains, see AuthorizedDomains.ListAuthorizedDomains."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings"
     #{"appsId"}
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

(defn domainMappings-delete$
  "Required parameters: appsId, domainMappingsId
  
  Optional parameters: none
  
  Deletes the specified domain mapping. A user must be authorized to administer the associated domain in order to delete a DomainMapping resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "domainMappingsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{"appsId" "domainMappingsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-delete$
  "Required parameters: ingressRulesId, appsId
  
  Optional parameters: none
  
  Deletes the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "ingressRulesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{"appsId" "ingressRulesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-list$
  "Required parameters: appsId
  
  Optional parameters: pageToken, pageSize, matchingAddress
  
  Lists the firewall rules of an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-create$
  "Required parameters: appsId
  
  Optional parameters: none
  
  Creates a firewall rule for the application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules"
     #{"appsId"}
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

(defn firewall-ingressRules-get$
  "Required parameters: ingressRulesId, appsId
  
  Optional parameters: none
  
  Gets the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "ingressRulesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{"appsId" "ingressRulesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-patch$
  "Required parameters: appsId, ingressRulesId
  
  Optional parameters: updateMask
  
  Updates the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "ingressRulesId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{"appsId" "ingressRulesId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-batchUpdate$
  "Required parameters: appsId
  
  Optional parameters: none
  
  Replaces the entire firewall ruleset in one bulk operation. This overrides and replaces the rules of an existing firewall with the new rules.If the final rule does not match traffic with the '*' wildcard IP range, then an \"allow all\" rule is explicitly added to the end of the list."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules:batchUpdate"
     #{"appsId"}
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

(defn locations-list$
  "Required parameters: appsId
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/locations"
     #{"appsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: locationsId, appsId
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"appsId" "locationsId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/locations/{locationsId}"
     #{"appsId" "locationsId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
