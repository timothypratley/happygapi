(ns happygapi.cloudbuild.projects
  "Cloud Build API: projects.
  Creates and manages builds on Google Cloud Platform.
  See: https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn triggers-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/create
  
  Required parameters: projectId
  
  Optional parameters: parent
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:installationId string,
            :owner string,
            :name string,
            :pullRequest PullRequestFilter,
            :push PushFilter},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :resourceName string,
   :webhookConfig {:secret string, :state string},
   :includedFiles [string],
   :filename string,
   :build {:serviceAccount string,
           :tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :name string,
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :warnings [Warning],
           :source Source,
           :logUrl string,
           :finishTime string,
           :availableSecrets Secrets,
           :status string,
           :id string,
           :timing {},
           :queueTtl string,
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :filter string,
   :id string,
   :pubsubConfig {:subscription string,
                  :state string,
                  :topic string,
                  :serviceAccountEmail string},
   :triggerTemplate {:substitutions {},
                     :tagName string,
                     :commitSha string,
                     :projectId string,
                     :dir string,
                     :invertRegex boolean,
                     :branchName string,
                     :repoName string}}
  
  Creates a new `BuildTrigger`. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{:projectId}
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

(defn triggers-webhook$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/webhook
  
  Required parameters: projectId, trigger
  
  Optional parameters: secret, name
  
  Body: 
  
  {:data string, :contentType string, :extensions [{}]}
  
  ReceiveTriggerWebhook [Experimental] is called when the API receives a webhook request targeted at a specific trigger."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :trigger})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{trigger}:webhook"
     #{:projectId :trigger}
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

(defn triggers-patch$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/patch
  
  Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:installationId string,
            :owner string,
            :name string,
            :pullRequest PullRequestFilter,
            :push PushFilter},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :resourceName string,
   :webhookConfig {:secret string, :state string},
   :includedFiles [string],
   :filename string,
   :build {:serviceAccount string,
           :tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :name string,
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :warnings [Warning],
           :source Source,
           :logUrl string,
           :finishTime string,
           :availableSecrets Secrets,
           :status string,
           :id string,
           :timing {},
           :queueTtl string,
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :filter string,
   :id string,
   :pubsubConfig {:subscription string,
                  :state string,
                  :topic string,
                  :serviceAccountEmail string},
   :triggerTemplate {:substitutions {},
                     :tagName string,
                     :commitSha string,
                     :projectId string,
                     :dir string,
                     :invertRegex boolean,
                     :branchName string,
                     :repoName string}}
  
  Updates a `BuildTrigger` by its project ID and trigger ID. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:triggerId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
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

(defn triggers-delete$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/delete
  
  Required parameters: projectId, triggerId
  
  Optional parameters: name
  
  Deletes a `BuildTrigger` by its project ID and trigger ID. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:triggerId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/get
  
  Required parameters: projectId, triggerId
  
  Optional parameters: name
  
  Returns information about a `BuildTrigger`. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:triggerId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{:triggerId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/list
  
  Required parameters: projectId
  
  Optional parameters: pageToken, pageSize, parent
  
  Lists existing `BuildTrigger`s. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-run$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/triggers/run
  
  Required parameters: triggerId, projectId
  
  Optional parameters: name
  
  Body: 
  
  {:substitutions {},
   :tagName string,
   :commitSha string,
   :projectId string,
   :dir string,
   :invertRegex boolean,
   :branchName string,
   :repoName string}
  
  Runs a `BuildTrigger` at a particular source revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:triggerId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}:run"
     #{:triggerId :projectId}
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

(defn builds-retry$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/retry
  
  Required parameters: projectId, id
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string, :id string, :name string}
  
  Creates a new build based on the specified build. This method creates a new build using the original build request, which may or may not result in an identical build. For triggered builds: * Triggered builds resolve to a precise revision; therefore a retry of a triggered build will result in a build that uses the same revision. For non-triggered builds that specify `RepoSource`: * If the original build built from the tip of a branch, the retried build will build from the tip of that branch, which may not be the same revision as the original build. * If the original build specified a commit sha or revision ID, the retried build will use the identical source. For builds that specify `StorageSource`: * If the original build pulled source from Google Cloud Storage without specifying the generation of the object, the new build will use the current object, which may be different from the original build source. * If the original build pulled source from Cloud Storage and specified the generation of the object, the new build will attempt to use the same object, which may or may not be available depending on the bucket's lifecycle management settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:retry"
     #{:id :projectId}
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

(defn builds-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/list
  
  Required parameters: projectId
  
  Optional parameters: pageToken, pageSize, parent, filter
  
  Lists previously requested builds. Previously requested builds may still be in-progress, or may have finished successfully or unsuccessfully."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn builds-cancel$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/cancel
  
  Required parameters: id, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :name string, :projectId string}
  
  Cancels a build in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:cancel"
     #{:id :projectId}
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

(defn builds-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/get
  
  Required parameters: projectId, id
  
  Optional parameters: name
  
  Returns information about a previously requested build. The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or `WORKING`), and timing information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}"
     #{:id :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn builds-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/builds/create
  
  Required parameters: projectId
  
  Optional parameters: parent
  
  Body: 
  
  {:serviceAccount string,
   :tags [string],
   :statusDetail string,
   :logsBucket string,
   :startTime string,
   :buildTriggerId string,
   :images [string],
   :secrets [{:secretEnv {}, :kmsKeyName string}],
   :name string,
   :steps [{:args [string],
            :waitFor [string],
            :dir string,
            :name string,
            :pullTiming TimeSpan,
            :env [string],
            :volumes [Volume],
            :status string,
            :id string,
            :secretEnv [string],
            :timing TimeSpan,
            :entrypoint string,
            :timeout string}],
   :createTime string,
   :substitutions {},
   :warnings [{:text string, :priority string}],
   :source {:storageSourceManifest StorageSourceManifest,
            :storageSource StorageSource,
            :repoSource RepoSource},
   :logUrl string,
   :finishTime string,
   :availableSecrets {:secretManager [SecretManagerSecret],
                      :inline [InlineSecret]},
   :status string,
   :id string,
   :timing {},
   :queueTtl string,
   :sourceProvenance {:resolvedRepoSource RepoSource,
                      :resolvedStorageSource StorageSource,
                      :resolvedStorageSourceManifest StorageSourceManifest,
                      :fileHashes {}},
   :projectId string,
   :options {:dynamicSubstitutions boolean,
             :sourceProvenanceHash [string],
             :machineType string,
             :env [string],
             :volumes [Volume],
             :logging string,
             :secretEnv [string],
             :diskSizeGb string,
             :logStreamingOption string,
             :workerPool string,
             :substitutionOption string,
             :requestedVerifyOption string},
   :timeout string,
   :artifacts {:objects ArtifactObjects, :images [string]},
   :results {:numArtifacts string,
             :buildStepOutputs [string],
             :buildStepImages [string],
             :artifactManifest string,
             :images [BuiltImage],
             :artifactTiming TimeSpan}}
  
  Starts a build with the specified configuration. This method returns a long-running `Operation`, which includes the build ID. Pass the build ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{:projectId}
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

(defn locations-triggers-run$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :triggerId string,
   :source {:substitutions {},
            :tagName string,
            :commitSha string,
            :projectId string,
            :dir string,
            :invertRegex boolean,
            :branchName string,
            :repoName string}}
  
  Runs a `BuildTrigger` at a particular source revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-triggers-webhook$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/webhook
  
  Required parameters: name
  
  Optional parameters: trigger, projectId, secret
  
  Body: 
  
  {:data string, :contentType string, :extensions [{}]}
  
  ReceiveTriggerWebhook [Experimental] is called when the API receives a webhook request targeted at a specific trigger."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+name}:webhook"
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

(defn locations-triggers-patch$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/patch
  
  Required parameters: resourceName
  
  Optional parameters: triggerId, projectId
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:installationId string,
            :owner string,
            :name string,
            :pullRequest PullRequestFilter,
            :push PushFilter},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :resourceName string,
   :webhookConfig {:secret string, :state string},
   :includedFiles [string],
   :filename string,
   :build {:serviceAccount string,
           :tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :name string,
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :warnings [Warning],
           :source Source,
           :logUrl string,
           :finishTime string,
           :availableSecrets Secrets,
           :status string,
           :id string,
           :timing {},
           :queueTtl string,
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :filter string,
   :id string,
   :pubsubConfig {:subscription string,
                  :state string,
                  :topic string,
                  :serviceAccountEmail string},
   :triggerTemplate {:substitutions {},
                     :tagName string,
                     :commitSha string,
                     :projectId string,
                     :dir string,
                     :invertRegex boolean,
                     :branchName string,
                     :repoName string}}
  
  Updates a `BuildTrigger` by its project ID and trigger ID. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+resourceName}"
     #{:resourceName}
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

