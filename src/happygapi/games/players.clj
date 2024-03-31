(ns happygapi.games.players
  "Google Play Game Services: players.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/players"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/api/reference/rest/v1/players/get
  
  Required parameters: playerId
  
  Optional parameters: language, playerIdConsistencyToken
  
  Retrieves the Player resource with the given ID. To retrieve the player for the currently authenticated user, set `playerId` to `me`."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}"
     #{:playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getScopedPlayerIds$
  "https://developers.google.com/games/api/reference/rest/v1/players/getScopedPlayerIds
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves scoped player identifiers for currently authenticated user."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/me/scopedIds"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getMultipleApplicationPlayerIds$
  "https://developers.google.com/games/api/reference/rest/v1/players/getMultipleApplicationPlayerIds
  
  Required parameters: none
  
  Optional parameters: applicationIds
  
  Get the application player ids for the currently authenticated player across all requested games by the same developer as the calling application. This will only return ids for players that actually have an id (scoped or otherwise) with that game."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/me/multipleApplicationPlayerIds"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1/players/list
  
  Required parameters: collection
  
  Optional parameters: language, maxResults, pageToken
  
  Get the collection of players for the currently authenticated user."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/me/players/{collection}"
     #{:collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
