(ns happygapi.proximitybeacon.beaconinfo
  "Proximity Beacon API: beaconinfo.
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/beaconinfo"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getforobserved$
  "https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/beaconinfo/getforobserved
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:observations [{:advertisedId AdvertisedId,
                   :telemetry string,
                   :timestampMs string}],
   :namespacedTypes [string]}
  
  Given one or more beacon observations, returns any beacon information
  and attachments accessible to your application. Authorize by using the
  [API
  key](https://developers.google.com/beacons/proximity/get-started#request_a_browser_api_key)
  for the application."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/beaconinfo:getforobserved"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
