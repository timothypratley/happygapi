(ns happygapi.customsearch.cse
  "Custom Search API: cse.
  Searches over a website or collection of websites
  See: https://developers.google.com/custom-search/v1/introductionapi/reference/rest/v1/cse"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/custom-search/v1/introductionapi/reference/rest/v1/cse/list
  
  Required parameters: none
  
  Optional parameters: q, lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, snippetLength, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  
  Returns metadata about the search performed, metadata about the engine used for the search, and the search results."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://customsearch.googleapis.com/"
     "customsearch/v1"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn siterestrict-list$
  "https://developers.google.com/custom-search/v1/introductionapi/reference/rest/v1/cse/siterestrict/list
  
  Required parameters: none
  
  Optional parameters: q, lr, num, excludeTerms, relatedSite, fileType, searchType, siteSearch, imgSize, orTerms, start, cr, hq, filter, imgColorType, exactTerms, hl, rights, imgDominantColor, imgType, cx, gl, snippetLength, dateRestrict, googlehost, c2coff, safe, siteSearchFilter, lowRange, sort, linkSite, highRange
  
  Returns metadata about the search performed, metadata about the engine used for the search, and the search results. Uses a small set of url patterns."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://customsearch.googleapis.com/"
     "customsearch/v1/siterestrict"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
