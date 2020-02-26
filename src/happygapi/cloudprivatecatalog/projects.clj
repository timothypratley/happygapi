(ns happygapi.cloudprivatecatalog.projects
  "Cloud Private Catalog API
  Enable cloud users to discover enterprise catalogs and products in their organizations.
  See: https://cloud.google.com/private-catalog/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "cloudprivatecatalog_schema.edn"))))

(defn catalogs-search$
  "Required parameters: resource
  
  Optional parameters: pageToken, pageSize, query
  
  Search Catalog resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: pageToken, pageSize, query
  
  Search Version resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: query, pageToken, pageSize
  
  Search Product resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
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
