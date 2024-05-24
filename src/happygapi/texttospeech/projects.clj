(ns happygapi.texttospeech.projects
  "Cloud Text-to-Speech API: projects.
  Synthesizes natural-sounding speech by applying powerful neural network models.
  See: https://cloud.google.com/text-to-speech/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-synthesizeLongAudio$
  "https://cloud.google.com/text-to-speech/api/reference/rest/v1/projects/locations/synthesizeLongAudio
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:input {:text string, :ssml string},
   :audioConfig {:audioEncoding string,
                 :speakingRate number,
                 :pitch number,
                 :volumeGainDb number,
                 :sampleRateHertz integer,
                 :effectsProfileId [string]},
   :outputGcsUri string,
   :voice {:languageCode string,
           :name string,
           :ssmlGender string,
           :customVoice CustomVoiceParams}}
  
  Synthesizes long form text asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://texttospeech.googleapis.com/"
     "v1/{+parent}:synthesizeLongAudio"
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

(defn locations-operations-list$
  "https://cloud.google.com/text-to-speech/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://texttospeech.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/text-to-speech/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://texttospeech.googleapis.com/"
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
