(ns happygapi.dialogflow.projects
  "Dialogflow API: projects.
  Builds conversational interfaces (for example, chatbots, and voice-powered apps and devices).
  See: https://cloud.google.com/dialogflow/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getAgent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/getAgent
  
  Required parameters: parent
  
  Optional parameters: none
  
  Retrieves the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setAgent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/setAgent
  
  Required parameters: parent
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :timeZone string,
   :tier string,
   :defaultLanguageCode string,
   :parent string,
   :displayName string,
   :supportedLanguageCodes [string],
   :enableLogging boolean,
   :matchMode string,
   :classificationThreshold number,
   :apiVersion string,
   :avatarUri string}
  
  Creates/updates the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
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

(defn deleteAgent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/deleteAgent
  
  Required parameters: parent
  
  Optional parameters: none
  
  Deletes the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}:cancel"
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
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}/operations"
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
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-restore$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/restore
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:agentContent string, :agentUri string}
  
  Restores the specified agent from a ZIP file.
  
  Replaces the current agent version with a new one. All the intents and
  entity types in the older version are deleted.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:restore"
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

(defn agent-export$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/export
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:agentUri string}
  
  Exports the specified agent to a ZIP file.
  
  Operation <response: ExportAgentResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:export"
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

(defn agent-search$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/search
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of agents.
  
  Since there is at most one conversational agent per project, this method is
  useful primarily for listing all agents across projects the caller has
  access to. One can achieve that with a wildcard project collection id \"-\".
  Refer to [List
  Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-updateFulfillment$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/updateFulfillment
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :enabled boolean,
   :genericWebService {:uri string,
                       :password string,
                       :isCloudFunction boolean,
                       :username string,
                       :requestHeaders {}},
   :features [{:type string}]}
  
  Updates the fulfillment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-train$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/train
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Trains the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:train"
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

(defn agent-getValidationResult$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/getValidationResult
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Gets agent validation result. Agent validation is performed during
  training time and is updated automatically when training is completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent/validationResult"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-import$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:agentContent string, :agentUri string}
  
  Imports the specified agent from a ZIP file.
  
  Uploads new intents and entity types without deleting the existing ones.
  Intents and entity types with the same name are replaced with the new
  versions from ImportAgentRequest.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/agent:import"
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

(defn agent-getFulfillment$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/getFulfillment
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the fulfillment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/create
  
  Required parameters: parent
  
  Optional parameters: intentView, languageCode
  
  Body: 
  
  {:mlDisabled boolean,
   :displayName string,
   :name string,
   :events [string],
   :isFallback boolean,
   :trainingPhrases [{:parts [GoogleCloudDialogflowV2IntentTrainingPhrasePart],
                      :name string,
                      :timesAddedCount integer,
                      :type string}],
   :rootFollowupIntentName string,
   :followupIntentInfo [{:followupIntentName string,
                         :parentFollowupIntentName string}],
   :outputContexts [{:lifespanCount integer,
                     :name string,
                     :parameters {}}],
   :messages [{:browseCarouselCard GoogleCloudDialogflowV2IntentMessageBrowseCarouselCard,
               :payload {},
               :mediaContent GoogleCloudDialogflowV2IntentMessageMediaContent,
               :listSelect GoogleCloudDialogflowV2IntentMessageListSelect,
               :quickReplies GoogleCloudDialogflowV2IntentMessageQuickReplies,
               :basicCard GoogleCloudDialogflowV2IntentMessageBasicCard,
               :carouselSelect GoogleCloudDialogflowV2IntentMessageCarouselSelect,
               :card GoogleCloudDialogflowV2IntentMessageCard,
               :suggestions GoogleCloudDialogflowV2IntentMessageSuggestions,
               :image GoogleCloudDialogflowV2IntentMessageImage,
               :linkOutSuggestion GoogleCloudDialogflowV2IntentMessageLinkOutSuggestion,
               :simpleResponses GoogleCloudDialogflowV2IntentMessageSimpleResponses,
               :tableCard GoogleCloudDialogflowV2IntentMessageTableCard,
               :platform string,
               :text GoogleCloudDialogflowV2IntentMessageText}],
   :parentFollowupIntentName string,
   :priority integer,
   :action string,
   :webhookState string,
   :parameters [{:displayName string,
                 :entityTypeDisplayName string,
                 :prompts [string],
                 :mandatory boolean,
                 :defaultValue string,
                 :isList boolean,
                 :name string,
                 :value string}],
   :resetContexts boolean,
   :defaultResponsePlatforms [string],
   :inputContextNames [string]}
  
  Creates an intent in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents"
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

(defn agent-intents-batchDelete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:intents [{:mlDisabled boolean,
              :displayName string,
              :name string,
              :events [string],
              :isFallback boolean,
              :trainingPhrases [GoogleCloudDialogflowV2IntentTrainingPhrase],
              :rootFollowupIntentName string,
              :followupIntentInfo [GoogleCloudDialogflowV2IntentFollowupIntentInfo],
              :outputContexts [GoogleCloudDialogflowV2Context],
              :messages [GoogleCloudDialogflowV2IntentMessage],
              :parentFollowupIntentName string,
              :priority integer,
              :action string,
              :webhookState string,
              :parameters [GoogleCloudDialogflowV2IntentParameter],
              :resetContexts boolean,
              :defaultResponsePlatforms [string],
              :inputContextNames [string]}]}
  
  Deletes intents in the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents:batchDelete"
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

(defn agent-intents-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/get
  
  Required parameters: name
  
  Optional parameters: intentView, languageCode
  
  Retrieves the specified intent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/patch
  
  Required parameters: name
  
  Optional parameters: intentView, languageCode, updateMask
  
  Body: 
  
  {:mlDisabled boolean,
   :displayName string,
   :name string,
   :events [string],
   :isFallback boolean,
   :trainingPhrases [{:parts [GoogleCloudDialogflowV2IntentTrainingPhrasePart],
                      :name string,
                      :timesAddedCount integer,
                      :type string}],
   :rootFollowupIntentName string,
   :followupIntentInfo [{:followupIntentName string,
                         :parentFollowupIntentName string}],
   :outputContexts [{:lifespanCount integer,
                     :name string,
                     :parameters {}}],
   :messages [{:browseCarouselCard GoogleCloudDialogflowV2IntentMessageBrowseCarouselCard,
               :payload {},
               :mediaContent GoogleCloudDialogflowV2IntentMessageMediaContent,
               :listSelect GoogleCloudDialogflowV2IntentMessageListSelect,
               :quickReplies GoogleCloudDialogflowV2IntentMessageQuickReplies,
               :basicCard GoogleCloudDialogflowV2IntentMessageBasicCard,
               :carouselSelect GoogleCloudDialogflowV2IntentMessageCarouselSelect,
               :card GoogleCloudDialogflowV2IntentMessageCard,
               :suggestions GoogleCloudDialogflowV2IntentMessageSuggestions,
               :image GoogleCloudDialogflowV2IntentMessageImage,
               :linkOutSuggestion GoogleCloudDialogflowV2IntentMessageLinkOutSuggestion,
               :simpleResponses GoogleCloudDialogflowV2IntentMessageSimpleResponses,
               :tableCard GoogleCloudDialogflowV2IntentMessageTableCard,
               :platform string,
               :text GoogleCloudDialogflowV2IntentMessageText}],
   :parentFollowupIntentName string,
   :priority integer,
   :action string,
   :webhookState string,
   :parameters [{:displayName string,
                 :entityTypeDisplayName string,
                 :prompts [string],
                 :mandatory boolean,
                 :defaultValue string,
                 :isList boolean,
                 :name string,
                 :value string}],
   :resetContexts boolean,
   :defaultResponsePlatforms [string],
   :inputContextNames [string]}
  
  Updates the specified intent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-intents-batchUpdate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:intentBatchUri string,
   :intentView string,
   :intentBatchInline {:intents [GoogleCloudDialogflowV2Intent]},
   :languageCode string,
   :updateMask string}
  
  Updates/Creates multiple intents in the specified agent.
  
  Operation <response: BatchUpdateIntentsResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents:batchUpdate"
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

(defn agent-intents-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified intent and its direct or indirect followup intents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-intents-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/intents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, intentView, languageCode, pageToken
  
  Returns the list of all intents in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/intents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: languageCode, updateMask
  
  Body: 
  
  {:name string,
   :autoExpansionMode string,
   :kind string,
   :enableFuzzyExtraction boolean,
   :displayName string,
   :entities [{:value string, :synonyms [string]}]}
  
  Updates the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/get
  
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
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-batchUpdate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string,
   :updateMask string,
   :entityTypeBatchUri string,
   :entityTypeBatchInline {:entityTypes [GoogleCloudDialogflowV2EntityType]}}
  
  Updates/Creates multiple entity types in the specified agent.
  
  Operation <response: BatchUpdateEntityTypesResponse>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes:batchUpdate"
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

(defn agent-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified entity type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: languageCode, pageToken, pageSize
  
  Returns the list of all entity types in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-entityTypes-batchDelete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entityTypeNames [string]}
  
  Deletes entity types in the specified agent.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes:batchDelete"
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

(defn agent-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Body: 
  
  {:name string,
   :autoExpansionMode string,
   :kind string,
   :enableFuzzyExtraction boolean,
   :displayName string,
   :entities [{:value string, :synonyms [string]}]}
  
  Creates an entity type in the specified agent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
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

(defn agent-entityTypes-entities-batchUpdate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/entities/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entities [{:value string, :synonyms [string]}],
   :languageCode string,
   :updateMask string}
  
  Updates or creates multiple entities in the specified entity type. This
  method does not affect entities in the entity type that aren't explicitly
  specified in the request.
  
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchUpdate"
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

(defn agent-entityTypes-entities-batchDelete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/entities/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string, :entityValues [string]}
  
  Deletes entities in the specified entity type.
  
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchDelete"
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

(defn agent-entityTypes-entities-batchCreate$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/entityTypes/entities/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:entities [{:value string, :synonyms [string]}],
   :languageCode string}
  
  Creates multiple new entities in the specified entity type.
  
  Operation <response: google.protobuf.Empty>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entities:batchCreate"
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

(defn agent-environments-users-sessions-deleteContexts$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/deleteContexts
  
  Required parameters: parent
  
  Optional parameters: none
  
  Deletes all active contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-detectIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/detectIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryParams {:resetContexts boolean,
                 :geoLocation GoogleTypeLatLng,
                 :payload {},
                 :contexts [GoogleCloudDialogflowV2Context],
                 :sentimentAnalysisRequestConfig GoogleCloudDialogflowV2SentimentAnalysisRequestConfig,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowV2SessionEntityType]},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowV2SynthesizeSpeechConfig,
                       :sampleRateHertz integer},
   :inputAudio string,
   :outputAudioConfigMask string,
   :queryInput {:audioConfig GoogleCloudDialogflowV2InputAudioConfig,
                :event GoogleCloudDialogflowV2EventInput,
                :text GoogleCloudDialogflowV2TextInput}}
  
  Processes a natural language query and returns structured, actionable data
  as a result. This method is not idempotent, because it may cause contexts
  and session entity types to be updated, which in turn might affect
  results of future queries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+session}:detectIntent"
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

(defn agent-environments-users-sessions-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all session entity types in the specified session.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :entityOverrideMode string,
   :entities [{:value string, :synonyms [string]}]}
  
  Updates the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-environments-users-sessions-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :entityOverrideMode string,
   :entities [{:value string, :synonyms [string]}]}
  
  Creates a session entity type.
  
  If the specified session entity type already exists, overrides the session
  entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
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

