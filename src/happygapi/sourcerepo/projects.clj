(ns happygapi.sourcerepo.projects
  "Cloud Source Repositories API: projects.
  Accesses source code repositories hosted by Google.
  See: https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn updateConfig$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/updateConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectConfig {:pubsubConfigs {},
                   :enablePrivateKeyCheck boolean,
                   :name string},
   :updateMask string}
  
  Updates the Cloud Source Repositories configuration of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/config"
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

(defn getConfig$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the Cloud Source Repositories configuration of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/config"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn repos-get$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-setIamPolicy$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [AuditConfig],
            :etag string,
            :version integer,
            :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn repos-patch$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:repo {:url string,
          :mirrorConfig MirrorConfig,
          :pubsubConfigs {},
          :size string,
          :name string},
   :updateMask string}
  
  Updates information about a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-testIamPermissions$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn repos-create$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:url string,
   :mirrorConfig {:url string, :webhookId string, :deployKeyId string},
   :pubsubConfigs {},
   :size string,
   :name string}
  
  Creates a repo in the given project with the given name. If the named repository already exists, `CreateRepo` returns `ALREADY_EXISTS`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+parent}/repos"
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

(defn repos-delete$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-sync$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/sync
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Synchronize a connected repo. The response contains SyncRepoMetadata in the metadata field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}:sync"
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

(defn repos-getIamPolicy$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn repos-list$
  "https://cloud.google.com/source-repositories/docs/apisapi/reference/rest/v1/projects/repos/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Returns all repos belonging to a project. The sizes of the repos are not set by ListRepos. To get the size of a repo, use GetRepo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/repos"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
