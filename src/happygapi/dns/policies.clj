(ns happygapi.dns.policies
  "Cloud DNS API: policies.
  
  See: https://cloud.google.com/dns/docsapi/reference/rest/v1/policies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/get
  
  Required parameters: project, policy
  
  Optional parameters: clientOperationId
  
  Fetch the representation of an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:policy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/policies/{policy}"
     #{:policy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/update
  
  Required parameters: project, policy
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :enableInboundForwarding boolean,
   :kind string,
   :description string,
   :alternativeNameServerConfig {:targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer],
                                 :kind string},
   :enableLogging boolean,
   :name string,
   :networks [{:networkUrl string, :kind string}]}
  
  Update an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:policy :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/policies/{policy}"
     #{:policy :project}
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/delete
  
  Required parameters: policy, project
  
  Optional parameters: clientOperationId
  
  Delete a previously created Policy. Will fail if the policy is still being referenced by a network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:policy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/policies/{policy}"
     #{:policy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :enableInboundForwarding boolean,
   :kind string,
   :description string,
   :alternativeNameServerConfig {:targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer],
                                 :kind string},
   :enableLogging boolean,
   :name string,
   :networks [{:networkUrl string, :kind string}]}
  
  Create a new Policy"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/policies"
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

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/patch
  
  Required parameters: project, policy
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :enableInboundForwarding boolean,
   :kind string,
   :description string,
   :alternativeNameServerConfig {:targetNameServers [PolicyAlternativeNameServerConfigTargetNameServer],
                                 :kind string},
   :enableLogging boolean,
   :name string,
   :networks [{:networkUrl string, :kind string}]}
  
  Apply a partial update to an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:policy :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/policies/{policy}"
     #{:policy :project}
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/policies/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken
  
  Enumerate all Policies associated with a project."
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
     "dns/v1/projects/{project}/policies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
