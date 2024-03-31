(ns happygapi.datalineage.projects
  "Data Lineage API: projects.
  
  See: https://cloud.google.com/data-catalogapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-processOpenLineageRunEvent$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processOpenLineageRunEvent
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {}
  
  Creates new lineage events together with their parents: process and run. Updates the process and run if they already exist. Mapped from Open Lineage specification: https://github.com/OpenLineage/OpenLineage/blob/main/spec/OpenLineage.json."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}:processOpenLineageRunEvent"
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

(defn locations-batchSearchLinkProcesses$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/batchSearchLinkProcesses
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :links [string], :pageSize integer}
  
  Retrieve information about LineageProcesses associated with specific links. LineageProcesses are transformation pipelines that result in data flowing from **source** to **target** assets. Links between assets represent this operation. If you have specific link names, you can use this method to verify which LineageProcesses contribute to creating those links. See the SearchLinks method for more information on how to retrieve link name. You can retrieve the LineageProcess information in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}:batchSearchLinkProcesses"
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

(defn locations-searchLinks$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/searchLinks
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string,
   :pageSize integer,
   :source {:fullyQualifiedName string},
   :target {:fullyQualifiedName string}}
  
  Retrieve a list of links connected to a specific asset. Links represent the data flow between **source** (upstream) and **target** (downstream) assets in transformation pipelines. Links are stored in the same project as the Lineage Events that create them. You can retrieve links in every project where you have the `datalineage.events.get` permission. The project provided in the URL is used for Billing and Quota."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}:searchLinks"
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

(defn locations-operations-list$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-operations-get$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-delete$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Deletes the process with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-list$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List processes in the given project and location. List order is descending by insertion time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/processes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-patch$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/patch
  
  Required parameters: name
  
  Optional parameters: allowMissing, updateMask
  
  Body: 
  
  {:attributes {},
   :displayName string,
   :origin {:sourceType string, :name string},
   :name string}
  
  Updates a process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
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

(defn locations-processes-create$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/create
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {:attributes {},
   :displayName string,
   :origin {:sourceType string, :name string},
   :name string}
  
  Creates a new process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/processes"
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

(defn locations-processes-get$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of the specified process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-list$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists runs in the given project and location. List order is descending by `start_time`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/runs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-delete$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Deletes the run with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-get$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of the specified run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-patch$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:attributes {},
   :endTime string,
   :state string,
   :name string,
   :startTime string,
   :displayName string}
  
  Updates a run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
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

(defn locations-processes-runs-create$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/create
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {:attributes {},
   :endTime string,
   :state string,
   :name string,
   :startTime string,
   :displayName string}
  
  Creates a new run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/runs"
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

(defn locations-processes-runs-lineageEvents-get$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/lineageEvents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a specified lineage event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-lineageEvents-list$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/lineageEvents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists lineage events in the given project and location. The list order is not defined."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/lineageEvents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processes-runs-lineageEvents-create$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/lineageEvents/create
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {:name string,
   :endTime string,
   :startTime string,
   :links [{:source GoogleCloudDatacatalogLineageV1EntityReference,
            :target GoogleCloudDatacatalogLineageV1EntityReference}]}
  
  Creates a new lineage event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+parent}/lineageEvents"
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

(defn locations-processes-runs-lineageEvents-delete$
  "https://cloud.google.com/data-catalogapi/reference/rest/v1/projects/locations/processes/runs/lineageEvents/delete
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Deletes the lineage event with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalineage.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
