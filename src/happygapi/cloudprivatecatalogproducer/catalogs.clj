(ns happygapi.cloudprivatecatalogproducer.catalogs
  "Cloud Private Catalog Producer API: catalogs.
  Enables cloud users to manage and share enterprise catalogs intheir organizations.
  See: https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns the requested Catalog resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [GoogleIamV1Binding],
            :etag string,
            :version integer,
            :auditConfigs [GoogleIamV1AuditConfig]},
   :updateMask string}
  
  Sets the IAM policy for the specified Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+resource}:setIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :description string,
   :parent string,
   :createTime string,
   :updateTime string,
   :name string}
  
  Updates a specific Catalog resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Tests the IAM permissions for the specified Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+resource}:testIamPermissions"
     #{:resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :description string,
   :parent string,
   :createTime string,
   :updateTime string,
   :name string}
  
  Creates a new Catalog resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/catalogs"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/delete
  
  Required parameters: name
  
  Optional parameters: force
  Soft deletes an existing Catalog and all resources under it.
  The catalog can only be deleted if there is no associations under it or
  DeleteCatalogRequest.force is true. The delete operation
  can be recovered by the PrivateCatalogProducer.UndeleteCatalog
  method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  Gets IAM policy for the specified Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+resource}:getIamPolicy"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn undelete$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes a deleted Catalog and all resources under it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}:undelete"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/list
  
  Required parameters: none
  
  Optional parameters: parent, pageToken, pageSize
  Lists Catalog resources that the producer has access to, within the
  scope of the parent resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/catalogs"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn associations-delete$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/associations/delete
  
  Required parameters: name
  
  Optional parameters: none
  Deletes the given Association."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn associations-get$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/associations/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns the requested Association resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn associations-list$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/associations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists all Association resources under a catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/associations"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn associations-create$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/associations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:association {:createTime string, :resource string, :name string}}
  
  Creates an Association instance under a given Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/associations"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-create$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateTime string,
   :name string,
   :assetType string,
   :displayMetadata {},
   :iconUri string,
   :createTime string}
  
  Creates a Product instance under a given Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/products"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-copy$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/copy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationProductName string}
  
  Copies a Product under another Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}:copy"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-get$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns the requested Product resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-patch$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :name string,
   :assetType string,
   :displayMetadata {},
   :iconUri string,
   :createTime string}
  
  Updates a specific Product resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-delete$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/delete
  
  Required parameters: name
  
  Optional parameters: none
  Hard deletes a Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-list$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  Lists Product resources that the producer has access to, within the
  scope of the parent catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/products"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-icons-upload$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/icons/upload
  
  Required parameters: product
  
  Optional parameters: none
  
  Body: 
  
  {:icon string}
  
  Creates an Icon instance under a given Product.
  If Product only has a default icon, a new Icon
  instance is created and associated with the given Product.
  If Product already has a non-default icon, the action creates
  a new Icon instance, associates the newly created
  Icon with the given Product and deletes the old icon."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:product})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+product}/icons:upload"
     #{:product}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-versions-delete$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/versions/delete
  
  Required parameters: name
  
  Optional parameters: none
  Hard deletes a Version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-versions-list$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  Lists Version resources that the producer has access to, within the
  scope of the parent Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/versions"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-versions-get$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/versions/get
  
  Required parameters: name
  
  Optional parameters: none
  Returns the requested Version resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-versions-patch$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/versions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:originalAsset {},
   :description string,
   :asset {},
   :createTime string,
   :updateTime string,
   :name string}
  
  Updates a specific Version resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-versions-create$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/catalogs/products/versions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:originalAsset {},
   :description string,
   :asset {},
   :createTime string,
   :updateTime string,
   :name string}
  
  Creates a Version instance under a given Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudprivatecatalogproducer.googleapis.com/"
     "v1beta1/{+parent}/versions"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
