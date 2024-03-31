(ns happygapi.calendar.acl
  "Calendar API: acl.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/delete
  
  Required parameters: calendarId, ruleId
  
  Optional parameters: none
  
  Deletes an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :ruleId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{:calendarId :ruleId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/get
  
  Required parameters: calendarId, ruleId
  
  Optional parameters: none
  
  Returns an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :ruleId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{:calendarId :ruleId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/insert
  
  Required parameters: calendarId
  
  Optional parameters: sendNotifications
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :role string,
   :scope {:type string, :value string}}
  
  Creates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl"
     #{:calendarId}
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
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/list
  
  Required parameters: calendarId
  
  Optional parameters: maxResults, pageToken, showDeleted, syncToken
  
  Returns the rules in the access control list for the calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/patch
  
  Required parameters: calendarId, ruleId
  
  Optional parameters: sendNotifications
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :role string,
   :scope {:type string, :value string}}
  
  Updates an access control rule. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId :ruleId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{:calendarId :ruleId}
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

(defn update$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/update
  
  Required parameters: calendarId, ruleId
  
  Optional parameters: sendNotifications
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :role string,
   :scope {:type string, :value string}}
  
  Updates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId :ruleId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{:calendarId :ruleId}
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

(defn watch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/acl/watch
  
  Required parameters: calendarId
  
  Optional parameters: maxResults, pageToken, showDeleted, syncToken
  
  Body: 
  
  {:address string,
   :resourceUri string,
   :payload boolean,
   :expiration string,
   :params {},
   :type string,
   :resourceId string,
   :token string,
   :id string,
   :kind string}
  
  Watch for changes to ACL resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/watch"
     #{:calendarId}
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
