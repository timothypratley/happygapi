(ns happygapi.calendar.freebusy
  "Calendar API: freebusy.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/freebusy"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/freebusy/query
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeMin string,
   :timeMax string,
   :items [{:id string}],
   :groupExpansionMax integer,
   :calendarExpansionMax integer,
   :timeZone string}
  
  Returns free/busy information for a set of calendars."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "freeBusy"
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
