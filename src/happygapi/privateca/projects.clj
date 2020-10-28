(ns happygapi.privateca.projects
  "Certificate Authority API: projects.
  
  See: https://cloud.google.com/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/operations/cancel
  
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
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:cancel"
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

(defn locations-certificateAuthorities-disable$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Disable a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:disable"
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

(defn locations-certificateAuthorities-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/setIamPolicy
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-enable$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/enable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Enable a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:enable"
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

(defn locations-certificateAuthorities-patch$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :tier string,
   :deleteTime string,
   :gcsBucket string,
   :config {:publicKey PublicKey,
            :reusableConfig ReusableConfigWrapper,
            :subjectConfig SubjectConfig},
   :name string,
   :createTime string,
   :keySpec {:algorithm string, :cloudKmsKeyVersion string},
   :type string,
   :state string,
   :subordinateConfig {:pemIssuerChain SubordinateConfigChain,
                       :certificateAuthority string},
   :updateTime string,
   :issuingOptions {:includeCaCertUrl boolean,
                    :includeCrlAccessUrl boolean},
   :accessUrls {:crlAccessUrl string, :caCertificateAccessUrl string},
   :lifetime string,
   :caCertificateDescriptions [{:subjectKeyId KeyId,
                                :crlDistributionPoints [string],
                                :configValues ReusableConfigValues,
                                :subjectDescription SubjectDescription,
                                :authorityKeyId KeyId,
                                :aiaIssuingCertificateUrls [string],
                                :certFingerprint CertificateFingerprint,
                                :publicKey PublicKey}],
   :certificatePolicy {:allowedIssuanceModes IssuanceModes,
                       :allowedConfigList AllowedConfigList,
                       :allowedLocationsAndOrganizations [Subject],
                       :overwriteConfigValues ReusableConfigWrapper,
                       :allowedSans AllowedSubjectAltNames,
                       :maximumLifetime string,
                       :allowedCommonNames [string]},
   :pemCaCertificates [string]}
  
  Update a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/testIamPermissions
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-restore$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Restore a CertificateAuthority that is scheduled for deletion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:restore"
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

(defn locations-certificateAuthorities-create$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/create
  
  Required parameters: parent
  
  Optional parameters: certificateAuthorityId, requestId
  
  Body: 
  
  {:labels {},
   :tier string,
   :deleteTime string,
   :gcsBucket string,
   :config {:publicKey PublicKey,
            :reusableConfig ReusableConfigWrapper,
            :subjectConfig SubjectConfig},
   :name string,
   :createTime string,
   :keySpec {:algorithm string, :cloudKmsKeyVersion string},
   :type string,
   :state string,
   :subordinateConfig {:pemIssuerChain SubordinateConfigChain,
                       :certificateAuthority string},
   :updateTime string,
   :issuingOptions {:includeCaCertUrl boolean,
                    :includeCrlAccessUrl boolean},
   :accessUrls {:crlAccessUrl string, :caCertificateAccessUrl string},
   :lifetime string,
   :caCertificateDescriptions [{:subjectKeyId KeyId,
                                :crlDistributionPoints [string],
                                :configValues ReusableConfigValues,
                                :subjectDescription SubjectDescription,
                                :authorityKeyId KeyId,
                                :aiaIssuingCertificateUrls [string],
                                :certFingerprint CertificateFingerprint,
                                :publicKey PublicKey}],
   :certificatePolicy {:allowedIssuanceModes IssuanceModes,
                       :allowedConfigList AllowedConfigList,
                       :allowedLocationsAndOrganizations [Subject],
                       :overwriteConfigValues ReusableConfigWrapper,
                       :allowedSans AllowedSubjectAltNames,
                       :maximumLifetime string,
                       :allowedCommonNames [string]},
   :pemCaCertificates [string]}
  
  Create a new CertificateAuthority in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificateAuthorities"
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

(defn locations-certificateAuthorities-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter, orderBy
  
  Lists CertificateAuthorities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificateAuthorities"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateAuthorities-fetch$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/fetch
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetch a certificate signing request (CSR) from a CertificateAuthority that is in state PENDING_ACTIVATION and is of type SUBORDINATE. The CSR must then be signed by the desired parent Certificate Authority, which could be another CertificateAuthority resource, or could be an on-prem certificate authority. See also ActivateCertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:fetch"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateAuthorities-scheduleDelete$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/scheduleDelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Schedule a CertificateAuthority for deletion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:scheduleDelete"
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

(defn locations-certificateAuthorities-activate$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :subordinateConfig {:pemIssuerChain SubordinateConfigChain,
                       :certificateAuthority string},
   :pemCaCertificate string}
  
  Activate a CertificateAuthority that is in state PENDING_ACTIVATION and is of type SUBORDINATE. After the parent Certificate Authority signs a certificate signing request from FetchCertificateAuthorityCsr, this method can complete the activation process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:activate"
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

(defn locations-certificateAuthorities-certificates-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, orderBy, filter, pageToken
  
  Lists Certificates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateAuthorities-certificates-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificates-patch$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:revocationDetails {:revocationState string, :revocationTime string},
   :labels {},
   :config {:publicKey PublicKey,
            :reusableConfig ReusableConfigWrapper,
            :subjectConfig SubjectConfig},
   :name string,
   :createTime string,
   :updateTime string,
   :pemCertificate string,
   :pemCsr string,
   :lifetime string,
   :certificateDescription {:subjectKeyId KeyId,
                            :crlDistributionPoints [string],
                            :configValues ReusableConfigValues,
                            :subjectDescription SubjectDescription,
                            :authorityKeyId KeyId,
                            :aiaIssuingCertificateUrls [string],
                            :certFingerprint CertificateFingerprint,
                            :publicKey PublicKey},
   :pemCertificateChain [string]}
  
  Update a Certificate. Currently, the only field you can update is the labels field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificates-create$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificates/create
  
  Required parameters: parent
  
  Optional parameters: requestId, certificateId
  
  Body: 
  
  {:revocationDetails {:revocationState string, :revocationTime string},
   :labels {},
   :config {:publicKey PublicKey,
            :reusableConfig ReusableConfigWrapper,
            :subjectConfig SubjectConfig},
   :name string,
   :createTime string,
   :updateTime string,
   :pemCertificate string,
   :pemCsr string,
   :lifetime string,
   :certificateDescription {:subjectKeyId KeyId,
                            :crlDistributionPoints [string],
                            :configValues ReusableConfigValues,
                            :subjectDescription SubjectDescription,
                            :authorityKeyId KeyId,
                            :aiaIssuingCertificateUrls [string],
                            :certFingerprint CertificateFingerprint,
                            :publicKey PublicKey},
   :pemCertificateChain [string]}
  
  Create a new Certificate in a given Project, Location from a particular CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificates"
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

(defn locations-certificateAuthorities-certificates-revoke$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificates/revoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :reason string}
  
  Revoke a Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+name}:revoke"
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

(defn locations-certificateAuthorities-certificateRevocationLists-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificateRevocationLists-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a CertificateRevocationList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificateRevocationLists-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Lists CertificateRevocationLists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificateRevocationLists"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateAuthorities-certificateRevocationLists-patch$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/patch
  
  Required parameters: name
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:sequenceNumber string,
   :labels {},
   :accessUrl string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :revokedCertificates [{:revocationReason string,
                          :hexSerialNumber string,
                          :certificate string}],
   :pemCrl string}
  
  Update a CertificateRevocationList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificateRevocationLists-create$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/create
  
  Required parameters: parent
  
  Optional parameters: certificateRevocationListId, requestId
  
  Body: 
  
  {:sequenceNumber string,
   :labels {},
   :accessUrl string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :revokedCertificates [{:revocationReason string,
                          :hexSerialNumber string,
                          :certificate string}],
   :pemCrl string}
  
  Create a new CertificateRevocationList in a given Project, Location for a particular CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/certificateRevocationLists"
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

(defn locations-certificateAuthorities-certificateRevocationLists-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/setIamPolicy
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-certificateAuthorities-certificateRevocationLists-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/certificateAuthorities/certificateRevocationLists/testIamPermissions
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-reusableConfigs-list$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/reusableConfigs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageToken, pageSize, filter
  
  Lists ReusableConfigs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1beta1/{+parent}/reusableConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reusableConfigs-get$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/reusableConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a ReusableConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-reusableConfigs-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/reusableConfigs/testIamPermissions
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-reusableConfigs-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/reusableConfigs/setIamPolicy
  
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
     "https://privateca.googleapis.com/"
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

(defn locations-reusableConfigs-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1beta1/projects/locations/reusableConfigs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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
