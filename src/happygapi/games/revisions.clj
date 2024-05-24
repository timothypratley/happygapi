(ns happygapi.games.revisions
  "Google Play Game Services: revisions.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/docs/reference/rest/v1/revisions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn check$
  "https://developers.google.com/games/api/reference/rest/v1/revisions/check
  
  Required parameters: clientRevision
  
  Optional parameters: none
  
  Checks whether the games client is out of date."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:clientRevision})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/revisions/check"
     #{:clientRevision}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
