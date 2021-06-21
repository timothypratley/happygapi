(ns happygapi.remotebuildexecution.actionResults
  "Remote Build Execution API: actionResults.
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults/get
  
  Required parameters: hash, sizeBytes, instanceName
  
  Optional parameters: inlineStderr, inlineOutputFiles, inlineStdout
  
  Retrieve a cached execution result. Implementations SHOULD ensure that any blobs referenced from the ContentAddressableStorage are available at the time of returning the ActionResult and will be for some period of time afterwards. The lifetimes of the referenced blobs SHOULD be increased if necessary and applicable. Errors: * `NOT_FOUND`: The requested `ActionResult` is not in the cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:hash :instanceName :sizeBytes})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{:hash :instanceName :sizeBytes}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/actionResults/update
  
  Required parameters: sizeBytes, hash, instanceName
  
  Optional parameters: resultsCachePolicy.priority
  
  Body: 
  
  {:stderrDigest {:hash string, :sizeBytes string},
   :exitCode integer,
   :outputSymlinks [{:path string,
                     :target string,
                     :nodeProperties BuildBazelRemoteExecutionV2NodeProperties}],
   :stdoutRaw string,
   :executionMetadata {:auxiliaryMetadata [{}],
                       :executionCompletedTimestamp string,
                       :workerStartTimestamp string,
                       :inputFetchCompletedTimestamp string,
                       :outputUploadCompletedTimestamp string,
                       :executionStartTimestamp string,
                       :workerCompletedTimestamp string,
                       :inputFetchStartTimestamp string,
                       :queuedTimestamp string,
                       :outputUploadStartTimestamp string,
                       :worker string},
   :outputFiles [{:isExecutable boolean,
                  :contents string,
                  :path string,
                  :nodeProperties BuildBazelRemoteExecutionV2NodeProperties,
                  :digest BuildBazelRemoteExecutionV2Digest}],
   :stdoutDigest {:hash string, :sizeBytes string},
   :outputDirectories [{:path string,
                        :treeDigest BuildBazelRemoteExecutionV2Digest}],
   :outputDirectorySymlinks [{:path string,
                              :target string,
                              :nodeProperties BuildBazelRemoteExecutionV2NodeProperties}],
   :stderrRaw string,
   :outputFileSymlinks [{:path string,
                         :target string,
                         :nodeProperties BuildBazelRemoteExecutionV2NodeProperties}]}
  
  Upload a new execution result. In order to allow the server to perform access control based on the type of action, and to assist with client debugging, the client MUST first upload the Action that produced the result, along with its Command, into the `ContentAddressableStorage`. Server implementations MAY modify the `UpdateActionResultRequest.action_result` and return an equivalent value. Errors: * `INVALID_ARGUMENT`: One or more arguments are invalid. * `FAILED_PRECONDITION`: One or more errors occurred in updating the action result, such as a missing command or action. * `RESOURCE_EXHAUSTED`: There is insufficient storage space to add the entry to the cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:hash :instanceName :sizeBytes})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/actionResults/{hash}/{sizeBytes}"
     #{:hash :instanceName :sizeBytes}
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
