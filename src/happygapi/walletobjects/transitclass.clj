(ns happygapi.walletobjects.transitclass
  "Google Wallet API: transitclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :transitType string,
   :customFareNameLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :customDiscountMessageLabel {:defaultValue TranslatedString,
                                :translatedValues [TranslatedString],
                                :kind string},
   :customPlatformLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:defaultValue TranslatedString,
                                         :translatedValues [TranslatedString],
                                         :kind string},
   :customCarriageLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :customZoneLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customFareClassLabel {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :customPurchaseReceiptNumberLabel {:defaultValue TranslatedString,
                                      :translatedValues [TranslatedString],
                                      :kind string},
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customConcessionCategoryLabel {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customTransitTerminusNameLabel {:defaultValue TranslatedString,
                                    :translatedValues [TranslatedString],
                                    :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customOtherRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customCoachLabel {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :watermark {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string,
   :customTicketNumberLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :languageOverride string}
  
  Updates the transit class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
     #{:resourceId}
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/addmessage
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:body string,
             :messageType string,
             :header string,
             :id string,
             :kind string,
             :displayInterval TimeInterval,
             :localizedHeader LocalizedString,
             :localizedBody LocalizedString}}
  
  Adds a message to the transit class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}/addMessage"
     #{:resourceId}
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

(defn get$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the transit class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :transitType string,
   :customFareNameLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :customDiscountMessageLabel {:defaultValue TranslatedString,
                                :translatedValues [TranslatedString],
                                :kind string},
   :customPlatformLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:defaultValue TranslatedString,
                                         :translatedValues [TranslatedString],
                                         :kind string},
   :customCarriageLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :customZoneLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customFareClassLabel {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :customPurchaseReceiptNumberLabel {:defaultValue TranslatedString,
                                      :translatedValues [TranslatedString],
                                      :kind string},
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customConcessionCategoryLabel {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customTransitTerminusNameLabel {:defaultValue TranslatedString,
                                    :translatedValues [TranslatedString],
                                    :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customOtherRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customCoachLabel {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :watermark {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string,
   :customTicketNumberLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :languageOverride string}
  
  Inserts a transit class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass"
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

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, maxResults, token
  
  Returns a list of all transit classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :transitType string,
   :customFareNameLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :customDiscountMessageLabel {:defaultValue TranslatedString,
                                :translatedValues [TranslatedString],
                                :kind string},
   :customPlatformLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:defaultValue TranslatedString,
                                         :translatedValues [TranslatedString],
                                         :kind string},
   :customCarriageLabel {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :customZoneLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customFareClassLabel {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :customPurchaseReceiptNumberLabel {:defaultValue TranslatedString,
                                      :translatedValues [TranslatedString],
                                      :kind string},
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customConcessionCategoryLabel {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customTransitTerminusNameLabel {:defaultValue TranslatedString,
                                    :translatedValues [TranslatedString],
                                    :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customOtherRestrictionsLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:defaultValue TranslatedString,
                                  :translatedValues [TranslatedString],
                                  :kind string},
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :customCoachLabel {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string},
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :watermark {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string,
   :customTicketNumberLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :languageOverride string}
  
  Updates the transit class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/transitClass/{resourceId}"
     #{:resourceId}
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
