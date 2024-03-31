(ns happygapi.androidpublisher.monetization
  "Google Play Android Developer API: monetization.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/monetization"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn convertRegionPrices$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/convertRegionPrices
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:price {:currencyCode string, :units string, :nanos integer}}
  
  Calculates the region prices, using today's exchange rate and country-specific pricing patterns, based on the price in the request for a set of regions."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/pricing:convertRegionPrices"
     #{:packageName}
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

(defn subscriptions-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/get
  
  Required parameters: packageName, productId
  
  Optional parameters: none
  
  Reads a single subscription."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}"
     #{:packageName :productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-batchGet$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/batchGet
  
  Required parameters: packageName
  
  Optional parameters: productIds
  
  Reads one or more subscriptions."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions:batchGet"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/list
  
  Required parameters: packageName
  
  Optional parameters: pageSize, pageToken, showArchived
  
  Lists all subscriptions under a given app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/create
  
  Required parameters: packageName
  
  Optional parameters: productId, regionsVersion.version
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlans [{:basePlanId string,
                :state string,
                :autoRenewingBasePlanType AutoRenewingBasePlanType,
                :prepaidBasePlanType PrepaidBasePlanType,
                :regionalConfigs [RegionalBasePlanConfig],
                :offerTags [OfferTag],
                :otherRegionsConfig OtherRegionsBasePlanConfig}],
   :listings [{:languageCode string,
               :title string,
               :benefits [string],
               :description string}],
   :archived boolean,
   :taxAndComplianceSettings {:eeaWithdrawalRightType string,
                              :taxRateInfoByRegionCode {},
                              :isTokenizedDigitalAsset boolean}}
  
  Creates a new subscription. Newly added base plans will remain in draft state until activated."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions"
     #{:packageName}
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

(defn subscriptions-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/patch
  
  Required parameters: packageName, productId
  
  Optional parameters: updateMask, regionsVersion.version, allowMissing, latencyTolerance
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlans [{:basePlanId string,
                :state string,
                :autoRenewingBasePlanType AutoRenewingBasePlanType,
                :prepaidBasePlanType PrepaidBasePlanType,
                :regionalConfigs [RegionalBasePlanConfig],
                :offerTags [OfferTag],
                :otherRegionsConfig OtherRegionsBasePlanConfig}],
   :listings [{:languageCode string,
               :title string,
               :benefits [string],
               :description string}],
   :archived boolean,
   :taxAndComplianceSettings {:eeaWithdrawalRightType string,
                              :taxRateInfoByRegionCode {},
                              :isTokenizedDigitalAsset boolean}}
  
  Updates an existing subscription."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}"
     #{:packageName :productId}
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

(defn subscriptions-batchUpdate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/batchUpdate
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:subscription Subscription,
               :updateMask string,
               :regionsVersion RegionsVersion,
               :allowMissing boolean,
               :latencyTolerance string}]}
  
  Updates a batch of subscriptions. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions:batchUpdate"
     #{:packageName}
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

(defn subscriptions-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/delete
  
  Required parameters: packageName, productId
  
  Optional parameters: none
  
  Deletes a subscription. A subscription can only be deleted if it has never had a base plan published."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}"
     #{:packageName :productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-archive$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/archive
  
  Required parameters: packageName, productId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deprecated: subscription archiving is not supported."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}:archive"
     #{:packageName :productId}
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

(defn subscriptions-basePlans-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/delete
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Deletes a base plan. Can only be done for draft base plans. This action is irreversible."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}"
     #{:packageName :basePlanId :productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-basePlans-activate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/activate
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlanId string,
   :latencyTolerance string}
  
  Activates a base plan. Once activated, base plans will be available to new subscribers."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:activate"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-deactivate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/deactivate
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlanId string,
   :latencyTolerance string}
  
  Deactivates a base plan. Once deactivated, the base plan will become unavailable to new subscribers, but existing subscribers will maintain their subscription"
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:deactivate"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-batchUpdateStates$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/batchUpdateStates
  
  Required parameters: packageName, productId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:activateBasePlanRequest ActivateBasePlanRequest,
               :deactivateBasePlanRequest DeactivateBasePlanRequest}]}
  
  Activates or deactivates base plans across one or multiple subscriptions. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans:batchUpdateStates"
     #{:packageName :productId}
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

(defn subscriptions-basePlans-migratePrices$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/migratePrices
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlanId string,
   :regionalPriceMigrations [{:regionCode string,
                              :oldestAllowedPriceVersionTime string,
                              :priceIncreaseType string}],
   :regionsVersion {:version string},
   :latencyTolerance string}
  
  Migrates subscribers who are receiving an historical subscription price to the currently-offered price for the specified region. Requests will cause price change notifications to be sent to users who are currently receiving an historical price older than the supplied timestamp. Subscribers who do not agree to the new price will have their subscription ended at the next renewal."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}:migratePrices"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-batchMigratePrices$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/batchMigratePrices
  
  Required parameters: packageName, productId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:packageName string,
               :productId string,
               :basePlanId string,
               :regionalPriceMigrations [RegionalPriceMigrationConfig],
               :regionsVersion RegionsVersion,
               :latencyTolerance string}]}
  
  Batch variant of the MigrateBasePlanPrices endpoint. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans:batchMigratePrices"
     #{:packageName :productId}
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

