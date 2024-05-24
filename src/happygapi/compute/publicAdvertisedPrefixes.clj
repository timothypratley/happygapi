(ns happygapi.compute.publicAdvertisedPrefixes
  "Compute Engine API: publicAdvertisedPrefixes.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/publicAdvertisedPrefixes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the PublicAdvertisedPrefixes for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/get
  
  Required parameters: project, publicAdvertisedPrefix
  
  Optional parameters: none
  
  Returns the specified PublicAdvertisedPrefix resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :publicAdvertisedPrefix})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}"
     #{:project :publicAdvertisedPrefix}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :dnsVerificationIp string,
   :creationTimestamp string,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :byoipApiVersion string,
   :pdpScope string,
   :status string,
   :id string,
   :kind string,
   :publicDelegatedPrefixs [{:name string,
                             :region string,
                             :project string,
                             :status string,
                             :ipRange string}],
   :sharedSecret string,
   :fingerprint string}
  
  Creates a PublicAdvertisedPrefix in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/delete
  
  Required parameters: project, publicAdvertisedPrefix
  
  Optional parameters: requestId
  
  Deletes the specified PublicAdvertisedPrefix"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :publicAdvertisedPrefix})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}"
     #{:project :publicAdvertisedPrefix}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/patch
  
  Required parameters: project, publicAdvertisedPrefix
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :dnsVerificationIp string,
   :creationTimestamp string,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :byoipApiVersion string,
   :pdpScope string,
   :status string,
   :id string,
   :kind string,
   :publicDelegatedPrefixs [{:name string,
                             :region string,
                             :project string,
                             :status string,
                             :ipRange string}],
   :sharedSecret string,
   :fingerprint string}
  
  Patches the specified Router resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:project :publicAdvertisedPrefix})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}"
     #{:project :publicAdvertisedPrefix}
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

(defn announce$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/announce
  
  Required parameters: project, publicAdvertisedPrefix
  
  Optional parameters: requestId
  
  Announces the specified PublicAdvertisedPrefix"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :publicAdvertisedPrefix})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}/announce"
     #{:project :publicAdvertisedPrefix}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn withdraw$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicAdvertisedPrefixes/withdraw
  
  Required parameters: project, publicAdvertisedPrefix
  
  Optional parameters: requestId
  
  Withdraws the specified PublicAdvertisedPrefix"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :publicAdvertisedPrefix})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicAdvertisedPrefixes/{publicAdvertisedPrefix}/withdraw"
     #{:project :publicAdvertisedPrefix}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
