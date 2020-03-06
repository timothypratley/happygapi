(ns happygapi.games.metagame
  "Google Play Game Services API: metagame.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/metagame"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getMetagameConfig$
  "https://developers.google.com/games/services/api/reference/rest/v1/metagame/getMetagameConfig
  
  Required parameters: none
  
  Optional parameters: none
  Return the metagame configuration data for the calling application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "metagameConfig"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listCategoriesByPlayer$
  "https://developers.google.com/games/services/api/reference/rest/v1/metagame/listCategoriesByPlayer
  
  Required parameters: collection, playerId
  
  Optional parameters: language, maxResults, pageToken
  List play data aggregated per category for the player corresponding to playerId."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:playerId :collection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/categories/{collection}"
     #{:playerId :collection}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
