(ns happygapi.adsensehost.adclients
  "AdSense Host API: adclients.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/api/reference/rest/v4.1/adclients"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/adclients/get
  
  Required parameters: adClientId
  
  Optional parameters: none
  
  Get information about one of the ad clients in the Host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}"
     #{:adClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/adclients/list
  
  Required parameters: none
  
  Optional parameters: pageToken, maxResults
  
  List all host ad clients in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
