(ns happygapi.securitycenter.folders
  "Security Command Center API: folders.
  Security Command Center API provides access to temporal views of assets and findings within an organization.
  See: https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn findings-bulkMute$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/findings/bulkMute
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :muteAnnotation string}
  
  Kicks off an LRO to bulk mute findings for a parent based on a filter. The parent can be either an organization, folder or project. The findings matched by the filter will be muted after the LRO is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings:bulkMute"
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

(defn eventThreatDetectionSettings-validateCustomModule$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/validateCustomModule
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:rawText string, :type string}
  
  Validates the given Event Threat Detection custom module."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}:validateCustomModule"
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

(defn eventThreatDetectionSettings-customModules-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :enablementState string,
   :lastEditor string,
   :config {},
   :displayName string,
   :ancestorModule string,
   :name string,
   :type string,
   :updateTime string}
  
  Creates a resident Event Threat Detection custom module at the scope of the given Resource Manager parent, and also creates inherited custom modules for all descendants of the given parent. These modules are enabled by default."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules"
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

(defn eventThreatDetectionSettings-customModules-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Event Threat Detection custom module and all of its descendants in the Resource Manager hierarchy. This method is only supported for resident custom modules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn eventThreatDetectionSettings-customModules-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an Event Threat Detection custom module."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn eventThreatDetectionSettings-customModules-listDescendant$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/listDescendant
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all resident Event Threat Detection custom modules under the given Resource Manager parent and its descendants."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules:listDescendant"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn eventThreatDetectionSettings-customModules-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all Event Threat Detection custom modules for the given Resource Manager parent. This includes resident modules defined at the scope of the parent along with modules inherited from ancestors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn eventThreatDetectionSettings-customModules-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/customModules/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :enablementState string,
   :lastEditor string,
   :config {},
   :displayName string,
   :ancestorModule string,
   :name string,
   :type string,
   :updateTime string}
  
  Updates the Event Threat Detection custom module with the given name based on the given update mask. Updating the enablement state is supported for both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name or configuration of a module is supported for resident modules only. The type of a module cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn eventThreatDetectionSettings-effectiveCustomModules-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/effectiveCustomModules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an effective Event Threat Detection custom module at the given level."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn eventThreatDetectionSettings-effectiveCustomModules-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/eventThreatDetectionSettings/effectiveCustomModules/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all effective Event Threat Detection custom modules for the given parent. This includes resident modules defined at the scope of the parent along with modules inherited from its ancestors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/effectiveCustomModules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assets-group$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/assets/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :groupBy string,
   :compareDuration string,
   :readTime string,
   :pageToken string,
   :pageSize integer}
  
  Filters an organization's assets and groups them by their specified properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets:group"
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

(defn assets-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/assets/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, readTime, compareDuration, fieldMask, pageToken, pageSize
  
  Lists an organization's assets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assets-updateSecurityMarks$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/assets/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: updateMask, startTime
  
  Body: 
  
  {:name string, :marks {}, :canonicalName string}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all sources belonging to an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-group$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :groupBy string,
   :readTime string,
   :compareDuration string,
   :pageToken string,
   :pageSize integer}
  
  Filters an organization or source's findings and groups them by their specified properties. To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings:group"
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

