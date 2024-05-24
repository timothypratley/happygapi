(ns happygapi.firebaseappdistribution.projects
  "Firebase App Distribution API: projects.
  
  See: https://firebase.google.com/products/app-distributiondocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn groups-delete$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn groups-batchJoin$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/batchJoin
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:createMissingTesters boolean, :emails [string]}
  
  Batch adds members to a group. The testers will gain access to all releases that the groups have access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+group}:batchJoin"
     #{:group}
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

(defn groups-list$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/groups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-create$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/create
  
  Required parameters: parent
  
  Optional parameters: groupId
  
  Body: 
  
  {:testerCount integer,
   :inviteLinkCount integer,
   :name string,
   :displayName string,
   :releaseCount integer}
  
  Create a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/groups"
     #{:parent}
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

(defn groups-get$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn groups-batchLeave$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/batchLeave
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:emails [string]}
  
  Batch removed members from a group. The testers will lose access to all releases that the groups have access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+group}:batchLeave"
     #{:group}
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

(defn groups-patch$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:testerCount integer,
   :inviteLinkCount integer,
   :name string,
   :displayName string,
   :releaseCount integer}
  
  Update a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn testers-batchAdd$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/testers/batchAdd
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:emails [string]}
  
  Batch adds testers. This call adds testers for the specified emails if they don't already exist. Returns all testers specified in the request, including newly created and previously existing testers. This action is idempotent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+project}/testers:batchAdd"
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

(defn testers-list$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/testers/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists testers and their resource ids."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/testers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testers-patch$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/testers/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :name string,
   :groups [string],
   :lastActivityTime string}
  
  Update a tester. If the testers joins a group they gain access to all releases that the group has access to."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn testers-batchRemove$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/testers/batchRemove
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:emails [string]}
  
  Batch removes testers. If found, this call deletes testers for the specified emails. Returns all deleted testers."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+project}/testers:batchRemove"
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

(defn apps-getAabInfo$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/getAabInfo
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets Android App Bundle (AAB) information for a Firebase app."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-distribute$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/distribute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:testerEmails [string], :groupAliases [string]}
  
  Distributes a release to testers. This call does the following: 1. Creates testers for the specified emails, if none exist. 2. Adds the testers and groups to the release. 3. Sends new testers an invitation email. 4. Sends existing testers a new release email. The request will fail with a `INVALID_ARGUMENT` if it contains a group that doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+name}:distribute"
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

(defn apps-releases-batchDelete$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes releases. A maximum of 100 releases can be deleted per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/releases:batchDelete"
     #{:parent}
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

(defn apps-releases-get$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a release."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-list$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Lists releases. By default, sorts by `createTime` in descending order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-releases-patch$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:buildVersion string,
   :firebaseConsoleUri string,
   :name string,
   :displayVersion string,
   :binaryDownloadUri string,
   :createTime string,
   :releaseNotes {:text string},
   :testingUri string}
  
  Updates a release."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-feedbackReports-delete$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/feedbackReports/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a feedback report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-feedbackReports-list$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/feedbackReports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists feedback reports. By default, sorts by `createTime` in descending order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+parent}/feedbackReports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-releases-feedbackReports-get$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/feedbackReports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a feedback report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-operations-cancel$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn apps-releases-operations-get$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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

(defn apps-releases-operations-wait$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/operations/wait
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timeout string}
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+name}:wait"
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

(defn apps-releases-operations-list$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-releases-operations-delete$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/projects/apps/releases/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
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
