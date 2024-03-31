(ns happygapi.storagetransfer.googleServiceAccounts
  "Storage Transfer API: googleServiceAccounts.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets. 
  See: https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/googleServiceAccounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/googleServiceAccounts/get
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Returns the Google service account that is used by Storage Transfer Service to access buckets in the project where transfers run or in other projects. Each Google service account is associated with one Google Cloud project. Users should add this service account to the Google Cloud Storage bucket ACLs to grant access to Storage Transfer Service. This service account is created and owned by Storage Transfer Service and can only be used by Storage Transfer Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/googleServiceAccounts/{projectId}"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
