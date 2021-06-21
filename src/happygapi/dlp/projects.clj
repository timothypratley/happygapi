(ns happygapi.dlp.projects
  "Cloud Data Loss Prevention (DLP) API: projects.
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn content-deidentify$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/content/deidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :deidentifyTemplateName string,
   :deidentifyConfig {:recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :locationId string,
   :inspectTemplateName string}
  
  De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:deidentify"
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

(defn content-inspect$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/content/inspect
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplateName string,
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :locationId string}
  
  Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images and https://cloud.google.com/dlp/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:inspect"
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

(defn content-reidentify$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/content/reidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplateName string,
   :reidentifyConfig {:recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :locationId string,
   :item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :reidentifyTemplateName string}
  
  Re-identifies content that has been de-identified. See https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:reidentify"
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

(defn deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:createTime string,
                        :displayName string,
                        :description string,
                        :updateTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :name string},
   :updateMask string}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn deidentifyTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: locationId, orderBy, pageSize, pageToken
  
  Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :deidentifyTemplate {:createTime string,
                        :displayName string,
                        :description string,
                        :updateTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :name string},
   :locationId string}
  
  Creates a DeidentifyTemplate for re-using frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn dlpJobs-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, filter, type, pageToken, locationId
  
  Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/dlpJobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :riskJob {:sourceTable GooglePrivacyDlpV2BigQueryTable,
             :privacyMetric GooglePrivacyDlpV2PrivacyMetric,
             :actions [GooglePrivacyDlpV2Action]},
   :jobId string,
   :inspectJob {:storageConfig GooglePrivacyDlpV2StorageConfig,
                :inspectTemplateName string,
                :actions [GooglePrivacyDlpV2Action],
                :inspectConfig GooglePrivacyDlpV2InspectConfig}}
  
  Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
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

(defn dlpJobs-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/dlpJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/dlpJobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be cancelled if possible. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dlpJobs-cancel$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/dlpJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn image-redact$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/image/redact
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:byteItem {:type string, :data string},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :imageRedactionConfigs [{:redactAllText boolean,
                            :redactionColor GooglePrivacyDlpV2Color,
                            :infoType GooglePrivacyDlpV2InfoType}],
   :includeFindings boolean,
   :locationId string}
  
  Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/image:redact"
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

(defn inspectTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, locationId, pageSize
  
  Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:name string,
                     :updateTime string,
                     :description string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :updateMask string}
  
  Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectTemplate {:name string,
                     :updateTime string,
                     :description string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :templateId string}
  
  Creates an InspectTemplate for re-using frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :storedInfoTypeId string,
   :config {:regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :displayName string,
            :description string}}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn storedInfoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, locationId, orderBy, pageSize
  
  Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :displayName string,
            :description string}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-activate$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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

(defn locations-jobTriggers-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, type, locationId, filter, orderBy
  
  Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string}}
  
  Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-jobTriggers-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :triggerId string}
  
  Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
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

(defn locations-jobTriggers-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobTriggers-hybridInspect$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/jobTriggers/hybridInspect
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:hybridItem {:item GooglePrivacyDlpV2ContentItem,
                :findingDetails GooglePrivacyDlpV2HybridFindingDetails}}
  
  Inspect hybrid content and store findings to a trigger. The inspection will be processed asynchronously. To review the findings monitor the jobs within the trigger."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:hybridInspect"
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

(defn locations-inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectTemplate {:name string,
                     :updateTime string,
                     :description string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :templateId string}
  
  Creates an InspectTemplate for re-using frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn locations-inspectTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplate {:name string,
                     :updateTime string,
                     :description string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :updateMask string}
  
  Updates the InspectTemplate. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-inspectTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, locationId, pageSize, orderBy
  
  Lists InspectTemplates. See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-content-inspect$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/content/inspect
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplateName string,
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :locationId string}
  
  Finds potentially sensitive info in content. This method has limits on input size, processing time, and output size. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated. For how to guides, see https://cloud.google.com/dlp/docs/inspecting-images and https://cloud.google.com/dlp/docs/inspecting-text,"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:inspect"
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

