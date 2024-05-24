(ns happygapi.developerconnect.projects
  "Developer Connect API: projects.
  Connect third-party source code management to Google
  See: http://cloud.google.com/developer-connect/docs/overviewdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-operations-list$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-operations-get$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-operations-delete$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-operations-cancel$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-list$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Connections in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+parent}/connections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-get$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-create$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/create
  
  Required parameters: parent
  
  Optional parameters: connectionId, requestId, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :disabled boolean,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :installationState {:stage string,
                       :message string,
                       :actionUri string},
   :githubConfig {:githubApp string,
                  :authorizerCredential OAuthCredential,
                  :appInstallationId string,
                  :installationUri string},
   :annotations {}}
  
  Creates a new Connection in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+parent}/connections"
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

(defn locations-connections-patch$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, allowMissing, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :disabled boolean,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :installationState {:stage string,
                       :message string,
                       :actionUri string},
   :githubConfig {:githubApp string,
                  :authorizerCredential OAuthCredential,
                  :appInstallationId string,
                  :installationUri string},
   :annotations {}}
  
  Updates the parameters of a single Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-delete$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/delete
  
  Required parameters: name
  
  Optional parameters: requestId, validateOnly, etag
  
  Deletes a single Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-fetchLinkableGitRepositories$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/fetchLinkableGitRepositories
  
  Required parameters: connection
  
  Optional parameters: pageSize, pageToken
  
  FetchLinkableGitRepositories returns a list of git repositories from an SCM that are available to be added to a Connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:connection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+connection}:fetchLinkableGitRepositories"
     #{:connection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-fetchGitHubInstallations$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/fetchGitHubInstallations
  
  Required parameters: connection
  
  Optional parameters: none
  
  FetchGitHubInstallations returns the list of GitHub Installations that are available to be added to a Connection. For github.com, only installations accessible to the authorizer token are returned. For GitHub Enterprise, all installations are returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:connection})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+connection}:fetchGitHubInstallations"
     #{:connection}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-gitRepositoryLinks-create$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/create
  
  Required parameters: parent
  
  Optional parameters: gitRepositoryLinkId, requestId, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :cloneUri string,
   :annotations {}}
  
  Creates a GitRepositoryLink. Upon linking a Git Repository, Developer Connect will configure the Git Repository to send webhook events to Developer Connect. Connections that use Firebase GitHub Application will have events forwarded to the Firebase service. All other Connections will have events forwarded to Cloud Build."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+parent}/gitRepositoryLinks"
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

(defn locations-connections-gitRepositoryLinks-delete$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/delete
  
  Required parameters: name
  
  Optional parameters: requestId, validateOnly, etag
  
  Deletes a single GitRepositoryLink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-gitRepositoryLinks-list$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists GitRepositoryLinks in a given project, location, and connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+parent}/gitRepositoryLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-gitRepositoryLinks-get$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single GitRepositoryLink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
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

(defn locations-connections-gitRepositoryLinks-fetchReadWriteToken$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/fetchReadWriteToken
  
  Required parameters: gitRepositoryLink
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Fetches read/write token of a given gitRepositoryLink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:gitRepositoryLink})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+gitRepositoryLink}:fetchReadWriteToken"
     #{:gitRepositoryLink}
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

(defn locations-connections-gitRepositoryLinks-fetchReadToken$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/fetchReadToken
  
  Required parameters: gitRepositoryLink
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Fetches read token of a given gitRepositoryLink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:gitRepositoryLink})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+gitRepositoryLink}:fetchReadToken"
     #{:gitRepositoryLink}
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

(defn locations-connections-gitRepositoryLinks-fetchGitRefs$
  "http://cloud.google.com/developer-connect/docs/overviewapi/reference/rest/v1/projects/locations/connections/gitRepositoryLinks/fetchGitRefs
  
  Required parameters: gitRepositoryLink
  
  Optional parameters: refType, pageSize, pageToken
  
  Fetch the list of branches or tags for a given repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:gitRepositoryLink})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://developerconnect.googleapis.com/"
     "v1/{+gitRepositoryLink}:fetchGitRefs"
     #{:gitRepositoryLink}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
