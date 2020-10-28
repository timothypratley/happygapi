(ns happygapi.dns.changes
  "Cloud DNS API: changes.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/changes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/changes/get
  
  Required parameters: managedZone, changeId, project
  
  Optional parameters: clientOperationId
  
  Fetch the representation of an existing Change."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:managedZone :project :changeId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/changes/{changeId}"
     #{:managedZone :project :changeId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/changes/create
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:startTime string,
   :isServing boolean,
   :status string,
   :additions [{:signatureRrdatas [string],
                :ttl integer,
                :rrdatas [string],
                :routingPolicy RRSetRoutingPolicy,
                :kind string,
                :name string,
                :type string}],
   :deletions [{:signatureRrdatas [string],
                :ttl integer,
                :rrdatas [string],
                :routingPolicy RRSetRoutingPolicy,
                :kind string,
                :name string,
                :type string}],
   :id string,
   :kind string}
  
  Atomically update the ResourceRecordSet collection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/changes"
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/changes/list
  
  Required parameters: project, managedZone
  
  Optional parameters: sortBy, maxResults, sortOrder, pageToken
  
  Enumerate Changes to a ResourceRecordSet collection."
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
     "dns/v1/projects/{project}/managedZones/{managedZone}/changes"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
