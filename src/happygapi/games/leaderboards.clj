(ns happygapi.games.leaderboards
  "Google Play Game Services API: leaderboards.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/leaderboards"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/leaderboards/get
  
  Required parameters: leaderboardId
  
  Optional parameters: language
  Retrieves the metadata of the leaderboard with the given ID."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:leaderboardId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards/{leaderboardId}"
     #{:leaderboardId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/leaderboards/list
  
  Required parameters: none
  
  Optional parameters: language, maxResults, pageToken
  Lists all the leaderboard metadata for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "leaderboards"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
