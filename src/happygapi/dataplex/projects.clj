(ns happygapi.dataplex.projects
  "Cloud Dataplex API: projects.
  Dataplex API is used to manage the lifecycle of data lakes.
  See: https://cloud.google.com/dataplex/docsdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-lookupEntry$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lookupEntry
  
  Required parameters: name
  
  Optional parameters: view, aspectTypes, paths, entry
  
  Looks up a single entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:lookupEntry"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-searchEntries$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/searchEntries
  
  Required parameters: name
  
  Optional parameters: query, pageSize, pageToken, orderBy, scope
  
  Searches for entries matching given query and scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:searchEntries"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/create
  
  Required parameters: parent
  
  Optional parameters: entryGroupId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :transferStatus string}
  
  Creates an EntryGroup"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entryGroups"
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

(defn locations-entryGroups-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :transferStatus string}
  
  Updates a EntryGroup resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a EntryGroup resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists EntryGroup resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entryGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a EntryGroup resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-entries-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/entries/create
  
  Required parameters: parent
  
  Optional parameters: entryId
  
  Body: 
  
  {:name string,
   :entryType string,
   :createTime string,
   :updateTime string,
   :aspects {},
   :parentEntry string,
   :fullyQualifiedName string,
   :entrySource {:description string,
                 :labels {},
                 :system string,
                 :displayName string,
                 :createTime string,
                 :updateTime string,
                 :ancestors [GoogleCloudDataplexV1EntrySourceAncestor],
                 :resource string,
                 :platform string}}
  
  Creates an Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entries"
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

(defn locations-entryGroups-entries-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/entries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing, deleteMissingAspects, aspectKeys
  
  Body: 
  
  {:name string,
   :entryType string,
   :createTime string,
   :updateTime string,
   :aspects {},
   :parentEntry string,
   :fullyQualifiedName string,
   :entrySource {:description string,
                 :labels {},
                 :system string,
                 :displayName string,
                 :createTime string,
                 :updateTime string,
                 :ancestors [GoogleCloudDataplexV1EntrySourceAncestor],
                 :resource string,
                 :platform string}}
  
  Updates an Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-entries-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/entries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryGroups-entries-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/entries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists entries within an entry group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryGroups/entries/get
  
  Required parameters: name
  
  Optional parameters: view, aspectTypes, paths
  
  Gets a single entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/create
  
  Required parameters: parent
  
  Optional parameters: aspectTypeId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :authorization {:alternateUsePermission string},
   :uid string,
   :name string,
   :metadataTemplate {:constraints GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
                      :index integer,
                      :name string,
                      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
                      :type string,
                      :typeId string,
                      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
                      :typeRef string,
                      :enumValues [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
                      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
                      :annotations GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
   :createTime string,
   :etag string,
   :updateTime string,
   :transferStatus string}
  
  Creates an AspectType"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/aspectTypes"
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

(defn locations-aspectTypes-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :authorization {:alternateUsePermission string},
   :uid string,
   :name string,
   :metadataTemplate {:constraints GoogleCloudDataplexV1AspectTypeMetadataTemplateConstraints,
                      :index integer,
                      :name string,
                      :recordFields [GoogleCloudDataplexV1AspectTypeMetadataTemplate],
                      :type string,
                      :typeId string,
                      :arrayItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
                      :typeRef string,
                      :enumValues [GoogleCloudDataplexV1AspectTypeMetadataTemplateEnumValue],
                      :mapItems GoogleCloudDataplexV1AspectTypeMetadataTemplate,
                      :annotations GoogleCloudDataplexV1AspectTypeMetadataTemplateAnnotations},
   :createTime string,
   :etag string,
   :updateTime string,
   :transferStatus string}
  
  Updates a AspectType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a AspectType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists AspectType resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/aspectTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-aspectTypes-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a AspectType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-aspectTypes-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/aspectTypes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a DataScan resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-run$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Runs an on-demand execution of a DataScan"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-dataScans-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :executionStatus {:latestJobStartTime string,
                     :latestJobEndTime string},
   :uid string,
   :name string,
   :dataProfileResult {:rowCount string,
                       :profile GoogleCloudDataplexV1DataProfileResultProfile,
                       :scannedData GoogleCloudDataplexV1ScannedData,
                       :postScanActionsResult GoogleCloudDataplexV1DataProfileResultPostScanActionsResult},
   :createTime string,
   :executionSpec {:trigger GoogleCloudDataplexV1Trigger, :field string},
   :type string,
   :state string,
   :updateTime string,
   :dataProfileSpec {:samplingPercent number,
                     :rowFilter string,
                     :postScanActions GoogleCloudDataplexV1DataProfileSpecPostScanActions,
                     :includeFields GoogleCloudDataplexV1DataProfileSpecSelectedFields,
                     :excludeFields GoogleCloudDataplexV1DataProfileSpecSelectedFields},
   :dataQualitySpec {:rules [GoogleCloudDataplexV1DataQualityRule],
                     :samplingPercent number,
                     :rowFilter string,
                     :postScanActions GoogleCloudDataplexV1DataQualitySpecPostScanActions},
   :dataQualityResult {:passed boolean,
                       :score number,
                       :dimensions [GoogleCloudDataplexV1DataQualityDimensionResult],
                       :columns [GoogleCloudDataplexV1DataQualityColumnResult],
                       :rules [GoogleCloudDataplexV1DataQualityRuleResult],
                       :rowCount string,
                       :scannedData GoogleCloudDataplexV1ScannedData,
                       :postScanActionsResult GoogleCloudDataplexV1DataQualityResultPostScanActionsResult},
   :data {:entity string, :resource string}}
  
  Updates a DataScan resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-generateDataQualityRules$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/generateDataQualityRules
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates recommended DataQualityRule from a data profiling DataScan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:generateDataQualityRules"
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

