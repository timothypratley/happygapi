(ns happygapi.gamesManagement.applications
  "Google Play Game Services Management API
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "gamesManagement_schema.edn"))))

(defn listHidden$
  "Required parameters: applicationId
  
  Optional parameters: maxResults, pageToken
  
  Get the list of players hidden from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth args]
  {:pre [(util/has-keys? args #{"applicationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden"
     #{"applicationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
