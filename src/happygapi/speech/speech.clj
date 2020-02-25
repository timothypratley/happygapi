(ns happygapi.speech.speech
  "Cloud Speech-to-Text API
  Converts audio to text by applying powerful neural network models.
  See: https://cloud.google.com/speech-to-text/docs/quickstart-protocol"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "speech_schema.edn"))))

(defn longrunningrecognize$
  "Required parameters: none
  
  Optional parameters: none
  
  Performs asynchronous speech recognition: receive results via the
  google.longrunning.Operations interface. Returns either an
  `Operation.error` or an `Operation.response` which contains
  a `LongRunningRecognizeResponse` message.
  For more information on asynchronous speech recognition, see the
  [how-to](https://cloud.google.com/speech-to-text/docs/async-recognize)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn recognize$
  "Required parameters: none
  
  Optional parameters: none
  
  Performs synchronous speech recognition: receive results after all audio
  has been sent and processed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
