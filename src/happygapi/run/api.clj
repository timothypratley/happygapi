(ns happygapi.run.api
  "Cloud Run API: api.
  Deploy and manage user provided container images that scale automatically based on HTTP traffic.
  See: https://cloud.google.com/run/api/reference/rest/v1/api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn v1-namespaces-get$
  "https://cloud.google.com/run/api/reference/rest/v1/api/v1/namespaces/get
  
  Required parameters: name
  
  Optional parameters: none
  Rpc to get information about a namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn v1-namespaces-patch$
  "https://cloud.google.com/run/api/reference/rest/v1/api/v1/namespaces/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:metadata {:labels {},
              :clusterName string,
              :generation integer,
              :ownerReferences [OwnerReference],
              :creationTimestamp string,
              :uid string,
              :name string,
              :resourceVersion string,
              :selfLink string,
              :deletionTimestamp string,
              :finalizers [string],
              :deletionGracePeriodSeconds integer,
              :annotations {},
              :namespace string,
              :generateName string},
   :status {:phase string},
   :spec {:finalizers [string]}}
  
  Rpc to update a namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
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

(defn v1-namespaces-secrets-get$
  "https://cloud.google.com/run/api/reference/rest/v1/api/v1/namespaces/secrets/get
  
  Required parameters: name
  
  Optional parameters: none
  Rpc to get information about a secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn v1-namespaces-secrets-replaceSecret$
  "https://cloud.google.com/run/api/reference/rest/v1/api/v1/namespaces/secrets/replaceSecret
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:data {},
   :stringData {},
   :metadata {:labels {},
              :clusterName string,
              :generation integer,
              :ownerReferences [OwnerReference],
              :creationTimestamp string,
              :uid string,
              :name string,
              :resourceVersion string,
              :selfLink string,
              :deletionTimestamp string,
              :finalizers [string],
              :deletionGracePeriodSeconds integer,
              :annotations {},
              :namespace string,
              :generateName string},
   :type string}
  
  Rpc to replace a secret.
  
  Only the spec and metadata labels and annotations are modifiable. After
  the Update request, Cloud Run will work to make the 'status'
  match the requested 'spec'.
  
  May provide metadata.resourceVersion to enforce update from last read for
  optimistic concurrency control."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+name}"
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

(defn v1-namespaces-secrets-create$
  "https://cloud.google.com/run/api/reference/rest/v1/api/v1/namespaces/secrets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:data {},
   :stringData {},
   :metadata {:labels {},
              :clusterName string,
              :generation integer,
              :ownerReferences [OwnerReference],
              :creationTimestamp string,
              :uid string,
              :name string,
              :resourceVersion string,
              :selfLink string,
              :deletionTimestamp string,
              :finalizers [string],
              :deletionGracePeriodSeconds integer,
              :annotations {},
              :namespace string,
              :generateName string},
   :type string}
  
  Creates a new secret."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "api/v1/{+parent}/secrets"
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
