(ns happygapi.calendar.acl
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

(defn delete$
  "Required parameters: calendarId, ruleId
  
  Optional parameters: none
  
  Deletes an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{"calendarId" "ruleId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: calendarId, ruleId
  
  Optional parameters: none
  
  Returns an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{"calendarId" "ruleId"}
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
  
  Optional parameters: sendNotifications
  
  Creates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl"
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

(defn list$
  "Required parameters: calendarId
  
  Optional parameters: maxResults, pageToken, showDeleted, syncToken
  
  Returns the rules in the access control list for the calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl"
     #{"calendarId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: calendarId, ruleId
  
  Optional parameters: sendNotifications
  
  Updates an access control rule. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{"calendarId" "ruleId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: calendarId, ruleId
  
  Optional parameters: sendNotifications
  
  Updates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/{ruleId}"
     #{"calendarId" "ruleId"}
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

(defn watch$
  "Required parameters: calendarId
  
  Optional parameters: maxResults, pageToken, showDeleted, syncToken
  
  Watch for changes to ACL resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/calendar/v3/"
     "calendars/{calendarId}/acl/watch"
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
