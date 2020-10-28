(ns happygapi.testing.projects
  "Cloud Testing API: projects.
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn testMatrices-get$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/get
  
  Required parameters: testMatrixId, projectId
  
  Optional parameters: none
  
  Checks the status of a test matrix. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to read project - INVALID_ARGUMENT - if the request is malformed - NOT_FOUND - if the Test Matrix does not exist"
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
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/cancel
  
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

(defn testMatrices-create$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/create
  
  Required parameters: projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:invalidMatrixDetails string,
   :clientInfo {:clientInfoDetails [ClientInfoDetail], :name string},
   :resultStorage {:toolResultsExecution ToolResultsExecution,
                   :googleCloudStorage GoogleCloudStorage,
                   :toolResultsHistory ToolResultsHistory,
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
                       :iosXcTest IosXcTest,
                       :androidTestLoop AndroidTestLoop,
                       :disablePerformanceMetrics boolean}}
  
  Creates and runs a matrix of tests according to the given specifications. Unsupported environments will be returned in the state UNSUPPORTED. A test matrix is limited to use at most 2000 devices in parallel. May return any of the following canonical error codes: - PERMISSION_DENIED - if the user is not authorized to write to project - INVALID_ARGUMENT - if the request is malformed or if the matrix tries to use too many simultaneous devices."
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
