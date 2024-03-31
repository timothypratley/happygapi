(ns happygapi.bigquerydatapolicy.projects
  "BigQuery Data Policy API: projects.
  Allows users to manage BigQuery data policies.
  See: https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-dataPolicies-get$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the data policy specified by its resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
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

(defn locations-dataPolicies-setIamPolicy$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy for the specified data policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-dataPolicies-patch$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:policyTag string,
   :dataMaskingPolicy {:predefinedExpression string, :routine string},
   :name string,
   :dataPolicyType string,
   :dataPolicyId string}
  
  Updates the metadata for an existing data policy. The target data policy can be specified by the resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
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

(defn locations-dataPolicies-testIamPermissions$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the caller's permission on the specified data policy resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-dataPolicies-create$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:policyTag string,
   :dataMaskingPolicy {:predefinedExpression string, :routine string},
   :name string,
   :dataPolicyType string,
   :dataPolicyId string}
  
  Creates a new data policy under a project with the given `dataPolicyId` (used as the display name), policy tag, and data policy type."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+parent}/dataPolicies"
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

(defn locations-dataPolicies-delete$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the data policy specified by its resource name."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
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

(defn locations-dataPolicies-rename$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newDataPolicyId string}
  
  Renames the id (display name) of the specified data policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+name}:rename"
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

(defn locations-dataPolicies-getIamPolicy$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy for the specified data policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
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

(defn locations-dataPolicies-list$
  "https://cloud.google.com/bigquery/docs/column-data-maskingapi/reference/rest/v1/projects/locations/dataPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List all of the data policies in the specified parent project."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatapolicy.googleapis.com/"
     "v1/{+parent}/dataPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
