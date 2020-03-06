(ns happygapi.gamesManagement.achievements
  "Google Play Game Services Management API: achievements.
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reset$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements/reset
  
  Required parameters: achievementId
  
  Optional parameters: none
  Resets the achievement with the given ID for the currently authenticated player. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "achievements/{achievementId}/reset"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetAll$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements/resetAll
  
  Required parameters: none
  
  Optional parameters: none
  Resets all achievements for the currently authenticated player for your application. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "achievements/reset"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetAllForAllPlayers$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements/resetAllForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  Resets all draft achievements for all players. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "achievements/resetAllForAllPlayers"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetForAllPlayers$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements/resetForAllPlayers
  
  Required parameters: achievementId
  
  Optional parameters: none
  Resets the achievement with the given ID for all players. This method is only available to user accounts for your developer console. Only draft achievements can be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:achievementId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "achievements/{achievementId}/resetForAllPlayers"
     #{:achievementId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetMultipleForAllPlayers$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/achievements/resetMultipleForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:achievement_ids [string], :kind string}
  
  Resets achievements with the given IDs for all players. This method is only available to user accounts for your developer console. Only draft achievements may be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "achievements/resetMultipleForAllPlayers"
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
