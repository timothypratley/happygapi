(ns happygapi.fcm.projects
  "Firebase Cloud Messaging API
  FCM send API that provides a cross-platform messaging solution to reliably deliver messages at no cost.
  See: https://firebase.google.com/docs/cloud-messaging"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn messages-send$
  "Required parameters: parent
  
  Send a message to specified target (a registration token, topic
  or condition)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://fcm.googleapis.com/"
     "v1/{+parent}/messages:send"
     #{"parent"}
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
