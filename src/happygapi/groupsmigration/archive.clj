(ns happygapi.groupsmigration.archive
  "Groups Migration API: archive.
  Groups Migration Api.
  See: https://developers.google.com/google-apps/groups-migration/api/reference/rest/v1/archive"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/google-apps/groups-migration/api/reference/rest/v1/archive/insert
  
  Required parameters: groupId
  
  Optional parameters: none
  
  Inserts a new mail into the archive of the Google group."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.migration"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:groupId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/groups/v1/groups/"
     "{groupId}/archive"
     #{:groupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
