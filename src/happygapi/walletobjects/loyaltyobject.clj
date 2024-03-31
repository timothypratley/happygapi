(ns happygapi.walletobjects.loyaltyobject
  "Google Wallet API: loyaltyobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/addmessage
  
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
  
  Adds a message to the loyalty object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the loyalty object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn modifylinkedofferobjects$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/modifylinkedofferobjects
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:linkedOfferObjectIds {:addLinkedOfferObjectIds [string],
                          :removeLinkedOfferObjectIds [string]}}
  
  Modifies linked offer objects for the loyalty object with the given ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject/{resourceId}/modifyLinkedOfferObjects"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :accountName string,
   :state string,
   :classReference {:localizedAccountIdLabel LocalizedString,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedRewardsTier LocalizedString,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :discoverableProgram DiscoverableProgram,
                    :localizedRewardsTierLabel LocalizedString,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :secondaryRewardsTierLabel string,
                    :accountNameLabel string,
                    :rewardsTierLabel string,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :localizedSecondaryRewardsTier LocalizedString,
                    :imageModulesData [ImageModuleData],
                    :secondaryRewardsTier string,
                    :locations [LatLongPoint],
                    :rewardsTier string,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedSecondaryRewardsTierLabel LocalizedString,
                    :localizedAccountNameLabel LocalizedString,
                    :programName string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :localizedProgramName LocalizedString,
                    :heroImage Image,
                    :accountIdLabel string,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :loyaltyPoints {:balance LoyaltyPointsBalance,
                   :label string,
                   :localizedLabel LocalizedString},
   :secondaryLoyaltyPoints {:balance LoyaltyPointsBalance,
                            :label string,
                            :localizedLabel LocalizedString},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :accountId string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Inserts an loyalty object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :accountName string,
   :state string,
   :classReference {:localizedAccountIdLabel LocalizedString,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedRewardsTier LocalizedString,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :discoverableProgram DiscoverableProgram,
                    :localizedRewardsTierLabel LocalizedString,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :secondaryRewardsTierLabel string,
                    :accountNameLabel string,
                    :rewardsTierLabel string,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :localizedSecondaryRewardsTier LocalizedString,
                    :imageModulesData [ImageModuleData],
                    :secondaryRewardsTier string,
                    :locations [LatLongPoint],
                    :rewardsTier string,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedSecondaryRewardsTierLabel LocalizedString,
                    :localizedAccountNameLabel LocalizedString,
                    :programName string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :localizedProgramName LocalizedString,
                    :heroImage Image,
                    :accountIdLabel string,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :loyaltyPoints {:balance LoyaltyPointsBalance,
                   :label string,
                   :localizedLabel LocalizedString},
   :secondaryLoyaltyPoints {:balance LoyaltyPointsBalance,
                            :label string,
                            :localizedLabel LocalizedString},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :accountId string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Updates the loyalty object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, classId
  
  Returns a list of all loyalty objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/loyaltyobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:totpDetails RotatingBarcodeTotpDetails,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :showCodeText LocalizedString,
                     :type string,
                     :valuePattern string,
                     :alternateText string,
                     :renderEncoding string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :barcode {:alternateText string,
             :showCodeText LocalizedString,
             :type string,
             :renderEncoding string,
             :value string,
             :kind string},
   :hasLinkedDevice boolean,
   :groupingInfo {:groupingId string, :sortIndex integer},
   :accountName string,
   :state string,
   :classReference {:localizedAccountIdLabel LocalizedString,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedRewardsTier LocalizedString,
                    :wideProgramLogo Image,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :discoverableProgram DiscoverableProgram,
                    :localizedRewardsTierLabel LocalizedString,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :secondaryRewardsTierLabel string,
                    :accountNameLabel string,
                    :rewardsTierLabel string,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :localizedSecondaryRewardsTier LocalizedString,
                    :imageModulesData [ImageModuleData],
                    :secondaryRewardsTier string,
                    :locations [LatLongPoint],
                    :rewardsTier string,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :programLogo Image,
                    :id string,
                    :kind string,
                    :localizedSecondaryRewardsTierLabel LocalizedString,
                    :localizedAccountNameLabel LocalizedString,
                    :programName string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :localizedProgramName LocalizedString,
                    :heroImage Image,
                    :accountIdLabel string,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :loyaltyPoints {:balance LoyaltyPointsBalance,
                   :label string,
                   :localizedLabel LocalizedString},
   :secondaryLoyaltyPoints {:balance LoyaltyPointsBalance,
                            :label string,
                            :localizedLabel LocalizedString},
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :accountId string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Updates the loyalty object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/loyaltyObject/{resourceId}"
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
