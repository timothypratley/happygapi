(ns happygapi.vpcaccess.projects
  "Serverless VPC Access API: projects.
  API for managing VPC access connectors.
  See: https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vpcaccess.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vpcaccess.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vpcaccess.googleapis.com/"
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

(defn locations-connectors-create$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/connectors/create
  
  Required parameters: parent
  
  Optional parameters: connectorId
  
  Body: 
  
  {:name string,
   :ipCidrRange string,
   :minInstances integer,
   :state string,
   :machineType string,
   :minThroughput integer,
   :network string,
   :maxInstances integer,
   :maxThroughput integer,
   :subnet {:name string, :projectId string},
   :connectedProjects [string]}
  
  Creates a Serverless VPC Access connector, returns an operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vpcaccess.googleapis.com/"
     "v1/{+parent}/connectors"
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

(defn locations-connectors-patch$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/connectors/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :ipCidrRange string,
   :minInstances integer,
   :state string,
   :machineType string,
   :minThroughput integer,
   :network string,
   :maxInstances integer,
   :maxThroughput integer,
   :subnet {:name string, :projectId string},
   :connectedProjects [string]}
  
  Updates a Serverless VPC Access connector, returns an operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vpcaccess.googleapis.com/"
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

(defn locations-connectors-get$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/connectors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vpcaccess.googleapis.com/"
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

(defn locations-connectors-list$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/connectors/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Serverless VPC Access connectors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vpcaccess.googleapis.com/"
     "v1/{+parent}/connectors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connectors-delete$
  "https://cloud.google.com/vpc/docs/configure-serverless-vpc-accessapi/reference/rest/v1/projects/locations/connectors/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Serverless VPC Access connector. Returns NOT_FOUND if the resource does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vpcaccess.googleapis.com/"
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
