(ns happygapi.adsense.alerts
  "AdSense Management API
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adsense_schema.edn"))))

(defn delete$
  "Required parameters: alertId
  
  Optional parameters: none
  
  Dismiss (delete) the specified alert from the publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "alerts/{alertId}"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: locale
  
  List the alerts for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "alerts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
