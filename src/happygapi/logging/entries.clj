(ns happygapi.logging.entries
  "Cloud Logging API: entries.
  Writes log entries and manages your Cloud Logging configuration. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the documentation at https://cloud.google.com/logging/docs.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/entries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:projectIds [string],
   :filter string,
   :pageToken string,
   :pageSize integer,
   :orderBy string,
   :resourceNames [string]}
  
  Lists log entries. Use this method to retrieve log entries that originated from a project/folder/organization/billing account. For ways to export log entries, see Exporting Logs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:list"
     #{}
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

(defn write$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/entries/write
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:logName string,
   :entries [{:traceSampled boolean,
              :jsonPayload {},
              :labels {},
              :spanId string,
              :receiveTimestamp string,
              :trace string,
              :operation LogEntryOperation,
              :logName string,
              :textPayload string,
              :sourceLocation LogEntrySourceLocation,
              :resource MonitoredResource,
              :severity string,
              :insertId string,
              :httpRequest HttpRequest,
              :protoPayload {},
              :timestamp string,
              :metadata MonitoredResourceMetadata}],
   :partialSuccess boolean,
   :dryRun boolean,
   :labels {},
   :resource {:labels {}, :type string}}
  
  Writes log entries to Logging. This API method is the only way to send log entries to Logging. This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging libraries configured to use Logging. A single request may contain log entries for a maximum of 1000 different resources (projects, organizations, billing accounts or folders)"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/entries:write"
     #{}
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
