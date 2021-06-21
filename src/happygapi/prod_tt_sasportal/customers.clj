(ns happygapi.prod_tt_sasportal.customers
  "SAS Portal API (Testing): customers.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Updates an existing customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of requested customers."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/customers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:allowedBillingModes [string],
   :frns [string],
   :displayName string,
   :name string,
   :sasUserIds [string],
   :defaultBillingMode string}
  
  Creates a new deployment."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
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

(defn deployments-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists deployments."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:allowedBillingModes [string],
   :frns [string],
   :displayName string,
   :name string,
   :sasUserIds [string],
   :defaultBillingMode string}
  
  Updates an existing deployment."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn deployments-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a deployment."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested deployment."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a deployment under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn deployments-devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:highFrequencyMhz number,
                           :lowFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {},
   :grants [{:expireTime string,
             :maxEirp number,
             :moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :grantId string,
             :suspensionReason [string],
             :channelType string,
             :state string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn deployments-devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/deployments/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encodedDevice string, :installerId string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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

(defn nodes-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :sasUserIds [string], :displayName string}
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
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

(defn nodes-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :sasUserIds [string], :displayName string}
  
  Updates an existing node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn nodes-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a node under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn nodes-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a requested node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-deployments-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists deployments."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-deployments-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/deployments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:allowedBillingModes [string],
   :frns [string],
   :displayName string,
   :name string,
   :sasUserIds [string],
   :defaultBillingMode string}
  
  Creates a new deployment."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/deployments"
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

(defn nodes-nodes-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/nodes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :sasUserIds [string], :displayName string}
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
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

(defn nodes-nodes-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/nodes/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:highFrequencyMhz number,
                           :lowFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {},
   :grants [{:expireTime string,
             :maxEirp number,
             :moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :grantId string,
             :suspensionReason [string],
             :channelType string,
             :state string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn nodes-devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encodedDevice string, :installerId string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:highFrequencyMhz number,
                           :lowFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {},
   :grants [{:expireTime string,
             :maxEirp number,
             :moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :grantId string,
             :suspensionReason [string],
             :channelType string,
             :state string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn devices-updateSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/updateSigned
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :encodedDevice string}
  
  Updates a signed device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:updateSigned"
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

(defn devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encodedDevice string, :installerId string}
  
  Creates a signed device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
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

(defn devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:serialNumber string,
   :activeConfig {:category string,
                  :installationParams SasPortalInstallationParams,
                  :state string,
                  :measurementCapabilities [string],
                  :updateTime string,
                  :callSign string,
                  :userId string,
                  :isSigned boolean,
                  :airInterface SasPortalDeviceAirInterface,
                  :model SasPortalDeviceModel},
   :grantRangeAllowlists [{:highFrequencyMhz number,
                           :lowFrequencyMhz number}],
   :displayName string,
   :name string,
   :state string,
   :deviceMetadata {},
   :grants [{:expireTime string,
             :maxEirp number,
             :moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :grantId string,
             :suspensionReason [string],
             :channelType string,
             :state string}],
   :preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :currentChannels [{:frequencyRange SasPortalFrequencyRange,
                      :score number}],
   :fccId string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
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

(defn devices-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string}
  
  Moves a device under another node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
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

(defn devices-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn devices-signDevice$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/signDevice
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:device {:serialNumber string,
            :activeConfig SasPortalDeviceConfig,
            :grantRangeAllowlists [SasPortalFrequencyRange],
            :displayName string,
            :name string,
            :state string,
            :deviceMetadata SasPortalDeviceMetadata,
            :grants [SasPortalDeviceGrant],
            :preloadedConfig SasPortalDeviceConfig,
            :currentChannels [SasPortalChannelWithScore],
            :fccId string}}
  
  Signs a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:signDevice"
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
