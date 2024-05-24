(ns happygapi.compute.regionInstanceTemplates
  "Compute Engine API: regionInstanceTemplates.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionInstanceTemplates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceTemplates/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of instance templates that are contained within the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceTemplates"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceTemplates/get
  
  Required parameters: instanceTemplate, project, region
  
  Optional parameters: none
  
  Returns the specified instance template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :instanceTemplate})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceTemplates/{instanceTemplate}"
     #{:region :project :instanceTemplate}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceTemplates/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :properties {:description string,
                :tags Tags,
                :labels {},
                :shieldedInstanceConfig ShieldedInstanceConfig,
                :scheduling Scheduling,
                :resourcePolicies [string],
                :privateIpv6GoogleAccess string,
                :canIpForward boolean,
                :resourceManagerTags {},
                :guestAccelerators [AcceleratorConfig],
                :networkPerformanceConfig NetworkPerformanceConfig,
                :machineType string,
                :confidentialInstanceConfig ConfidentialInstanceConfig,
                :keyRevocationActionType string,
                :advancedMachineFeatures AdvancedMachineFeatures,
                :disks [AttachedDisk],
                :reservationAffinity ReservationAffinity,
                :networkInterfaces [NetworkInterface],
                :metadata Metadata,
                :serviceAccounts [ServiceAccount],
                :minCpuPlatform string},
   :sourceInstance string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :region string,
   :id string,
   :sourceInstanceParams {:diskConfigs [DiskInstantiationConfig]},
   :kind string}
  
  Creates an instance template in the specified project and region using the global instance template whose URL is included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceTemplates"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceTemplates/delete
  
  Required parameters: instanceTemplate, project, region
  
  Optional parameters: requestId
  
  Deletes the specified instance template. Deleting an instance template is permanent and cannot be undone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :instanceTemplate})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceTemplates/{instanceTemplate}"
     #{:region :project :instanceTemplate}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
