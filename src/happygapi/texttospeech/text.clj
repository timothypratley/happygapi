(ns happygapi.texttospeech.text
  "Cloud Text-to-Speech API
  Synthesizes natural-sounding speech by applying powerful neural network models.
  See: https://cloud.google.com/text-to-speech/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn synthesize$
  "Required parameters: none
  
  Synthesizes speech synchronously: receive results after all text input
  has been processed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://texttospeech.googleapis.com/"
     "v1/text:synthesize"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
