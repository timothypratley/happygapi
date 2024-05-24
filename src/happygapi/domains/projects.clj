(ns happygapi.domains.projects
  "Cloud Domains API: projects.
  Enables management and configuration of domain names.
  See: https://cloud.google.com/domains/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/get
  
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

(defn locations-operations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/operations/get
  
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

(defn locations-registrations-retrieveRegisterParameters$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/retrieveRegisterParameters
  
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
     "v1/{+location}/registrations:retrieveRegisterParameters"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-retrieveTransferParameters$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/retrieveTransferParameters
  
  Required parameters: location
  
  Optional parameters: domainName
  
  Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Gets parameters needed to transfer a domain name from another registrar to Cloud Domains. For domains already managed by [Google Domains](https://domains.google/), use `ImportDomain` instead. Use the returned values to call `TransferDomain`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+location}/registrations:retrieveTransferParameters"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/get
  
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

(defn locations-registrations-setIamPolicy$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-configureManagementSettings$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/configureManagementSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:managementSettings {:renewalMethod string,
                        :preferredRenewalMethod string,
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
     "v1/{+registration}:configureManagementSettings"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:transferFailureReason string,
   :labels {},
   :supportedPrivacy [string],
   :dnsSettings {:customDns CustomDns,
                 :googleDomainsDns GoogleDomainsDns,
                 :glueRecords [GlueRecord]},
   :issues [string],
   :name string,
   :registerFailureReason string,
   :createTime string,
   :managementSettings {:renewalMethod string,
                        :preferredRenewalMethod string,
                        :transferLockState string},
   :contactSettings {:privacy string,
                     :registrantContact Contact,
                     :adminContact Contact,
                     :technicalContact Contact},
   :state string,
   :domainName string,
   :expireTime string,
   :pendingContactSettings {:privacy string,
                            :registrantContact Contact,
                            :adminContact Contact,
                            :technicalContact Contact}}
  
  Updates select fields of a `Registration` resource, notably `labels`. To update other fields, use the appropriate custom update method: * To update management settings, see `ConfigureManagementSettings` * To update DNS configuration, see `ConfigureDnsSettings` * To update contact information, see `ConfigureContactSettings`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-testIamPermissions$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/testIamPermissions
  
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

(defn locations-registrations-transfer$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/transfer
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:registration {:transferFailureReason string,
                  :labels {},
                  :supportedPrivacy [string],
                  :dnsSettings DnsSettings,
                  :issues [string],
                  :name string,
                  :registerFailureReason string,
                  :createTime string,
                  :managementSettings ManagementSettings,
                  :contactSettings ContactSettings,
                  :state string,
                  :domainName string,
                  :expireTime string,
                  :pendingContactSettings ContactSettings},
   :contactNotices [string],
   :yearlyPrice {:currencyCode string, :units string, :nanos integer},
   :authorizationCode {:code string},
   :validateOnly boolean}
  
  Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Transfers a domain name from another registrar to Cloud Domains. For domains already managed by [Google Domains](https://domains.google/), use `ImportDomain` instead. Before calling this method, go to the domain's current registrar to unlock the domain for transfer and retrieve the domain's transfer authorization code. Then call `RetrieveTransferParameters` to confirm that the domain is unlocked and to get values needed to build a call to this method. A successful call creates a `Registration` resource in state `TRANSFER_PENDING`. It can take several days to complete the transfer process. The registrant can often speed up this process by approving the transfer through the current registrar, either by clicking a link in an email from the registrar or by visiting the registrar's website. A few minutes after transfer approval, the resource transitions to state `ACTIVE`, indicating that the transfer was successful. If the transfer is rejected or the request expires without being approved, the resource can end up in state `TRANSFER_FAILED`. If transfer fails, you can safely delete the resource and retry the transfer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+parent}/registrations:transfer"
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

(defn locations-registrations-resetAuthorizationCode$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/resetAuthorizationCode
  
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
     "v1/{+registration}:resetAuthorizationCode"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/configureContactSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:contactSettings {:privacy string,
                     :registrantContact Contact,
                     :adminContact Contact,
                     :technicalContact Contact},
   :updateMask string,
   :contactNotices [string],
   :validateOnly boolean}
  
  Updates a `Registration`'s contact settings. Some changes require confirmation by the domain's registrant contact . Caution: Please consider carefully any changes to contact privacy settings when changing from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA.` There may be a delay in reflecting updates you make to registrant contact information such that any changes you make to contact privacy (including from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA`) will be applied without delay but changes to registrant contact information may take a limited time to be publicized. This means that changes to contact privacy from `REDACTED_CONTACT_DATA` to `PUBLIC_CONTACT_DATA` may make the previous registrant contact data public until the modified registrant contact details are published."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+registration}:configureContactSettings"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/configureDnsSettings
  
  Required parameters: registration
  
  Optional parameters: none
  
  Body: 
  
  {:dnsSettings {:customDns CustomDns,
                 :googleDomainsDns GoogleDomainsDns,
                 :glueRecords [GlueRecord]},
   :updateMask string,
   :validateOnly boolean}
  
  Updates a `Registration`'s DNS settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:registration})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+registration}:configureDnsSettings"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a `Registration` resource. This method works on any `Registration` resource using [Subscription or Commitment billing](/domains/pricing#billing-models), provided that the resource was created at least 1 day in the past. When an active registration is successfully deleted, you can continue to use the domain in [Google Domains](https://domains.google/) until it expires. The calling user becomes the domain's sole owner in Google Domains, and permissions for the domain are subsequently managed there. The domain does not renew automatically unless the new owner sets up billing in Google Domains. After January 2024 you will only be able to delete `Registration` resources when `state` is one of: `EXPORTED`, `EXPIRED`,`REGISTRATION_FAILED` or `TRANSFER_FAILED`. See [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) for more details."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://domains.googleapis.com/"
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

(defn locations-registrations-export$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Exports a `Registration` resource, such that it is no longer managed by Cloud Domains. When an active domain is successfully exported, you can continue to use the domain in [Google Domains](https://domains.google/) until it expires. The calling user becomes the domain's sole owner in Google Domains, and permissions for the domain are subsequently managed there. The domain does not renew automatically unless the new owner sets up billing in Google Domains."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+name}:export"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/getIamPolicy
  
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

(defn locations-registrations-retrieveImportableDomains$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/retrieveImportableDomains
  
  Required parameters: location
  
  Optional parameters: pageSize, pageToken
  
  Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Lists domain names from [Google Domains](https://domains.google/) that can be imported to Cloud Domains using the `ImportDomain` method. Since individual users can own domains in Google Domains, the list of domains returned depends on the individual user making the call. Domains already managed by Cloud Domains are not returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+location}/registrations:retrieveImportableDomains"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-list$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the `Registration` resources in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+parent}/registrations"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/register
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:registration {:transferFailureReason string,
                  :labels {},
                  :supportedPrivacy [string],
                  :dnsSettings DnsSettings,
                  :issues [string],
                  :name string,
                  :registerFailureReason string,
                  :createTime string,
                  :managementSettings ManagementSettings,
                  :contactSettings ContactSettings,
                  :state string,
                  :domainName string,
                  :expireTime string,
                  :pendingContactSettings ContactSettings},
   :domainNotices [string],
   :contactNotices [string],
   :yearlyPrice {:currencyCode string, :units string, :nanos integer},
   :validateOnly boolean}
  
  Registers a new domain name and creates a corresponding `Registration` resource. Call `RetrieveRegisterParameters` first to check availability of the domain name and determine parameters like price that are needed to build a call to this method. A successful call creates a `Registration` resource in state `REGISTRATION_PENDING`, which resolves to `ACTIVE` within 1-2 minutes, indicating that the domain was successfully registered. If the resource ends up in state `REGISTRATION_FAILED`, it indicates that the domain was not registered successfully, and you can safely delete the resource and retry registration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+parent}/registrations:register"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/retrieveAuthorizationCode
  
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
     "v1/{+registration}:retrieveAuthorizationCode"
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
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/searchDomains
  
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
     "v1/{+location}/registrations:searchDomains"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-registrations-import$
  "https://cloud.google.com/domains/api/reference/rest/v1/projects/locations/registrations/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:domainName string, :labels {}}
  
  Deprecated: For more information, see [Cloud Domains feature deprecation](https://cloud.google.com/domains/docs/deprecations/feature-deprecations) Imports a domain name from [Google Domains](https://domains.google/) for use in Cloud Domains. To transfer a domain from another registrar, use the `TransferDomain` method instead. Since individual users can own domains in Google Domains, the calling user must have ownership permission on the domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://domains.googleapis.com/"
     "v1/{+parent}/registrations:import"
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
