(ns happygapi.doubleclicksearch.savedColumns
  "Search Ads 360 API
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "doubleclicksearch_schema.edn"))))

(defn list$
  "Required parameters: advertiserId, agencyId
  
  Optional parameters: none
  
  Retrieve the list of saved columns for a specified advertiser."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys? args #{"advertiserId" "agencyId"})
         (json-schema/validate schemas args)]}
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
