(ns happygapi.run.namespaces
  "Cloud Run API: namespaces.
  Deploy and manage user provided container images that scale automatically based on HTTP traffic.
  See: https://cloud.google.com/run/api/reference/rest/v1/namespaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn routes-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/routes/list
  
  Required parameters: parent
  
  Optional parameters: fieldSelector, includeUninitialized, resourceVersion, continue, limit, watch, labelSelector
  List routes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/routes"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn routes-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/routes/get
  
  Required parameters: name
  
  Optional parameters: none
  Get information about a route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/delete
  
  Required parameters: name
  
  Optional parameters: apiVersion, propagationPolicy, kind
  Delete a revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, fieldSelector, resourceVersion, includeUninitialized, continue, limit, watch
  List revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/revisions"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/get
  
  Required parameters: name
  
  Optional parameters: none
  Get information about a revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/configurations/list
  
  Required parameters: parent
  
  Optional parameters: resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch, labelSelector
  List configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/configurations"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/configurations/get
  
  Required parameters: name
  
  Optional parameters: none
  Get information about a configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/list
  
  Required parameters: parent
  
  Optional parameters: resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch, labelSelector
  List domain mappings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/domainmappings"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/get
  
  Required parameters: name
  
  Optional parameters: none
  Get information about a domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-create$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
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
   :status {:resourceRecords [ResourceRecord],
            :mappedRouteName string,
            :conditions [GoogleCloudRunV1Condition],
            :observedGeneration integer},
   :apiVersion string,
   :spec {:forceOverride boolean,
          :routeName string,
          :certificateMode string}}
  
  Create a new domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/domainmappings"
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

(defn domainmappings-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/delete
  
  Required parameters: name
  
  Optional parameters: propagationPolicy, kind, apiVersion
  Delete a domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn authorizeddomains-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/authorizeddomains/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  List authorized domains."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/authorizeddomains"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/delete
  
  Required parameters: name
  
  Optional parameters: apiVersion, propagationPolicy, kind
  Delete a service.
  This will cause the Service to stop serving traffic and will delete the
  child entities like Routes, Configurations and Revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, fieldSelector, includeUninitialized, resourceVersion, continue, limit, watch
  List services."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/services"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/get
  
  Required parameters: name
  
  Optional parameters: none
  Get information about a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn services-create$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/create
  
  Required parameters: parent
  
  Optional parameters: none
  
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
   :status {:url string,
            :traffic [TrafficTarget],
            :latestReadyRevisionName string,
            :latestCreatedRevisionName string,
            :conditions [GoogleCloudRunV1Condition],
            :address Addressable,
            :observedGeneration integer},
   :apiVersion string,
   :spec {:traffic [TrafficTarget], :template RevisionTemplate},
   :kind string}
  
  Create a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/services"
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

(defn services-replaceService$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/replaceService
  
  Required parameters: name
  
  Optional parameters: none
  
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
   :status {:url string,
            :traffic [TrafficTarget],
            :latestReadyRevisionName string,
            :latestCreatedRevisionName string,
            :conditions [GoogleCloudRunV1Condition],
            :address Addressable,
            :observedGeneration integer},
   :apiVersion string,
   :spec {:traffic [TrafficTarget], :template RevisionTemplate},
   :kind string}
  
  Replace a service.
  
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
     "apis/serving.knative.dev/v1/{+name}"
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
