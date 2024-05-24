(ns happygapi.chat.media
  "Google Chat API: media.
  The Google Chat API lets you build Chat apps to integrate your services with Google Chat and manage Chat resources such as spaces, members, and messages.
  See: https://developers.google.com/hangouts/chatdocs/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/media/download
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Downloads media. Download is supported on the URI `/v1/media/{+name}?alt=media`."
  {:scopes ["https://www.googleapis.com/auth/chat.bot"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.readonly"]}
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

(defn upload$
  "https://developers.google.com/hangouts/chatapi/reference/rest/v1/media/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filename string}
  
  Uploads an attachment. For an example, see [Upload media as a file attachment](https://developers.google.com/workspace/chat/upload-media-attachments). Requires user [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user). You can upload attachments up to 200 MB. Certain file types aren't supported. For details, see [File types blocked by Google Chat](https://support.google.com/chat/answer/7651457?&co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat)."
  {:scopes ["https://www.googleapis.com/auth/chat.import"
            "https://www.googleapis.com/auth/chat.messages"
            "https://www.googleapis.com/auth/chat.messages.create"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chat.googleapis.com/"
     "v1/{+parent}/attachments:upload"
     #{:parent}
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
