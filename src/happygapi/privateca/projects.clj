(ns happygapi.privateca.projects
  "Certificate Authority API: projects.
  The Certificate Authority Service API is a highly-available, scalable service that enables you to simplify and automate the management of private certificate authorities (CAs) while staying in control of your private keys. 
  See: https://cloud.google.com/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/get
  
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
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/operations/get
  
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
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/operations/delete
  
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
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/operations/cancel
  
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

(defn locations-caPools-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a CaPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/setIamPolicy
  
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

(defn locations-caPools-patch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :tier string,
   :issuancePolicy {:allowedKeyTypes [AllowedKeyType],
                    :maximumLifetime string,
                    :allowedIssuanceModes IssuanceModes,
                    :baselineValues X509Parameters,
                    :identityConstraints CertificateIdentityConstraints,
                    :passthroughExtensions CertificateExtensionConstraints},
   :publishingOptions {:publishCaCert boolean,
                       :publishCrl boolean,
                       :encodingFormat string},
   :labels {}}
  
  Update a CaPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/testIamPermissions
  
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

(defn locations-caPools-fetchCaCerts$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/fetchCaCerts
  
  Required parameters: caPool
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  FetchCaCerts returns the current trust anchor for the CaPool. This will include CA certificate chains for all Certificate Authorities in the ENABLED, DISABLED, or STAGED states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:caPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+caPool}:fetchCaCerts"
     #{:caPool}
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

(defn locations-caPools-create$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/create
  
  Required parameters: parent
  
  Optional parameters: caPoolId, requestId
  
  Body: 
  
  {:name string,
   :tier string,
   :issuancePolicy {:allowedKeyTypes [AllowedKeyType],
                    :maximumLifetime string,
                    :allowedIssuanceModes IssuanceModes,
                    :baselineValues X509Parameters,
                    :identityConstraints CertificateIdentityConstraints,
                    :passthroughExtensions CertificateExtensionConstraints},
   :publishingOptions {:publishCaCert boolean,
                       :publishCrl boolean,
                       :encodingFormat string},
   :labels {}}
  
  Create a CaPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/caPools"
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

(defn locations-caPools-delete$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/delete
  
  Required parameters: name
  
  Optional parameters: requestId, ignoreDependentResources
  
  Delete a CaPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/getIamPolicy
  
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

(defn locations-caPools-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CaPools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/caPools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-caPools-certificates-create$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificates/create
  
  Required parameters: parent
  
  Optional parameters: certificateId, requestId, validateOnly, issuingCertificateAuthorityId
  
  Body: 
  
  {:revocationDetails {:revocationState string, :revocationTime string},
   :labels {},
   :certificateTemplate string,
   :issuerCertificateAuthority string,
   :config {:subjectConfig SubjectConfig,
            :x509Config X509Parameters,
            :publicKey PublicKey,
            :subjectKeyId CertificateConfigKeyId},
   :name string,
   :createTime string,
   :subjectMode string,
   :updateTime string,
   :pemCertificate string,
   :pemCsr string,
   :lifetime string,
   :certificateDescription {:subjectDescription SubjectDescription,
                            :x509Description X509Parameters,
                            :publicKey PublicKey,
                            :subjectKeyId KeyId,
                            :authorityKeyId KeyId,
                            :crlDistributionPoints [string],
                            :aiaIssuingCertificateUrls [string],
                            :certFingerprint CertificateFingerprint},
   :pemCertificateChain [string]}
  
  Create a new Certificate in a given Project, Location from a particular CaPool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificates"
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

(defn locations-caPools-certificates-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificates/get
  
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

(defn locations-caPools-certificates-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Certificates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-caPools-certificates-revoke$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificates/revoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:reason string, :requestId string}
  
  Revoke a Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+name}:revoke"
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

(defn locations-caPools-certificates-patch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:revocationDetails {:revocationState string, :revocationTime string},
   :labels {},
   :certificateTemplate string,
   :issuerCertificateAuthority string,
   :config {:subjectConfig SubjectConfig,
            :x509Config X509Parameters,
            :publicKey PublicKey,
            :subjectKeyId CertificateConfigKeyId},
   :name string,
   :createTime string,
   :subjectMode string,
   :updateTime string,
   :pemCertificate string,
   :pemCsr string,
   :lifetime string,
   :certificateDescription {:subjectDescription SubjectDescription,
                            :x509Description X509Parameters,
                            :publicKey PublicKey,
                            :subjectKeyId KeyId,
                            :authorityKeyId KeyId,
                            :crlDistributionPoints [string],
                            :aiaIssuingCertificateUrls [string],
                            :certFingerprint CertificateFingerprint},
   :pemCertificateChain [string]}
  
  Update a Certificate. Currently, the only field you can update is the labels field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-certificateAuthorities-disable$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :ignoreDependentResources boolean}
  
  Disable a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+name}:disable"
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

(defn locations-caPools-certificateAuthorities-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/get
  
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

(defn locations-caPools-certificateAuthorities-enable$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/enable
  
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
     "v1/{+name}:enable"
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

(defn locations-caPools-certificateAuthorities-patch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :tier string,
   :deleteTime string,
   :gcsBucket string,
   :config {:subjectConfig SubjectConfig,
            :x509Config X509Parameters,
            :publicKey PublicKey,
            :subjectKeyId CertificateConfigKeyId},
   :name string,
   :createTime string,
   :keySpec {:cloudKmsKeyVersion string, :algorithm string},
   :type string,
   :state string,
   :subordinateConfig {:certificateAuthority string,
                       :pemIssuerChain SubordinateConfigChain},
   :updateTime string,
   :accessUrls {:caCertificateAccessUrl string, :crlAccessUrls [string]},
   :lifetime string,
   :caCertificateDescriptions [{:subjectDescription SubjectDescription,
                                :x509Description X509Parameters,
                                :publicKey PublicKey,
                                :subjectKeyId KeyId,
                                :authorityKeyId KeyId,
                                :crlDistributionPoints [string],
                                :aiaIssuingCertificateUrls [string],
                                :certFingerprint CertificateFingerprint}],
   :expireTime string,
   :pemCaCertificates [string]}
  
  Update a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-certificateAuthorities-create$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/create
  
  Required parameters: parent
  
  Optional parameters: certificateAuthorityId, requestId
  
  Body: 
  
  {:labels {},
   :tier string,
   :deleteTime string,
   :gcsBucket string,
   :config {:subjectConfig SubjectConfig,
            :x509Config X509Parameters,
            :publicKey PublicKey,
            :subjectKeyId CertificateConfigKeyId},
   :name string,
   :createTime string,
   :keySpec {:cloudKmsKeyVersion string, :algorithm string},
   :type string,
   :state string,
   :subordinateConfig {:certificateAuthority string,
                       :pemIssuerChain SubordinateConfigChain},
   :updateTime string,
   :accessUrls {:caCertificateAccessUrl string, :crlAccessUrls [string]},
   :lifetime string,
   :caCertificateDescriptions [{:subjectDescription SubjectDescription,
                                :x509Description X509Parameters,
                                :publicKey PublicKey,
                                :subjectKeyId KeyId,
                                :authorityKeyId KeyId,
                                :crlDistributionPoints [string],
                                :aiaIssuingCertificateUrls [string],
                                :certFingerprint CertificateFingerprint}],
   :expireTime string,
   :pemCaCertificates [string]}
  
  Create a new CertificateAuthority in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificateAuthorities"
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

(defn locations-caPools-certificateAuthorities-delete$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/delete
  
  Required parameters: name
  
  Optional parameters: requestId, ignoreActiveCertificates, skipGracePeriod, ignoreDependentResources
  
  Delete a CertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-certificateAuthorities-undelete$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Undelete a CertificateAuthority that has been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn locations-caPools-certificateAuthorities-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateAuthorities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificateAuthorities"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-caPools-certificateAuthorities-fetch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/fetch
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetch a certificate signing request (CSR) from a CertificateAuthority that is in state AWAITING_USER_ACTIVATION and is of type SUBORDINATE. The CSR must then be signed by the desired parent Certificate Authority, which could be another CertificateAuthority resource, or could be an on-prem certificate authority. See also ActivateCertificateAuthority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+name}:fetch"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-caPools-certificateAuthorities-activate$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:pemCaCertificate string,
   :subordinateConfig {:certificateAuthority string,
                       :pemIssuerChain SubordinateConfigChain},
   :requestId string}
  
  Activate a CertificateAuthority that is in state AWAITING_USER_ACTIVATION and is of type SUBORDINATE. After the parent Certificate Authority signs a certificate signing request from FetchCertificateAuthorityCsr, this method can complete the activation process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+name}:activate"
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

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/get
  
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

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateRevocationLists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificateRevocationLists"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-patch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:sequenceNumber string,
   :labels {},
   :accessUrl string,
   :name string,
   :createTime string,
   :revisionId string,
   :state string,
   :updateTime string,
   :revokedCertificates [{:certificate string,
                          :hexSerialNumber string,
                          :revocationReason string}],
   :pemCrl string}
  
  Update a CertificateRevocationList."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/setIamPolicy
  
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

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/getIamPolicy
  
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

(defn locations-caPools-certificateAuthorities-certificateRevocationLists-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/caPools/certificateAuthorities/certificateRevocationLists/testIamPermissions
  
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

(defn locations-certificateTemplates-create$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/create
  
  Required parameters: parent
  
  Optional parameters: certificateTemplateId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :identityConstraints {:celExpression Expr,
                         :allowSubjectPassthrough boolean,
                         :allowSubjectAltNamesPassthrough boolean},
   :name string,
   :maximumLifetime string,
   :createTime string,
   :passthroughExtensions {:knownExtensions [string],
                           :additionalExtensions [ObjectId]},
   :updateTime string,
   :predefinedValues {:keyUsage KeyUsage,
                      :caOptions CaOptions,
                      :policyIds [ObjectId],
                      :aiaOcspServers [string],
                      :nameConstraints NameConstraints,
                      :additionalExtensions [X509Extension]}}
  
  Create a new CertificateTemplate in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificateTemplates"
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

(defn locations-certificateTemplates-delete$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  DeleteCertificateTemplate deletes a CertificateTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateTemplates-get$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a CertificateTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateTemplates-list$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateTemplates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://privateca.googleapis.com/"
     "v1/{+parent}/certificateTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateTemplates-patch$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :identityConstraints {:celExpression Expr,
                         :allowSubjectPassthrough boolean,
                         :allowSubjectAltNamesPassthrough boolean},
   :name string,
   :maximumLifetime string,
   :createTime string,
   :passthroughExtensions {:knownExtensions [string],
                           :additionalExtensions [ObjectId]},
   :updateTime string,
   :predefinedValues {:keyUsage KeyUsage,
                      :caOptions CaOptions,
                      :policyIds [ObjectId],
                      :aiaOcspServers [string],
                      :nameConstraints NameConstraints,
                      :additionalExtensions [X509Extension]}}
  
  Update a CertificateTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://privateca.googleapis.com/"
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

(defn locations-certificateTemplates-setIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/setIamPolicy
  
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

(defn locations-certificateTemplates-getIamPolicy$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/getIamPolicy
  
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

(defn locations-certificateTemplates-testIamPermissions$
  "https://cloud.google.com/api/reference/rest/v1/projects/locations/certificateTemplates/testIamPermissions
  
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
