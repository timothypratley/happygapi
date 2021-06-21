(ns happygapi.webrisk.hashes
  "Web Risk API: hashes.
  
  See: https://cloud.google.com/web-risk/api/reference/rest/v1/hashes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/web-risk/api/reference/rest/v1/hashes/search
  
  Required parameters: none
  
  Optional parameters: threatTypes, hashPrefix
  
  Gets the full hashes that match the requested hash prefix. This is used after a hash prefix is looked up in a threatList and there is a match. The client side threatList only holds partial hashes so the client must query this method to determine if there is a full hash match of a threat."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://webrisk.googleapis.com/"
     "v1/hashes:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
