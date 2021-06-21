(ns happygapi.content.repricingrules
  "Content API for Shopping: repricingrules.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/get
  
  Required parameters: ruleId, merchantId
  
  Optional parameters: none
  
  Retrieves a repricing rule from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ruleId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules/{ruleId}"
     #{:ruleId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/delete
  
  Required parameters: ruleId, merchantId
  
  Optional parameters: none
  
  Deletes a repricing rule in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ruleId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules/{ruleId}"
     #{:ruleId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/create
  
  Required parameters: merchantId
  
  Optional parameters: ruleId
  
  Body: 
  
  {:restriction {:floor RepricingRuleRestrictionBoundary,
                 :useAutoPricingMinPrice boolean},
   :effectiveTimePeriod {:fixedTimePeriods [RepricingRuleEffectiveTimeFixedTimePeriod]},
   :paused boolean,
   :eligibleOfferMatcher {:itemGroupIdMatcher RepricingRuleEligibleOfferMatcherStringMatcher,
                          :matcherOption string,
                          :brandMatcher RepricingRuleEligibleOfferMatcherStringMatcher,
                          :skipWhenOnPromotion boolean,
                          :offerIdMatcher RepricingRuleEligibleOfferMatcherStringMatcher},
   :type string,
   :title string,
   :statsBasedRule {:percentageDelta integer, :priceDelta string},
   :languageCode string,
   :ruleId string,
   :cogsBasedRule {:priceDelta string, :percentageDelta integer},
   :merchantId string,
   :countryCode string}
  
  Creates a repricing rule for your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules"
     #{:merchantId}
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/list
  
  Required parameters: merchantId
  
  Optional parameters: pageSize, countryCode, pageToken, languageCode
  
  Lists the repricing rules in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/patch
  
  Required parameters: ruleId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:restriction {:floor RepricingRuleRestrictionBoundary,
                 :useAutoPricingMinPrice boolean},
   :effectiveTimePeriod {:fixedTimePeriods [RepricingRuleEffectiveTimeFixedTimePeriod]},
   :paused boolean,
   :eligibleOfferMatcher {:itemGroupIdMatcher RepricingRuleEligibleOfferMatcherStringMatcher,
                          :matcherOption string,
                          :brandMatcher RepricingRuleEligibleOfferMatcherStringMatcher,
                          :skipWhenOnPromotion boolean,
                          :offerIdMatcher RepricingRuleEligibleOfferMatcherStringMatcher},
   :type string,
   :title string,
   :statsBasedRule {:percentageDelta integer, :priceDelta string},
   :languageCode string,
   :ruleId string,
   :cogsBasedRule {:priceDelta string, :percentageDelta integer},
   :merchantId string,
   :countryCode string}
  
  Updates a repricing rule in your Merchant Center account. All mutable fields will be overwritten in each update request. In each update, you must provide all required mutable fields, or an error will be thrown. If you do not provide an optional field in the update request, if that field currently exists, it will be deleted from the rule."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:ruleId :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules/{ruleId}"
     #{:ruleId :merchantId}
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

(defn repricingreports-list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/repricingrules/repricingreports/list
  
  Required parameters: ruleId, merchantId
  
  Optional parameters: pageToken, endDate, pageSize, startDate
  
  Lists the metrics report for a given Repricing rule."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ruleId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/repricingrules/{ruleId}/repricingreports"
     #{:ruleId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
