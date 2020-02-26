(ns happygapi.androidenterprise.managedconfigurationssettings
  "Google Play EMM API
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidenterprise_schema.edn"))))

(defn list$
  "Required parameters: enterpriseId, productId
  
  Optional parameters: none
  
  Lists all the managed configurations settings for the specified app."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/products/{productId}/managedConfigurationsSettings"
     #{"productId" "enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
