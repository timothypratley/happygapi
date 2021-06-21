(ns happygapi.bigtableadmin.projects
  "Cloud Bigtable Admin API: projects.
  Administer your Cloud Bigtable tables and instances.
  See: https://cloud.google.com/bigtable/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
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

(defn locations-get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
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
            :etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
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
  
  {:instance {:labels {},
              :displayName string,
              :state string,
              :name string,
              :type string},
   :clusters {},
   :instanceId string,
   :parent string}
  
  Create an instance within a project."
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
  
  {:labels {},
   :displayName string,
   :state string,
   :name string,
   :type string}
  
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
  
  {:labels {},
   :displayName string,
   :state string,
   :name string,
   :type string}
  
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
            :etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on a Table resource. Replaces any existing policy."
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

(defn instances-tables-testIamPermissions$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified table resource."
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
  
  {:backup string, :tableId string}
  
  Create a new table by restoring from a completed backup. The new table must be in the same project as the instance containing the backup. The returned table long-running operation can be used to track the progress of the operation, and to cancel it. The metadata field type is RestoreTableMetadata. The response type is Table, if successful."
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
  
  {:table {:name string,
           :columnFamilies {},
           :granularity string,
           :restoreInfo RestoreInfo,
           :clusterStates {}},
   :tableId string,
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
                    :update ColumnFamily,
                    :create ColumnFamily,
                    :drop boolean}]}
  
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
  
  Gets the access control policy for a Table resource. Returns an empty policy if the resource exists but does not have a policy set."
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

(defn instances-tables-dropRowRange$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/tables/dropRowRange
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:deleteAllDataFromTable boolean, :rowKeyPrefix string}
  
  Permanently drop/delete a row range from a specified table. The request can specify whether to delete all rows in a table, or only those that match a particular prefix."
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
  
  {:consistencyToken string}
  
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
  
  Optional parameters: pageSize, pageToken, view
  
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

(defn instances-clusters-update$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:encryptionConfig {:kmsKeyName string},
   :defaultStorageType string,
   :name string,
   :serveNodes integer,
   :location string,
   :state string}
  
  Updates a cluster within an instance. UpdateCluster is deprecated. Please use PartialUpdateCluster instead."
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

(defn instances-clusters-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/create
  
  Required parameters: parent
  
  Optional parameters: clusterId
  
  Body: 
  
  {:encryptionConfig {:kmsKeyName string},
   :defaultStorageType string,
   :name string,
   :serveNodes integer,
   :location string,
   :state string}
  
  Creates a cluster within an instance."
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

(defn instances-clusters-partialUpdateCluster$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/partialUpdateCluster
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:encryptionConfig {:kmsKeyName string},
   :defaultStorageType string,
   :name string,
   :serveNodes integer,
   :location string,
   :state string}
  
  Partially updates a cluster within a project. This method is the preferred way to update a Cluster. "
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

(defn instances-clusters-backups-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId
  
  Body: 
  
  {:name string,
   :state string,
   :endTime string,
   :sizeBytes string,
   :startTime string,
   :expireTime string,
   :sourceTable string,
   :encryptionInfo {:encryptionType string,
                    :kmsKeyVersion string,
                    :encryptionStatus Status}}
  
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

(defn instances-clusters-backups-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :endTime string,
   :sizeBytes string,
   :startTime string,
   :expireTime string,
   :sourceTable string,
   :encryptionInfo {:encryptionType string,
                    :kmsKeyVersion string,
                    :encryptionStatus Status}}
  
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

(defn instances-clusters-backups-setIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on a Table resource. Replaces any existing policy."
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

(defn instances-clusters-backups-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, pageSize, filter
  
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

(defn instances-clusters-backups-getIamPolicy$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a Table resource. Returns an empty policy if the resource exists but does not have a policy set."
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

(defn instances-clusters-backups-testIamPermissions$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/clusters/backups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified table resource."
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

(defn instances-appProfiles-create$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/create
  
  Required parameters: parent
  
  Optional parameters: appProfileId, ignoreWarnings
  
  Body: 
  
  {:singleClusterRouting {:allowTransactionalWrites boolean,
                          :clusterId string},
   :name string,
   :etag string,
   :description string,
   :multiClusterRoutingUseAny {}}
  
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

(defn instances-appProfiles-patch$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/projects/instances/appProfiles/patch
  
  Required parameters: name
  
  Optional parameters: ignoreWarnings, updateMask
  
  Body: 
  
  {:singleClusterRouting {:allowTransactionalWrites boolean,
                          :clusterId string},
   :name string,
   :etag string,
   :description string,
   :multiClusterRoutingUseAny {}}
  
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
