(ns happygapi.tpu.projects
  "Cloud TPU API: projects.
  TPU API provides customers with access to Google TPU technology.
  See: https://cloud.google.com/tpu/docs/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-generateServiceIdentity$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/generateServiceIdentity
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates the Cloud TPU service identity for the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}:generateServiceIdentity"
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

(defn locations-operations-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nodes-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists nodes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/nodes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nodes-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nodes-create$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/create
  
  Required parameters: parent
  
  Optional parameters: nodeId
  
  Body: 
  
  {:description string,
   :serviceAccount {:email string, :scope [string]},
   :tags [string],
   :labels {},
   :queuedResource string,
   :acceleratorType string,
   :shieldedInstanceConfig {:enableSecureBoot boolean},
   :schedulingConfig {:preemptible boolean,
                      :reserved boolean,
                      :spot boolean},
   :name string,
   :symptoms [{:createTime string,
               :symptomType string,
               :details string,
               :workerId string}],
   :healthDescription string,
   :createTime string,
   :state string,
   :networkConfig {:network string,
                   :subnetwork string,
                   :enableExternalIps boolean,
                   :canIpForward boolean,
                   :queueCount integer},
   :dataDisks [{:sourceDisk string, :mode string}],
   :multisliceNode boolean,
   :acceleratorConfig {:type string, :topology string},
   :id string,
   :runtimeVersion string,
   :networkEndpoints [{:ipAddress string,
                       :port integer,
                       :accessConfig AccessConfig}],
   :health string,
   :apiVersion string,
   :metadata {},
   :cidrBlock string}
  
  Creates a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/nodes"
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

(defn locations-nodes-delete$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-nodes-stop$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a node. This operation is only available with single TPU nodes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}:stop"
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

(defn locations-nodes-start$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}:start"
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

(defn locations-nodes-patch$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :serviceAccount {:email string, :scope [string]},
   :tags [string],
   :labels {},
   :queuedResource string,
   :acceleratorType string,
   :shieldedInstanceConfig {:enableSecureBoot boolean},
   :schedulingConfig {:preemptible boolean,
                      :reserved boolean,
                      :spot boolean},
   :name string,
   :symptoms [{:createTime string,
               :symptomType string,
               :details string,
               :workerId string}],
   :healthDescription string,
   :createTime string,
   :state string,
   :networkConfig {:network string,
                   :subnetwork string,
                   :enableExternalIps boolean,
                   :canIpForward boolean,
                   :queueCount integer},
   :dataDisks [{:sourceDisk string, :mode string}],
   :multisliceNode boolean,
   :acceleratorConfig {:type string, :topology string},
   :id string,
   :runtimeVersion string,
   :networkEndpoints [{:ipAddress string,
                       :port integer,
                       :accessConfig AccessConfig}],
   :health string,
   :apiVersion string,
   :metadata {},
   :cidrBlock string}
  
  Updates the configurations of a node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
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

(defn locations-nodes-getGuestAttributes$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/nodes/getGuestAttributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:queryPath string, :workerIds [string]}
  
  Retrieves the guest attributes for the node."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}:getGuestAttributes"
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

(defn locations-queuedResources-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/queuedResources/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists queued resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/queuedResources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queuedResources-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/queuedResources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a queued resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queuedResources-create$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/queuedResources/create
  
  Required parameters: parent
  
  Optional parameters: queuedResourceId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :tpu {:nodeSpec [NodeSpec]},
   :spot {},
   :guaranteed {:minDuration string},
   :queueingPolicy {:validUntilDuration string,
                    :validUntilTime string,
                    :validAfterDuration string,
                    :validAfterTime string,
                    :validInterval Interval},
   :state {:activeData ActiveData,
           :failedData FailedData,
           :suspendingData SuspendingData,
           :acceptedData AcceptedData,
           :deletingData DeletingData,
           :state string,
           :provisioningData ProvisioningData,
           :stateInitiator string,
           :creatingData CreatingData,
           :suspendedData SuspendedData},
   :reservationName string}
  
  Creates a QueuedResource TPU instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/queuedResources"
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

(defn locations-queuedResources-delete$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/queuedResources/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a QueuedResource TPU instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queuedResources-reset$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/queuedResources/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets a QueuedResource TPU instance"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}:reset"
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

(defn locations-acceleratorTypes-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/acceleratorTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists accelerator types supported by this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/acceleratorTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-acceleratorTypes-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/acceleratorTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets AcceleratorType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-runtimeVersions-list$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/runtimeVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists runtime versions supported by this API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+parent}/runtimeVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-runtimeVersions-get$
  "https://cloud.google.com/tpu/api/reference/rest/v2/projects/locations/runtimeVersions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a runtime version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://tpu.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
