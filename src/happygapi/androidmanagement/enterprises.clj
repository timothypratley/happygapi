(ns happygapi.androidmanagement.enterprises
  "Android Management API: enterprises.
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/managementdocs/reference/rest/v1/enterprises"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/create
  
  Required parameters: none
  
  Optional parameters: projectId, signupUrlName, enterpriseToken, agreementAccepted
  
  Body: 
  
  {:contactInfo {:contactEmail string,
                 :dataProtectionOfficerName string,
                 :dataProtectionOfficerEmail string,
                 :dataProtectionOfficerPhone string,
                 :euRepresentativeName string,
                 :euRepresentativeEmail string,
                 :euRepresentativePhone string},
   :enabledNotificationTypes [string],
   :enterpriseDisplayName string,
   :logo {:url string, :sha256Hash string},
   :name string,
   :pubsubTopic string,
   :primaryColor integer,
   :termsAndConditions [{:header UserFacingMessage,
                         :content UserFacingMessage}],
   :appAutoApprovalEnabled boolean,
   :signinDetails [{:signinUrl string,
                    :signinEnrollmentToken string,
                    :qrCode string,
                    :allowPersonalUsage string,
                    :tokenTag string}]}
  
  Creates an enterprise. This is the last step in the enterprise signup flow. See also: SigninDetail"
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/enterprises"
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

(defn delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes an enterprise and all accounts and data associated with it. Warning: this will result in a cascaded deletion of all AM API devices associated with the deleted enterprise. Only available for EMM-managed enterprises."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:contactInfo {:contactEmail string,
                 :dataProtectionOfficerName string,
                 :dataProtectionOfficerEmail string,
                 :dataProtectionOfficerPhone string,
                 :euRepresentativeName string,
                 :euRepresentativeEmail string,
                 :euRepresentativePhone string},
   :enabledNotificationTypes [string],
   :enterpriseDisplayName string,
   :logo {:url string, :sha256Hash string},
   :name string,
   :pubsubTopic string,
   :primaryColor integer,
   :termsAndConditions [{:header UserFacingMessage,
                         :content UserFacingMessage}],
   :appAutoApprovalEnabled boolean,
   :signinDetails [{:signinUrl string,
                    :signinEnrollmentToken string,
                    :qrCode string,
                    :allowPersonalUsage string,
                    :tokenTag string}]}
  
  Updates an enterprise. See also: SigninDetail"
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/list
  
  Required parameters: none
  
  Optional parameters: projectId, pageSize, pageToken, view
  
  Lists EMM-managed enterprises. Only BASIC fields are returned."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/enterprises"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn enrollmentTokens-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/enrollmentTokens/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:expirationTimestamp string,
   :oneTimeOnly boolean,
   :additionalData string,
   :name string,
   :value string,
   :duration string,
   :qrCode string,
   :user {:accountIdentifier string},
   :policyName string,
   :allowPersonalUsage string}
  
  Creates an enrollment token for a given enterprise. It's up to the caller's responsibility to manage the lifecycle of newly created tokens and deleting them when they're not intended to be used anymore. Once an enrollment token has been created, it's not possible to retrieve the token's content anymore using AM API. It is recommended for EMMs to securely store the token if it's intended to be reused."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/enrollmentTokens"
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

