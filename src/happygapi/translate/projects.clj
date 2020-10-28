(ns happygapi.translate.projects
  "Cloud Translation API: projects.
  Integrates text translation into your website or application.
  See: https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn detectLanguage$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/detectLanguage
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:mimeType string, :content string, :labels {}, :model string}
  
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
  
  Optional parameters: model, displayLanguageCode
  
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

(defn translateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/translateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:targetLanguageCode string,
   :glossaryConfig {:ignoreCase boolean, :glossary string},
   :sourceLanguageCode string,
   :contents [string],
   :mimeType string,
   :model string,
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

(defn locations-getSupportedLanguages$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/getSupportedLanguages
  
  Required parameters: parent
  
  Optional parameters: model, displayLanguageCode
  
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

(defn locations-detectLanguage$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/detectLanguage
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:mimeType string, :content string, :labels {}, :model string}
  
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

(defn locations-batchTranslateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/batchTranslateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :models {},
   :inputConfigs [{:gcsSource GcsSource, :mimeType string}],
   :targetLanguageCodes [string],
   :glossaries {},
   :outputConfig {:gcsDestination GcsDestination},
   :sourceLanguageCode string}
  
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

(defn locations-translateText$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/translateText
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:targetLanguageCode string,
   :glossaryConfig {:ignoreCase boolean, :glossary string},
   :sourceLanguageCode string,
   :contents [string],
   :mimeType string,
   :model string,
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

(defn locations-operations-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
  
  Waits for the specified long-running operation until it is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
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

(defn locations-glossaries-create$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:gcsSource GcsSource},
   :languageCodesSet {:languageCodes [string]},
   :languagePair {:sourceLanguageCode string,
                  :targetLanguageCode string},
   :entryCount integer,
   :name string,
   :endTime string,
   :submitTime string}
  
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

(defn locations-glossaries-list$
  "https://cloud.google.com/translate/docs/quickstartsapi/reference/rest/v3/projects/locations/glossaries/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
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
