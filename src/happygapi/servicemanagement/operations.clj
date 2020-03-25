(ns happygapi.servicemanagement.operations
  "Service Management API: operations.
  Google Service Management allows service producers to publish their services on Google Cloud Platform so that they can be discovered and used by service consumers.
  See: https://cloud.google.com/service-management/api/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/service-management/api/reference/rest/v1/operations/list
  
  Required parameters: none
  
  Optional parameters: name, pageToken, pageSize, filter
  
  Lists service operations that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/operations"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/service-management/api/reference/rest/v1/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicemanagement.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
