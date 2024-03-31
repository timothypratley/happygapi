(ns happygapi.walletobjects.giftcardclass
  "Google Wallet API: giftcardclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:defaultValue TranslatedString,
                           :translatedValues [TranslatedString],
                           :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:contentDescription LocalizedString,
                 :kind string,
                 :sourceUri ImageUri},
   :id string,
   :kind string,
   :localizedPinLabel {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string}}
  
  Inserts an gift card class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/list
  
  Required parameters: none
  
  Optional parameters: maxResults, issuerId, token
  
  Returns a list of all gift card classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:defaultValue TranslatedString,
                           :translatedValues [TranslatedString],
                           :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:contentDescription LocalizedString,
                 :kind string,
                 :sourceUri ImageUri},
   :id string,
   :kind string,
   :localizedPinLabel {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string}}
  
  Updates the gift card class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the gift card class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/addmessage
  
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
  
  Adds a message to the gift card class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}/addMessage"
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:defaultValue TranslatedString,
                           :translatedValues [TranslatedString],
                           :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:contentDescription LocalizedString,
                 :kind string,
                 :sourceUri ImageUri},
   :id string,
   :kind string,
   :localizedPinLabel {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:defaultValue TranslatedString,
                              :translatedValues [TranslatedString],
                              :kind string}}
  
  Updates the gift card class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/giftCardClass/{resourceId}"
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
