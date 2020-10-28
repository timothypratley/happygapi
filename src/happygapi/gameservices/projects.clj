(ns happygapi.gameservices.projects
  "Game Services API: projects.
  Deploy and manage infrastructure for global multiplayer gaming experiences.
  See: https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: includeUnrevealedLocations, pageSize, filter, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://gameservices.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
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
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-get$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single game server deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-setIamPolicy$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:auditConfigs [AuditConfig],
            :rules [Rule],
            :version integer,
            :iamOwned boolean,
            :etag string,
            :bindings [Binding]},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-patch$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :description string,
   :updateTime string,
   :etag string}
  
  Patches a game server deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-testIamPermissions$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/testIamPermissions
  
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
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-create$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/create
  
  Required parameters: parent
  
  Optional parameters: deploymentId
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :description string,
   :updateTime string,
   :etag string}
  
  Creates a new game server deployment in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/gameServerDeployments"
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

(defn locations-gameServerDeployments-delete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single game server deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-getIamPolicy$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-fetchDeploymentState$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/fetchDeploymentState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Retrieves information about the current state of the game server deployment. Gathers all the Agones fleets and Agones autoscalers, including fleets running an older version of the game server deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}:fetchDeploymentState"
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

(defn locations-gameServerDeployments-list$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, orderBy, pageToken
  
  Lists game server deployments in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/gameServerDeployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gameServerDeployments-previewRollout$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/previewRollout
  
  Required parameters: name
  
  Optional parameters: updateMask, previewTime
  
  Body: 
  
  {:name string,
   :updateTime string,
   :gameServerConfigOverrides [{:configVersion string,
                                :realmsSelector RealmSelector}],
   :defaultGameServerConfig string,
   :etag string,
   :createTime string}
  
  Previews the game server deployment rollout. This API does not mutate the rollout resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}/rollout:preview"
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

(defn locations-gameServerDeployments-updateRollout$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/updateRollout
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :updateTime string,
   :gameServerConfigOverrides [{:configVersion string,
                                :realmsSelector RealmSelector}],
   :defaultGameServerConfig string,
   :etag string,
   :createTime string}
  
  Patches a single game server deployment rollout. The method will not return an error if the update does not affect any existing realms. For example - if the default_game_server_config is changed but all existing realms use the override, that is valid. Similarly, if a non existing realm is explicitly called out in game_server_config_overrides field, that will also not result in an error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}/rollout"
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

(defn locations-gameServerDeployments-getRollout$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/getRollout
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details a single game server deployment rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}/rollout"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gameServerDeployments-configs-delete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/configs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single game server config. The deletion will fail if the game server config is referenced in a game server deployment rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-configs-create$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/configs/create
  
  Required parameters: parent
  
  Optional parameters: configId
  
  Body: 
  
  {:updateTime string,
   :scalingConfigs [{:name string,
                     :schedules [Schedule],
                     :selectors [LabelSelector],
                     :fleetAutoscalerSpec string}],
   :labels {},
   :fleetConfigs [{:fleetSpec string, :name string}],
   :description string,
   :name string,
   :createTime string}
  
  Creates a new game server config in a given project, location, and game server deployment. Game server configs are immutable, and are not applied until referenced in the game server deployment rollout resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/configs"
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

(defn locations-gameServerDeployments-configs-get$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/configs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single game server config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-gameServerDeployments-configs-list$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/gameServerDeployments/configs/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists game server configs in a given project, location, and game server deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/configs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-realms-get$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single realm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-delete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single realm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-previewUpdate$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/previewUpdate
  
  Required parameters: name
  
  Optional parameters: previewTime, updateMask
  
  Body: 
  
  {:updateTime string,
   :timeZone string,
   :etag string,
   :description string,
   :labels {},
   :createTime string,
   :name string}
  
  Previews patches to a single realm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}:previewUpdate"
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

(defn locations-realms-patch$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :timeZone string,
   :etag string,
   :description string,
   :labels {},
   :createTime string,
   :name string}
  
  Patches a single realm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-create$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/create
  
  Required parameters: parent
  
  Optional parameters: realmId
  
  Body: 
  
  {:updateTime string,
   :timeZone string,
   :etag string,
   :description string,
   :labels {},
   :createTime string,
   :name string}
  
  Creates a new realm in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/realms"
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

(defn locations-realms-list$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, orderBy, pageToken
  
  Lists realms in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/realms"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-realms-gameServerClusters-delete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single game server cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-gameServerClusters-previewDelete$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/previewDelete
  
  Required parameters: name
  
  Optional parameters: previewTime
  
  Previews deletion of a single game server cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}:previewDelete"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-realms-gameServerClusters-get$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single game server cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-gameServerClusters-previewCreate$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/previewCreate
  
  Required parameters: parent
  
  Optional parameters: gameServerClusterId, previewTime
  
  Body: 
  
  {:labels {},
   :etag string,
   :updateTime string,
   :name string,
   :description string,
   :connectionInfo {:namespace string,
                    :gkeClusterReference GkeClusterReference},
   :createTime string}
  
  Previews creation of a new game server cluster in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/gameServerClusters:previewCreate"
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

(defn locations-realms-gameServerClusters-previewUpdate$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/previewUpdate
  
  Required parameters: name
  
  Optional parameters: previewTime, updateMask
  
  Body: 
  
  {:labels {},
   :etag string,
   :updateTime string,
   :name string,
   :description string,
   :connectionInfo {:namespace string,
                    :gkeClusterReference GkeClusterReference},
   :createTime string}
  
  Previews updating a GameServerCluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+name}:previewUpdate"
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

(defn locations-realms-gameServerClusters-patch$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :etag string,
   :updateTime string,
   :name string,
   :description string,
   :connectionInfo {:namespace string,
                    :gkeClusterReference GkeClusterReference},
   :createTime string}
  
  Patches a single game server cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gameservices.googleapis.com/"
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

(defn locations-realms-gameServerClusters-create$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/create
  
  Required parameters: parent
  
  Optional parameters: gameServerClusterId
  
  Body: 
  
  {:labels {},
   :etag string,
   :updateTime string,
   :name string,
   :description string,
   :connectionInfo {:namespace string,
                    :gkeClusterReference GkeClusterReference},
   :createTime string}
  
  Creates a new game server cluster in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/gameServerClusters"
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

(defn locations-realms-gameServerClusters-list$
  "https://cloud.google.com/solutions/gaming/api/reference/rest/v1/projects/locations/realms/gameServerClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, filter, pageSize
  
  Lists game server clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gameservices.googleapis.com/"
     "v1/{+parent}/gameServerClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
