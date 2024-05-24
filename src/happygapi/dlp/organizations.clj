(ns happygapi.dlp.organizations
  "Sensitive Data Protection (DLP): organizations.
  Discover and protect your sensitive data. A fully managed service designed to help you discover, classify, and protect your valuable data assets with ease.
  See: https://cloud.google.com/sensitive-data-protection/docs/docs/reference/rest/v2/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn inspectTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectTemplate {:updateTime string,
                     :description string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :templateId string}
  
  Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :inspectTemplate {:updateTime string,
                     :description string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string}}
  
  Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, locationId, orderBy, pageSize
  
  Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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

(defn storedInfoTypes-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:config {:description string,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string},
   :storedInfoTypeId string,
   :locationId string}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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

(defn storedInfoTypes-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:description string,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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

(defn storedInfoTypes-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, locationId
  
  Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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

(defn storedInfoTypes-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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

(defn deidentifyTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :locationId string,
   :deidentifyTemplate {:description string,
                        :displayName string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :name string,
                        :updateTime string}}
  
  Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn deidentifyTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :deidentifyTemplate {:description string,
                        :displayName string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :name string,
                        :updateTime string}}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn deidentifyTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn deidentifyTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, locationId, pageSize, pageToken
  
  Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn deidentifyTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn locations-inspectTemplates-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :inspectTemplate {:updateTime string,
                     :description string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string},
   :templateId string}
  
  Creates an InspectTemplate for reusing frequently used configuration for inspecting content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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

(defn locations-inspectTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: locationId, orderBy, pageToken, pageSize
  
  Lists InspectTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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

(defn locations-inspectTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :inspectTemplate {:updateTime string,
                     :description string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :createTime string}}
  
  Updates the InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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

(defn locations-inspectTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InspectTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates to learn more."
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

(defn locations-tableDataProfiles-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/tableDataProfiles/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a TableDataProfile. Will not prevent the profile from being regenerated if the table is still included in a discovery configuration."
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

(defn locations-tableDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/tableDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, filter, pageSize
  
  Lists table data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/tableDataProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tableDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/tableDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a table data profile."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, locationId, pageToken
  
  Lists stored infoTypes. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :config {:description string,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string}}
  
  Updates the stored infoType by creating a new version. The existing version will continue to be used until the new version is ready. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:config {:description string,
            :largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string},
   :storedInfoTypeId string,
   :locationId string}
  
  Creates a pre-built stored infoType to be used for inspection. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a stored infoType. See https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes to learn more."
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

(defn locations-columnDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/columnDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a column data profile."
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

(defn locations-columnDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/columnDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists column data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/columnDataProfiles"
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/dlpJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, locationId, filter, pageToken, type, orderBy
  
  Lists DlpJobs that match the specified filter in the request. See https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage and https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis to learn more."
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

(defn locations-deidentifyTemplates-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn locations-deidentifyTemplates-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: locationId, pageToken, orderBy, pageSize
  
  Lists DeidentifyTemplates. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :locationId string,
   :deidentifyTemplate {:description string,
                        :displayName string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :name string,
                        :updateTime string}}
  
  Creates a DeidentifyTemplate for reusing frequently used configuration for de-identifying content, images, and storage. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn locations-deidentifyTemplates-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :deidentifyTemplate {:description string,
                        :displayName string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :name string,
                        :updateTime string}}
  
  Updates the DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn locations-deidentifyTemplates-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DeidentifyTemplate. See https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid to learn more."
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

(defn locations-jobTriggers-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/jobTriggers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
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

(defn locations-jobTriggers-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/jobTriggers/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :updateMask string}
  
  Updates a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
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

(defn locations-jobTriggers-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/jobTriggers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job trigger. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
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

(defn locations-jobTriggers-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/jobTriggers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:jobTrigger {:description string,
                :errors [GooglePrivacyDlpV2Error],
                :displayName string,
                :inspectJob GooglePrivacyDlpV2InspectJobConfig,
                :name string,
                :createTime string,
                :triggers [GooglePrivacyDlpV2Trigger],
                :updateTime string,
                :status string,
                :lastRunTime string},
   :locationId string,
   :triggerId string}
  
  Creates a job trigger to run DLP actions such as scanning storage for sensitive information on a set schedule. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
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

(defn locations-jobTriggers-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/jobTriggers/list
  
  Required parameters: parent
  
  Optional parameters: type, pageSize, pageToken, filter, locationId, orderBy
  
  Lists job triggers. See https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers to learn more."
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

(defn locations-projectDataProfiles-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/projectDataProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, filter, pageSize
  
  Lists project data profiles for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/projectDataProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-projectDataProfiles-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/projectDataProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a project data profile."
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

(defn locations-connections-search$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/connections/search
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Searches for Connections in a parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/connections:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveryConfigs-get$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/discoveryConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a discovery configuration."
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

(defn locations-discoveryConfigs-delete$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/discoveryConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a discovery configuration."
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

(defn locations-discoveryConfigs-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/discoveryConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, orderBy
  
  Lists discovery configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/discoveryConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-discoveryConfigs-patch$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/discoveryConfigs/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :discoveryConfig {:inspectTemplates [string],
                     :errors [GooglePrivacyDlpV2Error],
                     :displayName string,
                     :name string,
                     :createTime string,
                     :orgConfig GooglePrivacyDlpV2OrgConfig,
                     :targets [GooglePrivacyDlpV2DiscoveryTarget],
                     :actions [GooglePrivacyDlpV2DataProfileAction],
                     :updateTime string,
                     :status string,
                     :lastRunTime string}}
  
  Updates a discovery configuration."
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

(defn locations-discoveryConfigs-create$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/organizations/locations/discoveryConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:configId string,
   :discoveryConfig {:inspectTemplates [string],
                     :errors [GooglePrivacyDlpV2Error],
                     :displayName string,
                     :name string,
                     :createTime string,
                     :orgConfig GooglePrivacyDlpV2OrgConfig,
                     :targets [GooglePrivacyDlpV2DiscoveryTarget],
                     :actions [GooglePrivacyDlpV2DataProfileAction],
                     :updateTime string,
                     :status string,
                     :lastRunTime string}}
  
  Creates a config for discovery to scan and profile storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/discoveryConfigs"
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
