(ns happygapi.cloudfunctions.projects
  "Cloud Functions API: projects.
  Manages lightweight user-provided functions executed in response to events.
  See: https://cloud.google.com/functionsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-get$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a function with the given name from the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-setIamPolicy$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the IAM access control policy on the specified function.
  Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-patch$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :versionId string,
   :name string,
   :entryPoint string,
   :environmentVariables {},
   :sourceUploadUrl string,
   :vpcConnector string,
   :updateTime string,
   :vpcConnectorEgressSettings string,
   :eventTrigger {:eventType string,
                  :resource string,
                  :service string,
                  :failurePolicy FailurePolicy},
   :availableMemoryMb integer,
   :serviceAccountEmail string,
   :status string,
   :sourceArchiveUrl string,
   :runtime string,
   :network string,
   :timeout string,
   :maxInstances integer,
   :ingressSettings string,
   :httpsTrigger {:url string},
   :sourceRepository {:url string, :deployedUrl string}}
  
  Updates existing function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-testIamPermissions$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests the specified permissions against the IAM access control policy
  for a function.
  If the function does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-call$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/call
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:data string}
  
  Synchronously invokes a deployed Cloud Function. To be used for testing
  purposes as very limited traffic is allowed. For more information on
  the actual limits, refer to
  [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}:call"
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

(defn locations-functions-create$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/create
  
  Required parameters: location
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :versionId string,
   :name string,
   :entryPoint string,
   :environmentVariables {},
   :sourceUploadUrl string,
   :vpcConnector string,
   :updateTime string,
   :vpcConnectorEgressSettings string,
   :eventTrigger {:eventType string,
                  :resource string,
                  :service string,
                  :failurePolicy FailurePolicy},
   :availableMemoryMb integer,
   :serviceAccountEmail string,
   :status string,
   :sourceArchiveUrl string,
   :runtime string,
   :network string,
   :timeout string,
   :maxInstances integer,
   :ingressSettings string,
   :httpsTrigger {:url string},
   :sourceRepository {:url string, :deployedUrl string}}
  
  Creates a new function. If a function with the given name already exists in
  the specified project, the long running operation will return
  `ALREADY_EXISTS` error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+location}/functions"
     #{:location}
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

(defn locations-functions-generateUploadUrl$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/generateUploadUrl
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns a signed URL for uploading a function source code.
  For more information about the signed URL usage see:
  https://cloud.google.com/storage/docs/access-control/signed-urls.
  Once the function source code upload is complete, the used signed
  URL should be provided in CreateFunction or UpdateFunction request
  as a reference to the function source code.
  
  When uploading source code to the generated signed URL, please follow
  these restrictions:
  
  * Source file type should be a zip file.
  * Source file size should not exceed 100MB limit.
  * No credentials should be attached - the signed URLs provide access to the
    target bucket using internal service identity; if credentials were
    attached, the identity from the credentials would be used, but that
    identity does not have permissions to upload files to the URL.
  
  When making a HTTP PUT request, these two headers need to be specified:
  
  * `content-type: application/zip`
  * `x-goog-content-length-range: 0,104857600`
  
  And this header SHOULD NOT be specified:
  
  * `Authorization: Bearer YOUR_TOKEN`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+parent}/functions:generateUploadUrl"
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

(defn locations-functions-delete$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a function with the given name from the specified project. If the
  given function is used by some trigger, the trigger will be updated to
  remove this function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-getIamPolicy$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM access control policy for a function.
  Returns an empty policy if the function exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-generateDownloadUrl$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/generateDownloadUrl
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:versionId string}
  
  Returns a signed URL for downloading deployed function source code.
  The URL is only valid for a limited period and should be used within
  minutes after generation.
  For more information about the signed URL usage see:
  https://cloud.google.com/storage/docs/access-control/signed-urls"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}:generateDownloadUrl"
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

(defn locations-functions-list$
  "https://cloud.google.com/functionsapi/reference/rest/v1/projects/locations/functions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of functions that belong to the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+parent}/functions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
