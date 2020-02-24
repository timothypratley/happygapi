(ns happygapi.manufacturers.accounts
  "Manufacturer Center API
  Public API for managing Manufacturer Center related data.
  See: https://developers.google.com/manufacturers/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn products-list$
  "Required parameters: parent
  
  Lists all the products in a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
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

(defn products-get$
  "Required parameters: name,parent
  
  Gets the product from a Manufacturer Center account, including product
  issues.
  
  A recently updated product takes around 15 minutes to process. Changes are
  only visible after it has been processed. While some issues may be
  available once the product has been processed, other issues may take days
  to appear."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{"parent" "name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-update$
  "Required parameters: parent,name
  
  Inserts or updates the attributes of the product in a Manufacturer Center
  account.
  
  Creates a product with the provided attributes. If the product already
  exists, then all attributes are replaced with the new ones. The checks at
  upload time are minimal. All required attributes need to be present for a
  product to be valid. Issues may show up later after the API has accepted a
  new upload for a product and it is possible to overwrite an existing valid
  product with an invalid product. To detect this, you should retrieve the
  product and check it for issues once the new version is available.
  
  Uploaded attributes first need to be processed before they can be
  retrieved. Until then, new products will be unavailable, and retrieval
  of previously uploaded products will return the original state of the
  product."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{"parent" "name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-delete$
  "Required parameters: parent,name
  
  Deletes the product from a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent" "name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{"parent" "name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
