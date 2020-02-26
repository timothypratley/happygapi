(ns happygapi.games.scores
  "Google Play Game Services API
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "games_schema.edn"))))

(defn get$
  "Required parameters: leaderboardId, playerId, timeSpan
  
  Optional parameters: includeRankType, language, maxResults, pageToken
  
  Get high scores, and optionally ranks, in leaderboards for the currently authenticated player. For a specific time span, leaderboardId can be set to ALL to retrieve data for all leaderboards in a given time span.
  NOTE: You cannot ask for 'ALL' leaderboards and 'ALL' timeSpans in the same request; only one parameter may be set to 'ALL'."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"timeSpan" "playerId" "leaderboardId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/leaderboards/{leaderboardId}/scores/{timeSpan}"
     #{"timeSpan" "playerId" "leaderboardId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: collection, leaderboardId, timeSpan
  
  Optional parameters: language, maxResults, pageToken
  
  Lists the scores in a leaderboard, starting from the top."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"timeSpan" "collection" "leaderboardId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/scores/{collection}"
     #{"collection" "leaderboardId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listWindow$
  "Required parameters: collection, leaderboardId, timeSpan
  
  Optional parameters: language, maxResults, pageToken, resultsAbove, returnTopIfAbsent
  
  Lists the scores in a leaderboard around (and including) a player's score."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"timeSpan" "collection" "leaderboardId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/window/{collection}"
     #{"collection" "leaderboardId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "Required parameters: leaderboardId, score
  
  Optional parameters: language, scoreTag
  
  Submits a score to the specified leaderboard."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"score" "leaderboardId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}/scores"
     #{"leaderboardId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn submitMultiple$
  "Required parameters: none
  
  Optional parameters: language
  
  Submits multiple scores to leaderboards."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/scores"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
