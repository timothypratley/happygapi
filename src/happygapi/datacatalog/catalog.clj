(ns happygapi.datacatalog.catalog
  "Google Cloud Data Catalog API: catalog.
  A fully managed and highly scalable data discovery and metadata management service. 
  See: https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/catalog"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/catalog/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:orderBy string,
   :query string,
   :pageSize integer,
   :pageToken string,
   :scope {:includeProjectIds [string],
           :restrictedLocations [string],
           :includeOrgIds [string],
           :includeGcpPublicDatasets boolean}}
  
  Searches Data Catalog for multiple resources like entries and tags that match a query. This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't return all information on a resource, only its ID and high level fields. To get more information, you can subsequently call specific get methods. Note: Data Catalog search queries don't guarantee full recall. Results that match your query might not be returned, even in subsequent result pages. Additionally, returned (and not returned) results can vary if you repeat search queries. For more information, see [Data Catalog search syntax] (https://cloud.google.com/data-catalog/docs/how-to/search-reference)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/catalog:search"
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
