(ns happygapi.kmsinventory.organizations
  "KMS Inventory API: organizations.
  
  See: https://cloud.google.com/kms/api/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn protectedResources-search$
  "https://cloud.google.com/kms/api/reference/rest/v1/organizations/protectedResources/search
  
  Required parameters: scope
  
  Optional parameters: pageSize, cryptoKey, pageToken, resourceTypes
  
  Returns metadata about the resources protected by the given Cloud KMS CryptoKey in the given Cloud organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kmsinventory.googleapis.com/"
     "v1/{+scope}/protectedResources:search"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
