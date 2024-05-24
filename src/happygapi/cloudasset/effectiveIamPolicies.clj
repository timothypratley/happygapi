(ns happygapi.cloudasset.effectiveIamPolicies
  "Cloud Asset API: effectiveIamPolicies.
  The Cloud Asset API manages the history and inventory of Google Cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartdocs/reference/rest/v1/effectiveIamPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchGet$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/effectiveIamPolicies/batchGet
  
  Required parameters: scope
  
  Optional parameters: names
  
  Gets effective IAM policies for a batch of resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}/effectiveIamPolicies:batchGet"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
