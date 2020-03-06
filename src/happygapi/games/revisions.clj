(ns happygapi.games.revisions
  "Google Play Game Services API: revisions.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/revisions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn check$
  "https://developers.google.com/games/services/api/reference/rest/v1/revisions/check
  
  Required parameters: clientRevision
  
  Optional parameters: none
  Checks whether the games client is out of date."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:clientRevision})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "revisions/check"
     #{:clientRevision}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
