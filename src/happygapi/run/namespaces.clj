(ns happygapi.run.namespaces
  "Cloud Run Admin API: namespaces.
  Deploy and manage user provided container images that scale automatically based on incoming requests. The Cloud Run Admin API follows the Knative Serving API specification.
  See: https://cloud.google.com/run/api/reference/rest/v1/namespaces"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn revisions-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, continue, limit, watch, resourceVersion, fieldSelector, includeUninitialized
  
  List revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/revisions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get information about a revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revisions-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/revisions/delete
  
  Required parameters: name
  
  Optional parameters: dryRun, apiVersion, kind, propagationPolicy
  
  Delete a revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizeddomains-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/authorizeddomains/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List authorized domains."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/authorizeddomains"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-create$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/create
  
  Required parameters: parent
  
  Optional parameters: dryRun
  
  Body: 
  
  {:apiVersion string,
   :status {:mappedRouteName string,
            :url string,
            :resourceRecords [ResourceRecord],
            :observedGeneration integer,
            :conditions [GoogleCloudRunV1Condition]},
   :kind string,
   :spec {:routeName string,
          :forceOverride boolean,
          :certificateMode string},
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
              :generateName string}}
  
  Create a new domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/domainmappings"
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

(defn domainmappings-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get information about a domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/delete
  
  Required parameters: name
  
  Optional parameters: dryRun, propagationPolicy, kind, apiVersion
  
  Delete a domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainmappings-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/domainmappings/list
  
  Required parameters: parent
  
  Optional parameters: limit, continue, fieldSelector, labelSelector, includeUninitialized, watch, resourceVersion
  
  List domain mappings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/domains.cloudrun.com/v1/{+parent}/domainmappings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-replaceService$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/replaceService
  
  Required parameters: name
  
  Optional parameters: dryRun
  
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
   :apiVersion string,
   :kind string,
   :spec {:traffic [TrafficTarget], :template RevisionTemplate},
   :status {:latestReadyRevisionName string,
            :url string,
            :conditions [GoogleCloudRunV1Condition],
            :address Addressable,
            :observedGeneration integer,
            :traffic [TrafficTarget],
            :latestCreatedRevisionName string}}
  
  Replace a service. Only the spec and metadata labels and annotations are modifiable. After the Update request, Cloud Run will work to make the 'status' match the requested 'spec'. May provide metadata.resourceVersion to enforce update from last read for optimistic concurrency control."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
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

(defn services-create$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/create
  
  Required parameters: parent
  
  Optional parameters: dryRun
  
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
   :apiVersion string,
   :kind string,
   :spec {:traffic [TrafficTarget], :template RevisionTemplate},
   :status {:latestReadyRevisionName string,
            :url string,
            :conditions [GoogleCloudRunV1Condition],
            :address Addressable,
            :observedGeneration integer,
            :traffic [TrafficTarget],
            :latestCreatedRevisionName string}}
  
  Create a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/services"
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

(defn services-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/list
  
  Required parameters: parent
  
  Optional parameters: fieldSelector, watch, limit, resourceVersion, continue, labelSelector, includeUninitialized
  
  List services."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/delete
  
  Required parameters: name
  
  Optional parameters: apiVersion, dryRun, propagationPolicy, kind
  
  Delete a service. This will cause the Service to stop serving traffic and will delete the child entities like Routes, Configurations and Revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get information about a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/configurations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get information about a configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn configurations-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/configurations/list
  
  Required parameters: parent
  
  Optional parameters: watch, includeUninitialized, limit, fieldSelector, resourceVersion, labelSelector, continue
  
  List configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/configurations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn routes-list$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/routes/list
  
  Required parameters: parent
  
  Optional parameters: watch, limit, labelSelector, continue, includeUninitialized, fieldSelector, resourceVersion
  
  List routes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+parent}/routes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn routes-get$
  "https://cloud.google.com/run/api/reference/rest/v1/namespaces/routes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get information about a route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "apis/serving.knative.dev/v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
