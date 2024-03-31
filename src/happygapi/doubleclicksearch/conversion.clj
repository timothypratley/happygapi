(ns happygapi.doubleclicksearch.conversion
  "Search Ads 360 API: conversion.
  The Search Ads 360 API allows developers to automate uploading conversions and downloading reports from Search Ads 360.
  See: https://developers.google.com/search-adsapi/reference/rest/v2/conversion"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/search-adsapi/reference/rest/v2/conversion/get
  
  Required parameters: startDate, endDate, engineAccountId, advertiserId, startRow, agencyId, rowCount
  
  Optional parameters: adId, adGroupId, campaignId, criterionId, customerId
  
  Retrieves a list of conversions from a DoubleClick Search engine account."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
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
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/agency/{agencyId}/advertiser/{advertiserId}/engine/{engineAccountId}/conversion"
     #{:startDate
       :endDate
       :engineAccountId
       :advertiserId
       :startRow
       :agencyId
       :rowCount}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getByCustomerId$
  "https://developers.google.com/search-adsapi/reference/rest/v2/conversion/getByCustomerId
  
  Required parameters: startDate, customerId, endDate, startRow, rowCount
  
  Optional parameters: adId, adGroupId, campaignId, criterionId, engineAccountId, advertiserId, agencyId
  
  Retrieves a list of conversions from a DoubleClick Search engine account."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:startDate :customerId :endDate :startRow :rowCount})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/customer/{customerId}/conversion"
     #{:startDate :customerId :endDate :startRow :rowCount}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/search-adsapi/reference/rest/v2/conversion/insert
  
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
                 :adUserDataConsent string,
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
                 :customerId string,
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/conversion"
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

(defn update$
  "https://developers.google.com/search-adsapi/reference/rest/v2/conversion/update
  
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
                 :adUserDataConsent string,
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
                 :customerId string,
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/conversion"
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

(defn updateAvailability$
  "https://developers.google.com/search-adsapi/reference/rest/v2/conversion/updateAvailability
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:availabilities [{:agencyId string,
                     :advertiserId string,
                     :segmentationType string,
                     :segmentationId string,
                     :segmentationName string,
                     :availabilityTimestamp string,
                     :customerId string}]}
  
  Updates the availabilities of a batch of floodlight activities in DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclicksearch.googleapis.com/"
     "doubleclicksearch/v2/conversion/updateAvailability"
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
