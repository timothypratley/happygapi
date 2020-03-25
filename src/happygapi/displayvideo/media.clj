(ns happygapi.displayvideo.media
  "Display & Video 360 API: media.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/display-video/api/reference/rest/v1/media/download
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Downloads media. Download is supported on the URI `/download/{resource_name=**}?alt=media.`
  
  **Note**: Download requests will not be successful without including `alt=media` query string."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "download/{+resourceName}"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
