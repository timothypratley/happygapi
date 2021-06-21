(ns happygapi.cloudresourcemanager.tagValues
  "Cloud Resource Manager API: tagValues.
  Creates, reads, and updates metadata for Google Cloud Platform resource containers.
  See: https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a TagValue. The TagValue cannot have any bindings when it is deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
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

(defn create$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/create
  
  Required parameters: none
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :shortName string,
   :name string,
   :namespacedName string,
   :parent string,
   :etag string,
   :createTime string,
   :updateTime string}
  
  Creates a TagValue as a child of the specified TagKey. If a another request with the same parameters is sent while the original request is in process the second request will receive an error. A maximum of 300 TagValues can exist under a TagKey at any given time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/tagValues"
     #{}
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

(defn setIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:version integer,
            :etag string,
            :bindings [Binding],
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on a TagValue, replacing any existing policy. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must have `resourcemanager.tagValues.setIamPolicy` permission on the identified tagValue."
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
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a TagValue. The returned policy may be empty if no such policy or resource exists. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. The caller must have the `cloudresourcemanager.googleapis.com/tagValues.getIamPolicy` permission on the identified TagValue to get the access control policy."
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

(defn patch$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :shortName string,
   :name string,
   :namespacedName string,
   :parent string,
   :etag string,
   :createTime string,
   :updateTime string}
  
  Updates the attributes of the TagValue resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/{+name}"
     #{:name}
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
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified TagValue. The `resource` field should be the TagValue's resource name. For example: `tagValues/1234`. There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
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

(defn get$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves TagValue. If the TagValue or namespaced name does not exist, or if the user does not have permission to view it, this method will return `PERMISSION_DENIED`."
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

(defn list$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagValues/list
  
  Required parameters: none
  
  Optional parameters: parent, pageToken, pageSize
  
  Lists all TagValues for a specific TagKey."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/tagValues"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
