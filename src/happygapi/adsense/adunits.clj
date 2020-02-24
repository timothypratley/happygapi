(ns happygapi.adsense.adunits
  "AdSense Management API
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: adClientId,adUnitId
  
  Gets the specified ad unit in the specified ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}"
     #{"adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getAdCode$
  "Required parameters: adClientId,adUnitId
  
  Get ad code for the specified ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{"adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: adClientId
  
  List all ad units in the specified ad client for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits"
     #{"adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-list$
  "Required parameters: adClientId,adUnitId
  
  List all custom channels which the specified ad unit belongs to."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/adunits/{adUnitId}/customchannels"
     #{"adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
