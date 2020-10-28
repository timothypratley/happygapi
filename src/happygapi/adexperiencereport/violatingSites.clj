(ns happygapi.adexperiencereport.violatingSites
  "Ad Experience Report API: violatingSites.
  Views Ad Experience Report data, and gets a list of sites that have a significant number of annoying ads.
  See: https://developers.google.com/ad-experience-report/api/reference/rest/v1/violatingSites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/ad-experience-report/api/reference/rest/v1/violatingSites/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Lists sites that are failing in the Ad Experience Report on at least one platform."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexperiencereport.googleapis.com/"
     "v1/violatingSites"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
