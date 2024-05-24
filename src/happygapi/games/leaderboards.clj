(ns happygapi.games.leaderboards
  "Google Play Game Services: leaderboards.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/docs/reference/rest/v1/leaderboards"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/api/reference/rest/v1/leaderboards/get
  
  Required parameters: leaderboardId
  
  Optional parameters: language
  
  Retrieves the metadata of the leaderboard with the given ID."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards/{leaderboardId}"
     #{:leaderboardId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1/leaderboards/list
  
  Required parameters: none
  
  Optional parameters: language, maxResults, pageToken
  
  Lists all the leaderboard metadata for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
