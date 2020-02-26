(ns happygapi.groupsmigration.archive
  "Groups Migration API
  Groups Migration Api.
  See: https://developers.google.com/google-apps/groups-migration/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "groupsmigration_schema.edn"))))

(defn insert$
  "Required parameters: groupId
  
  Optional parameters: none
  
  Inserts a new mail into the archive of the Google group."
  {:scopes ["https://www.googleapis.com/auth/apps.groups.migration"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"groupId"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))
