(ns happygapi.remotebuildexecution.operations
  "Remote Build Execution API
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn waitExecution$
  "Required parameters: name
  
  Wait for an execution operation to complete. When the client initially
  makes the request, the server immediately responds with the current status
  of the execution. The server will leave the request stream open until the
  operation completes, and then respond with the completed operation. The
  server MAY choose to stream additional updates as execution progresses,
  such as to provide an update as to the state of the execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+name}:waitExecution"
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
