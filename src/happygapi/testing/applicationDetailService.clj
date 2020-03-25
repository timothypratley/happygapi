(ns happygapi.testing.applicationDetailService
  "Cloud Testing API: applicationDetailService.
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/api/reference/rest/v1/applicationDetailService"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getApkDetails$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/applicationDetailService/getApkDetails
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:gcsPath string}
  
  Gets the details of an Android application APK."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/applicationDetailService/getApkDetails"
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
