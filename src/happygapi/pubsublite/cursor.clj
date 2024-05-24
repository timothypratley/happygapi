(ns happygapi.pubsublite.cursor
  "Pub/Sub Lite API: cursor.
  
  See: https://cloud.google.com/pubsub/lite/docsdocs/reference/rest/v1/cursor"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn projects-locations-subscriptions-commitCursor$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/cursor/projects/locations/subscriptions/commitCursor
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:partition string, :cursor {:offset string}}
  
  Updates the committed cursor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/cursor/{+subscription}:commitCursor"
     #{:subscription}
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

(defn projects-locations-subscriptions-cursors-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/cursor/projects/locations/subscriptions/cursors/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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
