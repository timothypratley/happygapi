(ns happygapi.cloudresourcemanager.effectiveTags
  "Cloud Resource Manager API: effectiveTags.
  Creates, reads, and updates metadata for Google Cloud Platform resource containers.
  See: https://cloud.google.com/resource-managerapi/reference/rest/v3/effectiveTags"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/effectiveTags/list
  
  Required parameters: none
  
  Optional parameters: parent, pageSize, pageToken
  
  Return a list of effective tags for the given Google Cloud resource, as specified in `parent`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/effectiveTags"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
