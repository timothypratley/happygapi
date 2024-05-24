(ns happygapi.doubleclickbidmanager.queries
  "DoubleClick Bid Manager API: queries.
  DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/bid-manager/docs/reference/rest/v2/queries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:queryId string,
   :metadata {:title string,
              :dataRange DataRange,
              :format string,
              :sendNotification boolean,
              :shareEmailAddress [string]},
   :params {:type string,
            :groupBys [string],
            :filters [FilterPair],
            :metrics [string],
            :options Options},
   :schedule {:startDate Date,
              :endDate Date,
              :frequency string,
              :nextRunTimezoneCode string}}
  
  Creates a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries"
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

(defn delete$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/delete
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Deletes a query as well as the associated reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/get
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Retrieves a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, orderBy
  
  Lists queries created by the current user."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn run$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/run
  
  Required parameters: queryId
  
  Optional parameters: synchronous
  
  Body: 
  
  {:dataRange {:range string,
               :customStartDate Date,
               :customEndDate Date}}
  
  Runs a stored query to generate a report."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries/{queryId}:run"
     #{:queryId}
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

(defn reports-list$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/reports/list
  
  Required parameters: queryId
  
  Optional parameters: pageSize, pageToken, orderBy
  
  Lists reports associated with a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries/{queryId}/reports"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-get$
  "https://developers.google.com/bid-manager/api/reference/rest/v2/queries/reports/get
  
  Required parameters: queryId, reportId
  
  Optional parameters: none
  
  Retrieves a report."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/v2/"
     "queries/{queryId}/reports/{reportId}"
     #{:reportId :queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
