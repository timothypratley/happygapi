(ns happygapi.games.rooms
  "Google Play Game Services API: rooms.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/rooms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/create
  
  Required parameters: none
  
  Optional parameters: language
  
  Body: 
  
  {:autoMatchingCriteria {:exclusiveBitmask string,
                          :kind string,
                          :maxAutoMatchingPlayers integer,
                          :minAutoMatchingPlayers integer},
   :capabilities [string],
   :clientAddress {:kind string, :xmppAddress string},
   :invitedPlayerIds [string],
   :kind string,
   :networkDiagnostics {:androidNetworkSubtype integer,
                        :androidNetworkType integer,
                        :iosNetworkType integer,
                        :kind string,
                        :networkOperatorCode string,
                        :networkOperatorName string,
                        :registrationLatencyMillis integer},
   :requestId string,
   :variant integer}
  
  Create a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/create"
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

(defn decline$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/decline
  
  Required parameters: roomId
  
  Optional parameters: language
  
  Decline an invitation to join a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}/decline"
     #{:roomId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dismiss$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/dismiss
  
  Required parameters: roomId
  
  Optional parameters: none
  
  Dismiss an invitation to join a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}/dismiss"
     #{:roomId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/get
  
  Required parameters: roomId
  
  Optional parameters: language
  
  Get the data for a room."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}"
     #{:roomId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn join$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/join
  
  Required parameters: roomId
  
  Optional parameters: language
  
  Body: 
  
  {:capabilities [string],
   :clientAddress {:kind string, :xmppAddress string},
   :kind string,
   :networkDiagnostics {:androidNetworkSubtype integer,
                        :androidNetworkType integer,
                        :iosNetworkType integer,
                        :kind string,
                        :networkOperatorCode string,
                        :networkOperatorName string,
                        :registrationLatencyMillis integer}}
  
  Join a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}/join"
     #{:roomId}
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

(defn leave$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/leave
  
  Required parameters: roomId
  
  Optional parameters: language
  
  Body: 
  
  {:kind string,
   :leaveDiagnostics {:androidNetworkSubtype integer,
                      :androidNetworkType integer,
                      :iosNetworkType integer,
                      :kind string,
                      :networkOperatorCode string,
                      :networkOperatorName string,
                      :peerSession [PeerSessionDiagnostics],
                      :socketsUsed boolean},
   :reason string}
  
  Leave a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}/leave"
     #{:roomId}
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
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/list
  
  Required parameters: none
  
  Optional parameters: language, maxResults, pageToken
  
  Returns invitations to join rooms."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reportStatus$
  "https://developers.google.com/games/services/api/reference/rest/v1/rooms/reportStatus
  
  Required parameters: roomId
  
  Optional parameters: language
  
  Body: 
  
  {:kind string,
   :updates [{:connectionSetupLatencyMillis integer,
              :error string,
              :error_reason string,
              :kind string,
              :participantId string,
              :status string,
              :unreliableRoundtripLatencyMillis integer}]}
  
  Updates sent by a client reporting the status of peers in a room. For internal use by the Games SDK only. Calling this method directly is unsupported."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:roomId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "rooms/{roomId}/reportstatus"
     #{:roomId}
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
