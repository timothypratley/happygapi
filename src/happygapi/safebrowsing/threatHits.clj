(ns happygapi.safebrowsing.threatHits
  "Safe Browsing API: threatHits.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/threatHits"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/threatHits/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resources [{:remoteIp string,
                :referrer string,
                :type string,
                :url string}],
   :entry {:digest string, :hash string, :url string},
   :platformType string,
   :userInfo {:userId string, :regionCode string},
   :clientInfo {:clientVersion string, :clientId string},
   :threatType string}
  
  Reports a Safe Browsing threat list hit to Google. Only projects with
  TRUSTED_REPORTER visibility can use this method."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/threatHits"
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
