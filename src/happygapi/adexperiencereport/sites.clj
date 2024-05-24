(ns happygapi.adexperiencereport.sites
  "Ad Experience Report API: sites.
  Views Ad Experience Report data, and gets a list of sites that have a significant number of annoying ads.
  See: https://developers.google.com/ad-experience-report/docs/reference/rest/v1/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-experience-report/api/reference/rest/v1/sites/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a site's Ad Experience Report summary."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexperiencereport.googleapis.com/"
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
