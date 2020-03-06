(ns happygapi.doubleclickbidmanager.reports
  "DoubleClick Bid Manager API: reports.
  API for viewing and managing your reports in DoubleClick Bid Manager.
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
  [auth args]
  {:pre [(util/has-keys? args #{:queryId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "queries/{queryId}/reports"
     #{:queryId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
