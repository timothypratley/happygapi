(ns happygapi.remotebuildexecution.actionResults
  "Remote Build Execution API: actionResults.
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults/get
  
  Required parameters: sizeBytes, instanceName, hash
  
  Optional parameters: inlineStdout, inlineStderr, inlineOutputFiles
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
  {:pre [(util/has-keys? args #{:hash :instanceName :sizeBytes})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{:hash :instanceName :sizeBytes}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults/update
  
  Required parameters: sizeBytes, instanceName, hash
  
  Optional parameters: resultsCachePolicy.priority
  
  Body: 
  
  {:stderrDigest {:hash string, :sizeBytes string},
   :exitCode integer,
   :stdoutRaw string,
   :executionMetadata {:executionCompletedTimestamp string,
                       :workerStartTimestamp string,
                       :inputFetchCompletedTimestamp string,
                       :outputUploadCompletedTimestamp string,
                       :executionStartTimestamp string,
                       :workerCompletedTimestamp string,
                       :inputFetchStartTimestamp string,
                       :queuedTimestamp string,
                       :outputUploadStartTimestamp string,
                       :worker string},
   :outputFiles [{:digest BuildBazelRemoteExecutionV2Digest,
                  :isExecutable boolean,
                  :path string,
                  :contents string}],
   :stdoutDigest {:hash string, :sizeBytes string},
   :outputDirectories [{:path string,
                        :treeDigest BuildBazelRemoteExecutionV2Digest}],
   :outputDirectorySymlinks [{:target string, :path string}],
   :stderrRaw string,
   :outputFileSymlinks [{:target string, :path string}]}
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{:hash :instanceName :sizeBytes})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{:hash :instanceName :sizeBytes}
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
