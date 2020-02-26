(ns happygapi.serviceconsumermanagement.services
  "Service Consumer Management API
  Manages the service consumers of a Service Infrastructure service.
  See: https://cloud.google.com/service-consumer-management/docs/overview"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "serviceconsumermanagement_schema.edn"))))

(defn search$
  "Required parameters: parent
  
  Optional parameters: query, pageToken, pageSize
  
  Search tenancy units for a managed service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+parent}:search"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tenancyUnits-addProject$
  "Required parameters: parent
  
  Optional parameters: none
  
  Add a new tenant project to the tenancy unit.
  There can be a maximum of 512 tenant projects in a tenancy unit.
  If there are previously failed `AddTenantProject` calls, you might need to
  call `RemoveTenantProject` first to resolve them before you can make
  another call to `AddTenantProject` with the same tag.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+parent}:addProject"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-deleteProject$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified project resource identified by a tenant resource tag.
  The mothod removes a project lien with a 'TenantManager' origin if that was
  added. It will then attempt to delete the project. If that operation fails,
  this method also fails.
  After the project has been deleted, the tenant resource state is set to
  DELETED.  To permanently remove resource metadata, call the
  `RemoveTenantProject` method.
  New resources with the same tag can't be added if there are existing
  resources in a DELETED state.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+name}:deleteProject"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-applyProjectConfig$
  "Required parameters: name
  
  Optional parameters: none
  
  Apply a configuration to an existing tenant project.
  This project must exist in an active state and have the original owner
  account. The caller must have permission to add a project to the given
  tenancy unit. The configuration is applied, but any existing settings on
  the project aren't modified.
  Specified policy bindings are applied. Existing bindings aren't modified.
  Specified services are activated. No service is deactivated.
  If specified, new billing configuration is applied.
  Omit a billing configuration to keep the existing one.
  A service account in the project is created if previously non existed.
  Specified labels will be appended to tenant project, note that the value of
  existing label key will be updated if the same label key is requested.
  The specified folder is ignored, as moving a tenant project to a different
  folder isn't supported.
  The operation fails if any of the steps fail, but no rollback of already
  applied configuration changes is attempted.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+name}:applyProjectConfig"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a tenancy unit with no tenant resources.
  If tenancy unit already exists, it will be returned,
  however, in this case, returned TenancyUnit does not have tenant_resources
  field set and ListTenancyUnit has to be used to get a complete
  TenancyUnit with all fields populated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+parent}/tenancyUnits"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete a tenancy unit. Before you delete the tenancy unit, there should be
  no tenant resources in it that aren't in a DELETED state.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
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

(defn tenancyUnits-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Find the tenancy unit for a managed service and service consumer.
  This method shouldn't be used in a service producer's runtime path, for
  example to find the tenant project number when creating VMs. Service
  producers must persist the tenant project's information after the project
  is created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+parent}/tenancyUnits"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tenancyUnits-attachProject$
  "Required parameters: name
  
  Optional parameters: none
  
  Attach an existing project to the tenancy unit as a new tenant
  resource. The project could either be the tenant project reserved by
  calling `AddTenantProject` under a tenancy unit of a service producer's
  project of a managed service, or from a separate project.
  The caller is checked against a set of permissions as if calling
  `AddTenantProject` on the same service consumer.
  To trigger the attachment, the targeted tenant project must be in a
  folder. Make sure the ServiceConsumerManagement service account is
  the owner of that project. These two requirements are already met
  if the project is reserved by calling `AddTenantProject`.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+name}:attachProject"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-removeProject$
  "Required parameters: name
  
  Optional parameters: none
  
  Removes the specified project resource identified by a tenant resource tag.
  The method removes the project lien with 'TenantManager' origin if that
  was added. It then attempts to delete the project. If that operation
  fails, this method also fails.
  Calls to remove already removed or non-existent tenant project succeed.
  After the project has been deleted, or if was already in a DELETED state,
  resource metadata is permanently removed from the tenancy unit.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+name}:removeProject"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn tenancyUnits-undeleteProject$
  "Required parameters: name
  
  Optional parameters: none
  
  Attempts to undelete a previously deleted tenant project. The project must
  be in a DELETED state.
  There are no guarantees that an undeleted project will be in
  a fully restored and functional state. Call the `ApplyTenantProjectConfig`
  method to update its configuration and then validate all managed service
  resources.
  Operation<response: Empty>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://serviceconsumermanagement.googleapis.com/"
     "v1/{+name}:undeleteProject"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
