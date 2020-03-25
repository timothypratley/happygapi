(ns happygapi.doubleclickbidmanager.queries
  "DoubleClick Bid Manager API: queries.
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/createquery
  
  Required parameters: none
  
  Optional parameters: asynchronous
  
  Body: 
  
  {:kind string,
   :metadata {:format string,
              :locale string,
              :sendNotification boolean,
              :dataRange string,
              :latestReportRunTimeMs string,
              :title string,
              :running boolean,
              :googleCloudStoragePathForLatestReport string,
              :reportCount integer,
              :shareEmailAddress [string],
              :googleDrivePathForLatestReport string},
   :params {:filters [FilterPair],
            :groupBys [string],
            :includeInviteData boolean,
            :metrics [string],
            :options Options,
            :type string},
   :queryId string,
   :reportDataEndTimeMs string,
   :reportDataStartTimeMs string,
   :schedule {:endTimeMs string,
              :frequency string,
              :nextRunMinuteOfDay integer,
              :nextRunTimezoneCode string,
              :startTimeMs string},
   :timezoneCode string}
  
  Creates a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query"
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

(defn deletequery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/deletequery
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Deletes a stored query as well as the associated stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/getquery
  
  Required parameters: queryId
  
  Optional parameters: none
  
  Retrieves a stored query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{:queryId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listqueries$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/listqueries
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Retrieves stored queries."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
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

(defn runquery$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/queries/runquery
  
  Required parameters: queryId
  
  Optional parameters: asynchronous
  
  Body: 
  
  {:dataRange string,
   :reportDataEndTimeMs string,
   :reportDataStartTimeMs string,
   :timezoneCode string}
  
  Runs a stored query to generate a report."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
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
