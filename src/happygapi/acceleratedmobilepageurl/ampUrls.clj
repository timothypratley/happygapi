(ns happygapi.acceleratedmobilepageurl.ampUrls
  "Accelerated Mobile Pages (AMP) URL API
  Retrieves the list of AMP URLs (and equivalent AMP Cache URLs) for a given list of public URL(s).
  
  See: https://developers.google.com/amp/cache/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "acceleratedmobilepageurl_schema.edn"))))

(defn batchGet$
  "Required parameters: none
  
  Optional parameters: none
  
  Returns AMP URL(s) and equivalent
  [AMP Cache URL(s)](/amp/cache/overview#amp-cache-url-format)."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
