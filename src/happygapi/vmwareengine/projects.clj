(ns happygapi.vmwareengine.projects
  "VMware Engine API: projects.
  The Google VMware Engine API lets you programmatically manage VMware environments.
  See: https://cloud.google.com/solutions/vmware-as-a-servicedocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getDnsBindPermission$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/getDnsBindPermission
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets all the principals having bind permission on the intranet VPC associated with the consumer project granted by the Grant API. DnsBindPermission is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-getDnsForwarding$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/getDnsForwarding
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of the `DnsForwarding` config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `PrivateCloud` resource by its resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-setIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/setIamPolicy
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :nsx {:internalIp string,
         :version string,
         :state string,
         :fqdn string},
   :uid string,
   :name string,
   :createTime string,
   :managementCluster {:clusterId string,
                       :nodeTypeConfigs {},
                       :stretchedClusterConfig StretchedClusterConfig},
   :type string,
   :state string,
   :networkConfig {:managementCidr string,
                   :vmwareEngineNetwork string,
                   :vmwareEngineNetworkCanonical string,
                   :managementIpAddressLayoutVersion integer,
                   :dnsServerIp string},
   :updateTime string,
   :hcx {:internalIp string,
         :version string,
         :state string,
         :fqdn string},
   :expireTime string,
   :vcenter {:internalIp string,
             :version string,
             :state string,
             :fqdn string}}
  
  Modifies a `PrivateCloud` resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-testIamPermissions$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/testIamPermissions
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-resetNsxCredentials$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/resetNsxCredentials
  
  Required parameters: privateCloud
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Resets credentials of the NSX appliance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:privateCloud})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+privateCloud}:resetNsxCredentials"
     #{:privateCloud}
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

(defn locations-privateClouds-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/create
  
  Required parameters: parent
  
  Optional parameters: privateCloudId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :nsx {:internalIp string,
         :version string,
         :state string,
         :fqdn string},
   :uid string,
   :name string,
   :createTime string,
   :managementCluster {:clusterId string,
                       :nodeTypeConfigs {},
                       :stretchedClusterConfig StretchedClusterConfig},
   :type string,
   :state string,
   :networkConfig {:managementCidr string,
                   :vmwareEngineNetwork string,
                   :vmwareEngineNetworkCanonical string,
                   :managementIpAddressLayoutVersion integer,
                   :dnsServerIp string},
   :updateTime string,
   :hcx {:internalIp string,
         :version string,
         :state string,
         :fqdn string},
   :expireTime string,
   :vcenter {:internalIp string,
             :version string,
             :state string,
             :fqdn string}}
  
  Creates a new `PrivateCloud` resource in a given project and location. Private clouds of type `STANDARD` and `TIME_LIMITED` are zonal resources, `STRETCHED` private clouds are regional. Creating a private cloud also creates a [management cluster](https://cloud.google.com/vmware-engine/docs/concepts-vmware-components) for that private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/privateClouds"
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

(defn locations-privateClouds-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force, delayHours
  
  Schedules a `PrivateCloud` resource for deletion. A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `expireTime` set to the time when deletion is final and can no longer be reversed. The delete operation is marked as done as soon as the `PrivateCloud` is successfully scheduled for deletion (this also applies when `delayHours` is set to zero), and the operation is not kept in pending state until `PrivateCloud` is purged. `PrivateCloud` can be restored using `UndeletePrivateCloud` method before the `expireTime` elapses. When `expireTime` is reached, deletion is final and all private cloud resources are irreversibly removed and billing stops. During the final removal process, `PrivateCloud.state` is set to `PURGING`. `PrivateCloud` can be polled using standard `GET` method for the whole period of deletion and purging. It will not be returned only when it is completely purged."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-getIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-resetVcenterCredentials$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/resetVcenterCredentials
  
  Required parameters: privateCloud
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :username string}
  
  Resets credentials of the Vcenter appliance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:privateCloud})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+privateCloud}:resetVcenterCredentials"
     #{:privateCloud}
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

