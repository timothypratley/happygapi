(ns happygapi.searchads360.customers
  "Search Ads 360 Reporting API: customers.
  The Search Ads 360 API allows developers to automate downloading reports from Search Ads 360.
  See: https://developers.google.com/search-ads/reportingdocs/reference/rest/v0/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listAccessibleCustomers$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/customers/listAccessibleCustomers
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns resource names of customers directly accessible by the user authenticating the call. List of thrown errors: [AuthenticationError]() [AuthorizationError]() [HeaderError]() [InternalError]() [QuotaError]() [RequestError]()"
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchads360.googleapis.com/"
     "v0/customers:listAccessibleCustomers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customColumns-get$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/customers/customColumns/get
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Returns the requested custom column in full detail."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchads360.googleapis.com/"
     "v0/{+resourceName}"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customColumns-list$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/customers/customColumns/list
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Returns all the custom columns associated with the customer in full detail."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchads360.googleapis.com/"
     "v0/customers/{+customerId}/customColumns"
     #{:customerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchAds360-search$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/customers/searchAds360/search
  
  Required parameters: customerId
  
  Optional parameters: none
  
  Body: 
  
  {:query string,
   :pageToken string,
   :pageSize integer,
   :validateOnly boolean,
   :returnTotalResultsCount boolean,
   :summaryRowSetting string}
  
  Returns all rows that match the search query. List of thrown errors: [AuthenticationError]() [AuthorizationError]() [HeaderError]() [InternalError]() [QueryError]() [QuotaError]() [RequestError]()"
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchads360.googleapis.com/"
     "v0/customers/{+customerId}/searchAds360:search"
     #{:customerId}
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
