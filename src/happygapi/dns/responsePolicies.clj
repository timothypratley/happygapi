(ns happygapi.dns.responsePolicies
  "Cloud DNS API: responsePolicies.
  
  See: https://cloud.google.com/dns/docsdocs/reference/rest/v1/responsePolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/create
  
  Required parameters: project
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :responsePolicyName string,
   :description string,
   :networks [{:networkUrl string, :kind string}],
   :gkeClusters [{:gkeClusterName string, :kind string}],
   :labels {},
   :kind string}
  
  Creates a new Response Policy"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies"
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/get
  
  Required parameters: project, responsePolicy
  
  Optional parameters: clientOperationId
  
  Fetches the representation of an existing Response Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}"
     #{:project :responsePolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken
  
  Enumerates all Response Policies associated with a project."
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
     "dns/v1/projects/{project}/responsePolicies"
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/delete
  
  Required parameters: project, responsePolicy
  
  Optional parameters: clientOperationId
  
  Deletes a previously created Response Policy. Fails if the response policy is non-empty or still being referenced by a network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}"
     #{:project :responsePolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/patch
  
  Required parameters: project, responsePolicy
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :responsePolicyName string,
   :description string,
   :networks [{:networkUrl string, :kind string}],
   :gkeClusters [{:gkeClusterName string, :kind string}],
   :labels {},
   :kind string}
  
  Applies a partial update to an existing Response Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}"
     #{:project :responsePolicy}
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
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicies/update
  
  Required parameters: project, responsePolicy
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:id string,
   :responsePolicyName string,
   :description string,
   :networks [{:networkUrl string, :kind string}],
   :gkeClusters [{:gkeClusterName string, :kind string}],
   :labels {},
   :kind string}
  
  Updates an existing Response Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}"
     #{:project :responsePolicy}
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
