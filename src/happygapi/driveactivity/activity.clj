(ns happygapi.driveactivity.activity
  "Drive Activity API: activity.
  Provides a historical view of activity in Google Drive.
  See: https://developers.google.com/drive/activity/api/reference/rest/v2/activity"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/drive/activity/api/reference/rest/v2/activity/query
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :ancestorName string,
   :consolidationStrategy {:none NoConsolidation, :legacy Legacy},
   :itemName string,
   :filter string,
   :pageToken string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
