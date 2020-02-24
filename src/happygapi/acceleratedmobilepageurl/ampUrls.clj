(ns happygapi.acceleratedmobilepageurl.ampUrls
  "Accelerated Mobile Pages (AMP) URL API
  Retrieves the list of AMP URLs (and equivalent AMP Cache URLs) for a given list of public URL(s).
  
  See: https://developers.google.com/amp/cache/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn batchGet$
  "Required parameters: none
  
  Returns AMP URL(s) and equivalent
  [AMP Cache URL(s)](/amp/cache/overview#amp-cache-url-format)."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://acceleratedmobilepageurl.googleapis.com/"
     "v1/ampUrls:batchGet"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
