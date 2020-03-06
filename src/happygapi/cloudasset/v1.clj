(ns happygapi.cloudasset.v1
  "Cloud Asset API: v1.
  The cloud asset API manages the history and inventory of cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/exportAssets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:readTime string,
   :contentType string,
   :outputConfig {:bigqueryDestination BigQueryDestination,
                  :gcsDestination GcsDestination},
   :assetTypes [string]}
  
  Exports assets with time and resource types to a given Cloud Storage
  location. The output format is newline-delimited JSON.
  This API implements the google.longrunning.Operation API allowing you
  to keep track of the export."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:exportAssets"
     #{:parent}
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

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/batchGetAssetsHistory
  
  Required parameters: parent
  
  Optional parameters: contentType, readTimeWindow.endTime, readTimeWindow.startTime, assetNames
  Batch gets the update history of assets that overlap a time window.
  For RESOURCE content, this API outputs history with asset in both
  non-delete or deleted status.
  For IAM_POLICY content, this API outputs history when the asset and its
  attached IAM POLICY both exist. This can create gaps in the output history.
  If a specified asset does not exist, this API returns an INVALID_ARGUMENT
  error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:batchGetAssetsHistory"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