(defn locations-dataScans-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/create
  
  Required parameters: parent
  
  Optional parameters: dataScanId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :executionStatus {:latestJobStartTime string,
                     :latestJobEndTime string},
   :uid string,
   :name string,
   :dataProfileResult {:rowCount string,
                       :profile GoogleCloudDataplexV1DataProfileResultProfile,
                       :scannedData GoogleCloudDataplexV1ScannedData,
                       :postScanActionsResult GoogleCloudDataplexV1DataProfileResultPostScanActionsResult},
   :createTime string,
   :executionSpec {:trigger GoogleCloudDataplexV1Trigger, :field string},
   :type string,
   :state string,
   :updateTime string,
   :dataProfileSpec {:samplingPercent number,
                     :rowFilter string,
                     :postScanActions GoogleCloudDataplexV1DataProfileSpecPostScanActions,
                     :includeFields GoogleCloudDataplexV1DataProfileSpecSelectedFields,
                     :excludeFields GoogleCloudDataplexV1DataProfileSpecSelectedFields},
   :dataQualitySpec {:rules [GoogleCloudDataplexV1DataQualityRule],
                     :samplingPercent number,
                     :rowFilter string,
                     :postScanActions GoogleCloudDataplexV1DataQualitySpecPostScanActions},
   :dataQualityResult {:passed boolean,
                       :score number,
                       :dimensions [GoogleCloudDataplexV1DataQualityDimensionResult],
                       :columns [GoogleCloudDataplexV1DataQualityColumnResult],
                       :rules [GoogleCloudDataplexV1DataQualityRuleResult],
                       :rowCount string,
                       :scannedData GoogleCloudDataplexV1ScannedData,
                       :postScanActionsResult GoogleCloudDataplexV1DataQualityResultPostScanActionsResult},
   :data {:entity string, :resource string}}
  
  Creates a DataScan resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataScans"
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

