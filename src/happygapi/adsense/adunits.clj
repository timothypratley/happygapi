(ns happygapi.adsense.adunits
  "AdSense Management API: adunits.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/adunits"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/adunits/get
  
  Required parameters: adClientId, adUnitId
  
  Optional parameters: none
  Gets the specified ad unit in the specified ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:adUnitId :adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}"
     #{:adUnitId :adClientId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getAdCode$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/adunits/getAdCode
  
  Required parameters: adClientId, adUnitId
  
  Optional parameters: none
  Get ad code for the specified ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:adUnitId :adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{:adUnitId :adClientId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/adunits/list
  
  Required parameters: adClientId
  
  Optional parameters: includeInactive, maxResults, pageToken
  List all ad units in the specified ad client for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits"
     #{:adClientId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/adunits/customchannels/list
  
  Required parameters: adClientId, adUnitId
  
  Optional parameters: maxResults, pageToken
  List all custom channels which the specified ad unit belongs to."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:adUnitId :adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}/customchannels"
     #{:adUnitId :adClientId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
