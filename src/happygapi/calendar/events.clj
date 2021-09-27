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
  
  Optional parameters: alwaysIncludeEmail, timeZone, maxAttendees
  
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
  
  Optional parameters: conferenceDataVersion, supportsAttachments, sendNotifications, sendUpdates, maxAttendees
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :eventType string,
   :creator {:self boolean,
             :displayName string,
             :email string,
             :id string},
   :privateCopy boolean,
   :extendedProperties {:private {}, :shared {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:iconLink string,
                  :title string,
                  :fileUrl string,
                  :fileId string,
                  :mimeType string}],
   :conferenceData {:notes string,
                    :createRequest CreateConferenceRequest,
                    :signature string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :conferenceSolution ConferenceSolution,
                    :entryPoints [EntryPoint]},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:title string, :url string},
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
   :gadget {:width integer,
            :type string,
            :display string,
            :iconLink string,
            :link string,
            :title string,
            :height integer,
            :preferences {}},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:displayName string,
               :id string,
               :self boolean,
               :email string},
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
  
  Required parameters: eventId, calendarId
  
  Optional parameters: conferenceDataVersion, sendUpdates, alwaysIncludeEmail, supportsAttachments, sendNotifications, maxAttendees
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :eventType string,
   :creator {:self boolean,
             :displayName string,
             :email string,
             :id string},
   :privateCopy boolean,
   :extendedProperties {:private {}, :shared {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:iconLink string,
                  :title string,
                  :fileUrl string,
                  :fileId string,
                  :mimeType string}],
   :conferenceData {:notes string,
                    :createRequest CreateConferenceRequest,
                    :signature string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :conferenceSolution ConferenceSolution,
                    :entryPoints [EntryPoint]},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:title string, :url string},
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
   :gadget {:width integer,
            :type string,
            :display string,
            :iconLink string,
            :link string,
            :title string,
            :height integer,
            :preferences {}},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:displayName string,
               :id string,
               :self boolean,
               :email string},
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
  
  Required parameters: destination, eventId, calendarId
  
  Optional parameters: sendUpdates, sendNotifications
  
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
  
  Optional parameters: alwaysIncludeEmail, supportsAttachments, sendNotifications, conferenceDataVersion, maxAttendees, sendUpdates
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :eventType string,
   :creator {:self boolean,
             :displayName string,
             :email string,
             :id string},
   :privateCopy boolean,
   :extendedProperties {:private {}, :shared {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:iconLink string,
                  :title string,
                  :fileUrl string,
                  :fileId string,
                  :mimeType string}],
   :conferenceData {:notes string,
                    :createRequest CreateConferenceRequest,
                    :signature string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :conferenceSolution ConferenceSolution,
                    :entryPoints [EntryPoint]},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:title string, :url string},
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
   :gadget {:width integer,
            :type string,
            :display string,
            :iconLink string,
            :link string,
            :title string,
            :height integer,
            :preferences {}},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:displayName string,
               :id string,
               :self boolean,
               :email string},
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
  
  Optional parameters: conferenceDataVersion, supportsAttachments
  
  Body: 
  
  {:iCalUID string,
   :recurringEventId string,
   :description string,
   :eventType string,
   :creator {:self boolean,
             :displayName string,
             :email string,
             :id string},
   :privateCopy boolean,
   :extendedProperties {:private {}, :shared {}},
   :updated string,
   :endTimeUnspecified boolean,
   :attachments [{:iconLink string,
                  :title string,
                  :fileUrl string,
                  :fileId string,
                  :mimeType string}],
   :conferenceData {:notes string,
                    :createRequest CreateConferenceRequest,
                    :signature string,
                    :conferenceId string,
                    :parameters ConferenceParameters,
                    :conferenceSolution ConferenceSolution,
                    :entryPoints [EntryPoint]},
   :htmlLink string,
   :start {:timeZone string, :dateTime string, :date string},
   :etag string,
   :created string,
   :guestsCanSeeOtherGuests boolean,
   :originalStartTime {:timeZone string, :dateTime string, :date string},
   :source {:title string, :url string},
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
   :gadget {:width integer,
            :type string,
            :display string,
            :iconLink string,
            :link string,
            :title string,
            :height integer,
            :preferences {}},
   :reminders {:useDefault boolean,
               :overrides [{:minutes integer, :method string}]},
   :guestsCanModify boolean,
   :end {:timeZone string, :dateTime string, :date string},
   :colorId string,
   :location string,
   :visibility string,
   :hangoutLink string,
   :organizer {:displayName string,
               :id string,
               :self boolean,
               :email string},
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
