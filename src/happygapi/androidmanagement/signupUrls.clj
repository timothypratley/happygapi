(ns happygapi.androidmanagement.signupUrls
  "Android Management API
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/management"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidmanagement_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: callbackUrl, projectId
  
  Creates an enterprise signup URL."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
