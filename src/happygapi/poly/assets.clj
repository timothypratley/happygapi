(ns happygapi.poly.assets
  "Poly API: assets.
  The Poly API provides read access to assets hosted on poly.google.com to all, and upload access to poly.google.com for whitelisted accounts. 
  See: https://developers.google.com/poly/api/reference/rest/v1/assets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/poly/api/reference/rest/v1/assets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns detailed information about an asset given its name. PRIVATE assets are returned only if the currently authenticated user (via OAuth token) is the author of the asset."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/poly/api/reference/rest/v1/assets/list
  
  Required parameters: none
  
  Optional parameters: category, maxComplexity, curated, pageSize, orderBy, keywords, format, pageToken
  
  Lists all public, remixable assets. These are assets with an access level of PUBLIC and published under the CC-By license."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://poly.googleapis.com/"
     "v1/assets"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
