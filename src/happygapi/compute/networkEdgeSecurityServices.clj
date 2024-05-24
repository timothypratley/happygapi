(ns happygapi.compute.networkEdgeSecurityServices
  "Compute Engine API: networkEdgeSecurityServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/networkEdgeSecurityServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEdgeSecurityServices/get
  
  Required parameters: networkEdgeSecurityService, project, region
  
  Optional parameters: none
  
  Gets a specified NetworkEdgeSecurityService."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:networkEdgeSecurityService :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}"
     #{:networkEdgeSecurityService :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEdgeSecurityServices/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId, validateOnly
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :region string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string,
   :securityPolicy string}
  
  Creates a new service in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEdgeSecurityServices"
     #{:region :project}
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEdgeSecurityServices/delete
  
  Required parameters: networkEdgeSecurityService, project, region
  
  Optional parameters: requestId
  
  Deletes the specified service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:networkEdgeSecurityService :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}"
     #{:networkEdgeSecurityService :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEdgeSecurityServices/patch
  
  Required parameters: networkEdgeSecurityService, project, region
  
  Optional parameters: paths, requestId, updateMask
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :region string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string,
   :securityPolicy string}
  
  Patches the specified policy with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:networkEdgeSecurityService :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEdgeSecurityServices/{networkEdgeSecurityService}"
     #{:networkEdgeSecurityService :region :project}
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEdgeSecurityServices/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of all NetworkEdgeSecurityService resources available to the specified project. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/networkEdgeSecurityServices"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
