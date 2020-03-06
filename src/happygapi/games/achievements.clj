(ns happygapi.games.achievements
  "Google Play Game Services API: achievements.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/achievements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn increment$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/increment
  
  Required parameters: achievementId, stepsToIncrement
  
  Optional parameters: requestId
  Increments the steps of the achievement with the given ID for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId :stepsToIncrement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/increment"
     #{:achievementId :stepsToIncrement}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/list
  
  Required parameters: playerId
  
  Optional parameters: language, maxResults, pageToken, state
  Lists the progress for all your application's achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/achievements"
     #{:playerId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reveal$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/reveal
  
  Required parameters: achievementId
  
  Optional parameters: none
  Sets the state of the achievement with the given ID to REVEALED for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/reveal"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setStepsAtLeast$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/setStepsAtLeast
  
  Required parameters: achievementId, steps
  
  Optional parameters: none
  Sets the steps for the currently authenticated player towards unlocking an achievement. If the steps parameter is less than the current number of steps that the player already gained for the achievement, the achievement is not modified."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId :steps})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/setStepsAtLeast"
     #{:achievementId :steps}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn unlock$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/unlock
  
  Required parameters: achievementId
  
  Optional parameters: builtinGameId
  Unlocks this achievement for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/unlock"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateMultiple$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievements/updateMultiple
  
  Required parameters: none
  
  Optional parameters: builtinGameId
  
  Body: 
  
  {:kind string,
   :updates [{:achievementId string,
              :incrementPayload GamesAchievementIncrement,
              :kind string,
              :setStepsAtLeastPayload GamesAchievementSetStepsAtLeast,
              :updateType string}]}
  
  Updates multiple achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/updateMultiple"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
