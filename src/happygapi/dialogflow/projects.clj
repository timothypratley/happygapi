(ns happygapi.dialogflow.projects
  "Dialogflow API: projects.
  Builds conversational interfaces (for example, chatbots, and voice-powered apps and devices).
  See: https://cloud.google.com/dialogflow/api/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn operations-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn operations-cancel$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:cancel"
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
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-securitySettings-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/securitySettings/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :redactionStrategy string,
   :name string,
   :purgeDataTypes [string],
   :retentionWindowDays integer,
   :insightsExportSettings {:enableInsightsExport boolean},
   :inspectTemplate string,
   :redactionScope string,
   :deidentifyTemplate string}
  
  Create security settings in the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/securitySettings"
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

(defn locations-securitySettings-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/securitySettings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all security settings in the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/securitySettings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-securitySettings-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/securitySettings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified SecuritySettings. The returned settings may be stale by up to 1 minute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-securitySettings-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/securitySettings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :redactionStrategy string,
   :name string,
   :purgeDataTypes [string],
   :retentionWindowDays integer,
   :insightsExportSettings {:enableInsightsExport boolean},
   :inspectTemplate string,
   :redactionScope string,
   :deidentifyTemplate string}
  
  Updates the specified SecuritySettings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-securitySettings-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/securitySettings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified SecuritySettings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-validate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/validate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string}
  
  Validates the specified agent and creates or updates validation results. The agent in draft version is validated. Please call this API after the training is completed to get the complete validation results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:validate"
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

(defn locations-agents-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:advancedSettings {:loggingSettings GoogleCloudDialogflowCxV3AdvancedSettingsLoggingSettings},
   :description string,
   :securitySettings string,
   :timeZone string,
   :startFlow string,
   :defaultLanguageCode string,
   :displayName string,
   :speechToTextSettings {:enableSpeechAdaptation boolean},
   :name string,
   :supportedLanguageCodes [string],
   :enableSpellCorrection boolean,
   :enableStackdriverLogging boolean,
   :avatarUri string}
  
  Updates the specified agent. Note: You should always train flows prior to sending them queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-restore$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:restoreOption string, :agentContent string, :agentUri string}
  
  Restores the specified agent from a binary file. Replaces the current agent with a new one. Note that all existing resources in agent (e.g. intents, entity types, flows) will be removed. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: An [Empty message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty) Note: You should always train flows prior to sending them queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:restore"
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

(defn locations-agents-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:advancedSettings {:loggingSettings GoogleCloudDialogflowCxV3AdvancedSettingsLoggingSettings},
   :description string,
   :securitySettings string,
   :timeZone string,
   :startFlow string,
   :defaultLanguageCode string,
   :displayName string,
   :speechToTextSettings {:enableSpeechAdaptation boolean},
   :name string,
   :supportedLanguageCodes [string],
   :enableSpellCorrection boolean,
   :enableStackdriverLogging boolean,
   :avatarUri string}
  
  Creates an agent in the specified location. Note: You should always train flows prior to sending them queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/agents"
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

(defn locations-agents-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-export$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:environment string, :agentUri string}
  
  Exports the specified agent to a binary file. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: ExportAgentResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:export"
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

(defn locations-agents-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all agents in the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/agents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-getValidationResult$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/getValidationResult
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Gets the latest agent validation result. Agent validation is performed when ValidateAgent is called."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-intents-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/intents/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:isFallback boolean,
   :displayName string,
   :parameters [{:isList boolean,
                 :id string,
                 :redact boolean,
                 :entityType string}],
   :priority integer,
   :labels {},
   :description string,
   :trainingPhrases [{:parts [GoogleCloudDialogflowCxV3IntentTrainingPhrasePart],
                      :id string,
                      :repeatCount integer}],
   :name string}
  
  Creates an intent in the specified agent. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/intents"
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

