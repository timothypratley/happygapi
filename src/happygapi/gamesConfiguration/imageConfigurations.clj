(ns happygapi.gamesConfiguration.imageConfigurations
  "Google Play Game Services Publishing API: imageConfigurations.
  The Google Play Game Services Publishing API allows developers to configure their games in Game Services.
  See: https://developers.google.com/games/api/reference/rest/v1configuration/imageConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/games/api/reference/rest/v1configuration/imageConfigurations/upload
  
  Required parameters: resourceId, imageType
  
  Optional parameters: none
  
  Uploads an image for a resource with the given ID and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:imageType :resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gamesconfiguration.googleapis.com/"
     "games/v1configuration/images/{resourceId}/imageType/{imageType}"
     #{:imageType :resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
