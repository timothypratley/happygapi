(ns happygapi.testing.projects
  "Cloud Testing API: projects.
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn testMatrices-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/testMatrices/create
  
  Required parameters: projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:extendedInvalidMatrixDetails [{:reason string, :message string}],
   :invalidMatrixDetails string,
   :clientInfo {:name string, :clientInfoDetails [ClientInfoDetail]},
   :resultStorage {:googleCloudStorage GoogleCloudStorage,
                   :toolResultsHistory ToolResultsHistory,
                   :toolResultsExecution ToolResultsExecution,
                   :resultsUrl string},
   :failFast boolean,
   :flakyTestAttempts integer,
   :state string,
   :outcomeSummary string,
   :testMatrixId string,
   :testExecutions [{:testDetails TestDetails,
                     :matrixId string,
                     :shard Shard,
                     :state string,
                     :id string,
                     :environment Environment,
                     :projectId string,
                     :timestamp string,
                     :testSpecification TestSpecification,
                     :toolResultsStep ToolResultsStep}],
   :environmentMatrix {:androidMatrix AndroidMatrix,
                       :androidDeviceList AndroidDeviceList,
                       :iosDeviceList IosDeviceList},
   :projectId string,
   :timestamp string,
   :testSpecification {:testTimeout string,
                       :testSetup TestSetup,
                       :iosTestSetup IosTestSetup,
                       :androidRoboTest AndroidRoboTest,
                       :iosTestLoop IosTestLoop,
                       :androidInstrumentationTest AndroidInstrumentationTest,
                       :disableVideoRecording boolean,
                       :iosRoboTest IosRoboTest,
                       :iosXcTest IosXcTest,
                       :androidTestLoop AndroidTestLoop,
                       :disablePerformanceMetrics boolean}}
  
  Creates and runs a matrix of tests according to the given specifications. Unsupported environments will be returned in the state UNSUPPORTED. A test matrix is limited to use at most 2000 devices in parallel. The returned matrix will not yet contain the executions that will be created for this matrix. Execution creation happens later on and will require a call to GetTestMatrix. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed or if the matrix tries to use too many simultaneous devices."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices"
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

(defn testMatrices-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/testMatrices/get
  
  Required parameters: projectId, testMatrixId
  
  Optional parameters: none
  
  Checks the status of a test matrix and the executions once they are created. The test matrix will contain the list of test executions to run if and only if the resultStorage.toolResultsExecution fields have been populated. Note: Flaky test executions may be added to the matrix at a later stage. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Test Matrix does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:testMatrixId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices/{testMatrixId}"
     #{:testMatrixId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testMatrices-cancel$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/testMatrices/cancel
  
  Required parameters: projectId, testMatrixId
  
  Optional parameters: none
  
  Cancels unfinished test executions in a test matrix. This call returns immediately and cancellation proceeds asynchronously. If the matrix is already final, this operation will have no effect. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Test Matrix does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:testMatrixId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices/{testMatrixId}:cancel"
     #{:testMatrixId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceSessions-create$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/deviceSessions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :inactivityTimeout string,
   :name string,
   :createTime string,
   :androidDevice {:androidModelId string,
                   :androidVersionId string,
                   :locale string,
                   :orientation string},
   :state string,
   :ttl string,
   :stateHistories [{:sessionState string,
                     :eventTime string,
                     :stateMessage string}],
   :activeStartTime string,
   :expireTime string}
  
  POST /v1/projects/{project_id}/deviceSessions"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/{+parent}/deviceSessions"
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

(defn deviceSessions-list$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/deviceSessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  GET /v1/projects/{project_id}/deviceSessions Lists device Sessions owned by the project user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/{+parent}/deviceSessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceSessions-get$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/deviceSessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  GET /v1/projects/{project_id}/deviceSessions/{device_session_id} Return a DeviceSession, which documents the allocation status and whether the device is allocated. Clients making requests from this API must poll GetDeviceSession."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
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

(defn deviceSessions-cancel$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/deviceSessions/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  POST /v1/projects/{project_id}/deviceSessions/{device_session_id}:cancel Changes the DeviceSession to state FINISHED and terminates all connections. Canceled sessions are not deleted and can be retrieved or listed by the user until they expire based on the 28 day deletion policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
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

(defn deviceSessions-patch$
  "https://firebase.google.com/docs/test-lab/api/reference/rest/v1/projects/deviceSessions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :inactivityTimeout string,
   :name string,
   :createTime string,
   :androidDevice {:androidModelId string,
                   :androidVersionId string,
                   :locale string,
                   :orientation string},
   :state string,
   :ttl string,
   :stateHistories [{:sessionState string,
                     :eventTime string,
                     :stateMessage string}],
   :activeStartTime string,
   :expireTime string}
  
  PATCH /v1/projects/{projectId}/deviceSessions/deviceSessionId}:updateDeviceSession Updates the current device session to the fields described by the update_mask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://testing.googleapis.com/"
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
