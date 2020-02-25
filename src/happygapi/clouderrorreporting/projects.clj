(ns happygapi.clouderrorreporting.projects
  "Stackdriver Error Reporting API
  Groups and counts similar errors from cloud services and applications, reports new errors, and provides access to error groups and their associated errors.
  
  See: https://cloud.google.com/error-reporting/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "clouderrorreporting_schema.edn"))))

(defn deleteEvents$
  "Required parameters: projectName
  
  Optional parameters: none
  
  Deletes all error events of a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{"projectName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn events-list$
  "Required parameters: projectName
  
  Optional parameters: serviceFilter.service, pageToken, pageSize, serviceFilter.version, serviceFilter.resourceType, timeRange.period, groupId
  
  Lists the specified events."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events"
     #{"projectName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn events-report$
  "Required parameters: projectName
  
  Optional parameters: none
  
  Report an individual error event.
  
  This endpoint accepts **either** an OAuth token,
  **or** an [API key](https://support.google.com/cloud/answer/6158862)
  for authentication. To use an API key, append it to the URL as the value of
  a `key` parameter. For example:
  
  `POST
  https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/events:report"
     #{"projectName"}
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

(defn groups-get$
  "Required parameters: groupName
  
  Optional parameters: none
  
  Get the specified group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"groupName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+groupName}"
     #{"groupName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn groups-update$
  "Required parameters: name
  
  Optional parameters: none
  
  Replace the data for the specified group.
  Fails if the group does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn groupStats-list$
  "Required parameters: projectName
  
  Optional parameters: groupId, serviceFilter.resourceType, alignment, pageToken, alignmentTime, pageSize, serviceFilter.version, timeRange.period, order, timedCountDuration, serviceFilter.service
  
  Lists the specified groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouderrorreporting.googleapis.com/"
     "v1beta1/{+projectName}/groupStats"
     #{"projectName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
