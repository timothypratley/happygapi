(ns happygapi.prod_tt_sasportal.deployments
  "SAS Portal API (Testing): deployments.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/get
  
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

(defn devices-delete$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/delete
  
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

(defn devices-signDevice$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/signDevice
  
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

(defn devices-move$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/move
  
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

(defn devices-get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/get
  
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
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/patch
  
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
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/deployments/devices/updateSigned
  
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
