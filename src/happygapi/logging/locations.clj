(ns happygapi.logging.locations
  "Cloud Logging API: locations.
  Writes log entries and manages your Cloud Logging configuration. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the documentation at https://cloud.google.com/logging/docs.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn buckets-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists buckets (Beta)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/buckets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a bucket (Beta)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :retentionDays integer,
   :name string,
   :lifecycleState string,
   :description string,
   :createTime string}
  
  Updates a bucket. This method replaces the following fields in the existing bucket with values from the new bucket: retention_periodIf the retention period is decreased and the bucket is locked, FAILED_PRECONDITION will be returned.If the bucket has a LifecycleState of DELETE_REQUESTED, FAILED_PRECONDITION will be returned.A buckets region may not be modified after it is created. This method is in Beta."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
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