(defn locations-agents-intents-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/intents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified intent. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-intents-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/intents/list
  
  Required parameters: parent
  
  Optional parameters: languageCode, pageToken, intentView, pageSize
  
  Returns the list of all intents in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/intents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-intents-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/intents/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified intent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-intents-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/intents/patch
  
  Required parameters: name
  
  Optional parameters: languageCode, updateMask
  
  Body: 
  
  {:isFallback boolean,
   :displayName string,
   :parameters [{:isList boolean,
                 :id string,
                 :redact boolean,
                 :entityType string}],
   :priority integer,
   :labels {},
   :description string,
   :trainingPhrases [{:parts [GoogleCloudDialogflowCxV3IntentTrainingPhrasePart],
                      :id string,
                      :repeatCount integer}],
   :name string}
  
  Updates the specified intent. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all environments in the specified Agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-environments-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-runContinuousTest$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/runContinuousTest
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Kicks off a continuous test under the specified Environment. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: RunContinuousTestMetadata - `response`: RunContinuousTestResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+environment}:runContinuousTest"
     #{:environment}
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

(defn locations-agents-environments-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :updateTime string,
   :testCasesConfig {:enablePredeploymentRun boolean,
                     :testCases [string],
                     :enableContinuousRun boolean},
   :description string,
   :versionConfigs [{:version string}],
   :name string}
  
  Updates the specified Environment. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: Environment"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-deployFlow$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/deployFlow
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:flowVersion string}
  
  Deploys a flow to the specified Environment. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: DeployFlowMetadata - `response`: DeployFlowResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+environment}:deployFlow"
     #{:environment}
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

(defn locations-agents-environments-lookupEnvironmentHistory$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/lookupEnvironmentHistory
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
  Looks up the history of the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:lookupEnvironmentHistory"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-environments-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :updateTime string,
   :testCasesConfig {:enablePredeploymentRun boolean,
                     :testCases [string],
                     :enableContinuousRun boolean},
   :description string,
   :versionConfigs [{:version string}],
   :name string}
  
  Creates an Environment in the specified Agent. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: Environment"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/environments"
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

(defn locations-agents-environments-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-deployments-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/deployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified Deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-deployments-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all deployments in the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-environments-experiments-stop$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops the specified Experiment. This rpc only changes the state of experiment from RUNNING to DONE."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:stop"
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

(defn locations-agents-environments-experiments-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Experiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-experiments-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all experiments in the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/experiments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-environments-experiments-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :variantsHistory [{:versionVariants GoogleCloudDialogflowCxV3VersionVariants,
                      :updateTime string}],
   :definition {:condition string,
                :versionVariants GoogleCloudDialogflowCxV3VersionVariants},
   :rolloutState {:stepIndex integer, :startTime string, :step string},
   :startTime string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :rolloutFailureReason string,
   :state string,
   :rolloutConfig {:failureCondition string,
                   :rolloutCondition string,
                   :rolloutSteps [GoogleCloudDialogflowCxV3RolloutConfigRolloutStep]},
   :result {:lastUpdateTime string,
            :versionMetrics [GoogleCloudDialogflowCxV3ExperimentResultVersionMetrics]},
   :lastUpdateTime string,
   :experimentLength string}
  
  Updates the specified Experiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-experiments-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :variantsHistory [{:versionVariants GoogleCloudDialogflowCxV3VersionVariants,
                      :updateTime string}],
   :definition {:condition string,
                :versionVariants GoogleCloudDialogflowCxV3VersionVariants},
   :rolloutState {:stepIndex integer, :startTime string, :step string},
   :startTime string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :rolloutFailureReason string,
   :state string,
   :rolloutConfig {:failureCondition string,
                   :rolloutCondition string,
                   :rolloutSteps [GoogleCloudDialogflowCxV3RolloutConfigRolloutStep]},
   :result {:lastUpdateTime string,
            :versionMetrics [GoogleCloudDialogflowCxV3ExperimentResultVersionMetrics]},
   :lastUpdateTime string,
   :experimentLength string}
  
  Creates an Experiment in the specified Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/experiments"
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

