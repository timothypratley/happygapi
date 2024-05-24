(ns happygapi.cloudasset.v1
  "Cloud Asset API: v1.
  The Cloud Asset API manages the history and inventory of Google Cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartdocs/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/searchAllResources
  
  Required parameters: scope
  
  Optional parameters: query, assetTypes, pageSize, pageToken, orderBy, readMask
  
  Searches all Google Cloud resources within the specified scope, such as a project, folder, or organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission on the desired scope, otherwise the request will be rejected."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:searchAllResources"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/exportAssets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:readTime string,
   :assetTypes [string],
   :contentType string,
   :outputConfig {:gcsDestination GcsDestination,
                  :bigqueryDestination BigQueryDestination},
   :relationshipTypes [string]}
  
  Exports assets with time and resource types to a given Cloud Storage location/BigQuery table. For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line represents a google.cloud.asset.v1.Asset in the JSON format; for BigQuery table destinations, the output table stores the fields in asset Protobuf as columns. This API implements the google.longrunning.Operation API, which allows you to keep track of the export. We recommend intervals of at least 2 seconds with exponential retry to poll the export operation result. For regular-size resource parent, the export operation usually finishes within 5 minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:exportAssets"
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

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeOrgPolicyGovernedAssets
  
  Required parameters: scope
  
  Optional parameters: constraint, filter, pageSize, pageToken
  
  Analyzes organization policies governed assets (Google Cloud resources or policies) under a scope. This RPC supports custom constraints and the following canned constraints: * constraints/ainotebooks.accessMode * constraints/ainotebooks.disableFileDownloads * constraints/ainotebooks.disableRootAccess * constraints/ainotebooks.disableTerminal * constraints/ainotebooks.environmentOptions * constraints/ainotebooks.requireAutoUpgradeSchedule * constraints/ainotebooks.restrictVpcNetworks * constraints/compute.disableGuestAttributesAccess * constraints/compute.disableInstanceDataAccessApis * constraints/compute.disableNestedVirtualization * constraints/compute.disableSerialPortAccess * constraints/compute.disableSerialPortLogging * constraints/compute.disableVpcExternalIpv6 * constraints/compute.requireOsLogin * constraints/compute.requireShieldedVm * constraints/compute.restrictLoadBalancerCreationForTypes * constraints/compute.restrictProtocolForwardingCreationForTypes * constraints/compute.restrictXpnProjectLienRemoval * constraints/compute.setNewProjectDefaultToZonalDNSOnly * constraints/compute.skipDefaultNetworkCreation * constraints/compute.trustedImageProjects * constraints/compute.vmCanIpForward * constraints/compute.vmExternalIpAccess * constraints/gcp.detailedAuditLoggingMode * constraints/gcp.resourceLocations * constraints/iam.allowedPolicyMemberDomains * constraints/iam.automaticIamGrantsForDefaultServiceAccounts * constraints/iam.disableServiceAccountCreation * constraints/iam.disableServiceAccountKeyCreation * constraints/iam.disableServiceAccountKeyUpload * constraints/iam.restrictCrossProjectServiceAccountLienRemoval * constraints/iam.serviceAccountKeyExpiryHours * constraints/resourcemanager.accessBoundaries * constraints/resourcemanager.allowedExportDestinations * constraints/sql.restrictAuthorizedNetworks * constraints/sql.restrictNoncompliantDiagnosticDataAccess * constraints/sql.restrictNoncompliantResourceCreation * constraints/sql.restrictPublicIp * constraints/storage.publicAccessPrevention * constraints/storage.restrictAuthTypes * constraints/storage.uniformBucketLevelAccess This RPC only returns either resources of types [supported by search APIs](https://cloud.google.com/asset-inventory/docs/supported-asset-types) or IAM policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:analyzeOrgPolicyGovernedAssets"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeOrgPolicies
  
  Required parameters: scope
  
  Optional parameters: constraint, filter, pageSize, pageToken
  
  Analyzes organization policies under a scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:analyzeOrgPolicies"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeIamPolicy
  
  Required parameters: scope
  
  Optional parameters: analysisQuery.options.expandResources, analysisQuery.identitySelector.identity, analysisQuery.options.analyzeServiceAccountImpersonation, analysisQuery.options.expandGroups, analysisQuery.resourceSelector.fullResourceName, executionTimeout, analysisQuery.options.outputGroupEdges, analysisQuery.accessSelector.roles, analysisQuery.accessSelector.permissions, analysisQuery.options.expandRoles, analysisQuery.conditionContext.accessTime, analysisQuery.options.outputResourceEdges, savedAnalysisQuery
  
  Analyzes IAM policies to answer which identities have what accesses on which resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:analyzeIamPolicy"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeMove
  
  Required parameters: resource
  
  Optional parameters: destinationParent, view
  
  Analyze moving a resource to a specified destination without kicking off the actual move. The analysis is best effort depending on the user's permissions of viewing different hierarchical policies and configurations. The policies and configuration are subject to change before the actual resource migration takes place."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+resource}:analyzeMove"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/batchGetAssetsHistory
  
  Required parameters: parent
  
  Optional parameters: assetNames, contentType, readTimeWindow.startTime, readTimeWindow.endTime, relationshipTypes
  
  Batch gets the update history of assets that overlap a time window. For IAM_POLICY content, this API outputs history when the asset and its attached IAM POLICY both exist. This can create gaps in the output history. Otherwise, this API outputs history with asset in both non-delete or deleted status. If a specified asset does not exist, this API returns an INVALID_ARGUMENT error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:batchGetAssetsHistory"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeOrgPolicyGovernedContainers
  
  Required parameters: scope
  
  Optional parameters: constraint, filter, pageSize, pageToken
  
  Analyzes organization policies governed containers (projects, folders or organization) under a scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:analyzeOrgPolicyGovernedContainers"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeIamPolicyLongrunning
  
  Required parameters: scope
  
  Optional parameters: none
  
  Body: 
  
  {:analysisQuery {:scope string,
                   :resourceSelector ResourceSelector,
                   :identitySelector IdentitySelector,
                   :accessSelector AccessSelector,
                   :options Options,
                   :conditionContext ConditionContext},
   :savedAnalysisQuery string,
   :outputConfig {:gcsDestination GoogleCloudAssetV1GcsDestination,
                  :bigqueryDestination GoogleCloudAssetV1BigQueryDestination}}
  
  Analyzes IAM policies asynchronously to answer which identities have what accesses on which resources, and writes the analysis results to a Google Cloud Storage or a BigQuery destination. For Cloud Storage destination, the output format is the JSON format that represents a AnalyzeIamPolicyResponse. This method implements the google.longrunning.Operation, which allows you to track the operation status. We recommend intervals of at least 2 seconds with exponential backoff retry to poll the operation result. The metadata contains the metadata for the long-running operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:analyzeIamPolicyLongrunning"
     #{:scope}
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

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/searchAllIamPolicies
  
  Required parameters: scope
  
  Optional parameters: query, pageSize, pageToken, assetTypes, orderBy
  
  Searches all IAM policies within the specified scope, such as a project, folder, or organization. The caller must be granted the `cloudasset.assets.searchAllIamPolicies` permission on the desired scope, otherwise the request will be rejected."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:scope})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+scope}:searchAllIamPolicies"
     #{:scope}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/queryAssets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:statement string,
   :jobReference string,
   :pageSize integer,
   :pageToken string,
   :timeout string,
   :readTimeWindow {:startTime string, :endTime string},
   :readTime string,
   :outputConfig {:bigqueryDestination GoogleCloudAssetV1QueryAssetsOutputConfigBigQueryDestination}}
  
  Issue a job that queries assets using a SQL statement compatible with [BigQuery SQL](https://cloud.google.com/bigquery/docs/introduction-sql). If the query execution finishes within timeout and there's no pagination, the full query results will be returned in the `QueryAssetsResponse`. Otherwise, full query results can be obtained by issuing extra requests with the `job_reference` from the a previous `QueryAssets` call. Note, the query result has approximately 10 GB limitation enforced by [BigQuery](https://cloud.google.com/bigquery/docs/best-practices-performance-output). Queries return larger results will result in errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}:queryAssets"
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
