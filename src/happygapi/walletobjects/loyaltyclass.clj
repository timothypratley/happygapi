(ns happygapi.walletobjects.loyaltyclass
  "Google Wallet API: loyaltyclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, token, maxResults
  
  Returns a list of all loyalty classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedRewardsTier {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :state string},
   :localizedRewardsTierLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:defaultValue TranslatedString,
                                        :translatedValues [TranslatedString],
                                        :kind string},
   :localizedAccountNameLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :programName string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :localizedProgramName {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :accountIdLabel string,
   :countryCode string}
  
  Updates the loyalty class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/addmessage
  
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
  
  Adds a message to the loyalty class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the loyalty class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedRewardsTier {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :state string},
   :localizedRewardsTierLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:defaultValue TranslatedString,
                                        :translatedValues [TranslatedString],
                                        :kind string},
   :localizedAccountNameLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :programName string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :localizedProgramName {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :accountIdLabel string,
   :countryCode string}
  
  Inserts an loyalty class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:defaultValue TranslatedString,
                             :translatedValues [TranslatedString],
                             :kind string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedRewardsTier {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :wideProgramLogo {:contentDescription LocalizedString,
                     :kind string,
                     :sourceUri ImageUri},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo,
                         :state string},
   :localizedRewardsTierLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:defaultValue TranslatedString,
                                   :translatedValues [TranslatedString],
                                   :kind string},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:defaultValue TranslatedString,
                                        :translatedValues [TranslatedString],
                                        :kind string},
   :localizedAccountNameLabel {:defaultValue TranslatedString,
                               :translatedValues [TranslatedString],
                               :kind string},
   :programName string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :localizedProgramName {:defaultValue TranslatedString,
                          :translatedValues [TranslatedString],
                          :kind string},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :accountIdLabel string,
   :countryCode string}
  
  Updates the loyalty class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyClass/{resourceId}"
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
