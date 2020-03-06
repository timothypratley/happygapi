(ns happygapi.cloudprivatecatalog.projects
  "Cloud Private Catalog API: projects.
  Enable cloud users to discover enterprise catalogs and products in their organizations.
  See: https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn catalogs-search$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/projects/catalogs/search
  
  Required parameters: resource
  
  Optional parameters: pageToken, pageSize, query
  Search Catalog resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/catalogs:search"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn versions-search$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/projects/versions/search
  
  Required parameters: resource
  
  Optional parameters: pageToken, pageSize, query
  Search Version resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/versions:search"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-search$
  "https://cloud.google.com/private-catalog/api/reference/rest/v1beta1/projects/products/search
  
  Required parameters: resource
  
  Optional parameters: pageToken, pageSize, query
  Search Product resources that consumers have access to, within the
  scope of the consumer cloud resource hierarchy context."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudprivatecatalog.googleapis.com/"
     "v1beta1/{+resource}/products:search"
     #{:resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
