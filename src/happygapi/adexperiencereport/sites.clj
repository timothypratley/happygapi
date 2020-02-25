(ns happygapi.adexperiencereport.sites
  "Ad Experience Report API
  Views Ad Experience Report data, and gets a list of sites that have a significant number of annoying ads.
  See: https://developers.google.com/ad-experience-report/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "adexperiencereport_schema.edn"))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a site's Ad Experience Report summary."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
