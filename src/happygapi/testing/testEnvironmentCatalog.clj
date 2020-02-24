(ns happygapi.testing.testEnvironmentCatalog
  "Cloud Testing API
  Allows developers to run automated tests for their mobile applications on Google infrastructure.
  See: https://developers.google.com/cloud-test-lab/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: environmentType
  
  Gets the catalog of supported test environments.
  
  May return any of the following canonical error codes:
  
  - INVALID_ARGUMENT - if the request is malformed
  - NOT_FOUND - if the environment type does not exist
  - INTERNAL - if an internal error occurred"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"environmentType"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://testing.googleapis.com/"
     "v1/testEnvironmentCatalog/{environmentType}"
     #{"environmentType"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
