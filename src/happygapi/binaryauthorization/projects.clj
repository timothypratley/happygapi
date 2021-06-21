(ns happygapi.binaryauthorization.projects
  "Binary Authorization API: projects.
  The management interface for Binary Authorization, a system providing policy control for images deployed to Kubernetes Engine clusters. 
  See: https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/getPolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  A policy specifies the attestors that must attest to a container image, before the project is allowed to deploy that image. There is at most one policy per project. All image admission requests are permitted if a project has no policy. Gets the policy for this project. Returns a default policy if the project does not have one."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn updatePolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/updatePolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :name string,
   :defaultAdmissionRule {:requireAttestationsBy [string],
                          :evaluationMode string,
                          :enforcementMode string},
   :updateTime string,
   :istioServiceIdentityAdmissionRules {},
   :clusterAdmissionRules {},
   :globalPolicyEvaluationMode string,
   :kubernetesServiceAccountAdmissionRules {},
   :kubernetesNamespaceAdmissionRules {},
   :admissionWhitelistPatterns [{:namePattern string}]}
  
  Creates or updates a project's policy, and returns a copy of the new policy. A policy is always updated as a whole, to avoid race conditions with concurrent policy enforcement (or management!) requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT if the request is malformed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn policy-testIamPermissions$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/policy/testIamPermissions
  
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
     "https://binaryauthorization.googleapis.com/"
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

(defn policy-setIamPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/policy/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string, :version integer, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn policy-getIamPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/policy/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-get$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an attestor. Returns NOT_FOUND if the attestor does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-setIamPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string, :version integer, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-testIamPermissions$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/testIamPermissions
  
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
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-create$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/create
  
  Required parameters: parent
  
  Optional parameters: attestorId
  
  Body: 
  
  {:userOwnedGrafeasNote {:publicKeys [AttestorPublicKey],
                          :noteReference string,
                          :delegationServiceAccountEmail string},
   :name string,
   :description string,
   :updateTime string}
  
  Creates an attestor, and returns a copy of the new attestor. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the attestor already exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
     "v1/{+parent}/attestors"
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

(defn attestors-update$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:userOwnedGrafeasNote {:publicKeys [AttestorPublicKey],
                          :noteReference string,
                          :delegationServiceAccountEmail string},
   :name string,
   :description string,
   :updateTime string}
  
  Updates an attestor. Returns NOT_FOUND if the attestor does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-delete$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an attestor. Returns NOT_FOUND if the attestor does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-getIamPolicy$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
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

(defn attestors-list$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists attestors. Returns INVALID_ARGUMENT if the project does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
     "v1/{+parent}/attestors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attestors-validateAttestationOccurrence$
  "https://cloud.google.com/binary-authorization/api/reference/rest/v1/projects/attestors/validateAttestationOccurrence
  
  Required parameters: attestor
  
  Optional parameters: none
  
  Body: 
  
  {:occurrenceNote string,
   :attestation {:serializedPayload string,
                 :signatures [Signature],
                 :jwts [Jwt]},
   :occurrenceResourceUri string}
  
  Returns whether the given Attestation for the given image URI was signed by the given Attestor"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:attestor})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://binaryauthorization.googleapis.com/"
     "v1/{+attestor}:validateAttestationOccurrence"
     #{:attestor}
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
