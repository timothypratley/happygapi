(ns happygapi.healthcare.projects
  "Cloud Healthcare API
  Manage, store, and access healthcare data in Google Cloud Platform.
  See: https://cloud.google.com/healthcare"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "healthcare_schema.edn"))))

(defn locations-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets any metadata associated with a dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates dataset metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-create$
  "Required parameters: parent
  
  Optional parameters: datasetId
  
  Creates a new health dataset. Results are returned through the
  Operation interface which returns either an
  `Operation.response` which contains a Dataset or
  `Operation.error`. The metadata
  field type is OperationMetadata.
  A Google Cloud Platform project can contain up to 500 datasets across all
  regions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/datasets"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified health dataset and all data contained in the dataset.
  Deleting a dataset does not affect the sources from which the dataset was
  imported (if any)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-deidentify$
  "Required parameters: sourceDataset
  
  Optional parameters: none
  
  Creates a new dataset containing de-identified data from the source
  dataset. The metadata field type
  is OperationMetadata.
  If the request is successful, the
  response field type is
  DeidentifySummary.
  If errors occur,
  error
  details field type is
  DeidentifyErrorDetails.
  Errors are also logged to Stackdriver Logging. For more information,
  see [Viewing logs](/healthcare/docs/how-tos/stackdriver-logging)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"sourceDataset"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+sourceDataset}:deidentify"
     #{"sourceDataset"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the health datasets in the current project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/datasets"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationStores-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-annotationStores-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-annotationStores-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the configuration of the specified FHIR store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the configuration of the specified FHIR store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-create$
  "Required parameters: parent
  
  Optional parameters: fhirStoreId
  
  Creates a new FHIR store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhirStores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified FHIR store and removes all resources within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-export$
  "Required parameters: name
  
  Optional parameters: none
  
  Export resources from the FHIR store to the specified destination.
  
  This method returns an Operation that can
  be used to track the status of the export by calling
  GetOperation.
  
  Immediate fatal errors appear in the
  error field, errors are also logged
  to Stackdriver (see [Viewing
  logs](/healthcare/docs/how-tos/stackdriver-logging)).
  Otherwise, when the operation finishes, a detailed response of type
  ExportResourcesResponse is returned in the
  response field.
  The metadata field type for this
  operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}:export"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-deidentify$
  "Required parameters: sourceStore
  
  Optional parameters: none
  
  De-identifies data from the source store and writes it to the destination
  store. The metadata field type
  is OperationMetadata.
  If the request is successful, the
  response field type is
  DeidentifyFhirStoreSummary. If errors occur,
  error
  details field type is
  DeidentifyErrorDetails.
  Errors are also logged to Stackdriver
  (see [Viewing logs](/healthcare/docs/how-tos/stackdriver-logging))."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"sourceStore"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+sourceStore}:deidentify"
     #{"sourceStore"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists the FHIR stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhirStores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-import$
  "Required parameters: name
  
  Optional parameters: none
  
  Import resources to the FHIR store by loading data from the specified
  sources. This method is optimized to load large quantities of data using
  import semantics that ignore some FHIR store configuration options and are
  not suitable for all use cases. It is primarily intended to load data into
  an empty FHIR store that is not being used by other clients. In cases
  where this method is not appropriate, consider using ExecuteBundle to
  load data.
  
  Every resource in the input must contain a client-supplied ID, and will be
  stored using that ID regardless of the
  enable_update_create setting on the FHIR
  store.
  
  The import process does not enforce referential integrity, regardless of
  the
  disable_referential_integrity
  setting on the FHIR store. This allows the import of resources with
  arbitrary interdependencies without considering grouping or ordering, but
  if the input data contains invalid references or if some resources fail to
  be imported, the FHIR store might be left in a state that violates
  referential integrity.
  
  If a resource with the specified ID already exists, the most recent
  version of the resource is overwritten without creating a new historical
  version, regardless of the
  disable_resource_versioning
  setting on the FHIR store. If transient failures occur during the import,
  it is possible that successfully imported resources will be overwritten
  more than once.
  
  The import operation is idempotent unless the input data contains multiple
  valid resources with the same ID but different contents. In that case,
  after the import completes, the store will contain exactly one resource
  with that ID but there is no ordering guarantee on which version of the
  contents it will have. The operation result counters do not count
  duplicate IDs as an error and will count one success for each resource in
  the input, which might result in a success count larger than the number
  of resources in the FHIR store. This often occurs when importing data
  organized in bundles produced by Patient-everything
  where each bundle contains its own copy of a resource such as Practitioner
  that might be referred to by many patients.
  
  If some resources fail to import, for example due to parsing errors,
  successfully imported resources are not rolled back.
  
  The location and format of the input data is specified by the parameters
  below. Note that if no format is specified, this method assumes the
  `BUNDLE` format. When using the `BUNDLE` format this method ignores the
  `Bundle.type` field, except that `history` bundles are rejected, and does
  not apply any of the bundle processing semantics for batch or transaction
  bundles. Unlike in ExecuteBundle, transaction bundles are not executed
  as a single transaction and bundle-internal references are not rewritten.
  The bundle is treated as a collection of resources to be written as
  provided in `Bundle.entry.resource`, ignoring `Bundle.entry.request`. As
  an example, this allows the import of `searchset` bundles produced by a
  FHIR search or
  Patient-everything operation.
  
  This method returns an Operation that can
  be used to track the status of the import by calling
  GetOperation.
  
  Immediate fatal errors appear in the
  error field, errors are also logged
  to Stackdriver (see [Viewing
  logs](/healthcare/docs/how-tos/stackdriver-logging)). Otherwise, when the
  operation finishes, a detailed response of type ImportResourcesResponse
  is returned in the response field.
  The metadata field type for this
  operation is OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}:import"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-fhir-capabilities$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the FHIR capability statement
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/capabilitystatement.html),
  [R4](http://hl7.org/implement/standards/fhir/R4/capabilitystatement.html)),
  or the [conformance
  statement](http://hl7.org/implement/standards/fhir/DSTU2/conformance.html)
  in the DSTU2 case for the store, which contains a description of
  functionality supported by the server.
  
  Implements the FHIR standard capabilities interaction
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#capabilities),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#capabilities)),
  or the [conformance
  interaction](http://hl7.org/implement/standards/fhir/DSTU2/http.html#conformance)
  in the DSTU2 case.
  
  On success, the response body will contain a JSON-encoded representation
  of a `CapabilityStatement` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/fhir/metadata"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-Resource-purge$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes all the historical versions of a resource (excluding the current
  version) from the FHIR store. To remove all versions of a resource, first
  delete the current version and then call this method.
  
  This is not a FHIR standard operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/$purge"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-conditionalUpdate$
  "Required parameters: parent, type
  
  Optional parameters: none
  
  If a resource is found based on the search criteria specified in the query
  parameters, updates the entire contents of that resource.
  
  Implements the FHIR standard conditional update interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.10.2),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#cond-update),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#cond-update)).
  
  Search terms are provided as query parameters following the same pattern as
  the search method.
  
  If the search criteria identify more than one match, the request will
  return a `412 Precondition Failed` error.
  If the search criteria identify zero matches, and the supplied resource
  body contains an `id`, and the FHIR store has
  enable_update_create set, creates the
  resource with the client-specified ID. If the search criteria identify zero
  matches, and the supplied resource body does not contain an `id`, the
  resource will be created with a server-assigned ID as per the
  create method.
  
  The request body must contain a JSON-encoded FHIR resource, and the request
  headers must contain `Content-Type: application/fhir+json`.
  
  On success, the response body will contain a JSON-encoded representation
  of the updated resource, including the server-assigned version ID.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "type"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/{+type}"
     #{"parent" "type"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-read$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the contents of a FHIR resource.
  
  Implements the FHIR standard read interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#read),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#read),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#read)).
  
  Also supports the FHIR standard conditional read interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#cread),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#cread),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#cread))
  specified by supplying an `If-Modified-Since` header with a date/time value
  or an `If-None-Match` header with an ETag value.
  
  On success, the response body will contain a JSON-encoded representation
  of the resource.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates part of an existing resource by applying the operations specified
  in a [JSON Patch](http://jsonpatch.com/) document.
  
  Implements the FHIR standard patch interaction
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#patch),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#patch)]).
  
  DSTU2 doesn't define a patch method, but the server supports it in the same
  way it supports STU3.
  
  The request body must contain a JSON Patch document, and the request
  headers must contain `Content-Type: application/json-patch+json`.
  
  On success, the response body will contain a JSON-encoded representation
  of the updated resource, including the server-assigned version ID.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-create$
  "Required parameters: parent, type
  
  Optional parameters: none
  
  Creates a FHIR resource.
  
  Implements the FHIR standard create interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#create),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#create),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#create)),
  which creates a new resource with a server-assigned resource ID.
  
  Also supports the FHIR standard conditional create interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#ccreate),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#ccreate),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#ccreate)),
  specified by supplying an `If-None-Exist` header containing a FHIR search
  query. If no resources match this search query, the server processes the
  create operation as normal.
  
  The request body must contain a JSON-encoded FHIR resource, and the request
  headers must contain `Content-Type: application/fhir+json`.
  
  On success, the response body will contain a JSON-encoded representation
  of the resource as it was created on the server, including the
  server-assigned resource ID and version ID.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent" "type"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/{+type}"
     #{"parent" "type"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-fhir-history$
  "Required parameters: name
  
  Optional parameters: _since, _at, _page_token, _count
  
  Lists all the versions of a resource (including the current version and
  deleted versions) from the FHIR store.
  
  Implements the per-resource form of the FHIR standard history interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#history),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#history),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#history)).
  
  On success, the response body will contain a JSON-encoded representation
  of a `Bundle` resource of type `history`, containing the version history
  sorted from most recent to oldest versions.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/_history"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates the entire contents of a resource.
  
  Implements the FHIR standard update interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#update),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#update),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#update)).
  
  If the specified resource does
  not exist and the FHIR store has
  enable_update_create set, creates the
  resource with the client-specified ID.
  
  The request body must contain a JSON-encoded FHIR resource, and the request
  headers must contain `Content-Type: application/fhir+json`. The resource
  must contain an `id` element having an identical value to the ID in the
  REST path of the request.
  
  On success, the response body will contain a JSON-encoded representation
  of the updated resource, including the server-assigned version ID.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a FHIR resource.
  
  Implements the FHIR standard delete interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#delete),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#delete),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#delete)).
  
  Note: Unless resource versioning is disabled by setting the
  disable_resource_versioning flag
  on the FHIR store, the deleted resources will be moved to a history
  repository that can still be retrieved through vread
  and related methods, unless they are removed by the
  purge method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-Patient-everything$
  "Required parameters: name
  
  Optional parameters: _page_token, end, _count, start
  
  On success, the response body will contain a JSON-encoded representation
  of a `Bundle` resource of type `searchset`, containing the results of the
  operation.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/$everything"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-search$
  "Required parameters: parent
  
  Optional parameters: none
  
  Searches for resources in the given FHIR store according to criteria
  specified as query parameters.
  
  Implements the FHIR standard search interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#search),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#search),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#search))
  using the search semantics described in the FHIR Search specification
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/search.html),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/search.html),
  [R4](http://hl7.org/implement/standards/fhir/R4/search.html)).
  
  Supports three methods of search defined by the specification:
  
  *  `GET [base]?[parameters]` to search across all resources.
  *  `GET [base]/[type]?[parameters]` to search resources of a specified
  type.
  *  `POST [base]/[type]/_search?[parameters]` as an alternate form having
  the same semantics as the `GET` method.
  
  The `GET` methods do not support compartment searches. The `POST` method
  does not support `application/x-www-form-urlencoded` search parameters.
  
  On success, the response body will contain a JSON-encoded representation
  of a `Bundle` resource of type `searchset`, containing the results of the
  search.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead.
  
  The server's capability statement, retrieved through
  capabilities, indicates what search parameters
  are supported on each FHIR resource. A list of all search parameters
  defined by the specification can be found in the FHIR Search Parameter
  Registry
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/searchparameter-registry.html),
  [R4](http://hl7.org/implement/standards/fhir/R4/searchparameter-registry.html)).
  FHIR search parameters for DSTU2 can be found on each resource's definition
  page.
  
  Supported search modifiers: `:missing`, `:exact`, `:contains`, `:text`,
  `:in`, `:not-in`, `:above`, `:below`, `:[type]`, `:not`, and `:recurse`.
  
  Supported search result parameters: `_sort`, `_count`, `_include`,
  `_revinclude`, `_summary=text`, `_summary=data`, and `_elements`.
  
  The maximum number of search results returned defaults to 100, which can
  be overridden by the `_count` parameter up to a maximum limit of 1000. If
  there are additional results, the returned `Bundle` will contain
  pagination links.
  
  Resources with a total size larger than 5MB or a field count larger than
  50,000 might not be fully searchable as the server might trim its generated
  search index in those cases.
  
  Note: FHIR resources are indexed asynchronously, so there might be a slight
  delay between the time a resource is created or changes and when the change
  is reflected in search results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/_search"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-fhir-executeBundle$
  "Required parameters: parent
  
  Optional parameters: none
  
  Executes all the requests in the given Bundle.
  
  Implements the FHIR standard batch/transaction interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#transaction),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#transaction),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#transaction)).
  
  Supports all interactions within a bundle, except search. This method
  accepts Bundles of type `batch` and `transaction`, processing them
  according to the batch processing rules
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.16.1),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#2.21.0.17.1),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#brules))
  and transaction processing rules
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.16.2),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#2.21.0.17.2),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#trules)).
  
  The request body must contain a JSON-encoded FHIR `Bundle` resource, and
  the request headers must contain `Content-Type: application/fhir+json`.
  
  For a batch bundle or a successful transaction the response body will
  contain a JSON-encoded representation of a `Bundle` resource of type
  `batch-response` or `transaction-response` containing one entry for each
  entry in the request, with the outcome of processing the entry. In the
  case of an error for a transaction bundle, the response body will contain
  a JSON-encoded `OperationOutcome` resource describing the reason for the
  error. If the request cannot be mapped to a valid API method on a FHIR
  store, a generic GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-fhirStores-fhir-vread$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the contents of a version (current or historical) of a FHIR resource
  by version ID.
  
  Implements the FHIR standard vread interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#vread),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#vread),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#vread)).
  
  On success, the response body will contain a JSON-encoded representation
  of the resource.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-Observation-lastn$
  "Required parameters: parent
  
  Optional parameters: none
  
  Retrieves the N most recent `Observation` resources for a subject matching
  search criteria specified as query parameters, grouped by
  `Observation.code`, sorted from most recent to oldest.
  
  Implements the FHIR extended operation Observation-lastn
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/observation-operations.html#lastn),
  [R4](http://hl7.org/implement/standards/fhir/R4/observation-operations.html#lastn)).
  
  DSTU2 doesn't define the Observation-lastn method, but the server supports
  it the same way it supports STU3.
  
  Search terms are provided as query parameters following the same pattern as
  the search method. The following search parameters must
  be provided:
  
      - `subject` or `patient` to specify a subject for the Observation.
      - `code`, `category` or any of the composite parameters that include
        `code`.
  
  Any other valid Observation search parameters can also be provided. This
  operation accepts an additional query parameter `max`, which specifies N,
  the maximum number of Observations to return from each group, with a
  default of 1.
  
  Searches with over 1000 results are rejected. Results are counted before
  grouping and limiting the results with `max`. To stay within the limit,
  constrain these searches using Observation search parameters such as
  `_lastUpdated` or `date`.
  
  On success, the response body will contain a JSON-encoded representation
  of a `Bundle` resource of type `searchset`, containing the results of the
  operation.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/Observation/$lastn"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-conditionalPatch$
  "Required parameters: type, parent
  
  Optional parameters: none
  
  If a resource is found based on the search criteria specified in the query
  parameters, updates part of that resource by applying the operations
  specified in a [JSON Patch](http://jsonpatch.com/) document.
  
  Implements the FHIR standard conditional patch interaction
  ([STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#patch),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#patch)).
  
  DSTU2 doesn't define a conditional patch method, but the server supports it
  in the same way it supports STU3.
  
  Search terms are provided as query parameters following the same pattern as
  the search method.
  
  If the search criteria identify more than one match, the request will
  return a `412 Precondition Failed` error.
  
  The request body must contain a JSON Patch document, and the request
  headers must contain `Content-Type: application/json-patch+json`.
  
  On success, the response body will contain a JSON-encoded representation
  of the updated resource, including the server-assigned version ID.
  Errors generated by the FHIR store will contain a JSON-encoded
  `OperationOutcome` resource describing the reason for the error. If the
  request cannot be mapped to a valid API method on a FHIR store, a generic
  GCP error might be returned instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "type"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/{+type}"
     #{"parent" "type"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-fhirStores-fhir-conditionalDelete$
  "Required parameters: type, parent
  
  Optional parameters: none
  
  Deletes FHIR resources that match a search query.
  
  Implements the FHIR standard conditional delete interaction
  ([DSTU2](http://hl7.org/implement/standards/fhir/DSTU2/http.html#2.1.0.12.1),
  [STU3](http://hl7.org/implement/standards/fhir/STU3/http.html#2.21.0.13.1),
  [R4](http://hl7.org/implement/standards/fhir/R4/http.html#3.1.0.7.1)).
  If multiple resources match, all of them will be deleted.
  
  Search terms are provided as query parameters following the same pattern as
  the search method.
  
  Note: Unless resource versioning is disabled by setting the
  disable_resource_versioning flag
  on the FHIR store, the deleted resources will be moved to a history
  repository that can still be retrieved through vread
  and related methods, unless they are removed by the
  purge method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "type"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/fhir/{+type}"
     #{"parent" "type"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the specified DICOM store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-searchForSeries$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForSeries returns a list of matching series. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the specified DICOM store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-create$
  "Required parameters: parent
  
  Optional parameters: dicomStoreId
  
  Creates a new DICOM store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomStores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified DICOM store and removes all images that are contained
  within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-searchForStudies$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForStudies returns a list of matching studies. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-export$
  "Required parameters: name
  
  Optional parameters: none
  
  Exports data to the specified destination by copying it from the DICOM
  store.
  The metadata field type is
  OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}:export"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-searchForInstances$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-deidentify$
  "Required parameters: sourceStore
  
  Optional parameters: none
  
  De-identifies data from the source store and writes it to the destination
  store. The metadata field type
  is OperationMetadata.
  If the request is successful, the
  response field type is
  DeidentifyDicomStoreSummary. If errors occur,
  error
  details field type is
  DeidentifyErrorDetails.
  Errors are also logged to Stackdriver
  (see [Viewing logs](/healthcare/docs/how-tos/stackdriver-logging))."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"sourceStore"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+sourceStore}:deidentify"
     #{"sourceStore"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the DICOM stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomStores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-import$
  "Required parameters: name
  
  Optional parameters: none
  
  Imports data into the DICOM store by copying it from the specified source.
  For errors, the Operation is populated with error details (in the form
  of ImportDicomDataErrorDetails in error.details), which hold
  finer-grained error information. Errors are also logged to Stackdriver
  Logging. For more information,
  see [Viewing logs](/healthcare/docs/how-tos/stackdriver-logging).
  The metadata field type is
  OperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}:import"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-storeInstances$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  StoreInstances stores DICOM instances associated with study instance unique
  identifiers (SUID). See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.5."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-studies-retrieveMetadata$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  RetrieveStudyMetadata returns instance associated with the given study
  presented as metadata with the bulk data removed. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-storeInstances$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  StoreInstances stores DICOM instances associated with study instance unique
  identifiers (SUID). See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.5."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-dicomStores-studies-delete$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  DeleteStudy deletes all instances within the given study. Delete requests
  are equivalent to the GET requests specified in the Retrieve transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-retrieveStudy$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveStudy returns all instances within the given study. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-searchForSeries$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForSeries returns a list of matching series. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-searchForInstances$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-retrieveMetadata$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveSeriesMetadata returns instance associated with the given study and
  series, presented as metadata with the bulk data removed. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-retrieveSeries$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  RetrieveSeries returns all instances within the given study and series. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-searchForInstances$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  SearchForInstances returns a list of matching instances. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.6."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-delete$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  DeleteSeries deletes all instances within the given study and series.
  Delete requests are equivalent to the GET requests specified in the
  Retrieve transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveMetadata$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveInstanceMetadata returns instance associated with the given study,
  series, and SOP Instance UID presented as metadata with the bulk data
  removed. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-delete$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  DeleteInstance deletes an instance associated with the given study, series,
  and SOP Instance UID. Delete requests are equivalent to the GET requests
  specified in the Retrieve transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveRendered$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  RetrieveRenderedInstance returns instance associated with the given study,
  series, and SOP Instance UID in an acceptable Rendered Media Type. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-retrieveInstance$
  "Required parameters: dicomWebPath, parent
  
  Optional parameters: none
  
  RetrieveInstance returns instance associated with the given study, series,
  and SOP Instance UID. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-frames-retrieveFrames$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveFrames returns instances associated with the given study, series,
  SOP Instance UID and frame numbers. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-dicomStores-studies-series-instances-frames-retrieveRendered$
  "Required parameters: parent, dicomWebPath
  
  Optional parameters: none
  
  RetrieveRenderedFrames returns instances associated with the given study,
  series, SOP Instance UID and frame numbers in an acceptable Rendered Media
  Type. See
  http://dicom.nema.org/medical/dicom/current/output/html/part18.html#sect_10.4."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "dicomWebPath"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/dicomWeb/{+dicomWebPath}"
     #{"parent" "dicomWebPath"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified HL7v2 store and removes all messages that are
  contained within it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the HL7v2 stores in the given dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/hl7V2Stores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-create$
  "Required parameters: parent
  
  Optional parameters: hl7V2StoreId
  
  Creates a new HL7v2 store within the parent dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/hl7V2Stores"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-hl7V2Stores-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-hl7V2Stores-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the HL7v2 store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the specified HL7v2 store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes an HL7v2 message."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-list$
  "Required parameters: parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize, view
  
  Lists all the messages in the given HL7v2 store with support for filtering.
  
  Note: HL7v2 messages are indexed asynchronously, so there might be a slight
  delay between the time a message is created and when it can be found
  through a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/messages"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a message and sends a notification to the Cloud Pub/Sub topic. If
  configured, the MLLP adapter listens to messages created by this method and
  sends those back to the hospital. A successful response indicates the
  message has been persisted to storage and a Cloud Pub/Sub notification has
  been sent. Sending to the hospital by the MLLP adapter happens
  asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/messages"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-ingest$
  "Required parameters: parent
  
  Optional parameters: none
  
  Ingests a new HL7v2 message from the hospital and sends a notification to
  the Cloud Pub/Sub topic. Return is an HL7v2 ACK message if the message was
  successfully stored. Otherwise an error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+parent}/messages:ingest"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Update the message.
  
  The contents of the message in Message.data and data extracted from
  the contents such as Message.create_time cannot be altered. Only the
  Message.labels field is allowed to be updated. The labels in the
  request are merged with the existing set of labels. Existing labels with
  the same keys are updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-hl7V2Stores-messages-get$
  "Required parameters: name
  
  Optional parameters: view
  
  Gets an HL7v2 message."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://healthcare.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
