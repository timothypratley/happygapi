(ns happygapi.games.snapshots
  "Google Play Game Services API
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: snapshotId
  
  Retrieves the metadata for a given snapshot ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"snapshotId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "snapshots/{snapshotId}"
     #{"snapshotId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: playerId
  
  Retrieves a list of snapshots created by your application for the player corresponding to the player ID."
  {:scopes ["https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"playerId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "players/{playerId}/snapshots"
     #{"playerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
