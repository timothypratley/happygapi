(ns happygapi.gamesManagement.turnBasedMatches
  "Google Play Game Services Management API: turnBasedMatches.
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1management/turnBasedMatches"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reset$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/turnBasedMatches/reset
  
  Required parameters: none
  
  Optional parameters: none
  
  Reset all turn-based match data for a user. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "turnbasedmatches/reset"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetForAllPlayers$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/turnBasedMatches/resetForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Deletes turn-based matches where the only match participants are from whitelisted tester accounts for your application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "turnbasedmatches/resetForAllPlayers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
