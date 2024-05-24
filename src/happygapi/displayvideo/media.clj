(ns happygapi.displayvideo.media
  "Display & Video 360 API: media.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/display-video/api/reference/rest/v3/media/upload
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:resourceName string}
  
  Uploads media. Upload is supported on the URI `/upload/media/{resource_name=**}?upload_type=media.` **Note**: Upload requests will not be successful without including `upload_type=media` query string."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "media/{+resourceName}"
     #{:resourceName}
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

(defn download$
  "https://developers.google.com/display-video/api/reference/rest/v3/media/download
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Downloads media. Download is supported on the URI `/download/{resource_name=**}?alt=media.` **Note**: Download requests will not be successful without including `alt=media` query string."
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
