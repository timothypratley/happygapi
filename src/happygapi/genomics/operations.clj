(ns happygapi.genomics.operations
  "Genomics API
  Uploads, processes, queries, and searches Genomics data in the cloud.
  See: https://cloud.google.com/genomics"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "genomics_schema.edn"))))

(defn list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `genomics.operations.list`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/genomics"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://genomics.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.
  Clients can use this method to poll the operation result at intervals as
  recommended by the API service.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `genomics.operations.get`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/genomics"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://genomics.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.
  The server makes a best effort to cancel the operation, but success is not
  guaranteed. Clients may use Operations.GetOperation
  or Operations.ListOperations
  to check whether the cancellation succeeded or the operation completed
  despite cancellation.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `genomics.operations.cancel`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/genomics"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://genomics.googleapis.com/"
     "v1/{+name}:cancel"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
