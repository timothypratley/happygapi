(ns happygapi.compute.firewalls
  "Compute Engine API: firewalls.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/firewalls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of firewall rules available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/get
  
  Required parameters: firewall, project
  
  Optional parameters: none
  
  Returns the specified firewall."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewall})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls/{firewall}"
     #{:project :firewall}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :disabled boolean,
   :creationTimestamp string,
   :name string,
   :destinationRanges [string],
   :selfLink string,
   :targetTags [string],
   :sourceTags [string],
   :priority integer,
   :id string,
   :kind string,
   :denied [{:IPProtocol string, :ports [string]}],
   :sourceServiceAccounts [string],
   :targetServiceAccounts [string],
   :network string,
   :logConfig {:enable boolean, :metadata string},
   :direction string,
   :sourceRanges [string],
   :allowed [{:IPProtocol string, :ports [string]}]}
  
  Creates a firewall rule in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls"
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/delete
  
  Required parameters: firewall, project
  
  Optional parameters: requestId
  
  Deletes the specified firewall."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewall})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls/{firewall}"
     #{:project :firewall}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/update
  
  Required parameters: firewall, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :disabled boolean,
   :creationTimestamp string,
   :name string,
   :destinationRanges [string],
   :selfLink string,
   :targetTags [string],
   :sourceTags [string],
   :priority integer,
   :id string,
   :kind string,
   :denied [{:IPProtocol string, :ports [string]}],
   :sourceServiceAccounts [string],
   :targetServiceAccounts [string],
   :network string,
   :logConfig {:enable boolean, :metadata string},
   :direction string,
   :sourceRanges [string],
   :allowed [{:IPProtocol string, :ports [string]}]}
  
  Updates the specified firewall rule with the data included in the request. Note that all fields will be updated if using PUT, even fields that are not specified. To update individual fields, please use PATCH instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewall})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls/{firewall}"
     #{:project :firewall}
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/firewalls/patch
  
  Required parameters: firewall, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :disabled boolean,
   :creationTimestamp string,
   :name string,
   :destinationRanges [string],
   :selfLink string,
   :targetTags [string],
   :sourceTags [string],
   :priority integer,
   :id string,
   :kind string,
   :denied [{:IPProtocol string, :ports [string]}],
   :sourceServiceAccounts [string],
   :targetServiceAccounts [string],
   :network string,
   :logConfig {:enable boolean, :metadata string},
   :direction string,
   :sourceRanges [string],
   :allowed [{:IPProtocol string, :ports [string]}]}
  
  Updates the specified firewall rule with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewall})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewalls/{firewall}"
     #{:project :firewall}
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
