(ns happygapi.games.pushtokens
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

(defn remove$
  "Required parameters: none
  
  Optional parameters: none
  
  Removes a push token for the current user and application. Removing a non-existent push token will report success."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "pushtokens/remove"
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

(defn update$
  "Required parameters: none
  
  Optional parameters: none
  
  Registers a push token for the current user and application."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/games/v1/"
     "pushtokens"
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