(defn locations-agents-environments-experiments-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified Experiment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-experiments-start$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/experiments/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts the specified Experiment. This rpc only changes the state of experiment from PENDING to RUNNING."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:start"
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

(defn locations-agents-environments-sessions-matchIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/matchIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryInput {:event GoogleCloudDialogflowCxV3EventInput,
                :dtmf GoogleCloudDialogflowCxV3DtmfInput,
                :intent GoogleCloudDialogflowCxV3IntentInput,
                :text GoogleCloudDialogflowCxV3TextInput,
                :languageCode string,
                :audio GoogleCloudDialogflowCxV3AudioInput},
   :queryParams {:currentPage string,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowCxV3SessionEntityType],
                 :payload {},
                 :webhookHeaders {},
                 :disableWebhook boolean,
                 :analyzeQueryTextSentiment boolean,
                 :flowVersions [string],
                 :geoLocation GoogleTypeLatLng,
                 :parameters {}}}
  
  Returns preliminary intent match results, doesn't change the session status."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:matchIntent"
     #{:session}
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

(defn locations-agents-environments-sessions-fulfillIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/fulfillIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:match {:parameters {},
           :intent GoogleCloudDialogflowCxV3Intent,
           :event string,
           :confidence number,
           :resolvedInput string,
           :matchType string},
   :matchIntentRequest {:queryInput GoogleCloudDialogflowCxV3QueryInput,
                        :queryParams GoogleCloudDialogflowCxV3QueryParameters},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowCxV3SynthesizeSpeechConfig,
                       :sampleRateHertz integer}}
  
  Fulfills a matched intent returned by MatchIntent. Must be called after MatchIntent, with input from MatchIntentResponse. Otherwise, the behavior is undefined."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:fulfillIntent"
     #{:session}
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

(defn locations-agents-environments-sessions-detectIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/detectIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryInput {:event GoogleCloudDialogflowCxV3EventInput,
                :dtmf GoogleCloudDialogflowCxV3DtmfInput,
                :intent GoogleCloudDialogflowCxV3IntentInput,
                :text GoogleCloudDialogflowCxV3TextInput,
                :languageCode string,
                :audio GoogleCloudDialogflowCxV3AudioInput},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowCxV3SynthesizeSpeechConfig,
                       :sampleRateHertz integer},
   :queryParams {:currentPage string,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowCxV3SessionEntityType],
                 :payload {},
                 :webhookHeaders {},
                 :disableWebhook boolean,
                 :analyzeQueryTextSentiment boolean,
                 :flowVersions [string],
                 :geoLocation GoogleTypeLatLng,
                 :parameters {}}}
  
  Processes a natural language query and returns structured, actionable data as a result. This method is not idempotent, because it may cause session entity types to be updated, which in turn might affect results of future queries. Note: Always use agent versions for production traffic. See [Versions and environments](https://cloud.google.com/dialogflow/cx/docs/concept/version)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:detectIntent"
     #{:session}
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

(defn locations-agents-environments-sessions-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-sessions-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-sessions-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all session entity types in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-environments-sessions-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:entityOverrideMode string,
   :name string,
   :entities [{:value string, :synonyms [string]}]}
  
  Updates the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-environments-sessions-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/sessions/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entityOverrideMode string,
   :name string,
   :entities [{:value string, :synonyms [string]}]}
  
  Creates a session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
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

(defn locations-agents-environments-continuousTestResults-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/environments/continuousTestResults/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Fetches a list of continuous test results for a given environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/continuousTestResults"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-sessions-fulfillIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/fulfillIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:match {:parameters {},
           :intent GoogleCloudDialogflowCxV3Intent,
           :event string,
           :confidence number,
           :resolvedInput string,
           :matchType string},
   :matchIntentRequest {:queryInput GoogleCloudDialogflowCxV3QueryInput,
                        :queryParams GoogleCloudDialogflowCxV3QueryParameters},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowCxV3SynthesizeSpeechConfig,
                       :sampleRateHertz integer}}
  
  Fulfills a matched intent returned by MatchIntent. Must be called after MatchIntent, with input from MatchIntentResponse. Otherwise, the behavior is undefined."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:fulfillIntent"
     #{:session}
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

(defn locations-agents-sessions-matchIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/matchIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryInput {:event GoogleCloudDialogflowCxV3EventInput,
                :dtmf GoogleCloudDialogflowCxV3DtmfInput,
                :intent GoogleCloudDialogflowCxV3IntentInput,
                :text GoogleCloudDialogflowCxV3TextInput,
                :languageCode string,
                :audio GoogleCloudDialogflowCxV3AudioInput},
   :queryParams {:currentPage string,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowCxV3SessionEntityType],
                 :payload {},
                 :webhookHeaders {},
                 :disableWebhook boolean,
                 :analyzeQueryTextSentiment boolean,
                 :flowVersions [string],
                 :geoLocation GoogleTypeLatLng,
                 :parameters {}}}
  
  Returns preliminary intent match results, doesn't change the session status."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:matchIntent"
     #{:session}
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

