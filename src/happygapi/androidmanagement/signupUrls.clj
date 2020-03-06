(ns happygapi.androidmanagement.signupUrls
  "Android Management API: signupUrls.
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/managementapi/reference/rest/v1/signupUrls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/signupUrls/create
  
  Required parameters: none
  
  Optional parameters: projectId, callbackUrl
  Creates an enterprise signup URL."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth args]
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
      :as :json}
     auth))))
