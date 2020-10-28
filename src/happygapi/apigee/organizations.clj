(ns happygapi.apigee.organizations
  "Apigee API: organizations.
  Use the Apigee API to programmatically develop and manage APIs with a set of RESTful operations. Develop and secure API proxies, deploy and undeploy API proxy revisions, monitor APIs, configure environments, manage users, and more. Get started using the APIs. *Note:* This product is available as a free trial for a time period of 60 days.
  See: https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the Apigee organizations and associated GCP projects that you have permission to access. See [Understanding organizations](https://cloud.google.com/apigee/docs/api-platform/fundamentals/organization-structure)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getDeployedIngressConfig$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getDeployedIngressConfig
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets the deployed ingress configuration for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :analyticsRegion string,
   :runtimeType string,
   :displayName string,
   :name string,
   :caCertificate string,
   :customerName string,
   :createdAt string,
   :type string,
   :environments [string],
   :lastModifiedAt string,
   :projectId string,
   :attributes [string],
   :subscriptionType string,
   :authorizedNetwork string}
  
  Updates the properties for an Apigee organization. No other fields in the organization profile will be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn setSyncAuthorization$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/setSyncAuthorization
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:identities [string], :etag string}
  
  Sets the permissions required to allow the Synchronizer to download environment data from the control plane. You must call this API to enable proper functioning of hybrid. Pass the ETag when calling `setSyncAuthorization` to ensure that you are updating the correct version. To get an ETag, call [getSyncAuthorization](getSyncAuthorization). If you don't pass the ETag in the call to `setSyncAuthorization`, then the existing authorization is overwritten indiscriminately. For more information, see [Configure the Synchronizer](https://cloud.google.com/apigee/docs/hybrid/latest/synchronizer-access). **Note**: Available to Apigee hybrid only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}:setSyncAuthorization"
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

