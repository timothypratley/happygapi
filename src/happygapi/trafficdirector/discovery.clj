(ns happygapi.trafficdirector.discovery
  "Traffic Director API: discovery.
  
  See: https://cloud.google.com/traffic-directorapi/reference/rest/v2/discovery"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn client_status$
  "https://cloud.google.com/traffic-directorapi/reference/rest/v2/discovery/client_status
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:nodeMatchers [{:nodeId StringMatcher,
                   :nodeMetadatas [StructMatcher]}]}
  
  "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://trafficdirector.googleapis.com/"
     "v2/discovery:client_status"
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