(defn locations-dataScans-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DataScan resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DataScans."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataScans"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataScans-jobs-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/jobs/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a DataScanJob resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataScans-jobs-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists DataScanJobs under the given DataScan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataScans-jobs-generateDataQualityRules$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataScans/jobs/generateDataQualityRules
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates recommended DataQualityRule from a data profiling DataScan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:generateDataQualityRules"
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

(defn locations-governanceRules-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/governanceRules/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-governanceRules-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/governanceRules/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-governanceRules-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/governanceRules/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/create
  
  Required parameters: parent
  
  Optional parameters: dataAttributeBindingId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :paths [{:name string, :attributes [string]}],
   :etag string,
   :updateTime string,
   :resource string,
   :attributes [string]}
  
  Create a DataAttributeBinding resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataAttributeBindings"
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

(defn locations-dataAttributeBindings-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :paths [{:name string, :attributes [string]}],
   :etag string,
   :updateTime string,
   :resource string,
   :attributes [string]}
  
  Updates a DataAttributeBinding resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a DataAttributeBinding resource. All attributes within the DataAttributeBinding must be deleted before the DataAttributeBinding can be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataAttributeBindings-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DataAttributeBinding resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataAttributeBindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataAttributeBindings-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataAttributeBindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a DataAttributeBinding resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/create
  
  Required parameters: parent
  
  Optional parameters: dataTaxonomyId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :attributeCount integer,
   :updateTime string,
   :classCount integer}
  
  Create a DataTaxonomy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataTaxonomies"
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

(defn locations-dataTaxonomies-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :attributeCount integer,
   :updateTime string,
   :classCount integer}
  
  Updates a DataTaxonomy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy must be deleted before the DataTaxonomy can be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DataTaxonomy resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/dataTaxonomies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataTaxonomies-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a DataTaxonomy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/create
  
  Required parameters: parent
  
  Optional parameters: dataAttributeId, validateOnly
  
  Body: 
  
  {:description string,
   :resourceAccessSpec {:readers [string],
                        :writers [string],
                        :owners [string]},
   :labels {},
   :dataAccessSpec {:readers [string]},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :attributeCount integer,
   :updateTime string,
   :parentId string}
  
  Create a DataAttribute resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/attributes"
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

(defn locations-dataTaxonomies-attributes-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :resourceAccessSpec {:readers [string],
                        :writers [string],
                        :owners [string]},
   :labels {},
   :dataAccessSpec {:readers [string]},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :attributeCount integer,
   :updateTime string,
   :parentId string}
  
  Updates a DataAttribute resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a Data Attribute resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-dataTaxonomies-attributes-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Data Attribute resources in a DataTaxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataTaxonomies-attributes-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/dataTaxonomies/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a Data Attribute resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/create
  
  Required parameters: parent
  
  Optional parameters: lakeId, validateOnly
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :metastoreStatus {:state string,
                     :message string,
                     :updateTime string,
                     :endpoint string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :metastore {:service string},
   :assetStatus {:updateTime string,
                 :activeAssets integer,
                 :securityPolicyApplyingAssets integer}}
  
  Creates a lake resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/lakes"
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