(defn get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the profile for an Apigee organization. See [Understanding organizations](https://cloud.google.com/apigee/docs/api-platform/fundamentals/organization-structure)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/create
  
  Required parameters: none
  
  Optional parameters: parent
  
  Body: 
  
  {:description string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :analyticsRegion string,
   :runtimeType string,
   :displayName string,
   :name string,
   :caCertificate string,
   :customerName string,
   :createdAt string,
   :type string,
   :environments [string],
   :lastModifiedAt string,
   :projectId string,
   :attributes [string],
   :subscriptionType string,
   :authorizedNetwork string}
  
  Creates an Apigee organization. See [Create an Apigee organization](https://cloud.google.com/apigee/docs/api-platform/get-started/create-org)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/organizations"
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

(defn getSyncAuthorization$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/getSyncAuthorization
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Lists the service accounts with the permissions required to allow the Synchronizer to download environment data from the control plane. An ETag is returned in the response to `getSyncAuthorization`. Pass that ETag when calling [setSyncAuthorization](setSyncAuthorization) to ensure that you are updating the correct version. If you don't pass the ETag in the call to `setSyncAuthorization`, then the existing authorization is overwritten indiscriminately. For more information, see [Configure the Synchronizer](https://cloud.google.com/apigee/docs/hybrid/latest/synchronizer-access). **Note**: Available to Apigee hybrid only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}:getSyncAuthorization"
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

(defn apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the app profile for the specified app ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apps/list
  
  Required parameters: parent
  
  Optional parameters: startKey, apiProduct, ids, keyStatus, rows, status, includeCred, expand, apptype
  
  Lists IDs of apps within an organization that have the specified app status (approved or revoked) or are of the specified app type (developer or company)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:createdAt string,
   :hostnames [string],
   :lastModifiedAt string,
   :name string}
  
  Creates a new environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/envgroups"
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

(defn envgroups-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all environment groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/envgroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn envgroups-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-patch$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createdAt string,
   :hostnames [string],
   :lastModifiedAt string,
   :name string}
  
  Updates an environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-attachments-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/attachments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an environment group attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-attachments-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/attachments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createdAt string, :environment string, :name string}
  
  Creates a new attachment of an environment to an environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attachments"
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

(defn envgroups-attachments-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/attachments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an environment group attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn envgroups-attachments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/envgroups/attachments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all attachments of an environment group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attachments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apicategories-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apicategories/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a category on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sites-apicategories-patch$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apicategories/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :name string, :updateTime string, :siteId string}
  
  Updates a category on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sites-apicategories-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apicategories/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :name string, :updateTime string, :siteId string}
  
  Creates a new category on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apicategories"
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

(defn sites-apicategories-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apicategories/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the categories on the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apicategories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-apicategories-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sites/apicategories/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a category from the portal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API product from an organization. Deleting an API product causes app requests to the resource URIs defined in the API product to fail. Ensure that you create a new API product to serve existing apps, unless your intention is to disable access to the resources defined in the API product. The API product name required in the request URL is the internal name of the product, not the display name. While they may be the same, it depends on whether the API product was created via the UI or the API. View the list of API products to verify the internal name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets configuration details for an API product. The API product name required in the request URL is the internal name of the product, not the display name. While they may be the same, it depends on whether the API product was created via the UI or the API. View the list of API products to verify the internal name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :description string,
   :displayName string,
   :name string,
   :createdAt string,
   :approvalType string,
   :quota string,
   :environments [string],
   :quotaTimeUnit string,
   :proxies [string],
   :lastModifiedAt string,
   :quotaInterval string,
   :attributes [{:value string, :name string}],
   :operationGroup {:operationConfigType string,
                    :operationConfigs [GoogleCloudApigeeV1OperationConfig]},
   :apiResources [string]}
  
  Creates an API product in an organization. You create API products after you have proxied backend services using API proxies. An API product is a collection of API resources combined with quota settings and metadata that you can use to deliver customized and productized API bundles to your developer community. This metadata can include: - Scope - Environments - API proxies - Extensible profile API products enable you repackage APIs on-the-fly, without having to do any additional coding or configuration. Apigee recommends that you start with a simple API product including only required elements. You then provision credentials to apps to enable them to start testing your APIs. After you have authentication and authorization working against a simple API product, you can iterate to create finer grained API products, defining different sets of API resources for each API product. *WARNING:* - If you don't specify an API proxy in the request body, *any* app associated with the product can make calls to *any* API in your entire organization. - If you don't specify an environment in the request body, the product allows access to all environments. For more information, see {{what_api_product}}"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apiproducts"
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

(defn apiproducts-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/list
  
  Required parameters: parent
  
  Optional parameters: expand, count, attributename, startKey, attributevalue
  
  Lists all API product names for an organization. Filter the list by passing an `attributename` and `attibutevalue`. The limit on the number of API products returned by the API is 1000. You can paginate the list of API products returned using the `startKey` and `count` query parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apiproducts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates or creates API product attributes. This API **replaces** the current list of attributes with the attributes specified in the request body. In this way, you can update existing attributes, add new attributes, or delete existing attributes by omitting them from the request body. OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (current default). Any custom attributes associated with entities also get cached for at least 180 seconds after entity is accessed during runtime. In this case, the `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/attributes"
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

(defn apiproducts-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :description string,
   :displayName string,
   :name string,
   :createdAt string,
   :approvalType string,
   :quota string,
   :environments [string],
   :quotaTimeUnit string,
   :proxies [string],
   :lastModifiedAt string,
   :quotaInterval string,
   :attributes [{:value string, :name string}],
   :operationGroup {:operationConfigType string,
                    :operationConfigs [GoogleCloudApigeeV1OperationConfig]},
   :apiResources [string]}
  
  Updates an existing API product. You must include all required values, whether or not you are updating them, as well as any optional values that you are updating. The API product name required in the request URL is the internal name of the product, not the Display Name. While they may be the same, it depends on whether the API product was created via UI or API. View the list of API products to identify their internal names."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all API product attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apiproducts-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API product attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the value of an API product attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apiproducts-attributes-updateApiProductAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apiproducts/attributes/updateApiProductAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates the value of an API product attribute. Limitations are: OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (current default). Any custom attributes associated with entities also get cached for at least 180 seconds after entity is accessed during runtime. In this case, the `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a shared flow by name, including a list of its revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a shared flow and all it's revisions. The shared flow must be undeployed before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/list
  
  Required parameters: parent
  
  Optional parameters: includeRevisions, includeMetaData
  
  Lists all shared flows in the organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sharedflows"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/create
  
  Required parameters: parent
  
  Optional parameters: action, name
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Uploads a ZIP-formatted shared flow configuration bundle to an organization. If the shared flow already exists, this creates a new revision of it. If the shared flow does not exist, this creates it. Once imported, the shared flow revision must be deployed before it can be accessed at runtime. The size limit of a shared flow bundle is 15 MB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/sharedflows"
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

(defn sharedflows-revisions-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/get
  
  Required parameters: name
  
  Optional parameters: format
  
  Gets a revision of a shared flow. If `format=bundle` is passed, it instead outputs a shared flow revision as a ZIP-formatted bundle of code and config files."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-revisions-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a shared flow and all associated policies, resources, and revisions. You must undeploy the shared flow before deleting it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-revisions-updateSharedFlowRevision$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/updateSharedFlowRevision
  
  Required parameters: name
  
  Optional parameters: validate
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Updates a shared flow revision. This operation is only allowed on revisions which have never been deployed. After deployment a revision becomes immutable, even if it becomes undeployed. The payload is a ZIP-formatted shared flow. Content type must be either multipart/form-data or application/octet-stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn sharedflows-revisions-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/revisions/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sharedflows-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/sharedflows/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/deployments/list
  
  Required parameters: parent
  
  Optional parameters: sharedFlows
  
  Lists all deployments of API proxies or shared flows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets environment details."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-unsubscribe$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/unsubscribe
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string}
  
  Deletes a subscription for the environment's Pub/Sub topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}:unsubscribe"
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

(defn environments-updateDebugmask$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/updateDebugmask
  
  Required parameters: name
  
  Optional parameters: updateMask, replaceRepeatedFields
  
  Body: 
  
  {:namespaces {},
   :responseXPaths [string],
   :name string,
   :variables [string],
   :requestJSONPaths [string],
   :requestXPaths [string],
   :faultJSONPaths [string],
   :faultXPaths [string],
   :responseJSONPaths [string]}
  
  Updates the debug mask singleton resource for an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-setIamPolicy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [GoogleIamV1AuditConfig],
            :bindings [GoogleIamV1Binding],
            :etag string,
            :version integer}}
  
  Sets the IAM policy on an environment, if the policy already exists it will be replaced. For more information, see [Manage users, roles, and permissions using the API](https://cloud.google.com/apigee/docs/api-platform/system-administration/manage-users-roles). You must have the `apigee.environments.setIamPolicy` permission to call this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-testIamPermissions$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests the permissions of a user on an environment, and returns a subset of permissions that the user has on the environment. If the environment does not exist, an empty permission set is returned (a NOT_FOUND error is not returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:displayName string,
   :lastModifiedAt string,
   :createdAt string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :name string,
   :description string}
  
  Creates an environment in an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/environments"
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

(defn environments-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :lastModifiedAt string,
   :createdAt string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :name string,
   :description string}
  
  Updates an existing environment. When updating properties, you must pass all existing properties to the API, even if they are not being changed. If you omit properties from the payload, the properties are removed. To get the current list of properties for the environment, use the [Get Environment API](get)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an environment from an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-getIamPolicy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM policy on an environment. For more information, see [Manage users, roles, and permissions using the API](https://cloud.google.com/apigee/docs/api-platform/system-administration/manage-users-roles). You must have the `apigee.environments.getIamPolicy` permission to call this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-getDebugmask$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getDebugmask
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the debug mask singleton resource for an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-updateEnvironment$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/updateEnvironment
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :lastModifiedAt string,
   :createdAt string,
   :properties {:property [GoogleCloudApigeeV1Property]},
   :name string,
   :description string}
  
  Updates an existing environment. When updating properties, you must pass all existing properties to the API, even if they are not being changed. If you omit properties from the payload, the properties are removed. To get the current list of properties for the environment, use the [Get Environment API](get)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-getDeployedConfig$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/getDeployedConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployed configuration for an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-subscribe$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/subscribe
  
  Required parameters: parent
  
  Optional parameters: none
  
  Creates a subscription for the environment's Pub/Sub topic. The server will assign a random name for this subscription. The \"name\" and \"push_config\" must *not* be specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}:subscribe"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-caches-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/caches/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a cache."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-resourcefiles-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/update
  
  Required parameters: name, parent, type
  
  Optional parameters: none
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Updates a resource file. Specify the `Content-Type` as `application/octet-stream` or `multipart/form-data`. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
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

(defn environments-resourcefiles-listEnvironmentResources$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/listEnvironmentResources
  
  Required parameters: parent, type
  
  Optional parameters: none
  
  Lists all resource files, optionally filtering by type. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :type})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}"
     #{:parent :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/list
  
  Required parameters: parent
  
  Optional parameters: type
  
  Lists all resource files, optionally filtering by type. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/create
  
  Required parameters: parent
  
  Optional parameters: type, name
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Creates a resource file. Specify the `Content-Type` as `application/octet-stream` or `multipart/form-data`. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles"
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

