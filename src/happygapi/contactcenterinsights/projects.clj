(ns happygapi.contactcenterinsights.projects
  "Contact Center AI Insights API: projects.
  
  See: https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn locations-updateSettings$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/updateSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :analysisConfig {:runtimeIntegrationAnalysisPercentage number},
   :updateTime string,
   :conversationTtl string,
   :name string,
   :languageCode string,
   :pubsubNotificationSettings {}}
  
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

(defn locations-operations-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
   :phraseMatchRuleGroups [{:phraseMatchRules [GoogleCloudContactcenterinsightsV1PhraseMatchRule],
                            :type string}],
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

(defn locations-phraseMatchers-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/phraseMatchers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
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

(defn locations-issueModels-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :trainingStats {:analyzedConversationsCount string,
                   :issueStats {},
                   :unclassifiedConversationsCount string},
   :updateTime string,
   :inputDataConfig {:filter string,
                     :trainingConversationsCount string,
                     :medium string},
   :displayName string,
   :state string}
  
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

(defn locations-issueModels-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :createTime string,
   :trainingStats {:analyzedConversationsCount string,
                   :issueStats {},
                   :unclassifiedConversationsCount string},
   :updateTime string,
   :inputDataConfig {:filter string,
                     :trainingConversationsCount string,
                     :medium string},
   :displayName string,
   :state string}
  
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

(defn locations-issueModels-issues-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/issueModels/issues/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :updateTime string,
   :displayName string,
   :createTime string}
  
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

(defn locations-insightsdata-export$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/insightsdata/export
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bigQueryDestination {:projectId string,
                         :dataset string,
                         :table string},
   :parent string,
   :filter string,
   :kmsKey string}
  
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

(defn locations-conversations-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, view, pageSize
  
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

(defn locations-conversations-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/create
  
  Required parameters: parent
  
  Optional parameters: conversationId
  
  Body: 
  
  {:latestAnalysis {:analysisResult GoogleCloudContactcenterinsightsV1AnalysisResult,
                    :name string,
                    :requestTime string,
                    :createTime string},
   :labels {},
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
                         :faqAnswer GoogleCloudContactcenterinsightsV1FaqAnswerData,
                         :articleSuggestion GoogleCloudContactcenterinsightsV1ArticleSuggestionData}],
   :createTime string,
   :turnCount integer,
   :duration string,
   :updateTime string,
   :ttl string,
   :languageCode string,
   :dataSource {:dialogflowSource GoogleCloudContactcenterinsightsV1DialogflowSource,
                :gcsSource GoogleCloudContactcenterinsightsV1GcsSource},
   :expireTime string,
   :transcript {:transcriptSegments [GoogleCloudContactcenterinsightsV1ConversationTranscriptTranscriptSegment]},
   :dialogflowIntents {},
   :callMetadata {:customerChannel integer, :agentChannel integer}}
  
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

(defn locations-conversations-patch$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:latestAnalysis {:analysisResult GoogleCloudContactcenterinsightsV1AnalysisResult,
                    :name string,
                    :requestTime string,
                    :createTime string},
   :labels {},
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
                         :faqAnswer GoogleCloudContactcenterinsightsV1FaqAnswerData,
                         :articleSuggestion GoogleCloudContactcenterinsightsV1ArticleSuggestionData}],
   :createTime string,
   :turnCount integer,
   :duration string,
   :updateTime string,
   :ttl string,
   :languageCode string,
   :dataSource {:dialogflowSource GoogleCloudContactcenterinsightsV1DialogflowSource,
                :gcsSource GoogleCloudContactcenterinsightsV1GcsSource},
   :expireTime string,
   :transcript {:transcriptSegments [GoogleCloudContactcenterinsightsV1ConversationTranscriptTranscriptSegment]},
   :dialogflowIntents {},
   :callMetadata {:customerChannel integer, :agentChannel integer}}
  
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

(defn locations-conversations-analyses-list$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
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

(defn locations-conversations-analyses-create$
  "https://cloud.google.com/contact-center/insights/docsapi/reference/rest/v1/projects/locations/conversations/analyses/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:analysisResult {:endTime string,
                    :callAnalysisMetadata GoogleCloudContactcenterinsightsV1AnalysisResultCallAnalysisMetadata},
   :name string,
   :requestTime string,
   :createTime string}
  
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
