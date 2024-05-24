(ns happygapi.translate.projects
  "Cloud Translation API: projects.
  Integrates text translation into your website or application.
  See: https://cloud.google.com/translate/docs/quickstartsdocs/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn translateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/translateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contents [string],
   :mimeType string,
   :sourceLanguageCode string,
   :targetLanguageCode string,
   :model string,
   :glossaryConfig {:glossary string, :ignoreCase boolean},
   :transliterationConfig {:enableTransliteration boolean},
   :labels {}}
  
  Translates input text and returns translated text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:translateText"
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

(defn romanizeText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/romanizeText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contents [string], :sourceLanguageCode string}
  
  Romanize input text written in non-Latin scripts to Latin text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:romanizeText"
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

(defn detectLanguage$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/detectLanguage
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:model string, :content string, :mimeType string, :labels {}}
  
  Detects the language of text within a request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:detectLanguage"
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

(defn getSupportedLanguages$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/getSupportedLanguages
  
  Required parameters: parent
  
  Optional parameters: displayLanguageCode, model
  
  Returns a list of supported languages for translation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/supportedLanguages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-translateDocument$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/translateDocument
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :enableRotationCorrection boolean,
   :sourceLanguageCode string,
   :glossaryConfig {:glossary string, :ignoreCase boolean},
   :enableShadowRemovalNativePdf boolean,
   :documentInputConfig {:content string,
                         :gcsSource GcsSource,
                         :mimeType string},
   :isTranslateNativePdfOnly boolean,
   :customizedAttribution string,
   :documentOutputConfig {:gcsDestination GcsDestination,
                          :mimeType string},
   :targetLanguageCode string,
   :model string}
  
  Translates documents in synchronous mode."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:translateDocument"
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

(defn locations-getSupportedLanguages$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/getSupportedLanguages
  
  Required parameters: parent
  
  Optional parameters: displayLanguageCode, model
  
  Returns a list of supported languages for translation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/supportedLanguages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-translateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/translateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contents [string],
   :mimeType string,
   :sourceLanguageCode string,
   :targetLanguageCode string,
   :model string,
   :glossaryConfig {:glossary string, :ignoreCase boolean},
   :transliterationConfig {:enableTransliteration boolean},
   :labels {}}
  
  Translates input text and returns translated text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:translateText"
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

(defn locations-batchTranslateDocument$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/batchTranslateDocument
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:enableRotationCorrection boolean,
   :sourceLanguageCode string,
   :enableShadowRemovalNativePdf boolean,
   :inputConfigs [{:gcsSource GcsSource}],
   :outputConfig {:gcsDestination GcsDestination},
   :targetLanguageCodes [string],
   :customizedAttribution string,
   :models {},
   :formatConversions {},
   :glossaries {}}
  
  Translates a large volume of document in asynchronous batch mode. This function provides real-time output as the inputs are being processed. If caller cancels a request, the partial results (for an input file, it's all or nothing) may still be available on the specified output location. This call returns immediately and you can use google.longrunning.Operation.name to poll the status of the call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:batchTranslateDocument"
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

(defn locations-detectLanguage$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/detectLanguage
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:model string, :content string, :mimeType string, :labels {}}
  
  Detects the language of text within a request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:detectLanguage"
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

(defn locations-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-romanizeText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/romanizeText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contents [string], :sourceLanguageCode string}
  
  Romanize input text written in non-Latin scripts to Latin text."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:romanizeText"
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

(defn locations-batchTranslateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/batchTranslateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:sourceLanguageCode string,
   :targetLanguageCodes [string],
   :models {},
   :inputConfigs [{:mimeType string, :gcsSource GcsSource}],
   :outputConfig {:gcsDestination GcsDestination},
   :glossaries {},
   :labels {}}
  
  Translates a large volume of text in asynchronous batch mode. This function provides real-time output as the inputs are being processed. If caller cancels a request, the partial results (for an input file, it's all or nothing) may still be available on the specified output location. This call returns immediately and you can use google.longrunning.Operation.name to poll the status of the call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:batchTranslateText"
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

(defn locations-adaptiveMtTranslate$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtTranslate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dataset string, :content [string]}
  
  Translate text using Adaptive MT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:adaptiveMtTranslate"
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
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}/operations"
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
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}:cancel"
     #{:name}
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

(defn locations-operations-wait$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/wait
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timeout string}
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}:wait"
     #{:name}
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

(defn locations-glossaries-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :languagePair {:sourceLanguageCode string,
                  :targetLanguageCode string},
   :languageCodesSet {:languageCodes [string]},
   :inputConfig {:gcsSource GcsSource},
   :entryCount integer,
   :submitTime string,
   :endTime string,
   :displayName string}
  
  Creates a glossary and returns the long-running operation. Returns NOT_FOUND, if the project doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/glossaries"
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

