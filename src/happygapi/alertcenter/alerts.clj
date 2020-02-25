(ns happygapi.alertcenter.alerts
  "G Suite Alert Center API
  Manages alerts on issues affecting your domain.
  See: https://developers.google.com/admin-sdk/alertcenter/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "alertcenter_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: filter, pageToken, orderBy, customerId, pageSize
  
  Lists the alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn batchDelete$
  "Required parameters: none
  
  Optional parameters: none
  
  Performs batch delete operation on alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts:batchDelete"
     #{}
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

(defn batchUndelete$
  "Required parameters: none
  
  Optional parameters: none
  
  Performs batch undelete operation on alerts."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts:batchUndelete"
     #{}
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

(defn get$
  "Required parameters: alertId
  
  Optional parameters: customerId
  
  Gets the specified alert. Attempting to get a nonexistent alert returns
  `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn undelete$
  "Required parameters: alertId
  
  Optional parameters: none
  
  Restores, or \"undeletes\", an alert that was marked for deletion within the
  past 30 days. Attempting to undelete an alert which was marked for deletion
  over 30 days ago (which has been removed from the Alert Center database) or
  a nonexistent alert returns a `NOT_FOUND` error. Attempting to
  undelete an alert which has not been marked for deletion has no effect."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}:undelete"
     #{"alertId"}
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

(defn getMetadata$
  "Required parameters: alertId
  
  Optional parameters: customerId
  
  Returns the metadata of an alert. Attempting to get metadata for
  a non-existent alert returns `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/metadata"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: alertId
  
  Optional parameters: customerId
  
  Marks the specified alert for deletion. An alert that has been marked for
  deletion is removed from Alert Center after 30 days.
  Marking an alert for deletion has no effect on an alert which has
  already been marked for deletion. Attempting to mark a nonexistent alert
  for deletion results in a `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn feedback-list$
  "Required parameters: alertId
  
  Optional parameters: filter, customerId
  
  Lists all the feedback for an alert. Attempting to list feedbacks for
  a non-existent alert returns `NOT_FOUND` error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/feedback"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn feedback-create$
  "Required parameters: alertId
  
  Optional parameters: customerId
  
  Creates new feedback for an alert. Attempting to create a feedback for
  a non-existent alert returns `NOT_FOUND` error. Attempting to create a
  feedback for an alert that is marked for deletion returns
  `FAILED_PRECONDITION' error."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/alerts/{alertId}/feedback"
     #{"alertId"}
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
