(ns happygapi.cloudkms.projects
  "Cloud Key Management Service (KMS) API: projects.
  Manages keys and performs cryptographic operations in a central cloud service, for direct use by other cloud resources and applications.
  
  See: https://cloud.google.com/kms/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, filter
  Lists KeyRings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/keyRings"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-create$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/create
  
  Required parameters: parent
  
  Optional parameters: keyRingId
  
  Body: 
  
  {:createTime string, :name string}
  
  Create a new KeyRing in a given Project and Location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/keyRings"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-setIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-getIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-get$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns metadata for a given KeyRing."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-testIamPermissions$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-get$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns metadata for a given CryptoKey, as well as its
  primary CryptoKeyVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-setIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-patch$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:rotationPeriod string,
   :primary {:algorithm string,
             :generateTime string,
             :importFailureReason string,
             :name string,
             :importTime string,
             :createTime string,
             :state string,
             :externalProtectionLevelOptions ExternalProtectionLevelOptions,
             :importJob string,
             :attestation KeyOperationAttestation,
             :protectionLevel string,
             :destroyTime string,
             :destroyEventTime string},
   :name string,
   :versionTemplate {:algorithm string, :protectionLevel string},
   :purpose string,
   :nextRotationTime string,
   :labels {},
   :createTime string}
  
  Update a CryptoKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-testIamPermissions$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-create$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/create
  
  Required parameters: parent
  
  Optional parameters: cryptoKeyId, skipInitialVersionCreation
  
  Body: 
  
  {:rotationPeriod string,
   :primary {:algorithm string,
             :generateTime string,
             :importFailureReason string,
             :name string,
             :importTime string,
             :createTime string,
             :state string,
             :externalProtectionLevelOptions ExternalProtectionLevelOptions,
             :importJob string,
             :attestation KeyOperationAttestation,
             :protectionLevel string,
             :destroyTime string,
             :destroyEventTime string},
   :name string,
   :versionTemplate {:algorithm string, :protectionLevel string},
   :purpose string,
   :nextRotationTime string,
   :labels {},
   :createTime string}
  
  Create a new CryptoKey within a KeyRing.
  
  CryptoKey.purpose and
  CryptoKey.version_template.algorithm
  are required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeys"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-encrypt$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/encrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:additionalAuthenticatedData string, :plaintext string}
  
  Encrypts data, so that it can only be recovered by a call to Decrypt.
  The CryptoKey.purpose must be
  ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:encrypt"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-getIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, versionView, filter, pageToken, pageSize
  Lists CryptoKeys."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeys"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-updatePrimaryVersion$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/updatePrimaryVersion
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cryptoKeyVersionId string}
  
  Update the version of a CryptoKey that will be used in Encrypt.
  
  Returns an error if called on an asymmetric key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:updatePrimaryVersion"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-decrypt$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/decrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ciphertext string, :additionalAuthenticatedData string}
  
  Decrypts data that was protected by Encrypt. The CryptoKey.purpose
  must be ENCRYPT_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:decrypt"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-get$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns metadata for a given CryptoKeyVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-patch$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:algorithm string,
   :generateTime string,
   :importFailureReason string,
   :name string,
   :importTime string,
   :createTime string,
   :state string,
   :externalProtectionLevelOptions {:externalKeyUri string},
   :importJob string,
   :attestation {:format string, :content string},
   :protectionLevel string,
   :destroyTime string,
   :destroyEventTime string}
  
  Update a CryptoKeyVersion's metadata.
  
  state may be changed between
  ENABLED and
  DISABLED using this
  method. See DestroyCryptoKeyVersion and RestoreCryptoKeyVersion to
  move between other states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-restore$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restore a CryptoKeyVersion in the
  DESTROY_SCHEDULED
  state.
  
  Upon restoration of the CryptoKeyVersion, state
  will be set to DISABLED,
  and destroy_time will be cleared."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:restore"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-create$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:algorithm string,
   :generateTime string,
   :importFailureReason string,
   :name string,
   :importTime string,
   :createTime string,
   :state string,
   :externalProtectionLevelOptions {:externalKeyUri string},
   :importJob string,
   :attestation {:format string, :content string},
   :protectionLevel string,
   :destroyTime string,
   :destroyEventTime string}
  
  Create a new CryptoKeyVersion in a CryptoKey.
  
  The server will assign the next sequential id. If unset,
  state will be set to
  ENABLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-destroy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/destroy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Schedule a CryptoKeyVersion for destruction.
  
  Upon calling this method, CryptoKeyVersion.state will be set to
  DESTROY_SCHEDULED
  and destroy_time will be set to a time 24
  hours in the future, at which point the state
  will be changed to
  DESTROYED, and the key
  material will be irrevocably destroyed.
  
  Before the destroy_time is reached,
  RestoreCryptoKeyVersion may be called to reverse the process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:destroy"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-getPublicKey$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/getPublicKey
  
  Required parameters: name
  
  Optional parameters: none
  Returns the public key for the given CryptoKeyVersion. The
  CryptoKey.purpose must be
  ASYMMETRIC_SIGN or
  ASYMMETRIC_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}/publicKey"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricSign$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricSign
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:digest {:sha384 string, :sha256 string, :sha512 string}}
  
  Signs data using a CryptoKeyVersion with CryptoKey.purpose
  ASYMMETRIC_SIGN, producing a signature that can be verified with the public
  key retrieved from GetPublicKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:asymmetricSign"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view, orderBy, filter
  Lists CryptoKeyVersions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-import$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:algorithm string, :rsaAesWrappedKey string, :importJob string}
  
  Imports a new CryptoKeyVersion into an existing CryptoKey using the
  wrapped key material provided in the request.
  
  The version ID will be assigned the next sequential id within the
  CryptoKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/cryptoKeyVersions:import"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-cryptoKeyVersions-asymmetricDecrypt$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/cryptoKeyVersions/asymmetricDecrypt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:ciphertext string}
  
  Decrypts data that was encrypted with a public key retrieved from
  GetPublicKey corresponding to a CryptoKeyVersion with
  CryptoKey.purpose ASYMMETRIC_DECRYPT."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}:asymmetricDecrypt"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-getIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-get$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns metadata for a given ImportJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-testIamPermissions$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  Lists ImportJobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/importJobs"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-create$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/create
  
  Required parameters: parent
  
  Optional parameters: importJobId
  
  Body: 
  
  {:generateTime string,
   :name string,
   :createTime string,
   :expireEventTime string,
   :state string,
   :publicKey {:pem string},
   :attestation {:format string, :content string},
   :expireTime string,
   :importMethod string,
   :protectionLevel string}
  
  Create a new ImportJob within a KeyRing.
  
  ImportJob.import_method is required."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+parent}/importJobs"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-importJobs-setIamPolicy$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/importJobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloudkms"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudkms.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
