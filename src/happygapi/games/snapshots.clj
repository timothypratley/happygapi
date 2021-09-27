(ns happygapi.games.snapshots
  "Google Play Game Services: snapshots.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/snapshots"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/api/reference/rest/v1/snapshots/get
  
  Required parameters: snapshotId
  
  Optional parameters: language
  
  Retrieves the metadata for a given snapshot ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:snapshotId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/snapshots/{snapshotId}"
     #{:snapshotId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/games/api/reference/rest/v1/snapshots/list
  
  Required parameters: playerId
  
  Optional parameters: language, pageToken, maxResults
  
  Retrieves a list of snapshots created by your application for the player corresponding to the player ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:playerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/players/{playerId}/snapshots"
     #{:playerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
