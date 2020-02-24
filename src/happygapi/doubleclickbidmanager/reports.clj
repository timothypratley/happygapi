(ns happygapi.doubleclickbidmanager.reports
  "DoubleClick Bid Manager API
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn listreports$
  "Required parameters: queryId
  
  Retrieves stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{"queryId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "queries/{queryId}/reports"
     #{"queryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
