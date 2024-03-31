(ns happygapi.compute.projects
  "Compute Engine API: projects.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn moveDisk$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/moveDisk
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:targetDisk string, :destinationZone string}
  
  Moves a persistent disk from one zone to another."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/moveDisk"
     #{:project}
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

(defn setDefaultNetworkTier$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/setDefaultNetworkTier
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkTier string}
  
  Sets the default network tier of the project. The default network tier is used when an address/forwardingRule/instance is created without specifying the network tier field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/setDefaultNetworkTier"
     #{:project}
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

(defn setUsageExportBucket$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/setUsageExportBucket
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:bucketName string, :reportNamePrefix string}
  
  Enables the usage export feature and sets the usage export bucket where reports are stored. If you provide an empty request body using this method, the usage export feature will be disabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/setUsageExportBucket"
     #{:project}
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

(defn disableXpnHost$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/disableXpnHost
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Disable this project as a shared VPC host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/disableXpnHost"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/get
  
  Required parameters: project
  
  Optional parameters: none
  
  Returns the specified Project resource. To decrease latency for this method, you can optionally omit any unneeded information from the response by using a field mask. This practice is especially recommended for unused quota information (the `quotas` field). To exclude one or more fields, set your request's `fields` query parameter to only include the fields you need. For example, to only include the `id` and `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setCloudArmorTier$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/setCloudArmorTier
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:cloudArmorTier string}
  
  Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/setCloudArmorTier"
     #{:project}
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

(defn getXpnResources$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/getXpnResources
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Gets service resources (a.k.a service project) associated with this host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/getXpnResources"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setCommonInstanceMetadata$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/setCommonInstanceMetadata
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:kind string,
   :fingerprint string,
   :items [{:key string, :value string}]}
  
  Sets metadata common to all instances within the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/setCommonInstanceMetadata"
     #{:project}
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

(defn moveInstance$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/moveInstance
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:targetInstance string, :destinationZone string}
  
  Moves an instance and its attached persistent disks from one zone to another. *Note*: Moving VMs or disks by using this method might cause unexpected behavior. For more information, see the [known issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior). [Deprecated] This method is deprecated. See [moving instance across zones](/compute/docs/instances/moving-instance-across-zones) instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/moveInstance"
     #{:project}
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

(defn getXpnHost$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/getXpnHost
  
  Required parameters: project
  
  Optional parameters: none
  
  Gets the shared VPC host project that this project links to. May be empty if no link exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/getXpnHost"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn disableXpnResource$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/disableXpnResource
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:xpnResource {:type string, :id string}}
  
  Disable a service resource (also known as service project) associated with this host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/disableXpnResource"
     #{:project}
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

(defn enableXpnHost$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/enableXpnHost
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Enable this project as a shared VPC host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/enableXpnHost"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn enableXpnResource$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/enableXpnResource
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:xpnResource {:type string, :id string}}
  
  Enable service resource (a.k.a service project) for a host project, so that subnets in the host project can be used by instances in the service project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/enableXpnResource"
     #{:project}
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

(defn listXpnHosts$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/listXpnHosts
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Body: 
  
  {:organization string}
  
  Lists all shared VPC host projects visible to the user in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/listXpnHosts"
     #{:project}
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
