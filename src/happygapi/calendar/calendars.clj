(ns happygapi.calendar.calendars
  "Calendar API: calendars.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:summary string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :location string,
   :id string,
   :etag string,
   :description string,
   :timeZone string}
  
  Creates a secondary calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars"
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

(defn delete$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/delete
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Deletes a secondary calendar. Use calendars.clear for clearing all events on primary calendars."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/update
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Body: 
  
  {:summary string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :location string,
   :id string,
   :etag string,
   :description string,
   :timeZone string}
  
  Updates metadata for a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
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

(defn patch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/patch
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Body: 
  
  {:summary string,
   :kind string,
   :conferenceProperties {:allowedConferenceSolutionTypes [string]},
   :location string,
   :id string,
   :etag string,
   :description string,
   :timeZone string}
  
  Updates metadata for a calendar. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
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

(defn get$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/get
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Returns metadata for a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clear$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/calendars/clear
  
  Required parameters: calendarId
  
  Optional parameters: none
  
  Clears a primary calendar. This operation deletes all events associated with the primary calendar of an account."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/clear"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
