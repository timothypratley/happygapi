(ns happygapi.adexperiencereport.sites
  "Ad Experience Report API
  Views Ad Experience Report data, and gets a list of sites that have a significant number of annoying ads.
  See: https://developers.google.com/ad-experience-report/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Gets a site's Ad Experience Report summary."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexperiencereport.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