(defn agent-environments-users-sessions-contexts-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/contexts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-contexts-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/contexts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-contexts-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/contexts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-environments-users-sessions-contexts-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/contexts/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:lifespanCount integer, :name string, :parameters {}}
  
  Updates the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-environments-users-sessions-contexts-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/environments/users/sessions/contexts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:lifespanCount integer, :name string, :parameters {}}
  
  Creates a context.
  
  If the specified context already exists, overrides the context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
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

(defn agent-sessions-deleteContexts$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/deleteContexts
  
  Required parameters: parent
  
  Optional parameters: none
  
  Deletes all active contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-detectIntent$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/detectIntent
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryParams {:resetContexts boolean,
                 :geoLocation GoogleTypeLatLng,
                 :payload {},
                 :contexts [GoogleCloudDialogflowV2Context],
                 :sentimentAnalysisRequestConfig GoogleCloudDialogflowV2SentimentAnalysisRequestConfig,
                 :timeZone string,
                 :sessionEntityTypes [GoogleCloudDialogflowV2SessionEntityType]},
   :outputAudioConfig {:audioEncoding string,
                       :synthesizeSpeechConfig GoogleCloudDialogflowV2SynthesizeSpeechConfig,
                       :sampleRateHertz integer},
   :inputAudio string,
   :outputAudioConfigMask string,
   :queryInput {:audioConfig GoogleCloudDialogflowV2InputAudioConfig,
                :event GoogleCloudDialogflowV2EventInput,
                :text GoogleCloudDialogflowV2TextInput}}
  
  Processes a natural language query and returns structured, actionable data
  as a result. This method is not idempotent, because it may cause contexts
  and session entity types to be updated, which in turn might affect
  results of future queries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+session}:detectIntent"
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

