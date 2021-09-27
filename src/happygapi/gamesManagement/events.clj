(ns happygapi.gamesManagement.events
  "Google Play Game Management: events.
  The Google Play Game Management API allows developers to manage resources from the Google Play Game service.
  See: https://developers.google.com/games/api/reference/rest/v1management/events"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn resetForAllPlayers$
  "https://developers.google.com/games/api/reference/rest/v1management/events/resetForAllPlayers
  
  Required parameters: eventId
  
  Optional parameters: none
  
  Resets the event with the given ID for all players. This method is only available to user accounts for your developer console. Only draft events can be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:eventId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/events/{eventId}/resetForAllPlayers"
     #{:eventId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reset$
  "https://developers.google.com/games/api/reference/rest/v1management/events/reset
  
  Required parameters: eventId
  
  Optional parameters: none
  
  Resets all player progress on the event with the given ID for the currently authenticated player. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:eventId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/events/{eventId}/reset"
     #{:eventId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAllForAllPlayers$
  "https://developers.google.com/games/api/reference/rest/v1management/events/resetAllForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets all draft events for all players. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/events/resetAllForAllPlayers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetAll$
  "https://developers.google.com/games/api/reference/rest/v1management/events/resetAll
  
  Required parameters: none
  
  Optional parameters: none
  
  Resets all player progress on all events for the currently authenticated player. This method is only accessible to whitelisted tester accounts for your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/events/reset"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetMultipleForAllPlayers$
  "https://developers.google.com/games/api/reference/rest/v1management/events/resetMultipleForAllPlayers
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :event_ids [string]}
  
  Resets events with the given IDs for all players. This method is only available to user accounts for your developer console. Only draft events may be reset."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesmanagement.googleapis.com/"
     "games/v1management/events/resetMultipleForAllPlayers"
     #{}
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
