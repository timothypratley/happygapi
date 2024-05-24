(ns happygapi.advisorynotifications.organizations
  "Advisory Notifications API: organizations.
  An API for accessing Advisory Notifications in Google Cloud
  See: https://cloud.google.com/advisory-notificationsdocs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-updateSettings$
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/organizations/locations/updateSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string, :notificationSettings {}, :name string}
  
  Update notification settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://advisorynotifications.googleapis.com/"
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

(defn locations-getSettings$
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/organizations/locations/getSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Get notification settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://advisorynotifications.googleapis.com/"
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

(defn locations-notifications-get$
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/organizations/locations/notifications/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Gets a notification."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://advisorynotifications.googleapis.com/"
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

(defn locations-notifications-list$
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/organizations/locations/notifications/list
  
  Required parameters: parent
  
  Optional parameters: languageCode, pageSize, pageToken, view
  
  Lists notifications under a given parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://advisorynotifications.googleapis.com/"
     "v1/{+parent}/notifications"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
