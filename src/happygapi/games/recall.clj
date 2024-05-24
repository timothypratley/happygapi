(ns happygapi.games.recall
  "Google Play Game Services: recall.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/docs/reference/rest/v1/recall"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn linkPersona$
  "https://developers.google.com/games/api/reference/rest/v1/recall/linkPersona
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:sessionId string,
   :persona string,
   :token string,
   :cardinalityConstraint string,
   :conflictingLinksResolutionPolicy string,
   :expireTime string,
   :ttl string}
  
  Associate the PGS Player principal encoded in the provided recall session id with an in-game account"
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/recall:linkPersona"
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

(defn retrieveTokens$
  "https://developers.google.com/games/api/reference/rest/v1/recall/retrieveTokens
  
  Required parameters: sessionId
  
  Optional parameters: none
  
  Retrieve all Recall tokens associated with the PGS Player principal encoded in the provided recall session id. The API is only available for users that have active PGS Player profile."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sessionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/recall/tokens/{sessionId}"
     #{:sessionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lastTokenFromAllDeveloperGames$
  "https://developers.google.com/games/api/reference/rest/v1/recall/lastTokenFromAllDeveloperGames
  
  Required parameters: sessionId
  
  Optional parameters: none
  
  Retrieve the last Recall token from all developer games that is associated with the PGS Player principal encoded in the provided recall session id. The API is only available for users that have active PGS Player profile."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sessionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/recall/developerGamesLastPlayerToken/{sessionId}"
     #{:sessionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unlinkPersona$
  "https://developers.google.com/games/api/reference/rest/v1/recall/unlinkPersona
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:sessionId string, :token string, :persona string}
  
  Delete a Recall token linking the PGS Player principal identified by the Recall session and an in-game account identified either by the 'persona' or by the token value."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/recall:unlinkPersona"
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

(defn resetPersona$
  "https://developers.google.com/games/api/reference/rest/v1/recall/resetPersona
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:persona string}
  
  Delete all Recall tokens linking the given persona to any player (with or without a profile)."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/recall:resetPersona"
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
