(ns happygapi.cloudasset.assets
  "Cloud Asset API: assets.
  The Cloud Asset API manages the history and inventory of Google Cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/assets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/assets/list
  
  Required parameters: parent
  
  Optional parameters: readTime, assetTypes, contentType, pageSize, pageToken, relationshipTypes
  
  Lists assets with time and resource types and returns paged results in response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}/assets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
