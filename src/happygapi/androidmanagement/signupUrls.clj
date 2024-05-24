(ns happygapi.androidmanagement.signupUrls
  "Android Management API: signupUrls.
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/managementdocs/reference/rest/v1/signupUrls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/android/managementapi/reference/rest/v1/signupUrls/create
  
  Required parameters: none
  
  Optional parameters: projectId, callbackUrl, adminEmail
  
  Creates an enterprise signup URL."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/signupUrls"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
