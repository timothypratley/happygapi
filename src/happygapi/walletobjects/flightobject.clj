(ns happygapi.walletobjects.flightobject
  "Google Wallet API: flightobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/flightobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/addmessage
  
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:securityProgramLogo {:sourceUri ImageUri,
                         :kind string,
                         :contentDescription LocalizedString},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :confirmationCode string,
                     :kind string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
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
   :passengerName string,
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

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/list
  
  Required parameters: none
  
  Optional parameters: classId, maxResults, token
  
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:securityProgramLogo {:sourceUri ImageUri,
                         :kind string,
                         :contentDescription LocalizedString},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :confirmationCode string,
                     :kind string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
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
   :passengerName string,
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
  
  {:securityProgramLogo {:sourceUri ImageUri,
                         :kind string,
                         :contentDescription LocalizedString},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
   :reservationInfo {:frequentFlyerInfo FrequentFlyerInfo,
                     :eticketNumber string,
                     :confirmationCode string,
                     :kind string},
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
                    :appLinkData AppLinkData,
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
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
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
   :passengerName string,
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
