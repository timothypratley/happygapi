(ns happygapi.walletobjects.flightobject
  "Google Wallet API: flightobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:securityProgramLogo {:contentDescription LocalizedString,
                         :kind string,
                         :sourceUri ImageUri},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :kind string,
                     :confirmationCode string},
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
   :classReference {:localScheduledDepartureDateTime string,
                    :wordMark Image,
                    :localGateClosingDateTime string,
                    :localBoardingDateTime string,
                    :reviewStatus string,
                    :boardingAndSeatingPolicy BoardingAndSeatingPolicy,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :flightHeader FlightHeader,
                    :localEstimatedOrActualArrivalDateTime string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :localEstimatedOrActualDepartureDateTime string,
                    :review Review,
                    :localScheduledArrivalDateTime string,
                    :id string,
                    :kind string,
                    :flightStatus string,
                    :origin AirportInfo,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :destination AirportInfo,
                    :countryCode string,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :boardingAndSeatingInfo {:sequenceNumber string,
                            :seatAssignment LocalizedString,
                            :seatNumber string,
                            :boardingPosition string,
                            :kind string,
                            :boardingGroup string,
                            :boardingPrivilegeImage Image,
                            :boardingDoor string,
                            :seatClass string},
   :hexBackgroundColor string,
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
   :passengerName string,
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
  
  Updates the flight object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/addmessage
  
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
  
  Adds a message to the flight object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/list
  
  Required parameters: none
  
  Optional parameters: token, maxResults, classId
  
  Returns a list of all flight objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the flight object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:securityProgramLogo {:contentDescription LocalizedString,
                         :kind string,
                         :sourceUri ImageUri},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :kind string,
                     :confirmationCode string},
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
   :classReference {:localScheduledDepartureDateTime string,
                    :wordMark Image,
                    :localGateClosingDateTime string,
                    :localBoardingDateTime string,
                    :reviewStatus string,
                    :boardingAndSeatingPolicy BoardingAndSeatingPolicy,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :flightHeader FlightHeader,
                    :localEstimatedOrActualArrivalDateTime string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :localEstimatedOrActualDepartureDateTime string,
                    :review Review,
                    :localScheduledArrivalDateTime string,
                    :id string,
                    :kind string,
                    :flightStatus string,
                    :origin AirportInfo,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :destination AirportInfo,
                    :countryCode string,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :boardingAndSeatingInfo {:sequenceNumber string,
                            :seatAssignment LocalizedString,
                            :seatNumber string,
                            :boardingPosition string,
                            :kind string,
                            :boardingGroup string,
                            :boardingPrivilegeImage Image,
                            :boardingDoor string,
                            :seatClass string},
   :hexBackgroundColor string,
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
   :passengerName string,
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
  
  Updates the flight object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:securityProgramLogo {:contentDescription LocalizedString,
                         :kind string,
                         :sourceUri ImageUri},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :kind string,
                     :confirmationCode string},
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
   :classReference {:localScheduledDepartureDateTime string,
                    :wordMark Image,
                    :localGateClosingDateTime string,
                    :localBoardingDateTime string,
                    :reviewStatus string,
                    :boardingAndSeatingPolicy BoardingAndSeatingPolicy,
                    :textModulesData [TextModuleData],
                    :issuerName string,
                    :flightHeader FlightHeader,
                    :localEstimatedOrActualArrivalDateTime string,
                    :securityAnimation SecurityAnimation,
                    :multipleDevicesAndHoldersAllowedStatus string,
                    :homepageUri Uri,
                    :callbackOptions CallbackOptions,
                    :linksModuleData LinksModuleData,
                    :imageModulesData [ImageModuleData],
                    :locations [LatLongPoint],
                    :allowMultipleUsersPerObject boolean,
                    :hexBackgroundColor string,
                    :messages [Message],
                    :localizedIssuerName LocalizedString,
                    :redemptionIssuers [string],
                    :localEstimatedOrActualDepartureDateTime string,
                    :review Review,
                    :localScheduledArrivalDateTime string,
                    :id string,
                    :kind string,
                    :flightStatus string,
                    :origin AirportInfo,
                    :classTemplateInfo ClassTemplateInfo,
                    :enableSmartTap boolean,
                    :version string,
                    :viewUnlockRequirement string,
                    :infoModuleData InfoModuleData,
                    :heroImage Image,
                    :destination AirportInfo,
                    :countryCode string,
                    :languageOverride string},
   :disableExpirationNotification boolean,
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :locations [{:latitude number, :kind string, :longitude number}],
   :boardingAndSeatingInfo {:sequenceNumber string,
                            :seatAssignment LocalizedString,
                            :seatNumber string,
                            :boardingPosition string,
                            :kind string,
                            :boardingGroup string,
                            :boardingPrivilegeImage Image,
                            :boardingDoor string,
                            :seatClass string},
   :hexBackgroundColor string,
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
   :passengerName string,
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
  
  Inserts an flight object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightObject"
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
