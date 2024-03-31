(ns happygapi.advisorynotifications.projects
  "Advisory Notifications API: projects.
  An API for accessing Advisory Notifications in Google Cloud
  See: https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-notifications-get$
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/projects/locations/notifications/get
  
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
  "https://cloud.google.com/advisory-notificationsapi/reference/rest/v1/projects/locations/notifications/list
  
  Required parameters: parent
  
  Optional parameters: languageCode, view, pageToken, pageSize
  
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
