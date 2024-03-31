(ns happygapi.binaryauthorization.systempolicy
  "Binary Authorization API: systempolicy.
  The management interface for Binary Authorization, a service that provides policy-based deployment validation and control for images deployed to Google Kubernetes Engine (GKE), Anthos Service Mesh, Anthos Clusters, and Cloud Run. 
  See: https://cloud.google.com/binary-authorization/api/reference/rest/v1/systempolicy"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/systempolicy/getPolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the current system policy in the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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
