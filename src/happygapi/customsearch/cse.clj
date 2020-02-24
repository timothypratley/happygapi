(ns happygapi.customsearch.cse
  "CustomSearch API
  Searches over a website or collection of websites
  See: https://developers.google.com/custom-search/v1/using_rest"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: q
  
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"q"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/customsearch/"
     "v1"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn siterestrict-list$
  "Required parameters: q
  
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results. Uses a small set of url patterns."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"q"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/customsearch/"
     "v1/siterestrict"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
