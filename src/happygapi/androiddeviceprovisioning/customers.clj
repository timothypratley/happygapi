(ns happygapi.androiddeviceprovisioning.customers
  "Android Device Provisioning Partner API: customers.
  Automates Android zero-touch enrollment for device resellers, customers, and EMMs.
  See: https://developers.google.com/zero-touch/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists the user's customer accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/customers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-removeConfiguration$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/devices/removeConfiguration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:device {:deviceIdentifier DeviceIdentifier, :deviceId string}}
  
  Removes a configuration from device."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/devices:removeConfiguration"
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

(defn devices-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists a customer's devices."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-unclaim$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/devices/unclaim
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:device {:deviceIdentifier DeviceIdentifier, :deviceId string}}
  
  Unclaims a device from a customer and removes it from zero-touch enrollment. After removing a device, a customer must contact their reseller to register the device into zero-touch enrollment again."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/devices:unclaim"
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

(defn devices-applyConfiguration$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/devices/applyConfiguration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:configuration string,
   :device {:deviceIdentifier DeviceIdentifier, :deviceId string}}
  
  Applies a Configuration to the device to register the device for zero-touch enrollment. After applying a configuration to a device, the device automatically provisions itself on first boot, or next factory reset."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/devices:applyConfiguration"
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
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a device."
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

(defn dpcs-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/dpcs/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the DPCs (device policy controllers) that support zero-touch enrollment."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/dpcs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-list$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/configurations/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists a customer's configurations."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/configurations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-patch$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/configurations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:isDefault boolean,
   :configurationName string,
   :dpcExtras string,
   :name string,
   :customMessage string,
   :contactEmail string,
   :configurationId string,
   :companyName string,
   :dpcResourcePath string,
   :contactPhone string}
  
  Updates a configuration's field values."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
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

(defn configurations-delete$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/configurations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an unused configuration. The API call fails if the customer has devices with the configuration applied."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
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

(defn configurations-get$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/configurations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a configuration."
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

(defn configurations-create$
  "https://developers.google.com/zero-touch/api/reference/rest/v1/customers/configurations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:isDefault boolean,
   :configurationName string,
   :dpcExtras string,
   :name string,
   :customMessage string,
   :contactEmail string,
   :configurationId string,
   :companyName string,
   :dpcResourcePath string,
   :contactPhone string}
  
  Creates a new configuration. Once created, a customer can apply the configuration to devices."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androiddeviceprovisioning.googleapis.com/"
     "v1/{+parent}/configurations"
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
