(ns happygapi.alertcenter.v1beta1
  "G Suite Alert Center API
  Manages alerts on issues affecting your domain.
  See: https://developers.google.com/admin-sdk/alertcenter/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "alertcenter_schema.edn"))))

(defn $
  "Required parameters: none
  
  Optional parameters: customerId
  
  Returns customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Optional parameters: customerId
  
  Updates the customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
