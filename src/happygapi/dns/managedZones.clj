(ns happygapi.dns.managedZones
  "Cloud DNS API: managedZones.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/get
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Fetches the representation of an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/{+resource}:setIamPolicy"
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

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/patch
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:targetNetwork ManagedZonePeeringConfigTargetNetwork,
                   :kind string},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :nonExistence string,
                  :kind string},
   :cloudLoggingConfig {:enableLogging boolean, :kind string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :gkeClusters [ManagedZonePrivateVisibilityConfigGKECluster],
                             :kind string},
   :serviceDirectoryConfig {:namespace ManagedZoneServiceDirectoryConfigNamespace,
                            :kind string},
   :forwardingConfig {:targetNameServers [ManagedZoneForwardingConfigNameServerTarget],
                      :kind string},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Applies a partial update to an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}"
     #{:managedZone :project}
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

(defn testIamPermissions$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this returns an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/{+resource}:testIamPermissions"
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

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:targetNetwork ManagedZonePeeringConfigTargetNetwork,
                   :kind string},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :nonExistence string,
                  :kind string},
   :cloudLoggingConfig {:enableLogging boolean, :kind string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :gkeClusters [ManagedZonePrivateVisibilityConfigGKECluster],
                             :kind string},
   :serviceDirectoryConfig {:namespace ManagedZoneServiceDirectoryConfigNamespace,
                            :kind string},
   :forwardingConfig {:targetNameServers [ManagedZoneForwardingConfigNameServerTarget],
                      :kind string},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Creates a new ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones"
     #{:project}
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

(defn update$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/update
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:targetNetwork ManagedZonePeeringConfigTargetNetwork,
                   :kind string},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :nonExistence string,
                  :kind string},
   :cloudLoggingConfig {:enableLogging boolean, :kind string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :gkeClusters [ManagedZonePrivateVisibilityConfigGKECluster],
                             :kind string},
   :serviceDirectoryConfig {:namespace ManagedZoneServiceDirectoryConfigNamespace,
                            :kind string},
   :forwardingConfig {:targetNameServers [ManagedZoneForwardingConfigNameServerTarget],
                      :kind string},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Updates an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}"
     #{:managedZone :project}
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

(defn delete$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/delete
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Deletes a previously created ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/{+resource}:getIamPolicy"
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

(defn list$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, dnsName
  
  Enumerates ManagedZones that have been created but not yet deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
