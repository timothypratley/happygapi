(ns happygapi.gamesManagement.players
  "Google Play Game Services Management API
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "gamesManagement_schema.edn"))))

(defn hide$
  "Required parameters: applicationId, playerId
  
  Optional parameters: none
  
  Hide the given player's leaderboard scores from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"applicationId" "playerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden/{playerId}"
     #{"applicationId" "playerId"}
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

(defn unhide$
  "Required parameters: applicationId, playerId
  
  Optional parameters: none
  
  Unhide the given player's leaderboard scores from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationId" "playerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden/{playerId}"
     #{"applicationId" "playerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
