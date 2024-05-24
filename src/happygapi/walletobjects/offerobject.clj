(ns happygapi.walletobjects.offerobject
  "Google Wallet API: offerobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/offerobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:showCodeText LocalizedString,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :valuePattern string,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :totpDetails RotatingBarcodeTotpDetails},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :barcode {:renderEncoding string,
             :showCodeText LocalizedString,
             :type string,
             :kind string,
             :alternateText string,
             :value string},
   :hasLinkedDevice boolean,
   :groupingInfo {:sortIndex integer, :groupingId string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString}}
  
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
  
  Optional parameters: classId, maxResults, token
  
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:showCodeText LocalizedString,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :valuePattern string,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :totpDetails RotatingBarcodeTotpDetails},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :barcode {:renderEncoding string,
             :showCodeText LocalizedString,
             :type string,
             :kind string,
             :alternateText string,
             :value string},
   :hasLinkedDevice boolean,
   :groupingInfo {:sortIndex integer, :groupingId string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString}}
  
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/addmessage
  
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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:hasUsers boolean,
   :smartTapRedemptionValue string,
   :rotatingBarcode {:showCodeText LocalizedString,
                     :initialRotatingBarcodeValues RotatingBarcodeValues,
                     :valuePattern string,
                     :renderEncoding string,
                     :alternateText string,
                     :type string,
                     :totpDetails RotatingBarcodeTotpDetails},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :barcode {:renderEncoding string,
             :showCodeText LocalizedString,
             :type string,
             :kind string,
             :alternateText string,
             :value string},
   :hasLinkedDevice boolean,
   :groupingInfo {:sortIndex integer, :groupingId string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :messages [{:messageType string,
               :displayInterval TimeInterval,
               :body string,
               :id string,
               :localizedBody LocalizedString,
               :header string,
               :localizedHeader LocalizedString,
               :kind string}],
   :id string,
   :kind string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :version string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString}}
  
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
