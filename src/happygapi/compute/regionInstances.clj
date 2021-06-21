(ns happygapi.compute.regionInstances
  "Compute Engine API: regionInstances.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionInstances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn bulkInsert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstances/bulkInsert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:sourceInstanceTemplate string,
   :locationPolicy {:locations {}},
   :instanceProperties {:description string,
                        :tags Tags,
                        :labels {},
                        :shieldedInstanceConfig ShieldedInstanceConfig,
                        :scheduling Scheduling,
                        :resourcePolicies [string],
                        :privateIpv6GoogleAccess string,
                        :canIpForward boolean,
                        :guestAccelerators [AcceleratorConfig],
                        :machineType string,
                        :confidentialInstanceConfig ConfidentialInstanceConfig,
                        :advancedMachineFeatures AdvancedMachineFeatures,
                        :disks [AttachedDisk],
                        :reservationAffinity ReservationAffinity,
                        :networkInterfaces [NetworkInterface],
                        :metadata Metadata,
                        :serviceAccounts [ServiceAccount],
                        :minCpuPlatform string},
   :namePattern string,
   :count string,
   :perInstanceProperties {},
   :minCount string}
  
  Creates multiple instances in a given region. Count specifies the number of instances to create."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instances/bulkInsert"
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
