(ns happygapi.dns.managedZoneOperations
  "Google Cloud DNS API: managedZoneOperations.
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZoneOperations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZoneOperations/get
  
  Required parameters: managedZone, operation, project
  
  Optional parameters: clientOperationId
  
  Fetch the representation of an existing Operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:managedZone :operation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/operations/{operation}"
     #{:managedZone :operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/managedZoneOperations/list
  
  Required parameters: managedZone, project
  
  Optional parameters: maxResults, pageToken, sortBy
  
  Enumerate Operations for the given ManagedZone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/operations"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
