(ns happygapi.cloudresourcemanager.organizations
  "Cloud Resource Manager API: organizations.
  Creates, reads, and updates metadata for Google Cloud Platform resource containers.
  See: https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches an organization resource identified by the specified resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations/search
  
  Required parameters: none
  
  Optional parameters: pageSize, query, pageToken
  
  Searches organization resources that are visible to the user and satisfy the specified filter. This method returns organizations in an unspecified order. New organizations do not necessarily appear at the end of the results, and may take a small amount of time to appear. Search will only return organizations on which the user has the permission `resourcemanager.organizations.get`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/organizations:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:version integer,
            :etag string,
            :bindings [Binding],
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on an organization resource. Replaces any existing policy. The `resource` field should be the organization's resource name, for example: \"organizations/123\". Authorization requires the IAM permission `resourcemanager.organizations.setIamPolicy` on the specified organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/{+resource}:setIamPolicy"
     #{:resource}
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

(defn getIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for an organization resource. The policy may be empty if no such policy or resource exists. The `resource` field should be the organization's resource name, for example: \"organizations/123\". Authorization requires the IAM permission `resourcemanager.organizations.getIamPolicy` on the specified organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/{+resource}:getIamPolicy"
     #{:resource}
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

(defn testIamPermissions$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/organizations/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified organization. The `resource` field should be the organization's resource name, for example: \"organizations/123\". There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/{+resource}:testIamPermissions"
     #{:resource}
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
