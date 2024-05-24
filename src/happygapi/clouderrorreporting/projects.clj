(ns happygapi.clouderrorreporting.projects
  "Error Reporting API: projects.
  Groups and counts similar errors from cloud services and applications, reports new errors, and provides access to error groups and their associated errors. 
  See: https://cloud.google.com/error-reporting/docs/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deleteEvents$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/deleteEvents
  
  Required parameters: projectName
  
  Optional parameters: none
  
  Deletes all error events of a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{:projectName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-get$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groups/get
  
  Required parameters: groupName
  
  Optional parameters: none
  
  Get the specified group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:groupName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+groupName}"
     #{:groupName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-update$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groups/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :groupId string,
   :trackingIssues [{:url string}],
   :resolutionStatus string}
  
  Replace the data for the specified group. Fails if the group does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+name}"
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

(defn groupStats-list$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groupStats/list
  
  Required parameters: projectName
  
  Optional parameters: groupId, serviceFilter.resourceType, alignment, pageToken, alignmentTime, pageSize, serviceFilter.version, timeRange.period, order, timedCountDuration, serviceFilter.service
  
  Lists the specified groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/groupStats"
     #{:projectName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn events-list$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/events/list
  
  Required parameters: projectName
  
  Optional parameters: groupId, serviceFilter.service, serviceFilter.version, serviceFilter.resourceType, timeRange.period, pageSize, pageToken
  
  Lists the specified events."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{:projectName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn events-report$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/events/report
  
  Required parameters: projectName
  
  Optional parameters: none
  
  Body: 
  
  {:eventTime string,
   :serviceContext {:service string,
                    :version string,
                    :resourceType string},
   :message string,
   :context {:httpRequest HttpRequestContext,
             :user string,
             :reportLocation SourceLocation,
             :sourceReferences [SourceReference]}}
  
  Report an individual error event and record the event to a log. This endpoint accepts **either** an OAuth token, **or** an [API key](https://support.google.com/cloud/answer/6158862) for authentication. To use an API key, append it to the URL as the value of a `key` parameter. For example: `POST https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456` **Note:** [Error Reporting] (https://cloud.google.com/error-reporting) is a global service built on Cloud Logging and can analyze log entries when all of the following are true: * The log entries are stored in a log bucket in the `global` location. * Customer-managed encryption keys (CMEK) are disabled on the log bucket. * The log bucket satisfies one of the following: * The log bucket is stored in the same project where the logs originated. * The logs were routed to a project, and then that project stored those logs in a log bucket that it owns."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events:report"
     #{:projectName}
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
