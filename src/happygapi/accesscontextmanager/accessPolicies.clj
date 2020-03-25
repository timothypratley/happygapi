(ns happygapi.accesscontextmanager.accessPolicies
  "Access Context Manager API: accessPolicies.
  An API for setting attribute based access control to requests to GCP services.
  See: https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an AccessPolicy by resource
  name. The longrunning Operation will have a successful status once the
  AccessPolicy
  has been removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/list
  
  Required parameters: none
  
  Optional parameters: parent, pageToken, pageSize
  
  List all AccessPolicies under a
  container."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an AccessPolicy by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:title string,
   :etag string,
   :parent string,
   :createTime string,
   :updateTime string,
   :name string}
  
  Update an AccessPolicy. The
  longrunning Operation from this RPC will have a successful status once the
  changes to the AccessPolicy have propagated
  to long-lasting storage. Syntactic and basic semantic errors will be
  returned in `metadata` as a BadRequest proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:title string,
   :etag string,
   :parent string,
   :createTime string,
   :updateTime string,
   :name string}
  
  Create an `AccessPolicy`. Fails if this organization already has a
  `AccessPolicy`. The longrunning Operation will have a successful status
  once the `AccessPolicy` has propagated to long-lasting storage.
  Syntactic and basic semantic errors will be returned in `metadata` as a
  BadRequest proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/accessPolicies"
     #{}
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

(defn servicePerimeters-commit$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/commit
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:commit"
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

(defn servicePerimeters-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a Service Perimeter by resource
  name. The longrunning operation from this RPC will have a successful status
  once the Service Perimeter has been
  removed from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all Service Perimeters for an
  access policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn servicePerimeters-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :name string,
   :createTime string,
   :title string,
   :updateTime string,
   :spec {:resources [string],
          :accessLevels [string],
          :restrictedServices [string],
          :vpcAccessibleServices VpcAccessibleServices},
   :useExplicitDryRunSpec boolean,
   :status {:resources [string],
            :accessLevels [string],
            :restrictedServices [string],
            :vpcAccessibleServices VpcAccessibleServices},
   :perimeterType string}
  
  Create a Service Perimeter. The
  longrunning operation from this RPC will have a successful status once the
  Service Perimeter has
  propagated to long-lasting storage. Service Perimeters containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters"
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

(defn servicePerimeters-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a Service Perimeter by resource
  name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :name string,
   :createTime string,
   :title string,
   :updateTime string,
   :spec {:resources [string],
          :accessLevels [string],
          :restrictedServices [string],
          :vpcAccessibleServices VpcAccessibleServices},
   :useExplicitDryRunSpec boolean,
   :status {:resources [string],
            :accessLevels [string],
            :restrictedServices [string],
            :vpcAccessibleServices VpcAccessibleServices},
   :perimeterType string}
  
  Update a Service Perimeter. The
  longrunning operation from this RPC will have a successful status once the
  changes to the Service Perimeter have
  propagated to long-lasting storage. Service Perimeter containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn servicePerimeters-replaceAll$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/servicePerimeters/replaceAll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :servicePerimeters [{:description string,
                        :name string,
                        :createTime string,
                        :title string,
                        :updateTime string,
                        :spec ServicePerimeterConfig,
                        :useExplicitDryRunSpec boolean,
                        :status ServicePerimeterConfig,
                        :perimeterType string}]}
  
  Replace all existing Service Perimeters in an
  Access Policy
  with the Service Perimeters provided.
  This is done atomically. The longrunning operation from this
  RPC will have a successful status once all replacements have propagated to
  long-lasting storage. Replacements containing errors will result in an
  error response for the first error encountered. Replacement will be
  cancelled on error, existing Service Perimeters will not be
  affected. Operation.response field will contain
  ReplaceServicePerimetersResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/servicePerimeters:replaceAll"
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

(defn accessLevels-replaceAll$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/replaceAll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :accessLevels [{:createTime string,
                   :updateTime string,
                   :name string,
                   :basic BasicLevel,
                   :custom CustomLevel,
                   :title string,
                   :description string}]}
  
  Replace all existing Access Levels in an Access
  Policy with
  the Access Levels provided. This
  is done atomically. The longrunning operation from this RPC will have a
  successful status once all replacements have propagated to long-lasting
  storage. Replacements containing errors will result in an error response
  for the first error encountered.  Replacement will be cancelled on error,
  existing Access Levels will not be
  affected. Operation.response field will contain
  ReplaceAccessLevelsResponse. Removing Access Levels contained in existing
  Service Perimeters will result in
  error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels:replaceAll"
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

(defn accessLevels-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an Access Level by resource
  name. The longrunning operation from this RPC will have a successful status
  once the Access Level has been removed
  from long-lasting storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, accessLevelFormat
  
  List all Access Levels for an access
  policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accessLevels-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createTime string,
   :updateTime string,
   :name string,
   :basic {:conditions [Condition], :combiningFunction string},
   :custom {:expr Expr},
   :title string,
   :description string}
  
  Create an Access Level. The longrunning
  operation from this RPC will have a successful status once the Access
  Level has
  propagated to long-lasting storage. Access Levels containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/accessLevels"
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

(defn accessLevels-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:createTime string,
   :updateTime string,
   :name string,
   :basic {:conditions [Condition], :combiningFunction string},
   :custom {:expr Expr},
   :title string,
   :description string}
  
  Update an Access Level. The longrunning
  operation from this RPC will have a successful status once the changes to
  the Access Level have propagated
  to long-lasting storage. Access Levels containing
  errors will result in an error response for the first error encountered."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn accessLevels-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/accessPolicies/accessLevels/get
  
  Required parameters: name
  
  Optional parameters: accessLevelFormat
  
  Get an Access Level by resource
  name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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
