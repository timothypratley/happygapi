(ns happygapi.plus.people
  "Google+ API: people.
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/api/reference/rest/v1/people"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/+/api/api/reference/rest/v1/people/get
  
  Required parameters: userId
  
  Optional parameters: none
  
  Get a person's profile. If your app uses scope https://www.googleapis.com/auth/plus.login, this method is guaranteed to return ageRange and language."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/+/api/api/reference/rest/v1/people/list
  
  Required parameters: collection, userId
  
  Optional parameters: maxResults, orderBy, pageToken
  
  List all of the people in the specified collection."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}/people/{collection}"
     #{:userId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listByActivity$
  "https://developers.google.com/+/api/api/reference/rest/v1/people/listByActivity
  
  Required parameters: activityId, collection
  
  Optional parameters: maxResults, pageToken
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collection :activityId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities/{activityId}/people/{collection}"
     #{:collection :activityId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://developers.google.com/+/api/api/reference/rest/v1/people/search
  
  Required parameters: query
  
  Optional parameters: language, maxResults, pageToken
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:query})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people"
     #{:query}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
