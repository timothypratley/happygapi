(ns happygapi.cloudcontrolspartner.organizations
  "Cloud Controls Partner API: organizations.
  Provides insights about your customers and their Assured Workloads based on your Sovereign Controls by Partners offering.
  See: https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restdocs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getPartner$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/getPartner
  
  Required parameters: name
  
  Optional parameters: none
  
  Get details of a Partner."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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

(defn locations-customers-get$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single customer"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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

(defn locations-customers-list$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists customers of a partner identified by its Google Cloud organization ID"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
     "v1/{+parent}/customers"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customers-workloads-get$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single workload"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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

(defn locations-customers-workloads-list$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists customer workloads for a given customer org id"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
     "v1/{+parent}/workloads"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customers-workloads-getEkmConnections$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/getEkmConnections
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the EKM connections associated with a workload"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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

(defn locations-customers-workloads-getPartnerPermissions$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/getPartnerPermissions
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the partner permissions granted for a workload"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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

(defn locations-customers-workloads-accessApprovalRequests-list$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/accessApprovalRequests/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists access requests associated with a workload"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
     "v1/{+parent}/accessApprovalRequests"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customers-workloads-violations-list$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/violations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, interval.startTime, interval.endTime
  
  Lists Violations for a workload Callers may also choose to read across multiple Customers or for a single customer as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of {customer} & {workload}. Format: `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
     "v1/{+parent}/violations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customers-workloads-violations-get$
  "https://cloud.google.com/sovereign-controls-by-partners/docs/sovereign-partners/reference/restapi/reference/rest/v1/organizations/locations/customers/workloads/violations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Violation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudcontrolspartner.googleapis.com/"
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
