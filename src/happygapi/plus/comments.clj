(ns happygapi.plus.comments
  "Google+ API: comments.
  Builds on top of the Google+ platform.
  See: https://developers.google.com/+/api/api/reference/rest/v1/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/+/api/api/reference/rest/v1/comments/get
  
  Required parameters: commentId
  
  Optional parameters: none
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:commentId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "comments/{commentId}"
     #{:commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/+/api/api/reference/rest/v1/comments/list
  
  Required parameters: activityId
  
  Optional parameters: maxResults, pageToken, sortOrder
  
  Shut down. See https://developers.google.com/+/api-shutdown for more details."
  {:scopes ["https://www.googleapis.com/auth/plus.login"
            "https://www.googleapis.com/auth/plus.me"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:activityId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/plus/v1/"
     "activities/{activityId}/comments"
     #{:activityId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
