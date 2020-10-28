(ns happygapi.pubsublite.cursor
  "Pub/Sub Lite API: cursor.
  
  See: https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/cursor"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn projects-locations-subscriptions-cursors-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/cursor/projects/locations/subscriptions/cursors/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns all committed cursor information for a subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/cursor/{+parent}/cursors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
