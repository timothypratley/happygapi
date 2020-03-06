(ns happygapi.clouderrorreporting.projects
  "Error Reporting API: projects.
  Groups and counts similar errors from cloud services and applications, reports new errors, and provides access to error groups and their associated errors.
  
  See: https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deleteEvents$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/deleteEvents
  
  Required parameters: projectName
  
  Optional parameters: none
  Deletes all error events of a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{:projectName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn groups-get$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groups/get
  
  Required parameters: groupName
  
  Optional parameters: none
  Get the specified group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:groupName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+groupName}"
     #{:groupName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn groups-update$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groups/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :groupId string, :trackingIssues [{:url string}]}
  
  Replace the data for the specified group.
  Fails if the group does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn groupStats-list$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/groupStats/list
  
  Required parameters: projectName
  
  Optional parameters: groupId, serviceFilter.resourceType, alignment, pageToken, alignmentTime, pageSize, serviceFilter.version, timeRange.period, order, timedCountDuration, serviceFilter.service
  Lists the specified groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/groupStats"
     #{:projectName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn events-list$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/events/list
  
  Required parameters: projectName
  
  Optional parameters: serviceFilter.resourceType, timeRange.period, groupId, pageToken, serviceFilter.service, pageSize, serviceFilter.version
  Lists the specified events."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{:projectName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn events-report$
  "https://cloud.google.com/error-reporting/api/reference/rest/v1beta1/projects/events/report
  
  Required parameters: projectName
  
  Optional parameters: none
  
  Body: 
  
  {:message string,
   :serviceContext {:service string,
                    :resourceType string,
                    :version string},
   :eventTime string,
   :context {:reportLocation SourceLocation,
             :sourceReferences [SourceReference],
             :httpRequest HttpRequestContext,
             :user string}}
  
  Report an individual error event.
  
  This endpoint accepts **either** an OAuth token,
  **or** an [API key](https://support.google.com/cloud/answer/6158862)
  for authentication. To use an API key, append it to the URL as the value of
  a `key` parameter. For example:
  
  `POST
  https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events:report"
     #{:projectName}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
