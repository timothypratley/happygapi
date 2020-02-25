(ns happygapi.run.api
  "Cloud Run API
  Deploy and manage user provided container images that scale automatically based on HTTP traffic.
  See: https://cloud.google.com/run/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "run_schema.edn"))))

(defn v1-namespaces-secrets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Rpc to get information about a secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn v1-namespaces-secrets-replaceSecret$
  "Required parameters: name
  
  Optional parameters: none
  
  Rpc to replace a secret.
  
  Only the spec and metadata labels and annotations are modifiable. After
  the Update request, Cloud Run will work to make the 'status'
  match the requested 'spec'.
  
  May provide metadata.resourceVersion to enforce update from last read for
  optimistic concurrency control."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn v1-namespaces-secrets-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+parent}/secrets"
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
