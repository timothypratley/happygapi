(ns happygapi.games.applications
  "Google Play Game Services API
  The API for Google Play Game Services.
  See: https://developers.google.com/games/services/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "games_schema.edn"))))

(defn get$
  "Required parameters: applicationId
  
  Optional parameters: language, platformType
  
  Retrieves the metadata of the application with the given ID. If the requested application is not available for the specified platformType, the returned response will not include any instance data."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "applications/{applicationId}"
     #{"applicationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn played$
  "Required parameters: none
  
  Optional parameters: builtinGameId
  
  Indicate that the the currently authenticated user is playing your application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn verify$
  "Required parameters: applicationId
  
  Optional parameters: none
  
  Verifies the auth token provided with this request is for the application with the specified ID, and returns the ID of the player it was granted for."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "applications/{applicationId}/verify"
     #{"applicationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