(defn locations-lakes-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :metastoreStatus {:state string,
                     :message string,
                     :updateTime string,
                     :endpoint string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :metastore {:service string},
   :assetStatus {:updateTime string,
                 :activeAssets integer,
                 :securityPolicyApplyingAssets integer}}
  
  Updates a lake resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a lake resource. All zones within the lake must be deleted before the lake can be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists lake resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/lakes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a lake resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/create
  
  Required parameters: parent
  
  Optional parameters: zoneId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :resourceSpec {:locationType string},
   :discoverySpec {:enabled boolean,
                   :includePatterns [string],
                   :excludePatterns [string],
                   :csvOptions GoogleCloudDataplexV1ZoneDiscoverySpecCsvOptions,
                   :jsonOptions GoogleCloudDataplexV1ZoneDiscoverySpecJsonOptions,
                   :schedule string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :updateTime string,
   :assetStatus {:updateTime string,
                 :activeAssets integer,
                 :securityPolicyApplyingAssets integer}}
  
  Creates a zone resource within a lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/zones"
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

(defn locations-lakes-zones-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :resourceSpec {:locationType string},
   :discoverySpec {:enabled boolean,
                   :includePatterns [string],
                   :excludePatterns [string],
                   :csvOptions GoogleCloudDataplexV1ZoneDiscoverySpecCsvOptions,
                   :jsonOptions GoogleCloudDataplexV1ZoneDiscoverySpecJsonOptions,
                   :schedule string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :updateTime string,
   :assetStatus {:updateTime string,
                 :activeAssets integer,
                 :securityPolicyApplyingAssets integer}}
  
  Updates a zone resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a zone resource. All assets within a zone must be deleted before the zone can be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists zone resources in a lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/zones"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-zones-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a zone resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/create
  
  Required parameters: parent
  
  Optional parameters: assetId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :resourceSpec {:name string, :type string, :readAccessMode string},
   :discoverySpec {:enabled boolean,
                   :includePatterns [string],
                   :excludePatterns [string],
                   :csvOptions GoogleCloudDataplexV1AssetDiscoverySpecCsvOptions,
                   :jsonOptions GoogleCloudDataplexV1AssetDiscoverySpecJsonOptions,
                   :schedule string},
   :discoveryStatus {:state string,
                     :message string,
                     :updateTime string,
                     :lastRunTime string,
                     :stats GoogleCloudDataplexV1AssetDiscoveryStatusStats,
                     :lastRunDuration string},
   :resourceStatus {:state string,
                    :message string,
                    :updateTime string,
                    :managedAccessIdentity string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :securityStatus {:state string, :message string, :updateTime string}}
  
  Creates an asset resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/assets"
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

(defn locations-lakes-zones-assets-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :resourceSpec {:name string, :type string, :readAccessMode string},
   :discoverySpec {:enabled boolean,
                   :includePatterns [string],
                   :excludePatterns [string],
                   :csvOptions GoogleCloudDataplexV1AssetDiscoverySpecCsvOptions,
                   :jsonOptions GoogleCloudDataplexV1AssetDiscoverySpecJsonOptions,
                   :schedule string},
   :discoveryStatus {:state string,
                     :message string,
                     :updateTime string,
                     :lastRunTime string,
                     :stats GoogleCloudDataplexV1AssetDiscoveryStatusStats,
                     :lastRunDuration string},
   :resourceStatus {:state string,
                    :message string,
                    :updateTime string,
                    :managedAccessIdentity string},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :securityStatus {:state string, :message string, :updateTime string}}
  
  Updates an asset resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an asset resource. The referenced storage resource is detached (default) or deleted based on the associated Lifecycle policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists asset resources in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves an asset resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-assets-actions-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/assets/actions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists action resources in an asset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/actions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-zones-entities-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/create
  
  Required parameters: parent
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :schema {:userManaged boolean,
            :fields [GoogleCloudDataplexV1SchemaSchemaField],
            :partitionFields [GoogleCloudDataplexV1SchemaPartitionField],
            :partitionStyle string},
   :format {:format string,
            :compressionFormat string,
            :mimeType string,
            :csv GoogleCloudDataplexV1StorageFormatCsvOptions,
            :json GoogleCloudDataplexV1StorageFormatJsonOptions,
            :iceberg GoogleCloudDataplexV1StorageFormatIcebergOptions},
   :system string,
   :catalogEntry string,
   :compatibility {:hiveMetastore GoogleCloudDataplexV1EntityCompatibilityStatusCompatibility,
                   :bigquery GoogleCloudDataplexV1EntityCompatibilityStatusCompatibility},
   :dataPathPattern string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :etag string,
   :updateTime string,
   :id string,
   :dataPath string,
   :access {:read string},
   :asset string}
  
  Create a metadata entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entities"
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

(defn locations-lakes-zones-entities-update$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/update
  
  Required parameters: name
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :schema {:userManaged boolean,
            :fields [GoogleCloudDataplexV1SchemaSchemaField],
            :partitionFields [GoogleCloudDataplexV1SchemaPartitionField],
            :partitionStyle string},
   :format {:format string,
            :compressionFormat string,
            :mimeType string,
            :csv GoogleCloudDataplexV1StorageFormatCsvOptions,
            :json GoogleCloudDataplexV1StorageFormatJsonOptions,
            :iceberg GoogleCloudDataplexV1StorageFormatIcebergOptions},
   :system string,
   :catalogEntry string,
   :compatibility {:hiveMetastore GoogleCloudDataplexV1EntityCompatibilityStatusCompatibility,
                   :bigquery GoogleCloudDataplexV1EntityCompatibilityStatusCompatibility},
   :dataPathPattern string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :type string,
   :etag string,
   :updateTime string,
   :id string,
   :dataPath string,
   :access {:read string},
   :asset string}
  
  Update a metadata entity. Only supports full resource update."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-entities-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Delete a metadata entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-entities-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Get a metadata entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-entities-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/list
  
  Required parameters: parent
  
  Optional parameters: view, pageSize, pageToken, filter
  
  List metadata entities in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entities"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-zones-entities-partitions-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/partitions/create
  
  Required parameters: parent
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:name string, :values [string], :location string, :etag string}
  
  Create a metadata partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/partitions"
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