(defn locations-agents-sessions-detectIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/detectIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryInput {:event GoogleCloudDialogflowCxV3EventInput,
                :dtmf GoogleCloudDialogflowCxV3DtmfInput,
                :intent GoogleCloudDialogflowCxV3IntentInput,
                :text GoogleCloudDialogflowCxV3TextInput,
                :languageCode string,
                :audio GoogleCloudDialogflowCxV3AudioInput},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowCxV3SynthesizeSpeechConfig,
                       :sampleRateHertz integer},
   :queryParams {:currentPage string,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowCxV3SessionEntityType],
                 :payload {},
                 :webhookHeaders {},
                 :disableWebhook boolean,
                 :analyzeQueryTextSentiment boolean,
                 :flowVersions [string],
                 :geoLocation GoogleTypeLatLng,
                 :parameters {}}}
  
  Processes a natural language query and returns structured, actionable data as a result. This method is not idempotent, because it may cause session entity types to be updated, which in turn might affect results of future queries. Note: Always use agent versions for production traffic. See [Versions and environments](https://cloud.google.com/dialogflow/cx/docs/concept/version)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+session}:detectIntent"
     #{:session}
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

(defn locations-agents-sessions-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-sessions-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entityOverrideMode string,
   :name string,
   :entities [{:value string, :synonyms [string]}]}
  
  Creates a session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
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

(defn locations-agents-sessions-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:entityOverrideMode string,
   :name string,
   :entities [{:value string, :synonyms [string]}]}
  
  Updates the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-sessions-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all session entity types in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-sessions-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/sessions/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified session entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-testCases-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a test case."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-testCases-run$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:environment string}
  
  Kicks off a test case run. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: RunTestCaseMetadata - `response`: RunTestCaseResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:run"
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

(defn locations-agents-testCases-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :testConfig {:trackingParameters [string], :flow string},
   :lastTestResult {:testResult string,
                    :conversationTurns [GoogleCloudDialogflowCxV3ConversationTurn],
                    :environment string,
                    :testTime string,
                    :name string},
   :tags [string],
   :name string,
   :notes string,
   :testCaseConversationTurns [{:virtualAgentOutput GoogleCloudDialogflowCxV3ConversationTurnVirtualAgentOutput,
                                :userInput GoogleCloudDialogflowCxV3ConversationTurnUserInput}],
   :creationTime string}
  
  Updates the specified test case."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-testCases-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :testConfig {:trackingParameters [string], :flow string},
   :lastTestResult {:testResult string,
                    :conversationTurns [GoogleCloudDialogflowCxV3ConversationTurn],
                    :environment string,
                    :testTime string,
                    :name string},
   :tags [string],
   :name string,
   :notes string,
   :testCaseConversationTurns [{:virtualAgentOutput GoogleCloudDialogflowCxV3ConversationTurnVirtualAgentOutput,
                                :userInput GoogleCloudDialogflowCxV3ConversationTurnUserInput}],
   :creationTime string}
  
  Creates a test case for the given agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases"
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

(defn locations-agents-testCases-export$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/export
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsUri string, :dataFormat string, :filter string}
  
  Exports the test cases under the agent to a Cloud Storage bucket or a local file. Filter can be applied to export a subset of test cases. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: ExportTestCasesMetadata - `response`: ExportTestCasesResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases:export"
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

