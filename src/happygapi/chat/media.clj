(ns happygapi.chat.media
  "Hangouts Chat API: media.
  Enables bots to fetch information and perform actions in Hangouts Chat.
  See: https://developers.google.com/hangouts/chatapi/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/media/download
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Downloads media. Download is supported on the URI `/v1/media/{+name}?alt=media`."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/media/{+resourceName}"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
