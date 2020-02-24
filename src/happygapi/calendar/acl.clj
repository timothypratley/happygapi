(ns happygapi.calendar.acl
  "Calendar API
  Manipulates events and other calendar data.
  See: https://developers.google.com/google-apps/calendar/firstapp"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: calendarId,ruleId
  
  Deletes an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})]}
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
  "Required parameters: calendarId,ruleId
  
  Returns an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"
            "https://www.googleapis.com/auth/calendar.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})]}
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
  
  Creates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
      :body body}
     auth))))

(defn list$
  "Required parameters: calendarId
  
  Returns the rules in the access control list for the calendar."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
  "Required parameters: calendarId,ruleId
  
  Updates an access control rule. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})]}
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
  "Required parameters: calendarId,ruleId
  
  Updates an access control rule."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args]
  {:pre [(util/has-keys? args #{"calendarId" "ruleId"})]}
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
      :as :json}
     auth))))

(defn watch$
  "Required parameters: calendarId
  
  Watch for changes to ACL resources."
  {:scopes ["https://www.googleapis.com/auth/calendar"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"calendarId"})]}
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
      :body body}
     auth))))
