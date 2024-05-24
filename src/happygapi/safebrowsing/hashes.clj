(ns happygapi.safebrowsing.hashes
  "Safe Browsing API: hashes.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/docs/reference/rest/v5/hashes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/safe-browsing/api/reference/rest/v5/hashes/search
  
  Required parameters: none
  
  Optional parameters: hashPrefixes
  
  Search for full hashes matching the specified prefixes. This is a custom method as defined by https://google.aip.dev/136 (the custom method refers to this method having a custom name within Google's general API development nomenclature; it does not refer to using a custom HTTP method)."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v5/hashes:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
