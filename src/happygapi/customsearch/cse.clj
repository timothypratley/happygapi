(ns happygapi.customsearch.cse
  "CustomSearch API: cse.
  Searches over a website or collection of websites
  See: https://developers.google.com/custom-search/v1/using_restapi/reference/rest/v1/cse"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/custom-search/v1/using_restapi/reference/rest/v1/cse/list
  
  Required parameters: q
  
  Optional parameters: lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:q})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/customsearch/"
     "v1"
     #{:q}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn siterestrict-list$
  "https://developers.google.com/custom-search/v1/using_restapi/reference/rest/v1/cse/siterestrict/list
  
  Required parameters: q
  
  Optional parameters: lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  Returns metadata about the search performed, metadata about the custom search engine used for the search, and the search results. Uses a small set of url patterns."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:q})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/customsearch/"
     "v1/siterestrict"
     #{:q}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
