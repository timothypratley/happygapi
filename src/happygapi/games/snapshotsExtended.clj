(ns happygapi.games.snapshotsExtended
  "Google Play Game Services: snapshotsExtended.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/snapshotsExtended"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn resolveSnapshotHead$
  "https://developers.google.com/games/api/reference/rest/v1/snapshotsExtended/resolveSnapshotHead
  
  Required parameters: snapshotName
  
  Optional parameters: none
  
  Body: 
  
  {:resolutionPolicy string}
  
  Resolves any potential conflicts according to the resolution policy specified in the request and returns the snapshot head after the resolution."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:snapshotName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/snapshotsExtended/{snapshotName}:resolveHead"
     #{:snapshotName}
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
