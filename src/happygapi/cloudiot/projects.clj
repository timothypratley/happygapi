(ns happygapi.cloudiot.projects
  "Cloud IoT API
  Registers and manages IoT (Internet of Things) devices that connect to the Google Cloud Platform.
  
  See: https://cloud.google.com/iot"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn locations-registries-get$
  "Required parameters: name
  
  Gets a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn locations-registries-patch$
  "Required parameters: name
  
  Updates a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn locations-registries-create$
  "Required parameters: parent
  
  Creates a device registry that contains devices."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/registries"
     #{"parent"}
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

(defn locations-registries-bindDeviceToGateway$
  "Required parameters: parent
  
  Associates the device with the gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}:bindDeviceToGateway"
     #{"parent"}
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

(defn locations-registries-unbindDeviceFromGateway$
  "Required parameters: parent
  
  Deletes the association between the device and the gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}:unbindDeviceFromGateway"
     #{"parent"}
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

(defn locations-registries-delete$
  "Required parameters: name
  
  Deletes a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn locations-registries-list$
  "Required parameters: parent
  
  Lists device registries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/registries"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-groups-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn locations-registries-groups-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn locations-registries-groups-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn locations-registries-groups-devices-list$
  "Required parameters: parent
  
  List devices in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/devices"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-devices-create$
  "Required parameters: parent
  
  Creates a device in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/devices"
     #{"parent"}
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

(defn locations-registries-devices-modifyCloudToDeviceConfig$
  "Required parameters: name
  
  Modifies the configuration for the device, which is eventually sent from
  the Cloud IoT Core servers. Returns the modified configuration version and
  its metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}:modifyCloudToDeviceConfig"
     #{"name"}
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

(defn locations-registries-devices-sendCommandToDevice$
  "Required parameters: name
  
  Sends a command to the specified device. In order for a device to be able
  to receive commands, it must:
  1) be connected to Cloud IoT Core using the MQTT protocol, and
  2) be subscribed to the group of MQTT topics specified by
     /devices/{device-id}/commands/#. This subscription will receive commands
     at the top-level topic /devices/{device-id}/commands as well as commands
     for subfolders, like /devices/{device-id}/commands/subfolder.
     Note that subscribing to specific subfolders is not supported.
  If the command could not be delivered to the device, this method will
  return an error; in particular, if the device is not subscribed, this
  method will return FAILED_PRECONDITION. Otherwise, this method will
  return OK. If the subscription is QoS 1, at least once delivery will be
  guaranteed; for QoS 0, no acknowledgment will be expected from the device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}:sendCommandToDevice"
     #{"name"}
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

(defn locations-registries-devices-patch$
  "Required parameters: name
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-get$
  "Required parameters: name
  
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-delete$
  "Required parameters: name
  
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-list$
  "Required parameters: parent
  
  List devices in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/devices"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-devices-configVersions-list$
  "Required parameters: name
  
  Lists the last few versions of the device configuration in descending
  order (i.e.: newest first)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}/configVersions"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-devices-states-list$
  "Required parameters: name
  
  Lists the last few versions of the device state in descending order (i.e.:
  newest first)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}/states"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
