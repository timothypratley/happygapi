(ns happygapi.compute.nodeGroups
  "Compute Engine API: nodeGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/get
  
  Required parameters: nodeGroup, project, zone
  
  Optional parameters: none
  
  Returns the specified NodeGroup. Get a list of available NodeGroups by making a list() request. Note: the \"nodes\" field should not be used. Use nodeGroups.listNodes instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}"
     #{:zone :nodeGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/setIamPolicy
  
  Required parameters: zone, project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:members [string],
               :condition Expr,
               :bindingId string,
               :role string}],
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :rules [Rule],
            :bindings [Binding]},
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{resource}/setIamPolicy"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/insert
  
  Required parameters: zone, project, initialNodeCount
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :locationHint string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :size integer,
   :nodeTemplate string,
   :maintenancePolicy string,
   :status string,
   :id string,
   :kind string,
   :maintenanceWindow {:maintenanceDuration Duration, :startTime string},
   :autoscalingPolicy {:mode string,
                       :maxNodes integer,
                       :minNodes integer},
   :fingerprint string}
  
  Creates a NodeGroup resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :initialNodeCount :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups"
     #{:zone :initialNodeCount :project}
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/patch
  
  Required parameters: project, zone, nodeGroup
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :locationHint string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :size integer,
   :nodeTemplate string,
   :maintenancePolicy string,
   :status string,
   :id string,
   :kind string,
   :maintenanceWindow {:maintenanceDuration Duration, :startTime string},
   :autoscalingPolicy {:mode string,
                       :maxNodes integer,
                       :minNodes integer},
   :fingerprint string}
  
  Updates the specified node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}"
     #{:zone :nodeGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/testIamPermissions
  
  Required parameters: resource, project, zone
  
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
     "projects/{project}/zones/{zone}/nodeGroups/{resource}/testIamPermissions"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/aggregatedList
  
  Required parameters: project
  
  Optional parameters: orderBy, returnPartialSuccess, pageToken, maxResults, filter, includeAllScopes
  
  Retrieves an aggregated list of node groups. Note: use nodeGroups.listNodes for more details about each group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/nodeGroups"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addNodes$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/addNodes
  
  Required parameters: project, zone, nodeGroup
  
  Optional parameters: requestId
  
  Body: 
  
  {:additionalNodeCount integer}
  
  Adds specified number of nodes to the node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/addNodes"
     #{:zone :nodeGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/delete
  
  Required parameters: nodeGroup, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified NodeGroup resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}"
     #{:zone :nodeGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deleteNodes$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/deleteNodes
  
  Required parameters: zone, nodeGroup, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:nodes [string]}
  
  Deletes specified nodes from the node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/deleteNodes"
     #{:zone :nodeGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/getIamPolicy
  
  Required parameters: project, zone, resource
  
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
     "projects/{project}/zones/{zone}/nodeGroups/{resource}/getIamPolicy"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/list
  
  Required parameters: zone, project
  
  Optional parameters: returnPartialSuccess, maxResults, pageToken, orderBy, filter
  
  Retrieves a list of node groups available to the specified project. Note: use nodeGroups.listNodes for more details about each group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setNodeTemplate$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/setNodeTemplate
  
  Required parameters: nodeGroup, zone, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:nodeTemplate string}
  
  Updates the node template of the node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/setNodeTemplate"
     #{:zone :nodeGroup :project}
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

(defn listNodes$
  "https://cloud.google.com/compute/api/reference/rest/v1/nodeGroups/listNodes
  
  Required parameters: project, zone, nodeGroup
  
  Optional parameters: returnPartialSuccess, orderBy, maxResults, pageToken, filter
  
  Lists nodes in the node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :nodeGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/nodeGroups/{nodeGroup}/listNodes"
     #{:zone :nodeGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
