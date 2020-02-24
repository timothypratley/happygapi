(ns happygapi.analytics.userDeletion
  "Google Analytics API
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn userDeletionRequest-upsert$
  "Required parameters: none
  
  Insert or update a user deletion requests."
  {:scopes ["https://www.googleapis.com/auth/analytics.user.deletion"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "userDeletion/userDeletionRequests:upsert"
     #{}
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
