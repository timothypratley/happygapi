(ns happygapi.dns.managedZones
  "Google Cloud DNS API: managedZones.
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string,
                  :state string},
   :name string,
   :nameServerSet string,
   :privateVisibilityConfig {:kind string,
                             :networks [ManagedZonePrivateVisibilityConfigNetwork]},
   :forwardingConfig {:kind string,
                      :targetNameServers [ManagedZoneForwardingConfigNameServerTarget]},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Create a new ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones"
     #{:project}
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

(defn delete$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/delete
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  Delete a previously created ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}"
     #{:managedZone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/get
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  Fetch the representation of an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}"
     #{:managedZone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/list
  
  Required parameters: project
  
  Optional parameters: dnsName, maxResults, pageToken
  Enumerate ManagedZones that have been created but not yet deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/patch
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string,
                  :state string},
   :name string,
   :nameServerSet string,
   :privateVisibilityConfig {:kind string,
                             :networks [ManagedZonePrivateVisibilityConfigNetwork]},
   :forwardingConfig {:kind string,
                      :targetNameServers [ManagedZoneForwardingConfigNameServerTarget]},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Apply a partial update to an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}"
     #{:managedZone :project}
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

(defn update$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZones/update
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :peeringConfig {:kind string,
                   :targetNetwork ManagedZonePeeringConfigTargetNetwork},
   :dnssecConfig {:defaultKeySpecs [DnsKeySpec],
                  :kind string,
                  :nonExistence string,
                  :state string},
   :name string,
   :nameServerSet string,
   :privateVisibilityConfig {:kind string,
                             :networks [ManagedZonePrivateVisibilityConfigNetwork]},
   :forwardingConfig {:kind string,
                      :targetNameServers [ManagedZoneForwardingConfigNameServerTarget]},
   :dnsName string,
   :id string,
   :kind string,
   :nameServers [string],
   :visibility string}
  
  Update an existing ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}"
     #{:managedZone :project}
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
