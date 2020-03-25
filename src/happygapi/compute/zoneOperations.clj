(ns happygapi.compute.zoneOperations
  "Compute Engine API: zoneOperations.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/zoneOperations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/zoneOperations/delete
  
  Required parameters: operation, project, zone
  
  Optional parameters: none
  
  Deletes the specified zone-specific Operations resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :operation :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/operations/{operation}"
     #{:zone :operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/zoneOperations/get
  
  Required parameters: operation, project, zone
  
  Optional parameters: none
  
  Retrieves the specified zone-specific Operations resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :operation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/operations/{operation}"
     #{:zone :operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/zoneOperations/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of Operation resources contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/operations"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn wait$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/zoneOperations/wait
  
  Required parameters: operation, project, zone
  
  Optional parameters: none
  
  Waits for the specified Operation resource to return as DONE or for the request to approach the 2 minute deadline, and retrieves the specified Operation resource. This method differs from the GET method in that it waits for no more than the default deadline (2 minutes) and then returns the current state of the operation, which might be DONE or still in progress.
  
  This method is called on a best-effort basis. Specifically:  
  - In uncommon cases, when the server is overloaded, the request might return before the default deadline is reached, or might return after zero seconds. 
  - If the default deadline is reached, there is no guarantee that the operation is actually done when the method returns. Be prepared to retry if the operation is not DONE."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :operation :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/operations/{operation}/wait"
     #{:zone :operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
