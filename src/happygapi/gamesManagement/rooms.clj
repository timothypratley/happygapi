(ns happygapi.gamesManagement.rooms
  "Google Play Game Services Management API: rooms.
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1management/rooms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reset$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/rooms/reset
  
  Required parameters: none
  
  Optional parameters: none
  Reset all rooms for the currently authenticated player for your application. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "rooms/reset"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetForAllPlayers$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/rooms/resetForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  Deletes rooms where the only room participants are from whitelisted tester accounts for your application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "rooms/resetForAllPlayers"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
