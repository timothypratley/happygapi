(ns happygapi.baremetalsolution.projects
  "Bare Metal Solution API: projects.
  Provides ways to manage Bare Metal Solution hardware installed in a regional extension located near a Google Cloud data center.
  See: https://cloud.google.com/bare-metalapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-instances-resetInstance$
  "https://cloud.google.com/bare-metalapi/reference/rest/v1/projects/locations/instances/resetInstance
  
  Required parameters: instance
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Perform an ungraceful, hard reset on a machine (equivalent to shutting the power off, and then turning it back on)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://baremetalsolution.googleapis.com/"
     "v1/{+instance}:resetInstance"
     #{:instance}
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
