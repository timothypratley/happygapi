(ns happygapi.cloudasset.v1
  "Cloud Asset API: v1.
  The cloud asset API manages the history and inventory of cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/searchAllResources
  
  Required parameters: scope
  
  Optional parameters: query, assetTypes, pageToken, pageSize, orderBy, readMask
  
  Searches all Cloud resources within the specified scope, such as a project, folder, or organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission on the desired scope, otherwise the request will be rejected."
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/batchGetAssetsHistory
  
  Required parameters: parent
  
  Optional parameters: readTimeWindow.endTime, readTimeWindow.startTime, contentType, relationshipTypes, assetNames
  
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/searchAllIamPolicies
  
  Required parameters: scope
  
  Optional parameters: orderBy, assetTypes, pageToken, pageSize, query
  
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeIamPolicy
  
  Required parameters: scope
  
  Optional parameters: analysisQuery.options.expandResources, analysisQuery.identitySelector.identity, analysisQuery.options.analyzeServiceAccountImpersonation, analysisQuery.options.expandGroups, analysisQuery.resourceSelector.fullResourceName, executionTimeout, analysisQuery.options.outputGroupEdges, analysisQuery.accessSelector.roles, analysisQuery.accessSelector.permissions, analysisQuery.options.expandRoles, analysisQuery.conditionContext.accessTime, analysisQuery.options.outputResourceEdges
  
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeIamPolicyLongrunning
  
  Required parameters: scope
  
  Optional parameters: none
  
  Body: 
  
  {:outputConfig {:bigqueryDestination GoogleCloudAssetV1BigQueryDestination,
                  :gcsDestination GoogleCloudAssetV1GcsDestination},
   :analysisQuery {:accessSelector AccessSelector,
                   :options Options,
                   :conditionContext ConditionContext,
                   :identitySelector IdentitySelector,
                   :resourceSelector ResourceSelector,
                   :scope string}}
  
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/exportAssets
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:contentType string,
   :outputConfig {:gcsDestination GcsDestination,
                  :bigqueryDestination BigQueryDestination},
   :readTime string,
   :assetTypes [string],
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/analyzeMove
  
  Required parameters: resource
  
  Optional parameters: view, destinationParent
  
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
