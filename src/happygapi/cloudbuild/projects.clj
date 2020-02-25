(ns happygapi.cloudbuild.projects
  "Cloud Build API
  Creates and manages builds on Google Cloud Platform.
  See: https://cloud.google.com/cloud-build/docs/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudbuild_schema.edn"))))

(defn builds-retry$
  "Required parameters: projectId, id
  
  Optional parameters: none
  
  Creates a new build based on the specified build.
  
  This method creates a new build using the original build request, which may
  or may not result in an identical build.
  
  For triggered builds:
  
  * Triggered builds resolve to a precise revision; therefore a retry of a
  triggered build will result in a build that uses the same revision.
  
  For non-triggered builds that specify `RepoSource`:
  
  * If the original build built from the tip of a branch, the retried build
  will build from the tip of that branch, which may not be the same revision
  as the original build.
  * If the original build specified a commit sha or revision ID, the retried
  build will use the identical source.
  
  For builds that specify `StorageSource`:
  
  * If the original build pulled source from Google Cloud Storage without
  specifying the generation of the object, the new build will use the current
  object, which may be different from the original build source.
  * If the original build pulled source from Cloud Storage and specified the
  generation of the object, the new build will attempt to use the same
  object, which may or may not be available depending on the bucket's
  lifecycle management settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:retry"
     #{"id" "projectId"}
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

(defn builds-get$
  "Required parameters: id, projectId
  
  Optional parameters: none
  
  Returns information about a previously requested build.
  
  The `Build` that is returned includes its status (such as `SUCCESS`,
  `FAILURE`, or `WORKING`), and timing information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}"
     #{"id" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn builds-list$
  "Required parameters: projectId
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists previously requested builds.
  
  Previously requested builds may still be in-progress, or may have finished
  successfully or unsuccessfully."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn builds-create$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Starts a build with the specified configuration.
  
  This method returns a long-running `Operation`, which includes the build
  ID. Pass the build ID to `GetBuild` to determine the build status (such as
  `SUCCESS` or `FAILURE`)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds"
     #{"projectId"}
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

(defn builds-cancel$
  "Required parameters: projectId, id
  
  Optional parameters: none
  
  Cancels a build in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/builds/{id}:cancel"
     #{"id" "projectId"}
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

(defn triggers-create$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Creates a new `BuildTrigger`.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{"projectId"}
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

(defn triggers-run$
  "Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Runs a `BuildTrigger` at a particular source revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId" "triggerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}:run"
     #{"projectId" "triggerId"}
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

(defn triggers-patch$
  "Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Updates a `BuildTrigger` by its project ID and trigger ID.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId" "triggerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{"projectId" "triggerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-get$
  "Required parameters: projectId, triggerId
  
  Optional parameters: none
  
  Returns information about a `BuildTrigger`.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId" "triggerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{"projectId" "triggerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-delete$
  "Required parameters: triggerId, projectId
  
  Optional parameters: none
  
  Deletes a `BuildTrigger` by its project ID and trigger ID.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId" "triggerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers/{triggerId}"
     #{"projectId" "triggerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn triggers-list$
  "Required parameters: projectId
  
  Optional parameters: pageToken, pageSize
  
  Lists existing `BuildTrigger`s.
  
  This API is experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbuild.googleapis.com/"
     "v1/projects/{projectId}/triggers"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
