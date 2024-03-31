(ns happygapi.dataform.projects
  "Dataform API: projects.
  Service to develop, version control, and operationalize SQL pipelines in BigQuery.
  See: https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}/locations"
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
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-readFile$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/readFile
  
  Required parameters: name
  
  Optional parameters: commitSha, path
  
  Returns the contents of a file (inside a Repository). The Repository must not have a value for `git_remote_settings.url`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:readFile"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-setIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-repositories-patch$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :setAuthenticatedUserAdmin boolean,
   :workspaceCompilationOverrides {:defaultDatabase string,
                                   :schemaSuffix string,
                                   :tablePrefix string},
   :displayName string,
   :npmrcEnvironmentVariablesSecretVersion string,
   :name string,
   :createTime string,
   :gitRemoteSettings {:url string,
                       :defaultBranch string,
                       :authenticationTokenSecretVersion string,
                       :sshAuthenticationConfig SshAuthenticationConfig,
                       :tokenStatus string}}
  
  Updates a single Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-repositories-testIamPermissions$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-repositories-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/create
  
  Required parameters: parent
  
  Optional parameters: repositoryId
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :setAuthenticatedUserAdmin boolean,
   :workspaceCompilationOverrides {:defaultDatabase string,
                                   :schemaSuffix string,
                                   :tablePrefix string},
   :displayName string,
   :npmrcEnvironmentVariablesSecretVersion string,
   :name string,
   :createTime string,
   :gitRemoteSettings {:url string,
                       :defaultBranch string,
                       :authenticationTokenSecretVersion string,
                       :sshAuthenticationConfig SshAuthenticationConfig,
                       :tokenStatus string}}
  
  Creates a new Repository in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/repositories"
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

(defn locations-repositories-delete$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a single Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-fetchRemoteBranches$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/fetchRemoteBranches
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a Repository's remote branches."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:fetchRemoteBranches"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-getIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-queryDirectoryContents$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/queryDirectoryContents
  
  Required parameters: name
  
  Optional parameters: commitSha, path, pageSize, pageToken
  
  Returns the contents of a given Repository directory. The Repository must not have a value for `git_remote_settings.url`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:queryDirectoryContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists Repositories in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/repositories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-fetchHistory$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/fetchHistory
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Fetches a Repository's history of commits. The Repository must not have a value for `git_remote_settings.url`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:fetchHistory"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-commit$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/commit
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:commitMetadata {:author CommitAuthor, :commitMessage string},
   :requiredHeadCommitSha string,
   :fileOperations {}}
  
  Applies a Git commit to a Repository. The Repository must not have a value for `git_remote_settings.url`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:commit"
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

(defn locations-repositories-computeAccessTokenStatus$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/computeAccessTokenStatus
  
  Required parameters: name
  
  Optional parameters: none
  
  Computes a Repository's Git access token status."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:computeAccessTokenStatus"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-readFile$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/readFile
  
  Required parameters: workspace
  
  Optional parameters: path, revision
  
  Returns the contents of a file (inside a Workspace)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:readFile"
     #{:workspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-removeFile$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/removeFile
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string}
  
  Deletes a file (inside a Workspace)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:removeFile"
     #{:workspace}
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

(defn locations-repositories-workspaces-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-push$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/push
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:remoteBranch string}
  
  Pushes Git commits from a Workspace to the Repository's remote."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:push"
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

