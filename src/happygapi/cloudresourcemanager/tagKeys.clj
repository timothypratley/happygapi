(ns happygapi.cloudresourcemanager.tagKeys
  "Cloud Resource Manager API: tagKeys.
  Creates, reads, and updates metadata for Google Cloud Platform resource containers.
  See: https://cloud.google.com/resource-managerdocs/reference/rest/v3/tagKeys"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a TagKey. This method will return `PERMISSION_DENIED` if the key does not exist or the user does not have permission to view it."
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

(defn setIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on a TagKey, replacing any existing policy. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". The caller must have `resourcemanager.tagKeys.setIamPolicy` permission on the identified tagValue."
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

(defn patch$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :parent string,
   :purpose string,
   :name string,
   :createTime string,
   :namespacedName string,
   :etag string,
   :updateTime string,
   :shortName string,
   :purposeData {}}
  
  Updates the attributes of the TagKey resource."
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
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified TagKey. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". There are no permissions required for making this API call."
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

(defn create$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/create
  
  Required parameters: none
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :parent string,
   :purpose string,
   :name string,
   :createTime string,
   :namespacedName string,
   :etag string,
   :updateTime string,
   :shortName string,
   :purposeData {}}
  
  Creates a new TagKey. If another request with the same parameters is sent while the original request is in process, the second request will receive an error. A maximum of 1000 TagKeys can exist under a parent at any given time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/tagKeys"
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

(defn getNamespaced$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/getNamespaced
  
  Required parameters: none
  
  Optional parameters: name
  
  Retrieves a TagKey by its namespaced name. This method will return `PERMISSION_DENIED` if the key does not exist or the user does not have permission to view it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/tagKeys/namespaced"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a TagKey. The TagKey cannot be deleted if it has any child TagValues."
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

(defn getIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a TagKey. The returned policy may be empty if no such policy or resource exists. The `resource` field should be the TagKey's resource name. For example, \"tagKeys/1234\". The caller must have `cloudresourcemanager.googleapis.com/tagKeys.getIamPolicy` permission on the specified TagKey."
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

(defn list$
  "https://cloud.google.com/resource-managerapi/reference/rest/v3/tagKeys/list
  
  Required parameters: none
  
  Optional parameters: parent, pageSize, pageToken
  
  Lists all TagKeys for a parent resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v3/tagKeys"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
