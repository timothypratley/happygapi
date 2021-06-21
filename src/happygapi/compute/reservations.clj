(ns happygapi.compute.reservations
  "Compute Engine API: reservations.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/reservations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/get
  
  Required parameters: project, reservation, zone
  
  Optional parameters: none
  
  Retrieves information about the specified reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :reservation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{reservation}"
     #{:zone :reservation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/setIamPolicy
  
  Required parameters: resource, project, zone
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :policy {:rules [Rule],
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :etag string},
   :bindings [{:condition Expr,
               :members [string],
               :bindingId string,
               :role string}]}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{resource}/setIamPolicy"
     #{:zone :project :resource}
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/insert
  
  Required parameters: zone, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :specificReservationRequired boolean,
   :commitment string,
   :selfLink string,
   :satisfiesPzs boolean,
   :specificReservation {:count string,
                         :instanceProperties AllocationSpecificSKUAllocationReservedInstanceProperties,
                         :inUseCount string},
   :status string,
   :id string,
   :kind string}
  
  Creates a new reservation. For more information, read Reserving zonal resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations"
     #{:zone :project}
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/testIamPermissions
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{resource}/testIamPermissions"
     #{:zone :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/aggregatedList
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, includeAllScopes, pageToken, maxResults, orderBy, filter
  
  Retrieves an aggregated list of reservations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/reservations"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/delete
  
  Required parameters: project, zone, reservation
  
  Optional parameters: requestId
  
  Deletes the specified reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :reservation :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{reservation}"
     #{:zone :reservation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/resize
  
  Required parameters: zone, project, reservation
  
  Optional parameters: requestId
  
  Body: 
  
  {:specificSkuCount string}
  
  Resizes the reservation (applicable to standalone reservations only). For more information, read Modifying reservations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :reservation :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{reservation}/resize"
     #{:zone :reservation :project}
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

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/getIamPolicy
  
  Required parameters: zone, project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations/{resource}/getIamPolicy"
     #{:zone :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/reservations/list
  
  Required parameters: zone, project
  
  Optional parameters: orderBy, returnPartialSuccess, maxResults, pageToken, filter
  
  A list of all the reservations that have been configured for the specified project in specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/reservations"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
