(ns happygapi.securitycenter.organizations
  "Security Command Center API: organizations.
  Security Command Center API provides access to temporal views of assets and findings within an organization.
  See: https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getOrganizationSettings$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/getOrganizationSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the settings for an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn updateOrganizationSettings$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/updateOrganizationSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :enableAssetDiscovery boolean,
   :assetDiscoveryConfig {:inclusionMode string,
                          :projectIds [string],
                          :folderIds [string]}}
  
  Updates an organization's settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn operations-cancel$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn operations-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn operations-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/notificationConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:pubsubTopic string,
   :description string,
   :serviceAccount string,
   :streamingConfig {:filter string},
   :name string}
  
   Updates a notification config. The following update fields are allowed: description, pubsub_topic, streaming_config.filter"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/notificationConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-delete$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/notificationConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn notificationConfigs-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/notificationConfigs/create
  
  Required parameters: parent
  
  Optional parameters: configId
  
  Body: 
  
  {:pubsubTopic string,
   :description string,
   :serviceAccount string,
   :streamingConfig {:filter string},
   :name string}
  
  Creates a notification config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/notificationConfigs"
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

(defn notificationConfigs-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/notificationConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists notification configs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/notificationConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assets-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/assets/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, compareDuration, pageSize, fieldMask, readTime, pageToken, filter
  
  Lists an organization's assets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assets-runDiscovery$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/assets/runDiscovery
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Runs asset discovery. The discovery is tracked with a long-running operation. This API can only be called with limited frequency for an organization. If it is called too frequently the caller will receive a TOO_MANY_REQUESTS error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets:runDiscovery"
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

(defn assets-group$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/assets/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:readTime string,
   :filter string,
   :pageToken string,
   :groupBy string,
   :compareDuration string,
   :pageSize integer}
  
  Filters an organization's assets and groups them by their specified properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/assets:group"
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

(defn assets-updateSecurityMarks$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/assets/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: startTime, updateMask
  
  Body: 
  
  {:marks {}, :name string, :canonicalName string}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-get$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :description string,
   :name string,
   :canonicalName string}
  
  Creates a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/sources"
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

(defn sources-testIamPermissions$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has on the specified source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all sources belonging to an organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sources-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :description string,
   :name string,
   :canonicalName string}
  
  Updates a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-setIamPolicy$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string,
            :version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the access control policy on the specified Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-getIamPolicy$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy on the specified Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn sources-findings-setState$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/setState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string, :state string}
  
  Updates the state of a finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+name}:setState"
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

(defn sources-findings-list$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, readTime, filter, compareDuration, pageSize, fieldMask, pageToken
  
  Lists an organization or source's findings. To list across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sources-findings-group$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/group
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :groupBy string,
   :pageToken string,
   :filter string,
   :readTime string,
   :compareDuration string}
  
  Filters an organization or source's findings and groups them by their specified properties. To group across all sources provide a `-` as the source id. Example: /v1/organizations/{organization_id}/sources/-/findings, /v1/folders/{folder_id}/sources/-/findings, /v1/projects/{project_id}/sources/-/findings"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings:group"
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

(defn sources-findings-updateSecurityMarks$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/updateSecurityMarks
  
  Required parameters: name
  
  Optional parameters: startTime, updateMask
  
  Body: 
  
  {:marks {}, :name string, :canonicalName string}
  
  Updates security marks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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

(defn sources-findings-create$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/create
  
  Required parameters: parent
  
  Optional parameters: findingId
  
  Body: 
  
  {:category string,
   :parent string,
   :name string,
   :createTime string,
   :state string,
   :canonicalName string,
   :externalUri string,
   :resourceName string,
   :securityMarks {:marks {}, :name string, :canonicalName string},
   :sourceProperties {},
   :severity string,
   :eventTime string}
  
  Creates a finding. The corresponding source must exist for finding creation to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://securitycenter.googleapis.com/"
     "v1/{+parent}/findings"
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

(defn sources-findings-patch$
  "https://cloud.google.com/security-command-centerapi/reference/rest/v1/organizations/sources/findings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:category string,
   :parent string,
   :name string,
   :createTime string,
   :state string,
   :canonicalName string,
   :externalUri string,
   :resourceName string,
   :securityMarks {:marks {}, :name string, :canonicalName string},
   :sourceProperties {},
   :severity string,
   :eventTime string}
  
  Creates or updates a finding. The corresponding source must exist for a finding creation to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://securitycenter.googleapis.com/"
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
