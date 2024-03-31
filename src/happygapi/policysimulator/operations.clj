(ns happygapi.policysimulator.operations
  "Policy Simulator API: operations.
   Policy Simulator is a collection of endpoints for creating, running, and viewing a Replay. A `Replay` is a type of simulation that lets you see how your members' access to resources might change if you changed your IAM policy. During a `Replay`, Policy Simulator re-evaluates, or replays, past access attempts under both the current policy and your proposed policy, and compares those results to determine how your members' access might change under the proposed policy.
  See: https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://policysimulator.googleapis.com/"
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

(defn get$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://policysimulator.googleapis.com/"
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
