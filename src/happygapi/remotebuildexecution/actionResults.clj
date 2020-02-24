(ns happygapi.remotebuildexecution.actionResults
  "Remote Build Execution API
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: hash,sizeBytes,instanceName
  
  Retrieve a cached execution result.
  
  Implementations SHOULD ensure that any blobs referenced from the
  ContentAddressableStorage
  are available at the time of returning the
  ActionResult and will be
  for some period of time afterwards. The TTLs of the referenced blobs SHOULD be increased
  if necessary and applicable.
  
  Errors:
  
  * `NOT_FOUND`: The requested `ActionResult` is not in the cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"instanceName" "hash" "sizeBytes"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{"instanceName" "hash" "sizeBytes"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: sizeBytes,instanceName,hash
  
  Upload a new execution result.
  
  In order to allow the server to perform access control based on the type of
  action, and to assist with client debugging, the client MUST first upload
  the Action that produced the
  result, along with its
  Command, into the
  `ContentAddressableStorage`.
  
  Errors:
  
  * `INVALID_ARGUMENT`: One or more arguments are invalid.
  * `FAILED_PRECONDITION`: One or more errors occurred in updating the
    action result, such as a missing command or action.
  * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the
    entry to the cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"instanceName" "hash" "sizeBytes"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{"instanceName" "hash" "sizeBytes"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
