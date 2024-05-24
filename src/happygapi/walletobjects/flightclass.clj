(ns happygapi.walletobjects.flightclass
  "Google Wallet API: flightclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/flightclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/addmessage
  
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
  
  Adds a message to the flight class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the flight class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localScheduledDepartureDateTime string,
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :seatClassPolicy string,
                              :boardingPolicy string},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :flightHeader {:operatingFlightNumber string,
                  :operatingCarrier FlightCarrier,
                  :flightNumberDisplayOverride string,
                  :carrier FlightCarrier,
                  :flightNumber string,
                  :kind string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :origin {:kind string,
            :airportNameOverride LocalizedString,
            :airportIataCode string,
            :terminal string,
            :gate string},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :destination {:kind string,
                 :airportNameOverride LocalizedString,
                 :airportIataCode string,
                 :terminal string,
                 :gate string},
   :countryCode string,
   :languageOverride string}
  
  Inserts an flight class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localScheduledDepartureDateTime string,
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :seatClassPolicy string,
                              :boardingPolicy string},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :flightHeader {:operatingFlightNumber string,
                  :operatingCarrier FlightCarrier,
                  :flightNumberDisplayOverride string,
                  :carrier FlightCarrier,
                  :flightNumber string,
                  :kind string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :origin {:kind string,
            :airportNameOverride LocalizedString,
            :airportIataCode string,
            :terminal string,
            :gate string},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :destination {:kind string,
                 :airportNameOverride LocalizedString,
                 :airportIataCode string,
                 :terminal string,
                 :gate string},
   :countryCode string,
   :languageOverride string}
  
  Updates the flight class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass/{resourceId}"
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localScheduledDepartureDateTime string,
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :seatClassPolicy string,
                              :boardingPolicy string},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :flightHeader {:operatingFlightNumber string,
                  :operatingCarrier FlightCarrier,
                  :flightNumberDisplayOverride string,
                  :carrier FlightCarrier,
                  :flightNumber string,
                  :kind string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :origin {:kind string,
            :airportNameOverride LocalizedString,
            :airportIataCode string,
            :terminal string,
            :gate string},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :destination {:kind string,
                 :airportNameOverride LocalizedString,
                 :airportIataCode string,
                 :terminal string,
                 :gate string},
   :countryCode string,
   :languageOverride string}
  
  Updates the flight class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, maxResults, token
  
  Returns a list of all flight classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/flightClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
