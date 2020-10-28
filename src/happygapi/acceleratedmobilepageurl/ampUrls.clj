(ns happygapi.acceleratedmobilepageurl.ampUrls
  "Accelerated Mobile Pages (AMP) URL API: ampUrls.
  Retrieves the list of AMP URLs (and equivalent AMP Cache URLs) for a given list of public URL(s). 
  See: https://developers.google.com/amp/cache/api/reference/rest/v1/ampUrls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchGet$
  "https://developers.google.com/amp/cache/api/reference/rest/v1/ampUrls/batchGet
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:urls [string], :lookupStrategy string}
  
  Returns AMP URL(s) and equivalent [AMP Cache URL(s)](/amp/cache/overview#amp-cache-url-format)."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://acceleratedmobilepageurl.googleapis.com/"
     "v1/ampUrls:batchGet"
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
