(ns happygapi.bigquery.tabledata
  "BigQuery API
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: tableId,datasetId,projectId
  
  Retrieves table data from a specified set of rows. Requires the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tableId" "datasetId" "projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/data"
     #{"tableId" "datasetId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insertAll$
  "Required parameters: tableId,projectId,datasetId
  
  Streams data into BigQuery one record at a time without needing to run a load job. Requires the WRITER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.insertdata"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"tableId" "datasetId" "projectId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/insertAll"
     #{"tableId" "datasetId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
