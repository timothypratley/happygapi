(ns happygapi.keep.media
  "Google Keep API: media.
  The Google Keep API is used in an enterprise environment to manage Google Keep content and resolve issues identified by cloud security software.
  See: https://developers.google.com/keep/apidocs/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/keep/apiapi/reference/rest/v1/media/download
  
  Required parameters: name
  
  Optional parameters: mimeType
  
  Gets an attachment. To download attachment media via REST requires the alt=media query parameter. Returns a 400 bad request error if attachment media is not available in the requested MIME type."
  {:scopes ["https://www.googleapis.com/auth/keep"
            "https://www.googleapis.com/auth/keep.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://keep.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
