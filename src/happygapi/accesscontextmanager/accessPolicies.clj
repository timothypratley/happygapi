(ns happygapi.accesscontextmanager.accessPolicies
  "Access Context Manager API
  An API for setting attribute based access control to requests to GCP services.
  See: https://cloud.google.com/access-context-manager/docs/reference/rest/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "accesscontextmanager_schema.edn"))))

(defn delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete an AccessPolicy by resource
  name. The longrunning Operation will have a successful status once the
  AccessPolicy
  has been removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn list$
  "Required parameters: none
  
  Optional parameters: parent, pageToken, pageSize
  
  List all AccessPolicies under a
  container."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Get an AccessPolicy by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Update an AccessPolicy. The
  longrunning Operation from this RPC will have a successful status once the
  changes to the AccessPolicy have propagated
  to long-lasting storage. Syntactic and basic semantic errors will be
  returned in `metadata` as a BadRequest proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Create an `AccessPolicy`. Fails if this organization already has a
  `AccessPolicy`. The longrunning Operation will have a successful status
  once the `AccessPolicy` has propagated to long-lasting storage.
  Syntactic and basic semantic errors will be returned in `metadata` as a
  BadRequest proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
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

(defn servicePerimeters-replaceAll$
  "Required parameters: parent
  
  Optional parameters: none
  
  Replace all existing Service Perimeters in an
  Access Policy
  with the Service Perimeters provided.
  This is done within one transaction. The longrunning operation from this
  RPC will have a successful status once all replacements have propagated to
  long-lasting storage. Replacements containing errors will result in an
  error response for the first error encountered and the transaction will be
  cancelled. Operation.response field will contain
  ReplaceServicePerimetersResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:replaceAll"
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

(defn servicePerimeters-commit$
  "Required parameters: parent
  
  Optional parameters: none
  
  Commit the dry-run spec for all the Service Perimeters in an
  Access Policy.
  A commit operation on a Service Perimeter involves copying its `spec` field
  to that Service Perimeter's `status` field. Only Service Perimeters with
  `use_explicit_dry_run_spec` field set to true are affected by a commit
  operation. The longrunning operation from this RPC will have a successful
  status once the dry-run specs for all the Service Perimeters have been
  committed. If a commit fails, it will cause the longrunning operation to
  return an error response and the entire commit operation will be cancelled.
  When successful, Operation.response field will contain
  CommitServicePerimetersResponse. The `dry_run` and the `spec` fields will
  be cleared after a successful commit operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:commit"
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

(defn servicePerimeters-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete an Service Perimeter by resource
  name. The longrunning operation from this RPC will have a successful status
  once the Service Perimeter has been
  removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all Service Perimeters for an
  access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn servicePerimeters-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Create an Service Perimeter. The
  longrunning operation from this RPC will have a successful status once the
  Service Perimeter has
  propagated to long-lasting storage. Service Perimeters containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
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

(defn servicePerimeters-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Update an Service Perimeter. The
  longrunning operation from this RPC will have a successful status once the
  changes to the Service Perimeter have
  propagated to long-lasting storage. Service Perimeter containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Get an Service Perimeter by resource
  name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-get$
  "Required parameters: name
  
  Optional parameters: accessLevelFormat
  
  Get an Access Level by resource
  name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Update an Access Level. The longrunning
  operation from this RPC will have a successful status once the changes to
  the Access Level have propagated
  to long-lasting storage. Access Levels containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-replaceAll$
  "Required parameters: parent
  
  Optional parameters: none
  
  Replace all existing Access Levels in an Access
  Policy with
  the Access Levels provided. This
  is done within one transaction. The longrunning operation from this RPC
  will have a successful status once all replacements have propagated to
  long-lasting storage. Replacements containing errors will result in an
  error response for the first error encountered and the transaction will be
  cancelled. Operation.response field will contain
  ReplaceAccessLevelsResponse. Removing Access Levels contained in existing
  Service Perimeters will result in
  error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels:replaceAll"
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

(defn accessLevels-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete an Access Level by resource
  name. The longrunning operation from this RPC will have a successful status
  once the Access Level has been removed
  from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, accessLevelFormat
  
  List all Access Levels for an access
  policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accessLevels-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Create an Access Level. The longrunning
  operation from this RPC will have a successful status once the Access
  Level has
  propagated to long-lasting storage. Access Levels containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
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