(defn subscriptions-basePlans-offers-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/get
  
  Required parameters: packageName, productId, basePlanId, offerId
  
  Optional parameters: none
  
  Reads a single offer"
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId :offerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}"
     #{:packageName :basePlanId :productId :offerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-basePlans-offers-batchUpdateStates$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/batchUpdateStates
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:activateSubscriptionOfferRequest ActivateSubscriptionOfferRequest,
               :deactivateSubscriptionOfferRequest DeactivateSubscriptionOfferRequest}]}
  
  Updates a batch of subscription offer states. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchUpdateStates"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-offers-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/patch
  
  Required parameters: packageName, productId, basePlanId, offerId
  
  Optional parameters: updateMask, regionsVersion.version, allowMissing, latencyTolerance
  
  Body: 
  
  {:packageName string,
   :regionalConfigs [{:regionCode string,
                      :newSubscriberAvailability boolean}],
   :basePlanId string,
   :state string,
   :productId string,
   :offerTags [{:tag string}],
   :otherRegionsConfig {:otherRegionsNewSubscriberAvailability boolean},
   :offerId string,
   :phases [{:recurrenceCount integer,
             :duration string,
             :regionalConfigs [RegionalSubscriptionOfferPhaseConfig],
             :otherRegionsConfig OtherRegionsSubscriptionOfferPhaseConfig}],
   :targeting {:acquisitionRule AcquisitionTargetingRule,
               :upgradeRule UpgradeTargetingRule}}
  
  Updates an existing subscription offer."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId :offerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}"
     #{:packageName :basePlanId :productId :offerId}
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

(defn subscriptions-basePlans-offers-batchUpdate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/batchUpdate
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:subscriptionOffer SubscriptionOffer,
               :updateMask string,
               :regionsVersion RegionsVersion,
               :allowMissing boolean,
               :latencyTolerance string}]}
  
  Updates a batch of subscription offers. Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchUpdate"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-offers-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/create
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: offerId, regionsVersion.version
  
  Body: 
  
  {:packageName string,
   :regionalConfigs [{:regionCode string,
                      :newSubscriberAvailability boolean}],
   :basePlanId string,
   :state string,
   :productId string,
   :offerTags [{:tag string}],
   :otherRegionsConfig {:otherRegionsNewSubscriberAvailability boolean},
   :offerId string,
   :phases [{:recurrenceCount integer,
             :duration string,
             :regionalConfigs [RegionalSubscriptionOfferPhaseConfig],
             :otherRegionsConfig OtherRegionsSubscriptionOfferPhaseConfig}],
   :targeting {:acquisitionRule AcquisitionTargetingRule,
               :upgradeRule UpgradeTargetingRule}}
  
  Creates a new subscription offer. Only auto-renewing base plans can have subscription offers. The offer state will be DRAFT until it is activated."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-offers-batchGet$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/batchGet
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:packageName string,
               :productId string,
               :basePlanId string,
               :offerId string}]}
  
  Reads one or more subscription offers."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers:batchGet"
     #{:packageName :basePlanId :productId}
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

(defn subscriptions-basePlans-offers-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/delete
  
  Required parameters: packageName, productId, basePlanId, offerId
  
  Optional parameters: none
  
  Deletes a subscription offer. Can only be done for draft offers. This action is irreversible."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId :offerId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}"
     #{:packageName :basePlanId :productId :offerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-basePlans-offers-deactivate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/deactivate
  
  Required parameters: packageName, productId, basePlanId, offerId
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlanId string,
   :offerId string,
   :latencyTolerance string}
  
  Deactivates a subscription offer. Once deactivated, existing subscribers will maintain their subscription, but the offer will become unavailable to new subscribers."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId :offerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}:deactivate"
     #{:packageName :basePlanId :productId :offerId}
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

(defn subscriptions-basePlans-offers-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/list
  
  Required parameters: packageName, productId, basePlanId
  
  Optional parameters: pageSize, pageToken
  
  Lists all offers under a given subscription."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers"
     #{:packageName :basePlanId :productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-basePlans-offers-activate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/monetization/subscriptions/basePlans/offers/activate
  
  Required parameters: packageName, productId, basePlanId, offerId
  
  Optional parameters: none
  
  Body: 
  
  {:packageName string,
   :productId string,
   :basePlanId string,
   :offerId string,
   :latencyTolerance string}
  
  Activates a subscription offer. Once activated, subscription offers will be available to new subscribers."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :basePlanId :productId :offerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/subscriptions/{productId}/basePlans/{basePlanId}/offers/{offerId}:activate"
     #{:packageName :basePlanId :productId :offerId}
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
