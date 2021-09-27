(ns happygapi.dns.resourceRecordSets
  "Cloud DNS API: resourceRecordSets.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/create
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:rrdatas [string],
   :type string,
   :ttl integer,
   :signatureRrdatas [string],
   :name string,
   :kind string}
  
  Creates a new ResourceRecordSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:managedZone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets"
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/list
  
  Required parameters: project, managedZone
  
  Optional parameters: pageToken, maxResults, type, name
  
  Enumerates ResourceRecordSets that you have created but not yet deleted."
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
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets"
     #{:managedZone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/get
  
  Required parameters: project, type, name, managedZone
  
  Optional parameters: clientOperationId
  
  Fetches the representation of an existing ResourceRecordSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:name :managedZone :type :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}"
     #{:name :managedZone :type :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/delete
  
  Required parameters: name, type, project, managedZone
  
  Optional parameters: clientOperationId
  
  Deletes a previously created ResourceRecordSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:name :managedZone :type :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}"
     #{:name :managedZone :type :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/resourceRecordSets/patch
  
  Required parameters: managedZone, type, project, name
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:rrdatas [string],
   :type string,
   :ttl integer,
   :signatureRrdatas [string],
   :name string,
   :kind string}
  
  Applies a partial update to an existing ResourceRecordSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:name :managedZone :type :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/managedZones/{managedZone}/rrsets/{name}/{type}"
     #{:name :managedZone :type :project}
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
