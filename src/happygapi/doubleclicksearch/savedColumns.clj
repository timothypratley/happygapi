(ns happygapi.doubleclicksearch.savedColumns
  "Search Ads 360 API: savedColumns.
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/api/reference/rest/v2/savedColumns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/savedColumns/list
  
  Required parameters: advertiserId, agencyId
  
  Optional parameters: none
  
  Retrieve the list of saved columns for a specified advertiser."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :agencyId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "agency/{agencyId}/advertiser/{advertiserId}/savedcolumns"
     #{:advertiserId :agencyId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
