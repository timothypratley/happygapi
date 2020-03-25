(ns happygapi.compute.images
  "Compute Engine API: images.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/get
  
  Required parameters: image, project
  
  Optional parameters: none
  
  Returns the specified image. Gets a list of available images by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :image})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{image}"
     #{:project :image}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/setIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:condition Expr, :members [string], :role string}],
   :etag string,
   :policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :iamOwned boolean,
            :rules [Rule],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{resource}/setIamPolicy"
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

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/insert
  
  Required parameters: project
  
  Optional parameters: forceCreate, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :sourceSnapshotEncryptionKey {:kmsKeyName string,
                                 :kmsKeyServiceAccount string,
                                 :rawKey string,
                                 :sha256 string},
   :guestOsFeatures [{:type string}],
   :family string,
   :sourceImage string,
   :sourceDiskId string,
   :creationTimestamp string,
   :sourceImageEncryptionKey {:kmsKeyName string,
                              :kmsKeyServiceAccount string,
                              :rawKey string,
                              :sha256 string},
   :imageEncryptionKey {:kmsKeyName string,
                        :kmsKeyServiceAccount string,
                        :rawKey string,
                        :sha256 string},
   :name string,
   :sourceDisk string,
   :sourceImageId string,
   :licenses [string],
   :selfLink string,
   :sourceSnapshot string,
   :sourceDiskEncryptionKey {:kmsKeyName string,
                             :kmsKeyServiceAccount string,
                             :rawKey string,
                             :sha256 string},
   :status string,
   :deprecated {:deleted string,
                :deprecated string,
                :obsolete string,
                :replacement string,
                :state string},
   :id string,
   :kind string,
   :sourceSnapshotId string,
   :rawDisk {:containerType string,
             :sha1Checksum string,
             :source string},
   :sourceType string,
   :diskSizeGb string,
   :licenseCodes [string],
   :storageLocations [string],
   :shieldedInstanceInitialState {:dbs [FileContentBuffer],
                                  :dbxs [FileContentBuffer],
                                  :keks [FileContentBuffer],
                                  :pk FileContentBuffer},
   :archiveSizeBytes string,
   :labelFingerprint string}
  
  Creates an image in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images"
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

(defn getFromFamily$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/getFromFamily
  
  Required parameters: family, project
  
  Optional parameters: none
  
  Returns the latest image that is part of an image family and is not deprecated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:family :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/family/{family}"
     #{:family :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/testIamPermissions
  
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
     "{project}/global/images/{resource}/testIamPermissions"
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

(defn setLabels$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/setLabels
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets the labels on an image. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{resource}/setLabels"
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

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/delete
  
  Required parameters: image, project
  
  Optional parameters: requestId
  
  Deletes the specified image."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :image})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{image}"
     #{:project :image}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{resource}/getIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of custom images available to the specified project. Custom images are images you create that belong to your project. This method does not get any images that belong to other projects, including publicly-available images, like Debian 8. If you want to get a list of publicly-available images, use this method to make a request to the respective image project, such as debian-cloud or windows-cloud."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deprecate$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/images/deprecate
  
  Required parameters: image, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:deleted string,
   :deprecated string,
   :obsolete string,
   :replacement string,
   :state string}
  
  Sets the deprecation status of an image.
  
  If an empty request body is given, clears the deprecation status instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :image})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/images/{image}/deprecate"
     #{:project :image}
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
