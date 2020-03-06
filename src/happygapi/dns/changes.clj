(ns happygapi.dns.changes
  "Google Cloud DNS API: changes.
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dnsapi/reference/rest/v1/changes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/changes/create
  
  Required parameters: managedZone, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:additions [{:kind string,
                :name string,
                :rrdatas [string],
                :signatureRrdatas [string],
                :ttl integer,
                :type string}],
   :deletions [{:kind string,
                :name string,
                :rrdatas [string],
                :signatureRrdatas [string],
                :ttl integer,
                :type string}],
   :id string,
   :isServing boolean,
   :kind string,
   :startTime string,
   :status string}
  
  Atomically update the ResourceRecordSet collection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:managedZone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/changes"
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

(defn get$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/changes/get
  
  Required parameters: changeId, managedZone, project
  
  Optional parameters: clientOperationId
  Fetch the representation of an existing Change."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:managedZone :project :changeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/managedZones/{managedZone}/changes/{changeId}"
     #{:managedZone :project :changeId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/changes/list
  
  Required parameters: managedZone, project
  
  Optional parameters: maxResults, pageToken, sortBy, sortOrder
  Enumerate Changes to a ResourceRecordSet collection."
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
     "{project}/managedZones/{managedZone}/changes"
     #{:managedZone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
