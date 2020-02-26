(ns happygapi.driveactivity.activity
  "Drive Activity API
  Provides a historical view of activity in Google Drive.
  See: https://developers.google.com/drive/activity/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "driveactivity_schema.edn"))))

(defn query$
  "Required parameters: none
  
  Optional parameters: none
  
  Query past activity in Google Drive."
  {:scopes ["https://www.googleapis.com/auth/drive.activity"
            "https://www.googleapis.com/auth/drive.activity.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://driveactivity.googleapis.com/"
     "v2/activity:query"
     #{}
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
