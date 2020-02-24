(ns happygapi.testing.applicationDetailService
  "Cloud Testing API
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getApkDetails$
  "Required parameters: none
  
  Gets the details of an Android application APK."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/applicationDetailService/getApkDetails"
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
