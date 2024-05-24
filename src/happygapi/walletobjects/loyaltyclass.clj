(ns happygapi.walletobjects.loyaltyclass
  "Google Wallet API: loyaltyclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/loyaltyclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/list
  
  Required parameters: none
  
  Optional parameters: token, issuerId, maxResults
  
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo},
   :localizedRewardsTierLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:kind string,
                                        :translatedValues [TranslatedString],
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :programName string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/addmessage
  
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo},
   :localizedRewardsTierLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:kind string,
                                        :translatedValues [TranslatedString],
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :programName string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localizedAccountIdLabel {:kind string,
                             :translatedValues [TranslatedString],
                             :defaultValue TranslatedString},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedRewardsTier {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :wideProgramLogo {:sourceUri ImageUri,
                     :kind string,
                     :contentDescription LocalizedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :discoverableProgram {:merchantSignupInfo DiscoverableProgramMerchantSignupInfo,
                         :state string,
                         :merchantSigninInfo DiscoverableProgramMerchantSigninInfo},
   :localizedRewardsTierLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :secondaryRewardsTierLabel string,
   :accountNameLabel string,
   :rewardsTierLabel string,
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :localizedSecondaryRewardsTier {:kind string,
                                   :translatedValues [TranslatedString],
                                   :defaultValue TranslatedString},
   :imageModulesData [{:mainImage Image, :id string}],
   :secondaryRewardsTier string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :rewardsTier string,
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
   :localizedSecondaryRewardsTierLabel {:kind string,
                                        :translatedValues [TranslatedString],
                                        :defaultValue TranslatedString},
   :localizedAccountNameLabel {:kind string,
                               :translatedValues [TranslatedString],
                               :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :programName string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :localizedProgramName {:kind string,
                          :translatedValues [TranslatedString],
                          :defaultValue TranslatedString},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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
