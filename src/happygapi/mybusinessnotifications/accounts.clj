(ns happygapi.mybusinessnotifications.accounts
  "My Business Notifications API: accounts.
  The My Business Notification Settings API enables managing notification settings for business accounts. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getNotificationSetting$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/getNotificationSetting
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the pubsub notification settings for the account."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessnotifications.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateNotificationSetting$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/updateNotificationSetting
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :pubsubTopic string, :notificationTypes [string]}
  
  Sets the pubsub notification setting for the account informing Google which topic to send pubsub notifications for. Use the notification_types field within notification_setting to manipulate the events an account wants to subscribe to. An account will only have one notification setting resource, and only one pubsub topic can be set. To delete the setting, update with an empty notification_types"
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessnotifications.googleapis.com/"
     "v1/{+name}"
     #{:name}
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
