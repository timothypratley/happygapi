(ns happygapi.games.achievementDefinitions
  "Google Play Game Services API: achievementDefinitions.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/achievementDefinitions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/achievementDefinitions/list
  
  Required parameters: none
  
  Optional parameters: language, maxResults, pageToken
  
  Lists all the achievement definitions for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "achievements"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
