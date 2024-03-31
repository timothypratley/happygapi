(ns happygapi.travelimpactmodel.flights
  "Travel Impact Model API: flights.
  Travel Impact Model API lets you query travel carbon emission estimates.
  See: https://developers.google.com/travel/impact-modelapi/reference/rest/v1/flights"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn computeFlightEmissions$
  "https://developers.google.com/travel/impact-modelapi/reference/rest/v1/flights/computeFlightEmissions
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:flights [{:operatingCarrierCode string,
              :departureDate Date,
              :origin string,
              :flightNumber integer,
              :destination string}]}
  
  Stateless method to retrieve emission estimates. Details on how emission estimates are computed: https://github.com/google/travel-impact-model The response will contain all entries that match the input flight legs, in the same order. If there are no estimates available for a certain flight leg, the response will return the flight leg object with empty emission fields. The request will still be considered successful. Reasons for missing emission estimates include: - The flight is unknown to the server. - The input flight leg is missing one or more identifiers. - The flight date is in the past. - The aircraft type is not supported by the model. - Missing seat configuration. The request can contain up to 1000 flight legs. If the request has more than 1000 direct flights, if will fail with an INVALID_ARGUMENT error."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://travelimpactmodel.googleapis.com/"
     "v1/flights:computeFlightEmissions"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