(defn locations-glossaries-patch$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :languagePair {:sourceLanguageCode string,
                  :targetLanguageCode string},
   :languageCodesSet {:languageCodes [string]},
   :inputConfig {:gcsSource GcsSource},
   :entryCount integer,
   :submitTime string,
   :endTime string,
   :displayName string}
  
  Updates a glossary. A LRO is used since the update can be async if the glossary's entry file is updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
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

(defn locations-glossaries-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists glossaries in a project. Returns NOT_FOUND, if the project doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/glossaries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-glossaries-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a glossary. Returns NOT_FOUND, if the glossary doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-glossaries-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a glossary, or cancels glossary construction if the glossary isn't created yet. Returns NOT_FOUND, if the glossary doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-glossaries-glossaryEntries-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/glossaryEntries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single glossary entry by the given id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-glossaries-glossaryEntries-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/glossaryEntries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the entries for the glossary."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/glossaryEntries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-glossaries-glossaryEntries-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/glossaryEntries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :termsPair {:sourceTerm GlossaryTerm, :targetTerm GlossaryTerm},
   :termsSet {:terms [GlossaryTerm]},
   :description string}
  
  Creates a glossary entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/glossaryEntries"
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

(defn locations-glossaries-glossaryEntries-patch$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/glossaryEntries/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :termsPair {:sourceTerm GlossaryTerm, :targetTerm GlossaryTerm},
   :termsSet {:terms [GlossaryTerm]},
   :description string}
  
  Updates a glossary entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
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

(defn locations-glossaries-glossaryEntries-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/glossaryEntries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single entry from the glossary"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:validateExampleCount integer,
   :sourceLanguageCode string,
   :displayName string,
   :name string,
   :trainExampleCount integer,
   :createTime string,
   :exampleCount integer,
   :updateTime string,
   :targetLanguageCode string,
   :testExampleCount integer}
  
  Creates a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/datasets"
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

(defn locations-datasets-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists datasets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/datasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a dataset and all of its contents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-datasets-importData$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/importData
  
  Required parameters: dataset
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:inputFiles [InputFile]}}
  
  Import sentence pairs into translation Dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:dataset})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+dataset}:importData"
     #{:dataset}
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

(defn locations-datasets-exportData$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/exportData
  
  Required parameters: dataset
  
  Optional parameters: none
  
  Body: 
  
  {:outputConfig {:gcsDestination GcsOutputDestination}}
  
  Exports dataset's data to the provided output location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:dataset})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+dataset}:exportData"
     #{:dataset}
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

(defn locations-datasets-examples-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/datasets/examples/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists sentence pairs in the dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/examples"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :sourceLanguageCode string,
   :targetLanguageCode string,
   :exampleCount integer,
   :createTime string,
   :updateTime string}
  
  Creates an Adaptive MT dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/adaptiveMtDatasets"
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

(defn locations-adaptiveMtDatasets-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Adaptive MT dataset, including all its entries and associated metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Adaptive MT dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all Adaptive MT datasets for which the caller has read permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/adaptiveMtDatasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-importAdaptiveMtFile$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/importAdaptiveMtFile
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:fileInputSource {:mimeType string,
                     :content string,
                     :displayName string},
   :gcsInputSource {:inputUri string}}
  
  Imports an AdaptiveMtFile and adds all of its sentences into the AdaptiveMtDataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}:importAdaptiveMtFile"
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

(defn locations-adaptiveMtDatasets-adaptiveMtFiles-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/adaptiveMtFiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets and AdaptiveMtFile"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-adaptiveMtFiles-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/adaptiveMtFiles/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an AdaptiveMtFile along with its sentences."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-adaptiveMtFiles-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/adaptiveMtFiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all AdaptiveMtFiles associated to an AdaptiveMtDataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/adaptiveMtFiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-adaptiveMtFiles-adaptiveMtSentences-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/adaptiveMtFiles/adaptiveMtSentences/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all AdaptiveMtSentences under a given file/dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/adaptiveMtSentences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-adaptiveMtDatasets-adaptiveMtSentences-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/adaptiveMtDatasets/adaptiveMtSentences/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all AdaptiveMtSentences under a given file/dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/adaptiveMtSentences"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/models/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:validateExampleCount integer,
   :sourceLanguageCode string,
   :displayName string,
   :name string,
   :trainExampleCount integer,
   :createTime string,
   :updateTime string,
   :targetLanguageCode string,
   :dataset string,
   :testExampleCount integer}
  
  Creates a Model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/models"
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

(defn locations-models-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/models/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists models."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+parent}/models"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-get$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/models/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-models-delete$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/models/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-translation"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://translation.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
