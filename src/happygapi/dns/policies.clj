(ns happygapi.dns.policies
  "Google Cloud DNS API: policies.
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:alternativeNameServerConfig {:kind string,
                                 :targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer]},
   :description string,
   :enableInboundForwarding boolean,
   :enableLogging boolean,
   :id string,
   :kind string,
   :name string,
   :networks [{:kind string, :networkUrl string}]}
  
  Create a new Policy"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies"
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
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/delete
  
  Required parameters: policy, project
  
  Optional parameters: clientOperationId
  Delete a previously created Policy. Will fail if the policy is still being referenced by a network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:policy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{:policy :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/get
  
  Required parameters: policy, project
  
  Optional parameters: clientOperationId
  Fetch the representation of an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{:policy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{:policy :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken
  Enumerate all Policies associated with a project."
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
     "{project}/policies"
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
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/patch
  
  Required parameters: policy, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:alternativeNameServerConfig {:kind string,
                                 :targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer]},
   :description string,
   :enableInboundForwarding boolean,
   :enableLogging boolean,
   :id string,
   :kind string,
   :name string,
   :networks [{:kind string, :networkUrl string}]}
  
  Apply a partial update to an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:policy :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{:policy :project}
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
  "https://developers.google.com/cloud-dnsapi/reference/rest/v1/policies/update
  
  Required parameters: policy, project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:alternativeNameServerConfig {:kind string,
                                 :targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer]},
   :description string,
   :enableInboundForwarding boolean,
   :enableLogging boolean,
   :id string,
   :kind string,
   :name string,
   :networks [{:kind string, :networkUrl string}]}
  
  Update an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:policy :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{:policy :project}
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
