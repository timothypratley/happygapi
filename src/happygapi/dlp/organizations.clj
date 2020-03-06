(ns happygapi.dlp.organizations
  "Cloud Data Loss Prevention (DLP) API: organizations.
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn inspectTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :inspectTemplate {:updateTime string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :description string,
                     :createTime string}}
  
  Updates the InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn inspectTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  Lists InspectTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn inspectTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :inspectTemplate {:updateTime string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :description string,
                     :createTime string},
   :locationId string}
  
  Creates an InspectTemplate for re-using frequently used configuration
  for inspecting content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/inspectTemplates"
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

(defn inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:displayName string,
                        :description string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :updateTime string,
                        :name string},
   :updateMask string}
  
  Updates the DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-deidentifyTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/list
  
  Required parameters: parent, locationId
  
  Optional parameters: pageToken, orderBy, pageSize
  Lists DeidentifyTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/deidentifyTemplates"
     #{:parent :locationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/deidentifyTemplates/create
  
  Required parameters: locationId, parent
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:displayName string,
                        :description string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :updateTime string,
                        :name string},
   :locationId string,
   :templateId string}
  
  Creates a DeidentifyTemplate for re-using frequently used configuration
  for de-identifying content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/deidentifyTemplates"
     #{:parent :locationId}
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

(defn locations-storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:config {:largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string,
            :description string},
   :updateMask string}
  
  Updates the stored infoType by creating a new version. The existing version
  will continue to be used until the new version is ready.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/list
  
  Required parameters: locationId, parent
  
  Optional parameters: pageToken, orderBy, pageSize
  Lists stored infoTypes.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/storedInfoTypes"
     #{:parent :locationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-storedInfoTypes-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/create
  
  Required parameters: locationId, parent
  
  Optional parameters: none
  
  Body: 
  
  {:locationId string,
   :storedInfoTypeId string,
   :config {:largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string,
            :description string}}
  
  Creates a pre-built stored infoType to be used for inspection.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/storedInfoTypes"
     #{:parent :locationId}
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

(defn locations-storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :inspectTemplate {:updateTime string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :description string,
                     :createTime string}}
  
  Updates the InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn locations-inspectTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets an InspectTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/list
  
  Required parameters: parent, locationId
  
  Optional parameters: pageToken, orderBy, pageSize
  Lists InspectTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/inspectTemplates"
     #{:parent :locationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-inspectTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/locations/inspectTemplates/create
  
  Required parameters: locationId, parent
  
  Optional parameters: none
  
  Body: 
  
  {:templateId string,
   :inspectTemplate {:updateTime string,
                     :name string,
                     :inspectConfig GooglePrivacyDlpV2InspectConfig,
                     :displayName string,
                     :description string,
                     :createTime string},
   :locationId string}
  
  Creates an InspectTemplate for re-using frequently used configuration
  for inspecting content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent :locationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/locations/{locationId}/inspectTemplates"
     #{:parent :locationId}
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

(defn deidentifyTemplates-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:displayName string,
                        :description string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :updateTime string,
                        :name string},
   :updateMask string}
  
  Updates the DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn deidentifyTemplates-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a DeidentifyTemplate.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  Lists DeidentifyTemplates.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deidentifyTemplates-create$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/deidentifyTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deidentifyTemplate {:displayName string,
                        :description string,
                        :deidentifyConfig GooglePrivacyDlpV2DeidentifyConfig,
                        :createTime string,
                        :updateTime string,
                        :name string},
   :locationId string,
   :templateId string}
  
  Creates a DeidentifyTemplate for re-using frequently used configuration
  for de-identifying content, images, and storage.
  See https://cloud.google.com/dlp/docs/creating-templates-deid to learn
  more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/deidentifyTemplates"
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

(defn storedInfoTypes-patch$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:config {:largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string,
            :description string},
   :updateMask string}
  
  Updates the stored infoType by creating a new version. The existing version
  will continue to be used until the new version is ready.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
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

(defn storedInfoTypes-get$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn storedInfoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, locationId
  Lists stored infoTypes.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :config {:largeCustomDictionary GooglePrivacyDlpV2LargeCustomDictionaryConfig,
            :dictionary GooglePrivacyDlpV2Dictionary,
            :regex GooglePrivacyDlpV2Regex,
            :displayName string,
            :description string}}
  
  Creates a pre-built stored infoType to be used for inspection.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/storedInfoTypes"
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

(defn storedInfoTypes-delete$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/organizations/storedInfoTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a stored infoType.
  See https://cloud.google.com/dlp/docs/creating-stored-infotypes to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
