(ns happygapi.games.scores
  "Google Play Game Services: scores.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/scores"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1/scores/list
  
  Required parameters: leaderboardId, collection, timeSpan
  
  Optional parameters: maxResults, pageToken, language
  
  Lists the scores in a leaderboard, starting from the top."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards/{leaderboardId}/scores/{collection}"
     #{:timeSpan :leaderboardId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn submitMultiple$
  "https://developers.google.com/games/api/reference/rest/v1/scores/submitMultiple
  
  Required parameters: none
  
  Optional parameters: language
  
  Body: 
  
  {:scores [{:score string,
             :kind string,
             :signature string,
             :leaderboardId string,
             :scoreTag string}],
   :kind string}
  
  Submits multiple scores to leaderboards."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards/scores"
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

(defn get$
  "https://developers.google.com/games/api/reference/rest/v1/scores/get
  
  Required parameters: playerId, leaderboardId, timeSpan
  
  Optional parameters: maxResults, pageToken, includeRankType, language
  
  Get high scores, and optionally ranks, in leaderboards for the currently authenticated player. For a specific time span, `leaderboardId` can be set to `ALL` to retrieve data for all leaderboards in a given time span. `NOTE: You cannot ask for 'ALL' leaderboards and 'ALL' timeSpans in the same request; only one parameter may be set to 'ALL'."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}/leaderboards/{leaderboardId}/scores/{timeSpan}"
     #{:timeSpan :leaderboardId :playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "https://developers.google.com/games/api/reference/rest/v1/scores/submit
  
  Required parameters: score, leaderboardId
  
  Optional parameters: scoreTag, language
  
  Submits a score to the specified leaderboard."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId :score})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards/{leaderboardId}/scores"
     #{:leaderboardId :score}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listWindow$
  "https://developers.google.com/games/api/reference/rest/v1/scores/listWindow
  
  Required parameters: timeSpan, collection, leaderboardId
  
  Optional parameters: pageToken, resultsAbove, returnTopIfAbsent, maxResults, language
  
  Lists the scores in a leaderboard around (and including) a player's score."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/leaderboards/{leaderboardId}/window/{collection}"
     #{:timeSpan :leaderboardId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
