(ns happygapi.adsense.urlchannels
  "AdSense Management API: urlchannels.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/urlchannels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/urlchannels/list
  
  Required parameters: adClientId
  
  Optional parameters: pageToken, maxResults
  
  List all URL channels in the specified ad client for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/urlchannels"
     #{:adClientId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
