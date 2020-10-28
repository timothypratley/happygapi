(ns happygapi.safebrowsing.threatMatches
  "Safe Browsing API: threatMatches.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/threatMatches"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn find$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/threatMatches/find
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:client {:clientId string, :clientVersion string},
   :threatInfo {:platformTypes [string],
                :threatEntries [ThreatEntry],
                :threatEntryTypes [string],
                :threatTypes [string]}}
  
  Finds the threat entries that match the Safe Browsing lists."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/threatMatches:find"
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
