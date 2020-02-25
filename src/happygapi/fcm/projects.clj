(ns happygapi.fcm.projects
  "Firebase Cloud Messaging API
  FCM send API that provides a cross-platform messaging solution to reliably deliver messages at no cost.
  See: https://firebase.google.com/docs/cloud-messaging"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "fcm_schema.edn"))))

(defn messages-send$
  "Required parameters: parent
  
  Optional parameters: none
  
  Send a message to specified target (a registration token, topic
  or condition)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
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
