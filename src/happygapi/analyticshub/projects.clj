(ns happygapi.analyticshub.projects
  "Analytics Hub API: projects.
  Exchange data and analytics assets securely and efficiently.
  See: https://cloud.google.com/bigquery/docs/analytics-hub-introductiondocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-dataExchanges-get$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a data exchange."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-setIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-patch$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :primaryContact string,
   :documentation string,
   :listingCount integer,
   :icon string,
   :sharingEnvironmentConfig {:defaultExchangeConfig DefaultExchangeConfig,
                              :dcrExchangeConfig DcrExchangeConfig}}
  
  Updates an existing data exchange."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-testIamPermissions$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-create$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/create
  
  Required parameters: parent
  
  Optional parameters: dataExchangeId
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :primaryContact string,
   :documentation string,
   :listingCount integer,
   :icon string,
   :sharingEnvironmentConfig {:defaultExchangeConfig DefaultExchangeConfig,
                              :dcrExchangeConfig DcrExchangeConfig}}
  
  Creates a new data exchange."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+parent}/dataExchanges"
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

(defn locations-dataExchanges-listSubscriptions$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listSubscriptions
  
  Required parameters: resource
  
  Optional parameters: includeDeletedSubscriptions, pageSize, pageToken
  
  Lists all subscriptions on a given Data Exchange or Listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+resource}:listSubscriptions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataExchanges-delete$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing data exchange."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-getIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-dataExchanges-list$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all data exchanges in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+parent}/dataExchanges"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataExchanges-subscribe$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/subscribe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destination string, :subscription string, :subscriberContact string}
  
  Creates a Subscription to a Data Exchange. This is a long-running operation as it will create one or more linked datasets."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+name}:subscribe"
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

(defn locations-dataExchanges-listings-get$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-listings-setIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-listings-patch$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :requestAccess string,
   :publisher {:name string, :primaryContact string},
   :displayName string,
   :name string,
   :state string,
   :dataProvider {:name string, :primaryContact string},
   :restrictedExportConfig {:enabled boolean,
                            :restrictDirectTableAccess boolean,
                            :restrictQueryResult boolean},
   :icon string,
   :documentation string,
   :categories [string],
   :primaryContact string,
   :bigqueryDataset {:dataset string,
                     :selectedResources [SelectedResource],
                     :restrictedExportPolicy RestrictedExportPolicy}}
  
  Updates an existing listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-listings-testIamPermissions$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns the permissions that a caller has."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-listings-create$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/create
  
  Required parameters: parent
  
  Optional parameters: listingId
  
  Body: 
  
  {:description string,
   :requestAccess string,
   :publisher {:name string, :primaryContact string},
   :displayName string,
   :name string,
   :state string,
   :dataProvider {:name string, :primaryContact string},
   :restrictedExportConfig {:enabled boolean,
                            :restrictDirectTableAccess boolean,
                            :restrictQueryResult boolean},
   :icon string,
   :documentation string,
   :categories [string],
   :primaryContact string,
   :bigqueryDataset {:dataset string,
                     :selectedResources [SelectedResource],
                     :restrictedExportPolicy RestrictedExportPolicy}}
  
  Creates a new listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+parent}/listings"
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

(defn locations-dataExchanges-listings-listSubscriptions$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/listSubscriptions
  
  Required parameters: resource
  
  Optional parameters: includeDeletedSubscriptions, pageSize, pageToken
  
  Lists all subscriptions on a given Data Exchange or Listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+resource}:listSubscriptions"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataExchanges-listings-delete$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a listing."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-dataExchanges-listings-getIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-dataExchanges-listings-list$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all listings in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+parent}/listings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataExchanges-listings-subscribe$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/dataExchanges/listings/subscribe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationDataset {:datasetReference DestinationDatasetReference,
                        :friendlyName string,
                        :description string,
                        :labels {},
                        :location string}}
  
  Subscribes to a listing. Currently, with Analytics Hub, you can create listings that reference only BigQuery datasets. Upon subscription to a listing for a BigQuery dataset, Analytics Hub creates a linked dataset in the subscriber's project."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+name}:subscribe"
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

(defn locations-subscriptions-refresh$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/refresh
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Refreshes a Subscription to a Data Exchange. A Data Exchange can become stale when a publisher adds or removes data. This is a long-running operation as it may create many linked datasets."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+name}:refresh"
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

(defn locations-subscriptions-get$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a Subscription."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-subscriptions-list$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists all subscriptions in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+parent}/subscriptions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-subscriptions-revoke$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/revoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Revokes a given subscription."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+name}:revoke"
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

(defn locations-subscriptions-delete$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a subscription."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticshub.googleapis.com/"
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

(defn locations-subscriptions-getIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-subscriptions-setIamPolicy$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/projects/locations/subscriptions/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM policy."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticshub.googleapis.com/"
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
