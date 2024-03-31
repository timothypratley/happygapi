(ns happygapi.networksecurity.projects
  "Network Security API: projects.
  
  See: https://cloud.google.com/networkingapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists ServerTlsPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/serverTlsPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serverTlsPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServerTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/create
  
  Required parameters: parent
  
  Optional parameters: serverTlsPolicyId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :allowOpen boolean,
   :serverCertificate {:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                       :certificateProviderInstance CertificateProviderInstance},
   :mtlsPolicy {:clientValidationMode string,
                :clientValidationCa [ValidationCA],
                :clientValidationTrustConfig string}}
  
  Creates a new ServerTlsPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/serverTlsPolicies"
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

(defn locations-serverTlsPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :allowOpen boolean,
   :serverCertificate {:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                       :certificateProviderInstance CertificateProviderInstance},
   :mtlsPolicy {:clientValidationMode string,
                :clientValidationCa [ValidationCA],
                :clientValidationTrustConfig string}}
  
  Updates the parameters of a single ServerTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ServerTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-serverTlsPolicies-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serverTlsPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists ClientTlsPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/clientTlsPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clientTlsPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ClientTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/create
  
  Required parameters: parent
  
  Optional parameters: clientTlsPolicyId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :sni string,
   :clientCertificate {:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                       :certificateProviderInstance CertificateProviderInstance},
   :serverValidationCa [{:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                         :certificateProviderInstance CertificateProviderInstance}]}
  
  Creates a new ClientTlsPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/clientTlsPolicies"
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

(defn locations-clientTlsPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :sni string,
   :clientCertificate {:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                       :certificateProviderInstance CertificateProviderInstance},
   :serverValidationCa [{:grpcEndpoint GoogleCloudNetworksecurityV1GrpcEndpoint,
                         :certificateProviderInstance CertificateProviderInstance}]}
  
  Updates the parameters of a single ClientTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ClientTlsPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-clientTlsPolicies-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/clientTlsPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-firewallEndpointAssociations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/firewallEndpointAssociations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Associations in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/firewallEndpointAssociations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-firewallEndpointAssociations-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/firewallEndpointAssociations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single FirewallEndpointAssociation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-firewallEndpointAssociations-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/firewallEndpointAssociations/create
  
  Required parameters: parent
  
  Optional parameters: firewallEndpointAssociationId, requestId
  
  Body: 
  
  {:labels {},
   :disabled boolean,
   :tlsInspectionPolicy string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :firewallEndpoint string,
   :reconciling boolean,
   :network string}
  
  Creates a new FirewallEndpointAssociation in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/firewallEndpointAssociations"
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

(defn locations-firewallEndpointAssociations-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/firewallEndpointAssociations/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single FirewallEndpointAssociation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-firewallEndpointAssociations-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/firewallEndpointAssociations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :disabled boolean,
   :tlsInspectionPolicy string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :firewallEndpoint string,
   :reconciling boolean,
   :network string}
  
  Update a single FirewallEndpointAssociation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :capacity integer,
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :updateTime string,
   :items [string]}
  
  Updates the parameters of a single address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/create
  
  Required parameters: parent
  
  Optional parameters: addressGroupId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :capacity integer,
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :updateTime string,
   :items [string]}
  
  Creates a new address group in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/addressGroups"
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

(defn locations-addressGroups-addItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/addItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:items [string], :requestId string}
  
  Adds items to an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:addItems"
     #{:addressGroup}
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