(defn locations-triggers-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/get
  
  Required parameters: name
  
  Optional parameters: triggerId, projectId
  
  Returns information about a `BuildTrigger`. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-triggers-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/create
  
  Required parameters: parent
  
  Optional parameters: projectId
  
  Body: 
  
  {:description string,
   :tags [string],
   :github {:installationId string,
            :owner string,
            :name string,
            :pullRequest PullRequestFilter,
            :push PushFilter},
   :disabled boolean,
   :name string,
   :createTime string,
   :ignoredFiles [string],
   :substitutions {},
   :resourceName string,
   :webhookConfig {:secret string, :state string},
   :includedFiles [string],
   :filename string,
   :build {:serviceAccount string,
           :tags [string],
           :statusDetail string,
           :logsBucket string,
           :startTime string,
           :buildTriggerId string,
           :images [string],
           :secrets [Secret],
           :name string,
           :steps [BuildStep],
           :createTime string,
           :substitutions {},
           :warnings [Warning],
           :source Source,
           :logUrl string,
           :finishTime string,
           :availableSecrets Secrets,
           :status string,
           :id string,
           :timing {},
           :queueTtl string,
           :sourceProvenance SourceProvenance,
           :projectId string,
           :options BuildOptions,
           :timeout string,
           :artifacts Artifacts,
           :results Results},
   :filter string,
   :id string,
   :pubsubConfig {:subscription string,
                  :state string,
                  :topic string,
                  :serviceAccountEmail string},
   :triggerTemplate {:substitutions {},
                     :tagName string,
                     :commitSha string,
                     :projectId string,
                     :dir string,
                     :invertRegex boolean,
                     :branchName string,
                     :repoName string}}
  
  Creates a new `BuildTrigger`. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+parent}/triggers"
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

