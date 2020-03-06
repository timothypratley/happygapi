(ns happygapi.run.projects
  "Cloud Run API: projects.
  Deploy and manage user provided container images that scale automatically based on HTTP traffic.
  See: https://cloud.google.com/run/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-routes-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/routes/list
  
  Required parameters: parent
  
  Optional parameters: limit, watch, labelSelector, fieldSelector, includeUninitialized, resourceVersion, continue
  List routes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+parent}/routes"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-routes-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/routes/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-revisions-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/revisions/list
  
  Required parameters: parent
  
  Optional parameters: resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch, labelSelector
  List revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+parent}/revisions"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-revisions-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/revisions/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-revisions-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/revisions/delete
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-configurations-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/configurations/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch
  List configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+parent}/configurations"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-configurations-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/configurations/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-domainmappings-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/domainmappings/delete
  
  Required parameters: name
  
  Optional parameters: apiVersion, propagationPolicy, kind
  Delete a domain mapping."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-domainmappings-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/domainmappings/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch
  List domain mappings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+parent}/domainmappings"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-domainmappings-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/domainmappings/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-domainmappings-create$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/domainmappings/create
  
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
     "v1/{+parent}/domainmappings"
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

(defn locations-secrets-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/secrets/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-secrets-replaceSecret$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/secrets/replaceSecret
  
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
     "v1/{+name}"
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

(defn locations-secrets-create$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/secrets/create
  
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
     "v1/{+parent}/secrets"
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

(defn locations-authorizeddomains-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/authorizeddomains/list
  
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
     "v1/{+parent}/authorizeddomains"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/namespaces/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-namespaces-patch$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/namespaces/patch
  
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
     "v1/{+name}"
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

(defn locations-services-getIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Get the IAM Access Control policy currently in effect for the given
  Cloud Run service. This result does not include any inherited policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-get$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/get
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-testIamPermissions$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified Project.
  
  There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-services-replaceService$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/replaceService
  
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
     "v1/{+name}"
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

(defn locations-services-delete$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/delete
  
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
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-list$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/list
  
  Required parameters: parent
  
  Optional parameters: labelSelector, resourceVersion, includeUninitialized, fieldSelector, continue, limit, watch
  List services."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+parent}/services"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-create$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/create
  
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
     "v1/{+parent}/services"
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

(defn locations-services-setIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v1/projects/locations/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding],
            :etag string,
            :version integer,
            :auditConfigs [AuditConfig]},
   :updateMask string}
  
  Sets the IAM Access control policy for the specified Service. Overwrites
  any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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
