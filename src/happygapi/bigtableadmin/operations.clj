(ns happygapi.bigtableadmin.operations
  "Cloud Bigtable Admin API: operations.
  Administer your Cloud Bigtable tables and instances.
  See: https://cloud.google.com/bigtable/api/reference/rest/v2/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cancel$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/bigtable.admin"
            "https://www.googleapis.com/auth/bigtable.admin.cluster"
            "https://www.googleapis.com/auth/bigtable.admin.instance"
            "https://www.googleapis.com/auth/cloud-bigtable.admin"
            "https://www.googleapis.com/auth/cloud-bigtable.admin.cluster"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigtableadmin.googleapis.com/"
     "v2/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
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

(defn get$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
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

(defn projects-operations-list$
  "https://cloud.google.com/bigtable/api/reference/rest/v2/operations/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
     "v2/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
