(ns happygapi.firebase.availableProjects
  "Firebase Management API
  The Firebase Management API enables programmatic setup and management of Firebase projects, including a project's Firebase resources and Firebase apps.
  See: https://firebase.google.com"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: none
  
  Returns a list of [Google Cloud Platform (GCP) `Projects`]
  (https://cloud.google.com/resource-manager/reference/rest/v1/projects)
  that are available to have Firebase resources added to them.
  <br>
  <br>A GCP `Project` will only be returned if:
  <ol>
    <li><p>The caller has sufficient
           [Google IAM](https://cloud.google.com/iam) permissions to call
           AddFirebase.</p></li>
    <li><p>The GCP `Project` is not already a FirebaseProject.</p></li>
    <li><p>The GCP `Project` is not in an Organization which has policies
           that prevent Firebase resources from being added.</p></li>
  </ol>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/availableProjects"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
