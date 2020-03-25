(ns happygapi.games.turnBasedMatches
  "Google Play Game Services API: turnBasedMatches.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/get
  
  Required parameters: matchId
  
  Optional parameters: includeMatchData, language
  
  Get the data for a turn-based match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/create
  
  Required parameters: none
  
  Optional parameters: language
  
  Body: 
  
  {:autoMatchingCriteria {:exclusiveBitmask string,
                          :kind string,
                          :maxAutoMatchingPlayers integer,
                          :minAutoMatchingPlayers integer},
   :invitedPlayerIds [string],
   :kind string,
   :requestId string,
   :variant integer}
  
  Create a turn-based match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/create"
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

(defn dismiss$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/dismiss
  
  Required parameters: matchId
  
  Optional parameters: none
  
  Dismiss a turn-based match from the match list. The match will no longer show up in the list and will not generate notifications."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/dismiss"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn decline$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/decline
  
  Required parameters: matchId
  
  Optional parameters: language
  
  Decline an invitation to play a turn-based match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/decline"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sync$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/sync
  
  Required parameters: none
  
  Optional parameters: includeMatchData, language, maxCompletedMatches, maxResults, pageToken
  
  Returns turn-based matches the player is or was involved in that changed since the last sync call, with the least recent changes coming first. Matches that should be removed from the local cache will have a status of MATCH_DELETED."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/sync"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn leaveTurn$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/leaveTurn
  
  Required parameters: matchId, matchVersion
  
  Optional parameters: language, pendingParticipantId
  
  Leave a turn-based match during the current player's turn, without canceling the match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchVersion :matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/leaveTurn"
     #{:matchVersion :matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn finish$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/finish
  
  Required parameters: matchId
  
  Optional parameters: language
  
  Body: 
  
  {:data {:data string, :kind string},
   :kind string,
   :matchVersion integer,
   :results [{:kind string,
              :participantId string,
              :placing integer,
              :result string}]}
  
  Finish a turn-based match. Each player should make this call once, after all results are in. Only the player whose turn it is may make the first call to Finish, and can pass in the final match state."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/finish"
     #{:matchId}
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

(defn list$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/list
  
  Required parameters: none
  
  Optional parameters: includeMatchData, language, maxCompletedMatches, maxResults, pageToken
  
  Returns turn-based matches the player is or was involved in."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn leave$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/leave
  
  Required parameters: matchId
  
  Optional parameters: language
  
  Leave a turn-based match when it is not the current player's turn, without canceling the match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/leave"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn takeTurn$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/takeTurn
  
  Required parameters: matchId
  
  Optional parameters: language
  
  Body: 
  
  {:data {:data string, :kind string},
   :kind string,
   :matchVersion integer,
   :pendingParticipantId string,
   :results [{:kind string,
              :participantId string,
              :placing integer,
              :result string}]}
  
  Commit the results of a player turn."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/turn"
     #{:matchId}
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

(defn rematch$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/rematch
  
  Required parameters: matchId
  
  Optional parameters: language, requestId
  
  Create a rematch of a match that was previously completed, with the same participants. This can be called by only one player on a match still in their list; the player must have called Finish first. Returns the newly created match; it will be the caller's turn."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/rematch"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/cancel
  
  Required parameters: matchId
  
  Optional parameters: none
  
  Cancel a turn-based match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/cancel"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn join$
  "https://developers.google.com/games/services/api/reference/rest/v1/turnBasedMatches/join
  
  Required parameters: matchId
  
  Optional parameters: language
  
  Join a turn-based match."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:matchId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "turnbasedmatches/{matchId}/join"
     #{:matchId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
