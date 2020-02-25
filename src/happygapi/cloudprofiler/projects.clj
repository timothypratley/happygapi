(ns happygapi.cloudprofiler.projects
  "Stackdriver Profiler API
  Manages continuous profiling information.
  See: https://cloud.google.com/profiler/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudprofiler_schema.edn"))))

(defn profiles-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  UpdateProfile updates the profile bytes and labels on the profile resource
  created in the online mode. Updating the bytes for profiles created in the
  offline mode is currently not supported: the profile content must be
  provided at the time of the profile creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn profiles-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  CreateProfile creates a new profile resource in the online mode.
  
  The server ensures that the new profiles are created at a constant rate per
  deployment, so the creation request may hang for some time until the next
  profile session is available.
  
  The request may fail with ABORTED error if the creation is not available
  within ~1m, the response will indicate the duration of the backoff the
  client should take before attempting creating a profile again. The backoff
  duration is returned in google.rpc.RetryInfo extension on the response
  status. To a gRPC client, the extension will be return as a
  binary-serialized proto in the trailing metadata item named
  \"google.rpc.retryinfo-bin\"."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
     "v2/{+parent}/profiles"
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

(defn profiles-createOffline$
  "Required parameters: parent
  
  Optional parameters: none
  
  CreateOfflineProfile creates a new profile resource in the offline mode.
  The client provides the profile to create along with the profile bytes, the
  server records it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprofiler.googleapis.com/"
     "v2/{+parent}/profiles:createOffline"
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
