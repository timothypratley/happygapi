(ns happygapi.datacatalog.catalog
  "Google Cloud Data Catalog API: catalog.
  A fully managed and highly scalable data discovery and metadata management service. 
  See: https://cloud.google.com/data-catalog/docs/api/reference/rest/v1beta1/catalog"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1beta1/catalog/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :orderBy string,
   :pageToken string,
   :query string,
   :scope {:includeOrgIds [string],
           :restrictedLocations [string],
           :includeGcpPublicDatasets boolean,
           :includeProjectIds [string]}}
  
  Searches Data Catalog for multiple resources like entries, tags that match a query. This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not return the complete resource, only the resource identifier and high level fields. Clients can subsequentally call `Get` methods. Note that Data Catalog search queries do not guarantee full recall. Query results that match your query may not be returned, even in subsequent result pages. Also note that results returned (and not returned) can vary across repeated search queries. See [Data Catalog Search Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/catalog:search"
     #{}
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
