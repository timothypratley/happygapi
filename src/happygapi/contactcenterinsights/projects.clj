(ns happygapi.contactcenterinsights.projects
  "Contact Center AI Insights API: projects.
  
  See: https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-updateSettings$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/updateSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:pubsubNotificationSettings {},
   :conversationTtl string,
   :name string,
   :createTime string,
   :updateTime string,
   :speechConfig {:speechRecognizer string},
   :languageCode string,
   :redactionConfig {:inspectTemplate string,
                     :deidentifyTemplate string},
   :analysisConfig {:uploadConversationAnalysisPercentage number,
                    :annotatorSelector GoogleCloudContactcenterinsightsV1AnnotatorSelector,
                    :runtimeIntegrationAnalysisPercentage number}}
  
  Updates project-level settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-getSettings$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/getSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets project-level settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-insightsdata-export$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/insightsdata/export
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:kmsKey string,
   :bigQueryDestination {:table string,
                         :dataset string,
                         :projectId string},
   :writeDisposition string,
   :filter string,
   :parent string}
  
  Export insights data to a destination defined in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/insightsdata:export"
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

(defn locations-operations-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}:cancel"
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
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-issueModels-undeploy$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/undeploy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string}
  
  Undeploys an issue model. An issue model can not be used in analysis after it has been undeployed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}:undeploy"
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

(defn locations-issueModels-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an issue model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-issueModels-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:modelType string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :languageCode string,
   :inputDataConfig {:filter string,
                     :medium string,
                     :trainingConversationsCount string},
   :issueCount string,
   :trainingStats {:unclassifiedConversationsCount string,
                   :issueStats {},
                   :analyzedConversationsCount string}}
  
  Updates an issue model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-issueModels-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:modelType string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :languageCode string,
   :inputDataConfig {:filter string,
                     :medium string,
                     :trainingConversationsCount string},
   :issueCount string,
   :trainingStats {:unclassifiedConversationsCount string,
                   :issueStats {},
                   :analyzedConversationsCount string}}
  
  Creates an issue model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/issueModels"
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

(defn locations-issueModels-calculateIssueModelStats$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/calculateIssueModelStats
  
  Required parameters: issueModel
  
  Optional parameters: none
  
  Gets an issue model's statistics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:issueModel})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+issueModel}:calculateIssueModelStats"
     #{:issueModel}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-issueModels-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an issue model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-issueModels-export$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :gcsDestination {:objectUri string}}
  
  Exports an issue model to the provided destination."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}:export"
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

(defn locations-issueModels-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists issue models."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/issueModels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-issueModels-import$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parent string,
   :createNewModel boolean,
   :gcsSource {:objectUri string}}
  
  Imports an issue model from a Cloud Storage bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/issueModels:import"
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

(defn locations-issueModels-deploy$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/deploy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string}
  
  Deploys an issue model. Returns an error if a model is already deployed. An issue model can only be used in analysis after it has been deployed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}:deploy"
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

(defn locations-issueModels-issues-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/issues/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists issues."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/issues"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-issueModels-issues-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/issues/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an issue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-issueModels-issues-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/issues/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :name string,
   :sampleUtterances [string],
   :updateTime string,
   :displayName string}
  
  Updates an issue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-issueModels-issues-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/issues/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an issue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-phraseMatchers-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a phrase matcher."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-phraseMatchers-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :revisionCreateTime string,
   :name string,
   :revisionId string,
   :activationUpdateTime string,
   :type string,
   :versionTag string,
   :updateTime string,
   :active boolean,
   :phraseMatchRuleGroups [{:type string,
                            :phraseMatchRules [GoogleCloudContactcenterinsightsV1PhraseMatchRule]}],
   :roleMatch string}
  
  Updates a phrase matcher."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-phraseMatchers-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :revisionCreateTime string,
   :name string,
   :revisionId string,
   :activationUpdateTime string,
   :type string,
   :versionTag string,
   :updateTime string,
   :active boolean,
   :phraseMatchRuleGroups [{:type string,
                            :phraseMatchRules [GoogleCloudContactcenterinsightsV1PhraseMatchRule]}],
   :roleMatch string}
  
  Creates a phrase matcher."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/phraseMatchers"
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

