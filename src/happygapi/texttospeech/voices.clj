(ns happygapi.texttospeech.voices
  "Cloud Text-to-Speech API: voices.
  Synthesizes natural-sounding speech by applying powerful neural network models.
  See: https://cloud.google.com/text-to-speech/api/reference/rest/v1/voices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/text-to-speech/api/reference/rest/v1/voices/list
  
  Required parameters: none
  
  Optional parameters: languageCode
  
  Returns a list of Voice supported for synthesis."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://texttospeech.googleapis.com/"
     "v1/voices"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
