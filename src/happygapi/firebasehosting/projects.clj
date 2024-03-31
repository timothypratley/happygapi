(ns happygapi.firebasehosting.projects
  "Firebase Hosting API: projects.
  The Firebase Hosting REST API enables programmatic and customizable management and deployments to your Firebase-hosted sites. Use this REST API to create and manage channels and sites as well as to deploy new or updated hosting configurations and content files.
  See: https://firebase.google.com/docs/hosting/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn sites-customDomains-operations-delete$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1/projects/sites/customDomains/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  DeleteOperation is a part of the google.longrunning.Operations interface, but is not implemented for CustomDomain resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-customDomains-operations-cancel$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1/projects/sites/customDomains/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  CancelOperation is a part of the google.longrunning.Operations interface, but is not implemented for CustomDomain resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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
