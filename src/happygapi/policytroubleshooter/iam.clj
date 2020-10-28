(ns happygapi.policytroubleshooter.iam
  "Policy Troubleshooter API: iam.
  
  See: https://cloud.google.com/iam/api/reference/rest/v1/iam"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn troubleshoot$
  "https://cloud.google.com/iam/api/reference/rest/v1/iam/troubleshoot
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:accessTuple {:principal string,
                 :fullResourceName string,
                 :permission string}}
  
  Checks whether a member has a specific permission for a specific resource, and explains why the member does or does not have that permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://policytroubleshooter.googleapis.com/"
     "v1/iam:troubleshoot"
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
