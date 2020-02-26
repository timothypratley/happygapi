(ns happygapi.accessapproval.folders
  "Access Approval API
  An API for controlling access to data by Google personnel.
  See: https://cloud.google.com/access-approval/docs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "accessapproval_schema.edn"))))

(defn getAccessApprovalSettings$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the settings associated with a project, folder, or organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deleteAccessApprovalSettings$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the settings associated with a project, folder, or organization.
  This will have the effect of disabling Access Approval for the project,
  folder, or organization, but only if all ancestors also have Access
  Approval disabled. If Access Approval is enabled at a higher level of the
  hierarchy, then Access Approval will still be enabled at this level as
  the settings are inherited."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateAccessApprovalSettings$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the settings associated with a project, folder, or organization.
  Settings to update are determined by the value of field_mask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists approval requests associated with a project, folder, or organization.
  Approval requests can be filtered by state (pending, active, dismissed).
  The order is reverse chronological."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+parent}/approvalRequests"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets an approval request. Returns NOT_FOUND if the request does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn approvalRequests-dismiss$
  "Required parameters: name
  
  Optional parameters: none
  
  Dismisses a request. Returns the updated ApprovalRequest.
  
  NOTE: This does not deny access to the resource if another request has been
  made and approved. It is equivalent in effect to ignoring the request
  altogether.
  
  Returns NOT_FOUND if the request does not exist.
  
  Returns FAILED_PRECONDITION if the request exists but is not in a pending
  state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:dismiss"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn approvalRequests-approve$
  "Required parameters: name
  
  Optional parameters: none
  
  Approves a request and returns the updated ApprovalRequest.
  
  Returns NOT_FOUND if the request does not exist. Returns
  FAILED_PRECONDITION if the request exists but is not in a pending state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accessapproval.googleapis.com/"
     "v1/{+name}:approve"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