(defn locations-lakes-zones-entities-partitions-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/partitions/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Delete a metadata partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-entities-partitions-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/partitions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a metadata partition of an entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-zones-entities-partitions-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/entities/partitions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List metadata partitions of an entity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/partitions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-zones-actions-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/zones/actions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists action resources in a zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/actions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-tasks-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get task resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-run$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {}, :args {}}
  
  Run an on demand execution of a Task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-lakes-tasks-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :executionStatus {:updateTime string,
                     :latestJob GoogleCloudDataplexV1Job},
   :uid string,
   :name string,
   :createTime string,
   :executionSpec {:args {},
                   :serviceAccount string,
                   :project string,
                   :maxJobExecutionLifetime string,
                   :kmsKey string},
   :state string,
   :updateTime string,
   :notebook {:notebook string,
              :infrastructureSpec GoogleCloudDataplexV1TaskInfrastructureSpec,
              :fileUris [string],
              :archiveUris [string]},
   :triggerSpec {:type string,
                 :startTime string,
                 :disabled boolean,
                 :maxRetries integer,
                 :schedule string},
   :spark {:mainJarFileUri string,
           :mainClass string,
           :pythonScriptFile string,
           :sqlScriptFile string,
           :sqlScript string,
           :fileUris [string],
           :archiveUris [string],
           :infrastructureSpec GoogleCloudDataplexV1TaskInfrastructureSpec}}
  
  Update the task resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/create
  
  Required parameters: parent
  
  Optional parameters: taskId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :executionStatus {:updateTime string,
                     :latestJob GoogleCloudDataplexV1Job},
   :uid string,
   :name string,
   :createTime string,
   :executionSpec {:args {},
                   :serviceAccount string,
                   :project string,
                   :maxJobExecutionLifetime string,
                   :kmsKey string},
   :state string,
   :updateTime string,
   :notebook {:notebook string,
              :infrastructureSpec GoogleCloudDataplexV1TaskInfrastructureSpec,
              :fileUris [string],
              :archiveUris [string]},
   :triggerSpec {:type string,
                 :startTime string,
                 :disabled boolean,
                 :maxRetries integer,
                 :schedule string},
   :spark {:mainJarFileUri string,
           :mainClass string,
           :pythonScriptFile string,
           :sqlScriptFile string,
           :sqlScript string,
           :fileUris [string],
           :archiveUris [string],
           :infrastructureSpec GoogleCloudDataplexV1TaskInfrastructureSpec}}
  
  Creates a task resource within a lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/tasks"
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

