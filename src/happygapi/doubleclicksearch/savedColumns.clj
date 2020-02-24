(ns happygapi.doubleclicksearch.savedColumns
  "Search Ads 360 API
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: advertiserId,agencyId
  
  Retrieve the list of saved columns for a specified advertiser."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys? args #{"advertiserId" "agencyId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "agency/{agencyId}/advertiser/{advertiserId}/savedcolumns"
     #{"advertiserId" "agencyId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
