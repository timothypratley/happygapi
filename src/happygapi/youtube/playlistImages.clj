(ns happygapi.youtube.playlistImages
  "YouTube Data API v3: playlistImages.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/playlistImages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistImages/insert
  
  Required parameters: none
  
  Optional parameters: part, onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Body: 
  
  {:kind string,
   :snippet {:height integer,
             :width integer,
             :playlistId string,
             :type string},
   :id string}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistImages"
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

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistImages/delete
  
  Required parameters: none
  
  Optional parameters: id, onBehalfOfContentOwner
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistImages"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistImages/list
  
  Required parameters: none
  
  Optional parameters: maxResults, onBehalfOfContentOwnerChannel, part, onBehalfOfContentOwner, pageToken, parent
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistImages"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistImages/update
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner, part
  
  Body: 
  
  {:kind string,
   :snippet {:height integer,
             :width integer,
             :playlistId string,
             :type string},
   :id string}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistImages"
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