(defn agent-sessions-contexts-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/contexts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:lifespanCount integer, :name string, :parameters {}}
  
  Creates a context.
  
  If the specified context already exists, overrides the context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
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

(defn agent-sessions-contexts-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/contexts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/contexts/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all contexts in the specified session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/contexts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/contexts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-contexts-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/contexts/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:lifespanCount integer, :name string, :parameters {}}
  
  Updates the specified context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-sessions-entityTypes-delete$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/entityTypes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all session entity types in the specified session.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-get$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agent-sessions-entityTypes-patch$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/entityTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :entityOverrideMode string,
   :entities [{:value string, :synonyms [string]}]}
  
  Updates the specified session entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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

(defn agent-sessions-entityTypes-create$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/agent/sessions/entityTypes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :entityOverrideMode string,
   :entities [{:value string, :synonyms [string]}]}
  
  Creates a session entity type.
  
  If the specified session entity type already exists, overrides the session
  entity type.
  
  This method doesn't work with Google Assistant integration.
  Contact Dialogflow support if you need to use session entities
  with Google Assistant integration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+parent}/entityTypes"
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

(defn operations-list$
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}/operations"
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
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}"
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
  "https://cloud.google.com/dialogflow/api/reference/rest/v2/projects/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/dialogflow"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dialogflow.googleapis.com/"
     "v2/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
