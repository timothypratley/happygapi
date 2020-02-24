(ns happygapi.datacatalog.catalog
  "Google Cloud Data Catalog API
  A fully managed and highly scalable data discovery and metadata management service.
  
  See: https://cloud.google.com/data-catalog/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn search$
  "Required parameters: none
  
  Searches Data Catalog for multiple resources like entries, tags that
  match a query.
  
  This is a custom method
  (https://cloud.google.com/apis/design/custom_methods) and does not return
  the complete resource, only the resource identifier and high level
  fields. Clients can subsequentally call `Get` methods.
  
  Note that Data Catalog search queries do not guarantee full recall. Query
  results that match your query may not be returned, even in subsequent
  result pages. Also note that results returned (and not returned) can vary
  across repeated search queries.
  
  See [Data Catalog Search
  Syntax](/data-catalog/docs/how-to/search-reference) for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/catalog:search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
