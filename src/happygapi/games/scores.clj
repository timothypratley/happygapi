(ns happygapi.games.scores
  "Google Play Game Services API: scores.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/scores"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/scores/get
  
  Required parameters: leaderboardId, playerId, timeSpan
  
  Optional parameters: includeRankType, language, maxResults, pageToken
  
  Get high scores, and optionally ranks, in leaderboards for the currently authenticated player. For a specific time span, leaderboardId can be set to ALL to retrieve data for all leaderboards in a given time span.
  NOTE: You cannot ask for 'ALL' leaderboards and 'ALL' timeSpans in the same request; only one parameter may be set to 'ALL'."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/leaderboards/{leaderboardId}/scores/{timeSpan}"
     #{:timeSpan :leaderboardId :playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/scores/list
  
  Required parameters: collection, leaderboardId, timeSpan
  
  Optional parameters: language, maxResults, pageToken
  
  Lists the scores in a leaderboard, starting from the top."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/scores/{collection}"
     #{:timeSpan :leaderboardId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listWindow$
  "https://developers.google.com/games/services/api/reference/rest/v1/scores/listWindow
  
  Required parameters: collection, leaderboardId, timeSpan
  
  Optional parameters: language, maxResults, pageToken, resultsAbove, returnTopIfAbsent
  
  Lists the scores in a leaderboard around (and including) a player's score."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:timeSpan :leaderboardId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/window/{collection}"
     #{:timeSpan :leaderboardId :collection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "https://developers.google.com/games/services/api/reference/rest/v1/scores/submit
  
  Required parameters: leaderboardId, score
  
  Optional parameters: language, scoreTag
  
  Submits a score to the specified leaderboard."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:leaderboardId :score})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/scores"
     #{:leaderboardId :score}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn submitMultiple$
  "https://developers.google.com/games/services/api/reference/rest/v1/scores/submitMultiple
  
  Required parameters: none
  
  Optional parameters: language
  
  Body: 
  
  {:kind string,
   :scores [{:kind string,
             :leaderboardId string,
             :score string,
             :scoreTag string,
             :signature string}]}
  
  Submits multiple scores to leaderboards."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/scores"
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
