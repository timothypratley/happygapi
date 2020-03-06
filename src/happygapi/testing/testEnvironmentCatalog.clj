(ns happygapi.testing.testEnvironmentCatalog
  "Cloud Testing API: testEnvironmentCatalog.
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/api/reference/rest/v1/testEnvironmentCatalog"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/cloud-test-lab/api/reference/rest/v1/testEnvironmentCatalog/get
  
  Required parameters: environmentType
  
  Optional parameters: projectId
  Gets the catalog of supported test environments.
  
  May return any of the following canonical error codes:
  
  - INVALID_ARGUMENT - if the request is malformed
  - NOT_FOUND - if the environment type does not exist
  - INTERNAL - if an internal error occurred"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:environmentType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/testEnvironmentCatalog/{environmentType}"
     #{:environmentType}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
