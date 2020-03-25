(ns happygapi.safebrowsing.threatListUpdates
  "Safe Browsing API: threatListUpdates.
  Enables client applications to check web resources (most commonly URLs) against Google-generated lists of unsafe web resources. The Safe Browsing APIs are for non-commercial use only. If you need to use APIs to detect malicious URLs for commercial purposes – meaning “for sale or revenue-generating purposes” – please refer to the Web Risk API.
  See: https://developers.google.com/safe-browsing/api/reference/rest/v4/threatListUpdates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn fetch$
  "https://developers.google.com/safe-browsing/api/reference/rest/v4/threatListUpdates/fetch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:listUpdateRequests [{:platformType string,
                         :threatType string,
                         :constraints Constraints,
                         :threatEntryType string,
                         :state string}],
   :client {:clientVersion string, :clientId string}}
  
  Fetches the most recent threat list updates. A client can request updates
  for multiple lists at once."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://safebrowsing.googleapis.com/"
     "v4/threatListUpdates:fetch"
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
