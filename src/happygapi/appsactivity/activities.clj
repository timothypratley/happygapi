(ns happygapi.appsactivity.activities
  "Drive Activity API: activities.
  Provides a historical view of activity.
  See: https://developers.google.com/google-apps/activity/api/reference/rest/v1/activities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/google-apps/activity/api/reference/rest/v1/activities/list
  
  Required parameters: none
  
  Optional parameters: drive.ancestorId, drive.fileId, groupingStrategy, pageSize, pageToken, source, userId
  Returns a list of activities visible to the current logged in user. Visible activities are determined by the visibility settings of the object that was acted on, e.g. Drive files a user can see. An activity is a record of past events. Multiple events may be merged if they are similar. A request is scoped to activities from a given Google service using the source parameter."
  {:scopes ["https://www.googleapis.com/auth/activity"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/appsactivity/v1/"
     "activities"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
