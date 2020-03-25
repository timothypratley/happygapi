(ns happygapi.abusiveexperiencereport.sites
  "Abusive Experience Report API: sites.
  Views Abusive Experience Report data, and gets a list of sites that have a significant number of abusive experiences.
  See: https://developers.google.com/abusive-experience-report/api/reference/rest/v1/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/abusive-experience-report/api/reference/rest/v1/sites/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a site's Abusive Experience Report summary."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://abusiveexperiencereport.googleapis.com/"
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