(defn environments-resourcefiles-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/get
  
  Required parameters: name, parent, type
  
  Optional parameters: none
  
  Gets the contents of a resource file. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-resourcefiles-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/resourcefiles/delete
  
  Required parameters: parent, name, type
  
  Optional parameters: none
  
  Deletes a resource file. For more information about resource files, see [Resource files](https://cloud.google.com/apigee/docs/api-platform/develop/resource-files)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name :type})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/resourcefiles/{type}/{name}"
     #{:parent :name :type}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn environments-flowhooks-detachSharedFlowFromFlowHook$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/detachSharedFlowFromFlowHook
  
  Required parameters: name
  
  Optional parameters: none
  
  Detaches a shared flow from a flow hook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-flowhooks-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the name of the shared flow attached to the specified flow hook. If there's no shared flow attached to the flow hook, the API does not return an error; it simply does not return a name in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-flowhooks-attachSharedFlowToFlowHook$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/flowhooks/attachSharedFlowToFlowHook
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:sharedFlow string,
   :continueOnError boolean,
   :description string,
   :flowHookPoint string}
  
  Attaches a shared flow to a flow hook."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-references-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:refers string,
   :resourceType string,
   :name string,
   :description string}
  
  Creates a Reference in the specified environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/references"
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

(defn environments-references-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Reference resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-references-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:refers string,
   :resourceType string,
   :name string,
   :description string}
  
  Updates an existing Reference. Note that this operation has PUT semantics; it will replace the entirety of the existing Reference with the resource in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-references-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/references/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Reference from an environment. Returns the deleted Reference resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-sharedflows-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of a shared flow in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-revisions-undeploy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/revisions/undeploy
  
  Required parameters: name
  
  Optional parameters: none
  
  Undeploys a shared flow revision from an environment. For a request path `organizations/{org}/environments/{env}/sharedflows/{sf}/revisions/{rev}/deployments`, two permissions are required: * `apigee.deployments.delete` on the resource `organizations/{org}/environments/{env}` * `apigee.sharedflowrevisions.undeploy` on the resource `organizations/{org}/sharedflows/{sf}/revisions/{rev}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-revisions-deploy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/revisions/deploy
  
  Required parameters: name
  
  Optional parameters: override
  
  Deploys a revision of a shared flow. If another revision of the same shared flow is currently deployed, set the `override` parameter to `true` to have this revision replace the currently deployed revision. You cannot use a shared flow until it has been deployed to an environment. For a request path `organizations/{org}/environments/{env}/sharedflows/{sf}/revisions/{rev}/deployments`, two permissions are required: * `apigee.deployments.create` on the resource `organizations/{org}/environments/{env}` * `apigee.sharedflowrevisions.deploy` on the resource `organizations/{org}/sharedflows/{sf}/revisions/{rev}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-sharedflows-revisions-getDeployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/sharedflows/revisions/getDeployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployment of a shared flow revision and actual state reported by runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/deployments/list
  
  Required parameters: parent
  
  Optional parameters: sharedFlows
  
  Lists all deployments of API proxies or shared flows in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-analytics-admin-getSchemav2$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/analytics/admin/getSchemav2
  
  Required parameters: name
  
  Optional parameters: type
  
  Get a list of metrics and dimensions which can be used for creating analytics queries and reports. Each schema element contains the name of the field with its associated type and if it is either custom field or standard field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-analytics-exports-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/analytics/exports/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the details and status of all analytics export jobs belonging to the parent organization and environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/analytics/exports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-analytics-exports-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/analytics/exports/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :dateRange {:start string, :end string},
   :datastoreName string,
   :outputFormat string,
   :csvDelimiter string,
   :description string}
  
  Submit a data export job to be processed in the background. If the request is successful, the API returns a 201 status, a URI that can be used to retrieve the status of the export job, and the `state` value of \"enqueued\"."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/analytics/exports"
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

