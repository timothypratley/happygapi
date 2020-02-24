(ns happygapi.cloudfunctions.projects
  "Cloud Functions API
  Manages lightweight user-provided functions executed in response to events.
  See: https://cloud.google.com/functions"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn locations-list$
  "Required parameters: name
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-get$
  "Required parameters: name
  
  Returns a function with the given name from the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-setIamPolicy$
  "Required parameters: resource
  
  Sets the IAM access control policy on the specified function.
  Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-functions-patch$
  "Required parameters: name
  
  Updates existing function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-testIamPermissions$
  "Required parameters: resource
  
  Tests the specified permissions against the IAM access control policy
  for a function.
  If the function does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-functions-call$
  "Required parameters: name
  
  Synchronously invokes a deployed Cloud Function. To be used for testing
  purposes as very limited traffic is allowed. For more information on
  the actual limits, refer to
  [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}:call"
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

(defn locations-functions-create$
  "Required parameters: location
  
  Creates a new function. If a function with the given name already exists in
  the specified project, the long running operation will return
  `ALREADY_EXISTS` error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"location"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+location}/functions"
     #{"location"}
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

(defn locations-functions-generateUploadUrl$
  "Required parameters: parent
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+parent}/functions:generateUploadUrl"
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

(defn locations-functions-delete$
  "Required parameters: name
  
  Deletes a function with the given name from the specified project. If the
  given function is used by some trigger, the trigger will be updated to
  remove this function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-getIamPolicy$
  "Required parameters: resource
  
  Gets the IAM access control policy for a function.
  Returns an empty policy if the function exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-generateDownloadUrl$
  "Required parameters: name
  
  Returns a signed URL for downloading deployed function source code.
  The URL is only valid for a limited period and should be used within
  minutes after generation.
  For more information about the signed URL usage see:
  https://cloud.google.com/storage/docs/access-control/signed-urls"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+name}:generateDownloadUrl"
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

(defn locations-functions-list$
  "Required parameters: parent
  
  Returns a list of functions that belong to the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v1/{+parent}/functions"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
