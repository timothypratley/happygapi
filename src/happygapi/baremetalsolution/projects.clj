(ns happygapi.baremetalsolution.projects
  "Bare Metal Solution API: projects.
  Provides ways to manage Bare Metal Solution hardware installed in a regional extension located near a Google Cloud data center.
  See: https://cloud.google.com/bare-metaldocs/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}/locations"
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
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sshKeys-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/sshKeys/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the public SSH keys registered for the specified project. These SSH keys are used only for the interactive serial console feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/sshKeys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sshKeys-create$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/sshKeys/create
  
  Required parameters: parent
  
  Optional parameters: sshKeyId
  
  Body: 
  
  {:name string, :publicKey string}
  
  Register a public SSH key in the specified project for use with the interactive serial console feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/sshKeys"
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

(defn locations-sshKeys-delete$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/sshKeys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a public SSH key registered in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List storage volumes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/volumes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a single storage volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-patch$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :autoGrownSizeGib string,
   :maxSizeGib string,
   :protocol string,
   :name string,
   :currentSizeGib string,
   :storageType string,
   :remainingSpaceGib string,
   :workloadProfile string,
   :state string,
   :bootVolume boolean,
   :performanceTier string,
   :pod string,
   :snapshotReservationDetail {:reservedSpaceGib string,
                               :reservedSpaceUsedPercent integer,
                               :reservedSpaceRemainingGib string,
                               :reservedSpacePercent integer},
   :instances [string],
   :snapshotAutoDeleteBehavior string,
   :id string,
   :notes string,
   :originallyRequestedSizeGib string,
   :emergencySizeGib string,
   :requestedSizeGib string,
   :expireTime string,
   :snapshotEnabled boolean,
   :attached boolean}
  
  Update details of a single storage volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
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

(defn locations-volumes-rename$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newVolumeId string}
  
  RenameVolume sets a new name for a volume. Use with caution, previous names become immediately invalidated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:rename"
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

(defn locations-volumes-evict$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/evict
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Skips volume's cooloff and deletes it now. Volume must be in cooloff state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:evict"
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

(defn locations-volumes-resize$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/resize
  
  Required parameters: volume
  
  Optional parameters: none
  
  Body: 
  
  {:sizeGib string}
  
  Emergency Volume resize."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:volume})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+volume}:resize"
     #{:volume}
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

(defn locations-volumes-snapshots-create$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/snapshots/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :id string,
   :description string,
   :createTime string,
   :storageVolume string,
   :type string}
  
  Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/snapshots"
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

(defn locations-volumes-snapshots-restoreVolumeSnapshot$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/snapshots/restoreVolumeSnapshot
  
  Required parameters: volumeSnapshot
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called for a non-boot volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:volumeSnapshot})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+volumeSnapshot}:restoreVolumeSnapshot"
     #{:volumeSnapshot}
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

(defn locations-volumes-snapshots-delete$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/snapshots/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-snapshots-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/snapshots/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-snapshots-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/snapshots/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves the list of snapshots for the specified volume. Returns a response with an empty list of snapshots if called for a non-boot volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/snapshots"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-luns-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/luns/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a single storage logical unit number(LUN)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-luns-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/luns/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List storage volume luns for given storage volume."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/luns"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-volumes-luns-evict$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/volumes/luns/evict
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Skips lun's cooloff and deletes it now. Lun must be in cooloff state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:evict"
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

(defn locations-networks-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/networks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List network in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/networks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networks-listNetworkUsage$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/networks/listNetworkUsage
  
  Required parameters: location
  
  Optional parameters: none
  
  List all Networks (and used IPs for each Network) in the vendor account associated with the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+location}/networks:listNetworkUsage"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networks-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/networks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a single network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-networks-patch$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/networks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:vlanId string,
   :labels {},
   :cidr string,
   :gatewayIp string,
   :mountPoints [{:instance string,
                  :logicalInterface string,
                  :defaultGateway boolean,
                  :ipAddress string}],
   :vrfAttachment string,
   :name string,
   :macAddress [string],
   :servicesCidr string,
   :type string,
   :state string,
   :vrf {:name string,
         :state string,
         :qosPolicy QosPolicy,
         :vlanAttachments [VlanAttachment]},
   :pod string,
   :id string,
   :ipAddress string,
   :reservations [{:startAddress string,
                   :endAddress string,
                   :note string}],
   :jumboFramesEnabled boolean}
  
  Update details of a single network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
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

(defn locations-networks-rename$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/networks/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newNetworkId string}
  
  RenameNetwork sets a new name for a network. Use with caution, previous names become immediately invalidated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:rename"
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

(defn locations-instances-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details about a single server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-patch$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :kmsKeyVersion string,
   :name string,
   :interactiveSerialConsoleEnabled boolean,
   :luns [{:wwid string,
           :storageVolume string,
           :bootLun boolean,
           :name string,
           :sizeGb string,
           :storageType string,
           :state string,
           :shareable boolean,
           :instances [string],
           :id string,
           :expireTime string,
           :multiprotocolType string}],
   :logicalInterfaces [{:logicalNetworkInterfaces [LogicalNetworkInterface],
                        :name string,
                        :interfaceIndex integer}],
   :sshKeys [string],
   :createTime string,
   :workloadProfile string,
   :state string,
   :networkTemplate string,
   :machineType string,
   :updateTime string,
   :volumes [{:labels {},
              :autoGrownSizeGib string,
              :maxSizeGib string,
              :protocol string,
              :name string,
              :currentSizeGib string,
              :storageType string,
              :remainingSpaceGib string,
              :workloadProfile string,
              :state string,
              :bootVolume boolean,
              :performanceTier string,
              :pod string,
              :snapshotReservationDetail SnapshotReservationDetail,
              :instances [string],
              :snapshotAutoDeleteBehavior string,
              :id string,
              :notes string,
              :originallyRequestedSizeGib string,
              :emergencySizeGib string,
              :requestedSizeGib string,
              :expireTime string,
              :snapshotEnabled boolean,
              :attached boolean}],
   :networks [{:vlanId string,
               :labels {},
               :cidr string,
               :gatewayIp string,
               :mountPoints [NetworkMountPoint],
               :vrfAttachment string,
               :name string,
               :macAddress [string],
               :servicesCidr string,
               :type string,
               :state string,
               :vrf VRF,
               :pod string,
               :id string,
               :ipAddress string,
               :reservations [NetworkAddressReservation],
               :jumboFramesEnabled boolean}],
   :pod string,
   :hyperthreadingEnabled boolean,
   :id string,
   :loginInfo string,
   :osImage string,
   :firmwareVersion string}
  
  Update details of a single server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
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

(defn locations-instances-reset$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then turning it back on."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:reset"
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

(defn locations-instances-loadAuthInfo$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/loadAuthInfo
  
  Required parameters: name
  
  Optional parameters: none
  
  Load auth info for a server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:loadAuthInfo"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-start$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a server that was shutdown."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:start"
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

(defn locations-instances-enableInteractiveSerialConsole$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/enableInteractiveSerialConsole
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enable the interactive serial console feature on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:enableInteractiveSerialConsole"
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

(defn locations-instances-disableHyperthreading$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/disableHyperthreading
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Perform disable hyperthreading operation on a single server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:disableHyperthreading"
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

(defn locations-instances-detachLun$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/detachLun
  
  Required parameters: instance
  
  Optional parameters: none
  
  Body: 
  
  {:lun string, :skipReboot boolean}
  
  Detach LUN from Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+instance}:detachLun"
     #{:instance}
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

(defn locations-instances-rename$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newInstanceId string}
  
  RenameInstance sets a new name for an instance. Use with caution, previous names become immediately invalidated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:rename"
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

(defn locations-instances-reimage$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/reimage
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:osImage string, :kmsKeyVersion string, :sshKeys [string]}
  
  Perform reimage operation on a single server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:reimage"
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

(defn locations-instances-stop$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stop a running server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:stop"
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

(defn locations-instances-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List servers in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-disableInteractiveSerialConsole$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/disableInteractiveSerialConsole
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disable the interactive serial console feature on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:disableInteractiveSerialConsole"
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

(defn locations-instances-enableHyperthreading$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/instances/enableHyperthreading
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Perform enable hyperthreading operation on a single server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:enableHyperthreading"
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

(defn locations-operations-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details about an operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-provisioningConfigs-submit$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/provisioningConfigs/submit
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:provisioningConfig {:customId string,
                        :email string,
                        :cloudConsoleUri string,
                        :name string,
                        :statusMessage string,
                        :state string,
                        :handoverServiceAccount string,
                        :updateTime string,
                        :volumes [VolumeConfig],
                        :vpcScEnabled boolean,
                        :networks [NetworkConfig],
                        :pod string,
                        :instances [InstanceConfig],
                        :ticketId string,
                        :location string},
   :email string}
  
  Submit a provisiong configuration for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/provisioningConfigs:submit"
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

(defn locations-provisioningConfigs-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/provisioningConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get ProvisioningConfig by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-provisioningConfigs-create$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/provisioningConfigs/create
  
  Required parameters: parent
  
  Optional parameters: email
  
  Body: 
  
  {:customId string,
   :email string,
   :cloudConsoleUri string,
   :name string,
   :statusMessage string,
   :state string,
   :handoverServiceAccount string,
   :updateTime string,
   :volumes [{:protocol string,
              :snapshotsEnabled boolean,
              :name string,
              :sizeGb integer,
              :type string,
              :performanceTier string,
              :nfsExports [NfsExport],
              :gcpService string,
              :machineIds [string],
              :userNote string,
              :id string,
              :lunRanges [LunRange]}],
   :vpcScEnabled boolean,
   :networks [{:vlanAttachments [IntakeVlanAttachment],
               :cidr string,
               :name string,
               :type string,
               :serviceCidr string,
               :vlanSameProject boolean,
               :bandwidth string,
               :gcpService string,
               :userNote string,
               :id string,
               :jumboFramesEnabled boolean}],
   :pod string,
   :instances [{:sshKeyNames [string],
                :accountNetworksEnabled boolean,
                :kmsKeyVersion string,
                :instanceType string,
                :name string,
                :logicalInterfaces [GoogleCloudBaremetalsolutionV2LogicalInterface],
                :networkTemplate string,
                :networkConfig string,
                :privateNetwork NetworkAddress,
                :userNote string,
                :id string,
                :hyperthreading boolean,
                :clientNetwork NetworkAddress,
                :osImage string}],
   :ticketId string,
   :location string}
  
  Create new ProvisioningConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/provisioningConfigs"
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

(defn locations-provisioningConfigs-patch$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/provisioningConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, email
  
  Body: 
  
  {:customId string,
   :email string,
   :cloudConsoleUri string,
   :name string,
   :statusMessage string,
   :state string,
   :handoverServiceAccount string,
   :updateTime string,
   :volumes [{:protocol string,
              :snapshotsEnabled boolean,
              :name string,
              :sizeGb integer,
              :type string,
              :performanceTier string,
              :nfsExports [NfsExport],
              :gcpService string,
              :machineIds [string],
              :userNote string,
              :id string,
              :lunRanges [LunRange]}],
   :vpcScEnabled boolean,
   :networks [{:vlanAttachments [IntakeVlanAttachment],
               :cidr string,
               :name string,
               :type string,
               :serviceCidr string,
               :vlanSameProject boolean,
               :bandwidth string,
               :gcpService string,
               :userNote string,
               :id string,
               :jumboFramesEnabled boolean}],
   :pod string,
   :instances [{:sshKeyNames [string],
                :accountNetworksEnabled boolean,
                :kmsKeyVersion string,
                :instanceType string,
                :name string,
                :logicalInterfaces [GoogleCloudBaremetalsolutionV2LogicalInterface],
                :networkTemplate string,
                :networkConfig string,
                :privateNetwork NetworkAddress,
                :userNote string,
                :id string,
                :hyperthreading boolean,
                :clientNetwork NetworkAddress,
                :osImage string}],
   :ticketId string,
   :location string}
  
  Update existing ProvisioningConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
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

(defn locations-osImages-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/osImages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves the list of OS images which are currently approved."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/osImages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-osImages-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/osImages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a single OS image."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-provisioningQuotas-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/provisioningQuotas/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the budget details to provision resources on a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/provisioningQuotas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nfsShares-get$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a single NFS share."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nfsShares-list$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List NFS shares."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/nfsShares"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nfsShares-patch$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :name string,
   :storageType string,
   :state string,
   :volume string,
   :nfsShareId string,
   :pod string,
   :id string,
   :requestedSizeGib string,
   :allowedClients [{:network string,
                     :shareIp string,
                     :allowedClientsCidr string,
                     :mountPermissions string,
                     :allowDev boolean,
                     :allowSuid boolean,
                     :noRootSquash boolean,
                     :nfsPath string}]}
  
  Update details of a single NFS share."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
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

(defn locations-nfsShares-create$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :name string,
   :storageType string,
   :state string,
   :volume string,
   :nfsShareId string,
   :pod string,
   :id string,
   :requestedSizeGib string,
   :allowedClients [{:network string,
                     :shareIp string,
                     :allowedClientsCidr string,
                     :mountPermissions string,
                     :allowDev boolean,
                     :allowSuid boolean,
                     :noRootSquash boolean,
                     :nfsPath string}]}
  
  Create an NFS share."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+parent}/nfsShares"
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

(defn locations-nfsShares-rename$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newNfsshareId string}
  
  RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become immediately invalidated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}:rename"
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

(defn locations-nfsShares-delete$
  "https://cloud.google.com/bare-metalapi/reference/rest/v2/projects/locations/nfsShares/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an NFS share. The underlying volume is automatically deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
