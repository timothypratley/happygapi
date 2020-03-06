(ns happygapi.testing.projects
  "Cloud Testing API: projects.
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn testMatrices-create$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/create
  
  Required parameters: projectId
  
  Optional parameters: requestId
  
  Body: 
  
  {:invalidMatrixDetails string,
   :clientInfo {:clientInfoDetails [ClientInfoDetail], :name string},
   :resultStorage {:googleCloudStorage GoogleCloudStorage,
                   :toolResultsExecution ToolResultsExecution,
                   :resultsUrl string,
                   :toolResultsHistory ToolResultsHistory},
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
   :environmentMatrix {:androidDeviceList AndroidDeviceList,
                       :androidMatrix AndroidMatrix,
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
  
  Creates and runs a matrix of tests according to the given specifications.
  Unsupported environments will be returned in the state UNSUPPORTED.
  Matrices are limited to at most 200 supported executions.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to write to project
  - INVALID_ARGUMENT - if the request is malformed or if the matrix expands
                       to more than 200 supported executions"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices"
     #{:projectId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testMatrices-cancel$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/cancel
  
  Required parameters: projectId, testMatrixId
  
  Optional parameters: none
  Cancels unfinished test executions in a test matrix.
  This call returns immediately and cancellation proceeds asychronously.
  If the matrix is already final, this operation will have no effect.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project
  - INVALID_ARGUMENT - if the request is malformed
  - NOT_FOUND - if the Test Matrix does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:testMatrixId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices/{testMatrixId}:cancel"
     #{:testMatrixId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testMatrices-get$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/projects/testMatrices/get
  
  Required parameters: projectId, testMatrixId
  
  Optional parameters: none
  Checks the status of a test matrix.
  
  May return any of the following canonical error codes:
  
  - PERMISSION_DENIED - if the user is not authorized to read project
  - INVALID_ARGUMENT - if the request is malformed
  - NOT_FOUND - if the Test Matrix does not exist"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:testMatrixId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/projects/{projectId}/testMatrices/{testMatrixId}"
     #{:testMatrixId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
