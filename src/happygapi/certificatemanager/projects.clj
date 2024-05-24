(ns happygapi.certificatemanager.projects
  "Certificate Manager API: projects.
  
  See: https://cloud.google.com/certificate-managerdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificates-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Certificates in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificates-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificates-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificates/create
  
  Required parameters: parent
  
  Optional parameters: certificateId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :selfManaged {:pemCertificate string, :pemPrivateKey string},
   :createTime string,
   :scope string,
   :updateTime string,
   :sanDnsnames [string],
   :pemCertificate string,
   :managed {:domains [string],
             :dnsAuthorizations [string],
             :issuanceConfig string,
             :state string,
             :provisioningIssue ProvisioningIssue,
             :authorizationAttemptInfo [AuthorizationAttemptInfo]},
   :expireTime string}
  
  Creates a new Certificate in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificates-patch$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :selfManaged {:pemCertificate string, :pemPrivateKey string},
   :createTime string,
   :scope string,
   :updateTime string,
   :sanDnsnames [string],
   :pemCertificate string,
   :managed {:domains [string],
             :dnsAuthorizations [string],
             :issuanceConfig string,
             :state string,
             :provisioningIssue ProvisioningIssue,
             :authorizationAttemptInfo [AuthorizationAttemptInfo]},
   :expireTime string}
  
  Updates a Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificates-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateMaps in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateMaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateMaps-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CertificateMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/create
  
  Required parameters: parent
  
  Optional parameters: certificateMapId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :gclbTargets [{:targetHttpsProxy string,
                  :targetSslProxy string,
                  :ipConfigs [IpConfig]}]}
  
  Creates a new CertificateMap in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateMaps"
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

(defn locations-certificateMaps-patch$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :labels {},
   :gclbTargets [{:targetHttpsProxy string,
                  :targetSslProxy string,
                  :ipConfigs [IpConfig]}]}
  
  Updates a CertificateMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single CertificateMap. A Certificate Map can't be deleted if it contains Certificate Map Entries. Remove all the entries from the map before calling this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-certificateMapEntries-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/certificateMapEntries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateMapEntries in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateMapEntries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateMaps-certificateMapEntries-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/certificateMapEntries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CertificateMapEntry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-certificateMapEntries-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/certificateMapEntries/create
  
  Required parameters: parent
  
  Optional parameters: certificateMapEntryId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :state string,
   :hostname string,
   :updateTime string,
   :certificates [string],
   :matcher string}
  
  Creates a new CertificateMapEntry in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateMapEntries"
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

(defn locations-certificateMaps-certificateMapEntries-patch$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/certificateMapEntries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :state string,
   :hostname string,
   :updateTime string,
   :certificates [string],
   :matcher string}
  
  Updates a CertificateMapEntry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateMaps-certificateMapEntries-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateMaps/certificateMapEntries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single CertificateMapEntry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-dnsAuthorizations-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/dnsAuthorizations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DnsAuthorizations in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/dnsAuthorizations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dnsAuthorizations-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/dnsAuthorizations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single DnsAuthorization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-dnsAuthorizations-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/dnsAuthorizations/create
  
  Required parameters: parent
  
  Optional parameters: dnsAuthorizationId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :domain string,
   :dnsResourceRecord {:name string, :type string, :data string},
   :type string}
  
  Creates a new DnsAuthorization in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/dnsAuthorizations"
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

(defn locations-dnsAuthorizations-patch$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/dnsAuthorizations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :domain string,
   :dnsResourceRecord {:name string, :type string, :data string},
   :type string}
  
  Updates a DnsAuthorization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-dnsAuthorizations-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/dnsAuthorizations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single DnsAuthorization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateIssuanceConfigs-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateIssuanceConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CertificateIssuanceConfigs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateIssuanceConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-certificateIssuanceConfigs-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateIssuanceConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CertificateIssuanceConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-certificateIssuanceConfigs-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateIssuanceConfigs/create
  
  Required parameters: parent
  
  Optional parameters: certificateIssuanceConfigId
  
  Body: 
  
  {:description string,
   :labels {},
   :rotationWindowPercentage integer,
   :name string,
   :keyAlgorithm string,
   :createTime string,
   :updateTime string,
   :lifetime string,
   :certificateAuthorityConfig {:certificateAuthorityServiceConfig CertificateAuthorityServiceConfig}}
  
  Creates a new CertificateIssuanceConfig in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/certificateIssuanceConfigs"
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

(defn locations-certificateIssuanceConfigs-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/certificateIssuanceConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single CertificateIssuanceConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-trustConfigs-list$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/trustConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists TrustConfigs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/trustConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-trustConfigs-get$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/trustConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single TrustConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-trustConfigs-create$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/trustConfigs/create
  
  Required parameters: parent
  
  Optional parameters: trustConfigId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :etag string,
   :trustStores [{:trustAnchors [TrustAnchor],
                  :intermediateCas [IntermediateCA]}],
   :allowlistedCertificates [{:pemCertificate string}]}
  
  Creates a new TrustConfig in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://certificatemanager.googleapis.com/"
     "v1/{+parent}/trustConfigs"
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

(defn locations-trustConfigs-patch$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/trustConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :etag string,
   :trustStores [{:trustAnchors [TrustAnchor],
                  :intermediateCas [IntermediateCA]}],
   :allowlistedCertificates [{:pemCertificate string}]}
  
  Updates a TrustConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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

(defn locations-trustConfigs-delete$
  "https://cloud.google.com/certificate-managerapi/reference/rest/v1/projects/locations/trustConfigs/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a single TrustConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://certificatemanager.googleapis.com/"
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
