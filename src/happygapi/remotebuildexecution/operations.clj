(ns happygapi.remotebuildexecution.operations
  "Remote Build Execution API: operations.
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn waitExecution$
  "https://cloud.google.com/remote-build-execution/docs/api/reference/rest/v2/operations/waitExecution
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Wait for an execution operation to complete. When the client initially
  makes the request, the server immediately responds with the current status
  of the execution. The server will leave the request stream open until the
  operation completes, and then respond with the completed operation. The
  server MAY choose to stream additional updates as execution progresses,
  such as to provide an update as to the state of the execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+name}:waitExecution"
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