(defn enrollmentTokens-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/enrollmentTokens/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an enrollment token. This operation invalidates the token, preventing its future use."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn enrollmentTokens-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/enrollmentTokens/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an active, unexpired enrollment token. Only a partial view of EnrollmentToken is returned: all the fields but name and expiration_timestamp are empty. This method is meant to help manage active enrollment tokens lifecycle. For security reasons, it's recommended to delete active enrollment tokens as soon as they're not intended to be used anymore."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn enrollmentTokens-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/enrollmentTokens/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists active, unexpired enrollment tokens for a given enterprise. The list items contain only a partial view of EnrollmentToken: all the fields but name and expiration_timestamp are empty. This method is meant to help manage active enrollment tokens lifecycle. For security reasons, it's recommended to delete active enrollment tokens as soon as they're not intended to be used anymore."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/enrollmentTokens"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webTokens-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webTokens/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :value string,
   :permissions [string],
   :parentFrameUrl string,
   :enabledFeatures [string]}
  
  Creates a web token to access an embeddable managed Google Play web UI for a given enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/webTokens"
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
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a device. Deleted devices will respond with a 404 error."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists devices for a given enterprise. Deleted devices are not returned in the response."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:dpcMigrationInfo {:previousDpc string, :additionalData string},
   :previousDeviceNames [string],
   :appliedState string,
   :memoryInfo {:totalRam string, :totalInternalStorage string},
   :networkInfo {:imei string,
                 :meid string,
                 :wifiMacAddress string,
                 :networkOperatorName string,
                 :telephonyInfos [TelephonyInfo]},
   :softwareInfo {:systemUpdateInfo SystemUpdateInfo,
                  :deviceKernelVersion string,
                  :androidBuildNumber string,
                  :androidDevicePolicyVersionName string,
                  :securityPatchLevel string,
                  :bootloaderVersion string,
                  :androidVersion string,
                  :deviceBuildSignature string,
                  :androidBuildTime string,
                  :androidDevicePolicyVersionCode integer,
                  :primaryLanguageCode string},
   :policyCompliant boolean,
   :name string,
   :lastStatusReportTime string,
   :systemProperties {},
   :state string,
   :apiLevel integer,
   :enrollmentTokenName string,
   :memoryEvents [{:eventType string,
                   :createTime string,
                   :byteCount string}],
   :appliedPasswordPolicies [{:requirePasswordUnlock string,
                              :unifiedLockSettings string,
                              :passwordScope string,
                              :passwordQuality string,
                              :passwordMinimumNumeric integer,
                              :passwordMinimumSymbols integer,
                              :passwordMinimumUpperCase integer,
                              :maximumFailedPasswordsForWipe integer,
                              :passwordMinimumLength integer,
                              :passwordMinimumNonLetter integer,
                              :passwordExpirationTimeout string,
                              :passwordHistoryLength integer,
                              :passwordMinimumLetters integer,
                              :passwordMinimumLowerCase integer}],
   :commonCriteriaModeInfo {:commonCriteriaModeStatus string},
   :hardwareStatusSamples [{:createTime string,
                            :batteryTemperatures [number],
                            :cpuTemperatures [number],
                            :gpuTemperatures [number],
                            :skinTemperatures [number],
                            :fanSpeeds [number],
                            :cpuUsages [number]}],
   :enrollmentTokenData string,
   :enrollmentTime string,
   :managementMode string,
   :lastPolicyComplianceReportTime string,
   :ownership string,
   :appliedPolicyName string,
   :securityPosture {:devicePosture string,
                     :postureDetails [PostureDetail]},
   :powerManagementEvents [{:eventType string,
                            :createTime string,
                            :batteryLevel number}],
   :lastPolicySyncTime string,
   :deviceSettings {:isDeviceSecure boolean,
                    :unknownSourcesEnabled boolean,
                    :developmentSettingsEnabled boolean,
                    :adbEnabled boolean,
                    :isEncrypted boolean,
                    :encryptionStatus string,
                    :verifyAppsEnabled boolean},
   :hardwareInfo {:serialNumber string,
                  :enterpriseSpecificId string,
                  :skinShutdownTemperatures [number],
                  :batteryThrottlingTemperatures [number],
                  :hardware string,
                  :brand string,
                  :deviceBasebandVersion string,
                  :gpuShutdownTemperatures [number],
                  :manufacturer string,
                  :skinThrottlingTemperatures [number],
                  :batteryShutdownTemperatures [number],
                  :cpuShutdownTemperatures [number],
                  :gpuThrottlingTemperatures [number],
                  :model string,
                  :cpuThrottlingTemperatures [number]},
   :user {:accountIdentifier string},
   :displays [{:name string,
               :displayId integer,
               :refreshRate integer,
               :state string,
               :width integer,
               :height integer,
               :density integer}],
   :disabledReason {:localizedMessages {}, :defaultMessage string},
   :userName string,
   :policyName string,
   :appliedPolicyVersion string,
   :nonComplianceDetails [{:settingName string,
                           :nonComplianceReason string,
                           :packageName string,
                           :fieldPath string,
                           :currentValue any,
                           :installationFailureReason string,
                           :specificNonComplianceReason string,
                           :specificNonComplianceContext SpecificNonComplianceContext}],
   :applicationReports [{:packageName string,
                         :packageSha256Hash string,
                         :displayName string,
                         :events [ApplicationEvent],
                         :installerPackageName string,
                         :state string,
                         :userFacingType string,
                         :versionName string,
                         :versionCode integer,
                         :keyedAppStates [KeyedAppState],
                         :applicationSource string,
                         :signingKeyCertFingerprints [string]}]}
  
  Updates a device."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/delete
  
  Required parameters: name
  
  Optional parameters: wipeDataFlags, wipeReasonMessage
  
  Deletes a device. This operation wipes the device. Deleted devices do not show up in enterprises.devices.list calls and a 404 is returned from enterprises.devices.get."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-issueCommand$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/issueCommand
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:startLostModeStatus {:status string},
   :errorCode string,
   :stopLostModeParams {},
   :createTime string,
   :type string,
   :stopLostModeStatus {:status string},
   :duration string,
   :resetPasswordFlags [string],
   :clearAppsDataParams {:packageNames [string]},
   :clearAppsDataStatus {:results {}},
   :newPassword string,
   :userName string,
   :startLostModeParams {:lostMessage UserFacingMessage,
                         :lostPhoneNumber UserFacingMessage,
                         :lostEmailAddress string,
                         :lostStreetAddress UserFacingMessage,
                         :lostOrganization UserFacingMessage}}
  
  Issues a command to a device. The Operation resource returned contains a Command in its metadata field. Use the get operation method to get the status of the command."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+name}:issueCommand"
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

