(ns happygapi.apigee.projects
  "Apigee API: projects.
  Use the Apigee API to programmatically develop and manage APIs with a set of RESTful operations. Develop and secure API proxies, deploy and undeploy API proxy revisions, monitor APIs, configure environments, manage users, and more. Note: This product is available as a free trial for a time period of 60 days.
  See: https://cloud.google.com/apigee-api-management/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn provisionOrganization$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/projects/provisionOrganization
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:authorizedNetwork string,
   :runtimeLocation string,
   :analyticsRegion string}
  
  Provisions a new Apigee organization with a functioning runtime. This is the standard way to create trial organizations for a free Apigee trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+project}:provisionOrganization"
     #{:project}
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
