(ns happygapi.managedidentities.projects
  "Managed Service for Microsoft Active Directory API: projects.
  The Managed Service for Microsoft Active Directory API is used for managing a highly available, hardened service running Microsoft Active Directory (AD).
  See: https://cloud.google.com/managed-microsoft-ad/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-operations-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-operations-get$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-operations-delete$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-operations-cancel$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/operations/cancel
  
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
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-get$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-disableMigration$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/disableMigration
  
  Required parameters: domain
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disable Domain Migration"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+domain}:disableMigration"
     #{:domain}
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

(defn locations-global-domains-setIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-patch$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :admin string,
   :name string,
   :reservedIpRange string,
   :statusMessage string,
   :createTime string,
   :state string,
   :fqdn string,
   :updateTime string,
   :locations [string],
   :authorizedNetworks [string],
   :auditLogsEnabled boolean,
   :trusts [{:trustDirection string,
             :createTime string,
             :state string,
             :updateTime string,
             :targetDomainName string,
             :targetDnsIpAddresses [string],
             :trustHandshakeSecret string,
             :selectiveAuthentication boolean,
             :trustType string,
             :lastTrustHeartbeatTime string,
             :stateDescription string}]}
  
  Updates the metadata and configuration of a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-testIamPermissions$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/testIamPermissions
  
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
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-updateLdapssettings$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/updateLdapssettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :certificate {:subject string,
                 :thumbprint string,
                 :subjectAlternativeName [string],
                 :issuingCertificate Certificate,
                 :expireTime string},
   :state string,
   :certificatePfx string,
   :certificatePassword string,
   :updateTime string}
  
  Patches a single ldaps settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}/ldapssettings"
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

(defn locations-global-domains-restore$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:backupId string}
  
  RestoreDomain restores domain backup mentioned in the RestoreDomainRequest"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:restore"
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

