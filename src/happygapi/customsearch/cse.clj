(ns happygapi.customsearch.cse
  "CustomSearch API
  Searches over a website or collection of websites
  See: https://developers.google.com/custom-search/v1/using_rest"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "customsearch_schema.edn"))))

(defn list$
  "Required parameters: q
  
  Optional parameters: lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"q"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results. Uses a small set of url patterns."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"q"})
         (json-schema/validate schemas args)]}
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
