(ns happygapi.artifactregistry.projects
  "Artifact Registry API: projects.
  Store and manage build artifacts in a scalable and integrated service built on Google infrastructure.
  See: https://cloud.google.com/artifacts/docs/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getProjectSettings$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/getProjectSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the Settings for the Project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateProjectSettings$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/updateProjectSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :legacyRedirectionState string}
  
  Updates the Settings for the Project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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

(defn locations-getVpcscConfig$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/getVpcscConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the VPCSC Config for the Project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-updateVpcscConfig$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/updateVpcscConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :vpcscPolicy string}
  
  Updates the VPCSC Config for the Project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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

(defn locations-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}/locations"
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
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists repositories."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/repositories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-create$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/create
  
  Required parameters: parent
  
  Optional parameters: repositoryId
  
  Body: 
  
  {:description string,
   :labels {},
   :format string,
   :mavenConfig {:allowSnapshotOverwrites boolean,
                 :versionPolicy string},
   :satisfiesPzi boolean,
   :name string,
   :sizeBytes string,
   :mode string,
   :createTime string,
   :cleanupPolicyDryRun boolean,
   :updateTime string,
   :virtualRepositoryConfig {:upstreamPolicies [UpstreamPolicy]},
   :cleanupPolicies {},
   :dockerConfig {:immutableTags boolean},
   :satisfiesPzs boolean,
   :kmsKeyName string,
   :remoteRepositoryConfig {:description string,
                            :pythonRepository PythonRepository,
                            :npmRepository NpmRepository,
                            :aptRepository AptRepository,
                            :disableUpstreamValidation boolean,
                            :mavenRepository MavenRepository,
                            :upstreamCredentials UpstreamCredentials,
                            :dockerRepository DockerRepository,
                            :yumRepository YumRepository},
   :disallowUnspecifiedMode boolean}
  
  Creates a repository. The returned Operation will finish once the repository has been created. Its response will be the created Repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/repositories"
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

(defn locations-repositories-patch$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :format string,
   :mavenConfig {:allowSnapshotOverwrites boolean,
                 :versionPolicy string},
   :satisfiesPzi boolean,
   :name string,
   :sizeBytes string,
   :mode string,
   :createTime string,
   :cleanupPolicyDryRun boolean,
   :updateTime string,
   :virtualRepositoryConfig {:upstreamPolicies [UpstreamPolicy]},
   :cleanupPolicies {},
   :dockerConfig {:immutableTags boolean},
   :satisfiesPzs boolean,
   :kmsKeyName string,
   :remoteRepositoryConfig {:description string,
                            :pythonRepository PythonRepository,
                            :npmRepository NpmRepository,
                            :aptRepository AptRepository,
                            :disableUpstreamValidation boolean,
                            :mavenRepository MavenRepository,
                            :upstreamCredentials UpstreamCredentials,
                            :dockerRepository DockerRepository,
                            :yumRepository YumRepository},
   :disallowUnspecifiedMode boolean}
  
  Updates a repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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

(defn locations-repositories-delete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a repository and all of its contents. The returned Operation will finish once the repository has been deleted. It will not have any Operation metadata and will return a google.protobuf.Empty response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-setIamPolicy$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Updates the IAM policy for a given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-repositories-getIamPolicy$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM policy for a given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-testIamPermissions$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests if the caller has a list of permissions on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-repositories-googetArtifacts-import$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/googetArtifacts/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsSource {:uris [string], :useWildcards boolean}}
  
  Imports GooGet artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/googetArtifacts:import"
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

(defn locations-repositories-googetArtifacts-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/googetArtifacts/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Directly uploads a GooGet artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/googetArtifacts:create"
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

(defn locations-repositories-kfpArtifacts-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/kfpArtifacts/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:tags [string], :description string}
  
  Directly uploads a KFP artifact. The returned Operation will complete once the resource is uploaded. Package, Version, and File resources will be created based on the uploaded artifact. Uploaded artifacts that conflict with existing resources will be overwritten."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/kfpArtifacts:create"
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

(defn locations-repositories-dockerImages-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/dockerImages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy
  
  Lists docker images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/dockerImages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-dockerImages-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/dockerImages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a docker image."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-aptArtifacts-import$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/aptArtifacts/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsSource {:uris [string], :useWildcards boolean}}
  
  Imports Apt artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/aptArtifacts:import"
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

(defn locations-repositories-aptArtifacts-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/aptArtifacts/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Directly uploads an Apt artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/aptArtifacts:create"
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

(defn locations-repositories-npmPackages-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/npmPackages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists npm packages."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/npmPackages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-npmPackages-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/npmPackages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a npm package."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-pythonPackages-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/pythonPackages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists python packages."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/pythonPackages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-pythonPackages-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/pythonPackages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a python package."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-mavenArtifacts-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/mavenArtifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists maven artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/mavenArtifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-mavenArtifacts-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/mavenArtifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a maven artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-genericArtifacts-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/genericArtifacts/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:packageId string, :versionId string, :filename string}
  
  Directly uploads a Generic artifact. The returned operation will complete once the resources are uploaded. Package, version, and file resources are created based on the uploaded artifact. Uploaded artifacts that conflict with existing resources will raise an `ALREADY_EXISTS` error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/genericArtifacts:create"
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

(defn locations-repositories-goModules-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/goModules/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Directly uploads a Go module. The returned Operation will complete once the Go module is uploaded. Package, Version, and File resources are created based on the uploaded Go module."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/goModules:create"
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

(defn locations-repositories-files-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/files/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, orderBy
  
  Lists files."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/files"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-files-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/files/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-files-download$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/files/download
  
  Required parameters: name
  
  Optional parameters: none
  
  Download a file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-files-delete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/files/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a file and all of its content. It is only allowed on generic repositories. The returned operation will complete once the file has been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists packages."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/packages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a package."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-delete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a package and all of its versions and tags. The returned operation will complete once the package has been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-patch$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :createTime string,
   :updateTime string,
   :annotations {}}
  
  Updates a package."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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

(defn locations-repositories-packages-versions-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view, orderBy
  
  Lists versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-versions-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/versions/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a version"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-versions-delete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/versions/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a version and all of its content. The returned operation will complete once the version has been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-versions-batchDelete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/versions/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string], :validateOnly boolean}
  
  Deletes multiple versions across a repository. The returned operation will complete once the versions have been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/versions:batchDelete"
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

(defn locations-repositories-packages-tags-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/tags/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists tags."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/tags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-tags-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/tags/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-packages-tags-create$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/tags/create
  
  Required parameters: parent
  
  Optional parameters: tagId
  
  Body: 
  
  {:name string, :version string}
  
  Creates a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/tags"
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

(defn locations-repositories-packages-tags-patch$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/tags/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :version string}
  
  Updates a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
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

(defn locations-repositories-packages-tags-delete$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/packages/tags/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-yumArtifacts-import$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/yumArtifacts/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsSource {:uris [string], :useWildcards boolean}}
  
  Imports Yum (RPM) artifacts. The returned Operation will complete once the resources are imported. Package, Version, and File resources are created based on the imported artifacts. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/yumArtifacts:import"
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

(defn locations-repositories-yumArtifacts-upload$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/yumArtifacts/upload
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Directly uploads a Yum artifact. The returned Operation will complete once the resources are uploaded. Package, Version, and File resources are created based on the imported artifact. Imported artifacts that conflict with existing resources are ignored."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/yumArtifacts:create"
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
