(ns happygapi.driveactivity.activity
  "Drive Activity API: activity.
  Provides a historical view of activity in Google Drive.
  See: https://developers.google.com/drive/activity/docs/reference/rest/v2/activity"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/drive/activity/api/reference/rest/v2/activity/query
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:itemName string,
   :ancestorName string,
   :consolidationStrategy {:none NoConsolidation, :legacy Legacy},
   :pageSize integer,
   :pageToken string,
   :filter string}
  
  Query past activity in Google Drive."
  {:scopes ["https://www.googleapis.com/auth/drive.activity"
            "https://www.googleapis.com/auth/drive.activity.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://driveactivity.googleapis.com/"
     "v2/activity:query"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