(defn locations-agents-testCases-batchDelete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Batch deletes test cases."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases:batchDelete"
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

(defn locations-agents-testCases-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, view, pageSize
  
  Fetches a list of test cases for a given agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-testCases-calculateCoverage$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/calculateCoverage
  
  Required parameters: agent
  
  Optional parameters: type
  
  Calculates the test coverage for an agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:agent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+agent}/testCases:calculateCoverage"
     #{:agent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-testCases-import$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsUri string, :content string}
  
  Imports the test cases from a Cloud Storage bucket or a local file. It always creates new test cases and won't overwite any existing ones. The provided ID in the imported test case is neglected. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: ImportTestCasesMetadata - `response`: ImportTestCasesResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases:import"
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

(defn locations-agents-testCases-batchRun$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/batchRun
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:testCases [string], :environment string}
  
  Kicks off a batch run of test cases. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: BatchRunTestCasesMetadata - `response`: BatchRunTestCasesResponse"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/testCases:batchRun"
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

(defn locations-agents-testCases-results-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/results/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Fetches a list of results for a given test case."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/results"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-testCases-results-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/testCases/results/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a test case result."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:redact boolean,
   :name string,
   :excludedPhrases [{:value string}],
   :entities [{:value string, :synonyms [string]}],
   :displayName string,
   :autoExpansionMode string,
   :kind string,
   :enableFuzzyExtraction boolean}
  
  Creates an entity type in the specified agent. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
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

(defn locations-agents-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes the specified entity type. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: languageCode, updateMask
  
  Body: 
  
  {:redact boolean,
   :name string,
   :excludedPhrases [{:value string}],
   :entities [{:value string, :synonyms [string]}],
   :displayName string,
   :autoExpansionMode string,
   :kind string,
   :enableFuzzyExtraction boolean}
  
  Updates the specified entity type. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, languageCode, pageToken
  
  Returns the list of all entity types in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-flows-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-validate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/validate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string}
  
  Validates the specified flow and creates or updates validation results. Please call this API after the training is completed to get the complete validation results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:validate"
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

(defn locations-agents-flows-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/patch
  
  Required parameters: name
  
  Optional parameters: languageCode, updateMask
  
  Body: 
  
  {:description string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}],
   :displayName string,
   :eventHandlers [{:triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                    :name string,
                    :targetFlow string,
                    :event string,
                    :targetPage string}],
   :transitionRouteGroups [string],
   :name string,
   :nluSettings {:classificationThreshold number,
                 :modelTrainingMode string,
                 :modelType string}}
  
  Updates the specified flow. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:description string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}],
   :displayName string,
   :eventHandlers [{:triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                    :name string,
                    :targetFlow string,
                    :event string,
                    :targetPage string}],
   :transitionRouteGroups [string],
   :name string,
   :nluSettings {:classificationThreshold number,
                 :modelTrainingMode string,
                 :modelType string}}
  
  Creates a flow in the specified agent. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/flows"
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

(defn locations-agents-flows-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a specified flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-export$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:flowUri string, :includeReferencedFlows boolean}
  
  Exports the specified flow to a binary file. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: ExportFlowResponse Note that resources (e.g. intents, entities, webhooks) that the flow references will also be exported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:export"
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

(defn locations-agents-flows-train$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/train
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Trains the specified flow. Note that only the flow in 'draft' environment is trained. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: An [Empty message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty) Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:train"
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

(defn locations-agents-flows-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/list
  
  Required parameters: parent
  
  Optional parameters: languageCode, pageToken, pageSize
  
  Returns the list of all flows in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/flows"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-flows-getValidationResult$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/getValidationResult
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Gets the latest flow validation result. Flow validation is performed when ValidateFlow is called."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-import$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:flowUri string, :flowContent string, :importOption string}
  
  Imports the specified flow to the specified agent from a binary file. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: ImportFlowResponse Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/flows:import"
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

(defn locations-agents-flows-pages-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/pages/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:eventHandlers [{:triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                    :name string,
                    :targetFlow string,
                    :event string,
                    :targetPage string}],
   :form {:parameters [GoogleCloudDialogflowCxV3FormParameter]},
   :transitionRouteGroups [string],
   :displayName string,
   :entryFulfillment {:returnPartialResponses boolean,
                      :webhook string,
                      :setParameterActions [GoogleCloudDialogflowCxV3FulfillmentSetParameterAction],
                      :tag string,
                      :conditionalCases [GoogleCloudDialogflowCxV3FulfillmentConditionalCases],
                      :messages [GoogleCloudDialogflowCxV3ResponseMessage]},
   :name string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}]}
  
  Creates a page in the specified flow. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/pages"
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

