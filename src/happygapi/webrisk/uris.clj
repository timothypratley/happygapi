(ns happygapi.webrisk.uris
  "Web Risk API: uris.
  
  See: https://cloud.google.com/web-risk/api/reference/rest/v1/uris"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/web-risk/api/reference/rest/v1/uris/search
  
  Required parameters: none
  
  Optional parameters: threatTypes, uri
  
  This method is used to check whether a URI is on a given threatList. Multiple threatLists may be searched in a single query. The response will list all requested threatLists the URI was found to match. If the URI is not found on any of the requested ThreatList an empty response will be returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://webrisk.googleapis.com/"
     "v1/uris:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
