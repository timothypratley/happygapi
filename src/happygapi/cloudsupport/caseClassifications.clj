(ns happygapi.cloudsupport.caseClassifications
  "Google Cloud Support API: caseClassifications.
  Manages Google Cloud technical support cases for Customer Care support offerings. 
  See: https://cloud.google.com/support/docs/apisdocs/reference/rest/v2/caseClassifications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/support/docs/apisapi/reference/rest/v2/caseClassifications/search
  
  Required parameters: none
  
  Optional parameters: pageToken, query, pageSize
  
  Retrieve valid classifications to use when creating a support case. Classifications are hierarchical. Each classification is a string containing all levels of the hierarchy separated by `\" > \"`. For example, `\"Technical Issue > Compute > Compute Engine\"`. Classification IDs returned by this endpoint are valid for at least six months. When a classification is deactivated, this endpoint immediately stops returning it. After six months, `case.create` requests using the classification will fail. EXAMPLES: cURL: ```shell curl \\ --header \"Authorization: Bearer $(gcloud auth print-access-token)\" \\ 'https://cloudsupport.googleapis.com/v2/caseClassifications:search?query=display_name:\"*Compute%20Engine*\"' ``` Python: ```python import googleapiclient.discovery supportApiService = googleapiclient.discovery.build( serviceName=\"cloudsupport\", version=\"v2\", discoveryServiceUrl=f\"https://cloudsupport.googleapis.com/$discovery/rest?version=v2\", ) request = supportApiService.caseClassifications().search( query='display_name:\"*Compute Engine*\"' ) print(request.execute()) ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsupport.googleapis.com/"
     "v2/caseClassifications:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
