(ns happygapi.calendar.events
  "Calendar API: events.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/get
  
  Required parameters: eventId, calendarId
  
  Optional parameters: maxAttendees, alwaysIncludeEmail, timeZone
  
  Returns an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :eventId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{:calendarId :eventId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/insert
  
  Required parameters: calendarId
  
  Optional parameters: sendNotifications, conferenceDataVersion, maxAttendees, supportsAttachments, sendUpdates
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :creator {:displayName string,
             :id string,
             :self boolean,
             :email string},
   :privateCopy boolean,
   :extendedProperties {:shared {}, :private {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:fileId string,
                  :iconLink string,
                  :mimeType string,
                  :fileUrl string,
                  :title string}],
   :conferenceData {:entryPoints [EntryPoint],
                    :createRequest CreateConferenceRequest,
                    :conferenceSolution ConferenceSolution,
                    :notes string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :signature string},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:url string, :title string},
   :summary string,
   :attendees [{:email string,
                :displayName string,
                :additionalGuests integer,
                :id string,
                :resource boolean,
                :optional boolean,
                :comment string,
                :responseStatus string,
                :self boolean,
                :organizer boolean}],
   :attendeesOmitted boolean,
   :anyoneCanAddSelf boolean,
   :status string,
   :locked boolean,
   :id string,
   :kind string,
   :sequence integer,
   :guestsCanInviteOthers boolean,
   :recurrence [string],
   :gadget {:iconLink string,
            :width integer,
            :height integer,
            :link string,
            :preferences {},
            :title string,
            :type string,
            :display string},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:email string,
               :id string,
               :displayName string,
               :self boolean},
   :transparency string}
  
  Creates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events"
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
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/patch
  
  Required parameters: calendarId, eventId
  
  Optional parameters: sendUpdates, maxAttendees, alwaysIncludeEmail, supportsAttachments, sendNotifications, conferenceDataVersion
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :creator {:displayName string,
             :id string,
             :self boolean,
             :email string},
   :privateCopy boolean,
   :extendedProperties {:shared {}, :private {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:fileId string,
                  :iconLink string,
                  :mimeType string,
                  :fileUrl string,
                  :title string}],
   :conferenceData {:entryPoints [EntryPoint],
                    :createRequest CreateConferenceRequest,
                    :conferenceSolution ConferenceSolution,
                    :notes string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :signature string},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:url string, :title string},
   :summary string,
   :attendees [{:email string,
                :displayName string,
                :additionalGuests integer,
                :id string,
                :resource boolean,
                :optional boolean,
                :comment string,
                :responseStatus string,
                :self boolean,
                :organizer boolean}],
   :attendeesOmitted boolean,
   :anyoneCanAddSelf boolean,
   :status string,
   :locked boolean,
   :id string,
   :kind string,
   :sequence integer,
   :guestsCanInviteOthers boolean,
   :recurrence [string],
   :gadget {:iconLink string,
            :width integer,
            :height integer,
            :link string,
            :preferences {},
            :title string,
            :type string,
            :display string},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:email string,
               :id string,
               :displayName string,
               :self boolean},
   :transparency string}
  
  Updates an event. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId :eventId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{:calendarId :eventId}
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