(defn sources-findings-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, readTime, compareDuration, fieldMask, pageToken, pageSize
  
  Lists an organization or source's findings. To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-setState$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/setState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:state string, :startTime string}
  
  Updates the state of a finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:setState"
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

(defn sources-findings-setMute$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/setMute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:mute string}
  
  Updates the mute state of a finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:setMute"
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

(defn sources-findings-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :category string,
   :externalSystems {},
   :exfiltration {:sources [ExfilResource],
                  :targets [ExfilResource],
                  :totalExfiltratedBytes string},
   :kernelRootkit {:unexpectedFtraceHandler boolean,
                   :unexpectedReadOnlyDataModification boolean,
                   :name string,
                   :unexpectedKernelCodePages boolean,
                   :unexpectedCodeModification boolean,
                   :unexpectedProcessesInRunqueue boolean,
                   :unexpectedSystemCallHandler boolean,
                   :unexpectedInterruptHandler boolean,
                   :unexpectedKprobeHandler boolean},
   :compliances [{:standard string, :version string, :ids [string]}],
   :kubernetes {:pods [Pod],
                :nodes [Node],
                :nodePools [NodePool],
                :roles [Role],
                :bindings [GoogleCloudSecuritycenterV1Binding],
                :accessReviews [AccessReview],
                :objects [Object]},
   :parent string,
   :contacts {},
   :application {:baseUri string, :fullUri string},
   :backupDisasterRecovery {:applications [string],
                            :appliance string,
                            :policies [string],
                            :backupTemplate string,
                            :backupCreateTime string,
                            :storagePool string,
                            :policyOptions [string],
                            :host string,
                            :backupType string,
                            :profile string},
   :name string,
   :attackExposure {:score number,
                    :latestCalculationTime string,
                    :attackExposureResult string,
                    :state string,
                    :exposedHighValueResourcesCount integer,
                    :exposedMediumValueResourcesCount integer,
                    :exposedLowValueResourcesCount integer},
   :createTime string,
   :vulnerability {:cve Cve,
                   :offendingPackage Package,
                   :fixedPackage Package,
                   :securityBulletin SecurityBulletin},
   :state string,
   :containers [{:name string,
                 :uri string,
                 :imageId string,
                 :labels [Label],
                 :createTime string}],
   :orgPolicies [{:name string}],
   :canonicalName string,
   :moduleName string,
   :nextSteps string,
   :externalUri string,
   :cloudDlpDataProfile {:dataProfile string, :parentType string},
   :resourceName string,
   :securityMarks {:name string, :marks {}, :canonicalName string},
   :sourceProperties {},
   :iamBindings [{:action string, :role string, :member string}],
   :muteUpdateTime string,
   :muteInitiator string,
   :cloudDlpInspection {:inspectJob string,
                        :infoType string,
                        :infoTypeCount string,
                        :fullScan boolean},
   :parentDisplayName string,
   :indicator {:ipAddresses [string],
               :domains [string],
               :signatures [ProcessSignature],
               :uris [string]},
   :severity string,
   :files [{:path string,
            :size string,
            :sha256 string,
            :hashedSize string,
            :partiallyHashed boolean,
            :contents string,
            :diskPath DiskPath}],
   :mitreAttack {:primaryTactic string,
                 :primaryTechniques [string],
                 :additionalTactics [string],
                 :additionalTechniques [string],
                 :version string},
   :loadBalancers [{:name string}],
   :database {:name string,
              :displayName string,
              :userName string,
              :query string,
              :grantees [string],
              :version string},
   :access {:serviceAccountDelegationInfo [ServiceAccountDelegationInfo],
            :callerIp string,
            :userAgentFamily string,
            :userAgent string,
            :serviceAccountKeyName string,
            :principalSubject string,
            :principalEmail string,
            :serviceName string,
            :methodName string,
            :callerIpGeo Geolocation,
            :userName string},
   :eventTime string,
   :connections [{:destinationIp string,
                  :destinationPort integer,
                  :sourceIp string,
                  :sourcePort integer,
                  :protocol string}],
   :securityPosture {:name string,
                     :revisionId string,
                     :postureDeploymentResource string,
                     :postureDeployment string,
                     :changedPolicy string,
                     :policySet string,
                     :policy string,
                     :policyDriftDetails [PolicyDriftDetails]},
   :processes [{:args [string],
                :binary File,
                :argumentsTruncated boolean,
                :libraries [File],
                :script File,
                :name string,
                :envVariablesTruncated boolean,
                :parentPid string,
                :envVariables [EnvironmentVariable],
                :pid string}],
   :findingClass string,
   :logEntries [{:cloudLoggingEntry CloudLoggingEntry}],
   :mute string}
  
  Creates or updates a finding. The corresponding source must exist for a finding creation to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-findings-updateSecurityMarks$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: updateMask, startTime
  
  Body: 
  
  {:name string, :marks {}, :canonicalName string}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-findings-externalSystems-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/sources/findings/externalSystems/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:assignees [string],
   :externalSystemUpdateTime string,
   :externalUid string,
   :name string,
   :ticketInfo {:id string,
                :assignee string,
                :description string,
                :uri string,
                :status string,
                :updateTime string},
   :caseCloseTime string,
   :caseCreateTime string,
   :status string,
   :caseSla string,
   :casePriority string,
   :caseUri string}
  
  Updates external system. This is for a given finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/notificationConfigs/create
  
  Required parameters: parent
  
  Optional parameters: configId
  
  Body: 
  
  {:name string,
   :description string,
   :pubsubTopic string,
   :serviceAccount string,
   :streamingConfig {:filter string}}
  
  Creates a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/notificationConfigs"
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

(defn notificationConfigs-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/notificationConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/notificationConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/notificationConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists notification configs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/notificationConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationConfigs-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/notificationConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :pubsubTopic string,
   :serviceAccount string,
   :streamingConfig {:filter string}}
  
   Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn bigQueryExports-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/bigQueryExports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a BigQuery export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn bigQueryExports-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/bigQueryExports/create
  
  Required parameters: parent
  
  Optional parameters: bigQueryExportId
  
  Body: 
  
  {:name string,
   :description string,
   :filter string,
   :dataset string,
   :createTime string,
   :updateTime string,
   :mostRecentEditor string,
   :principal string}
  
  Creates a BigQuery export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/bigQueryExports"
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

