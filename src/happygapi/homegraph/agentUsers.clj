(ns happygapi.homegraph.agentUsers
  "HomeGraph API: agentUsers.
  
  See: https://developers.google.com/actions/smarthome/create-app#request-syncapi/reference/rest/v1/agentUsers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/actions/smarthome/create-app#request-syncapi/reference/rest/v1/agentUsers/delete
  
  Required parameters: agentUserId
  
  Optional parameters: requestId
  
  Unlinks the given third-party user from your smart home Action. All data related to this user will be deleted. For more details on how users link their accounts, see [fulfillment and authentication](https://developers.google.com/assistant/smarthome/concepts/fulfillment-authentication). The third-party user's identity is passed in via the `agent_user_id` (see DeleteAgentUserRequest). This request must be authorized using service account credentials from your Actions console project."
  {:scopes ["https://www.googleapis.com/auth/homegraph"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:agentUserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/{+agentUserId}"
     #{:agentUserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
