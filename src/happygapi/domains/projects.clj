(ns happygapi.domains.projects
  "Cloud Domains API: projects.
  Enables management and configuration of domain names.
  See: https://cloud.google.com/domains/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-retrieveRegisterParameters$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/retrieveRegisterParameters
  
  Required parameters: location
  
  Optional parameters: domainName
  
  Gets parameters needed to register a new domain name, including price and up-to-date availability. Use the returned values to call `RegisterDomain`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+location}/registrations:retrieveRegisterParameters"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-get$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a `Registration` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-setIamPolicy$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :version integer},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-configureManagementSettings$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/configureManagementSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:managementSettings {:renewalMethod string,
                        :transferLockState string},
   :updateMask string}
  
  Updates a `Registration`'s management settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+registration}:configureManagementSettings"
     #{:registration}
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

(defn locations-registrations-patch$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :supportedPrivacy [string],
   :dnsSettings {:googleDomainsDns GoogleDomainsDns,
                 :glueRecords [GlueRecord],
                 :customDns CustomDns},
   :issues [string],
   :name string,
   :createTime string,
   :managementSettings {:renewalMethod string,
                        :transferLockState string},
   :contactSettings {:adminContact Contact,
                     :privacy string,
                     :technicalContact Contact,
                     :registrantContact Contact},
   :state string,
   :domainName string,
   :expireTime string,
   :pendingContactSettings {:adminContact Contact,
                            :privacy string,
                            :technicalContact Contact,
                            :registrantContact Contact}}
  
  Updates select fields of a `Registration` resource, notably `labels`. To update other fields, use the appropriate custom update method: * To update management settings, see `ConfigureManagementSettings` * To update DNS configuration, see `ConfigureDnsSettings` * To update contact information, see `ConfigureContactSettings`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-testIamPermissions$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/testIamPermissions
  
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
     "https://domains.googleapis.com/"
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

(defn locations-registrations-resetAuthorizationCode$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/resetAuthorizationCode
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets the authorization code of the `Registration` to a new random string. You can call this method only after 60 days have elapsed since the initial domain registration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+registration}:resetAuthorizationCode"
     #{:registration}
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

(defn locations-registrations-configureContactSettings$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/configureContactSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :contactSettings {:adminContact Contact,
                     :privacy string,
                     :technicalContact Contact,
                     :registrantContact Contact},
   :contactNotices [string],
   :validateOnly boolean}
  
  Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's registrant contact ."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+registration}:configureContactSettings"
     #{:registration}
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

(defn locations-registrations-configureDnsSettings$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/configureDnsSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:dnsSettings {:googleDomainsDns GoogleDomainsDns,
                 :glueRecords [GlueRecord],
                 :customDns CustomDns},
   :validateOnly boolean,
   :updateMask string}
  
  Updates a `Registration`'s DNS settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+registration}:configureDnsSettings"
     #{:registration}
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

(defn locations-registrations-delete$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a `Registration` resource. This method only works on resources in one of the following states: * `state` is `EXPORTED` with `expire_time` in the past * `state` is `REGISTRATION_FAILED`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-export$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Exports a `Registration` that you no longer want to use with Cloud Domains. You can continue to use the domain in [Google Domains](https://domains.google/) until it expires. If the export is successful: * The resource's `state` becomes `EXPORTED`, meaning that it is no longer managed by Cloud Domains * Because individual users can own domains in Google Domains, the calling user becomes the domain's sole owner. Permissions for the domain are subsequently managed in Google Domains. * Without further action, the domain does not renew automatically. The new owner can set up billing in Google Domains to renew the domain if needed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+name}:export"
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

(defn locations-registrations-getIamPolicy$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the `Registration` resources in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+parent}/registrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-register$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/register
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:yearlyPrice {:currencyCode string, :nanos integer, :units string},
   :validateOnly boolean,
   :registration {:labels {},
                  :supportedPrivacy [string],
                  :dnsSettings DnsSettings,
                  :issues [string],
                  :name string,
                  :createTime string,
                  :managementSettings ManagementSettings,
                  :contactSettings ContactSettings,
                  :state string,
                  :domainName string,
                  :expireTime string,
                  :pendingContactSettings ContactSettings},
   :contactNotices [string],
   :domainNotices [string]}
  
  Registers a new domain name and creates a corresponding `Registration` resource. Call `RetrieveRegisterParameters` first to check availability of the domain name and determine parameters like price that are needed to build a call to this method. A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the domain was not registered successfully, and you can safely delete the resource and retry registration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+parent}/registrations:register"
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

(defn locations-registrations-retrieveAuthorizationCode$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/retrieveAuthorizationCode
  
  Required parameters: registration
  
  Optional parameters: none
  
  Gets the authorization code of the `Registration` for the purpose of transferring the domain to another registrar. You can call this method only after 60 days have elapsed since the initial domain registration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+registration}:retrieveAuthorizationCode"
     #{:registration}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-searchDomains$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/registrations/searchDomains
  
  Required parameters: location
  
  Optional parameters: query
  
  Searches for available domain names similar to the provided query. Availability results from this method are approximate; call `RetrieveRegisterParameters` on a domain before registering to confirm availability."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+location}/registrations:searchDomains"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1beta1/{+name}/operations"
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
  "https://cloud.google.com/domains/api/reference/rest/v1beta1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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