(defn locations-privateClouds-undelete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Restores a private cloud that was previously scheduled for deletion by `DeletePrivateCloud`. A `PrivateCloud` resource scheduled for deletion has `PrivateCloud.state` set to `DELETED` and `PrivateCloud.expireTime` set to the time when deletion can no longer be reversed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn locations-privateClouds-showVcenterCredentials$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/showVcenterCredentials
  
  Required parameters: privateCloud
  
  Optional parameters: username
  
  Gets details of credentials for Vcenter appliance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:privateCloud})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+privateCloud}:showVcenterCredentials"
     #{:privateCloud}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `PrivateCloud` resources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/privateClouds"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-updateDnsForwarding$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/updateDnsForwarding
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :forwardingRules [{:domain string, :nameServers [string]}]}
  
  Updates the parameters of the `DnsForwarding` config, like associated domains. Only fields specified in `update_mask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-showNsxCredentials$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/showNsxCredentials
  
  Required parameters: privateCloud
  
  Optional parameters: none
  
  Gets details of credentials for NSX appliance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:privateCloud})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+privateCloud}:showNsxCredentials"
     #{:privateCloud}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-clusters-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `Cluster` resources in a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/clusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-clusters-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `Cluster` resource by its resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/create
  
  Required parameters: parent
  
  Optional parameters: clusterId, requestId, validateOnly
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :state string,
   :management boolean,
   :uid string,
   :nodeTypeConfigs {},
   :stretchedClusterConfig {:preferredLocation string,
                            :secondaryLocation string}}
  
  Creates a new cluster in a given private cloud. Creating a new cluster provides additional nodes for use in the parent private cloud and requires sufficient [node quota](https://cloud.google.com/vmware-engine/quotas)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/clusters"
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

(defn locations-privateClouds-clusters-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :state string,
   :management boolean,
   :uid string,
   :nodeTypeConfigs {},
   :stretchedClusterConfig {:preferredLocation string,
                            :secondaryLocation string}}
  
  Modifies a `Cluster` resource. Only fields specified in `updateMask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a `Cluster` resource. To avoid unintended data loss, migrate or gracefully shut down any workloads running on the cluster before deletion. You cannot delete the management cluster of a private cloud using this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-setIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/setIamPolicy
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-getIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-testIamPermissions$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/testIamPermissions
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-clusters-nodes-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists nodes in a given cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-clusters-nodes-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/clusters/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-externalAddresses-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/externalAddresses/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists external IP addresses assigned to VMware workload VMs in a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/externalAddresses"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-externalAddresses-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/externalAddresses/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single external IP address."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-externalAddresses-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/externalAddresses/create
  
  Required parameters: parent
  
  Optional parameters: externalAddressId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :internalIp string,
   :externalIp string,
   :state string,
   :uid string,
   :description string}
  
  Creates a new `ExternalAddress` resource in a given private cloud. The network policy that corresponds to the private cloud must have the external IP address network service enabled (`NetworkPolicy.external_ip`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/externalAddresses"
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

(defn locations-privateClouds-externalAddresses-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/externalAddresses/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :internalIp string,
   :externalIp string,
   :state string,
   :uid string,
   :description string}
  
  Updates the parameters of a single external IP address. Only fields specified in `update_mask` are applied. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-externalAddresses-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/externalAddresses/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single external IP address. When you delete an external IP address, connectivity between the external IP address and the corresponding internal IP address is lost."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-subnets-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/subnets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists subnets in a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/subnets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-subnets-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/subnets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single subnet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-subnets-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/subnets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :ipCidrRange string,
   :gatewayIp string,
   :type string,
   :state string,
   :vlanId integer}
  
  Updates the parameters of a single subnet. Only fields specified in `update_mask` are applied. *Note*: This API is synchronous and always returns a successful `google.longrunning.Operation` (LRO). The returned LRO will only have `done` and `response` fields."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-loggingServers-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/loggingServers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists logging servers configured for a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/loggingServers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-loggingServers-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/loggingServers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a logging server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-loggingServers-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/loggingServers/create
  
  Required parameters: parent
  
  Optional parameters: loggingServerId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :hostname string,
   :port integer,
   :protocol string,
   :sourceType string,
   :uid string}
  
  Create a new logging server for a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/loggingServers"
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

