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
  
  {:destinationZone string, :targetDisk string}
  
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
  
  {:reportNamePrefix string, :bucketName string}
  
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
  
  Returns the specified Project resource."
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

(defn getXpnResources$
  "https://cloud.google.com/compute/api/reference/rest/v1/projects/getXpnResources
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, pageToken, orderBy, maxResults, filter
  
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
  
  {:items [{:key string, :value string}],
   :kind string,
   :fingerprint string}
  
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
  
  Moves an instance and its attached persistent disks from one zone to another."
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
  
  {:xpnResource {:id string, :type string}}
  
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
  
  {:xpnResource {:id string, :type string}}
  
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
  
  Optional parameters: maxResults, pageToken, returnPartialSuccess, orderBy, filter
  
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
