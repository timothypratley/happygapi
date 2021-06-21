(ns happygapi.compute.sslCertificates
  "Compute Engine API: sslCertificates.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates/delete
  
  Required parameters: project, sslCertificate
  
  Optional parameters: requestId
  
  Deletes the specified SslCertificate resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sslCertificate :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/sslCertificates/{sslCertificate}"
     #{:sslCertificate :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :selfManaged {:privateKey string, :certificate string},
   :privateKey string,
   :selfLink string,
   :type string,
   :region string,
   :certificate string,
   :subjectAlternativeNames [string],
   :id string,
   :kind string,
   :managed {:status string, :domains [string], :domainStatus {}},
   :expireTime string}
  
  Creates a SslCertificate resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/sslCertificates"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates/list
  
  Required parameters: project
  
  Optional parameters: pageToken, filter, returnPartialSuccess, orderBy, maxResults
  
  Retrieves the list of SslCertificate resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/sslCertificates"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates/aggregatedList
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, filter, orderBy, includeAllScopes, returnPartialSuccess
  
  Retrieves the list of all SslCertificate resources, regional and global, available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/sslCertificates"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/sslCertificates/get
  
  Required parameters: sslCertificate, project
  
  Optional parameters: none
  
  Returns the specified SslCertificate resource. Gets a list of available SSL certificates by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sslCertificate :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/sslCertificates/{sslCertificate}"
     #{:sslCertificate :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