(defn locations-addressGroups-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-listReferences$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/listReferences
  
  Required parameters: addressGroup
  
  Optional parameters: pageSize, pageToken
  
  Lists references of an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:listReferences"
     #{:addressGroup}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-addressGroups-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists address groups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/addressGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-addressGroups-cloneItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/cloneItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:sourceAddressGroup string, :requestId string}
  
  Clones items from one address group to another."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:cloneItems"
     #{:addressGroup}
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

(defn locations-addressGroups-removeItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/addressGroups/removeItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:items [string], :requestId string}
  
  Removes items from an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:removeItems"
     #{:addressGroup}
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

(defn locations-authorizationPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists AuthorizationPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/authorizationPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-authorizationPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single AuthorizationPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-authorizationPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/create
  
  Required parameters: parent
  
  Optional parameters: authorizationPolicyId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :action string,
   :rules [{:sources [Source], :destinations [Destination]}]}
  
  Creates a new AuthorizationPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/authorizationPolicies"
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

(defn locations-authorizationPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :action string,
   :rules [{:sources [Source], :destinations [Destination]}]}
  
  Updates the parameters of a single AuthorizationPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-authorizationPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single AuthorizationPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-authorizationPolicies-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-authorizationPolicies-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-authorizationPolicies-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/authorizationPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://networksecurity.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-tlsInspectionPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsInspectionPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists TlsInspectionPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/tlsInspectionPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tlsInspectionPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsInspectionPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single TlsInspectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-tlsInspectionPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsInspectionPolicies/create
  
  Required parameters: parent
  
  Optional parameters: tlsInspectionPolicyId
  
  Body: 
  
  {:description string,
   :customTlsFeatures [string],
   :name string,
   :createTime string,
   :excludePublicCaSet boolean,
   :minTlsVersion string,
   :updateTime string,
   :tlsFeatureProfile string,
   :trustConfig string,
   :caPool string}
  
  Creates a new TlsInspectionPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/tlsInspectionPolicies"
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

(defn locations-tlsInspectionPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsInspectionPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :customTlsFeatures [string],
   :name string,
   :createTime string,
   :excludePublicCaSet boolean,
   :minTlsVersion string,
   :updateTime string,
   :tlsFeatureProfile string,
   :trustConfig string,
   :caPool string}
  
  Updates the parameters of a single TlsInspectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-tlsInspectionPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsInspectionPolicies/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single TlsInspectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists GatewaySecurityPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/gatewaySecurityPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gatewaySecurityPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single GatewaySecurityPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/create
  
  Required parameters: parent
  
  Optional parameters: gatewaySecurityPolicyId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :tlsInspectionPolicy string}
  
  Creates a new GatewaySecurityPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/gatewaySecurityPolicies"
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

(defn locations-gatewaySecurityPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :tlsInspectionPolicy string}
  
  Updates the parameters of a single GatewaySecurityPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single GatewaySecurityPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-rules-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/rules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists GatewaySecurityPolicyRules in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/rules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gatewaySecurityPolicies-rules-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/rules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single GatewaySecurityPolicyRule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-rules-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/rules/create
  
  Required parameters: parent
  
  Optional parameters: gatewaySecurityPolicyRuleId
  
  Body: 
  
  {:description string,
   :name string,
   :createTime string,
   :updateTime string,
   :basicProfile string,
   :priority integer,
   :sessionMatcher string,
   :tlsInspectionEnabled boolean,
   :applicationMatcher string,
   :enabled boolean}
  
  Creates a new GatewaySecurityPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/rules"
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

(defn locations-gatewaySecurityPolicies-rules-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/rules/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :name string,
   :createTime string,
   :updateTime string,
   :basicProfile string,
   :priority integer,
   :sessionMatcher string,
   :tlsInspectionEnabled boolean,
   :applicationMatcher string,
   :enabled boolean}
  
  Updates the parameters of a single GatewaySecurityPolicyRule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-gatewaySecurityPolicies-rules-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gatewaySecurityPolicies/rules/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single GatewaySecurityPolicyRule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-urlLists-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/urlLists/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists UrlLists in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/urlLists"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-urlLists-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/urlLists/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single UrlList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-urlLists-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/urlLists/create
  
  Required parameters: parent
  
  Optional parameters: urlListId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :values [string]}
  
  Creates a new UrlList in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/urlLists"
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

(defn locations-urlLists-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/urlLists/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :values [string]}
  
  Updates the parameters of a single UrlList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-urlLists-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/urlLists/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single UrlList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