(defn locations-privateClouds-loggingServers-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/loggingServers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :hostname string,
   :port integer,
   :protocol string,
   :sourceType string,
   :uid string}
  
  Updates the parameters of a single logging server. Only fields specified in `update_mask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-loggingServers-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/loggingServers/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single logging server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-hcxActivationKeys-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/create
  
  Required parameters: parent
  
  Optional parameters: hcxActivationKeyId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :state string,
   :activationKey string,
   :uid string}
  
  Creates a new HCX activation key in a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/hcxActivationKeys"
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

(defn locations-privateClouds-hcxActivationKeys-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists `HcxActivationKey` resources in a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/hcxActivationKeys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-hcxActivationKeys-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `HcxActivationKey` resource by its resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-hcxActivationKeys-setIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/setIamPolicy
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-hcxActivationKeys-getIamPolicy$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-hcxActivationKeys-testIamPermissions$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/hcxActivationKeys/testIamPermissions
  
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
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-managementDnsZoneBindings-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Consumer VPCs bound to Management DNS Zone of a given private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/managementDnsZoneBindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateClouds-managementDnsZoneBindings-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a 'ManagementDnsZoneBinding' resource by its resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-managementDnsZoneBindings-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/create
  
  Required parameters: parent
  
  Optional parameters: managementDnsZoneBindingId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :state string,
   :description string,
   :vpcNetwork string,
   :vmwareEngineNetwork string,
   :uid string}
  
  Creates a new `ManagementDnsZoneBinding` resource in a private cloud. This RPC creates the DNS binding and the resource that represents the DNS binding of the consumer VPC network to the management DNS zone. A management DNS zone is the Cloud DNS cross-project binding zone that VMware Engine creates for each private cloud. It contains FQDNs and corresponding IP addresses for the private cloud's ESXi hosts and management VM appliances like vCenter and NSX Manager."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/managementDnsZoneBindings"
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

(defn locations-privateClouds-managementDnsZoneBindings-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :state string,
   :description string,
   :vpcNetwork string,
   :vmwareEngineNetwork string,
   :uid string}
  
  Updates a `ManagementDnsZoneBinding` resource. Only fields specified in `update_mask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-managementDnsZoneBindings-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a `ManagementDnsZoneBinding` resource. When a management DNS zone binding is deleted, the corresponding consumer VPC network is no longer bound to the management DNS zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateClouds-managementDnsZoneBindings-repair$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateClouds/managementDnsZoneBindings/repair
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Retries to create a `ManagementDnsZoneBinding` resource that is in failed state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+name}:repair"
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

(defn locations-networkPolicies-fetchExternalAddresses$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/fetchExternalAddresses
  
  Required parameters: networkPolicy
  
  Optional parameters: pageSize, pageToken
  
  Lists external IP addresses assigned to VMware workload VMs within the scope of the given network policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:networkPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+networkPolicy}:fetchExternalAddresses"
     #{:networkPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networkPolicies-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `NetworkPolicy` resource by its resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPolicies-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `NetworkPolicy` resources in a specified project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/networkPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networkPolicies-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/create
  
  Required parameters: parent
  
  Optional parameters: networkPolicyId, requestId
  
  Body: 
  
  {:description string,
   :internetAccess {:enabled boolean, :state string},
   :uid string,
   :externalIp {:enabled boolean, :state string},
   :name string,
   :createTime string,
   :updateTime string,
   :vmwareEngineNetworkCanonical string,
   :vmwareEngineNetwork string,
   :edgeServicesCidr string}
  
  Creates a new network policy in a given VMware Engine network of a project and location (region). A new network policy cannot be created if another network policy already exists in the same scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/networkPolicies"
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

