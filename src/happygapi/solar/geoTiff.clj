(ns happygapi.solar.geoTiff
  "Solar API: geoTiff.
  Solar API.
  See: https://developers.google.com/maps/documentation/solardocs/reference/rest/v1/geoTiff"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/maps/documentation/solarapi/reference/rest/v1/geoTiff/get
  
  Required parameters: none
  
  Optional parameters: id
  
  Returns an image by its ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://solar.googleapis.com/"
     "v1/geoTiff:get"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
