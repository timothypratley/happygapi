(ns happygapi.calendar.colors
  "Calendar API: colors.
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstappdocs/reference/rest/v3/colors"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/calendar/firstappapi/reference/rest/v3/colors/get
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns the color definitions for calendars and events."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "colors"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
