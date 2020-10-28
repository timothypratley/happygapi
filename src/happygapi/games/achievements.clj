(ns happygapi.games.achievements
  "Google Play Game Services: achievements.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/achievements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setStepsAtLeast$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/setStepsAtLeast
  
  Required parameters: steps, achievementId
  
  Optional parameters: none
  
  Sets the steps for the currently authenticated player towards unlocking an achievement. If the steps parameter is less than the current number of steps that the player already gained for the achievement, the achievement is not modified."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId :steps})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements/{achievementId}/setStepsAtLeast"
     #{:achievementId :steps}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reveal$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/reveal
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Sets the state of the achievement with the given ID to `REVEALED` for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements/{achievementId}/reveal"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/list
  
  Required parameters: playerId
  
  Optional parameters: language, maxResults, state, pageToken
  
  Lists the progress for all your application's achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}/achievements"
     #{:playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unlock$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/unlock
  
  Required parameters: achievementId
  
  Optional parameters: none
  
  Unlocks this achievement for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements/{achievementId}/unlock"
     #{:achievementId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateMultiple$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/updateMultiple
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:updates [{:kind string,
              :updateType string,
              :incrementPayload GamesAchievementIncrement,
              :achievementId string,
              :setStepsAtLeastPayload GamesAchievementSetStepsAtLeast}],
   :kind string}
  
  Updates multiple achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements/updateMultiple"
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

(defn increment$
  "https://developers.google.com/games/api/reference/rest/v1/achievements/increment
  
  Required parameters: stepsToIncrement, achievementId
  
  Optional parameters: requestId
  
  Increments the steps of the achievement with the given ID for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:achievementId :stepsToIncrement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/achievements/{achievementId}/increment"
     #{:achievementId :stepsToIncrement}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
