(ns happygapi.plus.activities
  "Google+ API: activities.
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/api/reference/rest/v1/activities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/+/api/api/reference/rest/v1/activities/get
  
  Required parameters: activityId
  
  Optional parameters: none
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{:activityId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities/{activityId}"
     #{:activityId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/+/api/api/reference/rest/v1/activities/list
  
  Required parameters: collection, userId
  
  Optional parameters: maxResults, pageToken
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{:userId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}/activities/{collection}"
     #{:userId :collection}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://developers.google.com/+/api/api/reference/rest/v1/activities/search
  
  Required parameters: query
  
  Optional parameters: language, maxResults, orderBy, pageToken
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{:query})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities"
     #{:query}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
