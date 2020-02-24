(ns happygapi.driveactivity.activity
  "Drive Activity API
  Provides a historical view of activity in Google Drive.
  See: https://developers.google.com/drive/activity/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn query$
  "Required parameters: none
  
  Query past activity in Google Drive."
  {:scopes ["https://www.googleapis.com/auth/drive.activity"
            "https://www.googleapis.com/auth/drive.activity.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
      :body body}
     auth))))
