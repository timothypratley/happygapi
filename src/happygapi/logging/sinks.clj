(ns happygapi.logging.sinks
  "Cloud Logging API: sinks.
  Writes log entries and manages your Cloud Logging configuration.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists sinks."
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
     "v2/{+parent}/sinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks/get
  
  Required parameters: sinkName
  
  Optional parameters: none
  
  Gets a sink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks/create
  
  Required parameters: parent
  
  Optional parameters: uniqueWriterIdentity, customWriterIdentity
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usePartitionedTables boolean,
                     :usesTimestampColumnPartitioning boolean},
   :includeChildren boolean,
   :disabled boolean,
   :interceptChildren boolean,
   :name string,
   :createTime string,
   :exclusions [{:name string,
                 :description string,
                 :filter string,
                 :disabled boolean,
                 :createTime string,
                 :updateTime string}],
   :updateTime string,
   :resourceName string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Creates a sink that exports specified log entries to a destination. The export begins upon ingress, unless the sink's writer_identity is not permitted to write to the destination. A sink can export log entries only from the resource owning the sink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/sinks"
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

(defn update$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks/update
  
  Required parameters: sinkName
  
  Optional parameters: uniqueWriterIdentity, customWriterIdentity, updateMask
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usePartitionedTables boolean,
                     :usesTimestampColumnPartitioning boolean},
   :includeChildren boolean,
   :disabled boolean,
   :interceptChildren boolean,
   :name string,
   :createTime string,
   :exclusions [{:name string,
                 :description string,
                 :filter string,
                 :disabled boolean,
                 :createTime string,
                 :updateTime string}],
   :updateTime string,
   :resourceName string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Updates a sink. This method replaces the values of the destination and filter fields of the existing sink with the corresponding values from the new sink.The updated sink might also have a new writer_identity; see the unique_writer_identity field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
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

(defn delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/sinks/delete
  
  Required parameters: sinkName
  
  Optional parameters: none
  
  Deletes a sink. If the sink has a unique writer_identity, then that service account is also deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