(defn bigQueryExports-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/bigQueryExports/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing BigQuery export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn bigQueryExports-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/bigQueryExports/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :filter string,
   :dataset string,
   :createTime string,
   :updateTime string,
   :mostRecentEditor string,
   :principal string}
  
  Updates a BigQuery export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn bigQueryExports-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/bigQueryExports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists BigQuery exports. Note that when requesting BigQuery exports at a given level all exports under that level are also returned e.g. if requesting BigQuery exports under a folder, then all BigQuery exports immediately under the folder plus the ones created under the projects within the folder are returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/bigQueryExports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-muteConfigs-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/locations/muteConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn locations-muteConfigs-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/locations/muteConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn locations-muteConfigs-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/locations/muteConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :filter string,
   :createTime string,
   :updateTime string,
   :mostRecentEditor string}
  
  Updates a mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn securityHealthAnalyticsSettings-customModules-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :enablementState string,
   :updateTime string,
   :lastEditor string,
   :ancestorModule string,
   :customConfig {:predicate Expr,
                  :customOutput GoogleCloudSecuritycenterV1CustomOutputSpec,
                  :resourceSelector GoogleCloudSecuritycenterV1ResourceSelector,
                  :severity string,
                  :description string,
                  :recommendation string}}
  
  Creates a resident SecurityHealthAnalyticsCustomModule at the scope of the given CRM parent, and also creates inherited SecurityHealthAnalyticsCustomModules for all CRM descendants of the given parent. These modules are enabled by default."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules"
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

(defn securityHealthAnalyticsSettings-customModules-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified SecurityHealthAnalyticsCustomModule and all of its descendants in the CRM hierarchy. This method is only supported for resident custom modules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn securityHealthAnalyticsSettings-customModules-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a SecurityHealthAnalyticsCustomModule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn securityHealthAnalyticsSettings-customModules-listDescendant$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/listDescendant
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of all resident SecurityHealthAnalyticsCustomModules under the given CRM parent and all of the parent’s CRM descendants."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules:listDescendant"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn securityHealthAnalyticsSettings-customModules-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of all SecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn securityHealthAnalyticsSettings-customModules-simulate$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/simulate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:customConfig {:predicate Expr,
                  :customOutput GoogleCloudSecuritycenterV1CustomOutputSpec,
                  :resourceSelector GoogleCloudSecuritycenterV1ResourceSelector,
                  :severity string,
                  :description string,
                  :recommendation string},
   :resource {:resourceType string,
              :resourceData {},
              :iamPolicyData Policy}}
  
  Simulates a given SecurityHealthAnalyticsCustomModule and Resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/customModules:simulate"
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

(defn securityHealthAnalyticsSettings-customModules-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/customModules/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :enablementState string,
   :updateTime string,
   :lastEditor string,
   :ancestorModule string,
   :customConfig {:predicate Expr,
                  :customOutput GoogleCloudSecuritycenterV1CustomOutputSpec,
                  :resourceSelector GoogleCloudSecuritycenterV1ResourceSelector,
                  :severity string,
                  :description string,
                  :recommendation string}}
  
  Updates the SecurityHealthAnalyticsCustomModule under the given name based on the given update mask. Updating the enablement state is supported on both resident and inherited modules (though resident modules cannot have an enablement state of \"inherited\"). Updating the display name and custom config of a module is supported on resident modules only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn securityHealthAnalyticsSettings-effectiveCustomModules-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/effectiveCustomModules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves an EffectiveSecurityHealthAnalyticsCustomModule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn securityHealthAnalyticsSettings-effectiveCustomModules-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/securityHealthAnalyticsSettings/effectiveCustomModules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of all EffectiveSecurityHealthAnalyticsCustomModules for the given parent. This includes resident modules defined at the scope of the parent, and inherited modules, inherited from CRM ancestors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/effectiveCustomModules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn muteConfigs-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/muteConfigs/create
  
  Required parameters: parent
  
  Optional parameters: muteConfigId
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :filter string,
   :createTime string,
   :updateTime string,
   :mostRecentEditor string}
  
  Creates a mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/muteConfigs"
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

(defn muteConfigs-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/muteConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn muteConfigs-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/muteConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn muteConfigs-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/muteConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists mute configs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/muteConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn muteConfigs-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/folders/muteConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :filter string,
   :createTime string,
   :updateTime string,
   :mostRecentEditor string}
  
  Updates a mute config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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
