(ns happygapi.gamesManagement.players
  "Google Play Game Services Management API: players.
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1management/players"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn hide$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/players/hide
  
  Required parameters: applicationId, playerId
  
  Optional parameters: none
  
  Hide the given player's leaderboard scores from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId :applicationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden/{playerId}"
     #{:playerId :applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unhide$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/players/unhide
  
  Required parameters: applicationId, playerId
  
  Optional parameters: none
  
  Unhide the given player's leaderboard scores from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId :applicationId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden/{playerId}"
     #{:playerId :applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
