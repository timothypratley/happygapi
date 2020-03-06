(ns happygapi.adsense.reports
  "AdSense Management API: reports.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/reports/generate
  
  Required parameters: startDate, endDate
  
  Optional parameters: locale, currency, filter, dimension, accountId, startIndex, metric, sort, useTimezoneReporting, maxResults
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:startDate :endDate})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "reports"
     #{:startDate :endDate}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn saved-generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/reports/saved/generate
  
  Required parameters: savedReportId
  
  Optional parameters: locale, maxResults, startIndex
  Generate an AdSense report based on the saved report ID sent in the query parameters."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:savedReportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "reports/{savedReportId}"
     #{:savedReportId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn saved-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/reports/saved/list
  
  Required parameters: none
  
  Optional parameters: maxResults, pageToken
  List all saved reports in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "reports/saved"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
