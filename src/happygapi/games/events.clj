(ns happygapi.games.events
  "Google Play Game Services: events.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/events"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn record$
  "https://developers.google.com/games/api/reference/rest/v1/events/record
  
  Required parameters: none
  
  Optional parameters: language
  
  Body: 
  
  {:currentTimeMillis string,
   :requestId string,
   :timePeriods [{:kind string,
                  :updates [EventUpdateRequest],
                  :timePeriod EventPeriodRange}],
   :kind string}
  
  Records a batch of changes to the number of times events have occurred for the currently authenticated user of this application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/events"
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

(defn listDefinitions$
  "https://developers.google.com/games/api/reference/rest/v1/events/listDefinitions
  
  Required parameters: none
  
  Optional parameters: pageToken, language, maxResults
  
  Returns a list of the event definitions in this application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/eventDefinitions"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listByPlayer$
  "https://developers.google.com/games/api/reference/rest/v1/events/listByPlayer
  
  Required parameters: none
  
  Optional parameters: pageToken, maxResults, language
  
  Returns a list showing the current progress on events in this application for the currently authenticated user."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/events"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
