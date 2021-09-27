(ns happygapi.dns.managedZones
  "Cloud DNS API: managedZones.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/patch
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :kind string},
   :serviceDirectoryConfig {:kind string,
                            :namespace ManagedZoneServiceDirectoryConfigNamespace},
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

(defn update$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/update
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :kind string},
   :serviceDirectoryConfig {:kind string,
                            :namespace ManagedZoneServiceDirectoryConfigNamespace},
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

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:state string,
                  :defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string},
   :name string,
   :nameServerSet string,
   :reverseLookupConfig {:kind string},
   :privateVisibilityConfig {:networks [ManagedZonePrivateVisibilityConfigNetwork],
                             :kind string},
   :serviceDirectoryConfig {:kind string,
                            :namespace ManagedZoneServiceDirectoryConfigNamespace},
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

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/managedZones/get
  
  Required parameters: managedZone, project
  
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
