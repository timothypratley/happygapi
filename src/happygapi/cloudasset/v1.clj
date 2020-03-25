(ns happygapi.cloudasset.v1
  "Cloud Asset API: v1.
  The cloud asset API manages the history and inventory of cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/batchGetAssetsHistory
  
  Required parameters: parent
  
  Optional parameters: readTimeWindow.endTime, readTimeWindow.startTime, assetNames, contentType
  
  Batch gets the update history of assets that overlap a time window.
  For RESOURCE content, this API outputs history with asset in both
  non-delete or deleted status.
  For IAM_POLICY content, this API outputs history when the asset and its
  attached IAM POLICY both exist. This can create gaps in the output history.
  If a specified asset does not exist, this API returns an INVALID_ARGUMENT
  error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:batchGetAssetsHistory"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/exportAssets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:assetTypes [string],
   :readTime string,
   :contentType string,
   :outputConfig {:gcsDestination GcsDestination,
                  :bigqueryDestination BigQueryDestination}}
  
  Exports assets with time and resource types to a given Cloud Storage
  location. The output format is newline-delimited JSON.
  This API implements the google.longrunning.Operation API allowing you
  to keep track of the export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:exportAssets"
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
