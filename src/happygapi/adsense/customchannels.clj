(ns happygapi.adsense.customchannels
  "AdSense Management API: customchannels.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/customchannels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/customchannels/get
  
  Required parameters: adClientId, customChannelId
  
  Optional parameters: none
  
  Get the specified custom channel from the specified ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :customChannelId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/customchannels/{customChannelId}"
     #{:adClientId :customChannelId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/customchannels/list
  
  Required parameters: adClientId
  
  Optional parameters: pageToken, maxResults
  
  List all custom channels in the specified ad client for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/customchannels"
     #{:adClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/customchannels/adunits/list
  
  Required parameters: customChannelId, adClientId
  
  Optional parameters: includeInactive, pageToken, maxResults
  
  List all ad units in the specified custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :customChannelId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/customchannels/{customChannelId}/adunits"
     #{:adClientId :customChannelId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
