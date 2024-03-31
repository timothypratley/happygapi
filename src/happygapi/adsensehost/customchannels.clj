(ns happygapi.adsensehost.customchannels
  "AdSense Host API: customchannels.
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/delete
  
  Required parameters: adClientId, customChannelId
  
  Optional parameters: none
  
  Delete a specific custom channel from the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :customChannelId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
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

(defn get$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/get
  
  Required parameters: adClientId, customChannelId
  
  Optional parameters: none
  
  Get a specific custom channel from the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :customChannelId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
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

(defn insert$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/insert
  
  Required parameters: adClientId
  
  Optional parameters: none
  
  Body: 
  
  {:code string, :id string, :kind string, :name string}
  
  Add a new custom channel to the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{:adClientId}
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

(defn list$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/list
  
  Required parameters: adClientId
  
  Optional parameters: maxResults, pageToken
  
  List all host custom channels in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
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

(defn patch$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/patch
  
  Required parameters: adClientId, customChannelId
  
  Optional parameters: none
  
  Body: 
  
  {:code string, :id string, :kind string, :name string}
  
  Update a custom channel in the host AdSense account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId :customChannelId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{:adClientId :customChannelId}
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

(defn update$
  "https://developers.google.com/adsense/host/api/reference/rest/v4.1/customchannels/update
  
  Required parameters: adClientId
  
  Optional parameters: none
  
  Body: 
  
  {:code string, :id string, :kind string, :name string}
  
  Update a custom channel in the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:adClientId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{:adClientId}
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
