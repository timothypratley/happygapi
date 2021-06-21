(ns happygapi.texttospeech.text
  "Cloud Text-to-Speech API: text.
  Synthesizes natural-sounding speech by applying powerful neural network models.
  See: https://cloud.google.com/text-to-speech/api/reference/rest/v1/text"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn synthesize$
  "https://cloud.google.com/text-to-speech/api/reference/rest/v1/text/synthesize
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:audioConfig {:effectsProfileId [string],
                 :speakingRate number,
                 :volumeGainDb number,
                 :pitch number,
                 :sampleRateHertz integer,
                 :audioEncoding string},
   :input {:text string, :ssml string},
   :voice {:languageCode string, :ssmlGender string, :name string}}
  
  Synthesizes speech synchronously: receive results after all text input has been processed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://texttospeech.googleapis.com/"
     "v1/text:synthesize"
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
