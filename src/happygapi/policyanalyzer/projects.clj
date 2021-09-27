(ns happygapi.policyanalyzer.projects
  "Policy Analyzer API: projects.
  
  See: https://www.google.comapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-activityTypes-activities-query$
  "https://www.google.comapi/reference/rest/v1/projects/locations/activityTypes/activities/query
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Queries policy activities on Google Cloud resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://policyanalyzer.googleapis.com/"
     "v1/{+parent}/activities:query"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