(defn locations-phraseMatchers-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a phrase matcher."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-phraseMatchers-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists phrase matchers."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/phraseMatchers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversations-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-conversations-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:latestAnalysis {:createTime string,
                    :name string,
                    :requestTime string,
                    :annotatorSelector GoogleCloudContactcenterinsightsV1AnnotatorSelector,
                    :analysisResult GoogleCloudContactcenterinsightsV1AnalysisResult},
   :labels {},
   :obfuscatedUserId string,
   :startTime string,
   :agentId string,
   :medium string,
   :name string,
   :runtimeAnnotations [{:smartComposeSuggestion GoogleCloudContactcenterinsightsV1SmartComposeSuggestionData,
                         :endBoundary GoogleCloudContactcenterinsightsV1AnnotationBoundary,
                         :smartReply GoogleCloudContactcenterinsightsV1SmartReplyData,
                         :answerFeedback GoogleCloudContactcenterinsightsV1AnswerFeedback,
                         :createTime string,
                         :startBoundary GoogleCloudContactcenterinsightsV1AnnotationBoundary,
                         :annotationId string,
                         :dialogflowInteraction GoogleCloudContactcenterinsightsV1DialogflowInteractionData,
                         :conversationSummarizationSuggestion GoogleCloudContactcenterinsightsV1ConversationSummarizationSuggestionData,
                         :faqAnswer GoogleCloudContactcenterinsightsV1FaqAnswerData,
                         :articleSuggestion GoogleCloudContactcenterinsightsV1ArticleSuggestionData}],
   :createTime string,
   :turnCount integer,
   :duration string,
   :updateTime string,
   :qualityMetadata {:menuPath string,
                     :agentInfo [GoogleCloudContactcenterinsightsV1ConversationQualityMetadataAgentInfo],
                     :waitDuration string,
                     :customerSatisfactionRating integer},
   :latestSummary {:answerRecord string,
                   :text string,
                   :textSections {},
                   :metadata {},
                   :conversationModel string,
                   :confidence number},
   :ttl string,
   :languageCode string,
   :dataSource {:gcsSource GoogleCloudContactcenterinsightsV1GcsSource,
                :dialogflowSource GoogleCloudContactcenterinsightsV1DialogflowSource},
   :expireTime string,
   :transcript {:transcriptSegments [GoogleCloudContactcenterinsightsV1ConversationTranscriptTranscriptSegment]},
   :dialogflowIntents {},
   :callMetadata {:agentChannel integer, :customerChannel integer}}
  
  Updates a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-conversations-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/create
  
  Required parameters: parent
  
  Optional parameters: conversationId
  
  Body: 
  
  {:latestAnalysis {:createTime string,
                    :name string,
                    :requestTime string,
                    :annotatorSelector GoogleCloudContactcenterinsightsV1AnnotatorSelector,
                    :analysisResult GoogleCloudContactcenterinsightsV1AnalysisResult},
   :labels {},
   :obfuscatedUserId string,
   :startTime string,
   :agentId string,
   :medium string,
   :name string,
   :runtimeAnnotations [{:smartComposeSuggestion GoogleCloudContactcenterinsightsV1SmartComposeSuggestionData,
                         :endBoundary GoogleCloudContactcenterinsightsV1AnnotationBoundary,
                         :smartReply GoogleCloudContactcenterinsightsV1SmartReplyData,
                         :answerFeedback GoogleCloudContactcenterinsightsV1AnswerFeedback,
                         :createTime string,
                         :startBoundary GoogleCloudContactcenterinsightsV1AnnotationBoundary,
                         :annotationId string,
                         :dialogflowInteraction GoogleCloudContactcenterinsightsV1DialogflowInteractionData,
                         :conversationSummarizationSuggestion GoogleCloudContactcenterinsightsV1ConversationSummarizationSuggestionData,
                         :faqAnswer GoogleCloudContactcenterinsightsV1FaqAnswerData,
                         :articleSuggestion GoogleCloudContactcenterinsightsV1ArticleSuggestionData}],
   :createTime string,
   :turnCount integer,
   :duration string,
   :updateTime string,
   :qualityMetadata {:menuPath string,
                     :agentInfo [GoogleCloudContactcenterinsightsV1ConversationQualityMetadataAgentInfo],
                     :waitDuration string,
                     :customerSatisfactionRating integer},
   :latestSummary {:answerRecord string,
                   :text string,
                   :textSections {},
                   :metadata {},
                   :conversationModel string,
                   :confidence number},
   :ttl string,
   :languageCode string,
   :dataSource {:gcsSource GoogleCloudContactcenterinsightsV1GcsSource,
                :dialogflowSource GoogleCloudContactcenterinsightsV1DialogflowSource},
   :expireTime string,
   :transcript {:transcriptSegments [GoogleCloudContactcenterinsightsV1ConversationTranscriptTranscriptSegment]},
   :dialogflowIntents {},
   :callMetadata {:agentChannel integer, :customerChannel integer}}
  
  Creates a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations"
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

