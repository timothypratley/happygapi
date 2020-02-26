(ns happygapi.vision.projects
  "Cloud Vision API
  Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
  See: https://cloud.google.com/vision/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "vision_schema.edn"))))

(defn files-asyncBatchAnnotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run asynchronous image detection and annotation for a list of generic
  files, such as PDF files, which may contain multiple pages and multiple
  images per page. Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/files:asyncBatchAnnotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn files-annotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Service that performs image detection and annotation for a batch of files.
  Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported.
  
  This service will extract at most 5 (customers can specify which 5 in
  AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
  file provided and perform detection and annotation for each image
  extracted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/files:annotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn images-annotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run image detection and annotation for a batch of images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/images:annotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn images-asyncBatchAnnotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run asynchronous image detection and annotation for a list of images.
  
  Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
  
  This service will write image annotation outputs to json files in customer
  GCS bucket, each json file containing BatchAnnotateImagesResponse proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/images:asyncBatchAnnotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-productSets-create$
  "Required parameters: parent
  
  Optional parameters: productSetId
  
  Creates and returns a new ProductSet resource.
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if display_name is missing, or is longer than
    4096 characters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/productSets"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-productSets-removeProduct$
  "Required parameters: name
  
  Optional parameters: none
  
  Removes a Product from the specified ProductSet."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}:removeProduct"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-productSets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information associated with a ProductSet.
  
  Possible errors:
  
  * Returns NOT_FOUND if the ProductSet does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-productSets-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Makes changes to a ProductSet resource.
  Only display_name can be updated currently.
  
  Possible errors:
  
  * Returns NOT_FOUND if the ProductSet does not exist.
  * Returns INVALID_ARGUMENT if display_name is present in update_mask but
    missing from the request or longer than 4096 characters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-productSets-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes a ProductSet. Products and ReferenceImages in the
  ProductSet are not deleted.
  
  The actual image files are not deleted from Google Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-productSets-import$
  "Required parameters: parent
  
  Optional parameters: none
  
  Asynchronous API that imports a list of reference images to specified
  product sets based on a list of image information.
  
  The google.longrunning.Operation API can be used to keep track of the
  progress and results of the request.
  `Operation.metadata` contains `BatchOperationMetadata`. (progress)
  `Operation.response` contains `ImportProductSetsResponse`. (results)
  
  The input source of this method is a csv file on Google Cloud Storage.
  For the format of the csv file please see
  ImportProductSetsGcsSource.csv_file_uri."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/productSets:import"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-productSets-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists ProductSets in an unspecified order.
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if page_size is greater than 100, or less
    than 1."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/productSets"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-productSets-addProduct$
  "Required parameters: name
  
  Optional parameters: none
  
  Adds a Product to the specified ProductSet. If the Product is already
  present, no change is made.
  
  One Product can be added to at most 100 ProductSets.
  
  Possible errors:
  
  * Returns NOT_FOUND if the Product or the ProductSet doesn't exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}:addProduct"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-productSets-products-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
  Lists the Products in a ProductSet, in an unspecified order. If the
  ProductSet does not exist, the products field of the response will be
  empty.
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}/products"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-images-asyncBatchAnnotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run asynchronous image detection and annotation for a list of images.
  
  Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
  
  This service will write image annotation outputs to json files in customer
  GCS bucket, each json file containing BatchAnnotateImagesResponse proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/images:asyncBatchAnnotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-images-annotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run image detection and annotation for a batch of images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/images:annotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-create$
  "Required parameters: parent
  
  Optional parameters: productId
  
  Creates and returns a new product resource.
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if display_name is missing or longer than 4096
    characters.
  * Returns INVALID_ARGUMENT if description is longer than 4096 characters.
  * Returns INVALID_ARGUMENT if product_category is missing or invalid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/products"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-products-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information associated with a Product.
  
  Possible errors:
  
  * Returns NOT_FOUND if the Product does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Makes changes to a Product resource.
  Only the `display_name`, `description`, and `labels` fields can be updated
  right now.
  
  If labels are updated, the change will not be reflected in queries until
  the next index time.
  
  Possible errors:
  
  * Returns NOT_FOUND if the Product does not exist.
  * Returns INVALID_ARGUMENT if display_name is present in update_mask but is
    missing from the request or longer than 4096 characters.
  * Returns INVALID_ARGUMENT if description is present in update_mask but is
    longer than 4096 characters.
  * Returns INVALID_ARGUMENT if product_category is present in update_mask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-purge$
  "Required parameters: parent
  
  Optional parameters: none
  
  Asynchronous API to delete all Products in a ProductSet or all Products
  that are in no ProductSet.
  
  If a Product is a member of the specified ProductSet in addition to other
  ProductSets, the Product will still be deleted.
  
  It is recommended to not delete the specified ProductSet until after this
  operation has completed. It is also recommended to not add any of the
  Products involved in the batch delete to a new ProductSet while this
  operation is running because those Products may still end up deleted.
  
  It's not possible to undo the PurgeProducts operation. Therefore, it is
  recommended to keep the csv files used in ImportProductSets (if that was
  how you originally built the Product Set) before starting PurgeProducts, in
  case you need to re-import the data after deletion.
  
  If the plan is to purge all of the Products from a ProductSet and then
  re-use the empty ProductSet to re-import new Products into the empty
  ProductSet, you must wait until the PurgeProducts operation has finished
  for that ProductSet.
  
  The google.longrunning.Operation API can be used to keep track of the
  progress and results of the request.
  `Operation.metadata` contains `BatchOperationMetadata`. (progress)"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/products:purge"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-products-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes a product and its reference images.
  
  Metadata of the product and all its images will be deleted right away, but
  search queries against ProductSets containing the product may still work
  until all related caches are refreshed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists products in an unspecified order.
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if page_size is greater than 100 or less than 1."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/products"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-referenceImages-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists reference images.
  
  Possible errors:
  
  * Returns NOT_FOUND if the parent product does not exist.
  * Returns INVALID_ARGUMENT if the page_size is greater than 100, or less
    than 1."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/referenceImages"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-referenceImages-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information associated with a ReferenceImage.
  
  Possible errors:
  
  * Returns NOT_FOUND if the specified image does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-products-referenceImages-create$
  "Required parameters: parent
  
  Optional parameters: referenceImageId
  
  Creates and returns a new ReferenceImage resource.
  
  The `bounding_poly` field is optional. If `bounding_poly` is not specified,
  the system will try to detect regions of interest in the image that are
  compatible with the product_category on the parent product. If it is
  specified, detection is ALWAYS skipped. The system converts polygons into
  non-rotated rectangles.
  
  Note that the pipeline will resize the image if the image resolution is too
  large to process (above 50MP).
  
  Possible errors:
  
  * Returns INVALID_ARGUMENT if the image_uri is missing or longer than 4096
    characters.
  * Returns INVALID_ARGUMENT if the product does not exist.
  * Returns INVALID_ARGUMENT if bounding_poly is not provided, and nothing
    compatible with the parent product's product_category is detected.
  * Returns INVALID_ARGUMENT if bounding_poly contains more than 10 polygons."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/referenceImages"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-products-referenceImages-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Permanently deletes a reference image.
  
  The image metadata will be deleted right away, but search queries
  against ProductSets containing the image may still work until all related
  caches are refreshed.
  
  The actual image files are not deleted from Google Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-files-asyncBatchAnnotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Run asynchronous image detection and annotation for a list of generic
  files, such as PDF files, which may contain multiple pages and multiple
  images per page. Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/files:asyncBatchAnnotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn locations-files-annotate$
  "Required parameters: parent
  
  Optional parameters: none
  
  Service that performs image detection and annotation for a batch of files.
  Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported.
  
  This service will extract at most 5 (customers can specify which 5 in
  AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
  file provided and perform detection and annotation for each image
  extracted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/{+parent}/files:annotate"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
