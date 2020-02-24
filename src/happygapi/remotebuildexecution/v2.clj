(ns happygapi.remotebuildexecution.v2
  "Remote Build Execution API
  Supplies a Remote Execution API service for tools such as bazel.
  See: https://cloud.google.com/remote-build-execution/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn $
  "Required parameters: instanceName
  
  GetCapabilities returns the server capabilities configuration of the
  remote endpoint.
  Only the capabilities of the services supported by the endpoint will
  be returned:
  * Execution + CAS + Action Cache endpoints should return both
    CacheCapabilities and ExecutionCapabilities.
  * Execution only endpoints should return ExecutionCapabilities.
  * CAS + Action Cache only endpoints should return CacheCapabilities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"instanceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://remotebuildexecution.googleapis.com/"
     "v2/{+instanceName}/capabilities"
     #{"instanceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
