(ns happygapi.searchads360.searchAds360Fields
  "Search Ads 360 Reporting API: searchAds360Fields.
  The Search Ads 360 API allows developers to automate downloading reports from Search Ads 360.
  See: https://developers.google.com/search-ads/reportingdocs/reference/rest/v0/searchAds360Fields"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/searchAds360Fields/get
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Returns just the requested field. List of thrown errors: [AuthenticationError]() [AuthorizationError]() [HeaderError]() [InternalError]() [QuotaError]() [RequestError]()"
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

(defn search$
  "https://developers.google.com/search-ads/reportingapi/reference/rest/v0/searchAds360Fields/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:query string, :pageToken string, :pageSize integer}
  
  Returns all fields that match the search [query](/search-ads/reporting/concepts/field-service#use_a_query_to_get_field_details). List of thrown errors: [AuthenticationError]() [AuthorizationError]() [HeaderError]() [InternalError]() [QueryError]() [QuotaError]() [RequestError]()"
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchads360.googleapis.com/"
     "v0/searchAds360Fields:search"
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
