(ns happygapi.resourcesettings.folders
  "Resource Settings API: folders.
  The Resource Settings API allows users to control and modify the behavior of their GCP resources (e.g., VM, firewall, Project, etc.) across the Cloud Resource Hierarchy.
  See: https://cloud.google.com/resource-manager/docs/resource-settings/overviewapi/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn settings-patch$
  "https://cloud.google.com/resource-manager/docs/resource-settings/overviewapi/reference/rest/v1/folders/settings/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:metadata {:description string,
              :readOnly boolean,
              :displayName string,
              :dataType string,
              :defaultValue GoogleCloudResourcesettingsV1Value},
   :etag string,
   :localValue {:enumValue GoogleCloudResourcesettingsV1ValueEnumValue,
                :durationValue string,
                :stringValue string,
                :booleanValue boolean,
                :stringSetValue GoogleCloudResourcesettingsV1ValueStringSet,
                :stringMapValue GoogleCloudResourcesettingsV1ValueStringMap},
   :effectiveValue {:enumValue GoogleCloudResourcesettingsV1ValueEnumValue,
                    :durationValue string,
                    :stringValue string,
                    :booleanValue boolean,
                    :stringSetValue GoogleCloudResourcesettingsV1ValueStringSet,
                    :stringMapValue GoogleCloudResourcesettingsV1ValueStringMap},
   :name string}
  
  Updates a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.FAILED_PRECONDITION` if the setting is flagged as read only. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the setting value. On success, the response will contain only `name`, `local_value` and `etag`. The `metadata` and `effective_value` cannot be updated through this API. Note: the supplied setting will perform a full overwrite of the `local_value` field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://resourcesettings.googleapis.com/"
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

(defn settings-list$
  "https://cloud.google.com/resource-manager/docs/resource-settings/overviewapi/reference/rest/v1/folders/settings/list
  
  Required parameters: parent
  
  Optional parameters: view, pageToken, pageSize
  
  Lists all the settings that are available on the Cloud resource `parent`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://resourcesettings.googleapis.com/"
     "v1/{+parent}/settings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn settings-get$
  "https://cloud.google.com/resource-manager/docs/resource-settings/overviewapi/reference/rest/v1/folders/settings/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Returns a specified setting. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the setting does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://resourcesettings.googleapis.com/"
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
