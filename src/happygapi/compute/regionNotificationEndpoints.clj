(ns happygapi.compute.regionNotificationEndpoints
  "Compute Engine API: regionNotificationEndpoints.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionNotificationEndpoints"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNotificationEndpoints/get
  
  Required parameters: project, region, notificationEndpoint
  
  Optional parameters: none
  
  Returns the specified NotificationEndpoint resource in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:notificationEndpoint :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}"
     #{:notificationEndpoint :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNotificationEndpoints/list
  
  Required parameters: project, region
  
  Optional parameters: maxResults, pageToken, orderBy, returnPartialSuccess, filter
  
  Lists the NotificationEndpoints for a project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/notificationEndpoints"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNotificationEndpoints/delete
  
  Required parameters: notificationEndpoint, region, project
  
  Optional parameters: requestId
  
  Deletes the specified NotificationEndpoint in the given region"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:notificationEndpoint :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}"
     #{:notificationEndpoint :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNotificationEndpoints/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:region string,
   :grpcSettings {:retryDurationSec integer,
                  :payloadName string,
                  :resendInterval Duration,
                  :authority string,
                  :endpoint string},
   :description string,
   :selfLink string,
   :creationTimestamp string,
   :id string,
   :kind string,
   :name string}
  
  Create a NotificationEndpoint in the specified project in the given region using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/notificationEndpoints"
     #{:region :project}
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
