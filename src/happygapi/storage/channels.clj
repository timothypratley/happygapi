(ns happygapi.storage.channels
  "Cloud Storage JSON API: channels.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/channels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn stop$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/channels/stop
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:address string,
   :resourceUri string,
   :payload boolean,
   :expiration string,
   :params {},
   :type string,
   :resourceId string,
   :token string,
   :id string,
   :kind string}
  
  Stop watching resources through this channel"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "channels/stop"
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
