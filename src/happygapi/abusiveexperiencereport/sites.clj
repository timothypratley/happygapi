(ns happygapi.abusiveexperiencereport.sites
  "Abusive Experience Report API
  Views Abusive Experience Report data, and gets a list of sites that have a significant number of abusive experiences.
  See: https://developers.google.com/abusive-experience-report/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Gets a site's Abusive Experience Report summary."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://abusiveexperiencereport.googleapis.com/"
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
