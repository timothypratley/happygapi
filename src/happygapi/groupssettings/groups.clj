(ns happygapi.groupssettings.groups
  "Groups Settings API
  Manages permission levels and related settings of a group.
  See: https://developers.google.com/google-apps/groups-settings/get_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: groupUniqueId
  
  Gets one resource by id."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{"groupUniqueId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: groupUniqueId
  
  Updates an existing resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{"groupUniqueId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: groupUniqueId
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupUniqueId}"
     #{"groupUniqueId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
