(ns happygapi.calendar.events
  "Calendar API
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstapp"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: calendarId,eventId
  
  Returns an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})]}
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
  
  Creates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
      :body body}
     auth))))

(defn patch$
  "Required parameters: calendarId,eventId
  
  Updates an event. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})]}
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
  "Required parameters: calendarId,destination,eventId
  
  Moves an event to another calendar, i.e. changes an event's organizer."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"destination" "calendarId" "eventId"})]}
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
      :body body}
     auth))))

(defn update$
  "Required parameters: calendarId,eventId
  
  Updates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})]}
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
      :as :json}
     auth))))

(defn delete$
  "Required parameters: calendarId,eventId
  
  Deletes an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})]}
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
  "Required parameters: calendarId,eventId
  
  Returns instances of the specified recurring event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "eventId"})]}
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
  
  Returns events on the specified calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
  
  Watch for changes to Events resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
      :body body}
     auth))))

(defn quickAdd$
  "Required parameters: calendarId,text
  
  Creates an event based on a simple text string."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId" "text"})]}
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
      :body body}
     auth))))

(defn import$
  "Required parameters: calendarId
  
  Imports an event. This operation is used to add a private copy of an existing event to a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
      :body body}
     auth))))
