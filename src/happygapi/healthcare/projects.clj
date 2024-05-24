(ns happygapi.healthcare.projects
  "Cloud Healthcare API: projects.
  Manage, store, and access healthcare data in Google Cloud Platform.
  See: https://cloud.google.com/healthcaredocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets any metadata associated with a dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :timeZone string}
  
  Updates dataset metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/create
  
  Required parameters: parent
  
  Optional parameters: datasetId
  
  Body: 
  
  {:name string, :timeZone string}
  
  Creates a new health dataset. Results are returned through the Operation interface which returns either an `Operation.response` which contains a Dataset or `Operation.error`. The metadata field type is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/datasets"
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

(defn locations-datasets-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified health dataset and all data contained in the dataset. Deleting a dataset does not affect the sources from which the dataset was imported (if any)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-deidentify$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/deidentify
  
  Required parameters: sourceDataset
  
  Optional parameters: none
  
  Body: 
  
  {:destinationDataset string,
   :config {:dicom DicomConfig,
            :fhir FhirConfig,
            :image ImageConfig,
            :text TextConfig,
            :useRegionalDataProcessing boolean},
   :gcsConfigUri string}
  
  Creates a new dataset containing de-identified data from the source dataset. The metadata field type is OperationMetadata. If the request is successful, the response field type is DeidentifySummary. If errors occur, error is set. The LRO result may still be successful if de-identification fails for some DICOM instances. The new de-identified dataset will not contain these failed resources. Failed resource totals are tracked in Operation.metadata. Error details are also logged to Cloud Logging. For more information, see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sourceDataset})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+sourceDataset}:deidentify"
     #{:sourceDataset}
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

