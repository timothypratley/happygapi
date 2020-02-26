(ns happygapi.calendar.calendars
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

(defn clear$
  "Required parameters: calendarId
  
  Optional parameters: none
  
  Clears a primary calendar. This operation deletes all events associated with the primary calendar of an account."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/clear"
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

(defn delete$
  "Required parameters: calendarId
  
  Optional parameters: none
  
  Deletes a secondary calendar. Use calendars.clear for clearing all events on primary calendars."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: calendarId
  
  Optional parameters: none
  
  Returns metadata for a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a secondary calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars"
     #{}
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
  "Required parameters: calendarId
  
  Optional parameters: none
  
  Updates metadata for a calendar. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: calendarId
  
  Optional parameters: none
  
  Updates metadata for a calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}"
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
