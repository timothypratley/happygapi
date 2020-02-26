(ns happygapi.proximitybeacon.beaconinfo
  "Proximity Beacon API
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "proximitybeacon_schema.edn"))))

(defn getforobserved$
  "Required parameters: none
  
  Optional parameters: none
  
  Given one or more beacon observations, returns any beacon information
  and attachments accessible to your application. Authorize by using the
  [API
  key](https://developers.google.com/beacons/proximity/get-started#request_a_browser_api_key)
  for the application."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/beaconinfo:getforobserved"
     #{}
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