(defn locations-datasets-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the health datasets in the current project."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/datasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-consentStores-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :defaultConsentTtl string,
   :labels {},
   :enableConsentCreateOnUpdate boolean}
  
  Updates the specified consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-queryAccessibleData$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/queryAccessibleData
  
  Required parameters: consentStore
  
  Optional parameters: none
  
  Body: 
  
  {:gcsDestination {:uriPrefix string},
   :resourceAttributes {},
   :requestAttributes {}}
  
  Queries all data_ids that are consented for a specified use in the given consent store and writes them to a specified destination. The returned Operation includes a progress counter for the number of User data mappings processed. If the request is successful, a detailed response is returned of type QueryAccessibleDataResponse, contained in the response field when the operation finishes. The metadata field type is OperationMetadata. Errors are logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)). For example, the following sample log entry shows a `failed to evaluate consent policy` error that occurred during a QueryAccessibleData call to consent store `projects/{project_id}/locations/{location_id}/datasets/{dataset_id}/consentStores/{consent_store_id}`. ```json jsonPayload: { @type: \"type.googleapis.com/google.cloud.healthcare.logging.QueryAccessibleDataLogEntry\" error: { code: 9 message: \"failed to evaluate consent policy\" } resourceName: \"projects/{project_id}/locations/{location_id}/datasets/{dataset_id}/consentStores/{consent_store_id}/consents/{consent_id}\" } logName: \"projects/{project_id}/logs/healthcare.googleapis.com%2Fquery_accessible_data\" operation: { id: \"projects/{project_id}/locations/{location_id}/datasets/{dataset_id}/operations/{operation_id}\" producer: \"healthcare.googleapis.com/QueryAccessibleData\" } receiveTimestamp: \"TIMESTAMP\" resource: { labels: { consent_store_id: \"{consent_store_id}\" dataset_id: \"{dataset_id}\" location: \"{location_id}\" project_id: \"{project_id}\" } type: \"healthcare_consent_store\" } severity: \"ERROR\" timestamp: \"TIMESTAMP\" ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:consentStore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+consentStore}:queryAccessibleData"
     #{:consentStore}
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

(defn locations-datasets-consentStores-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-consentStores-evaluateUserConsents$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/evaluateUserConsents
  
  Required parameters: consentStore
  
  Optional parameters: none
  
  Body: 
  
  {:userId string,
   :resourceAttributes {},
   :requestAttributes {},
   :consentList {:consents [string]},
   :responseView string,
   :pageSize integer,
   :pageToken string}
  
  Evaluates the user's Consents for all matching User data mappings. Note: User data mappings are indexed asynchronously, which can cause a slight delay between the time mappings are created or updated and when they are included in EvaluateUserConsents results."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:consentStore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+consentStore}:evaluateUserConsents"
     #{:consentStore}
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

(defn locations-datasets-consentStores-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/create
  
  Required parameters: parent
  
  Optional parameters: consentStoreId
  
  Body: 
  
  {:name string,
   :defaultConsentTtl string,
   :labels {},
   :enableConsentCreateOnUpdate boolean}
  
  Creates a new consent store in the parent dataset. Attempting to create a consent store with the same ID as an existing store fails with an ALREADY_EXISTS error."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consentStores"
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

(defn locations-datasets-consentStores-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified consent store and removes all the consent store's data."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the consent stores in the specified dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consentStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-checkDataAccess$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/checkDataAccess
  
  Required parameters: consentStore
  
  Optional parameters: none
  
  Body: 
  
  {:dataId string,
   :requestAttributes {},
   :consentList {:consents [string]},
   :responseView string}
  
  Checks if a particular data_id of a User data mapping in the specified consent store is consented for the specified use."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:consentStore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+consentStore}:checkDataAccess"
     #{:consentStore}
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

(defn locations-datasets-consentStores-attributeDefinitions-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/attributeDefinitions/create
  
  Required parameters: parent
  
  Optional parameters: attributeDefinitionId
  
  Body: 
  
  {:name string,
   :description string,
   :category string,
   :allowedValues [string],
   :consentDefaultValues [string],
   :dataMappingDefaultValue string}
  
  Creates a new Attribute definition in the parent consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/attributeDefinitions"
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

(defn locations-datasets-consentStores-attributeDefinitions-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/attributeDefinitions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified Attribute definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-attributeDefinitions-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/attributeDefinitions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Attribute definition. Fails if the Attribute definition is referenced by any User data mapping, or the latest revision of any Consent."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-attributeDefinitions-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/attributeDefinitions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :category string,
   :allowedValues [string],
   :consentDefaultValues [string],
   :dataMappingDefaultValue string}
  
  Updates the specified Attribute definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-attributeDefinitions-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/attributeDefinitions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the Attribute definitions in the specified consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/attributeDefinitions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-consentArtifacts-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consentArtifacts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :userId string,
   :userSignature {:userId string,
                   :image Image,
                   :metadata {},
                   :signatureTime string},
   :guardianSignature {:userId string,
                       :image Image,
                       :metadata {},
                       :signatureTime string},
   :witnessSignature {:userId string,
                      :image Image,
                      :metadata {},
                      :signatureTime string},
   :consentContentScreenshots [{:rawBytes string, :gcsUri string}],
   :consentContentVersion string,
   :metadata {}}
  
  Creates a new Consent artifact in the parent consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consentArtifacts"
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

(defn locations-datasets-consentStores-consentArtifacts-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consentArtifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified Consent artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-consentArtifacts-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consentArtifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Consent artifact. Fails if the artifact is referenced by the latest revision of any Consent."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-consentArtifacts-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consentArtifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the Consent artifacts in the specified consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consentArtifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-consents-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified revision of a Consent, or the latest revision if `revision_id` is not specified in the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-consents-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:policies [{:resourceAttributes [Attribute], :authorizationRule Expr}],
   :revisionCreateTime string,
   :name string,
   :revisionId string,
   :state string,
   :ttl string,
   :consentArtifact string,
   :userId string,
   :expireTime string,
   :metadata {}}
  
  Updates the latest revision of the specified Consent by committing a new revision with the changes. A FAILED_PRECONDITION error occurs if the latest revision of the specified Consent is in the `REJECTED` or `REVOKED` state."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-consents-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:policies [{:resourceAttributes [Attribute], :authorizationRule Expr}],
   :revisionCreateTime string,
   :name string,
   :revisionId string,
   :state string,
   :ttl string,
   :consentArtifact string,
   :userId string,
   :expireTime string,
   :metadata {}}
  
  Creates a new Consent in the parent consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consents"
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

(defn locations-datasets-consentStores-consents-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the Consent and its revisions. To keep a record of the Consent but mark it inactive, see [RevokeConsent]. To delete a revision of a Consent, see [DeleteConsentRevision]. This operation does not delete the related Consent artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-consents-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the Consent in the given consent store, returning each Consent's latest revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/consents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-consents-reject$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/reject
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:consentArtifact string}
  
  Rejects the latest revision of the specified Consent by committing a new revision with `state` updated to `REJECTED`. If the latest revision of the specified Consent is in the `REJECTED` state, no new revision is committed. A FAILED_PRECONDITION error occurs if the latest revision of the specified Consent is in the `ACTIVE` or `REVOKED` state."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:reject"
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

(defn locations-datasets-consentStores-consents-deleteRevision$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/deleteRevision
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified revision of a Consent. An INVALID_ARGUMENT error occurs if the specified revision is the latest revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:deleteRevision"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-consents-listRevisions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/listRevisions
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the revisions of the specified Consent in reverse chronological order."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:listRevisions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-consents-activate$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:consentArtifact string, :expireTime string, :ttl string}
  
  Activates the latest revision of the specified Consent by committing a new revision with `state` updated to `ACTIVE`. If the latest revision of the specified Consent is in the `ACTIVE` state, no new revision is committed. A FAILED_PRECONDITION error occurs if the latest revision of the specified Consent is in the `REJECTED` or `REVOKED` state."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:activate"
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

(defn locations-datasets-consentStores-consents-revoke$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/consents/revoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:consentArtifact string}
  
  Revokes the latest revision of the specified Consent by committing a new revision with `state` updated to `REVOKED`. If the latest revision of the specified Consent is in the `REVOKED` state, no new revision is committed. A FAILED_PRECONDITION error occurs if the latest revision of the given consent is in `DRAFT` or `REJECTED` state."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:revoke"
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

(defn locations-datasets-consentStores-userDataMappings-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :dataId string,
   :userId string,
   :resourceAttributes [{:attributeDefinitionId string,
                         :values [string]}],
   :archived boolean,
   :archiveTime string}
  
  Creates a new User data mapping in the parent consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/userDataMappings"
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

(defn locations-datasets-consentStores-userDataMappings-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified User data mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-userDataMappings-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified User data mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-userDataMappings-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :dataId string,
   :userId string,
   :resourceAttributes [{:attributeDefinitionId string,
                         :values [string]}],
   :archived boolean,
   :archiveTime string}
  
  Updates the specified User data mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-consentStores-userDataMappings-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the User data mappings in the specified consent store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/userDataMappings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-consentStores-userDataMappings-archive$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/consentStores/userDataMappings/archive
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Archives the specified User data mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:archive"
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

(defn locations-datasets-dataMapperWorkspaces-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dataMapperWorkspaces/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-dataMapperWorkspaces-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dataMapperWorkspaces/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dataMapperWorkspaces-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dataMapperWorkspaces/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-dicomStores-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified DICOM store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-dicomStores-searchForSeries$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/searchForSeries
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForSeries returns a list of matching series. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForSeries, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForSeries, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-dicomStores-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :notificationConfig {:pubsubTopic string, :sendForBulkImport boolean},
   :labels {},
   :streamConfigs [{:bigqueryDestination GoogleCloudHealthcareV1DicomBigQueryDestination}]}
  
  Updates the specified DICOM store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-dicomStores-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-dicomStores-getDICOMStoreMetrics$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/getDICOMStoreMetrics
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metrics associated with the DICOM store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:getDICOMStoreMetrics"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/create
  
  Required parameters: parent
  
  Optional parameters: dicomStoreId
  
  Body: 
  
  {:name string,
   :notificationConfig {:pubsubTopic string, :sendForBulkImport boolean},
   :labels {},
   :streamConfigs [{:bigqueryDestination GoogleCloudHealthcareV1DicomBigQueryDestination}]}
  
  Creates a new DICOM store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomStores"
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

(defn locations-datasets-dicomStores-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified DICOM store and removes all images that are contained within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-dicomStores-searchForStudies$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/searchForStudies
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForStudies returns a list of matching studies. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForStudies, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForStudies, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-export$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:gcsDestination {:uriPrefix string, :mimeType string},
   :bigqueryDestination {:tableUri string,
                         :force boolean,
                         :writeDisposition string}}
  
  Exports data to the specified destination by copying it from the DICOM store. Errors are also logged to Cloud Logging. For more information, see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging). The metadata field type is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:export"
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

(defn locations-datasets-dicomStores-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-searchForInstances$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/searchForInstances
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForInstances, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForInstances, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-deidentify$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/deidentify
  
  Required parameters: sourceStore
  
  Optional parameters: none
  
  Body: 
  
  {:destinationStore string,
   :config {:dicom DicomConfig,
            :fhir FhirConfig,
            :image ImageConfig,
            :text TextConfig,
            :useRegionalDataProcessing boolean},
   :gcsConfigUri string,
   :filterConfig {:resourcePathsGcsUri string}}
  
  De-identifies data from the source store and writes it to the destination store. The metadata field type is OperationMetadata. If the request is successful, the response field type is DeidentifyDicomStoreSummary. If errors occur, error is set. The LRO result may still be successful if de-identification fails for some DICOM instances. The output DICOM store will not contain these failed resources. Failed resource totals are tracked in Operation.metadata. Error details are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging))."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sourceStore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+sourceStore}:deidentify"
     #{:sourceStore}
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

(defn locations-datasets-dicomStores-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the DICOM stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-import$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/import
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:gcsSource {:uri string}}
  
  Imports data into the DICOM store by copying it from the specified source. Errors are logged to Cloud Logging. For more information, see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging). The metadata field type is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:import"
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

(defn locations-datasets-dicomStores-storeInstances$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/storeInstances
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  StoreInstances stores DICOM instances associated with study instance unique identifiers (SUID). See [Store Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.5). For details on the implementation of StoreInstances, see [Store transaction](https://cloud.google.com/healthcare/docs/dicom#store_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call StoreInstances, see [Store DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#store-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
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

(defn locations-datasets-dicomStores-studies-retrieveStudy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/retrieveStudy
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveStudy returns all instances within the given study. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveStudy, see [DICOM study/series/instances](https://cloud.google.com/healthcare/docs/dicom#dicom_studyseriesinstances) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveStudy, see [Retrieve DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-retrieveMetadata$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/retrieveMetadata
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveStudyMetadata returns instance associated with the given study presented as metadata with the bulk data removed. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveStudyMetadata, see [Metadata resources](https://cloud.google.com/healthcare/docs/dicom#metadata_resources) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveStudyMetadata, see [Retrieve metadata](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-metadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-searchForSeries$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/searchForSeries
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForSeries returns a list of matching series. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForSeries, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForSeries, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-searchForInstances$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/searchForInstances
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForInstances, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForInstances, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/delete
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  DeleteStudy deletes all instances within the given study. Delete requests are equivalent to the GET requests specified in the Retrieve transaction. The method returns an Operation which will be marked successful when the deletion is complete. Warning: Instances cannot be inserted into a study that is being deleted by an operation until the operation completes. For samples that show how to call DeleteStudy, see [Delete a study, series, or instance](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#delete-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-storeInstances$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/storeInstances
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  StoreInstances stores DICOM instances associated with study instance unique identifiers (SUID). See [Store Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.5). For details on the implementation of StoreInstances, see [Store transaction](https://cloud.google.com/healthcare/docs/dicom#store_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call StoreInstances, see [Store DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#store-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
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

(defn locations-datasets-dicomStores-studies-series-retrieveSeries$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/retrieveSeries
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveSeries returns all instances within the given study and series. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveSeries, see [DICOM study/series/instances](https://cloud.google.com/healthcare/docs/dicom#dicom_studyseriesinstances) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveSeries, see [Retrieve DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-retrieveMetadata$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/retrieveMetadata
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveSeriesMetadata returns instance associated with the given study and series, presented as metadata with the bulk data removed. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveSeriesMetadata, see [Metadata resources](https://cloud.google.com/healthcare/docs/dicom#metadata_resources) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveSeriesMetadata, see [Retrieve metadata](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-metadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-searchForInstances$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/searchForInstances
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See [Search Transaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6). For details on the implementation of SearchForInstances, see [Search transaction](https://cloud.google.com/healthcare/docs/dicom#search_transaction) in the Cloud Healthcare API conformance statement. For samples that show how to call SearchForInstances, see [Search for DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#search-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/delete
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  DeleteSeries deletes all instances within the given study and series. Delete requests are equivalent to the GET requests specified in the Retrieve transaction. The method returns an Operation which will be marked successful when the deletion is complete. Warning: Instances cannot be inserted into a series that is being deleted by an operation until the operation completes. For samples that show how to call DeleteSeries, see [Delete a study, series, or instance](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#delete-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveInstance$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/retrieveInstance
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveInstance returns instance associated with the given study, series, and SOP Instance UID. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveInstance, see [DICOM study/series/instances](https://cloud.google.com/healthcare/docs/dicom#dicom_studyseriesinstances) and [DICOM instances](https://cloud.google.com/healthcare/docs/dicom#dicom_instances) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveInstance, see [Retrieve an instance](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-instance)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveRendered$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/retrieveRendered
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveRenderedInstance returns instance associated with the given study, series, and SOP Instance UID in an acceptable Rendered Media Type. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveRenderedInstance, see [Rendered resources](https://cloud.google.com/healthcare/docs/dicom#rendered_resources) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveRenderedInstance, see [Retrieve consumer image formats](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-consumer)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveMetadata$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/retrieveMetadata
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveInstanceMetadata returns instance associated with the given study, series, and SOP Instance UID presented as metadata with the bulk data removed. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveInstanceMetadata, see [Metadata resources](https://cloud.google.com/healthcare/docs/dicom#metadata_resources) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveInstanceMetadata, see [Retrieve metadata](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-metadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/delete
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  DeleteInstance deletes an instance associated with the given study, series, and SOP Instance UID. Delete requests are equivalent to the GET requests specified in the Retrieve transaction. Study and series search results can take a few seconds to be updated after an instance is deleted using DeleteInstance. For samples that show how to call DeleteInstance, see [Delete a study, series, or instance](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#delete-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-frames-retrieveFrames$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/frames/retrieveFrames
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveFrames returns instances associated with the given study, series, SOP Instance UID and frame numbers. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4}. For details on the implementation of RetrieveFrames, see [DICOM frames](https://cloud.google.com/healthcare/docs/dicom#dicom_frames) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveFrames, see [Retrieve DICOM data](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-dicom)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-frames-retrieveRendered$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/studies/series/instances/frames/retrieveRendered
  
  Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveRenderedFrames returns instances associated with the given study, series, SOP Instance UID and frame numbers in an acceptable Rendered Media Type. See [RetrieveTransaction] (http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4). For details on the implementation of RetrieveRenderedFrames, see [Rendered resources](https://cloud.google.com/healthcare/docs/dicom#rendered_resources) in the Cloud Healthcare API conformance statement. For samples that show how to call RetrieveRenderedFrames, see [Retrieve consumer image formats](https://cloud.google.com/healthcare/docs/how-tos/dicomweb#retrieve-consumer)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :dicomWebPath})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{:parent :dicomWebPath}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-dicomWeb-studies-getStudyMetrics$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/dicomWeb/studies/getStudyMetrics
  
  Required parameters: study
  
  Optional parameters: none
  
  GetStudyMetrics returns metrics for a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:study})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+study}:getStudyMetrics"
     #{:study}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-dicomWeb-studies-series-getSeriesMetrics$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/dicomStores/dicomWeb/studies/series/getSeriesMetrics
  
  Required parameters: series
  
  Optional parameters: none
  
  GetSeriesMetrics returns metrics for a series."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:series})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+series}:getSeriesMetrics"
     #{:series}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified HL7v2 store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-hl7V2Stores-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-hl7V2Stores-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :parserConfig {:allowNullHeader boolean,
                  :segmentTerminator string,
                  :schema SchemaPackage,
                  :version string},
   :labels {},
   :notificationConfigs [{:pubsubTopic string, :filter string}],
   :rejectDuplicateMessage boolean}
  
  Updates the HL7v2 store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-hl7V2Stores-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-hl7V2Stores-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/create
  
  Required parameters: parent
  
  Optional parameters: hl7V2StoreId
  
  Body: 
  
  {:name string,
   :parserConfig {:allowNullHeader boolean,
                  :segmentTerminator string,
                  :schema SchemaPackage,
                  :version string},
   :labels {},
   :notificationConfigs [{:pubsubTopic string, :filter string}],
   :rejectDuplicateMessage boolean}
  
  Creates a new HL7v2 store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/hl7V2Stores"
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

(defn locations-datasets-hl7V2Stores-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified HL7v2 store and removes all messages that it contains."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-hl7V2Stores-export$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string,
   :endTime string,
   :filter string,
   :gcsDestination {:uriPrefix string,
                    :messageView string,
                    :contentStructure string},
   :pubsubDestination {:pubsubTopic string}}
  
  Exports the messages to a destination. To filter messages to be exported, define a filter using the start and end time, relative to the message generation time (MSH.7). This API returns an Operation that can be used to track the status of the job by calling GetOperation. Immediate fatal errors appear in the error field. Otherwise, when the operation finishes, a detailed response of type ExportMessagesResponse is returned in the response field. The metadata field type for this operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:export"
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

(defn locations-datasets-hl7V2Stores-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-getHL7v2StoreMetrics$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/getHL7v2StoreMetrics
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metrics associated with the HL7v2 store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:getHL7v2StoreMetrics"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the HL7v2 stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/hl7V2Stores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-import$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/import
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:gcsSource {:uri string}}
  
  Import messages to the HL7v2 store by loading data from the specified sources. This method is optimized to load large quantities of data using import semantics that ignore some HL7v2 store configuration options and are not suitable for all use cases. It is primarily intended to load data into an empty HL7v2 store that is not being used by other clients. An existing message will be overwritten if a duplicate message is imported. A duplicate message is a message with the same raw bytes as a message that already exists in this HL7v2 store. When a message is overwritten, its labels will also be overwritten. The import operation is idempotent unless the input data contains multiple valid messages with the same raw bytes but different labels. In that case, after the import completes, the store contains exactly one message with those raw bytes but there is no ordering guarantee on which version of the labels it has. The operation result counters do not count duplicated raw bytes as an error and count one success for each message in the input, which might result in a success count larger than the number of messages in the HL7v2 store. If some messages fail to import, for example due to parsing errors, successfully imported messages are not rolled back. This method returns an Operation that can be used to track the status of the import by calling GetOperation. Immediate fatal errors appear in the error field, errors are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)). Otherwise, when the operation finishes, a response of type ImportMessagesResponse is returned in the response field. The metadata field type for this operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:import"
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

(defn locations-datasets-hl7V2Stores-messages-ingest$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/ingest
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:message {:labels {},
             :messageType string,
             :sendTime string,
             :name string,
             :createTime string,
             :parsedData ParsedData,
             :sendFacility string,
             :patientIds [PatientId],
             :schematizedData SchematizedData,
             :data string}}
  
  Parses and stores an HL7v2 message. This method triggers an asynchronous notification to any Pub/Sub topic configured in Hl7V2Store.Hl7V2NotificationConfig, if the filtering matches the message. If an MLLP adapter is configured to listen to a Pub/Sub topic, the adapter transmits the message when a notification is received. If the method is successful, it generates a response containing an HL7v2 acknowledgment (`ACK`) message. If the method encounters an error, it returns a negative acknowledgment (`NACK`) message. This behavior is suitable for replying to HL7v2 interface systems that expect these acknowledgments."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/messages:ingest"
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

(defn locations-datasets-hl7V2Stores-messages-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:message {:labels {},
             :messageType string,
             :sendTime string,
             :name string,
             :createTime string,
             :parsedData ParsedData,
             :sendFacility string,
             :patientIds [PatientId],
             :schematizedData SchematizedData,
             :data string}}
  
  Parses and stores an HL7v2 message. This method triggers an asynchronous notification to any Pub/Sub topic configured in Hl7V2Store.Hl7V2NotificationConfig, if the filtering matches the message. If an MLLP adapter is configured to listen to a Pub/Sub topic, the adapter transmits the message when a notification is received."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/messages"
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

(defn locations-datasets-hl7V2Stores-messages-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets an HL7v2 message."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-hl7V2Stores-messages-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an HL7v2 message."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-hl7V2Stores-messages-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, view
  
  Lists all the messages in the given HL7v2 store with support for filtering. Note: HL7v2 messages are indexed asynchronously, so there might be a slight delay between the time a message is created and when it can be found through a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/messages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/hl7V2Stores/messages/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :messageType string,
   :sendTime string,
   :name string,
   :createTime string,
   :parsedData {:segments [Segment]},
   :sendFacility string,
   :patientIds [{:value string, :type string}],
   :schematizedData {:data string, :error string},
   :data string}
  
  Update the message. The contents of the message in Message.data and data extracted from the contents such as Message.create_time cannot be altered. Only the Message.labels field is allowed to be updated. The labels in the request are merged with the existing set of labels. Existing labels with the same keys are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-rollback$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:type [string],
   :rollbackTime string,
   :filteringFields {:operationIds [string], :metadataFilter string},
   :force boolean,
   :changeType string,
   :resultGcsBucket string,
   :inputGcsObject string,
   :excludeRollbacks boolean}
  
  Rolls back resources from the FHIR store to the specified time. This method returns an Operation that can be used to track the status of the rollback by calling GetOperation. Immediate fatal errors appear in the error field, errors are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)). Otherwise, when the operation finishes, a detailed response of type RollbackFhirResourcesResponse is returned in the response field. The metadata field type for this operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:rollback"
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

(defn locations-datasets-fhirStores-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the configuration of the specified FHIR store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-setIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-datasets-fhirStores-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :streamConfigs [{:resourceTypes [string],
                    :bigqueryDestination GoogleCloudHealthcareV1FhirBigQueryDestination,
                    :deidentifiedStoreDestination DeidentifiedStoreDestination}],
   :name string,
   :notificationConfigs [{:pubsubTopic string,
                          :sendFullResource boolean,
                          :sendPreviousResourceOnDelete boolean}],
   :enableUpdateCreate boolean,
   :complexDataTypeReferenceParsing string,
   :notificationConfig {:pubsubTopic string, :sendForBulkImport boolean},
   :defaultSearchHandlingStrict boolean,
   :validationConfig {:disableProfileValidation boolean,
                      :enabledImplementationGuides [string],
                      :disableRequiredFieldValidation boolean,
                      :disableReferenceTypeValidation boolean,
                      :disableFhirpathValidation boolean},
   :disableResourceVersioning boolean,
   :disableReferentialIntegrity boolean,
   :version string}
  
  Updates the configuration of the specified FHIR store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-testIamPermissions$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-datasets-fhirStores-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/create
  
  Required parameters: parent
  
  Optional parameters: fhirStoreId
  
  Body: 
  
  {:labels {},
   :streamConfigs [{:resourceTypes [string],
                    :bigqueryDestination GoogleCloudHealthcareV1FhirBigQueryDestination,
                    :deidentifiedStoreDestination DeidentifiedStoreDestination}],
   :name string,
   :notificationConfigs [{:pubsubTopic string,
                          :sendFullResource boolean,
                          :sendPreviousResourceOnDelete boolean}],
   :enableUpdateCreate boolean,
   :complexDataTypeReferenceParsing string,
   :notificationConfig {:pubsubTopic string, :sendForBulkImport boolean},
   :defaultSearchHandlingStrict boolean,
   :validationConfig {:disableProfileValidation boolean,
                      :enabledImplementationGuides [string],
                      :disableRequiredFieldValidation boolean,
                      :disableReferenceTypeValidation boolean,
                      :disableFhirpathValidation boolean},
   :disableResourceVersioning boolean,
   :disableReferentialIntegrity boolean,
   :version string}
  
  Creates a new FHIR store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhirStores"
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

(defn locations-datasets-fhirStores-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified FHIR store and removes all resources within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-export$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:gcsDestination {:uriPrefix string},
   :bigqueryDestination {:datasetUri string,
                         :schemaConfig SchemaConfig,
                         :force boolean,
                         :writeDisposition string},
   :_since string,
   :_type string}
  
  Export resources from the FHIR store to the specified destination. This method returns an Operation that can be used to track the status of the export by calling GetOperation. Immediate fatal errors appear in the error field, errors are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)). Otherwise, when the operation finishes, a detailed response of type ExportResourcesResponse is returned in the response field. The metadata field type for this operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:export"
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

(defn locations-datasets-fhirStores-getFHIRStoreMetrics$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/getFHIRStoreMetrics
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metrics associated with the FHIR store."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:getFHIRStoreMetrics"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-getIamPolicy$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-deidentify$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/deidentify
  
  Required parameters: sourceStore
  
  Optional parameters: none
  
  Body: 
  
  {:destinationStore string,
   :config {:dicom DicomConfig,
            :fhir FhirConfig,
            :image ImageConfig,
            :text TextConfig,
            :useRegionalDataProcessing boolean},
   :gcsConfigUri string,
   :resourceFilter {:resources Resources},
   :skipModifiedResources boolean}
  
  De-identifies data from the source store and writes it to the destination store. The metadata field type is OperationMetadata. If the request is successful, the response field type is DeidentifyFhirStoreSummary. If errors occur, error is set. Error details are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging))."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sourceStore})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+sourceStore}:deidentify"
     #{:sourceStore}
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

(defn locations-datasets-fhirStores-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the FHIR stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhirStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-import$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/import
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:contentStructure string, :gcsSource {:uri string}}
  
  Imports resources to the FHIR store by loading data from the specified sources. This method is optimized to load large quantities of data using import semantics that ignore some FHIR store configuration options and are not suitable for all use cases. It is primarily intended to load data into an empty FHIR store that is not being used by other clients. In cases where this method is not appropriate, consider using ExecuteBundle to load data. Every resource in the input must contain a client-supplied ID. Each resource is stored using the supplied ID regardless of the enable_update_create setting on the FHIR store. It is strongly advised not to include or encode any sensitive data such as patient identifiers in client-specified resource IDs. Those IDs are part of the FHIR resource path recorded in Cloud Audit Logs and Cloud Pub/Sub notifications. Those IDs can also be contained in reference fields within other resources. The import process does not enforce referential integrity, regardless of the disable_referential_integrity setting on the FHIR store. This allows the import of resources with arbitrary interdependencies without considering grouping or ordering, but if the input data contains invalid references or if some resources fail to be imported, the FHIR store might be left in a state that violates referential integrity. The import process does not trigger Pub/Sub notification or BigQuery streaming update, regardless of how those are configured on the FHIR store. If a resource with the specified ID already exists, the most recent version of the resource is overwritten without creating a new historical version, regardless of the disable_resource_versioning setting on the FHIR store. If transient failures occur during the import, it's possible that successfully imported resources will be overwritten more than once. The import operation is idempotent unless the input data contains multiple valid resources with the same ID but different contents. In that case, after the import completes, the store contains exactly one resource with that ID but there is no ordering guarantee on which version of the contents it will have. The operation result counters do not count duplicate IDs as an error and count one success for each resource in the input, which might result in a success count larger than the number of resources in the FHIR store. This often occurs when importing data organized in bundles produced by Patient-everything where each bundle contains its own copy of a resource such as Practitioner that might be referred to by many patients. If some resources fail to import, for example due to parsing errors, successfully imported resources are not rolled back. The location and format of the input data is specified by the parameters in ImportResourcesRequest. Note that if no format is specified, this method assumes the `BUNDLE` format. When using the `BUNDLE` format this method ignores the `Bundle.type` field, except that `history` bundles are rejected, and does not apply any of the bundle processing semantics for batch or transaction bundles. Unlike in ExecuteBundle, transaction bundles are not executed as a single transaction and bundle-internal references are not rewritten. The bundle is treated as a collection of resources to be written as provided in `Bundle.entry.resource`, ignoring `Bundle.entry.request`. As an example, this allows the import of `searchset` bundles produced by a FHIR search or Patient-everything operation. This method returns an Operation that can be used to track the status of the import by calling GetOperation. Immediate fatal errors appear in the error field, errors are also logged to Cloud Logging (see [Viewing error logs in Cloud Logging](https://cloud.google.com/healthcare/docs/how-tos/logging)). Otherwise, when the operation finishes, a detailed response of type ImportResourcesResponse is returned in the response field. The metadata field type for this operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:import"
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

(defn locations-datasets-fhirStores-fhir-capabilities$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/capabilities
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the FHIR capability statement ([STU3](http://hl7.org/implement/standards/fhir/STU3/capabilitystatement.html), [R4](http://hl7.org/implement/standards/fhir/R4/capabilitystatement.html)), or the [conformance statement](http://hl7.org/implement/standards/fhir/DSTU2/conformance.html) in the DSTU2 case for the store, which contains a description of functionality supported by the server. Implements the FHIR standard capabilities interaction ([STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#capabilities), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#capabilities)), or the [conformance interaction](http://hl7.org/implement/standards/fhir/DSTU2/http.html#conformance) in the DSTU2 case. On success, the response body contains a JSON-encoded representation of a `CapabilityStatement` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/fhir/metadata"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-Resource-purge$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/Resource-purge
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes all the historical versions of a resource (excluding the current version) from the FHIR store. To remove all versions of a resource, first delete the current version and then call this method. This is not a FHIR standard operation. For samples that show how to call `Resource-purge`, see [Deleting historical versions of a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#deleting_historical_versions_of_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/$purge"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-conditionalUpdate$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/conditionalUpdate
  
  Required parameters: parent, type
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  If a resource is found with the identifier specified in the query parameters, updates the entire contents of that resource. Implements the FHIR standard conditional update interaction, limited to searching by resource identifier. Search term for identifier should be in the pattern `identifier=system|value` or `identifier=value` - similar to the `search` method on resources with a specific identifier. If the search criteria identify more than one match, the request returns a `412 Precondition Failed` error. If the search criteria identify zero matches, and the supplied resource body contains an `id`, and the FHIR store has enable_update_create set, creates the resource with the client-specified ID. It is strongly advised not to include or encode any sensitive data such as patient identifiers in client-specified resource IDs. Those IDs are part of the FHIR resource path recorded in Cloud Audit Logs and Pub/Sub notifications. Those IDs can also be contained in reference fields within other resources. If the search criteria identify zero matches, and the supplied resource body does not contain an `id`, the resource is created with a server-assigned ID as per the create method. The request body must contain a JSON-encoded FHIR resource, and the request headers must contain `Content-Type: application/fhir+json`. On success, the response body contains a JSON-encoded representation of the updated resource, including the server-assigned version ID. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `conditionalUpdate`, see [Conditionally updating a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#conditionally_updating_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{+type}"
     #{:parent :type}
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

(defn locations-datasets-fhirStores-fhir-read$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/read
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the contents of a FHIR resource. Implements the FHIR standard read interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#read), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#read), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#read)). Also supports the FHIR standard conditional read interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#cread), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#cread), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#cread)) specified by supplying an `If-Modified-Since` header with a date/time value or an `If-None-Match` header with an ETag value. On success, the response body contains a JSON-encoded representation of the resource. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `read`, see [Getting a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#getting_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-fhir-patch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  Updates part of an existing resource by applying the operations specified in a [JSON Patch](http://jsonpatch.com/) document. Implements the FHIR standard patch interaction ([STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#patch), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#patch)). DSTU2 doesn't define a patch method, but the server supports it in the same way it supports STU3. The request body must contain a JSON Patch document, and the request headers must contain `Content-Type: application/json-patch+json`. On success, the response body contains a JSON-encoded representation of the updated resource, including the server-assigned version ID. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `patch`, see [Patching a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#patching_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-fhir-create$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/create
  
  Required parameters: parent, type
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  Creates a FHIR resource. Implements the FHIR standard create interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#create), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#create), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#create)), which creates a new resource with a server-assigned resource ID. Also supports the FHIR standard conditional create interaction ([DSTU2](https://hl7.org/implement/standards/fhir/DSTU2/http.html#ccreate), [STU3](https://hl7.org/implement/standards/fhir/STU3/http.html#ccreate), [R4](https://hl7.org/implement/standards/fhir/R4/http.html#ccreate)), specified by supplying an `If-None-Exist` header containing a FHIR search query, limited to searching by resource identifier. If no resources match this search query, the server processes the create operation as normal. When using conditional create, the search term for identifier should be in the pattern `identifier=system|value` or `identifier=value` - similar to the `search` method on resources with a specific identifier. The request body must contain a JSON-encoded FHIR resource, and the request headers must contain `Content-Type: application/fhir+json`. On success, the response body contains a JSON-encoded representation of the resource as it was created on the server, including the server-assigned resource ID and version ID. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `create`, see [Creating a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#creating_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{+type}"
     #{:parent :type}
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

(defn locations-datasets-fhirStores-fhir-history$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/history
  
  Required parameters: name
  
  Optional parameters: _count, _since, _at, _page_token
  
  Lists all the versions of a resource (including the current version and deleted versions) from the FHIR store. Implements the per-resource form of the FHIR standard history interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#history), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#history), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#history)). On success, the response body contains a JSON-encoded representation of a `Bundle` resource of type `history`, containing the version history sorted from most recent to oldest versions. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `history`, see [Listing FHIR resource versions](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#listing_fhir_resource_versions)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/_history"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-update$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  Updates the entire contents of a resource. Implements the FHIR standard update interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#update), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#update), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#update)). If the specified resource does not exist and the FHIR store has enable_update_create set, creates the resource with the client-specified ID. It is strongly advised not to include or encode any sensitive data such as patient identifiers in client-specified resource IDs. Those IDs are part of the FHIR resource path recorded in Cloud Audit Logs and Pub/Sub notifications. Those IDs can also be contained in reference fields within other resources. The request body must contain a JSON-encoded FHIR resource, and the request headers must contain `Content-Type: application/fhir+json`. The resource must contain an `id` element having an identical value to the ID in the REST path of the request. On success, the response body contains a JSON-encoded representation of the updated resource, including the server-assigned version ID. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `update`, see [Updating a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#updating_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-fhir-delete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a FHIR resource. Implements the FHIR standard delete interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#delete), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#delete), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#delete)). Note: Unless resource versioning is disabled by setting the disable_resource_versioning flag on the FHIR store, the deleted resources will be moved to a history repository that can still be retrieved through vread and related methods, unless they are removed by the purge method. For samples that show how to call `delete`, see [Deleting a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#deleting_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-fhir-Resource-validate$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/Resource-validate
  
  Required parameters: parent, type
  
  Optional parameters: profile
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  Validates an input FHIR resource's conformance to its profiles and the profiles configured on the FHIR store. Implements the FHIR extended operation $validate ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/resource-operations.html#validate), [STU3](http://hl7.org/implement/standards/fhir/STU3/resource-operations.html#validate), or [R4](http://hl7.org/implement/standards/fhir/R4/resource-operation-validate.html)). The request body must contain a JSON-encoded FHIR resource, and the request headers must contain `Content-Type: application/fhir+json`. The `Parameters` input syntax is not supported. The `profile` query parameter can be used to request that the resource only be validated against a specific profile. If a profile with the given URL cannot be found in the FHIR store then an error is returned. Errors generated by validation contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{+type}/$validate"
     #{:parent :type}
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

(defn locations-datasets-fhirStores-fhir-Patient-everything$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/Patient-everything
  
  Required parameters: name
  
  Optional parameters: start, end, _page_token, _count, _since, _type
  
  Retrieves a Patient resource and resources related to that patient. Implements the FHIR extended operation Patient-everything ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/patient-operations.html#everything), [STU3](http://hl7.org/implement/standards/fhir/STU3/patient-operations.html#everything), [R4](http://hl7.org/implement/standards/fhir/R4/patient-operations.html#everything)). On success, the response body contains a JSON-encoded representation of a `Bundle` resource of type `searchset`, containing the results of the operation. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. The resources in scope for the response are: * The patient resource itself. * All the resources directly referenced by the patient resource. * Resources directly referencing the patient resource that meet the inclusion criteria. The inclusion criteria are based on the membership rules in the patient compartment definition ([DSTU2](http://hl7.org/fhir/DSTU2/compartment-patient.html), [STU3](http://www.hl7.org/fhir/stu3/compartmentdefinition-patient.html), [R4](http://hl7.org/fhir/R4/compartmentdefinition-patient.html)), which details the eligible resource types and referencing search parameters. For samples that show how to call `Patient-everything`, see [Getting all patient compartment resources](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#getting_all_patient_compartment_resources)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/$everything"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-search$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/search
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:resourceType string}
  
  Searches for resources in the given FHIR store according to criteria specified as query parameters. Implements the FHIR standard search interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#search), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#search), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#search)) using the search semantics described in the FHIR Search specification ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/search.html), [STU3](http://hl7.org/implement/standards/fhir/STU3/search.html), [R4](http://hl7.org/implement/standards/fhir/R4/search.html)). Supports four methods of search defined by the specification: * `GET [base]?[parameters]` to search across all resources. * `GET [base]/[type]?[parameters]` to search resources of a specified type. * `POST [base]/_search?[parameters]` as an alternate form having the same semantics as the `GET` method across all resources. * `POST [base]/[type]/_search?[parameters]` as an alternate form having the same semantics as the `GET` method for the specified type. The `GET` and `POST` methods do not support compartment searches. The `POST` method does not support `application/x-www-form-urlencoded` search parameters. On success, the response body contains a JSON-encoded representation of a `Bundle` resource of type `searchset`, containing the results of the search. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. The server's capability statement, retrieved through capabilities, indicates what search parameters are supported on each FHIR resource. A list of all search parameters defined by the specification can be found in the FHIR Search Parameter Registry ([STU3](http://hl7.org/implement/standards/fhir/STU3/searchparameter-registry.html), [R4](http://hl7.org/implement/standards/fhir/R4/searchparameter-registry.html)). FHIR search parameters for DSTU2 can be found on each resource's definition page. Supported search modifiers: `:missing`, `:exact`, `:contains`, `:text`, `:in`, `:not-in`, `:above`, `:below`, `:[type]`, `:not`, and `recurse` (DSTU2 and STU3) or `:iterate` (R4). Supported search result parameters: `_sort`, `_count`, `_include`, `_revinclude`, `_summary=text`, `_summary=data`, and `_elements`. The maximum number of search results returned defaults to 100, which can be overridden by the `_count` parameter up to a maximum limit of 1000. The server might return fewer resources than requested to prevent excessively large responses. If there are additional results, the returned `Bundle` contains a link of `relation` \"next\", which has a `_page_token` parameter for an opaque pagination token that can be used to retrieve the next page. Resources with a total size larger than 5MB or a field count larger than 50,000 might not be fully searchable as the server might trim its generated search index in those cases. Note: FHIR resources are indexed asynchronously, so there might be a slight delay between the time a resource is created or changed, and the time when the change reflects in search results. The only exception is resource identifier data, which is indexed synchronously as a special index. As a result, searching using resource identifier is not subject to indexing delay. To use the special synchronous index, the search term for identifier should be in the pattern `identifier=[system]|[value]` or `identifier=[value]`, and any of the following search result parameters can be used: * `_count` * `_include` * `_revinclude` * `_summary` * `_elements` If your query contains any other search parameters, the standard asynchronous index will be used instead. Note that searching against the special index is optimized for resolving a small number of matches. The search isn't optimized if your identifier search criteria matches a large number (i.e. more than 2,000) of resources. For a search query that will match a large number of resources, you can avoiding using the special synchronous index by including an additional `_sort` parameter in your query. Use `_sort=-_lastUpdated` if you want to keep the default sorting order. Note: The special synchronous identifier index are currently disabled for DocumentReference and DocumentManifest searches. For samples and detailed information, see [Searching for FHIR resources](https://cloud.google.com/healthcare/docs/how-tos/fhir-search) and [Advanced FHIR search features](https://cloud.google.com/healthcare/docs/how-tos/fhir-advanced-search)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/_search"
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

(defn locations-datasets-fhirStores-fhir-executeBundle$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/executeBundle
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  Executes all the requests in the given Bundle. Implements the FHIR standard batch/transaction interaction ([DSTU2](https://hl7.org/implement/standards/fhir/DSTU2/http.html#transaction), [STU3](https://hl7.org/implement/standards/fhir/STU3/http.html#transaction), [R4](https://hl7.org/implement/standards/fhir/R4/http.html#transaction)). Supports all interactions within a bundle, except search. This method accepts Bundles of type `batch` and `transaction`, processing them according to the batch processing rules ([DSTU2](https://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.16.1), [STU3](https://hl7.org/implement/standards/fhir/STU3/http.html#2.21.0.17.1), [R4](https://hl7.org/implement/standards/fhir/R4/http.html#brules)) and transaction processing rules ([DSTU2](https://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.16.2), [STU3](https://hl7.org/implement/standards/fhir/STU3/http.html#2.21.0.17.2), [R4](https://hl7.org/implement/standards/fhir/R4/http.html#trules)). The request body must contain a JSON-encoded FHIR `Bundle` resource, and the request headers must contain `Content-Type: application/fhir+json`. For a batch bundle or a successful transaction, the response body contains a JSON-encoded representation of a `Bundle` resource of type `batch-response` or `transaction-response` containing one entry for each entry in the request, with the outcome of processing the entry. In the case of an error for a transaction bundle, the response body contains a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. This method checks permissions for each request in the bundle. The `executeBundle` permission is required to call this method, but you must also grant sufficient permissions to execute the individual requests in the bundle. For example, if the bundle contains a request to create a FHIR resource, the caller must also have been granted the `healthcare.fhirResources.create` permission. You can use audit logs to view the permissions for `executeBundle` and each request in the bundle. For more information, see [Viewing Cloud Audit logs](https://cloud.google.com/healthcare-api/docs/how-tos/audit-logging). For samples that show how to call `executeBundle`, see [Managing FHIR resources using FHIR bundles](https://cloud.google.com/healthcare/docs/how-tos/fhir-bundles)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir"
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

(defn locations-datasets-fhirStores-fhir-vread$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/vread
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the contents of a version (current or historical) of a FHIR resource by version ID. Implements the FHIR standard vread interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#vread), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#vread), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#vread)). On success, the response body contains a JSON-encoded representation of the resource. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `vread`, see [Retrieving a FHIR resource version](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#retrieving_a_fhir_resource_version)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-fhirStores-fhir-search-type$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/search-type
  
  Required parameters: parent, resourceType
  
  Optional parameters: none
  
  Body: 
  
  {:resourceType string}
  
  Searches for resources in the given FHIR store according to criteria specified as query parameters. Implements the FHIR standard search interaction ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#search), [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#search), [R4](http://hl7.org/implement/standards/fhir/R4/http.html#search)) using the search semantics described in the FHIR Search specification ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/search.html), [STU3](http://hl7.org/implement/standards/fhir/STU3/search.html), [R4](http://hl7.org/implement/standards/fhir/R4/search.html)). Supports four methods of search defined by the specification: * `GET [base]?[parameters]` to search across all resources. * `GET [base]/[type]?[parameters]` to search resources of a specified type. * `POST [base]/_search?[parameters]` as an alternate form having the same semantics as the `GET` method across all resources. * `POST [base]/[type]/_search?[parameters]` as an alternate form having the same semantics as the `GET` method for the specified type. The `GET` and `POST` methods do not support compartment searches. The `POST` method does not support `application/x-www-form-urlencoded` search parameters. On success, the response body contains a JSON-encoded representation of a `Bundle` resource of type `searchset`, containing the results of the search. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. The server's capability statement, retrieved through capabilities, indicates what search parameters are supported on each FHIR resource. A list of all search parameters defined by the specification can be found in the FHIR Search Parameter Registry ([STU3](http://hl7.org/implement/standards/fhir/STU3/searchparameter-registry.html), [R4](http://hl7.org/implement/standards/fhir/R4/searchparameter-registry.html)). FHIR search parameters for DSTU2 can be found on each resource's definition page. Supported search modifiers: `:missing`, `:exact`, `:contains`, `:text`, `:in`, `:not-in`, `:above`, `:below`, `:[type]`, `:not`, and `recurse` (DSTU2 and STU3) or `:iterate` (R4). Supported search result parameters: `_sort`, `_count`, `_include`, `_revinclude`, `_summary=text`, `_summary=data`, and `_elements`. The maximum number of search results returned defaults to 100, which can be overridden by the `_count` parameter up to a maximum limit of 1000. The server might return fewer resources than requested to prevent excessively large responses. If there are additional results, the returned `Bundle` contains a link of `relation` \"next\", which has a `_page_token` parameter for an opaque pagination token that can be used to retrieve the next page. Resources with a total size larger than 5MB or a field count larger than 50,000 might not be fully searchable as the server might trim its generated search index in those cases. Note: FHIR resources are indexed asynchronously, so there might be a slight delay between the time a resource is created or changed, and the time when the change reflects in search results. The only exception is resource identifier data, which is indexed synchronously as a special index. As a result, searching using resource identifier is not subject to indexing delay. To use the special synchronous index, the search term for identifier should be in the pattern `identifier=[system]|[value]` or `identifier=[value]`, and any of the following search result parameters can be used: * `_count` * `_include` * `_revinclude` * `_summary` * `_elements` If your query contains any other search parameters, the standard asynchronous index will be used instead. Note that searching against the special index is optimized for resolving a small number of matches. The search isn't optimized if your identifier search criteria matches a large number (i.e. more than 2,000) of resources. For a search query that will match a large number of resources, you can avoiding using the special synchronous index by including an additional `_sort` parameter in your query. Use `_sort=-_lastUpdated` if you want to keep the default sorting order. Note: The special synchronous identifier index are currently disabled for DocumentReference and DocumentManifest searches. For samples and detailed information, see [Searching for FHIR resources](https://cloud.google.com/healthcare/docs/how-tos/fhir-search) and [Advanced FHIR search features](https://cloud.google.com/healthcare/docs/how-tos/fhir-advanced-search)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :resourceType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{resourceType}/_search"
     #{:parent :resourceType}
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

(defn locations-datasets-fhirStores-fhir-conditionalPatch$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/conditionalPatch
  
  Required parameters: parent, type
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string, :data string, :extensions [{}]}
  
  If a resource is found with the identifier specified in the query parameters, updates part of that resource by applying the operations specified in a [JSON Patch](http://jsonpatch.com/) document. Implements the FHIR standard conditional patch interaction, limited to searching by resource identifier. DSTU2 doesn't define a conditional patch method, but the server supports it in the same way it supports STU3. Search term for identifier should be in the pattern `identifier=system|value` or `identifier=value` - similar to the `search` method on resources with a specific identifier. If the search criteria identify more than one match, the request returns a `412 Precondition Failed` error. The request body must contain a JSON Patch document, and the request headers must contain `Content-Type: application/json-patch+json`. On success, the response body contains a JSON-encoded representation of the updated resource, including the server-assigned version ID. Errors generated by the FHIR store contain a JSON-encoded `OperationOutcome` resource describing the reason for the error. If the request cannot be mapped to a valid API method on a FHIR store, a generic GCP error might be returned instead. For samples that show how to call `conditionalPatch`, see [Conditionally patching a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#conditionally_patching_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{+type}"
     #{:parent :type}
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

(defn locations-datasets-fhirStores-fhir-conditionalDelete$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/fhirStores/fhir/conditionalDelete
  
  Required parameters: parent, type
  
  Optional parameters: none
  
  Deletes a FHIR resource that match an identifier search query. Implements the FHIR standard conditional delete interaction, limited to searching by resource identifier. If multiple resources match, 412 Precondition Failed error will be returned. Search term for identifier should be in the pattern `identifier=system|value` or `identifier=value` - similar to the `search` method on resources with a specific identifier. Note: Unless resource versioning is disabled by setting the disable_resource_versioning flag on the FHIR store, the deleted resource is moved to a history repository that can still be retrieved through vread and related methods, unless they are removed by the purge method. For samples that show how to call `conditionalDelete`, see [Conditionally deleting a FHIR resource](https://cloud.google.com/healthcare/docs/how-tos/fhir-resources#conditionally_deleting_a_fhir_resource)."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+parent}/fhir/{+type}"
     #{:parent :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-list$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-get$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
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

(defn locations-datasets-operations-cancel$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/datasets/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-services-nlp-analyzeEntities$
  "https://cloud.google.com/healthcareapi/reference/rest/v1/projects/locations/services/nlp/analyzeEntities
  
  Required parameters: nlpService
  
  Optional parameters: none
  
  Body: 
  
  {:documentContent string,
   :licensedVocabularies [string],
   :alternativeOutputFormat string}
  
  Analyze heathcare entity in a document. Its response includes the recognized entity mentions and the relationships between them. AnalyzeEntities uses context aware models to detect entities."
  {:scopes ["https://www.googleapis.com/auth/cloud-healthcare"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:nlpService})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1/{+nlpService}:analyzeEntities"
     #{:nlpService}
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
