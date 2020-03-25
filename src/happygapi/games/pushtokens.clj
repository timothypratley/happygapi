(ns happygapi.games.pushtokens
  "Google Play Game Services API: pushtokens.
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/api/reference/rest/v1/pushtokens"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn remove$
  "https://developers.google.com/games/services/api/reference/rest/v1/pushtokens/remove
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:ios {:apns_device_token string, :apns_environment string},
   :kind string}
  
  Removes a push token for the current user and application. Removing a non-existent push token will report success."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "pushtokens/remove"
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

(defn update$
  "https://developers.google.com/games/services/api/reference/rest/v1/pushtokens/update
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:clientRevision string,
   :id {:ios {:apns_device_token string, :apns_environment string},
        :kind string},
   :kind string,
   :language string}
  
  Registers a push token for the current user and application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "pushtokens"
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
