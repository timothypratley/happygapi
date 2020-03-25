(ns happygapi.servicedirectory.projects
  "Service Directory API: projects.
  Service Directory is a platform for discovering, publishing, and connecting services.
  
  See: https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}/locations"
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
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-getIamPolicy$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM Policy for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-namespaces-patch$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :labels {}}
  
  Updates a namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-namespaces-get$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-testIamPermissions$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests IAM permissions for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-namespaces-delete$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a namespace. This also deletes all services and endpoints in
  the namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-list$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  
  Lists all namespaces."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/namespaces"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-setIamPolicy$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the IAM Policy for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-namespaces-create$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/create
  
  Required parameters: parent
  
  Optional parameters: namespaceId
  
  Body: 
  
  {:name string, :labels {}}
  
  Creates a namespace, and returns the new Namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/namespaces"
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

(defn locations-namespaces-services-get$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-setIamPolicy$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the IAM Policy for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-namespaces-services-patch$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:metadata {},
   :name string,
   :endpoints [{:name string,
                :metadata {},
                :address string,
                :port integer}]}
  
  Updates a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-namespaces-services-testIamPermissions$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests IAM permissions for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-namespaces-services-create$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId
  
  Body: 
  
  {:metadata {},
   :name string,
   :endpoints [{:name string,
                :metadata {},
                :address string,
                :port integer}]}
  
  Creates a service, and returns the new Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/services"
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

(defn locations-namespaces-services-delete$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a service. This also deletes all endpoints associated with
  the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-getIamPolicy$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM Policy for a resource (namespace or service only)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
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

(defn locations-namespaces-services-list$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  
  Lists all services belonging to a namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-resolve$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/resolve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:endpointFilter string, :maxEndpoints integer}
  
  Returns a service and its
  associated endpoints.
  Resolving a service is not considered an active developer method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}:resolve"
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

(defn locations-namespaces-services-endpoints-delete$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/endpoints/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-endpoints-list$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/endpoints/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, filter
  
  Lists all endpoints."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/endpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-endpoints-get$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/endpoints/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-services-endpoints-patch$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/endpoints/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :metadata {}, :address string, :port integer}
  
  Updates a endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-namespaces-services-endpoints-create$
  "https://cloud.google.com/service-directoryapi/reference/rest/v1beta1/projects/locations/namespaces/services/endpoints/create
  
  Required parameters: parent
  
  Optional parameters: endpointId
  
  Body: 
  
  {:name string, :metadata {}, :address string, :port integer}
  
  Creates a endpoint, and returns the new Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicedirectory.googleapis.com/"
     "v1beta1/{+parent}/endpoints"
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
