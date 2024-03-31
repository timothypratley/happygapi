(ns happygapi.walletobjects.eventticketobject
  "Google Wallet API: eventticketobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:seat LocalizedString,
              :kind string,
              :section LocalizedString,
              :row LocalizedString,
              :gate LocalizedString},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:defaultValue TranslatedString,
                :translatedValues [TranslatedString],
                :kind string},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
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
               :sourceUri ImageUri},
   :ticketHolderName string}
  
  Updates the event ticket object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:seat LocalizedString,
              :kind string,
              :section LocalizedString,
              :row LocalizedString,
              :gate LocalizedString},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:defaultValue TranslatedString,
                :translatedValues [TranslatedString],
                :kind string},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
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
               :sourceUri ImageUri},
   :ticketHolderName string}
  
  Inserts an event ticket object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/list
  
  Required parameters: none
  
  Optional parameters: classId, token, maxResults
  
  Returns a list of all event ticket objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/addmessage
  
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
  
  Adds a message to the event ticket object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}/addMessage"
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

(defn modifylinkedofferobjects$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/modifylinkedofferobjects
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:linkedOfferObjectIds {:addLinkedOfferObjectIds [string],
                          :removeLinkedOfferObjectIds [string]}}
  
  Modifies linked offer objects for the event ticket object with the given ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}/modifyLinkedOfferObjects"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the event ticket object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:faceValue {:kind string, :currencyCode string, :micros string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:kind string, :confirmationCode string},
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
   :seatInfo {:seat LocalizedString,
              :kind string,
              :section LocalizedString,
              :row LocalizedString,
              :gate LocalizedString},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :ticketType {:defaultValue TranslatedString,
                :translatedValues [TranslatedString],
                :kind string},
   :state string,
   :classReference {:wordMark Image,
                    :eventName LocalizedString,
                    :reviewStatus string,
                    :rowLabel string,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :logo Image,
                    :wideLogo Image,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :customSeatLabel LocalizedString,
                    :customSectionLabel LocalizedString,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :eventId string,
                    :locations [LatLongPoint],
                    :dateTime EventDateTime,
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :sectionLabel string,
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :review Review,
                    :id string,
                    :kind string,
                    :venue EventVenue,
                    :customRowLabel LocalizedString,
                    :finePrint LocalizedString,
                    :gateLabel string,
                    :seatLabel string,
                    :customConfirmationCodeLabel LocalizedString,
                    :confirmationCodeLabel string,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :customGateLabel LocalizedString,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :countryCode string},
   :disableExpirationNotification boolean,
   :linkedOfferIds [string],
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :hexBackgroundColor string,
   :messages [{:body string,
               :messageType string,
               :header string,
               :id string,
               :kind string,
               :displayInterval TimeInterval,
               :localizedHeader LocalizedString,
               :localizedBody LocalizedString}],
   :ticketNumber string,
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
               :sourceUri ImageUri},
   :ticketHolderName string}
  
  Updates the event ticket object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketObject/{resourceId}"
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
