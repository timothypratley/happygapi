(ns happygapi.homegraph.agentUsers
  "HomeGraph API
  
  See: https://developers.google.com/actions/smarthome/create-app#request-sync"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "homegraph_schema.edn"))))

(defn delete$
  "Required parameters: agentUserId
  
  Optional parameters: requestId
  
  Unlinks an agent user from Google. As a result, all data related to this
  user will be deleted.
  
  Here is how the agent user is created in Google:
  
  1.  When a user opens their Google Home App, they can begin linking a 3p
      partner.
  2.  User is guided through the OAuth process.
  3.  After entering the 3p credentials, Google gets the 3p OAuth token and
      uses it to make a Sync call to the 3p partner and gets back all of the
      user's data, including `agent_user_id` and devices.
  4.  Google creates the agent user and stores a mapping from the
      `agent_user_id` -> Google ID mapping. Google also
      stores all of the user's devices under that Google ID.
  
  The mapping from `agent_user_id` to Google ID is many to many, since one
  Google user can have multiple 3p accounts, and multiple Google users can
  map to one `agent_user_id` (e.g., a husband and wife share one Nest account
  username/password).
  
  The third-party user's identity is passed in as `agent_user_id`.
  The agent is identified by the JWT signed by the partner's service account.
  
  Note: Special characters (except \"/\") in `agent_user_id` must be
  URL-encoded."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"agentUserId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://homegraph.googleapis.com/"
     "v1/{+agentUserId}"
     #{"agentUserId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
