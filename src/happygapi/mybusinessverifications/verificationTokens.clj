(ns happygapi.mybusinessverifications.verificationTokens
  "My Business Verifications API: verificationTokens.
  The My Business Verifications API provides an interface for taking verifications related actions for locations.
  See: https://developers.google.com/my-business/api/reference/rest/v1/verificationTokens"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/my-business/api/reference/rest/v1/verificationTokens/generate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:location {:primaryPhone string,
              :primaryCategoryId string,
              :address PostalAddress,
              :websiteUri string,
              :name string}}
  
  Generates a token for the provided location data as a vetted [partner](https://support.google.com/business/answer/7674102). Throws PERMISSION_DENIED if the caller is not a vetted partner account. Throws FAILED_PRECONDITION if the caller's VettedStatus is INVALID."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/verificationTokens:generate"
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
