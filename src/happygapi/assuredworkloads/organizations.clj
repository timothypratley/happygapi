(ns happygapi.assuredworkloads.organizations
  "Assured Workloads API: organizations.
  
  See: https://cloud.google.com/learnmoreurldocs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-get$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloads-get$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets Assured Workload associated with a CRM Node"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-patch$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:provisionedResourcesParent string,
   :compliantButDisallowedServices [string],
   :labels {},
   :kmsSettings {:nextRotationTime string, :rotationPeriod string},
   :partnerPermissions {:dataLogsViewer boolean,
                        :assuredWorkloadsMonitoring boolean,
                        :serviceAccessApprover boolean},
   :billingAccount string,
   :complianceStatus {:acknowledgedViolationCount integer,
                      :activeResourceViolationCount integer,
                      :activeViolationCount integer,
                      :acknowledgedResourceViolationCount integer},
   :partner string,
   :resourceMonitoringEnabled boolean,
   :displayName string,
   :name string,
   :createTime string,
   :ekmProvisioningResponse {:ekmProvisioningState string,
                             :ekmProvisioningErrorDomain string,
                             :ekmProvisioningErrorMapping string},
   :etag string,
   :violationNotificationsEnabled boolean,
   :complianceRegime string,
   :saaEnrollmentResponse {:setupErrors [string], :setupStatus string},
   :resourceSettings [{:displayName string,
                       :resourceType string,
                       :resourceId string}],
   :kajEnrollmentState string,
   :enableSovereignControls boolean,
   :resources [{:resourceId string, :resourceType string}]}
  
  Updates an existing workload. Currently allows updating of workload display_name and labels. For force updates don't set etag field in the Workload. Only one update operation per workload can be in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-analyzeWorkloadMove$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/analyzeWorkloadMove
  
  Required parameters: target
  
  Optional parameters: pageSize, project, assetTypes, pageToken
  
  Analyzes a hypothetical move of a source resource to a target workload to surface compliance risks. The analysis is best effort and is not guaranteed to be exhaustive."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:target})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+target}:analyzeWorkloadMove"
     #{:target}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloads-enableResourceMonitoring$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/enableResourceMonitoring
  
  Required parameters: name
  
  Optional parameters: none
  
  Enable resource violation monitoring for a workload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+name}:enableResourceMonitoring"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloads-create$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/create
  
  Required parameters: parent
  
  Optional parameters: externalId
  
  Body: 
  
  {:provisionedResourcesParent string,
   :compliantButDisallowedServices [string],
   :labels {},
   :kmsSettings {:nextRotationTime string, :rotationPeriod string},
   :partnerPermissions {:dataLogsViewer boolean,
                        :assuredWorkloadsMonitoring boolean,
                        :serviceAccessApprover boolean},
   :billingAccount string,
   :complianceStatus {:acknowledgedViolationCount integer,
                      :activeResourceViolationCount integer,
                      :activeViolationCount integer,
                      :acknowledgedResourceViolationCount integer},
   :partner string,
   :resourceMonitoringEnabled boolean,
   :displayName string,
   :name string,
   :createTime string,
   :ekmProvisioningResponse {:ekmProvisioningState string,
                             :ekmProvisioningErrorDomain string,
                             :ekmProvisioningErrorMapping string},
   :etag string,
   :violationNotificationsEnabled boolean,
   :complianceRegime string,
   :saaEnrollmentResponse {:setupErrors [string], :setupStatus string},
   :resourceSettings [{:displayName string,
                       :resourceType string,
                       :resourceId string}],
   :kajEnrollmentState string,
   :enableSovereignControls boolean,
   :resources [{:resourceId string, :resourceType string}]}
  
  Creates Assured Workload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+parent}/workloads"
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

(defn locations-workloads-restrictAllowedResources$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/restrictAllowedResources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:restrictionType string}
  
  Restrict the list of resources allowed in the Workload environment. The current list of allowed products can be found at https://cloud.google.com/assured-workloads/docs/supported-products In addition to assuredworkloads.workload.update permission, the user should also have orgpolicy.policy.set permission on the folder resource to use this functionality."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+name}:restrictAllowedResources"
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

(defn locations-workloads-delete$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes the workload. Make sure that workload's direct children are already in a deleted state, otherwise the request will fail with a FAILED_PRECONDITION error. In addition to assuredworkloads.workload.delete permission, the user should also have orgpolicy.policy.set permission on the deleted folder to remove Assured Workloads OrgPolicies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-list$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists Assured Workloads under a CRM Node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-mutatePartnerPermissions$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/mutatePartnerPermissions
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:partnerPermissions {:dataLogsViewer boolean,
                        :assuredWorkloadsMonitoring boolean,
                        :serviceAccessApprover boolean},
   :updateMask string,
   :etag string}
  
  Update the permissions settings for an existing partner workload. For force updates don't set etag field in the Workload. Only one update operation per workload can be in progress."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+name}:mutatePartnerPermissions"
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

(defn locations-workloads-violations-acknowledge$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/violations/acknowledge
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:comment string,
   :nonCompliantOrgPolicy string,
   :acknowledgeType string}
  
  Acknowledges an existing violation. By acknowledging a violation, users acknowledge the existence of a compliance violation in their workload and decide to ignore it due to a valid business justification. Acknowledgement is a permanent operation and it cannot be reverted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
     "v1/{+name}:acknowledge"
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

(defn locations-workloads-violations-list$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/violations/list
  
  Required parameters: parent
  
  Optional parameters: interval.endTime, filter, pageToken, interval.startTime, pageSize
  
  Lists the Violations in the AssuredWorkload Environment. Callers may also choose to read across multiple Workloads as per [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash character) as a wildcard character instead of workload-id in the parent. Format `organizations/{org_id}/locations/{location}/workloads/-`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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

(defn locations-workloads-violations-get$
  "https://cloud.google.com/learnmoreurlapi/reference/rest/v1/organizations/locations/workloads/violations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves Assured Workload Violation based on ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://assuredworkloads.googleapis.com/"
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
