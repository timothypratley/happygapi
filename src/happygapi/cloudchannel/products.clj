(ns happygapi.cloudchannel.products
  "Cloud Channel API: products.
  
  See: https://cloud.google.com/channelapi/reference/rest/v1/products"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/channelapi/reference/rest/v1/products/list
  
  Required parameters: none
  
  Optional parameters: pageToken, account, languageCode, pageSize
  
  Lists the Products the reseller is authorized to sell. Possible error codes: * INVALID_ARGUMENT: Required request parameters are missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/products"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn skus-list$
  "https://cloud.google.com/channelapi/reference/rest/v1/products/skus/list
  
  Required parameters: parent
  
  Optional parameters: account, pageSize, languageCode, pageToken
  
  Lists the SKUs for a product the reseller is authorized to sell. Possible error codes: * INVALID_ARGUMENT: Required request parameters are missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudchannel.googleapis.com/"
     "v1/{+parent}/skus"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
