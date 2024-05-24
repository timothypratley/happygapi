(ns happygapi.alertcenter.alerts
  "Google Workspace Alert Center API: alerts.
  Manages alerts on issues affecting your domain. Note: The current version of this API (v1beta1) is available to all Google Workspace customers. 
  See: https://developers.google.com/admin-sdk/alertcenter/docs/reference/rest/v1beta1/alerts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/list
  
  Required parameters: none
  
  Optional parameters: customerId, pageSize, pageToken, filter, orderBy
  
  Lists the alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts"
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
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/get
  
  Required parameters: alertId
  
  Optional parameters: customerId
  
  Gets the specified alert. Attempting to get a nonexistent alert returns `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}"
     #{:alertId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/delete
  
  Required parameters: alertId
  
  Optional parameters: customerId
  
  Marks the specified alert for deletion. An alert that has been marked for deletion is removed from Alert Center after 30 days. Marking an alert for deletion has no effect on an alert which has already been marked for deletion. Attempting to mark a nonexistent alert for deletion results in a `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}"
     #{:alertId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn undelete$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/undelete
  
  Required parameters: alertId
  
  Optional parameters: none
  
  Body: 
  
  {:customerId string}
  
  Restores, or \"undeletes\", an alert that was marked for deletion within the past 30 days. Attempting to undelete an alert which was marked for deletion over 30 days ago (which has been removed from the Alert Center database) or a nonexistent alert returns a `NOT_FOUND` error. Attempting to undelete an alert which has not been marked for deletion has no effect."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}:undelete"
     #{:alertId}
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

(defn getMetadata$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/getMetadata
  
  Required parameters: alertId
  
  Optional parameters: customerId
  
  Returns the metadata of an alert. Attempting to get metadata for a non-existent alert returns `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/metadata"
     #{:alertId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchDelete$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/batchDelete
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:customerId string, :alertId [string]}
  
  Performs batch delete operation on alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts:batchDelete"
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

(defn batchUndelete$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/batchUndelete
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:customerId string, :alertId [string]}
  
  Performs batch undelete operation on alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts:batchUndelete"
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

(defn feedback-create$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/feedback/create
  
  Required parameters: alertId
  
  Optional parameters: customerId
  
  Body: 
  
  {:customerId string,
   :alertId string,
   :feedbackId string,
   :createTime string,
   :type string,
   :email string}
  
  Creates new feedback for an alert. Attempting to create a feedback for a non-existent alert returns `NOT_FOUND` error. Attempting to create a feedback for an alert that is marked for deletion returns `FAILED_PRECONDITION' error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/feedback"
     #{:alertId}
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

(defn feedback-list$
  "https://developers.google.com/admin-sdk/alertcenter/api/reference/rest/v1beta1/alerts/feedback/list
  
  Required parameters: alertId
  
  Optional parameters: customerId, filter
  
  Lists all the feedback for an alert. Attempting to list feedbacks for a non-existent alert returns `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:alertId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/feedback"
     #{:alertId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
