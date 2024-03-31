(ns happygapi.androiddeviceprovisioning.partners
  "Android Device Provisioning Partner API: partners.
  Automates Android zero-touch enrollment for device resellers, customers, and EMMs.
  See: https://developers.google.com/zero-touch/api/reference/rest/v1/partners"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn customers-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/customers/list
  
  Required parameters: partnerId
  
  Optional parameters: pageToken, pageSize
  
  Lists the customers that are enrolled to the reseller identified by the `partnerId` argument. This list includes customers that the reseller created and customers that enrolled themselves using the portal."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/customers"
     #{:partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customers-create$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/customers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customer {:companyId string,
              :skipWelcomeEmail boolean,
              :termsStatus string,
              :name string,
              :ownerEmails [string],
              :googleWorkspaceAccount GoogleWorkspaceAccount,
              :languageCode string,
              :companyName string,
              :adminEmails [string]}}
  
  Creates a customer for zero-touch enrollment. After the method returns successfully, admin and owner roles can manage devices and EMM configs by calling API methods or using their zero-touch enrollment portal. The customer receives an email that welcomes them to zero-touch enrollment and explains how to sign into the portal."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/customers"
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

(defn devices-get$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a device."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
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

(defn devices-findByOwner$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/findByOwner
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:sectionType string,
   :googleWorkspaceCustomerId [string],
   :pageToken string,
   :limit string,
   :customerId [string]}
  
  Finds devices claimed for customers. The results only contain devices registered to the reseller that's identified by the `partnerId` argument. The customer's devices purchased from other resellers don't appear in the results."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:findByOwner"
     #{:partnerId}
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

(defn devices-getSimLockState$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/getSimLockState
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:deviceIdentifier {:imei string,
                      :model string,
                      :meid string,
                      :deviceType string,
                      :chromeOsAttestedDeviceId string,
                      :manufacturer string,
                      :serialNumber string}}
  
  Gets a device's SIM lock state."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:getSimLockState"
     #{:partnerId}
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

(defn devices-findByIdentifier$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/findByIdentifier
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:deviceIdentifier {:imei string,
                      :model string,
                      :meid string,
                      :deviceType string,
                      :chromeOsAttestedDeviceId string,
                      :manufacturer string,
                      :serialNumber string},
   :limit string,
   :pageToken string}
  
  Finds devices by hardware identifiers, such as IMEI."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:findByIdentifier"
     #{:partnerId}
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

(defn devices-unclaim$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/unclaim
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:vacationModeExpireTime string,
   :vacationModeDays integer,
   :sectionType string,
   :deviceIdentifier {:imei string,
                      :model string,
                      :meid string,
                      :deviceType string,
                      :chromeOsAttestedDeviceId string,
                      :manufacturer string,
                      :serialNumber string},
   :deviceId string}
  
  Unclaims a device from a customer and removes it from zero-touch enrollment."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:unclaim"
     #{:partnerId}
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

(defn devices-claimAsync$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/claimAsync
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:claims [{:deviceMetadata DeviceMetadata,
             :configurationId string,
             :googleWorkspaceCustomerId string,
             :customerId string,
             :deviceIdentifier DeviceIdentifier,
             :simlockProfileId string,
             :sectionType string,
             :preProvisioningToken string}]}
  
  Claims a batch of devices for a customer asynchronously. Adds the devices to zero-touch enrollment. To learn more, read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations)."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:claimAsync"
     #{:partnerId}
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

(defn devices-updateMetadataAsync$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/updateMetadataAsync
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:updates [{:deviceIdentifier DeviceIdentifier,
              :deviceMetadata DeviceMetadata,
              :deviceId string}]}
  
  Updates the reseller metadata attached to a batch of devices. This method updates devices asynchronously and returns an `Operation` that can be used to track progress. Read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations). Android Devices only."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:updateMetadataAsync"
     #{:partnerId}
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

(defn devices-unclaimAsync$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/unclaimAsync
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:unclaims [{:vacationModeExpireTime string,
               :sectionType string,
               :deviceId string,
               :vacationModeDays integer,
               :deviceIdentifier DeviceIdentifier}]}
  
  Unclaims a batch of devices for a customer asynchronously. Removes the devices from zero-touch enrollment. To learn more, read [Long‑running batch operations](/zero-touch/guides/how-it-works#operations)."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:unclaimAsync"
     #{:partnerId}
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

(defn devices-metadata$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/metadata
  
  Required parameters: metadataOwnerId, deviceId
  
  Optional parameters: none
  
  Body: 
  
  {:deviceMetadata {:entries {}}}
  
  Updates reseller metadata associated with the device. Android devices only."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:deviceId :metadataOwnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+metadataOwnerId}/devices/{+deviceId}/metadata"
     #{:deviceId :metadataOwnerId}
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

(defn devices-claim$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/devices/claim
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:simlockProfileId string,
   :deviceIdentifier {:imei string,
                      :model string,
                      :meid string,
                      :deviceType string,
                      :chromeOsAttestedDeviceId string,
                      :manufacturer string,
                      :serialNumber string},
   :preProvisioningToken string,
   :configurationId string,
   :sectionType string,
   :deviceMetadata {:entries {}},
   :customerId string,
   :googleWorkspaceCustomerId string}
  
  Claims a device for a customer and adds it to zero-touch enrollment. If the device is already claimed by another customer, the call returns an error."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/partners/{+partnerId}/devices:claim"
     #{:partnerId}
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

(defn vendors-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/vendors/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the vendors of the partner."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/vendors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn vendors-customers-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/partners/vendors/customers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the customers of the vendor."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
