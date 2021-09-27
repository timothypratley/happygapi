(ns happygapi.genomics.pipelines
  "Genomics API: pipelines.
  Uploads, processes, queries, and searches Genomics data in the cloud.
  See: https://cloud.google.com/genomicsapi/reference/rest/v2alpha1/pipelines"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn run$
  "https://cloud.google.com/genomicsapi/reference/rest/v2alpha1/pipelines/run
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :pipeline {:encryptedEnvironment Secret,
              :actions [Action],
              :timeout string,
              :environment {},
              :resources Resources},
   :pubSubTopic string}
  
  Runs a pipeline. The returned Operation's metadata field will contain a google.genomics.v2alpha1.Metadata object describing the status of the pipeline execution. The [response] field will contain a google.genomics.v2alpha1.RunPipelineResponse object if the pipeline completes successfully. **Note:** Before you can use this method, the Genomics Service Agent must have access to your project. This is done automatically when the Cloud Genomics API is first enabled, but if you delete this permission, or if you enabled the Cloud Genomics API before the v2alpha1 API launch, you must disable and re-enable the API to grant the Genomics Service Agent the required permissions. Authorization requires the following [Google IAM](https://cloud.google.com/iam/) permission: * `genomics.operations.create` [1]: /genomics/gsa"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/genomics"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://genomics.googleapis.com/"
     "v2alpha1/pipelines:run"
     #{}
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
