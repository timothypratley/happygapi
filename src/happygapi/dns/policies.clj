(ns happygapi.dns.policies
  "Google Cloud DNS API
  Configures and serves authoritative DNS records.
  See: https://developers.google.com/cloud-dns"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn create$
  "Required parameters: project
  
  Create a new Policy"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn delete$
  "Required parameters: policy,project
  
  Delete a previously created Policy. Will fail if the policy is still being referenced by a network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "policy"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{"project" "policy"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: policy,project
  
  Fetch the representation of an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "policy"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{"project" "policy"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: project
  
  Enumerate all Policies associated with a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: policy,project
  
  Apply a partial update to an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "policy"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{"project" "policy"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: policy,project
  
  Update an existing Policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "policy"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/dns/v1/projects/"
     "{project}/policies/{policy}"
     #{"project" "policy"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
