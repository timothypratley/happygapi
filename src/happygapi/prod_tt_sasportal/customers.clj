(ns happygapi.prod_tt_sasportal.customers
  "SAS Portal API (Testing): customers.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a requested customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  Returns a list of requested customers."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/customers"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Updates an existing customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets details about a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :state string,
   :name string,
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
   :grants [{:moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :channelType string,
             :maxEirp number,
             :expireTime string,
             :state string}],
   :fccId string,
   :serialNumber string,
   :displayName string}
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
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
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:updateSigned"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-bulk$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/bulk
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:csv string}
  
  Creates a device under a node or customer. Returned devices are unordered."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:bulk"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-createSigned$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/createSigned
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :encodedDevice string}
  
  Creates a signed device under a
  node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices:createSigned"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:preloadedConfig {:category string,
                     :installationParams SasPortalInstallationParams,
                     :state string,
                     :measurementCapabilities [string],
                     :updateTime string,
                     :callSign string,
                     :userId string,
                     :isSigned boolean,
                     :airInterface SasPortalDeviceAirInterface,
                     :model SasPortalDeviceModel},
   :state string,
   :name string,
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
   :grants [{:moveList [SasPortalDpaMoveList],
             :frequencyRange SasPortalFrequencyRange,
             :channelType string,
             :maxEirp number,
             :expireTime string,
             :state string}],
   :fccId string,
   :serialNumber string,
   :displayName string}
  
  Creates a device under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
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
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  Lists devices under a node or customer."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/devices"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn devices-signDevice$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/devices/signDevice
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:device {:preloadedConfig SasPortalDeviceConfig,
            :state string,
            :name string,
            :activeConfig SasPortalDeviceConfig,
            :grants [SasPortalDeviceGrant],
            :fccId string,
            :serialNumber string,
            :displayName string}}
  
  Signs a device."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:signDevice"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
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
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}:move"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-list$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-create$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Creates a new node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+parent}/nodes"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns a requested node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn nodes-patch$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/customers/nodes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :displayName string, :sasUserIds [string]}
  
  Updates an existing node."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
