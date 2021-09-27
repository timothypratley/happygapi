(ns happygapi.mybusinessbusinessinformation.chains
  "My Business Business Information API: chains.
  The My Business Business Information API provides an interface for managing business information on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/chains"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/my-business/api/reference/rest/v1/chains/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified chain. Returns `NOT_FOUND` if the chain does not exist."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn search$
  "https://developers.google.com/my-business/api/reference/rest/v1/chains/search
  
  Required parameters: none
  
  Optional parameters: pageSize, chainName
  
  Searches the chain based on chain name."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/chains:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
