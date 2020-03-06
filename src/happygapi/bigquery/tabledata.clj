(ns happygapi.bigquery.tabledata
  "BigQuery API: tabledata.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insertAll$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata/insertAll
  
  Required parameters: tableId, projectId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:ignoreUnknownValues boolean,
   :skipInvalidRows boolean,
   :rows [{:insertId string, :json {}}],
   :kind string,
   :templateSuffix string}
  
  Streams data into BigQuery one record at a time without needing to run a load job. Requires the WRITER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.insertdata"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/insertAll"
     #{:tableId :datasetId :projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tabledata/list
  
  Required parameters: datasetId, projectId, tableId
  
  Optional parameters: maxResults, selectedFields, startIndex, pageToken
  Retrieves table data from a specified set of rows. Requires the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}/data"
     #{:tableId :datasetId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
