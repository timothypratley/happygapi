(ns happygapi.androidpublisher.reviews
  "Google Play Developer API: reviews.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/reviews"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/reviews/get
  
  Required parameters: packageName, reviewId
  
  Optional parameters: translationLanguage
  
  Returns a single review."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :reviewId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews/{reviewId}"
     #{:packageName :reviewId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/reviews/list
  
  Required parameters: packageName
  
  Optional parameters: maxResults, startIndex, token, translationLanguage
  
  Returns a list of reviews. Only reviews from last week will be returned."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reply$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/reviews/reply
  
  Required parameters: packageName, reviewId
  
  Optional parameters: none
  
  Body: 
  
  {:replyText string}
  
  Reply to a single review, or update an existing reply."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :reviewId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews/{reviewId}:reply"
     #{:packageName :reviewId}
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
