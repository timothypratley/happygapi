(ns happygapi.securitycenter.organizations
  "Cloud Security Command Center API: organizations.
  Cloud Security Command Center API provides access to temporal views of assets and findings within an organization.
  See: https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getOrganizationSettings$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/getOrganizationSettings
  
  Required parameters: name
  
  Optional parameters: none
  Gets the settings for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateOrganizationSettings$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/updateOrganizationSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:assetDiscoveryConfig {:inclusionMode string, :projectIds [string]},
   :enableAssetDiscovery boolean,
   :name string}
  
  Updates an organization's settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn assets-runDiscovery$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/assets/runDiscovery
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Runs asset discovery. The discovery is tracked with a long-running
  operation.
  
  This API can only be called with limited frequency for an organization. If
  it is called too frequently the caller will receive a TOO_MANY_REQUESTS
  error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets:runDiscovery"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn assets-updateSecurityMarks$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/assets/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: updateMask, startTime
  
  Body: 
  
  {:name string, :marks {}}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn assets-group$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/assets/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:readTime string,
   :compareDuration string,
   :groupBy string,
   :filter string,
   :pageToken string,
   :pageSize integer}
  
  Filters an organization's assets and  groups them by their specified
  properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets:group"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn assets-list$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/assets/list
  
  Required parameters: parent
  
  Optional parameters: readTime, orderBy, compareDuration, filter, pageToken, fieldMask, pageSize
  Lists an organization's assets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-list$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists all sources belonging to an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-create$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :displayName string, :description string}
  
  Creates a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-setIamPolicy$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:version integer,
            :auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string}}
  
  Sets the access control policy on the specified Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-getIamPolicy$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy on the specified Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-get$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-patch$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :displayName string, :description string}
  
  Updates a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-testIamPermissions$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-list$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/list
  
  Required parameters: parent
  
  Optional parameters: readTime, orderBy, compareDuration, filter, pageToken, fieldMask, pageSize
  Lists an organization or source's findings.
  
  To list across all sources provide a `-` as the source id.
  Example: /v1/organizations/{organization_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-create$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/create
  
  Required parameters: parent
  
  Optional parameters: findingId
  
  Body: 
  
  {:category string,
   :parent string,
   :name string,
   :createTime string,
   :state string,
   :externalUri string,
   :resourceName string,
   :securityMarks {:name string, :marks {}},
   :sourceProperties {},
   :eventTime string}
  
  Creates a finding. The corresponding source must exist for finding creation
  to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-group$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string,
   :pageSize integer,
   :readTime string,
   :compareDuration string,
   :groupBy string,
   :filter string}
  
  Filters an organization or source's findings and  groups them by their
  specified properties.
  
  To group across all sources provide a `-` as the source id.
  Example: /v1/organizations/{organization_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings:group"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-patch$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:category string,
   :parent string,
   :name string,
   :createTime string,
   :state string,
   :externalUri string,
   :resourceName string,
   :securityMarks {:name string, :marks {}},
   :sourceProperties {},
   :eventTime string}
  
  Creates or updates a finding. The corresponding source must exist for a
  finding creation to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-setState$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/setState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string, :state string}
  
  Updates the state of a finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:setState"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-updateSecurityMarks$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/sources/findings/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: startTime, updateMask
  
  Body: 
  
  {:name string, :marks {}}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-delete$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://console.cloud.google.com/apis/api/securitycenter.googleapis.com/overviewapi/reference/rest/v1/organizations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
