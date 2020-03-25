(ns happygapi.compute.externalVpnGateways
  "Compute Engine API: externalVpnGateways.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/delete
  
  Required parameters: externalVpnGateway, project
  
  Optional parameters: requestId
  
  Deletes the specified externalVpnGateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:externalVpnGateway :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways/{externalVpnGateway}"
     #{:externalVpnGateway :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/get
  
  Required parameters: externalVpnGateway, project
  
  Optional parameters: none
  
  Returns the specified externalVpnGateway. Get a list of available externalVpnGateways by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:externalVpnGateway :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways/{externalVpnGateway}"
     #{:externalVpnGateway :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :interfaces [{:id integer, :ipAddress string}],
   :labels {},
   :redundancyType string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :id string,
   :kind string,
   :labelFingerprint string}
  
  Creates a ExternalVpnGateway in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways"
     #{:project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of ExternalVpnGateway available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setLabels$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/setLabels
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets the labels on an ExternalVpnGateway. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways/{resource}/setLabels"
     #{:project :resource}
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

(defn testIamPermissions$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/externalVpnGateways/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/externalVpnGateways/{resource}/testIamPermissions"
     #{:project :resource}
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
