(ns happygapi.compute.storagePools
  "Compute Engine API: storagePools.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/storagePools"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/get
  
  Required parameters: project, storagePool, zone
  
  Optional parameters: none
  
  Returns a specified storage pool. Gets a list of available storage pools by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :storagePool :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{storagePool}"
     #{:zone :storagePool :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/setIamPolicy
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :rules [Rule],
            :etag string},
   :bindings [{:role string,
               :members [string],
               :condition Expr,
               :bindingId string}],
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{resource}/setIamPolicy"
     #{:zone :project :resource}
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :performanceProvisioningType string,
   :creationTimestamp string,
   :resourceStatus {:totalProvisionedDiskIops string,
                    :diskCount string,
                    :lastResizeTimestamp string,
                    :poolUsedCapacityBytes string,
                    :totalProvisionedDiskThroughput string,
                    :poolUsedIops string,
                    :maxTotalProvisionedDiskCapacityGb string,
                    :poolUserWrittenBytes string,
                    :poolUsedThroughput string,
                    :totalProvisionedDiskCapacityGb string},
   :storagePoolType string,
   :zone string,
   :name string,
   :selfLink string,
   :state string,
   :capacityProvisioningType string,
   :selfLinkWithId string,
   :status {:totalProvisionedDiskIops string,
            :diskCount string,
            :lastResizeTimestamp string,
            :poolUsedCapacityBytes string,
            :totalProvisionedDiskThroughput string,
            :poolUsedIops string,
            :maxTotalProvisionedDiskCapacityGb string,
            :poolUserWrittenBytes string,
            :poolUsedThroughput string,
            :totalProvisionedDiskCapacityGb string},
   :poolProvisionedCapacityGb string,
   :id string,
   :kind string,
   :poolProvisionedIops string,
   :poolProvisionedThroughput string,
   :labelFingerprint string}
  
  Creates a storage pool in the specified project using the data in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools"
     #{:zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/testIamPermissions
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{resource}/testIamPermissions"
     #{:zone :project :resource}
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of storage pools. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/storagePools"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/update
  
  Required parameters: project, storagePool, zone
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :performanceProvisioningType string,
   :creationTimestamp string,
   :resourceStatus {:totalProvisionedDiskIops string,
                    :diskCount string,
                    :lastResizeTimestamp string,
                    :poolUsedCapacityBytes string,
                    :totalProvisionedDiskThroughput string,
                    :poolUsedIops string,
                    :maxTotalProvisionedDiskCapacityGb string,
                    :poolUserWrittenBytes string,
                    :poolUsedThroughput string,
                    :totalProvisionedDiskCapacityGb string},
   :storagePoolType string,
   :zone string,
   :name string,
   :selfLink string,
   :state string,
   :capacityProvisioningType string,
   :selfLinkWithId string,
   :status {:totalProvisionedDiskIops string,
            :diskCount string,
            :lastResizeTimestamp string,
            :poolUsedCapacityBytes string,
            :totalProvisionedDiskThroughput string,
            :poolUsedIops string,
            :maxTotalProvisionedDiskCapacityGb string,
            :poolUserWrittenBytes string,
            :poolUsedThroughput string,
            :totalProvisionedDiskCapacityGb string},
   :poolProvisionedCapacityGb string,
   :id string,
   :kind string,
   :poolProvisionedIops string,
   :poolProvisionedThroughput string,
   :labelFingerprint string}
  
  Updates the specified storagePool with the data included in the request. The update is performed only on selected fields included as part of update-mask. Only the following fields can be modified: size_tb and provisioned_iops."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :storagePool :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{storagePool}"
     #{:zone :storagePool :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/delete
  
  Required parameters: project, storagePool, zone
  
  Optional parameters: requestId
  
  Deletes the specified storage pool. Deleting a storagePool removes its data permanently and is irreversible. However, deleting a storagePool does not delete any snapshots previously made from the storagePool. You must separately delete snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :storagePool :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{storagePool}"
     #{:zone :storagePool :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/getIamPolicy
  
  Required parameters: project, resource, zone
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{resource}/getIamPolicy"
     #{:zone :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of storage pools contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listDisks$
  "https://cloud.google.com/compute/api/reference/rest/v1/storagePools/listDisks
  
  Required parameters: project, storagePool, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the disks in a specified storage pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :storagePool :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/storagePools/{storagePool}/listDisks"
     #{:zone :storagePool :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
