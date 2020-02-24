(ns happygapi.gamesManagement.applications
  "Google Play Game Services Management API
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/services"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn listHidden$
  "Required parameters: applicationId
  
  Get the list of players hidden from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden"
     #{"applicationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
