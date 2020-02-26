(ns happygapi.adsense.customchannels
  "AdSense Management API
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adsense_schema.edn"))))

(defn get$
  "Required parameters: adClientId, customChannelId
  
  Optional parameters: none
  
  Get the specified custom channel from the specified ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customChannelId" "adClientId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
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

(defn list$
  "Required parameters: adClientId
  
  Optional parameters: maxResults, pageToken
  
  List all custom channels in the specified ad client for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"adClientId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
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

(defn adunits-list$
  "Required parameters: adClientId, customChannelId
  
  Optional parameters: includeInactive, maxResults, pageToken
  
  List all ad units in the specified custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customChannelId" "adClientId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "adclients/{adClientId}/customchannels/{customChannelId}/adunits"
     #{"customChannelId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
