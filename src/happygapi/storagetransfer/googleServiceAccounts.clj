(ns happygapi.storagetransfer.googleServiceAccounts
  "Storage Transfer API
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets.
  See: https://cloud.google.com/storage-transfer/docs"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "storagetransfer_schema.edn"))))

(defn get$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Returns the Google service account that is used by Storage Transfer
  Service to access buckets in the project where transfers
  run or in other projects. Each Google service account is associated
  with one Google Cloud Platform Console project. Users
  should add this service account to the Google Cloud Storage bucket
  ACLs to grant access to Storage Transfer Service. This service
  account is created and owned by Storage Transfer Service and can
  only be used by Storage Transfer Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/googleServiceAccounts/{projectId}"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
