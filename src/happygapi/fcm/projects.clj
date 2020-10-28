(ns happygapi.fcm.projects
  "Firebase Cloud Messaging API: projects.
  FCM send API that provides a cross-platform messaging solution to reliably deliver messages at no cost.
  See: https://firebase.google.com/docs/cloud-messagingapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn messages-send$
  "https://firebase.google.com/docs/cloud-messagingapi/reference/rest/v1/projects/messages/send
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :message {:notification Notification,
             :name string,
             :topic string,
             :token string,
             :webpush WebpushConfig,
             :android AndroidConfig,
             :condition string,
             :fcmOptions FcmOptions,
             :apns ApnsConfig,
             :data {}}}
  
  Send a message to specified target (a registration token, topic or condition)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://fcm.googleapis.com/"
     "v1/{+parent}/messages:send"
     #{:parent}
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
