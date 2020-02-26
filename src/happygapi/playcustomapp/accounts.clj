(ns happygapi.playcustomapp.accounts
  "Google Play Custom App Publishing API
  An API to publish custom Android apps.
  See: https://developers.google.com/android/work/play/custom-app-api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "playcustomapp_schema.edn"))))

(defn customApps-create$
  "Required parameters: account
  
  Optional parameters: none
  
  Create and publish a new custom app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"account"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/playcustomapp/v1/accounts/"
     "{account}/customApps"
     #{"account"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
