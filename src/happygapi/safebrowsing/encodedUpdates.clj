(ns happygapi.safebrowsing.encodedUpdates
  "Safe Browsing API: encodedUpdates.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/encodedUpdates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/encodedUpdates/get
  
  Required parameters: encodedRequest
  
  Optional parameters: clientVersion, clientId
  "
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{:encodedRequest})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/encodedUpdates/{encodedRequest}"
     #{:encodedRequest}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
