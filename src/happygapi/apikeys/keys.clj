(ns happygapi.apikeys.keys
  "API Keys API: keys.
  Manages the API keys associated with developer projects.
  See: https://cloud.google.com/api-keys/docsapi/reference/rest/v2/keys"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn lookupKey$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/keys/lookupKey
  
  Required parameters: none
  
  Optional parameters: keyString
  
  Find the parent project and resource name of the API key that matches the key string in the request. If the API key has been purged, resource name will not be set. The service account must have the `apikeys.keys.lookup` permission on the parent project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/keys:lookupKey"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
