(ns happygapi.policysimulator.organizations
  "Policy Simulator API: organizations.
   Policy Simulator is a collection of endpoints for creating, running, and viewing a Replay. A `Replay` is a type of simulation that lets you see how your members' access to resources might change if you changed your IAM policy. During a `Replay`, Policy Simulator re-evaluates, or replays, past access attempts under both the current policy and your proposed policy, and compares those results to determine how your members' access might change under the proposed policy.
  See: https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-replays-get$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/organizations/locations/replays/get
  
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
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/organizations/locations/replays/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:state string,
   :name string,
   :config {:policyOverlay {}, :logSource string},
   :resultsSummary {:oldestDate GoogleTypeDate,
                    :unchangedCount integer,
                    :errorCount integer,
                    :newestDate GoogleTypeDate,
                    :logCount integer,
                    :differenceCount integer}}
  
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

(defn locations-replays-results-list$
  "https://cloud.google.com/iam/docs/simulating-accessapi/reference/rest/v1/organizations/locations/replays/results/list
  
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
