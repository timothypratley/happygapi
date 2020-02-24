(ns happygapi.groupsmigration.archive
  "Groups Migration API
  Groups Migration Api.
  See: https://developers.google.com/google-apps/groups-migration/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn insert$
  "Required parameters: groupId
  
  Inserts a new mail into the archive of the Google group."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.migration"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"groupId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupId}/archive"
     #{"groupId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
