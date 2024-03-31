(ns happygapi.cloudscheduler.projects
  "Cloud Scheduler API: projects.
  Creates and manages jobs run on a regular recurring schedule.
  See: https://cloud.google.com/scheduler/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}/locations"
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
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
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

(defn locations-jobs-list$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-get$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
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

(defn locations-jobs-create$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :httpTarget {:uri string,
                :httpMethod string,
                :headers {},
                :body string,
                :oauthToken OAuthToken,
                :oidcToken OidcToken},
   :timeZone string,
   :schedule string,
   :userUpdateTime string,
   :name string,
   :scheduleTime string,
   :lastAttemptTime string,
   :state string,
   :attemptDeadline string,
   :status {:code integer, :message string, :details [{}]},
   :retryConfig {:retryCount integer,
                 :maxRetryDuration string,
                 :minBackoffDuration string,
                 :maxBackoffDuration string,
                 :maxDoublings integer},
   :pubsubTarget {:topicName string, :data string, :attributes {}},
   :appEngineHttpTarget {:httpMethod string,
                         :appEngineRouting AppEngineRouting,
                         :relativeUri string,
                         :headers {},
                         :body string}}
  
  Creates a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+parent}/jobs"
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

(defn locations-jobs-patch$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :httpTarget {:uri string,
                :httpMethod string,
                :headers {},
                :body string,
                :oauthToken OAuthToken,
                :oidcToken OidcToken},
   :timeZone string,
   :schedule string,
   :userUpdateTime string,
   :name string,
   :scheduleTime string,
   :lastAttemptTime string,
   :state string,
   :attemptDeadline string,
   :status {:code integer, :message string, :details [{}]},
   :retryConfig {:retryCount integer,
                 :maxRetryDuration string,
                 :minBackoffDuration string,
                 :maxBackoffDuration string,
                 :maxDoublings integer},
   :pubsubTarget {:topicName string, :data string, :attributes {}},
   :appEngineHttpTarget {:httpMethod string,
                         :appEngineRouting AppEngineRouting,
                         :relativeUri string,
                         :headers {},
                         :body string}}
  
  Updates a job. If successful, the updated Job is returned. If the job does not exist, `NOT_FOUND` is returned. If UpdateJob does not successfully return, it is possible for the job to be in an Job.State.UPDATE_FAILED state. A job in this state may not be executed. If this happens, retry the UpdateJob request until a successful response is received."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
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

(defn locations-jobs-delete$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
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

(defn locations-jobs-pause$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses a job. If a job is paused then the system will stop executing the job until it is re-enabled via ResumeJob. The state of the job is stored in state; if paused it will be set to Job.State.PAUSED. A job must be in Job.State.ENABLED to be paused."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}:pause"
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

(defn locations-jobs-resume$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resume a job. This method reenables a job after it has been Job.State.PAUSED. The state of a job is stored in Job.state; after calling this method it will be set to Job.State.ENABLED. A job must be in Job.State.PAUSED to be resumed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
     "v1/{+name}:resume"
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

(defn locations-jobs-run$
  "https://cloud.google.com/scheduler/api/reference/rest/v1/projects/locations/jobs/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Forces a job to run now. When this method is called, Cloud Scheduler will dispatch the job, even if the job is already running."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudscheduler.googleapis.com/"
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
