(ns happygapi.plus.people
  "Google+ API
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "plus_schema.edn"))))

(defn get$
  "Required parameters: userId
  
  Optional parameters: none
  
  Get a person's profile. If your app uses scope https://www.googleapis.com/auth/plus.login, this method is guaranteed to return ageRange and language."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"
            "https://www.googleapis.com/auth/userinfo.email"
            "https://www.googleapis.com/auth/userinfo.profile"]}
  [auth args]
  {:pre [(util/has-keys? args #{"userId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: collection, userId
  
  Optional parameters: maxResults, orderBy, pageToken
  
  List all of the people in the specified collection."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection" "userId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: activityId, collection
  
  Optional parameters: maxResults, pageToken
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection" "activityId"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: language, maxResults, pageToken
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth args]
  {:pre [(util/has-keys? args #{"query"})
         (json-schema/validate schemas args)]}
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
