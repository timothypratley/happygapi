(ns happygapi.storage.notifications
  "Cloud Storage JSON API: notifications.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/notifications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/notifications/delete
  
  Required parameters: bucket, notification
  
  Optional parameters: userProject
  
  Permanently deletes a notification subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:notification :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/notificationConfigs/{notification}"
     #{:notification :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/notifications/get
  
  Required parameters: bucket, notification
  
  Optional parameters: userProject
  
  View a notification configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:notification :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/notificationConfigs/{notification}"
     #{:notification :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/notifications/insert
  
  Required parameters: bucket
  
  Optional parameters: userProject
  
  Body: 
  
  {:payload_format string,
   :selfLink string,
   :etag string,
   :topic string,
   :event_types [string],
   :id string,
   :kind string,
   :custom_attributes {},
   :object_name_prefix string}
  
  Creates a notification subscription for a given bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/notificationConfigs"
     #{:bucket}
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

(defn list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/notifications/list
  
  Required parameters: bucket
  
  Optional parameters: userProject
  
  Retrieves a list of notification subscriptions for a given bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/notificationConfigs"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
