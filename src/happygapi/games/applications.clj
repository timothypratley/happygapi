(ns happygapi.games.applications
  "Google Play Game Services: applications.
  The Google Play games service allows developers to enhance games with social leaderboards, achievements, game state, sign-in with Google, and more.
  See: https://developers.google.com/games/api/reference/rest/v1/applications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/api/reference/rest/v1/applications/get
  
  Required parameters: applicationId
  
  Optional parameters: language, platformType
  
  Retrieves the metadata of the application with the given ID. If the requested application is not available for the specified `platformType`, the returned response will not include any instance data."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/applications/{applicationId}"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn played$
  "https://developers.google.com/games/api/reference/rest/v1/applications/played
  
  Required parameters: none
  
  Optional parameters: none
  
  Indicate that the currently authenticated user is playing your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/applications/played"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn verify$
  "https://developers.google.com/games/api/reference/rest/v1/applications/verify
  
  Required parameters: applicationId
  
  Optional parameters: none
  
  Verifies the auth token provided with this request is for the application with the specified ID, and returns the ID of the player it was granted for."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/applications/{applicationId}/verify"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getEndPoint$
  "https://developers.google.com/games/api/reference/rest/v1/applications/getEndPoint
  
  Required parameters: none
  
  Optional parameters: applicationId, endPointType
  
  Returns a URL for the requested end point type."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://games.googleapis.com/"
     "games/v1/applications/getEndPoint"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
