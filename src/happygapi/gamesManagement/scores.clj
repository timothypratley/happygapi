(ns happygapi.gamesManagement.scores
  "Google Play Game Management: scores.
  The Google Play Game Management API allows developers to manage resources from the Google Play Game service.
  See: https://developers.google.com/games/docs/reference/rest/v1management/scores"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reset$
  "https://developers.google.com/games/api/reference/rest/v1management/scores/reset
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Resets scores for the leaderboard with the given ID for the currently authenticated player. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/leaderboards/{leaderboardId}/scores/reset"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAll$
  "https://developers.google.com/games/api/reference/rest/v1management/scores/resetAll
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets all scores for all leaderboards for the currently authenticated players. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/scores/reset"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAllForAllPlayers$
  "https://developers.google.com/games/api/reference/rest/v1management/scores/resetAllForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets scores for all draft leaderboards for all players. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/scores/resetAllForAllPlayers"
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
  "https://developers.google.com/games/api/reference/rest/v1management/scores/resetForAllPlayers
  
  Required parameters: leaderboardId
  
  Optional parameters: none
  
  Resets scores for the leaderboard with the given ID for all players. This method is only available to user accounts for your developer console. Only draft leaderboards can be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/leaderboards/{leaderboardId}/scores/resetForAllPlayers"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetMultipleForAllPlayers$
  "https://developers.google.com/games/api/reference/rest/v1management/scores/resetMultipleForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :leaderboard_ids [string]}
  
  Resets scores for the leaderboards with the given IDs for all players. This method is only available to user accounts for your developer console. Only draft leaderboards may be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/scores/resetMultipleForAllPlayers"
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