(defn locations-triggers-delete$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/delete
  
  Required parameters: name
  
  Optional parameters: triggerId, projectId
  
  Deletes a `BuildTrigger` by its project ID and trigger ID. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-triggers-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/triggers/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, projectId
  
  Lists existing `BuildTrigger`s. This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+parent}/triggers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-builds-create$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/builds/create
  
  Required parameters: parent
  
  Optional parameters: projectId
  
  Body: 
  
  {:serviceAccount string,
   :tags [string],
   :statusDetail string,
   :logsBucket string,
   :startTime string,
   :buildTriggerId string,
   :images [string],
   :secrets [{:secretEnv {}, :kmsKeyName string}],
   :name string,
   :steps [{:args [string],
            :waitFor [string],
            :dir string,
            :name string,
            :pullTiming TimeSpan,
            :env [string],
            :volumes [Volume],
            :status string,
            :id string,
            :secretEnv [string],
            :timing TimeSpan,
            :entrypoint string,
            :timeout string}],
   :createTime string,
   :substitutions {},
   :warnings [{:text string, :priority string}],
   :source {:storageSourceManifest StorageSourceManifest,
            :storageSource StorageSource,
            :repoSource RepoSource},
   :logUrl string,
   :finishTime string,
   :availableSecrets {:secretManager [SecretManagerSecret],
                      :inline [InlineSecret]},
   :status string,
   :id string,
   :timing {},
   :queueTtl string,
   :sourceProvenance {:resolvedRepoSource RepoSource,
                      :resolvedStorageSource StorageSource,
                      :resolvedStorageSourceManifest StorageSourceManifest,
                      :fileHashes {}},
   :projectId string,
   :options {:dynamicSubstitutions boolean,
             :sourceProvenanceHash [string],
             :machineType string,
             :env [string],
             :volumes [Volume],
             :logging string,
             :secretEnv [string],
             :diskSizeGb string,
             :logStreamingOption string,
             :workerPool string,
             :substitutionOption string,
             :requestedVerifyOption string},
   :timeout string,
   :artifacts {:objects ArtifactObjects, :images [string]},
   :results {:numArtifacts string,
             :buildStepOutputs [string],
             :buildStepImages [string],
             :artifactManifest string,
             :images [BuiltImage],
             :artifactTiming TimeSpan}}
  
  Starts a build with the specified configuration. This method returns a long-running `Operation`, which includes the build ID. Pass the build ID to `GetBuild` to determine the build status (such as `SUCCESS` or `FAILURE`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+parent}/builds"
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

(defn locations-builds-retry$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/builds/retry
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string, :id string, :name string}
  
  Creates a new build based on the specified build. This method creates a new build using the original build request, which may or may not result in an identical build. For triggered builds: * Triggered builds resolve to a precise revision; therefore a retry of a triggered build will result in a build that uses the same revision. For non-triggered builds that specify `RepoSource`: * If the original build built from the tip of a branch, the retried build will build from the tip of that branch, which may not be the same revision as the original build. * If the original build specified a commit sha or revision ID, the retried build will use the identical source. For builds that specify `StorageSource`: * If the original build pulled source from Google Cloud Storage without specifying the generation of the object, the new build will use the current object, which may be different from the original build source. * If the original build pulled source from Cloud Storage and specified the generation of the object, the new build will attempt to use the same object, which may or may not be available depending on the bucket's lifecycle management settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+name}:retry"
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

(defn locations-builds-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/builds/get
  
  Required parameters: name
  
  Optional parameters: id, projectId
  
  Returns information about a previously requested build. The `Build` that is returned includes its status (such as `SUCCESS`, `FAILURE`, or `WORKING`), and timing information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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

(defn locations-builds-cancel$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/builds/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :name string, :projectId string}
  
  Cancels a build in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-builds-list$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/builds/list
  
  Required parameters: parent
  
  Optional parameters: projectId, pageSize, filter, pageToken
  
  Lists previously requested builds. Previously requested builds may still be in-progress, or may have finished successfully or unsuccessfully."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+parent}/builds"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
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
  "https://cloud.google.com/cloud-build/docs/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/{+name}:cancel"
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
