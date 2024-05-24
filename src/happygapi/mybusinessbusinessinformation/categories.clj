(ns happygapi.mybusinessbusinessinformation.categories
  "My Business Business Information API: categories.
  The My Business Business Information API provides an interface for managing business information. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/docs/reference/rest/v1/categories"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/my-business/api/reference/rest/v1/categories/list
  
  Required parameters: none
  
  Optional parameters: regionCode, languageCode, filter, pageSize, pageToken, view
  
  Returns a list of business categories. Search will match the category name but not the category ID. Search only matches the front of a category name (that is, 'food' may return 'Food Court' but not 'Fast Food Restaurant')."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/categories"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchGet$
  "https://developers.google.com/my-business/api/reference/rest/v1/categories/batchGet
  
  Required parameters: none
  
  Optional parameters: names, languageCode, regionCode, view
  
  Returns a list of business categories for the provided language and GConcept ids."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/categories:batchGet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