(defn locations-lakes-tasks-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete the task resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists tasks under the given lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/tasks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-tasks-jobs-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Jobs under the given task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-tasks-jobs-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get job resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-tasks-jobs-cancel$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/tasks/jobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancel jobs running for the task resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/create
  
  Required parameters: parent
  
  Optional parameters: environmentId, validateOnly
  
  Body: 
  
  {:description string,
   :sessionStatus {:active boolean},
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :endpoints {:notebooks string, :sql string},
   :sessionSpec {:maxIdleDuration string, :enableFastStartup boolean},
   :infrastructureSpec {:compute GoogleCloudDataplexV1EnvironmentInfrastructureSpecComputeResources,
                        :osImage GoogleCloudDataplexV1EnvironmentInfrastructureSpecOsImageRuntime}}
  
  Create an environment resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/environments"
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

(defn locations-lakes-environments-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :sessionStatus {:active boolean},
   :labels {},
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :endpoints {:notebooks string, :sql string},
   :sessionSpec {:maxIdleDuration string, :enableFastStartup boolean},
   :infrastructureSpec {:compute GoogleCloudDataplexV1EnvironmentInfrastructureSpecComputeResources,
                        :osImage GoogleCloudDataplexV1EnvironmentInfrastructureSpecOsImageRuntime}}
  
  Update the environment resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete the environment resource. All the child resources must have been deleted before environment deletion can be initiated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists environments under the given lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-environments-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get environment resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-environments-sessions-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/environments/sessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists session resources in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/sessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-contentitems-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/create
  
  Required parameters: parent
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :path string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :sqlScript {:engine string},
   :updateTime string,
   :notebook {:kernelType string},
   :dataText string}
  
  Create a content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/contentitems"
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

(defn locations-lakes-contentitems-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :path string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :sqlScript {:engine string},
   :updateTime string,
   :notebook {:kernelType string},
   :dataText string}
  
  Update a content. Only supports full resource update."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Get a content resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a contentitem resource. A NOT_FOUND error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.Caller must have Google IAM dataplex.content.getIamPolicy permission on the resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified contentitem resource. Replaces any existing policy.Caller must have Google IAM dataplex.content.setIamPolicy permission on the resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the caller's permissions on a resource. If the resource does not exist, an empty set of permissions is returned (a NOT_FOUND error is not returned).A caller is not required to have Google IAM permission to make this request.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-contentitems-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/contentitems/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/contentitems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-content-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/create
  
  Required parameters: parent
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :path string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :sqlScript {:engine string},
   :updateTime string,
   :notebook {:kernelType string},
   :dataText string}
  
  Create a content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/content"
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

(defn locations-lakes-content-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :path string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :sqlScript {:engine string},
   :updateTime string,
   :notebook {:kernelType string},
   :dataText string}
  
  Update a content. Only supports full resource update."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Get a content resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a contentitem resource. A NOT_FOUND error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.Caller must have Google IAM dataplex.content.getIamPolicy permission on the resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified contentitem resource. Replaces any existing policy.Caller must have Google IAM dataplex.content.setIamPolicy permission on the resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the caller's permissions on a resource. If the resource does not exist, an empty set of permissions is returned (a NOT_FOUND error is not returned).A caller is not required to have Google IAM permission to make this request.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-lakes-content-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/content/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List content."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/content"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lakes-actions-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/lakes/actions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists action resources in a lake."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/actions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-create$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/create
  
  Required parameters: parent
  
  Optional parameters: entryTypeId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :system string,
   :displayName string,
   :authorization {:alternateUsePermission string},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :requiredAspects [{:type string}],
   :typeAliases [string],
   :platform string}
  
  Creates an EntryType"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entryTypes"
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

(defn locations-entryTypes-patch$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :system string,
   :displayName string,
   :authorization {:alternateUsePermission string},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :requiredAspects [{:type string}],
   :typeAliases [string],
   :platform string}
  
  Updates a EntryType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-delete$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a EntryType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-list$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists EntryType resources in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
     "v1/{+parent}/entryTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryTypes-get$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a EntryType resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-setIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-getIamPolicy$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataplex.googleapis.com/"
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

(defn locations-entryTypes-testIamPermissions$
  "https://cloud.google.com/dataplex/docsapi/reference/rest/v1/projects/locations/entryTypes/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataplex.googleapis.com/"
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
