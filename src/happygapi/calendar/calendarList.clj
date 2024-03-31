(ns happygapi.calendar.calendarList
  "Calendar API: calendarList.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/delete
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Removes a calendar from the user's calendar list."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList/{calendarId}"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/get
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Returns a calendar from the user's calendar list."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList/{calendarId}"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/insert
  
  Required parameters: none
  
  Optional parameters: colorRgbFormat
  
  Body: 
  
  {:description string,
   :timeZone string,
   :deleted boolean,
   :notificationSettings {:notifications [{:method string, :type string}]},
   :primary boolean,
   :selected boolean,
   :summaryOverride string,
   :accessRole string,
   :etag string,
   :defaultReminders [{:method string, :minutes integer}],
   :summary string,
   :hidden boolean,
   :id string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :backgroundColor string,
   :colorId string,
   :location string,
   :foregroundColor string}
  
  Inserts an existing calendar into the user's calendar list."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList"
     #{}
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
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/list
  
  Required parameters: none
  
  Optional parameters: maxResults, minAccessRole, pageToken, showDeleted, showHidden, syncToken
  
  Returns the calendars on the user's calendar list."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/patch
  
  Required parameters: calendarId
  
  Optional parameters: colorRgbFormat
  
  Body: 
  
  {:description string,
   :timeZone string,
   :deleted boolean,
   :notificationSettings {:notifications [{:method string, :type string}]},
   :primary boolean,
   :selected boolean,
   :summaryOverride string,
   :accessRole string,
   :etag string,
   :defaultReminders [{:method string, :minutes integer}],
   :summary string,
   :hidden boolean,
   :id string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :backgroundColor string,
   :colorId string,
   :location string,
   :foregroundColor string}
  
  Updates an existing calendar on the user's calendar list. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList/{calendarId}"
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

(defn update$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/update
  
  Required parameters: calendarId
  
  Optional parameters: colorRgbFormat
  
  Body: 
  
  {:description string,
   :timeZone string,
   :deleted boolean,
   :notificationSettings {:notifications [{:method string, :type string}]},
   :primary boolean,
   :selected boolean,
   :summaryOverride string,
   :accessRole string,
   :etag string,
   :defaultReminders [{:method string, :minutes integer}],
   :summary string,
   :hidden boolean,
   :id string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :backgroundColor string,
   :colorId string,
   :location string,
   :foregroundColor string}
  
  Updates an existing calendar on the user's calendar list."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList/{calendarId}"
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

(defn watch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendarList/watch
  
  Required parameters: none
  
  Optional parameters: maxResults, minAccessRole, pageToken, showDeleted, showHidden, syncToken
  
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
  
  Watch for changes to CalendarList resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/calendarList/watch"
     #{}
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
