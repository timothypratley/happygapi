(ns happygapi.bigqueryreservation.operations
  "BigQuery Reservation API: operations.
  A service to modify your BigQuery flat-rate reservations.
  See: https://cloud.google.com/bigquery/api/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
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

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v1/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryreservation.googleapis.com/"
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
