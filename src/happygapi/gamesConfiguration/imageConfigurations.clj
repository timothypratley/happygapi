(ns happygapi.gamesConfiguration.imageConfigurations
  "Google Play Game Services Publishing API: imageConfigurations.
  The Publishing API for Google Play Game Services.
  See: https://developers.google.com/games/servicesapi/reference/rest/v1configuration/imageConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/games/servicesapi/reference/rest/v1configuration/imageConfigurations/upload
  
  Required parameters: resourceId, imageType
  
  Optional parameters: none
  Uploads an image for a resource with the given ID and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:imageType :resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/games/v1configuration/"
     "images/{resourceId}/imageType/{imageType}"
     #{:imageType :resourceId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
