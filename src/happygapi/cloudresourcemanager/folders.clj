(ns happygapi.cloudresourcemanager.folders
  "Cloud Resource Manager API: folders.
  Creates, reads, and updates metadata for Google Cloud Platform resource containers.
  See: https://cloud.google.com/resource-managerapi/reference/rest/v2/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/get
  
  Required parameters: name
  
  Optional parameters: none
  Retrieves a Folder identified by the supplied resource name.
  Valid Folder resource names have the format `folders/{folder_id}`
  (for example, `folders/1234`).
  The caller must have `resourcemanager.folders.get` permission on the
  identified folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on a Folder, replacing any existing policy.
  The `resource` field should be the Folder's resource name, e.g.
  \"folders/1234\".
  The caller must have `resourcemanager.folders.setIamPolicy` permission
  on the identified folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
     #{:resource}
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

(defn patch$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :parent string,
   :createTime string,
   :lifecycleState string}
  
  Updates a Folder, changing its display_name.
  Changes to the folder display_name will be rejected if they violate either
  the display_name formatting rules or naming constraints described in
  the CreateFolder documentation.
  
  The Folder's display name must start and end with a letter or digit,
  may contain letters, digits, spaces, hyphens and underscores and can be
  no longer than 30 characters. This is captured by the regular expression:
  [\\p{L}\\p{N}]([\\p{L}\\p{N}_- ]{0,28}[\\p{L}\\p{N}])?.
  The caller must have `resourcemanager.folders.update` permission on the
  identified folder.
  
  If the update fails due to the unique name constraint then a
  PreconditionFailure explaining this violation will be returned
  in the Status.details field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+name}"
     #{:name}
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

(defn testIamPermissions$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified Folder.
  The `resource` field should be the Folder's resource name,
  e.g. \"folders/1234\".
  
  There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
     #{:resource}
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

(defn create$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/create
  
  Required parameters: none
  
  Optional parameters: parent
  
  Body: 
  
  {:name string,
   :displayName string,
   :parent string,
   :createTime string,
   :lifecycleState string}
  
  Creates a Folder in the resource hierarchy.
  Returns an Operation which can be used to track the progress of the
  folder creation workflow.
  Upon success the Operation.response field will be populated with the
  created Folder.
  
  In order to succeed, the addition of this new Folder must not violate
  the Folder naming, height or fanout constraints.
  
  + The Folder's display_name must be distinct from all other Folder's that
  share its parent.
  + The addition of the Folder must not cause the active Folder hierarchy
  to exceed a height of 4. Note, the full active + deleted Folder hierarchy
  is allowed to reach a height of 8; this provides additional headroom when
  moving folders that contain deleted folders.
  + The addition of the Folder must not cause the total number of Folders
  under its parent to exceed 100.
  
  If the operation fails due to a folder constraint violation, some errors
  may be returned by the CreateFolder request, with status code
  FAILED_PRECONDITION and an error description. Other folder constraint
  violations will be communicated in the Operation, with the specific
  PreconditionFailure returned via the details list in the Operation.error
  field.
  
  The caller must have `resourcemanager.folders.create` permission on the
  identified parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/folders"
     #{}
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

(defn move$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationParent string}
  
  Moves a Folder under a new resource parent.
  Returns an Operation which can be used to track the progress of the
  folder move workflow.
  Upon success the Operation.response field will be populated with the
  moved Folder.
  Upon failure, a FolderOperationError categorizing the failure cause will
  be returned - if the failure occurs synchronously then the
  FolderOperationError will be returned via the Status.details field
  and if it occurs asynchronously then the FolderOperation will be returned
  via the Operation.error field.
  In addition, the Operation.metadata field will be populated with a
  FolderOperation message as an aid to stateless clients.
  Folder moves will be rejected if they violate either the naming, height
  or fanout constraints described in the
  CreateFolder documentation.
  The caller must have `resourcemanager.folders.move` permission on the
  folder's current and proposed new parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+name}:move"
     #{:name}
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
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/delete
  
  Required parameters: name
  
  Optional parameters: none
  Requests deletion of a Folder. The Folder is moved into the
  DELETE_REQUESTED state
  immediately, and is deleted approximately 30 days later. This method may
  only be called on an empty Folder in the
  ACTIVE state, where a Folder is empty if
  it doesn't contain any Folders or Projects in the
  ACTIVE state.
  The caller must have `resourcemanager.folders.delete` permission on the
  identified folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer, :query string}
  
  Search for folders that match specific filter criteria.
  Search provides an eventually consistent view of the folders a user has
  access to which meet the specified filter criteria.
  
  This will only return folders on which the caller has the
  permission `resourcemanager.folders.get`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/folders:search"
     #{}
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

(defn getIamPolicy$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a Folder. The returned policy may be
  empty if no such policy or resource exists. The `resource` field should
  be the Folder's resource name, e.g. \"folders/1234\".
  The caller must have `resourcemanager.folders.getIamPolicy` permission
  on the identified folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
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

(defn undelete$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels the deletion request for a Folder. This method may only be
  called on a Folder in the
  DELETE_REQUESTED state.
  In order to succeed, the Folder's parent must be in the
  ACTIVE state.
  In addition, reintroducing the folder into the tree must not violate
  folder naming, height and fanout constraints described in the
  CreateFolder documentation.
  The caller must have `resourcemanager.folders.undelete` permission on the
  identified folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/{+name}:undelete"
     #{:name}
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

(defn list$
  "https://cloud.google.com/resource-managerapi/reference/rest/v2/folders/list
  
  Required parameters: none
  
  Optional parameters: showDeleted, pageToken, pageSize, parent
  Lists the Folders that are direct descendants of supplied parent resource.
  List provides a strongly consistent view of the Folders underneath
  the specified parent resource.
  List returns Folders sorted based upon the (ascending) lexical ordering
  of their display_name.
  The caller must have `resourcemanager.folders.list` permission on the
  identified parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudresourcemanager.googleapis.com/"
     "v2/folders"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
