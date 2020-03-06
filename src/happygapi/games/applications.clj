(ns happygapi.games.applications
  "Google Play Game Services API: applications.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/applications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/games/services/api/reference/rest/v1/applications/get
  
  Required parameters: applicationId
  
  Optional parameters: language, platformType
  Retrieves the metadata of the application with the given ID. If the requested application is not available for the specified platformType, the returned response will not include any instance data."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "applications/{applicationId}"
     #{:applicationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn played$
  "https://developers.google.com/games/services/api/reference/rest/v1/applications/played
  
  Required parameters: none
  
  Optional parameters: builtinGameId
  Indicate that the the currently authenticated user is playing your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "applications/played"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn verify$
  "https://developers.google.com/games/services/api/reference/rest/v1/applications/verify
  
  Required parameters: applicationId
  
  Optional parameters: none
  Verifies the auth token provided with this request is for the application with the specified ID, and returns the ID of the player it was granted for."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "applications/{applicationId}/verify"
     #{:applicationId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