(defn locations-conversations-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-conversations-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/list
  
  Required parameters: parent
  
  Optional parameters: view, filter, orderBy, pageToken, pageSize
  
  Lists conversations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversations-ingest$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/ingest
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:redactionConfig {:inspectTemplate string,
                     :deidentifyTemplate string},
   :speechConfig {:speechRecognizer string},
   :transcriptObjectConfig {:medium string},
   :conversationConfig {:customerChannel integer,
                        :agentChannel integer,
                        :agentId string},
   :parent string,
   :gcsSource {:bucketObjectType string,
               :metadataBucketUri string,
               :bucketUri string,
               :customMetadataKeys [string]}}
  
  Imports conversations and processes them according to the user's configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations:ingest"
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

(defn locations-conversations-calculateStats$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/calculateStats
  
  Required parameters: location
  
  Optional parameters: filter
  
  Gets conversation statistics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+location}/conversations:calculateStats"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversations-bulkAnalyze$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/bulkAnalyze
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :analysisPercentage number,
   :annotatorSelector {:runPhraseMatcherAnnotator boolean,
                       :runInterruptionAnnotator boolean,
                       :runIssueModelAnnotator boolean,
                       :runSilenceAnnotator boolean,
                       :runSentimentAnnotator boolean,
                       :runEntityAnnotator boolean,
                       :phraseMatchers [string],
                       :summarizationConfig GoogleCloudContactcenterinsightsV1AnnotatorSelectorSummarizationConfig,
                       :runIntentAnnotator boolean,
                       :issueModels [string],
                       :runSummarizationAnnotator boolean},
   :parent string}
  
  Analyzes multiple conversations in a single request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations:bulkAnalyze"
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

(defn locations-conversations-bulkDelete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/bulkDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parent string,
   :force boolean,
   :maxDeleteCount integer,
   :filter string}
  
  Deletes multiple conversations in a single request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations:bulkDelete"
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

(defn locations-conversations-upload$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:parent string,
   :redactionConfig {:inspectTemplate string,
                     :deidentifyTemplate string},
   :speechConfig {:speechRecognizer string},
   :conversationId string,
   :conversation {:latestAnalysis GoogleCloudContactcenterinsightsV1Analysis,
                  :labels {},
                  :obfuscatedUserId string,
                  :startTime string,
                  :agentId string,
                  :medium string,
                  :name string,
                  :runtimeAnnotations [GoogleCloudContactcenterinsightsV1RuntimeAnnotation],
                  :createTime string,
                  :turnCount integer,
                  :duration string,
                  :updateTime string,
                  :qualityMetadata GoogleCloudContactcenterinsightsV1ConversationQualityMetadata,
                  :latestSummary GoogleCloudContactcenterinsightsV1ConversationSummarizationSuggestionData,
                  :ttl string,
                  :languageCode string,
                  :dataSource GoogleCloudContactcenterinsightsV1ConversationDataSource,
                  :expireTime string,
                  :transcript GoogleCloudContactcenterinsightsV1ConversationTranscript,
                  :dialogflowIntents {},
                  :callMetadata GoogleCloudContactcenterinsightsV1ConversationCallMetadata}}
  
  Create a longrunning conversation upload operation. This method differs from CreateConversation by allowing audio transcription and optional DLP redaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/conversations:upload"
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

(defn locations-conversations-analyses-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createTime string,
   :name string,
   :requestTime string,
   :annotatorSelector {:runPhraseMatcherAnnotator boolean,
                       :runInterruptionAnnotator boolean,
                       :runIssueModelAnnotator boolean,
                       :runSilenceAnnotator boolean,
                       :runSentimentAnnotator boolean,
                       :runEntityAnnotator boolean,
                       :phraseMatchers [string],
                       :summarizationConfig GoogleCloudContactcenterinsightsV1AnnotatorSelectorSummarizationConfig,
                       :runIntentAnnotator boolean,
                       :issueModels [string],
                       :runSummarizationAnnotator boolean},
   :analysisResult {:callAnalysisMetadata GoogleCloudContactcenterinsightsV1AnalysisResultCallAnalysisMetadata,
                    :endTime string}}
  
  Creates an analysis. The long running operation is done when the analysis has completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/analyses"
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

(defn locations-conversations-analyses-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an analysis."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-conversations-analyses-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an analysis."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-conversations-analyses-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists analyses."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/analyses"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-views-delete$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/views/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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

(defn locations-views-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/views/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists views."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/views"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-views-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/views/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :createTime string,
   :value string,
   :name string,
   :displayName string}
  
  Updates a view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+name}"
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

(defn locations-views-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/views/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateTime string,
   :createTime string,
   :value string,
   :name string,
   :displayName string}
  
  Creates a view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
     "v1/{+parent}/views"
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

(defn locations-views-get$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/views/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenterinsights.googleapis.com/"
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
