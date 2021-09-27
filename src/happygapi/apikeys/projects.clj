(ns happygapi.apikeys.projects
  "API Keys API: projects.
  Manages the API keys associated with developer projects.
  See: https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-keys-undelete$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes an API key which was deleted within 30 days. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}:undelete"
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

(defn locations-keys-get$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the metadata for an API key. The key string of the API key isn't included in the response. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keys-list$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists the API keys owned by a project. The key string of the API key isn't included in the response. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+parent}/keys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keys-create$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/create
  
  Required parameters: parent
  
  Optional parameters: keyId
  
  Body: 
  
  {:restrictions {:iosKeyRestrictions V2IosKeyRestrictions,
                  :apiTargets [V2ApiTarget],
                  :browserKeyRestrictions V2BrowserKeyRestrictions,
                  :androidKeyRestrictions V2AndroidKeyRestrictions,
                  :serverKeyRestrictions V2ServerKeyRestrictions},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :keyString string,
   :etag string,
   :updateTime string}
  
  Creates a new API key. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+parent}/keys"
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

(defn locations-keys-delete$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes an API key. Deleted key can be retrieved within 30 days of deletion. Afterward, key will be purged from the project. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keys-getKeyString$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/getKeyString
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the key string for an API key. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}/keyString"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keys-patch$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:restrictions {:iosKeyRestrictions V2IosKeyRestrictions,
                  :apiTargets [V2ApiTarget],
                  :browserKeyRestrictions V2BrowserKeyRestrictions,
                  :androidKeyRestrictions V2AndroidKeyRestrictions,
                  :serverKeyRestrictions V2ServerKeyRestrictions},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :keyString string,
   :etag string,
   :updateTime string}
  
  Patches the modifiable fields of an API key. The key string of the API key isn't included in the response. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}"
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

(defn locations-keys-clone$
  "https://cloud.google.com/api-keys/docsapi/reference/rest/v2/projects/locations/keys/clone
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:keyId string}
  
  Clones the existing key's restriction and display name to a new API key. The service account must have the `apikeys.keys.get` and `apikeys.keys.create` permissions in the project. NOTE: Key is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apikeys.googleapis.com/"
     "v2/{+name}:clone"
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