(defn locations-global-domains-create$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/create
  
  Required parameters: parent
  
  Optional parameters: domainName
  
  Body: 
  
  {:labels {},
   :admin string,
   :name string,
   :reservedIpRange string,
   :statusMessage string,
   :createTime string,
   :state string,
   :fqdn string,
   :updateTime string,
   :locations [string],
   :authorizedNetworks [string],
   :auditLogsEnabled boolean,
   :trusts [{:trustDirection string,
             :createTime string,
             :state string,
             :updateTime string,
             :targetDomainName string,
             :targetDnsIpAddresses [string],
             :trustHandshakeSecret string,
             :selectiveAuthentication boolean,
             :trustType string,
             :lastTrustHeartbeatTime string,
             :stateDescription string}]}
  
  Creates a Microsoft AD domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/domains"
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

(defn locations-global-domains-validateTrust$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/validateTrust
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:trust {:trustDirection string,
           :createTime string,
           :state string,
           :updateTime string,
           :targetDomainName string,
           :targetDnsIpAddresses [string],
           :trustHandshakeSecret string,
           :selectiveAuthentication boolean,
           :trustType string,
           :lastTrustHeartbeatTime string,
           :stateDescription string}}
  
  Validates a trust state, that the target domain is reachable, and that the target domain is able to accept incoming trust requests."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:validateTrust"
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

(defn locations-global-domains-getLdapssettings$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/getLdapssettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the domain ldaps settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}/ldapssettings"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-domains-checkMigrationPermission$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/checkMigrationPermission
  
  Required parameters: domain
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  CheckMigrationPermission API gets the current state of DomainMigration"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+domain}:checkMigrationPermission"
     #{:domain}
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

(defn locations-global-domains-delete$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-detachTrust$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/detachTrust
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:trust {:trustDirection string,
           :createTime string,
           :state string,
           :updateTime string,
           :targetDomainName string,
           :targetDnsIpAddresses [string],
           :trustHandshakeSecret string,
           :selectiveAuthentication boolean,
           :trustType string,
           :lastTrustHeartbeatTime string,
           :stateDescription string}}
  
  Removes an AD trust."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:detachTrust"
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

(defn locations-global-domains-extendSchema$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/extendSchema
  
  Required parameters: domain
  
  Optional parameters: none
  
  Body: 
  
  {:description string, :gcsPath string, :fileContents string}
  
  Extend Schema for Domain"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+domain}:extendSchema"
     #{:domain}
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

(defn locations-global-domains-getIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists domains in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/domains"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-domains-domainJoinMachine$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/domainJoinMachine
  
  Required parameters: domain
  
  Optional parameters: none
  
  Body: 
  
  {:vmIdToken string, :ouName string, :force boolean}
  
  DomainJoinMachine API joins a Compute Engine VM to the domain"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+domain}:domainJoinMachine"
     #{:domain}
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

(defn locations-global-domains-resetAdminPassword$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/resetAdminPassword
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets a domain's administrator password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:resetAdminPassword"
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

(defn locations-global-domains-enableMigration$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/enableMigration
  
  Required parameters: domain
  
  Optional parameters: none
  
  Body: 
  
  {:migratingDomains [{:domainName string, :disableSidFiltering boolean}]}
  
  Enable Domain Migration"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+domain}:enableMigration"
     #{:domain}
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

(defn locations-global-domains-attachTrust$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/attachTrust
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:trust {:trustDirection string,
           :createTime string,
           :state string,
           :updateTime string,
           :targetDomainName string,
           :targetDnsIpAddresses [string],
           :trustHandshakeSecret string,
           :selectiveAuthentication boolean,
           :trustType string,
           :lastTrustHeartbeatTime string,
           :stateDescription string}}
  
  Adds an AD trust to a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:attachTrust"
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

(defn locations-global-domains-reconfigureTrust$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/reconfigureTrust
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetDomainName string, :targetDnsIpAddresses [string]}
  
  Updates the DNS conditional forwarder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+name}:reconfigureTrust"
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

(defn locations-global-domains-backups-create$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId
  
  Body: 
  
  {:name string,
   :labels {},
   :createTime string,
   :updateTime string,
   :type string,
   :state string,
   :statusMessage string}
  
  Creates a Backup for a domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/backups"
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

(defn locations-global-domains-backups-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Backup in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/backups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-domains-backups-get$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-backups-patch$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :labels {},
   :createTime string,
   :updateTime string,
   :type string,
   :state string,
   :statusMessage string}
  
  Updates the labels for specified Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-backups-delete$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes identified Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-backups-setIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-backups-getIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-backups-testIamPermissions$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/backups/testIamPermissions
  
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
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-domains-sqlIntegrations-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/sqlIntegrations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists SqlIntegrations in a given domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/sqlIntegrations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-domains-sqlIntegrations-get$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/domains/sqlIntegrations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single sqlIntegration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-create$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/create
  
  Required parameters: parent
  
  Optional parameters: peeringId
  
  Body: 
  
  {:name string,
   :labels {},
   :authorizedNetwork string,
   :domainResource string,
   :createTime string,
   :updateTime string,
   :state string,
   :statusMessage string}
  
  Creates a Peering for Managed AD instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/peerings"
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

(defn locations-global-peerings-list$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Peerings in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
     "v1/{+parent}/peerings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-peerings-get$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Peering."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-patch$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :labels {},
   :authorizedNetwork string,
   :domainResource string,
   :createTime string,
   :updateTime string,
   :state string,
   :statusMessage string}
  
  Updates the labels for specified Peering."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-delete$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes identified Peering."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-setIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-getIamPolicy$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://managedidentities.googleapis.com/"
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

(defn locations-global-peerings-testIamPermissions$
  "https://cloud.google.com/managed-microsoft-ad/api/reference/rest/v1/projects/locations/global/peerings/testIamPermissions
  
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
     "https://managedidentities.googleapis.com/"
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
