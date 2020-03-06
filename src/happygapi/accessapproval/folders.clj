(ns happygapi.accessapproval.folders
  "Access Approval API: folders.
  An API for controlling access to data by Google personnel.
  See: https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/getAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: none
  Gets the settings associated with a project, folder, or organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/deleteAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: none
  Deletes the settings associated with a project, folder, or organization.
  This will have the effect of disabling Access Approval for the project,
  folder, or organization, but only if all ancestors also have Access
  Approval disabled. If Access Approval is enabled at a higher level of the
  hierarchy, then Access Approval will still be enabled at this level as
  the settings are inherited."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/updateAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:notificationEmails [string],
   :name string,
   :enrolledAncestor boolean,
   :enrolledServices [{:enrollmentLevel string, :cloudProduct string}]}
  
  Updates the settings associated with a project, folder, or organization.
  Settings to update are determined by the value of field_mask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
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

(defn approvalRequests-approve$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/approvalRequests/approve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:expireTime string}
  
  Approves a request and returns the updated ApprovalRequest.
  
  Returns NOT_FOUND if the request does not exist. Returns
  FAILED_PRECONDITION if the request exists but is not in a pending state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:approve"
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

(defn approvalRequests-list$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/approvalRequests/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  Lists approval requests associated with a project, folder, or organization.
  Approval requests can be filtered by state (pending, active, dismissed).
  The order is reverse chronological."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+parent}/approvalRequests"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-get$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/approvalRequests/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets an approval request. Returns NOT_FOUND if the request does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-dismiss$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/folders/approvalRequests/dismiss
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Dismisses a request. Returns the updated ApprovalRequest.
  
  NOTE: This does not deny access to the resource if another request has been
  made and approved. It is equivalent in effect to ignoring the request
  altogether.
  
  Returns NOT_FOUND if the request does not exist.
  
  Returns FAILED_PRECONDITION if the request exists but is not in a pending
  state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:dismiss"
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
