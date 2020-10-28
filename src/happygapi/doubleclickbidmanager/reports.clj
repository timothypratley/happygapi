(ns happygapi.doubleclickbidmanager.reports
  "DoubleClick Bid Manager API: reports.
  DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listreports$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/reports/listreports
  
  Required parameters: queryId
  
  Optional parameters: pageSize, pageToken
  
  Retrieves stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
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
