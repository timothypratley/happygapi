(ns happygapi.walletobjects.transitclass
  "Google Wallet API: transitclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/transitclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/addmessage
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:message {:messageType string,
             :displayInterval TimeInterval,
             :body string,
             :id string,
             :localizedBody LocalizedString,
             :header string,
             :localizedHeader LocalizedString,
             :kind string}}
  
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

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/list
  
  Required parameters: none
  
  Optional parameters: maxResults, issuerId, token
  
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
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:kind string,
                                :translatedValues [TranslatedString],
                                :defaultValue TranslatedString},
   :customPlatformLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:kind string,
                                         :translatedValues [TranslatedString],
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :customZoneLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customFareClassLabel {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:kind string,
                                      :translatedValues [TranslatedString],
                                      :defaultValue TranslatedString},
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customConcessionCategoryLabel {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:kind string,
                                    :translatedValues [TranslatedString],
                                    :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :customCoachLabel {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :watermark {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:kind string,
                                :translatedValues [TranslatedString],
                                :defaultValue TranslatedString},
   :customPlatformLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:kind string,
                                         :translatedValues [TranslatedString],
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :customZoneLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customFareClassLabel {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:kind string,
                                      :translatedValues [TranslatedString],
                                      :defaultValue TranslatedString},
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customConcessionCategoryLabel {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:kind string,
                                    :translatedValues [TranslatedString],
                                    :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :customCoachLabel {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :watermark {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/transitclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :transitType string,
   :customFareNameLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :customDiscountMessageLabel {:kind string,
                                :translatedValues [TranslatedString],
                                :defaultValue TranslatedString},
   :customPlatformLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :reviewStatus string,
   :customRouteRestrictionsDetailsLabel {:kind string,
                                         :translatedValues [TranslatedString],
                                         :defaultValue TranslatedString},
   :customCarriageLabel {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :customZoneLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customFareClassLabel {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :customPurchaseReceiptNumberLabel {:kind string,
                                      :translatedValues [TranslatedString],
                                      :defaultValue TranslatedString},
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :activationOptions {:allowReactivation boolean,
                       :activationUrl string},
   :enableSingleLegItinerary boolean,
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :transitOperatorName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customConcessionCategoryLabel {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customTransitTerminusNameLabel {:kind string,
                                    :translatedValues [TranslatedString],
                                    :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :customRouteRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
   :customTimeRestrictionsLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :customOtherRestrictionsLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :customPurchaseFaceValueLabel {:kind string,
                                  :translatedValues [TranslatedString],
                                  :defaultValue TranslatedString},
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :customCoachLabel {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :customPurchasePriceLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString},
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :watermark {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :countryCode string,
   :customTicketNumberLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
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
