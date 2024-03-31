(ns happygapi.playgrouping.apps
  "Google Play Grouping API: apps.
  playgrouping.googleapis.com API.
  See: https://cloud.google.com/playgrouping/api/reference/rest/v1alpha1/apps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn tokens-verify$
  "https://cloud.google.com/playgrouping/api/reference/rest/v1alpha1/apps/tokens/verify
  
  Required parameters: token, appPackage
  
  Optional parameters: none
  
  Body: 
  
  {:persona string}
  
  Verify an API token by asserting the app and persona it belongs to. The verification is a protection against client-side attacks and will fail if the contents of the token don't match the provided values. A token must be verified before it can be used to manipulate user tags."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:token :appPackage})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playgrouping.googleapis.com/"
     "v1alpha1/{+appPackage}/{+token}:verify"
     #{:token :appPackage}
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

(defn tokens-tags-createOrUpdate$
  "https://cloud.google.com/playgrouping/api/reference/rest/v1alpha1/apps/tokens/tags/createOrUpdate
  
  Required parameters: token, appPackage
  
  Optional parameters: none
  
  Body: 
  
  {:tags [{:key string,
           :int64Value string,
           :booleanValue boolean,
           :stringValue string,
           :timeValue string}]}
  
  Create or update tags for the user and app that are represented by the given token."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:token :appPackage})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playgrouping.googleapis.com/"
     "v1alpha1/{+appPackage}/{+token}/tags:createOrUpdate"
     #{:token :appPackage}
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
