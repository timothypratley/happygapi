(ns happygapi.solar.buildingInsights
  "Solar API: buildingInsights.
  Solar API.
  See: https://developers.google.com/maps/documentation/solardocs/reference/rest/v1/buildingInsights"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn findClosest$
  "https://developers.google.com/maps/documentation/solarapi/reference/rest/v1/buildingInsights/findClosest
  
  Required parameters: none
  
  Optional parameters: location.longitude, requiredQuality, location.latitude
  
  Locates the closest building to a query point. Returns an error with code `NOT_FOUND` if there are no buildings within approximately 50m of the query point."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://solar.googleapis.com/"
     "v1/buildingInsights:findClosest"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
