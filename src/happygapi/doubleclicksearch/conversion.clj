(ns happygapi.doubleclicksearch.conversion
  "Search Ads 360 API: conversion.
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion/get
  
  Required parameters: startDate, endDate, engineAccountId, advertiserId, startRow, agencyId, rowCount
  
  Optional parameters: adId, adGroupId, campaignId, criterionId
  Retrieves a list of conversions from a DoubleClick Search engine account."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:startDate
            :endDate
            :engineAccountId
            :advertiserId
            :startRow
            :agencyId
            :rowCount})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "agency/{agencyId}/advertiser/{advertiserId}/engine/{engineAccountId}/conversion"
     #{:startDate
       :endDate
       :engineAccountId
       :advertiserId
       :startRow
       :agencyId
       :rowCount}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:conversion [{:productLanguage string,
                 :countMillis string,
                 :segmentationName string,
                 :customDimension [CustomDimension],
                 :conversionTimestamp string,
                 :customMetric [CustomMetric],
                 :adId string,
                 :dsConversionId string,
                 :attributionModel string,
                 :adGroupId string,
                 :campaignId string,
                 :conversionModifiedTimestamp string,
                 :channel string,
                 :type string,
                 :segmentationType string,
                 :state string,
                 :productId string,
                 :criterionId string,
                 :engineAccountId string,
                 :advertiserId string,
                 :storeId string,
                 :revenueMicros string,
                 :segmentationId string,
                 :deviceType string,
                 :conversionId string,
                 :productCountry string,
                 :agencyId string,
                 :productGroupId string,
                 :currencyCode string,
                 :inventoryAccountId string,
                 :quantityMillis string,
                 :clickId string,
                 :floodlightOrderId string}],
   :kind string}
  
  Inserts a batch of new conversions into DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion/patch
  
  Required parameters: advertiserId, agencyId, endDate, engineAccountId, rowCount, startDate, startRow
  
  Optional parameters: none
  
  Body: 
  
  {:conversion [{:productLanguage string,
                 :countMillis string,
                 :segmentationName string,
                 :customDimension [CustomDimension],
                 :conversionTimestamp string,
                 :customMetric [CustomMetric],
                 :adId string,
                 :dsConversionId string,
                 :attributionModel string,
                 :adGroupId string,
                 :campaignId string,
                 :conversionModifiedTimestamp string,
                 :channel string,
                 :type string,
                 :segmentationType string,
                 :state string,
                 :productId string,
                 :criterionId string,
                 :engineAccountId string,
                 :advertiserId string,
                 :storeId string,
                 :revenueMicros string,
                 :segmentationId string,
                 :deviceType string,
                 :conversionId string,
                 :productCountry string,
                 :agencyId string,
                 :productGroupId string,
                 :currencyCode string,
                 :inventoryAccountId string,
                 :quantityMillis string,
                 :clickId string,
                 :floodlightOrderId string}],
   :kind string}
  
  Updates a batch of conversions in DoubleClick Search. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:startDate
            :endDate
            :engineAccountId
            :advertiserId
            :startRow
            :agencyId
            :rowCount})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{:startDate
       :endDate
       :engineAccountId
       :advertiserId
       :startRow
       :agencyId
       :rowCount}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion/update
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:conversion [{:productLanguage string,
                 :countMillis string,
                 :segmentationName string,
                 :customDimension [CustomDimension],
                 :conversionTimestamp string,
                 :customMetric [CustomMetric],
                 :adId string,
                 :dsConversionId string,
                 :attributionModel string,
                 :adGroupId string,
                 :campaignId string,
                 :conversionModifiedTimestamp string,
                 :channel string,
                 :type string,
                 :segmentationType string,
                 :state string,
                 :productId string,
                 :criterionId string,
                 :engineAccountId string,
                 :advertiserId string,
                 :storeId string,
                 :revenueMicros string,
                 :segmentationId string,
                 :deviceType string,
                 :conversionId string,
                 :productCountry string,
                 :agencyId string,
                 :productGroupId string,
                 :currencyCode string,
                 :inventoryAccountId string,
                 :quantityMillis string,
                 :clickId string,
                 :floodlightOrderId string}],
   :kind string}
  
  Updates a batch of conversions in DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateAvailability$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/conversion/updateAvailability
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:availabilities [{:advertiserId string,
                     :agencyId string,
                     :availabilityTimestamp string,
                     :segmentationId string,
                     :segmentationName string,
                     :segmentationType string}]}
  
  Updates the availabilities of a batch of floodlight activities in DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion/updateAvailability"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
