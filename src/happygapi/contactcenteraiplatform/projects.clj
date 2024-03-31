(ns happygapi.contactcenteraiplatform.projects
  "Contact Center AI Platform API: projects.
  
  See: https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-queryContactCenterQuota$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/queryContactCenterQuota
  
  Required parameters: parent
  
  Optional parameters: none
  
  Queries the contact center quota, an aggregation over all the projects, that belongs to the billing account, which the input project belongs to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+parent}:queryContactCenterQuota"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
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
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}/operations"
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
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}:cancel"
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

(defn locations-contactCenters-list$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/contactCenters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ContactCenters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+parent}/contactCenters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-contactCenters-get$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/contactCenters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ContactCenter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-contactCenters-create$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/contactCenters/create
  
  Required parameters: parent
  
  Optional parameters: contactCenterId, requestId
  
  Body: 
  
  {:labels {},
   :customerDomainPrefix string,
   :displayName string,
   :name string,
   :createTime string,
   :samlParams {:ssoUri string,
                :entityId string,
                :certificate string,
                :userEmail string,
                :emailMapping string},
   :privateComponents [string],
   :state string,
   :updateTime string,
   :adminUser {:givenName string, :familyName string},
   :ccaipManagedUsers boolean,
   :kmsKey string,
   :instanceConfig {:instanceSize string},
   :uris {:rootUri string,
          :mediaUri string,
          :virtualAgentStreamingServiceUri string,
          :chatBotUri string},
   :userEmail string}
  
  Creates a new ContactCenter in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+parent}/contactCenters"
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

(defn locations-contactCenters-patch$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/contactCenters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :customerDomainPrefix string,
   :displayName string,
   :name string,
   :createTime string,
   :samlParams {:ssoUri string,
                :entityId string,
                :certificate string,
                :userEmail string,
                :emailMapping string},
   :privateComponents [string],
   :state string,
   :updateTime string,
   :adminUser {:givenName string, :familyName string},
   :ccaipManagedUsers boolean,
   :kmsKey string,
   :instanceConfig {:instanceSize string},
   :uris {:rootUri string,
          :mediaUri string,
          :virtualAgentStreamingServiceUri string,
          :chatBotUri string},
   :userEmail string}
  
  Updates the parameters of a single ContactCenter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn locations-contactCenters-delete$
  "https://cloud.google.com/solutions/contact-center-ai-platformapi/reference/rest/v1alpha1/projects/locations/contactCenters/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single ContactCenter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://contactcenteraiplatform.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
