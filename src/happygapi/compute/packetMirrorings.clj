(ns happygapi.compute.packetMirrorings
  "Compute Engine API: packetMirrorings.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of packetMirrorings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/packetMirrorings"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/delete
  
  Required parameters: packetMirroring, project, region
  
  Optional parameters: requestId
  
  Deletes the specified PacketMirroring resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packetMirroring :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings/{packetMirroring}"
     #{:packetMirroring :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/get
  
  Required parameters: packetMirroring, project, region
  
  Optional parameters: none
  
  Returns the specified PacketMirroring resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packetMirroring :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings/{packetMirroring}"
     #{:packetMirroring :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :enable string,
   :creationTimestamp string,
   :mirroredResources {:instances [PacketMirroringMirroredResourceInfoInstanceInfo],
                       :subnetworks [PacketMirroringMirroredResourceInfoSubnetInfo],
                       :tags [string]},
   :name string,
   :selfLink string,
   :region string,
   :filter {:IPProtocols [string], :cidrRanges [string]},
   :priority integer,
   :id string,
   :kind string,
   :network {:canonicalUrl string, :url string},
   :collectorIlb {:canonicalUrl string, :url string}}
  
  Creates a PacketMirroring resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings"
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

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of PacketMirroring resources available to the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/patch
  
  Required parameters: packetMirroring, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :enable string,
   :creationTimestamp string,
   :mirroredResources {:instances [PacketMirroringMirroredResourceInfoInstanceInfo],
                       :subnetworks [PacketMirroringMirroredResourceInfoSubnetInfo],
                       :tags [string]},
   :name string,
   :selfLink string,
   :region string,
   :filter {:IPProtocols [string], :cidrRanges [string]},
   :priority integer,
   :id string,
   :kind string,
   :network {:canonicalUrl string, :url string},
   :collectorIlb {:canonicalUrl string, :url string}}
  
  Patches the specified PacketMirroring resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packetMirroring :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings/{packetMirroring}"
     #{:packetMirroring :region :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/packetMirrorings/testIamPermissions
  
  Required parameters: project, region, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/packetMirrorings/{resource}/testIamPermissions"
     #{:region :project :resource}
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
