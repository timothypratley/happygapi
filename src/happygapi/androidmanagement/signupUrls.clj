(ns happygapi.androidmanagement.signupUrls
  "Android Management API
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/management"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: none
  
  Creates an enterprise signup URL."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/signupUrls"
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
