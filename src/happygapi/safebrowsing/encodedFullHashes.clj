(ns happygapi.safebrowsing.encodedFullHashes
  "Safe Browsing API: encodedFullHashes.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/encodedFullHashes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/encodedFullHashes/get
  
  Required parameters: encodedRequest
  
  Optional parameters: clientVersion, clientId
  
  "
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:encodedRequest})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/encodedFullHashes/{encodedRequest}"
     #{:encodedRequest}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
