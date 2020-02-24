(ns happygapi.abusiveexperiencereport.violatingSites
  "Abusive Experience Report API
  Views Abusive Experience Report data, and gets a list of sites that have a significant number of abusive experiences.
  See: https://developers.google.com/abusive-experience-report/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn list$
  "Required parameters: none
  
  Lists sites that are failing in the Abusive Experience Report."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://abusiveexperiencereport.googleapis.com/"
     "v1/violatingSites"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
