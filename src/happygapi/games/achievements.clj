(ns happygapi.games.achievements
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

(defn increment$
  "Required parameters: achievementId, stepsToIncrement
  
  Optional parameters: requestId
  
  Increments the steps of the achievement with the given ID for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"stepsToIncrement" "achievementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/increment"
     #{"achievementId"}
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

(defn list$
  "Required parameters: playerId
  
  Optional parameters: language, maxResults, pageToken, state
  
  Lists the progress for all your application's achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"playerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/achievements"
     #{"playerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reveal$
  "Required parameters: achievementId
  
  Optional parameters: none
  
  Sets the state of the achievement with the given ID to REVEALED for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"achievementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/reveal"
     #{"achievementId"}
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

(defn setStepsAtLeast$
  "Required parameters: achievementId, steps
  
  Optional parameters: none
  
  Sets the steps for the currently authenticated player towards unlocking an achievement. If the steps parameter is less than the current number of steps that the player already gained for the achievement, the achievement is not modified."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"steps" "achievementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/setStepsAtLeast"
     #{"achievementId"}
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

(defn unlock$
  "Required parameters: achievementId
  
  Optional parameters: builtinGameId
  
  Unlocks this achievement for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"achievementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/{achievementId}/unlock"
     #{"achievementId"}
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

(defn updateMultiple$
  "Required parameters: none
  
  Optional parameters: builtinGameId
  
  Updates multiple achievements for the currently authenticated player."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements/updateMultiple"
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
