(ns happygapi.dns.projects
  "Cloud DNS API: projects.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/projects/get
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Fetches the representation of an existing Project."
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
     "dns/v1/projects/{project}"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn managedZones-rrsets-get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/projects/managedZones/rrsets/get
  
  Required parameters: name, project, managedZone, type
  
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

(defn managedZones-rrsets-patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/projects/managedZones/rrsets/patch
  
  Required parameters: managedZone, project, name, type
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:signatureRrdatas [string],
   :name string,
   :type string,
   :rrdatas [string],
   :kind string,
   :ttl integer}
  
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

(defn managedZones-rrsets-create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/projects/managedZones/rrsets/create
  
  Required parameters: project, managedZone
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:signatureRrdatas [string],
   :name string,
   :type string,
   :rrdatas [string],
   :kind string,
   :ttl integer}
  
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

(defn managedZones-rrsets-delete$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/projects/managedZones/rrsets/delete
  
  Required parameters: type, managedZone, project, name
  
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