(defn locations-agents-flows-pages-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/pages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, languageCode, pageToken
  
  Returns the list of all pages in the specified flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/pages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-flows-pages-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/pages/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, languageCode
  
  Body: 
  
  {:eventHandlers [{:triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                    :name string,
                    :targetFlow string,
                    :event string,
                    :targetPage string}],
   :form {:parameters [GoogleCloudDialogflowCxV3FormParameter]},
   :transitionRouteGroups [string],
   :displayName string,
   :entryFulfillment {:returnPartialResponses boolean,
                      :webhook string,
                      :setParameterActions [GoogleCloudDialogflowCxV3FulfillmentSetParameterAction],
                      :tag string,
                      :conditionalCases [GoogleCloudDialogflowCxV3FulfillmentConditionalCases],
                      :messages [GoogleCloudDialogflowCxV3ResponseMessage]},
   :name string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}]}
  
  Updates the specified page. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-pages-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/pages/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified page."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-pages-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/pages/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes the specified page. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-transitionRouteGroups-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/transitionRouteGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, languageCode
  
  Body: 
  
  {:name string,
   :displayName string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}]}
  
  Updates the specified TransitionRouteGroup. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-transitionRouteGroups-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/transitionRouteGroups/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes the specified TransitionRouteGroup. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-transitionRouteGroups-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/transitionRouteGroups/get
  
  Required parameters: name
  
  Optional parameters: languageCode
  
  Retrieves the specified TransitionRouteGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-transitionRouteGroups-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/transitionRouteGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, languageCode
  
  Returns the list of all transition route groups in the specified flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/transitionRouteGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-flows-transitionRouteGroups-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/transitionRouteGroups/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:name string,
   :displayName string,
   :transitionRoutes [{:targetFlow string,
                       :condition string,
                       :targetPage string,
                       :name string,
                       :triggerFulfillment GoogleCloudDialogflowCxV3Fulfillment,
                       :intent string}]}
  
  Creates an TransitionRouteGroup in the specified flow. Note: You should always train a flow prior to sending it queries. See the [training documentation](https://cloud.google.com/dialogflow/cx/docs/concept/training)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/transitionRouteGroups"
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

(defn locations-agents-flows-versions-load$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/load
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:allowOverrideAgentResources boolean}
  
  Loads resources in the specified version to the draft flow. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: An empty [Struct message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct) - `response`: An [Empty message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+name}:load"
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

(defn locations-agents-flows-versions-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :displayName string,
   :state string,
   :nluSettings {:classificationThreshold number,
                 :modelTrainingMode string,
                 :modelType string},
   :name string,
   :createTime string}
  
  Creates a Version in the specified Flow. This method is a [long-running operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation). The returned `Operation` type has the following method-specific fields: - `metadata`: CreateVersionOperationMetadata - `response`: Version"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/versions"
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

(defn locations-agents-flows-versions-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all versions in the specified Flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-flows-versions-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :displayName string,
   :state string,
   :nluSettings {:classificationThreshold number,
                 :modelTrainingMode string,
                 :modelType string},
   :name string,
   :createTime string}
  
  Updates the specified Version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-versions-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified Version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-flows-versions-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/flows/versions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified Version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-webhooks-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/webhooks/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:timeout string,
   :disabled boolean,
   :genericWebService {:requestHeaders {},
                       :username string,
                       :password string,
                       :uri string},
   :name string,
   :displayName string,
   :serviceDirectory {:service string,
                      :genericWebService GoogleCloudDialogflowCxV3WebhookGenericWebService}}
  
  Updates the specified webhook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-webhooks-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/webhooks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all webhooks in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/webhooks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-agents-webhooks-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/webhooks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:timeout string,
   :disabled boolean,
   :genericWebService {:requestHeaders {},
                       :username string,
                       :password string,
                       :uri string},
   :name string,
   :displayName string,
   :serviceDirectory {:service string,
                      :genericWebService GoogleCloudDialogflowCxV3WebhookGenericWebService}}
  
  Creates a webhook in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v3/{+parent}/webhooks"
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

(defn locations-agents-webhooks-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/webhooks/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes the specified webhook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
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

(defn locations-agents-webhooks-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v3/projects/locations/agents/webhooks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified webhook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
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
