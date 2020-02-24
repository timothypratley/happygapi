(ns happygapi.storagetransfer.transferJobs
  "Storage Transfer API
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets.
  See: https://cloud.google.com/storage-transfer/docs"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: none
  
  Creates a transfer job that runs periodically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
     #{}
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

(defn patch$
  "Required parameters: jobName
  
  Updates a transfer job. Updating a job's transfer spec does not affect
  transfer operations that are running already. Updating a job's schedule
  is not allowed.
  
  **Note:** The job's status field can be modified
  using this RPC (for example, to set a job's status to
  DELETED,
  DISABLED, or
  ENABLED)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"jobName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{"jobName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: jobName
  
  Gets a transfer job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"jobName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{"jobName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Lists transfer jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
