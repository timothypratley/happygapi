(ns happygapi.calendar.settings
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
  "Required parameters: setting
  
  Optional parameters: none
  
  Returns a single user setting."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"
            "https://www.googleapis.com/auth/calendar.settings.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"setting"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/settings/{setting}"
     #{"setting"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: maxResults, pageToken, syncToken
  
  Returns all user settings for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"
            "https://www.googleapis.com/auth/calendar.settings.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/settings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "Required parameters: none
  
  Optional parameters: maxResults, pageToken, syncToken
  
  Watch for changes to Settings resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"
            "https://www.googleapis.com/auth/calendar.settings.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "users/me/settings/watch"
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
