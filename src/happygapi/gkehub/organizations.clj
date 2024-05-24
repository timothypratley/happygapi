(ns happygapi.gkehub.organizations
  "GKE Hub API: organizations.
  
  See: https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterdocs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-fleets-list$
  "https://cloud.google.com/anthos/multicluster-management/connect/registering-a-clusterapi/reference/rest/v1/organizations/locations/fleets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns all fleets within an organization or a project that the caller has access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkehub.googleapis.com/"
     "v1/{+parent}/fleets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
