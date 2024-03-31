(ns happygapi.bigtableadmin.projects
  "Cloud Bigtable Admin API: projects.
  Administer your Cloud Bigtable tables and instances.
  See: https://cloud.google.com/bigtable/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn instances-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-setIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on an instance resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{:resource}
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

(defn instances-testIamPermissions$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified instance resource."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{:resource}
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

(defn instances-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parent string,
   :instanceId string,
   :instance {:name string,
              :displayName string,
              :state string,
              :type string,
              :labels {},
              :createTime string,
              :satisfiesPzs boolean},
   :clusters {}}
  
  Create an instance within a project. Note that exactly one of Cluster.serve_nodes and Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is enabled."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/instances"
     #{:parent}
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

(defn instances-update$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :state string,
   :type string,
   :labels {},
   :createTime string,
   :satisfiesPzs boolean}
  
  Updates an instance within a project. This method updates only the display name and type for an Instance. To update other Instance properties, such as labels, use PartialUpdateInstance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an instance from a project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-getIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for an instance resource. Returns an empty policy if an instance exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
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

(defn instances-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists information about instances in a project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-partialUpdateInstance$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/partialUpdateInstance
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :state string,
   :type string,
   :labels {},
   :createTime string,
   :satisfiesPzs boolean}
  
  Partially updates an instance within a project. This method can modify all fields of an Instance and is the preferred way to update an Instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-clusters-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/create
  
  Required parameters: parent
  
  Optional parameters: clusterId
  
  Body: 
  
  {:name string,
   :location string,
   :state string,
   :serveNodes integer,
   :clusterConfig {:clusterAutoscalingConfig ClusterAutoscalingConfig},
   :defaultStorageType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Creates a cluster within an instance. Note that exactly one of Cluster.serve_nodes and Cluster.cluster_config.cluster_autoscaling_config can be set. If serve_nodes is set to non-zero, then the cluster is manually scaled. If cluster_config.cluster_autoscaling_config is non-empty, then autoscaling is enabled."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/clusters"
     #{:parent}
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

(defn instances-clusters-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a cluster."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/list
  
  Required parameters: parent
  
  Optional parameters: pageToken
  
  Lists information about clusters in an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/clusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-update$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :location string,
   :state string,
   :serveNodes integer,
   :clusterConfig {:clusterAutoscalingConfig ClusterAutoscalingConfig},
   :defaultStorageType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Updates a cluster within an instance. Note that UpdateCluster does not support updating cluster_config.cluster_autoscaling_config. In order to update it, you must use PartialUpdateCluster."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-clusters-partialUpdateCluster$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/partialUpdateCluster
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :location string,
   :state string,
   :serveNodes integer,
   :clusterConfig {:clusterAutoscalingConfig ClusterAutoscalingConfig},
   :defaultStorageType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Partially updates a cluster within a project. This method is the preferred way to update a Cluster. To enable and update autoscaling, set cluster_config.cluster_autoscaling_config. When autoscaling is enabled, serve_nodes is treated as an OUTPUT_ONLY field, meaning that updates to it are ignored. Note that an update cannot simultaneously set serve_nodes to non-zero and cluster_config.cluster_autoscaling_config to non-empty, and also specify both in the update_mask. To disable autoscaling, clear cluster_config.cluster_autoscaling_config, and explicitly set a serve_node count via the update_mask."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-clusters-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a cluster from an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-hotTablets-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/hotTablets/list
  
  Required parameters: parent
  
  Optional parameters: startTime, endTime, pageSize, pageToken
  
  Lists hot tablets in a cluster, within the time range provided. Hot tablets are ordered based on CPU usage."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/hotTablets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-backups-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metadata on a pending or completed Cloud Bigtable Backup."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-backups-copy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/copy
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:backupId string, :sourceBackup string, :expireTime string}
  
  Copy a Cloud Bigtable backup to a new backup in the destination cluster located in the destination instance and project."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/backups:copy"
     #{:parent}
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

(defn instances-clusters-backups-setIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on a Table or Backup resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{:resource}
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

(defn instances-clusters-backups-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:sourceBackup string,
   :encryptionInfo {:encryptionType string,
                    :encryptionStatus Status,
                    :kmsKeyVersion string},
   :startTime string,
   :name string,
   :sizeBytes string,
   :endTime string,
   :state string,
   :sourceTable string,
   :expireTime string}
  
  Updates a pending or completed Cloud Bigtable Backup."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-clusters-backups-testIamPermissions$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified Table or Backup resource."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{:resource}
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

(defn instances-clusters-backups-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId
  
  Body: 
  
  {:sourceBackup string,
   :encryptionInfo {:encryptionType string,
                    :encryptionStatus Status,
                    :kmsKeyVersion string},
   :startTime string,
   :name string,
   :sizeBytes string,
   :endTime string,
   :state string,
   :sourceTable string,
   :expireTime string}
  
  Starts creating a new Cloud Bigtable Backup. The returned backup long-running operation can be used to track creation of the backup. The metadata field type is CreateBackupMetadata. The response field type is Backup, if successful. Cancelling the returned operation will stop the creation and delete the backup."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/backups"
     #{:parent}
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

(defn instances-clusters-backups-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a pending or completed Cloud Bigtable backup."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-clusters-backups-getIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a Table or Backup resource. Returns an empty policy if the resource exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
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

(defn instances-clusters-backups-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists Cloud Bigtable backups. Returns both completed and pending backups."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/backups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/create
  
  Required parameters: parent
  
  Optional parameters: appProfileId, ignoreWarnings
  
  Body: 
  
  {:name string,
   :etag string,
   :description string,
   :multiClusterRoutingUseAny {:clusterIds [string]},
   :singleClusterRouting {:clusterId string,
                          :allowTransactionalWrites boolean},
   :priority string,
   :standardIsolation {:priority string},
   :dataBoostIsolationReadOnly {:computeBillingOwner string}}
  
  Creates an app profile within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/appProfiles"
     #{:parent}
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

(defn instances-appProfiles-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about an app profile."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists information about app profiles in an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/appProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-appProfiles-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, ignoreWarnings
  
  Body: 
  
  {:name string,
   :etag string,
   :description string,
   :multiClusterRoutingUseAny {:clusterIds [string]},
   :singleClusterRouting {:clusterId string,
                          :allowTransactionalWrites boolean},
   :priority string,
   :standardIsolation {:priority string},
   :dataBoostIsolationReadOnly {:computeBillingOwner string}}
  
  Updates an app profile within an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-appProfiles-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/delete
  
  Required parameters: name
  
  Optional parameters: ignoreWarnings
  
  Deletes an app profile from an instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets metadata information about the specified table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-setIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on a Table or Backup resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{:resource}
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

(defn instances-tables-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:restoreInfo {:sourceType string, :backupInfo BackupInfo},
   :columnFamilies {},
   :changeStreamConfig {:retentionPeriod string},
   :name string,
   :clusterStates {},
   :granularity string,
   :automatedBackupPolicy {:retentionPeriod string, :frequency string},
   :deletionProtection boolean,
   :stats {:rowCount string,
           :averageColumnsPerRow number,
           :averageCellsPerColumn number,
           :logicalDataBytes string}}
  
  Updates a specified table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-tables-testIamPermissions$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified Table or Backup resource."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{:resource}
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

(defn instances-tables-generateConsistencyToken$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/generateConsistencyToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a consistency token for a Table, which can be used in CheckConsistency to check whether mutations to the table that finished before this call started have been replicated. The tokens will be available for 90 days."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:generateConsistencyToken"
     #{:name}
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

(defn instances-tables-restore$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/restore
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:tableId string, :backup string}
  
  Create a new table by restoring from a completed backup. The returned table long-running operation can be used to track the progress of the operation, and to cancel it. The metadata field type is RestoreTableMetadata. The response type is Table, if successful."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/tables:restore"
     #{:parent}
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

(defn instances-tables-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:tableId string,
   :table {:restoreInfo RestoreInfo,
           :columnFamilies {},
           :changeStreamConfig ChangeStreamConfig,
           :name string,
           :clusterStates {},
           :granularity string,
           :automatedBackupPolicy AutomatedBackupPolicy,
           :deletionProtection boolean,
           :stats TableStats},
   :initialSplits [{:key string}]}
  
  Creates a new table in the specified instance. The table can be created with a full set of initial column families, specified in the request."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/tables"
     #{:parent}
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

(defn instances-tables-modifyColumnFamilies$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/modifyColumnFamilies
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:modifications [{:id string,
                    :create ColumnFamily,
                    :update ColumnFamily,
                    :drop boolean,
                    :updateMask string}],
   :ignoreWarnings boolean}
  
  Performs a series of column family modifications on the specified table. Either all or none of the modifications will occur before this method returns, but data requests received prior to that point may see a table where only some modifications have taken effect."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:modifyColumnFamilies"
     #{:name}
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

(defn instances-tables-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes a specified table and all of its data."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-getIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a Table or Backup resource. Returns an empty policy if the resource exists but does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
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

(defn instances-tables-undelete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restores a specified table which was accidentally deleted."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:undelete"
     #{:name}
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

(defn instances-tables-dropRowRange$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/dropRowRange
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:rowKeyPrefix string, :deleteAllDataFromTable boolean}
  
  Permanently drop/delete a row range from a specified table. The request can specify whether to delete all rows in a table, or only those that match a particular prefix. Note that row key prefixes used here are treated as service data. For more information about how service data is handled, see the [Google Cloud Privacy Notice](https://cloud.google.com/terms/cloud-privacy-notice)."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:dropRowRange"
     #{:name}
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

(defn instances-tables-checkConsistency$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/checkConsistency
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:consistencyToken string,
   :standardReadRemoteWrites {},
   :dataBoostReadLocalWrites {}}
  
  Checks replication consistency based on a consistency token, that is, if replication has caught up based on the conditions specified in the token and the check request."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:checkConsistency"
     #{:name}
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

(defn instances-tables-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/list
  
  Required parameters: parent
  
  Optional parameters: view, pageSize, pageToken
  
  Lists all tables served from a specified instance."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/tables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-authorizedViews-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/authorizedViews/create
  
  Required parameters: parent
  
  Optional parameters: authorizedViewId
  
  Body: 
  
  {:name string,
   :subsetView {:rowPrefixes [string], :familySubsets {}},
   :etag string,
   :deletionProtection boolean}
  
  Creates a new AuthorizedView in a table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/authorizedViews"
     #{:parent}
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

(defn instances-tables-authorizedViews-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/authorizedViews/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists all AuthorizedViews from a specific table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+parent}/authorizedViews"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-authorizedViews-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/authorizedViews/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets information from a specified AuthorizedView."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-tables-authorizedViews-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/authorizedViews/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, ignoreWarnings
  
  Body: 
  
  {:name string,
   :subsetView {:rowPrefixes [string], :familySubsets {}},
   :etag string,
   :deletionProtection boolean}
  
  Updates an AuthorizedView in a table."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn instances-tables-authorizedViews-delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/authorizedViews/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Permanently deletes a specified AuthorizedView."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.table"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
