(ns happygapi.analytics.userDeletion
  "Google Analytics API: userDeletion.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/userDeletion"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn userDeletionRequest-upsert$
  "https://developers.google.com/analytics/api/reference/rest/v3/userDeletion/userDeletionRequest/upsert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:deletionRequestTime string,
   :firebaseProjectId string,
   :id {:type string, :userId string},
   :kind string,
   :propertyId string,
   :webPropertyId string}
  
  Insert or update a user deletion requests."
  {:scopes ["https://www.googleapis.com/auth/analytics.user.deletion"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "userDeletion/userDeletionRequests:upsert"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