(defn locations-content-deidentify$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/content/deidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :deidentifyTemplateName string,
   :deidentifyConfig {:recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :locationId string,
   :inspectTemplateName string}
  
  De-identifies potentially sensitive info from a ContentItem. This method has limits on input size and output size. See https://cloud.google.com/dlp/docs/deidentify-sensitive-data to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:deidentify"
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

(defn locations-content-reidentify$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/content/reidentify
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inspectTemplateName string,
   :reidentifyConfig {:recordTransformations GooglePrivacyDlpV2RecordTransformations,
                      :transformationErrorHandling GooglePrivacyDlpV2TransformationErrorHandling,
                      :infoTypeTransformations GooglePrivacyDlpV2InfoTypeTransformations},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :locationId string,
   :item {:value string,
          :byteItem GooglePrivacyDlpV2ByteContentItem,
          :table GooglePrivacyDlpV2Table},
   :reidentifyTemplateName string}
  
  Re-identifies content that has been de-identified. See https://cloud.google.com/dlp/docs/pseudonymization#re-identification_in_free_text_code_example to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/content:reidentify"
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

(defn locations-storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :displayName string,
            :description string}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-storedInfoTypes-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :storedInfoTypeId string,
   :config {:regex GooglePrivacyDlpV2Regex,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :displayName string,
            :description string}}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn locations-storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, locationId, pageSize, pageToken
  
  Lists stored infoTypes. See https://cloud.google.com/dlp/docs/creating-stored-infotypes to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, type, pageSize, filter, locationId, pageToken
  
  Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-hybridInspect$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/hybridInspect
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:hybridItem {:item GooglePrivacyDlpV2ContentItem,
                :findingDetails GooglePrivacyDlpV2HybridFindingDetails}}
  
  Inspect hybrid content and store findings to a job. To review the findings, inspect the job. Inspection will occur asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:hybridInspect"
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

(defn locations-dlpJobs-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running DlpJob. This method indicates that the client is no longer interested in the DlpJob result. The job will be cancelled if possible. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :riskJob {:sourceTable GooglePrivacyDlpV2BigQueryTable,
             :privacyMetric GooglePrivacyDlpV2PrivacyMetric,
             :actions [GooglePrivacyDlpV2Action]},
   :jobId string,
   :inspectJob {:storageConfig GooglePrivacyDlpV2StorageConfig,
                :inspectTemplateName string,
                :actions [GooglePrivacyDlpV2Action],
                :inspectConfig GooglePrivacyDlpV2InspectConfig}}
  
  Creates a new job to inspect storage or calculate risk metrics. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more. When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/dlpJobs"
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

(defn locations-dlpJobs-cancel$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running DlpJob. The server makes a best effort to cancel the DlpJob, but success is not guaranteed. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-dlpJobs-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running DlpJob. See https://cloud.google.com/dlp/docs/inspecting-storage and https://cloud.google.com/dlp/docs/compute-risk-analysis to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dlpJobs-finish$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/dlpJobs/finish
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Finish a running hybrid DlpJob. Triggers the finalization steps and running of any enabled actions that have not yet run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:finish"
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

(defn locations-deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:createTime string,
                        :displayName string,
                        :description string,
                        :updateTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :name string},
   :updateMask string}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-deidentifyTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, locationId, pageSize
  
  Lists DeidentifyTemplates. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :deidentifyTemplate {:createTime string,
                        :displayName string,
                        :description string,
                        :updateTime string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :name string},
   :locationId string}
  
  Creates a DeidentifyTemplate for re-using frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn locations-deidentifyTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/dlp/docs/creating-templates-deid to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-image-redact$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/locations/image/redact
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:byteItem {:type string, :data string},
   :inspectConfig {:limits GooglePrivacyDlpV2FindingLimits,
                   :minLikelihood string,
                   :ruleSet [GooglePrivacyDlpV2InspectionRuleSet],
                   :infoTypes [GooglePrivacyDlpV2InfoType],
                   :customInfoTypes [GooglePrivacyDlpV2CustomInfoType],
                   :includeQuote boolean,
                   :excludeInfoTypes boolean,
                   :contentOptions [string]},
   :imageRedactionConfigs [{:redactAllText boolean,
                            :redactionColor GooglePrivacyDlpV2Color,
                            :infoType GooglePrivacyDlpV2InfoType}],
   :includeFindings boolean,
   :locationId string}
  
  Redacts potentially sensitive info from an image. This method has limits on input size, processing time, and output size. See https://cloud.google.com/dlp/docs/redacting-sensitive-data-images to learn more. When no InfoTypes or CustomInfoTypes are specified in this request, the system will automatically choose what detectors to run. By default this may be all types, but may change over time as detectors are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/image:redact"
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

(defn jobTriggers-activate$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activate a job trigger. Causes the immediate execute of a trigger instead of waiting on the trigger event to occur."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}:activate"
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

(defn jobTriggers-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :triggerId string}
  
  Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
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

(defn jobTriggers-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, type, pageSize, filter, locationId, orderBy
  
  Lists job triggers. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/jobTriggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobTriggers-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/projects/jobTriggers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string}}
  
  Updates a job trigger. See https://cloud.google.com/dlp/docs/creating-job-triggers to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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
