(ns happygapi.plus.people
  "Google+ API
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: userId
  
  Get a person's profile. If your app uses scope https://www.googleapis.com/auth/plus.login, this method is guaranteed to return ageRange and language."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}"
     #{"userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: collection,userId
  
  List all of the people in the specified collection."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}/people/{collection}"
     #{"collection" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listByActivity$
  "Required parameters: activityId,collection
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection" "activityId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities/{activityId}/people/{collection}"
     #{"collection" "activityId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "Required parameters: query
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"query"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
