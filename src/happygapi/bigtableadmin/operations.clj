(ns happygapi.bigtableadmin.operations
  "Cloud Bigtable Admin API: operations.
  Administer your Cloud Bigtable tables and instances.
  See: https://cloud.google.com/bigtable/docs/reference/rest/v2/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
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
