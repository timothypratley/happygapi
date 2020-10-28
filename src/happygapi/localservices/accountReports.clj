(ns happygapi.localservices.accountReports
  "Local Services API: accountReports.
  
  See: https://ads.google.com/local-services-ads/api/reference/rest/v1/accountReports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://ads.google.com/local-services-ads/api/reference/rest/v1/accountReports/search
  
  Required parameters: none
  
  Optional parameters: startDate.day, pageToken, endDate.month, endDate.day, startDate.year, pageSize, query, startDate.month, endDate.year
  
  Get account reports containing aggregate account data of all linked GLS accounts. Caller needs to provide their manager customer id and the associated auth credential that allows them read permissions on their linked accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://localservices.googleapis.com/"
     "v1/accountReports:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
