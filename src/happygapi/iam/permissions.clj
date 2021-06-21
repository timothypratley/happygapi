(ns happygapi.iam.permissions
  "Identity and Access Management (IAM) API: permissions.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls. 
  See: https://cloud.google.com/iam/api/reference/rest/v1/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn queryTestablePermissions$
  "https://cloud.google.com/iam/api/reference/rest/v1/permissions/queryTestablePermissions
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer, :pageToken string, :fullResourceName string}
  
  Lists every permission that you can test on a resource. A permission is testable if you can check whether a member has that permission on the resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/permissions:queryTestablePermissions"
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
