(ns happygapi.androidpublisher.reviews
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: packageName,reviewId
  
  Returns a single review."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reviewId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews/{reviewId}"
     #{"reviewId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: packageName
  
  Returns a list of reviews. Only reviews from last week will be returned."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews"
     #{"packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reply$
  "Required parameters: packageName,reviewId
  
  Reply to a single review, or update an existing reply."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"reviewId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/reviews/{reviewId}:reply"
     #{"reviewId" "packageName"}
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
