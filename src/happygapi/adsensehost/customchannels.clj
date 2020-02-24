(ns happygapi.adsensehost.customchannels
  "AdSense Host API
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: adClientId,customChannelId
  
  Delete a specific custom channel from the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customChannelId" "adClientId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels/{customChannelId}"
     #{"customChannelId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: adClientId,customChannelId
  
  Get a specific custom channel from the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customChannelId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels/{customChannelId}"
     #{"customChannelId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: adClientId
  
  Add a new custom channel to the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"adClientId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{"adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: adClientId
  
  List all host custom channels in this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{"adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: adClientId,customChannelId
  
  Update a custom channel in the host AdSense account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customChannelId" "adClientId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{"adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: adClientId
  
  Update a custom channel in the host AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adClientId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "adclients/{adClientId}/customchannels"
     #{"adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
