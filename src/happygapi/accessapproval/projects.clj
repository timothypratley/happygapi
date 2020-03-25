(ns happygapi.accessapproval.projects
  "Access Approval API: projects.
  An API for controlling access to data by Google personnel.
  See: https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/getAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the settings associated with a project, folder, or organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deleteAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/deleteAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the settings associated with a project, folder, or organization.
  This will have the effect of disabling Access Approval for the project,
  folder, or organization, but only if all ancestors also have Access
  Approval disabled. If Access Approval is enabled at a higher level of the
  hierarchy, then Access Approval will still be enabled at this level as
  the settings are inherited."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateAccessApprovalSettings$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/updateAccessApprovalSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :enrolledAncestor boolean,
   :enrolledServices [{:cloudProduct string, :enrollmentLevel string}],
   :notificationEmails [string]}
  
  Updates the settings associated with a project, folder, or organization.
  Settings to update are determined by the value of field_mask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
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

(defn approvalRequests-list$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/approvalRequests/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists approval requests associated with a project, folder, or organization.
  Approval requests can be filtered by state (pending, active, dismissed).
  The order is reverse chronological."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+parent}/approvalRequests"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-get$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/approvalRequests/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an approval request. Returns NOT_FOUND if the request does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-dismiss$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/approvalRequests/dismiss
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:dismiss"
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

(defn approvalRequests-approve$
  "https://cloud.google.com/access-approval/docsapi/reference/rest/v1/projects/approvalRequests/approve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:expireTime string}
  
  Approves a request and returns the updated ApprovalRequest.
  
  Returns NOT_FOUND if the request does not exist. Returns
  FAILED_PRECONDITION if the request exists but is not in a pending state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:approve"
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
