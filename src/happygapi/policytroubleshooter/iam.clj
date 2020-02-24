(ns happygapi.policytroubleshooter.iam
  "Policy Troubleshooter API
  
  See: https://cloud.google.com/iam/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn troubleshoot$
  "Required parameters: none
  
  Checks whether a member has a specific permission for a specific resource,
  and explains why the member does or does not have that permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://policytroubleshooter.googleapis.com/"
     "v1/iam:troubleshoot"
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
