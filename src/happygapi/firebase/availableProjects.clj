(ns happygapi.firebase.availableProjects
  "Firebase Management API: availableProjects.
  The Firebase Management API enables programmatic setup and management of Firebase projects, including a project's Firebase resources and Firebase apps.
  See: https://firebase.google.comapi/reference/rest/v1beta1/availableProjects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://firebase.google.comapi/reference/rest/v1beta1/availableProjects/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists each [Google Cloud Platform (GCP) `Project`] (https://cloud.google.com/resource-manager/reference/rest/v1/projects) that can have Firebase resources added to it. A Project will only be listed if: - The caller has sufficient [Google IAM](https://cloud.google.com/iam) permissions to call AddFirebase. - The Project is not already a FirebaseProject. - The Project is not in an Organization which has policies that prevent Firebase resources from being added. "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebase.googleapis.com/"
     "v1beta1/availableProjects"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
