(ns happygapi.walletobjects.offerobject
  "Google Wallet API: offerobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/insert
  
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
   :state string,
   :classReference {:helpUri Uri,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedFinePrint LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :localizedTitle LocalizedString,
                    :redemptionChannel string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedProvider LocalizedString,
                    :homepageUri Uri,
                    :titleImage Image,
                    :callbackOptions CallbackOptions,
                    :title string,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :details string,
                    :redemptionIssuers [string],
                    :review Review,
                    :localizedShortTitle LocalizedString,
                    :wideTitleImage Image,
                    :id string,
                    :kind string,
                    :finePrint string,
                    :classTemplateInfo ClassTemplateInfo,
                    :shortTitle string,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :provider string,
                    :heroImage Image,
                    :localizedDetails LocalizedString,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
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
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Inserts an offer object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/update
  
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
   :state string,
   :classReference {:helpUri Uri,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedFinePrint LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :localizedTitle LocalizedString,
                    :redemptionChannel string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedProvider LocalizedString,
                    :homepageUri Uri,
                    :titleImage Image,
                    :callbackOptions CallbackOptions,
                    :title string,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :details string,
                    :redemptionIssuers [string],
                    :review Review,
                    :localizedShortTitle LocalizedString,
                    :wideTitleImage Image,
                    :id string,
                    :kind string,
                    :finePrint string,
                    :classTemplateInfo ClassTemplateInfo,
                    :shortTitle string,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :provider string,
                    :heroImage Image,
                    :localizedDetails LocalizedString,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
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
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Updates the offer object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/list
  
  Required parameters: none
  
  Optional parameters: maxResults, token, classId
  
  Returns a list of all offer objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the offer object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/addmessage
  
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
  
  Adds a message to the offer object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/patch
  
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
   :state string,
   :classReference {:helpUri Uri,
                    :wordMark Image,
                    :reviewStatus string,
                    :localizedFinePrint LocalizedString,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :localizedTitle LocalizedString,
                    :redemptionChannel string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :localizedProvider LocalizedString,
                    :homepageUri Uri,
                    :titleImage Image,
                    :callbackOptions CallbackOptions,
                    :title string,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :details string,
                    :redemptionIssuers [string],
                    :review Review,
                    :localizedShortTitle LocalizedString,
                    :wideTitleImage Image,
                    :id string,
                    :kind string,
                    :finePrint string,
                    :classTemplateInfo ClassTemplateInfo,
                    :shortTitle string,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :provider string,
                    :heroImage Image,
                    :localizedDetails LocalizedString,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
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
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri}}
  
  Updates the offer object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerObject/{resourceId}"
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
