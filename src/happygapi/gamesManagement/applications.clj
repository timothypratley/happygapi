(ns happygapi.gamesManagement.applications
  "Google Play Game Services Management API: applications.
  The Management API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1management/applications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listHidden$
  "https://developers.google.com/games/servicesapi/reference/rest/v1management/applications/listHidden
  
  Required parameters: applicationId
  
  Optional parameters: maxResults, pageToken
  
  Get the list of players hidden from the given application. This method is only available to user accounts for your developer console."
  {:scopes ["https://www.googleapis.com/auth/games"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:applicationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/games/v1management/"
     "applications/{applicationId}/players/hidden"
     #{:applicationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
