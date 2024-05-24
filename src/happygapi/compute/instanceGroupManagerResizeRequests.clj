(ns happygapi.compute.instanceGroupManagerResizeRequests
  "Compute Engine API: instanceGroupManagerResizeRequests.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/instanceGroupManagerResizeRequests"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/instanceGroupManagerResizeRequests/get
  
  Required parameters: instanceGroupManager, project, resizeRequest, zone
  
  Optional parameters: none
  
  Returns all of the details about the specified resize request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :resizeRequest :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}"
     #{:zone :resizeRequest :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/instanceGroupManagerResizeRequests/insert
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :requestedRunDuration {:seconds string, :nanos integer},
   :zone string,
   :name string,
   :selfLink string,
   :state string,
   :selfLinkWithId string,
   :status {:error {:errors [{:code string,
                              :location string,
                              :message string,
                              :errorDetails [{:errorInfo ErrorInfo,
                                              :quotaInfo QuotaExceededInfo,
                                              :help Help,
                                              :localizedMessage LocalizedMessage}]}]},
            :lastAttempt InstanceGroupManagerResizeRequestStatusLastAttempt},
   :id string,
   :kind string,
   :resizeBy integer}
  
  Creates a new resize request that starts provisioning VMs immediately or queues VM creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests"
     #{:zone :instanceGroupManager :project}
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/instanceGroupManagerResizeRequests/list
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of resize requests that are contained in the managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "https://cloud.google.com/compute/api/reference/rest/v1/instanceGroupManagerResizeRequests/cancel
  
  Required parameters: instanceGroupManager, project, resizeRequest, zone
  
  Optional parameters: requestId
  
  Cancels the specified resize request and removes it from the queue. Cancelled resize request does no longer wait for the resources to be provisioned. Cancel is only possible for requests that are accepted in the queue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :resizeRequest :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}/cancel"
     #{:zone :resizeRequest :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/instanceGroupManagerResizeRequests/delete
  
  Required parameters: instanceGroupManager, project, resizeRequest, zone
  
  Optional parameters: requestId
  
  Deletes the specified, inactive resize request. Requests that are still active cannot be deleted. Deleting request does not delete instances that were provisioned previously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :resizeRequest :instanceGroupManager :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}"
     #{:zone :resizeRequest :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
