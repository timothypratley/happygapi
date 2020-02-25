(ns happygapi.cloudbilling.services
  "Cloud Billing API
  Allows developers to manage billing for their Google Cloud Platform projects
      programmatically.
  See: https://cloud.google.com/billing/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudbilling_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists all public cloud services."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/services"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn skus-list$
  "Required parameters: parent
  
  Optional parameters: endTime, pageToken, startTime, pageSize, currencyCode
  
  Lists all publicly available SKUs for a given cloud service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+parent}/skus"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
