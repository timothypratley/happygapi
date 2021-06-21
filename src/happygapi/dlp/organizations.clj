(ns happygapi.dlp.organizations
  "Cloud Data Loss Prevention (DLP) API: organizations.
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/patch
  
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

(defn storedInfoTypes-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/create
  
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

(defn storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/delete
  
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

(defn storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/get
  
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

(defn storedInfoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, locationId, pageSize
  
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

(defn deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/patch
  
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

(defn deidentifyTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/get
  
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

(defn deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/delete
  
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

(defn deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/create
  
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

(defn deidentifyTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, locationId, pageSize, pageToken
  
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

(defn inspectTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/create
  
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

(defn inspectTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/patch
  
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

(defn inspectTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/get
  
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

(defn inspectTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, locationId, pageToken
  
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

(defn inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/delete
  
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

(defn locations-storedInfoTypes-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/create
  
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

(defn locations-storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/get
  
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

(defn locations-storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/delete
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: locationId, orderBy, pageSize, pageToken
  
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

(defn locations-storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/patch
  
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

(defn locations-jobTriggers-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/jobTriggers/create
  
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

(defn locations-jobTriggers-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/jobTriggers/get
  
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

(defn locations-jobTriggers-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: locationId, type, filter, pageToken, orderBy, pageSize
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/jobTriggers/patch
  
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

(defn locations-jobTriggers-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/jobTriggers/delete
  
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

(defn locations-dlpJobs-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, orderBy, filter, type, locationId
  
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

(defn locations-deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/create
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/get
  
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

(defn locations-deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/patch
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, locationId, pageSize, orderBy
  
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

(defn locations-deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/delete
  
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

(defn locations-inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/delete
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/create
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/get
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/patch
  
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
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, locationId, orderBy
  
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