(defn move$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/move
  
  Required parameters: calendarId, destination, eventId
  
  Optional parameters: sendNotifications, sendUpdates
  
  Moves an event to another calendar, i.e. changes an event's organizer."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:calendarId :eventId :destination})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}/move"
     #{:calendarId :eventId :destination}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/update
  
  Required parameters: eventId, calendarId
  
  Optional parameters: maxAttendees, alwaysIncludeEmail, conferenceDataVersion, supportsAttachments, sendNotifications, sendUpdates
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :creator {:displayName string,
             :id string,
             :self boolean,
             :email string},
   :privateCopy boolean,
   :extendedProperties {:shared {}, :private {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:fileId string,
                  :iconLink string,
                  :mimeType string,
                  :fileUrl string,
                  :title string}],
   :conferenceData {:entryPoints [EntryPoint],
                    :createRequest CreateConferenceRequest,
                    :conferenceSolution ConferenceSolution,
                    :notes string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :signature string},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:url string, :title string},
   :summary string,
   :attendees [{:email string,
                :displayName string,
                :additionalGuests integer,
                :id string,
                :resource boolean,
                :optional boolean,
                :comment string,
                :responseStatus string,
                :self boolean,
                :organizer boolean}],
   :attendeesOmitted boolean,
   :anyoneCanAddSelf boolean,
   :status string,
   :locked boolean,
   :id string,
   :kind string,
   :sequence integer,
   :guestsCanInviteOthers boolean,
   :recurrence [string],
   :gadget {:iconLink string,
            :width integer,
            :height integer,
            :link string,
            :preferences {},
            :title string,
            :type string,
            :display string},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:email string,
               :id string,
               :displayName string,
               :self boolean},
   :transparency string}
  
  Updates an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId :eventId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{:calendarId :eventId}
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
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/delete
  
  Required parameters: calendarId, eventId
  
  Optional parameters: sendNotifications, sendUpdates
  
  Deletes an event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :eventId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}"
     #{:calendarId :eventId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/instances
  
  Required parameters: calendarId, eventId
  
  Optional parameters: timeZone, timeMin, maxAttendees, originalStart, pageToken, showDeleted, maxResults, timeMax, alwaysIncludeEmail
  
  Returns instances of the specified recurring event."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :eventId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/{eventId}/instances"
     #{:calendarId :eventId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/list
  
  Required parameters: calendarId
  
  Optional parameters: iCalUID, q, timeZone, showHiddenInvitations, timeMin, syncToken, maxAttendees, pageToken, sharedExtendedProperty, privateExtendedProperty, showDeleted, updatedMin, singleEvents, maxResults, timeMax, orderBy, alwaysIncludeEmail
  
  Returns events on the specified calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events"
     #{:calendarId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/watch
  
  Required parameters: calendarId
  
  Optional parameters: iCalUID, q, timeZone, showHiddenInvitations, timeMin, syncToken, maxAttendees, pageToken, sharedExtendedProperty, privateExtendedProperty, showDeleted, updatedMin, singleEvents, maxResults, timeMax, orderBy, alwaysIncludeEmail
  
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
  
  Watch for changes to Events resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"
            "https://www.googleapis.com/auth/calendar.events.readonly"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/watch"
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

(defn quickAdd$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/quickAdd
  
  Required parameters: text, calendarId
  
  Optional parameters: sendUpdates, sendNotifications
  
  Creates an event based on a simple text string."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:calendarId :text})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/quickAdd"
     #{:calendarId :text}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn import$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/events/import
  
  Required parameters: calendarId
  
  Optional parameters: supportsAttachments, conferenceDataVersion
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :creator {:displayName string,
             :id string,
             :self boolean,
             :email string},
   :privateCopy boolean,
   :extendedProperties {:shared {}, :private {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:fileId string,
                  :iconLink string,
                  :mimeType string,
                  :fileUrl string,
                  :title string}],
   :conferenceData {:entryPoints [EntryPoint],
                    :createRequest CreateConferenceRequest,
                    :conferenceSolution ConferenceSolution,
                    :notes string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :signature string},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:url string, :title string},
   :summary string,
   :attendees [{:email string,
                :displayName string,
                :additionalGuests integer,
                :id string,
                :resource boolean,
                :optional boolean,
                :comment string,
                :responseStatus string,
                :self boolean,
                :organizer boolean}],
   :attendeesOmitted boolean,
   :anyoneCanAddSelf boolean,
   :status string,
   :locked boolean,
   :id string,
   :kind string,
   :sequence integer,
   :guestsCanInviteOthers boolean,
   :recurrence [string],
   :gadget {:iconLink string,
            :width integer,
            :height integer,
            :link string,
            :preferences {},
            :title string,
            :type string,
            :display string},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:email string,
               :id string,
               :displayName string,
               :self boolean},
   :transparency string}
  
  Imports an event. This operation is used to add a private copy of an existing event to a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.events"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:calendarId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/events/import"
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