(defn locations-networkPolicies-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :internetAccess {:enabled boolean, :state string},
   :uid string,
   :externalIp {:enabled boolean, :state string},
   :name string,
   :createTime string,
   :updateTime string,
   :vmwareEngineNetworkCanonical string,
   :vmwareEngineNetwork string,
   :edgeServicesCidr string}
  
  Modifies a `NetworkPolicy` resource. Only the following fields can be updated: `internet_access`, `external_ip`, `edge_services_cidr`. Only fields specified in `updateMask` are applied. When updating a network policy, the external IP network service can only be disabled if there are no external IP addresses present in the scope of the policy. Also, a `NetworkService` cannot be updated when `NetworkService.state` is set to `RECONCILING`. During operation processing, the resource is temporarily in the `ACTIVE` state before the operation fully completes. For that period of time, you can't update the resource. Use the operation status to determine when the processing fully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPolicies-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a `NetworkPolicy` resource. A network policy cannot be deleted when `NetworkService.state` is set to `RECONCILING` for either its external IP or internet access service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPolicies-externalAccessRules-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/externalAccessRules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `ExternalAccessRule` resources in the specified network policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/externalAccessRules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networkPolicies-externalAccessRules-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/externalAccessRules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single external access rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPolicies-externalAccessRules-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/externalAccessRules/create
  
  Required parameters: parent
  
  Optional parameters: externalAccessRuleId, requestId
  
  Body: 
  
  {:description string,
   :sourceIpRanges [{:ipAddress string,
                     :ipAddressRange string,
                     :externalAddress string}],
   :ipProtocol string,
   :destinationPorts [string],
   :uid string,
   :name string,
   :createTime string,
   :destinationIpRanges [{:ipAddress string,
                          :ipAddressRange string,
                          :externalAddress string}],
   :state string,
   :updateTime string,
   :sourcePorts [string],
   :priority integer,
   :action string}
  
  Creates a new external access rule in a given network policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/externalAccessRules"
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

