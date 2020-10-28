(ns happygapi.androidmanagement.enterprises
  "Android Management API: enterprises.
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/managementapi/reference/rest/v1/enterprises"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/create
  
  Required parameters: none
  
  Optional parameters: projectId, signupUrlName, enterpriseToken
  
  Body: 
  
  {:enabledNotificationTypes [string],
   :enterpriseDisplayName string,
   :logo {:url string, :sha256Hash string},
   :name string,
   :pubsubTopic string,
   :primaryColor integer,
   :termsAndConditions [{:header UserFacingMessage,
                         :content UserFacingMessage}],
   :appAutoApprovalEnabled boolean,
   :signinDetails [{:signinEnrollmentToken string,
                    :qrCode string,
                    :signinUrl string,
                    :allowPersonalUsage string}]}
  
  Creates an enterprise. This is the last step in the enterprise signup flow."
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

(defn patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:enabledNotificationTypes [string],
   :enterpriseDisplayName string,
   :logo {:url string, :sha256Hash string},
   :name string,
   :pubsubTopic string,
   :primaryColor integer,
   :termsAndConditions [{:header UserFacingMessage,
                         :content UserFacingMessage}],
   :appAutoApprovalEnabled boolean,
   :signinDetails [{:signinEnrollmentToken string,
                    :qrCode string,
                    :signinUrl string,
                    :allowPersonalUsage string}]}
  
  Updates an enterprise."
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
  
  Optional parameters: pageToken, pageSize
  
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
   :kioskCustomization {:deviceSettings string,
                        :statusBar string,
                        :systemNavigation string,
                        :systemErrorWarnings string,
                        :powerButtonActions string},
   :wifiConfigDisabled boolean,
   :skipFirstUseHintsEnabled boolean,
   :statusBarDisabled boolean,
   :recommendedGlobalProxy {:pacUri string,
                            :host string,
                            :port integer,
                            :excludedHosts [string]},
   :blockApplicationsEnabled boolean,
   :alwaysOnVpnPackage {:lockdownEnabled boolean, :packageName string},
   :bluetoothConfigDisabled boolean,
   :applications [{:installType string,
                   :packageName string,
                   :managedConfiguration {},
                   :disabled boolean,
                   :managedConfigurationTemplate ManagedConfigurationTemplate,
                   :lockTaskAllowed boolean,
                   :delegatedScopes [string],
                   :accessibleTrackIds [string],
                   :minimumVersionCode integer,
                   :defaultPermissionPolicy string,
                   :permissionGrants [PermissionGrant],
                   :connectedWorkAndPersonalApp string}],
   :mountPhysicalMediaDisabled boolean,
   :stayOnPluggedModes [string],
   :dataRoamingDisabled boolean,
   :maximumTimeToLock string,
   :screenCaptureDisabled boolean,
   :encryptionPolicy string,
   :keyguardDisabled boolean,
   :unmuteMicrophoneDisabled boolean,
   :name string,
   :passwordRequirements {:requirePasswordUnlock string,
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
   :permittedInputMethods {:packageNames [string]},
   :androidDevicePolicyTracks [string],
   :installUnknownSourcesAllowed boolean,
   :minimumApiLevel integer,
   :credentialsConfigDisabled boolean,
   :ensureVerifyAppsEnabled boolean,
   :networkEscapeHatchEnabled boolean,
   :keyguardDisabledFeatures [string],
   :cameraDisabled boolean,
   :deviceOwnerLockScreenInfo {:defaultMessage string,
                               :localizedMessages {}},
   :safeBootDisabled boolean,
   :autoTimeRequired boolean,
   :playStoreMode string,
   :shareLocationDisabled boolean,
   :permittedAccessibilityServices {:packageNames [string]},
   :bluetoothDisabled boolean,
   :setupActions [{:title UserFacingMessage,
                   :launchApp LaunchAppAction,
                   :description UserFacingMessage}],
   :personalUsagePolicies {:maxDaysWithWorkOff integer,
                           :personalApplications [PersonalApplicationPolicy],
                           :cameraDisabled boolean,
                           :accountTypesWithManagementDisabled [string],
                           :screenCaptureDisabled boolean,
                           :personalPlayStoreMode string},
   :installAppsDisabled boolean,
   :frpAdminEmails [string],
   :passwordPolicies [{:requirePasswordUnlock string,
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
   :networkResetDisabled boolean,
   :appAutoUpdatePolicy string,
   :shortSupportMessage {:defaultMessage string, :localizedMessages {}},
   :tetheringConfigDisabled boolean,
   :usbFileTransferDisabled boolean,
   :cellBroadcastsConfigDisabled boolean,
   :defaultPermissionPolicy string,
   :choosePrivateKeyRules [{:urlPattern string,
                            :privateKeyAlias string,
                            :packageNames [string]}],
   :permissionGrants [{:policy string, :permission string}],
   :outgoingCallsDisabled boolean,
   :vpnConfigDisabled boolean,
   :bluetoothContactSharingDisabled boolean,
   :statusReportingSettings {:systemPropertiesEnabled boolean,
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
   :systemUpdate {:freezePeriods [FreezePeriod],
                  :endMinutes integer,
                  :startMinutes integer,
                  :type string},
   :policyEnforcementRules [{:blockAction BlockAction,
                             :wipeAction WipeAction,
                             :settingName string}],
   :uninstallAppsDisabled boolean,
   :advancedSecurityOverrides {:untrustedAppsPolicy string},
   :setUserIconDisabled boolean,
   :longSupportMessage {:defaultMessage string, :localizedMessages {}},
   :persistentPreferredActivities [{:actions [string],
                                    :receiverActivity string,
                                    :categories [string]}],
   :mobileNetworksConfigDisabled boolean,
   :funDisabled boolean,
   :complianceRules [{:nonComplianceDetailCondition NonComplianceDetailCondition,
                      :disableApps boolean,
                      :apiLevelCondition ApiLevelCondition,
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

(defn webApps-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
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

(defn webApps-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayMode string,
   :icons [{:imageData string}],
   :name string,
   :versionCode string,
   :startUrl string,
   :title string}
  
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

(defn webApps-patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webApps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayMode string,
   :icons [{:imageData string}],
   :name string,
   :versionCode string,
   :startUrl string,
   :title string}
  
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

(defn webTokens-create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/webTokens/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parentFrameUrl string,
   :permissions [string],
   :enabledFeatures [string],
   :value string,
   :name string}
  
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
  
  Creates an enrollment token for a given enterprise."
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

(defn devices-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists devices for a given enterprise."
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

(defn devices-issueCommand$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/issueCommand
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:userName string,
   :resetPasswordFlags [string],
   :duration string,
   :type string,
   :createTime string,
   :errorCode string,
   :newPassword string}
  
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

(defn devices-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/delete
  
  Required parameters: name
  
  Optional parameters: wipeDataFlags, wipeReasonMessage
  
  Deletes a device. This operation wipes the device."
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

(defn devices-patch$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:previousDeviceNames [string],
   :appliedState string,
   :memoryInfo {:totalInternalStorage string, :totalRam string},
   :networkInfo {:imei string,
                 :wifiMacAddress string,
                 :networkOperatorName string,
                 :meid string},
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
   :memoryEvents [{:createTime string,
                   :byteCount string,
                   :eventType string}],
   :hardwareStatusSamples [{:cpuTemperatures [number],
                            :cpuUsages [number],
                            :fanSpeeds [number],
                            :skinTemperatures [number],
                            :gpuTemperatures [number],
                            :createTime string,
                            :batteryTemperatures [number]}],
   :enrollmentTokenData string,
   :enrollmentTime string,
   :managementMode string,
   :lastPolicyComplianceReportTime string,
   :ownership string,
   :appliedPolicyName string,
   :securityPosture {:devicePosture string,
                     :postureDetails [PostureDetail]},
   :powerManagementEvents [{:batteryLevel number,
                            :eventType string,
                            :createTime string}],
   :lastPolicySyncTime string,
   :deviceSettings {:isDeviceSecure boolean,
                    :unknownSourcesEnabled boolean,
                    :encryptionStatus string,
                    :adbEnabled boolean,
                    :verifyAppsEnabled boolean,
                    :isEncrypted boolean,
                    :developmentSettingsEnabled boolean},
   :hardwareInfo {:serialNumber string,
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
   :displays [{:refreshRate integer,
               :density integer,
               :name string,
               :height integer,
               :displayId integer,
               :width integer,
               :state string}],
   :disabledReason {:defaultMessage string, :localizedMessages {}},
   :userName string,
   :policyName string,
   :appliedPolicyVersion string,
   :nonComplianceDetails [{:fieldPath string,
                           :installationFailureReason string,
                           :nonComplianceReason string,
                           :settingName string,
                           :packageName string,
                           :currentValue any}],
   :applicationReports [{:packageName string,
                         :packageSha256Hash string,
                         :displayName string,
                         :events [ApplicationEvent],
                         :installerPackageName string,
                         :state string,
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

(defn devices-get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a device."
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

(defn devices-operations-delete$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
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

(defn devices-operations-list$
  "https://developers.google.com/android/managementapi/reference/rest/v1/enterprises/devices/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.NOTE: the name binding allows API services to override the binding to use different resource name schemes, such as users/*/operations. To override the binding, API services can add a binding such as \"/v1/{name=users/*}/operations\" to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
