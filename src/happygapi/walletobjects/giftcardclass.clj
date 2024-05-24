(ns happygapi.walletobjects.giftcardclass
  "Google Wallet API: giftcardclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/giftcardclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:kind string,
                           :translatedValues [TranslatedString],
                           :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:sourceUri ImageUri,
                 :kind string,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :localizedPinLabel {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString}}
  
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:kind string,
                           :translatedValues [TranslatedString],
                           :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:sourceUri ImageUri,
                 :kind string,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :localizedPinLabel {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString}}
  
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/giftcardclass/addmessage
  
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
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedEventNumberLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :pinLabel string,
   :merchantName string,
   :localizedMerchantName {:kind string,
                           :translatedValues [TranslatedString],
                           :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
   :allowMultipleUsersPerObject boolean,
   :hexBackgroundColor string,
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
   :programLogo {:sourceUri ImageUri,
                 :kind string,
                 :contentDescription LocalizedString},
   :id string,
   :kind string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :localizedPinLabel {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :cardNumberLabel string,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :allowBarcodeRedemption boolean,
   :eventNumberLabel string,
   :countryCode string,
   :localizedCardNumberLabel {:kind string,
                              :translatedValues [TranslatedString],
                              :defaultValue TranslatedString}}
  
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
