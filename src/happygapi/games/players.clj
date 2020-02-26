(ns happygapi.games.players
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
  "Required parameters: playerId
  
  Optional parameters: language
  
  Retrieves the Player resource with the given ID. To retrieve the player for the currently authenticated user, set playerId to me."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"playerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}"
     #{"playerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: collection
  
  Optional parameters: language, maxResults, pageToken
  
  Get the collection of players for the currently authenticated user."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collection"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/me/players/{collection}"
     #{"collection"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