(defn locations-repositories-workspaces-setIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-repositories-workspaces-installNpmPackages$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/installNpmPackages
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Installs dependency NPM packages (inside a Workspace)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:installNpmPackages"
     #{:workspace}
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

(defn locations-repositories-workspaces-fetchFileGitStatuses$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/fetchFileGitStatuses
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches Git statuses for the files in a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:fetchFileGitStatuses"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-testIamPermissions$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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

(defn locations-repositories-workspaces-reset$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:paths [string], :clean boolean}
  
  Performs a Git reset for uncommitted files in a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:reset"
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

(defn locations-repositories-workspaces-searchFiles$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/searchFiles
  
  Required parameters: workspace
  
  Optional parameters: pageSize, pageToken, filter
  
  Finds the contents of a given Workspace directory by filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:searchFiles"
     #{:workspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/create
  
  Required parameters: parent
  
  Optional parameters: workspaceId
  
  Body: 
  
  {:name string}
  
  Creates a new Workspace in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workspaces"
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

(defn locations-repositories-workspaces-delete$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-getIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-queryDirectoryContents$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/queryDirectoryContents
  
  Required parameters: workspace
  
  Optional parameters: path, pageSize, pageToken
  
  Returns the contents of a given Workspace directory."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:queryDirectoryContents"
     #{:workspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-writeFile$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/writeFile
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string, :contents string}
  
  Writes to a file (inside a Workspace)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:writeFile"
     #{:workspace}
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

(defn locations-repositories-workspaces-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists Workspaces in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workspaces"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-moveFile$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/moveFile
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string, :newPath string}
  
  Moves a file (inside a Workspace) to a new location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:moveFile"
     #{:workspace}
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

(defn locations-repositories-workspaces-commit$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/commit
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:author {:name string, :emailAddress string},
   :commitMessage string,
   :paths [string]}
  
  Applies a Git commit for uncommitted files in a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:commit"
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

(defn locations-repositories-workspaces-makeDirectory$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/makeDirectory
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string}
  
  Creates a directory inside a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:makeDirectory"
     #{:workspace}
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

(defn locations-repositories-workspaces-moveDirectory$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/moveDirectory
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string, :newPath string}
  
  Moves a directory (inside a Workspace), and all of its contents, to a new location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:moveDirectory"
     #{:workspace}
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

(defn locations-repositories-workspaces-fetchFileDiff$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/fetchFileDiff
  
  Required parameters: workspace
  
  Optional parameters: path
  
  Fetches Git diff for an uncommitted file in a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:fetchFileDiff"
     #{:workspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-fetchGitAheadBehind$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/fetchGitAheadBehind
  
  Required parameters: name
  
  Optional parameters: remoteBranch
  
  Fetches Git ahead/behind against a remote branch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:fetchGitAheadBehind"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workspaces-pull$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/pull
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:remoteBranch string, :author {:name string, :emailAddress string}}
  
  Pulls Git commits from the Repository's remote into a Workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:pull"
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

(defn locations-repositories-workspaces-removeDirectory$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workspaces/removeDirectory
  
  Required parameters: workspace
  
  Optional parameters: none
  
  Body: 
  
  {:path string}
  
  Deletes a directory (inside a Workspace) and all of its contents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workspace})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+workspace}:removeDirectory"
     #{:workspace}
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

(defn locations-repositories-releaseConfigs-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/releaseConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists ReleaseConfigs in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/releaseConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-releaseConfigs-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/releaseConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single ReleaseConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-releaseConfigs-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/releaseConfigs/create
  
  Required parameters: parent
  
  Optional parameters: releaseConfigId
  
  Body: 
  
  {:name string,
   :gitCommitish string,
   :codeCompilationConfig {:defaultDatabase string,
                           :defaultSchema string,
                           :defaultLocation string,
                           :assertionSchema string,
                           :vars {},
                           :databaseSuffix string,
                           :schemaSuffix string,
                           :tablePrefix string},
   :cronSchedule string,
   :timeZone string,
   :recentScheduledReleaseRecords [{:releaseTime string,
                                    :compilationResult string,
                                    :errorStatus Status}],
   :releaseCompilationResult string,
   :disabled boolean}
  
  Creates a new ReleaseConfig in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/releaseConfigs"
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

(defn locations-repositories-releaseConfigs-patch$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/releaseConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :gitCommitish string,
   :codeCompilationConfig {:defaultDatabase string,
                           :defaultSchema string,
                           :defaultLocation string,
                           :assertionSchema string,
                           :vars {},
                           :databaseSuffix string,
                           :schemaSuffix string,
                           :tablePrefix string},
   :cronSchedule string,
   :timeZone string,
   :recentScheduledReleaseRecords [{:releaseTime string,
                                    :compilationResult string,
                                    :errorStatus Status}],
   :releaseCompilationResult string,
   :disabled boolean}
  
  Updates a single ReleaseConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-repositories-releaseConfigs-delete$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/releaseConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ReleaseConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-compilationResults-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/compilationResults/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists CompilationResults in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/compilationResults"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-compilationResults-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/compilationResults/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single CompilationResult."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-compilationResults-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/compilationResults/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :gitCommitish string,
   :workspace string,
   :releaseConfig string,
   :codeCompilationConfig {:defaultDatabase string,
                           :defaultSchema string,
                           :defaultLocation string,
                           :assertionSchema string,
                           :vars {},
                           :databaseSuffix string,
                           :schemaSuffix string,
                           :tablePrefix string},
   :resolvedGitCommitSha string,
   :dataformCoreVersion string,
   :compilationErrors [{:message string,
                        :stack string,
                        :path string,
                        :actionTarget Target}]}
  
  Creates a new CompilationResult in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/compilationResults"
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

(defn locations-repositories-compilationResults-query$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/compilationResults/query
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Returns CompilationResultActions in a given CompilationResult."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:query"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowConfigs-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists WorkflowConfigs in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workflowConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowConfigs-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single WorkflowConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowConfigs-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowConfigs/create
  
  Required parameters: parent
  
  Optional parameters: workflowConfigId
  
  Body: 
  
  {:name string,
   :releaseConfig string,
   :invocationConfig {:includedTargets [Target],
                      :includedTags [string],
                      :transitiveDependenciesIncluded boolean,
                      :transitiveDependentsIncluded boolean,
                      :fullyRefreshIncrementalTablesEnabled boolean,
                      :serviceAccount string},
   :cronSchedule string,
   :timeZone string,
   :recentScheduledExecutionRecords [{:executionTime string,
                                      :workflowInvocation string,
                                      :errorStatus Status}]}
  
  Creates a new WorkflowConfig in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workflowConfigs"
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

(defn locations-repositories-workflowConfigs-patch$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :releaseConfig string,
   :invocationConfig {:includedTargets [Target],
                      :includedTags [string],
                      :transitiveDependenciesIncluded boolean,
                      :transitiveDependentsIncluded boolean,
                      :fullyRefreshIncrementalTablesEnabled boolean,
                      :serviceAccount string},
   :cronSchedule string,
   :timeZone string,
   :recentScheduledExecutionRecords [{:executionTime string,
                                      :workflowInvocation string,
                                      :errorStatus Status}]}
  
  Updates a single WorkflowConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
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

(defn locations-repositories-workflowConfigs-delete$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single WorkflowConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowInvocations-list$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists WorkflowInvocations in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workflowInvocations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowInvocations-get$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Fetches a single WorkflowInvocation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowInvocations-create$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :compilationResult string,
   :workflowConfig string,
   :invocationConfig {:includedTargets [Target],
                      :includedTags [string],
                      :transitiveDependenciesIncluded boolean,
                      :transitiveDependentsIncluded boolean,
                      :fullyRefreshIncrementalTablesEnabled boolean,
                      :serviceAccount string},
   :state string,
   :invocationTiming {:startTime string, :endTime string},
   :resolvedCompilationResult string}
  
  Creates a new WorkflowInvocation in a given Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+parent}/workflowInvocations"
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

(defn locations-repositories-workflowInvocations-delete$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single WorkflowInvocation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-workflowInvocations-cancel$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Requests cancellation of a running WorkflowInvocation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:cancel"
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

(defn locations-repositories-workflowInvocations-query$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/repositories/workflowInvocations/query
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Returns WorkflowInvocationActions in a given WorkflowInvocation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+name}:query"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-setIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/collections/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
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

(defn locations-collections-getIamPolicy$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/collections/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-testIamPermissions$
  "https://cloud.google.com/dataform/docsapi/reference/rest/v1beta1/projects/locations/collections/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataform.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
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
