(ns happygapi.calendar.events
  "Calendar API
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstapp"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "calendar_schema.edn"))))

(defn get$
  "Required parameters: calendarId, eventId
  
  Optional parameters: alwaysIncludeEmail, maxAttendees, timeZone
  
  Returns an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: calendarId
  
  Optional parameters: conferenceDataVersion, maxAttendees, sendNotifications, sendUpdates, supportsAttachments
  
  Creates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn patch$
  "Required parameters: calendarId, eventId
  
  Optional parameters: alwaysIncludeEmail, conferenceDataVersion, maxAttendees, sendNotifications, sendUpdates, supportsAttachments
  
  Updates an event. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn move$
  "Required parameters: calendarId, destination, eventId
  
  Optional parameters: sendNotifications, sendUpdates
  
  Moves an event to another calendar, i.e. changes an event's organizer."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"destination" "calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}/move"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn update$
  "Required parameters: calendarId, eventId
  
  Optional parameters: alwaysIncludeEmail, conferenceDataVersion, maxAttendees, sendNotifications, sendUpdates, supportsAttachments
  
  Updates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn delete$
  "Required parameters: calendarId, eventId
  
  Optional parameters: sendNotifications, sendUpdates
  
  Deletes an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances$
  "Required parameters: calendarId, eventId
  
  Optional parameters: timeZone, timeMin, maxAttendees, originalStart, pageToken, showDeleted, maxResults, timeMax, alwaysIncludeEmail
  
  Returns instances of the specified recurring event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}/instances"
     #{"calendarId" "eventId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: calendarId
  
  Optional parameters: iCalUID, q, timeZone, showHiddenInvitations, timeMin, syncToken, maxAttendees, pageToken, sharedExtendedProperty, privateExtendedProperty, showDeleted, updatedMin, singleEvents, maxResults, timeMax, orderBy, alwaysIncludeEmail
  
  Returns events on the specified calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "Required parameters: calendarId
  
  Optional parameters: iCalUID, q, timeZone, showHiddenInvitations, timeMin, syncToken, maxAttendees, pageToken, sharedExtendedProperty, privateExtendedProperty, showDeleted, updatedMin, singleEvents, maxResults, timeMax, orderBy, alwaysIncludeEmail
  
  Watch for changes to Events resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/watch"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn quickAdd$
  "Required parameters: calendarId, text
  
  Optional parameters: sendNotifications, sendUpdates
  
  Creates an event based on a simple text string."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId" "text"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/quickAdd"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn import$
  "Required parameters: calendarId
  
  Optional parameters: conferenceDataVersion, supportsAttachments
  
  Imports an event. This operation is used to add a private copy of an existing event to a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/import"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
