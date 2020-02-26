(ns happygapi.remotebuildexecution.operations
  "Remote Build Execution API
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "remotebuildexecution_schema.edn"))))

(defn waitExecution$
  "Required parameters: name
  
  Optional parameters: none
  
  Wait for an execution operation to complete. When the client initially
  makes the request, the server immediately responds with the current status
  of the execution. The server will leave the request stream open until the
  operation completes, and then respond with the completed operation. The
  server MAY choose to stream additional updates as execution progresses,
  such as to provide an update as to the state of the execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))
