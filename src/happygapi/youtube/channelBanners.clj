(ns happygapi.youtube.channelBanners
  "YouTube Data API: channelBanners.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/channelBanners"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/channelBanners/insert
  
  Required parameters: none
  
  Optional parameters: channelId, onBehalfOfContentOwner
  
  Body: 
  
  {:etag string, :kind string, :url string}
  
  Uploads a channel banner image to YouTube. This method represents the first two steps in a three-step process to update the banner image for a channel:
  
  - Call the channelBanners.insert method to upload the binary image data to YouTube. The image must have a 16:9 aspect ratio and be at least 2120x1192 pixels.
  - Extract the url property's value from the response that the API returns for step 1.
  - Call the channels.update method to update the channel's branding settings. Set the brandingSettings.image.bannerExternalUrl property's value to the URL obtained in step 2."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "channelBanners/insert"
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