(defn environments-analytics-exports-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/analytics/exports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details and status of an analytics export job. If the export job is still in progress, its `state` is set to \"running\". After the export job has completed successfully, its `state` is set to \"completed\". If the export job fails, its `state` is set to `failed`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-optimizedStats-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/optimizedStats/get
  
  Required parameters: name
  
  Optional parameters: tzo, aggTable, limit, offset, timeRange, accuracy, realtime, sonar, topk, sortby, tsAscending, filter, timeUnit, sort, select
  
  This api is similar to GetStats except that the response is less verbose. In the current scheme, a query parameter _optimized instructs Edge Analytics to change the response but since this behavior is not possible with protocol buffer and since this parameter is predominantly used by Edge UI, we are introducing a separate api."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a keystore or truststore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:aliases [string], :name string}
  
  Creates a keystore or truststore: * Keystore: Contains certificates and their associated keys. * Truststore: Contains trusted certificates used to validate a server's certificate. These certificates are typically self-signed certificates or certificates that are not signed by a trusted CA."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keystores"
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

(defn environments-keystores-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a keystore or truststore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-aliases-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/update
  
  Required parameters: name
  
  Optional parameters: ignoreExpiryValidation, ignoreNewlineValidation
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Updates the certificate in an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-aliases-csr$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/csr
  
  Required parameters: name
  
  Optional parameters: none
  
  Generates a PKCS #10 Certificate Signing Request for the private key in an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/csr"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-keystores-aliases-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-aliases-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an alias."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-keystores-aliases-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/create
  
  Required parameters: parent
  
  Optional parameters: format, _password, ignoreNewlineValidation, alias, ignoreExpiryValidation
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Creates an alias from a key, certificate pair. The structure of the request is controlled by the `format` query parameter: * `keycertfile` - Separate PEM-encoded key and certificate files are uploaded. The request must have `Content-Type: multipart/form-data` and include fields `keyFile` and `certFile`. If uploading to a truststore, omit `keyFile`. A `password` field should be provided for encrypted keys. * `pkcs12` - A PKCS12 file is uploaded. The request must have `Content-Type: multipart/form-data` with the file provided in the `file` field and a `password` field if the file is encrypted. * `selfsignedcert` - A new private key and certificate are generated. The request must have `Content-Type: application/json` and a body of CertificateGenerationSpec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/aliases"
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

(defn environments-keystores-aliases-getCertificate$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/keystores/aliases/getCertificate
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the certificate from an alias in PEM-encoded form."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/certificate"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-targetservers-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :sSLInfo {:protocols [string],
             :keyStore string,
             :keyAlias string,
             :trustStore string,
             :clientAuthEnabled boolean,
             :commonName GoogleCloudApigeeV1TlsInfoCommonName,
             :ciphers [string],
             :enabled boolean,
             :ignoreValidationErrors boolean},
   :isEnabled boolean,
   :port integer,
   :host string,
   :name string}
  
  Updates an existing TargetServer. Note that this operation has PUT semantics; it will replace the entirety of the existing TargetServer with the resource in the request body."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-targetservers-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/create
  
  Required parameters: parent
  
  Optional parameters: name
  
  Body: 
  
  {:description string,
   :sSLInfo {:protocols [string],
             :keyStore string,
             :keyAlias string,
             :trustStore string,
             :clientAuthEnabled boolean,
             :commonName GoogleCloudApigeeV1TlsInfoCommonName,
             :ciphers [string],
             :enabled boolean,
             :ignoreValidationErrors boolean},
   :isEnabled boolean,
   :port integer,
   :host string,
   :name string}
  
  Creates a TargetServer in the specified environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/targetservers"
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

(defn environments-targetservers-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TargetServer resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-targetservers-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/targetservers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TargetServer from an environment. Returns the deleted TargetServer resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-apis-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy in an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-deploy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/deploy
  
  Required parameters: name
  
  Optional parameters: override, sequencedRollout
  
  Deploys a revision of an API proxy. If another revision of the same API proxy revision is currently deployed, set the `override` parameter to `true` to have this revision replace the currently deployed revision. You cannot invoke an API proxy until it has been deployed to an environment. After you deploy an API proxy revision, you cannot edit it. To edit the API proxy, you must create and deploy a new revision. For a request path `organizations/{org}/environments/{env}/apis/{api}/revisions/{rev}/deployments`, two permissions are required: * `apigee.deployments.create` on the resource `organizations/{org}/environments/{env}` * `apigee.proxyrevisions.deploy` on the resource `organizations/{org}/apis/{api}/revisions/{rev}` "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-getDeployments$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/getDeployments
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the deployment of an API proxy revision and actual state reported by runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-undeploy$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/undeploy
  
  Required parameters: name
  
  Optional parameters: sequencedRollout
  
  Undeploys an API proxy revision from an environment. For a request path `organizations/{org}/environments/{env}/apis/{api}/revisions/{rev}/deployments`, two permissions are required: * `apigee.deployments.delete` on the resource `organizations/{org}/environments/{env}` * `apigee.proxyrevisions.undeploy` on the resource `organizations/{org}/apis/{api}/revisions/{rev}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-deployments-generateUndeployChangeReport$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/deployments/generateUndeployChangeReport
  
  Required parameters: name
  
  Optional parameters: none
  
  Generates a report for a dry run analysis of an UndeployApiProxy request without committing the undeploy. In addition to the standard validations performed when removing deployments, additional analysis will be done to detect possible traffic routing changes that would result from this deployment being removed. Any potential routing conflicts or unsafe changes will be reported in the response. This routing analysis is not performed for a non-dry-run UndeployApiProxy request. For a request path `organizations/{org}/environments/{env}/apis/{api}/revisions/{rev}/deployments:generateUndeployChangeReport`, two permissions are required: * `apigee.deployments.delete` on the resource `organizations/{org}/environments/{env}` * `apigee.proxyrevisions.undeploy` on the resource `organizations/{org}/apis/{api}/revisions/{rev}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments:generateUndeployChangeReport"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-deployments-generateDeployChangeReport$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/deployments/generateDeployChangeReport
  
  Required parameters: name
  
  Optional parameters: override
  
  Generates a report for a dry run analysis of a DeployApiProxy request without committing the deployment. In addition to the standard validations performed when adding deployments, additional analysis will be done to detect possible traffic routing changes that would result from this deployment being created. Any potential routing conflicts or unsafe changes will be reported in the response. This routing analysis is not performed for a non-dry-run DeployApiProxy request. For a request path `organizations/{org}/environments/{env}/apis/{api}/revisions/{rev}/deployments:generateDeployChangeReport`, two permissions are required: * `apigee.deployments.create` on the resource `organizations/{org}/environments/{env}` * `apigee.proxyrevisions.deploy` on the resource `organizations/{org}/apis/{api}/revisions/{rev}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/deployments:generateDeployChangeReport"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a debug session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-apis-revisions-debugsessions-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/create
  
  Required parameters: parent
  
  Optional parameters: timeout
  
  Body: 
  
  {:count integer,
   :tracesize integer,
   :name string,
   :filter string,
   :timeout string,
   :validity integer}
  
  Creates a debug session for a deployed API Proxy revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/debugsessions"
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

(defn environments-apis-revisions-debugsessions-deleteData$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/deleteData
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the data from a debug session. This does not cancel the debug session or prevent further data from being collected if the session is still active in runtime pods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/data"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists debug sessions that are currently active in the given API Proxy revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/debugsessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-apis-revisions-debugsessions-data-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/apis/revisions/debugsessions/data/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the debug data from a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-queries-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportDefinitionId string,
   :limit integer,
   :timeRange any,
   :name string,
   :outputFormat string,
   :dimensions [string],
   :filter string,
   :csvDelimiter string,
   :groupByTimeUnit string,
   :metrics [{:value string,
              :alias string,
              :operator string,
              :name string,
              :function string}]}
  
  Submit a query to be processed in the background. If the submission of the query succeeds, the API returns a 201 status and an ID that refer to the query. In addition to the HTTP status 201, the `state` of \"enqueued\" means that the request succeeded."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/queries"
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

(defn environments-queries-getResult$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/getResult
  
  Required parameters: name
  
  Optional parameters: none
  
  After the query is completed, use this API to retrieve the results. If the request succeeds, and there is a non-zero result set, the result is downloaded to the client as a zipped JSON file. The name of the downloaded file will be: OfflineQueryResult-.zip Example: `OfflineQueryResult-9cfc0d85-0f30-46d6-ae6f-318d0cb961bd.zip`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-queries-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/list
  
  Required parameters: parent
  
  Optional parameters: submittedBy, dataset, from, inclQueriesWithoutReport, to, status
  
  Return a list of Asynchronous Queries"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/queries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn environments-queries-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/queries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get query status If the query is still in progress, the `state` is set to \"running\" After the query has completed successfully, `state` is set to \"completed\""
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn environments-stats-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/environments/stats/get
  
  Required parameters: name
  
  Optional parameters: tzo, aggTable, limit, offset, timeRange, accuracy, realtime, sonar, topk, sortby, tsAscending, filter, timeUnit, sort, select
  
  Retrieve metrics grouped by dimensions. The types of metrics you can retrieve include traffic, message counts, API call latency, response size, and cache hits and counts. Dimensions let you view metrics in meaningful groups. The stats api does accept dimensions as path params. The dimensions are optional in which case the metrics are computed on the entire data for the given timerange."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn analytics-datastores-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:targetType string,
   :datastoreConfig {:projectId string,
                     :bucketName string,
                     :tablePrefix string,
                     :path string,
                     :datasetName string},
   :lastUpdateTime string,
   :createTime string,
   :displayName string,
   :self string,
   :org string}
  
  Create a Datastore for an org"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/analytics/datastores"
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

(defn analytics-datastores-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetType string,
   :datastoreConfig {:projectId string,
                     :bucketName string,
                     :tablePrefix string,
                     :path string,
                     :datasetName string},
   :lastUpdateTime string,
   :createTime string,
   :displayName string,
   :self string,
   :org string}
  
  Update a Datastore"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn analytics-datastores-test$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/test
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:targetType string,
   :datastoreConfig {:projectId string,
                     :bucketName string,
                     :tablePrefix string,
                     :path string,
                     :datasetName string},
   :lastUpdateTime string,
   :createTime string,
   :displayName string,
   :self string,
   :org string}
  
  Test if Datastore configuration is correct. This includes checking if credentials provided by customer have required permissions in target destination storage"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/analytics/datastores:test"
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

(defn analytics-datastores-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a Datastore from an org."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn analytics-datastores-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/list
  
  Required parameters: parent
  
  Optional parameters: targetType
  
  List Datastores"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/analytics/datastores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn analytics-datastores-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/analytics/datastores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a Datastore"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates developer attributes. This API replaces the existing attributes with those specified in the request. Add new attributes, and include or exclude any existing attributes that you want to retain or remove, respectively. The custom attribute limit is 18. **Note**: OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (default). Any custom attributes associated with these entities are cached for at least 180 seconds after the entity is accessed at runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
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

(defn developers-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer. All apps and API keys associated with the developer are also removed. **Warning**: This API will permanently delete the developer and related artifacts. To avoid permanently deleting developers and their artifacts, set the developer status to `inactive` using the SetDeveloperStatus API. **Note**: The delete operation is asynchronous. The developer app is deleted immediately, but its associated resources, such as apps and API keys, may take anywhere from a few seconds to a few minutes to be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/list
  
  Required parameters: parent
  
  Optional parameters: expand, ids, includeCompany, count, startKey
  
  Lists all developers in an organization by email address. By default, the response does not include company developers. Set the `includeCompany` query parameter to `true` to include company developers. **Note**: A maximum of 1000 developers are returned in the response. You paginate the list of developers returned using the `startKey` and `count` query parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/developers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/get
  
  Required parameters: name
  
  Optional parameters: action
  
  Returns the developer details, including the developer's name, email address, apps, and other information. **Note**: The response includes only the first 100 developer apps."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-setDeveloperStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/setDeveloperStatus
  
  Required parameters: name
  
  Optional parameters: action
  
  Sets the status of a developer. Valid values are `active` or `inactive`. A developer is `active` by default. If you set a developer's status to `inactive`, the API keys assigned to the developer apps are no longer valid even though the API keys are set to `approved`. Inactive developers can still sign in to the developer portal and create apps; however, any new API keys generated during app creation won't work. If successful, the API call returns the following HTTP status code: `204 No Content`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:apps [string],
   :email string,
   :accessType string,
   :appFamily string,
   :firstName string,
   :createdAt string,
   :organizationName string,
   :developerId string,
   :status string,
   :lastModifiedAt string,
   :lastName string,
   :companies [string],
   :attributes [{:value string, :name string}],
   :userName string}
  
  Updates a developer. This API replaces the existing developer details with those specified in the request. Include or exclude any existing details that you want to retain or delete, respectively. The custom attribute limit is 18. **Note**: OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (current default). Any custom attributes associated with these entities are cached for at least 180 seconds after the entity is accessed at runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:apps [string],
   :email string,
   :accessType string,
   :appFamily string,
   :firstName string,
   :createdAt string,
   :organizationName string,
   :developerId string,
   :status string,
   :lastModifiedAt string,
   :lastName string,
   :companies [string],
   :attributes [{:value string, :name string}],
   :userName string}
  
  Creates a developer. Once created, the developer can register an app and obtain an API key. At creation time, a developer is set as `active`. To change the developer status, use the SetDeveloperStatus API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/developers"
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

(defn developers-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the value of the specified developer attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-attributes-updateDeveloperAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/updateDeveloperAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates a developer attribute. **Note**: OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (default). Any custom attributes associated with these entities are cached for at least 180 seconds after the entity is accessed at runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all developer attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:scopes [string],
                  :issuedAt string,
                  :expiresAt string,
                  :status string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute],
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :consumerSecret string}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Updates the details for a developer app. In addition, you can add an API product to a developer app and automatically generate an API key for the app to use when calling APIs in the API product. If you want to use an existing API key for the API product, add the API product to the API key using the UpdateDeveloperAppKey API. Using this API, you cannot update the following: * App name as it is the primary key used to identify the app and cannot be changed. * Scopes associated with the app. Instead, use the ReplaceDeveloperAppKey API. This API replaces the existing attributes with those specified in the request. Include or exclude any existing attributes that you want to retain or delete, respectively."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-generateKeyPairOrUpdateDeveloperAppStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/generateKeyPairOrUpdateDeveloperAppStatus
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:scopes [string],
                  :issuedAt string,
                  :expiresAt string,
                  :status string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute],
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :consumerSecret string}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Manages access to a developer app by enabling you to: * Approve or revoke a developer app * Generate a new consumer key and secret for a developer app To approve or revoke a developer app, set the `action` query parameter to `approved` or `revoked`, respectively, and the `Content-Type` header to `application/octet-stream`. If a developer app is revoked, none of its API keys are valid for API calls even though the keys are still `approved`. If successful, the API call returns the following HTTP status code: `204 No Content` To generate a new consumer key and secret for a developer app, pass the new key/secret details. Rather than replace an existing key, this API generates a new key. In this case, multiple key pairs may be associated with a single developer app. Each key pair has an independent status (`approved` or `revoked`) and expiration time. Any approved, non-expired key can be used in an API call. For example, if you're using API key rotation, you can generate new keys with expiration times that overlap keys that are going to expire. You might also generate a new consumer key/secret if the security of the original key/secret is compromised. The `keyExpiresIn` property defines the expiration time for the API key in milliseconds. If you don't set this property or set it to `-1`, the API key never expires. **Notes**: * When generating a new key/secret, this API replaces the existing attributes, notes, and callback URLs with those specified in the request. Include or exclude any existing information that you want to retain or delete, respectively. * To migrate existing consumer keys and secrets to hybrid from another system, see the CreateDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer app. **Note**: The delete operation is asynchronous. The developer app is deleted immediately, but its associated resources, such as app keys or access tokens, may take anywhere from a few seconds to a few minutes to be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/get
  
  Required parameters: name
  
  Optional parameters: entity, query
  
  Returns the details for a developer app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :callbackUrl string,
   :apiProducts [string],
   :credentials [{:scopes [string],
                  :issuedAt string,
                  :expiresAt string,
                  :status string,
                  :consumerKey string,
                  :attributes [GoogleCloudApigeeV1Attribute],
                  :apiProducts [GoogleCloudApigeeV1ApiProductRef],
                  :consumerSecret string}],
   :name string,
   :appFamily string,
   :keyExpiresIn string,
   :createdAt string,
   :developerId string,
   :status string,
   :appId string,
   :lastModifiedAt string,
   :attributes [{:value string, :name string}]}
  
  Creates an app associated with a developer. This API associates the developer app with the specified API product and auto-generates an API key for the app to use in calls to API proxies inside that API product. The `name` is the unique ID of the app that you can use in API calls. The `DisplayName` (set as an attribute) appears in the UI. If you don't set the `DisplayName` attribute, the `name` appears in the UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
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

(defn developers-apps-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/list
  
  Required parameters: parent
  
  Optional parameters: expand, startKey, count, shallowExpand
  
  Lists all apps created by a developer in an Apigee organization. Optionally, you can request an expanded view of the developer apps. A maximum of 100 developer apps are returned per API call. You can paginate the list of deveoper apps returned using the `startKey` and `count` query parameters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-attributes$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [{:value string, :name string}]}
  
  Updates attributes for a developer app. This API replaces the current attributes with those specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+name}/attributes"
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

(defn developers-apps-keys-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :status string,
   :consumerSecret string,
   :issuedAt string,
   :expiresAt string,
   :apiProducts [any],
   :attributes [{:value string, :name string}],
   :consumerKey string}
  
  Creates a custom consumer key and secret for a developer app. This is particularly useful if you want to migrate existing consumer keys and secrets to Apigee hybrid from another system. Consumer keys and secrets can contain letters, numbers, underscores, and hyphens. No other special characters are allowed. To avoid service disruptions, a consumer key and secret should not exceed 2 KBs each. **Note**: When creating the consumer key and secret, an association to API products will not be made. Therefore, you should not specify the associated API products in your request. Instead, use the UpdateDeveloperAppKey API to make the association after the consumer key and secret are created. If a consumer key and secret already exist, you can keep them or delete them using the DeleteDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keys"
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

(defn developers-apps-keys-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an app's consumer key and removes all API products associated with the app. After the consumer key is deleted, it cannot be used to access any APIs. **Note**: After you delete a consumer key, you may want to: 1. Create a new consumer key and secret for the developer app using the CreateDeveloperAppKey API, and subsequently add an API product to the key using the UpdateDeveloperAppKey API. 2. Delete the developer app, if it is no longer required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-replaceDeveloperAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/replaceDeveloperAppKey
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :status string,
   :consumerSecret string,
   :issuedAt string,
   :expiresAt string,
   :apiProducts [any],
   :attributes [{:value string, :name string}],
   :consumerKey string}
  
  Updates the scope of an app. This API replaces the existing scopes with those specified in the request. Include or exclude any existing scopes that you want to retain or delete, respectively. The specified scopes must already be defined for the API products associated with the app. This API sets the `scopes` element under the `apiProducts` element in the attributes of the app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns details for a consumer key for a developer app, including the key and secret value, associated API products, and other information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-updateDeveloperAppKey$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/updateDeveloperAppKey
  
  Required parameters: name
  
  Optional parameters: action
  
  Body: 
  
  {:scopes [string],
   :status string,
   :consumerSecret string,
   :issuedAt string,
   :expiresAt string,
   :apiProducts [any],
   :attributes [{:value string, :name string}],
   :consumerKey string}
  
  Adds an API product to a developer app key, enabling the app that holds the key to access the API resources bundled in the API product. In addition, you can add attributes to a developer app key. This API replaces the existing attributes with those specified in the request. Include or exclude any existing attributes that you want to retain or delete, respectively. You can use the same key to access all API products associated with the app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-apiproducts-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/apiproducts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes an API product from an app's consumer key. After the API product is removed, the app cannot access the API resources defined in that API product. **Note**: The consumer key is not removed, only its association with the API product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-apiproducts-updateDeveloperAppKeyApiProduct$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/apiproducts/updateDeveloperAppKeyApiProduct
  
  Required parameters: name
  
  Optional parameters: action
  
  Approve or revoke an app's consumer key. After a consumer key is approved, the app can use it to access APIs. A consumer key that is revoked or pending cannot be used to access an API. Any access tokens associated with a revoked consumer key will remain active. However, Apigee hybrid checks the status of the consumer key and if set to `revoked` will not allow access to the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-keys-create-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/keys/create/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:scopes [string],
   :status string,
   :consumerSecret string,
   :issuedAt string,
   :expiresAt string,
   :apiProducts [any],
   :attributes [{:value string, :name string}],
   :consumerKey string}
  
  Creates a custom consumer key and secret for a developer app. This is particularly useful if you want to migrate existing consumer keys and secrets to Apigee hybrid from another system. Consumer keys and secrets can contain letters, numbers, underscores, and hyphens. No other special characters are allowed. To avoid service disruptions, a consumer key and secret should not exceed 2 KBs each. **Note**: When creating the consumer key and secret, an association to API products will not be made. Therefore, you should not specify the associated API products in your request. Instead, use the UpdateDeveloperAppKey API to make the association after the consumer key and secret are created. If a consumer key and secret already exist, you can keep them or delete them using the DeleteDeveloperAppKey API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keys/create"
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

(defn developers-apps-attributes-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a developer app attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-attributes-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Returns a list of all developer app attributes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attributes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn developers-apps-attributes-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a developer app attribute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn developers-apps-attributes-updateDeveloperAppAttribute$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/developers/apps/attributes/updateDeveloperAppAttribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:value string, :name string}
  
  Updates a developer app attribute. **Note**: OAuth access tokens and Key Management Service (KMS) entities (apps, developers, and API products) are cached for 180 seconds (current default). Any custom attributes associated with these entities are cached for at least 180 seconds after the entity is accessed at runtime. Therefore, an `ExpiresIn` element on the OAuthV2 policy won't be able to expire an access token in less than 180 seconds."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn instances-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Apigee runtime instance. The instance stops serving requests and the runtime data is deleted. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn instances-reportStatus$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/reportStatus
  
  Required parameters: instance
  
  Optional parameters: none
  
  Body: 
  
  {:reportTime string,
   :instanceUid string,
   :resources [{:uid string,
                :resource string,
                :revisions [GoogleCloudApigeeV1RevisionStatus],
                :totalReplicas integer}]}
  
  Reports the latest status for a runtime instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+instance}:reportStatus"
     #{:instance}
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

(defn instances-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :diskEncryptionKeyName string,
   :displayName string,
   :name string,
   :createdAt string,
   :state string,
   :port string,
   :host string,
   :lastModifiedAt string,
   :location string}
  
  Creates an Apigee runtime instance. The instance is accessible from the authorized network configured on the organization. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/instances"
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

(defn instances-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all Apigee runtime instances for the organization. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details for an Apigee runtime instance. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn instances-attachments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/attachments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all attachments to an instance. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attachments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-attachments-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/attachments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an attachment. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn instances-attachments-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/attachments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:environment string, :createdAt string, :name string}
  
  Creates a new attachment of an environment to an instance. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/attachments"
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

(defn instances-attachments-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/instances/attachments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an attachment. **Note:** Not supported for Apigee hybrid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn operations-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn operations-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/create
  
  Required parameters: parent
  
  Optional parameters: action, name, validate
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Creates an API proxy. The API proxy created will not be accessible at runtime until it is deployed to an environment. Create a new API proxy by setting the `name` query parameter to the name of the API proxy. Import an API proxy configuration bundle stored in zip format on your local machine to your organization by doing the following: * Set the `name` query parameter to the name of the API proxy. * Set the `action` query parameter to `import`. * Set the `Content-Type` header to `multipart/form-data`. * Pass as a file the name of API proxy configuration bundle stored in zip format on your local machine using the `file` form field. **Note**: To validate the API proxy configuration bundle only without importing it, set the `action` query parameter to `validate`. When importing an API proxy configuration bundle, if the API proxy does not exist, it will be created. If the API proxy exists, then a new revision is created. Invalid API proxy configurations are rejected, and a list of validation errors is returned to the client."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apis"
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

(defn apis-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API proxy and all associated endpoints, policies, resources, and revisions. The API proxy must be undeployed before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an API proxy including a list of existing revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/list
  
  Required parameters: parent
  
  Optional parameters: includeMetaData, includeRevisions
  
  Lists the names of all API proxies in an organization. The names returned correspond to the names defined in the configuration files for each API proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/apis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-revisions-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an API proxy revision and all policies, resources, endpoints, and revisions associated with it. The API proxy revision must be undeployed before you can delete it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-revisions-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/get
  
  Required parameters: name
  
  Optional parameters: format
  
  Gets an API proxy revision. To download the API proxy configuration bundle for the specified revision as a zip file, do the following: * Set the `format` query parameter to `bundle`. * Set the `Accept` header to `application/zip`. If you are using curl, specify `-o filename.zip` to save the output to a file; otherwise, it displays to `stdout`. Then, develop the API proxy configuration locally and upload the updated API proxy configuration revision, as described in [updateApiProxyRevision](updateApiProxyRevision)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-revisions-updateApiProxyRevision$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/updateApiProxyRevision
  
  Required parameters: name
  
  Optional parameters: validate
  
  Body: 
  
  {:extensions [{}], :contentType string, :data string}
  
  Updates an existing API proxy revision by uploading the API proxy configuration bundle as a zip file from your local machine. You can update only API proxy revisions that have never been deployed. After deployment, an API proxy revision becomes immutable, even if it is undeployed. Set the `Content-Type` header to either `multipart/form-data` or `application/octet-stream`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-revisions-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/revisions/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-deployments-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/deployments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all deployments of an API proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apis-keyvaluemaps-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/keyvaluemaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a key value map in an api proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn apis-keyvaluemaps-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/apis/keyvaluemaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:encrypted boolean, :name string}
  
  Creates a key value map in an api proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/keyvaluemaps"
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

(defn reports-create$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:properties [{:value [GoogleCloudApigeeV1Attribute],
                 :property string}],
   :toTime string,
   :tags [string],
   :lastViewedAt string,
   :limit string,
   :chartType string,
   :offset string,
   :displayName string,
   :sortByCols [string],
   :fromTime string,
   :name string,
   :comments [string],
   :createdAt string,
   :topk string,
   :organization string,
   :dimensions [string],
   :filter string,
   :lastModifiedAt string,
   :sortOrder string,
   :timeUnit string,
   :environment string,
   :metrics [{:name string, :function string}]}
  
  Creates a Custom Report for an Organization. A Custom Report provides Apigee Customers to create custom dashboards in addition to the standard dashboards which are provided. The Custom Report in its simplest form contains specifications about metrics, dimensions and filters. It is important to note that the custom report by itself does not provide an executable entity. The Edge UI converts the custom report definition into an analytics query and displays the result in a chart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/reports"
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

(defn reports-update$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:properties [{:value [GoogleCloudApigeeV1Attribute],
                 :property string}],
   :toTime string,
   :tags [string],
   :lastViewedAt string,
   :limit string,
   :chartType string,
   :offset string,
   :displayName string,
   :sortByCols [string],
   :fromTime string,
   :name string,
   :comments [string],
   :createdAt string,
   :topk string,
   :organization string,
   :dimensions [string],
   :filter string,
   :lastModifiedAt string,
   :sortOrder string,
   :timeUnit string,
   :environment string,
   :metrics [{:name string, :function string}]}
  
  Update an existing custom report definition"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn reports-delete$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing custom report definition"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn reports-get$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve a custom report definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
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

(defn reports-list$
  "https://cloud.google.com/apigee-api-management/api/reference/rest/v1/organizations/reports/list
  
  Required parameters: parent
  
  Optional parameters: expand
  
  Return a list of Custom Reports"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigee.googleapis.com/"
     "v1/{+parent}/reports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
