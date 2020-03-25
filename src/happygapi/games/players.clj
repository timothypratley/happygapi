(ns happygapi.games.players
  "Google Play Game Services API: players.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/players"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/players/get
  
  Required parameters: playerId
  
  Optional parameters: language
  
  Retrieves the Player resource with the given ID. To retrieve the player for the currently authenticated user, set playerId to me."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}"
     #{:playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/players/list
  
  Required parameters: collection
  
  Optional parameters: language, maxResults, pageToken
  
  Get the collection of players for the currently authenticated user."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/me/players/{collection}"
     #{:collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
