(ns happygapi.policysimulator.folders
  "Policy Simulator API: folders.
   Policy Simulator is a collection of endpoints for creating, running, and viewing a Replay. A `Replay` is a type of simulation that lets you see how your members' access to resources might change if you changed your IAM policy. During a `Replay`, Policy Simulator re-evaluates, or replays, past access attempts under both the current policy and your proposed policy, and compares those results to determine how your members' access might change under the proposed policy.
  See: https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-replays-get$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/replays/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified Replay. Each `Replay` is available for at least 7 days."
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

(defn locations-replays-create$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/replays/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:state string,
   :name string,
   :resultsSummary {:differenceCount integer,
                    :newestDate GoogleTypeDate,
                    :logCount integer,
                    :errorCount integer,
                    :unchangedCount integer,
                    :oldestDate GoogleTypeDate},
   :config {:policyOverlay {}, :logSource string}}
  
  Creates and starts a Replay using the given ReplayConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://policysimulator.googleapis.com/"
     "v1/{+parent}/replays"
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

(defn locations-replays-operations-get$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/replays/operations/get
  
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

(defn locations-replays-operations-list$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/replays/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
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

(defn locations-replays-results-list$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/replays/results/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the results of running a Replay."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://policysimulator.googleapis.com/"
     "v1/{+parent}/results"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-orgPolicyViolationsPreviews-operations-get$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/folders/locations/orgPolicyViolationsPreviews/operations/get
  
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
