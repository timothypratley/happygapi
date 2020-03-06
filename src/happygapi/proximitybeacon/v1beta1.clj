(ns happygapi.proximitybeacon.v1beta1
  "Proximity Beacon API: v1beta1.
  Registers, manages, indexes, and searches beacons.
  See: https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/v1beta1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/beacons/proximity/api/reference/rest/v1beta1/getEidparams
  
  Required parameters: none
  
  Optional parameters: none
  Gets the Proximity Beacon API's current public key and associated
  parameters used to initiate the Diffie-Hellman key exchange required to
  register a beacon that broadcasts the Eddystone-EID format. This key
  changes periodically; clients may cache it and re-use the same public key
  to provision and register multiple beacons. However, clients should be
  prepared to refresh this key when they encounter an error registering an
  Eddystone-EID beacon."
  {:scopes ["https://www.googleapis.com/auth/userlocation.beacon.registry"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://proximitybeacon.googleapis.com/"
     "v1beta1/eidparams"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
