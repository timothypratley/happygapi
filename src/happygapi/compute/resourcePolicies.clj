(ns happygapi.compute.resourcePolicies
  "Compute Engine API: resourcePolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/setIamPolicy
  
  Required parameters: resource, project, region
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:rules [Rule],
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :etag string},
   :etag string,
   :bindings [{:condition Expr,
               :members [string],
               :bindingId string,
               :role string}]}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies/{resource}/setIamPolicy"
     #{:region :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/getIamPolicy
  
  Required parameters: resource, region, project
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies/{resource}/getIamPolicy"
     #{:region :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/list
  
  Required parameters: project, region
  
  Optional parameters: maxResults, filter, returnPartialSuccess, pageToken, orderBy
  
  A list all the resource policies that have been configured for the specified project in specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/delete
  
  Required parameters: resourcePolicy, project, region
  
  Optional parameters: requestId
  
  Deletes the specified resource policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:resourcePolicy :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies/{resourcePolicy}"
     #{:resourcePolicy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/aggregatedList
  
  Required parameters: project
  
  Optional parameters: includeAllScopes, filter, pageToken, orderBy, returnPartialSuccess, maxResults
  
  Retrieves an aggregated list of resource policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/resourcePolicies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/testIamPermissions
  
  Required parameters: resource, region, project
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies/{resource}/testIamPermissions"
     #{:region :project :resource}
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/get
  
  Required parameters: resourcePolicy, project, region
  
  Optional parameters: none
  
  Retrieves all information of the specified resource policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:resourcePolicy :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies/{resourcePolicy}"
     #{:resourcePolicy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/resourcePolicies/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :resourceStatus {:instanceSchedulePolicy ResourcePolicyResourceStatusInstanceSchedulePolicyStatus},
   :name string,
   :selfLink string,
   :region string,
   :instanceSchedulePolicy {:vmStartSchedule ResourcePolicyInstanceSchedulePolicySchedule,
                            :vmStopSchedule ResourcePolicyInstanceSchedulePolicySchedule,
                            :timeZone string,
                            :expirationTime string,
                            :startTime string},
   :status string,
   :id string,
   :kind string,
   :groupPlacementPolicy {:vmCount integer,
                          :collocation string,
                          :availabilityDomainCount integer},
   :snapshotSchedulePolicy {:snapshotProperties ResourcePolicySnapshotSchedulePolicySnapshotProperties,
                            :schedule ResourcePolicySnapshotSchedulePolicySchedule,
                            :retentionPolicy ResourcePolicySnapshotSchedulePolicyRetentionPolicy}}
  
  Creates a new resource policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/resourcePolicies"
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
