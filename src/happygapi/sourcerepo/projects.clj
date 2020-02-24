(ns happygapi.sourcerepo.projects
  "Cloud Source Repositories API
  Accesses source code repositories hosted by Google.
  See: https://cloud.google.com/source-repositories/docs/apis"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn updateConfig$
  "Required parameters: name
  
  Updates the Cloud Source Repositories configuration of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/config"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getConfig$
  "Required parameters: name
  
  Returns the Cloud Source Repositories configuration of the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/config"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn repos-get$
  "Required parameters: name
  
  Returns information about a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn repos-patch$
  "Required parameters: name
  
  Updates information about a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn repos-create$
  "Required parameters: parent
  
  Creates a repo in the given project with the given name.
  
  If the named repository already exists, `CreateRepo` returns
  `ALREADY_EXISTS`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+parent}/repos"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn repos-delete$
  "Required parameters: name
  
  Deletes a repo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sourcerepo.googleapis.com/"
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

(defn repos-sync$
  "Required parameters: name
  
  Synchronize a connected repo.
  
  The response contains SyncRepoMetadata in the metadata field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}:sync"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn repos-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn repos-list$
  "Required parameters: name
  
  Returns all repos belonging to a project. The sizes of the repos are
  not set by ListRepos.  To get the size of a repo, use GetRepo."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/source.full_control"
            "https://www.googleapis.com/auth/source.read_only"
            "https://www.googleapis.com/auth/source.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sourcerepo.googleapis.com/"
     "v1/{+name}/repos"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
