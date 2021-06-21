(ns happygapi.cloudidentity.devices
  "Cloud Identity API: devices.
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/api/reference/rest/v1/devices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/get
  
  Required parameters: name
  
  Optional parameters: customer
  
  Retrieves the specified device."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/delete
  
  Required parameters: name
  
  Optional parameters: customer
  
  Deletes the specified device."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn list$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/list
  
  Required parameters: none
  
  Optional parameters: view, orderBy, pageSize, customer, filter, pageToken
  
  Lists/Searches devices."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/devices"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/create
  
  Required parameters: none
  
  Optional parameters: customer
  
  Body: 
  
  {:networkOperator string,
   :otherAccounts [string],
   :releaseVersion string,
   :serialNumber string,
   :enabledUsbDebugging boolean,
   :name string,
   :bootloaderVersion string,
   :ownerType string,
   :meid string,
   :createTime string,
   :buildNumber string,
   :brand string,
   :kernelVersion string,
   :compromisedState string,
   :imei string,
   :basebandVersion string,
   :wifiMacAddresses [string],
   :securityPatchTime string,
   :lastSyncTime string,
   :deviceType string,
   :encryptionState string,
   :osVersion string,
   :manufacturer string,
   :androidSpecificAttributes {:supportsWorkProfile boolean,
                               :enabledUnknownSources boolean,
                               :ownershipPrivilege string,
                               :ownerProfileAccount boolean},
   :enabledDeveloperOptions boolean,
   :assetTag string,
   :managementState string,
   :model string}
  
  Creates a device. Only company-owned device may be created. **Note**: This method is available only to customers who have one of the following SKUs: Enterprise Standard, Enterprise Plus, Enterprise for Education, and Cloud Identity Premium"
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/devices"
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

(defn cancelWipe$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/cancelWipe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Cancels an unfinished device wipe. This operation can be used to cancel device wipe in the gap between the wipe operation returning success and the device being wiped. This operation is possible when the device is in a \"pending wipe\" state. The device enters the \"pending wipe\" state when a wipe device command is issued, but has not yet been sent to the device. The cancel wipe will fail if the wipe command has already been issued to the device."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:cancelWipe"
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

(defn wipe$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/wipe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Wipes all data on the specified device."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:wipe"
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

(defn deviceUsers-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, customer, filter, pageToken, orderBy
  
  Lists/Searches DeviceUsers."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/deviceUsers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceUsers-block$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/block
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Blocks device from accessing user data"
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:block"
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

(defn deviceUsers-lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/lookup
  
  Required parameters: parent
  
  Optional parameters: rawResourceId, androidId, pageToken, pageSize, userId
  
  Looks up resource names of the DeviceUsers associated with the caller's credentials, as well as the properties provided in the request. This method must be called with end-user credentials with the scope: https://www.googleapis.com/auth/cloud-identity.devices.lookup If multiple properties are provided, only DeviceUsers having all of these properties are considered as matches - i.e. the query behaves like an AND. Different platforms require different amounts of information from the caller to ensure that the DeviceUser is uniquely identified. - iOS: No properties need to be passed, the caller's credentials are sufficient to identify the corresponding DeviceUser. - Android: Specifying the 'android_id' field is required. - Desktop: Specifying the 'raw_resource_id' field is required."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.devices.lookup"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}:lookup"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceUsers-cancelWipe$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/cancelWipe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Cancels an unfinished user account wipe. This operation can be used to cancel device wipe in the gap between the wipe operation returning success and the device being wiped."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:cancelWipe"
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

(defn deviceUsers-approve$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/approve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Approves device to access user data."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:approve"
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

(defn deviceUsers-delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/delete
  
  Required parameters: name
  
  Optional parameters: customer
  
  Deletes the specified DeviceUser. This also revokes the user's access to device data."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn deviceUsers-wipe$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/wipe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:customer string}
  
  Wipes the user's account on a device. Other data on the device that is not associated with the user's work account is not affected. For example, if a Gmail app is installed on a device that is used for personal and work purposes, and the user is logged in to the Gmail app with their personal account as well as their work account, wiping the \"deviceUser\" by their work administrator will not affect their personal account within Gmail or other apps such as Photos."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:wipe"
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

(defn deviceUsers-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/get
  
  Required parameters: name
  
  Optional parameters: customer
  
  Retrieves the specified DeviceUser"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn deviceUsers-clientStates-patch$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/clientStates/patch
  
  Required parameters: name
  
  Optional parameters: customer, updateMask
  
  Body: 
  
  {:scoreReason string,
   :assetTags [string],
   :customId string,
   :healthScore string,
   :name string,
   :ownerType string,
   :createTime string,
   :etag string,
   :lastUpdateTime string,
   :managed string,
   :complianceState string,
   :keyValuePairs {}}
  
  Updates the client state for the device user **Note**: This method is available only to customers who have one of the following SKUs: Enterprise Standard, Enterprise Plus, Enterprise for Education, and Cloud Identity Premium"
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn deviceUsers-clientStates-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/clientStates/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, customer, filter
  
  Lists the client states for the given search query."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/clientStates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceUsers-clientStates-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/devices/deviceUsers/clientStates/get
  
  Required parameters: name
  
  Optional parameters: customer
  
  Gets the client state for the device user"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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