(defn locations-networkPolicies-externalAccessRules-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/externalAccessRules/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :sourceIpRanges [{:ipAddress string,
                     :ipAddressRange string,
                     :externalAddress string}],
   :ipProtocol string,
   :destinationPorts [string],
   :uid string,
   :name string,
   :createTime string,
   :destinationIpRanges [{:ipAddress string,
                          :ipAddressRange string,
                          :externalAddress string}],
   :state string,
   :updateTime string,
   :sourcePorts [string],
   :priority integer,
   :action string}
  
  Updates the parameters of a single external access rule. Only fields specified in `update_mask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPolicies-externalAccessRules-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPolicies/externalAccessRules/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single external access rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-nodeTypes-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/nodeTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists node types"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/nodeTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nodeTypes-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/nodeTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single `NodeType`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPeerings-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `NetworkPeering` resource by its resource name. The resource contains details of the network peering, such as peered networks, import and export custom route configurations, and peering state. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPeerings-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `NetworkPeering` resources in a given project. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/networkPeerings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networkPeerings-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/create
  
  Required parameters: parent
  
  Optional parameters: networkPeeringId, requestId
  
  Body: 
  
  {:description string,
   :exportCustomRoutes boolean,
   :peerMtu integer,
   :importCustomRoutesWithPublicIp boolean,
   :peerNetwork string,
   :uid string,
   :name string,
   :exchangeSubnetRoutes boolean,
   :createTime string,
   :state string,
   :stateDetails string,
   :updateTime string,
   :vmwareEngineNetwork string,
   :exportCustomRoutesWithPublicIp boolean,
   :importCustomRoutes boolean,
   :peerNetworkType string}
  
  Creates a new network peering between the peer network and VMware Engine network provided in a `NetworkPeering` resource. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/networkPeerings"
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

(defn locations-networkPeerings-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a `NetworkPeering` resource. When a network peering is deleted for a VMware Engine network, the peer network becomes inaccessible to that VMware Engine network. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPeerings-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :exportCustomRoutes boolean,
   :peerMtu integer,
   :importCustomRoutesWithPublicIp boolean,
   :peerNetwork string,
   :uid string,
   :name string,
   :exchangeSubnetRoutes boolean,
   :createTime string,
   :state string,
   :stateDetails string,
   :updateTime string,
   :vmwareEngineNetwork string,
   :exportCustomRoutesWithPublicIp boolean,
   :importCustomRoutes boolean,
   :peerNetworkType string}
  
  Modifies a `NetworkPeering` resource. Only the `description` field can be updated. Only fields specified in `updateMask` are applied. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-networkPeerings-peeringRoutes-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/networkPeerings/peeringRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the network peering routes exchanged over a peering connection. NetworkPeering is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/peeringRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareEngineNetworks-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/vmwareEngineNetworks/create
  
  Required parameters: parent
  
  Optional parameters: vmwareEngineNetworkId, requestId
  
  Body: 
  
  {:description string,
   :vpcNetworks [{:type string, :network string}],
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :etag string,
   :state string,
   :updateTime string}
  
  Creates a new VMware Engine network that can be used by a private cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/vmwareEngineNetworks"
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

(defn locations-vmwareEngineNetworks-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/vmwareEngineNetworks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :vpcNetworks [{:type string, :network string}],
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :etag string,
   :state string,
   :updateTime string}
  
  Modifies a VMware Engine network resource. Only the following fields can be updated: `description`. Only fields specified in `updateMask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-vmwareEngineNetworks-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/vmwareEngineNetworks/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag
  
  Deletes a `VmwareEngineNetwork` resource. You can only delete a VMware Engine network after all resources that refer to it are deleted. For example, a private cloud, a network peering, and a network policy can all refer to the same VMware Engine network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-vmwareEngineNetworks-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/vmwareEngineNetworks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `VmwareEngineNetwork` resource by its resource name. The resource contains details of the VMware Engine network, such as its VMware Engine network type, peered networks in a service project, and state (for example, `CREATING`, `ACTIVE`, `DELETING`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-vmwareEngineNetworks-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/vmwareEngineNetworks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `VmwareEngineNetwork` resources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/vmwareEngineNetworks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateConnections-create$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/create
  
  Required parameters: parent
  
  Optional parameters: privateConnectionId, requestId
  
  Body: 
  
  {:description string,
   :serviceNetwork string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :peeringId string,
   :updateTime string,
   :vmwareEngineNetworkCanonical string,
   :vmwareEngineNetwork string,
   :peeringState string,
   :routingMode string}
  
  Creates a new private connection that can be used for accessing private Clouds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/privateConnections"
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

(defn locations-privateConnections-get$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `PrivateConnection` resource by its resource name. The resource contains details of the private connection, such as connected network, routing mode and state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateConnections-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `PrivateConnection` resources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/privateConnections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateConnections-patch$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :serviceNetwork string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :peeringId string,
   :updateTime string,
   :vmwareEngineNetworkCanonical string,
   :vmwareEngineNetwork string,
   :peeringState string,
   :routingMode string}
  
  Modifies a `PrivateConnection` resource. Only `description` and `routing_mode` fields can be updated. Only fields specified in `updateMask` are applied."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateConnections-delete$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a `PrivateConnection` resource. When a private connection is deleted for a VMware Engine network, the connected network becomes inaccessible to that VMware Engine network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmwareengine.googleapis.com/"
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

(defn locations-privateConnections-peeringRoutes-list$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/privateConnections/peeringRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the private connection routes exchanged over a peering connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+parent}/peeringRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dnsBindPermission-grant$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/dnsBindPermission/grant
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:principal {:user string, :serviceAccount string}, :requestId string}
  
  Grants the bind permission to the customer provided principal(user / service account) to bind their DNS zone with the intranet VPC associated with the project. DnsBindPermission is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+name}:grant"
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

(defn locations-dnsBindPermission-revoke$
  "https://cloud.google.com/solutions/vmware-as-a-serviceapi/reference/rest/v1/projects/locations/dnsBindPermission/revoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:principal {:user string, :serviceAccount string}, :requestId string}
  
  Revokes the bind permission from the customer provided principal(user / service account) on the intranet VPC associated with the consumer project. DnsBindPermission is a global resource and location can only be global."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmwareengine.googleapis.com/"
     "v1/{+name}:revoke"
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
