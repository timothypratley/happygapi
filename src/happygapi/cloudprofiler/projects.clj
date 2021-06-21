(ns happygapi.cloudprofiler.projects
  "Stackdriver Profiler API: projects.
  Manages continuous profiling information.
  See: https://cloud.google.com/profiler/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn profiles-create$
  "https://cloud.google.com/profiler/api/reference/rest/v2/projects/profiles/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:deployment {:labels {}, :projectId string, :target string},
   :profileType [string]}
  
  CreateProfile creates a new profile resource in the online mode. The server ensures that the new profiles are created at a constant rate per deployment, so the creation request may hang for some time until the next profile session is available. The request may fail with ABORTED error if the creation is not available within ~1m, the response will indicate the duration of the backoff the client should take before attempting creating a profile again. The backoff duration is returned in google.rpc.RetryInfo extension on the response status. To a gRPC client, the extension will be return as a binary-serialized proto in the trailing metadata item named \"google.rpc.retryinfo-bin\"."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
     "v2/{+parent}/profiles"
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

(defn profiles-patch$
  "https://cloud.google.com/profiler/api/reference/rest/v2/projects/profiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:profileType string,
   :labels {},
   :duration string,
   :name string,
   :profileBytes string,
   :deployment {:labels {}, :projectId string, :target string}}
  
  UpdateProfile updates the profile bytes and labels on the profile resource created in the online mode. Updating the bytes for profiles created in the offline mode is currently not supported: the profile content must be provided at the time of the profile creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
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

(defn profiles-createOffline$
  "https://cloud.google.com/profiler/api/reference/rest/v2/projects/profiles/createOffline
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:profileType string,
   :labels {},
   :duration string,
   :name string,
   :profileBytes string,
   :deployment {:labels {}, :projectId string, :target string}}
  
  CreateOfflineProfile creates a new profile resource in the offline mode. The client provides the profile to create along with the profile bytes, the server records it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
     "v2/{+parent}/profiles:createOffline"
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
