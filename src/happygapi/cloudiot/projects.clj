(ns happygapi.cloudiot.projects
  "Cloud IoT API: projects.
  Registers and manages IoT (Internet of Things) devices that connect to the Google Cloud Platform. 
  See: https://cloud.google.com/iotapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-registries-get$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-setIamPolicy$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-patch$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :mqttConfig {:mqttEnabledState string},
   :httpConfig {:httpEnabledState string},
   :stateNotificationConfig {:pubsubTopicName string},
   :logLevel string,
   :eventNotificationConfigs [{:pubsubTopicName string,
                               :subfolderMatches string}],
   :id string,
   :credentials [{:publicKeyCertificate PublicKeyCertificate}]}
  
  Updates a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-testIamPermissions$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-create$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :mqttConfig {:mqttEnabledState string},
   :httpConfig {:httpEnabledState string},
   :stateNotificationConfig {:pubsubTopicName string},
   :logLevel string,
   :eventNotificationConfigs [{:pubsubTopicName string,
                               :subfolderMatches string}],
   :id string,
   :credentials [{:publicKeyCertificate PublicKeyCertificate}]}
  
  Creates a device registry that contains devices."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/registries"
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

(defn locations-registries-bindDeviceToGateway$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/bindDeviceToGateway
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deviceId string, :gatewayId string}
  
  Associates the device with the gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}:bindDeviceToGateway"
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

(defn locations-registries-unbindDeviceFromGateway$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/unbindDeviceFromGateway
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deviceId string, :gatewayId string}
  
  Deletes the association between the device and the gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}:unbindDeviceFromGateway"
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

(defn locations-registries-delete$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a device registry configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-getIamPolicy$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-registries-list$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists device registries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/registries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-groups-getIamPolicy$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/groups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-registries-groups-setIamPolicy$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/groups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-groups-testIamPermissions$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/groups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-groups-devices-list$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/groups/devices/list
  
  Required parameters: parent
  
  Optional parameters: fieldMask, gatewayListOptions.associationsGatewayId, gatewayListOptions.associationsDeviceId, pageToken, deviceNumIds, pageSize, deviceIds, gatewayListOptions.gatewayType
  
  List devices in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-create$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gatewayConfig {:gatewayType string,
                   :lastAccessedGatewayTime string,
                   :gatewayAuthMethod string,
                   :lastAccessedGatewayId string},
   :numId string,
   :lastConfigAckTime string,
   :lastHeartbeatTime string,
   :credentials [{:publicKey PublicKeyCredential,
                  :expirationTime string}],
   :config {:binaryData string,
            :version string,
            :cloudUpdateTime string,
            :deviceAckTime string},
   :lastConfigSendTime string,
   :name string,
   :lastStateTime string,
   :state {:binaryData string, :updateTime string},
   :lastErrorTime string,
   :id string,
   :lastEventTime string,
   :logLevel string,
   :lastErrorStatus {:message string, :details [{}], :code integer},
   :blocked boolean,
   :metadata {}}
  
  Creates a device in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+parent}/devices"
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

(defn locations-registries-devices-get$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/get
  
  Required parameters: name
  
  Optional parameters: fieldMask
  
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-delete$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-sendCommandToDevice$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/sendCommandToDevice
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:subfolder string, :binaryData string}
  
  Sends a command to the specified device. In order for a device to be able to receive commands, it must: 1) be connected to Cloud IoT Core using the MQTT protocol, and 2) be subscribed to the group of MQTT topics specified by /devices/{device-id}/commands/#. This subscription will receive commands at the top-level topic /devices/{device-id}/commands as well as commands for subfolders, like /devices/{device-id}/commands/subfolder. Note that subscribing to specific subfolders is not supported. If the command could not be delivered to the device, this method will return an error; in particular, if the device is not subscribed, this method will return FAILED_PRECONDITION. Otherwise, this method will return OK. If the subscription is QoS 1, at least once delivery will be guaranteed; for QoS 0, no acknowledgment will be expected from the device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}:sendCommandToDevice"
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

(defn locations-registries-devices-modifyCloudToDeviceConfig$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/modifyCloudToDeviceConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:versionToUpdate string, :binaryData string}
  
  Modifies the configuration for the device, which is eventually sent from the Cloud IoT Core servers. Returns the modified configuration version and its metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}:modifyCloudToDeviceConfig"
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

(defn locations-registries-devices-patch$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:gatewayConfig {:gatewayType string,
                   :lastAccessedGatewayTime string,
                   :gatewayAuthMethod string,
                   :lastAccessedGatewayId string},
   :numId string,
   :lastConfigAckTime string,
   :lastHeartbeatTime string,
   :credentials [{:publicKey PublicKeyCredential,
                  :expirationTime string}],
   :config {:binaryData string,
            :version string,
            :cloudUpdateTime string,
            :deviceAckTime string},
   :lastConfigSendTime string,
   :name string,
   :lastStateTime string,
   :state {:binaryData string, :updateTime string},
   :lastErrorTime string,
   :id string,
   :lastEventTime string,
   :logLevel string,
   :lastErrorStatus {:message string, :details [{}], :code integer},
   :blocked boolean,
   :metadata {}}
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-list$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/list
  
  Required parameters: parent
  
  Optional parameters: fieldMask, gatewayListOptions.associationsGatewayId, gatewayListOptions.associationsDeviceId, pageToken, deviceNumIds, pageSize, deviceIds, gatewayListOptions.gatewayType
  
  List devices in a device registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
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

(defn locations-registries-devices-configVersions-list$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/configVersions/list
  
  Required parameters: name
  
  Optional parameters: numVersions
  
  Lists the last few versions of the device configuration in descending order (i.e.: newest first)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}/configVersions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registries-devices-states-list$
  "https://cloud.google.com/iotapi/reference/rest/v1/projects/locations/registries/devices/states/list
  
  Required parameters: name
  
  Optional parameters: numStates
  
  Lists the last few versions of the device state in descending order (i.e.: newest first)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudiot"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudiot.googleapis.com/"
     "v1/{+name}/states"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
