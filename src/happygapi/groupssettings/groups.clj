(ns happygapi.groupssettings.groups
  "Groups Settings API
  Manages permission levels and related settings of a group.
  See: https://developers.google.com/google-apps/groups-settings/get_started"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "groupssettings_schema.edn"))))

(defn get$
  "Required parameters: groupUniqueId
  
  Optional parameters: none
  
  Gets one resource by id."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Updates an existing resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.settings"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupUniqueId"})
         (json-schema/validate schemas args)]}
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
