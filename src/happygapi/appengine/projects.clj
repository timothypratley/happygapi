(ns happygapi.appengine.projects
  "App Engine Admin API: projects.
  Provisions and manages developers' App Engine applications.
  See: https://cloud.google.com/appengine/docs/admin-api/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-applications-authorizedDomains-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/projects/locations/applications/authorizedDomains/list
  
  Required parameters: projectsId, locationsId, applicationsId
  
  Optional parameters: pageSize, pageToken
  
  Lists all domains the user is authorized to administer."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:applicationsId :projectsId :locationsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/projects/{projectsId}/locations/{locationsId}/applications/{applicationsId}/authorizedDomains"
     #{:applicationsId :projectsId :locationsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
