(ns happygapi.safebrowsing.fullHashes
  "Safe Browsing API: fullHashes.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/fullHashes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn find$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/fullHashes/find
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:threatInfo {:threatEntries [GoogleSecuritySafebrowsingV4ThreatEntry],
                :threatTypes [string],
                :platformTypes [string],
                :threatEntryTypes [string]},
   :apiClient {:clientVersion string, :clientId string},
   :client {:clientVersion string, :clientId string},
   :clientStates [string]}
  
  Finds the full hashes that match the requested hash prefixes."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/fullHashes:find"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
