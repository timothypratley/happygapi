(ns happygapi.assuredworkloads.organizations
  "Assured Workloads API: organizations.
  
  See: https://cloud.google.comapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-workloads-create$
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/workloads/create
  
  Required parameters: parent
  
  Optional parameters: externalId
  
  Body: 
  
  {:provisionedResourcesParent string,
   :labels {},
   :kmsSettings {:rotationPeriod string, :nextRotationTime string},
   :billingAccount string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :complianceRegime string,
   :resourceSettings [{:resourceId string,
                       :resourceType string,
                       :displayName string}],
   :resources [{:resourceId string, :resourceType string}]}
  
  Creates Assured Workload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-patch$
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/workloads/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:provisionedResourcesParent string,
   :labels {},
   :kmsSettings {:rotationPeriod string, :nextRotationTime string},
   :billingAccount string,
   :displayName string,
   :name string,
   :createTime string,
   :etag string,
   :complianceRegime string,
   :resourceSettings [{:resourceId string,
                       :resourceType string,
                       :displayName string}],
   :resources [{:resourceId string, :resourceType string}]}
  
  Updates an existing workload. Currently allows updating of workload display_name and labels. For force updates don't set etag field in the Workload. Only one update operation per workload can be in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-get$
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/workloads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets Assured Workload associated with a CRM Node"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-list$
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/workloads/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists Assured Workloads under a CRM Node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-delete$
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/workloads/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes the workload. Make sure that workload's direct children are already in a deleted state, otherwise the request will fail with a FAILED_PRECONDITION error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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
  "https://cloud.google.comapi/reference/rest/v1/organizations/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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
