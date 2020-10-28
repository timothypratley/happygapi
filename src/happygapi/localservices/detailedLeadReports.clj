(ns happygapi.localservices.detailedLeadReports
  "Local Services API: detailedLeadReports.
  
  See: https://ads.google.com/local-services-ads/api/reference/rest/v1/detailedLeadReports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://ads.google.com/local-services-ads/api/reference/rest/v1/detailedLeadReports/search
  
  Required parameters: none
  
  Optional parameters: startDate.day, pageToken, endDate.month, endDate.day, startDate.year, pageSize, query, startDate.month, endDate.year
  
  Get detailed lead reports containing leads that have been received by all linked GLS accounts. Caller needs to provide their manager customer id and the associated auth credential that allows them read permissions on their linked accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://localservices.googleapis.com/"
     "v1/detailedLeadReports:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
