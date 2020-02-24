(ns happygapi.cloudprivatecatalog.projects
  "Cloud Private Catalog API
  Enable cloud users to discover enterprise catalogs and products in their organizations.
  See: https://cloud.google.com/private-catalog/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn catalogs-search$
  "Required parameters: resource
  
  Search Catalog resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/catalogs:search"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-search$
  "Required parameters: resource
  
  Search Version resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/versions:search"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-search$
  "Required parameters: resource
  
  Search Product resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/products:search"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
