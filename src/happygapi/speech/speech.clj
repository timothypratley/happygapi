(ns happygapi.speech.speech
  "Cloud Speech-to-Text API
  Converts audio to text by applying powerful neural network models.
  See: https://cloud.google.com/speech-to-text/docs/quickstart-protocol"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn recognize$
  "Required parameters: none
  
  Performs synchronous speech recognition: receive results after all audio
  has been sent and processed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/speech:recognize"
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

(defn longrunningrecognize$
  "Required parameters: none
  
  Performs asynchronous speech recognition: receive results via the
  google.longrunning.Operations interface. Returns either an
  `Operation.error` or an `Operation.response` which contains
  a `LongRunningRecognizeResponse` message.
  For more information on asynchronous speech recognition, see the
  [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://speech.googleapis.com/"
     "v1/speech:longrunningrecognize"
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
