(ns happygapi.plus.activities
  "Google+ API
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: activityId
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"activityId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities/{activityId}"
     #{"activityId"}
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
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "people/{userId}/activities/{collection}"
     #{"collection" "userId"}
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
     "activities"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