(defn devices-operations-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-operations-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn devices-operations-cancel$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn policies-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/policies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a policy."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn policies-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/policies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists policies for a given enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/policies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn policies-patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/policies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:outgoingBeamDisabled boolean,
   :openNetworkConfiguration {},
   :debuggingFeaturesAllowed boolean,
   :kioskCustomLauncherEnabled boolean,
   :kioskCustomization {:powerButtonActions string,
                        :systemErrorWarnings string,
                        :systemNavigation string,
                        :statusBar string,
                        :deviceSettings string},
   :wifiConfigDisabled boolean,
   :skipFirstUseHintsEnabled boolean,
   :statusBarDisabled boolean,
   :recommendedGlobalProxy {:host string,
                            :port integer,
                            :excludedHosts [string],
                            :pacUri string},
   :cameraAccess string,
   :blockApplicationsEnabled boolean,
   :alwaysOnVpnPackage {:packageName string, :lockdownEnabled boolean},
   :bluetoothConfigDisabled boolean,
   :applications [{:installType string,
                   :packageName string,
                   :managedConfiguration {},
                   :credentialProviderPolicy string,
                   :disabled boolean,
                   :managedConfigurationTemplate ManagedConfigurationTemplate,
                   :lockTaskAllowed boolean,
                   :installConstraint [InstallConstraint],
                   :delegatedScopes [string],
                   :accessibleTrackIds [string],
                   :minimumVersionCode integer,
                   :extensionConfig ExtensionConfig,
                   :workProfileWidgets string,
                   :alwaysOnVpnLockdownExemption string,
                   :defaultPermissionPolicy string,
                   :permissionGrants [PermissionGrant],
                   :connectedWorkAndPersonalApp string,
                   :autoUpdateMode string,
                   :installPriority integer}],
   :mountPhysicalMediaDisabled boolean,
   :stayOnPluggedModes [string],
   :microphoneAccess string,
   :dataRoamingDisabled boolean,
   :maximumTimeToLock string,
   :screenCaptureDisabled boolean,
   :encryptionPolicy string,
   :keyguardDisabled boolean,
   :unmuteMicrophoneDisabled boolean,
   :deviceConnectivityManagement {:usbDataAccess string,
                                  :configureWifi string,
                                  :wifiDirectSettings string,
                                  :tetheringSettings string,
                                  :wifiSsidPolicy WifiSsidPolicy},
   :name string,
   :passwordRequirements {:requirePasswordUnlock string,
                          :unifiedLockSettings string,
                          :passwordScope string,
                          :passwordQuality string,
                          :passwordMinimumNumeric integer,
                          :passwordMinimumSymbols integer,
                          :passwordMinimumUpperCase integer,
                          :maximumFailedPasswordsForWipe integer,
                          :passwordMinimumLength integer,
                          :passwordMinimumNonLetter integer,
                          :passwordExpirationTimeout string,
                          :passwordHistoryLength integer,
                          :passwordMinimumLetters integer,
                          :passwordMinimumLowerCase integer},
   :factoryResetDisabled boolean,
   :preferentialNetworkService string,
   :permittedInputMethods {:packageNames [string]},
   :androidDevicePolicyTracks [string],
   :installUnknownSourcesAllowed boolean,
   :minimumApiLevel integer,
   :credentialsConfigDisabled boolean,
   :ensureVerifyAppsEnabled boolean,
   :networkEscapeHatchEnabled boolean,
   :keyguardDisabledFeatures [string],
   :credentialProviderPolicyDefault string,
   :cameraDisabled boolean,
   :deviceOwnerLockScreenInfo {:localizedMessages {},
                               :defaultMessage string},
   :printingPolicy string,
   :safeBootDisabled boolean,
   :autoTimeRequired boolean,
   :playStoreMode string,
   :shareLocationDisabled boolean,
   :permittedAccessibilityServices {:packageNames [string]},
   :bluetoothDisabled boolean,
   :setupActions [{:launchApp LaunchAppAction,
                   :title UserFacingMessage,
                   :description UserFacingMessage}],
   :personalUsagePolicies {:cameraDisabled boolean,
                           :screenCaptureDisabled boolean,
                           :accountTypesWithManagementDisabled [string],
                           :maxDaysWithWorkOff integer,
                           :personalPlayStoreMode string,
                           :personalApplications [PersonalApplicationPolicy]},
   :installAppsDisabled boolean,
   :frpAdminEmails [string],
   :passwordPolicies [{:requirePasswordUnlock string,
                       :unifiedLockSettings string,
                       :passwordScope string,
                       :passwordQuality string,
                       :passwordMinimumNumeric integer,
                       :passwordMinimumSymbols integer,
                       :passwordMinimumUpperCase integer,
                       :maximumFailedPasswordsForWipe integer,
                       :passwordMinimumLength integer,
                       :passwordMinimumNonLetter integer,
                       :passwordExpirationTimeout string,
                       :passwordHistoryLength integer,
                       :passwordMinimumLetters integer,
                       :passwordMinimumLowerCase integer}],
   :accountTypesWithManagementDisabled [string],
   :adjustVolumeDisabled boolean,
   :smsDisabled boolean,
   :usbMassStorageEnabled boolean,
   :setWallpaperDisabled boolean,
   :removeUserDisabled boolean,
   :deviceRadioState {:wifiState string,
                      :airplaneModeState string,
                      :ultraWidebandState string,
                      :cellularTwoGState string,
                      :minimumWifiSecurityLevel string},
   :networkResetDisabled boolean,
   :appAutoUpdatePolicy string,
   :shortSupportMessage {:localizedMessages {}, :defaultMessage string},
   :tetheringConfigDisabled boolean,
   :usbFileTransferDisabled boolean,
   :oncCertificateProviders [{:contentProviderEndpoint ContentProviderEndpoint,
                              :certificateReferences [string]}],
   :crossProfilePolicies {:showWorkContactsInPersonalProfile string,
                          :crossProfileCopyPaste string,
                          :crossProfileDataSharing string,
                          :workProfileWidgetsDefault string,
                          :exemptionsToShowWorkContactsInPersonalProfile PackageNameList},
   :cellBroadcastsConfigDisabled boolean,
   :defaultPermissionPolicy string,
   :choosePrivateKeyRules [{:urlPattern string,
                            :packageNames [string],
                            :privateKeyAlias string}],
   :permissionGrants [{:permission string, :policy string}],
   :outgoingCallsDisabled boolean,
   :vpnConfigDisabled boolean,
   :bluetoothContactSharingDisabled boolean,
   :statusReportingSettings {:commonCriteriaModeEnabled boolean,
                             :systemPropertiesEnabled boolean,
                             :powerManagementEventsEnabled boolean,
                             :memoryInfoEnabled boolean,
                             :applicationReportsEnabled boolean,
                             :applicationReportingSettings ApplicationReportingSettings,
                             :networkInfoEnabled boolean,
                             :deviceSettingsEnabled boolean,
                             :hardwareStatusEnabled boolean,
                             :displayInfoEnabled boolean,
                             :softwareInfoEnabled boolean},
   :modifyAccountsDisabled boolean,
   :addUserDisabled boolean,
   :createWindowsDisabled boolean,
   :version string,
   :locationMode string,
   :systemUpdate {:type string,
                  :startMinutes integer,
                  :endMinutes integer,
                  :freezePeriods [FreezePeriod]},
   :policyEnforcementRules [{:settingName string,
                             :blockAction BlockAction,
                             :wipeAction WipeAction}],
   :uninstallAppsDisabled boolean,
   :advancedSecurityOverrides {:untrustedAppsPolicy string,
                               :googlePlayProtectVerifyApps string,
                               :developerSettings string,
                               :commonCriteriaMode string,
                               :personalAppsThatCanReadWorkNotifications [string],
                               :mtePolicy string},
   :setUserIconDisabled boolean,
   :autoDateAndTimeZone string,
   :usageLog {:enabledLogTypes [string],
              :uploadOnCellularAllowed [string]},
   :longSupportMessage {:localizedMessages {}, :defaultMessage string},
   :persistentPreferredActivities [{:receiverActivity string,
                                    :actions [string],
                                    :categories [string]}],
   :mobileNetworksConfigDisabled boolean,
   :funDisabled boolean,
   :complianceRules [{:nonComplianceDetailCondition NonComplianceDetailCondition,
                      :apiLevelCondition ApiLevelCondition,
                      :disableApps boolean,
                      :packageNamesToDisable [string]}],
   :wifiConfigsLockdownEnabled boolean,
   :privateKeySelectionEnabled boolean}
  
  Updates or creates a policy."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn policies-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/policies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a policy. This operation is only permitted if no devices are currently referencing the policy."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn applications-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/applications/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Gets info about an application."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn webApps-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :title string,
   :startUrl string,
   :icons [{:imageData string}],
   :displayMode string,
   :versionCode string}
  
  Creates a web app."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/webApps"
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

(defn webApps-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a web app."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn webApps-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists web apps for a given enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/webApps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn webApps-patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :title string,
   :startUrl string,
   :icons [{:imageData string}],
   :displayMode string,
   :versionCode string}
  
  Updates a web app."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn webApps-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a web app."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn migrationTokens-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/migrationTokens/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:additionalData string,
   :deviceId string,
   :name string,
   :value string,
   :createTime string,
   :policy string,
   :managementMode string,
   :ttl string,
   :userId string,
   :expireTime string,
   :device string}
  
  Creates a migration token, to migrate an existing device from being managed by the EMM's Device Policy Controller (DPC) to being managed by the Android Management API. See the guide (https://developers.google.com/android/management/dpc-migration) for more details."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/migrationTokens"
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

(defn migrationTokens-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/migrationTokens/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a migration token."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
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

(defn migrationTokens-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/migrationTokens/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists migration tokens."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+parent}/migrationTokens"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
