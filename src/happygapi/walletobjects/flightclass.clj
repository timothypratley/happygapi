(ns happygapi.walletobjects.flightclass
  "Google Wallet API: flightclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localScheduledDepartureDateTime string,
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :boardingPolicy string,
                              :seatClassPolicy string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :flightHeader {:operatingCarrier FlightCarrier,
                  :flightNumber string,
                  :kind string,
                  :carrier FlightCarrier,
                  :operatingFlightNumber string,
                  :flightNumberDisplayOverride string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :origin {:terminal string,
            :kind string,
            :airportNameOverride LocalizedString,
            :gate string,
            :airportIataCode string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :destination {:terminal string,
                 :kind string,
                 :airportNameOverride LocalizedString,
                 :gate string,
                 :airportIataCode string},
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:localScheduledDepartureDateTime string,
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :boardingPolicy string,
                              :seatClassPolicy string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :flightHeader {:operatingCarrier FlightCarrier,
                  :flightNumber string,
                  :kind string,
                  :carrier FlightCarrier,
                  :operatingFlightNumber string,
                  :flightNumberDisplayOverride string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :origin {:terminal string,
            :kind string,
            :airportNameOverride LocalizedString,
            :gate string,
            :airportIataCode string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :destination {:terminal string,
                 :kind string,
                 :airportNameOverride LocalizedString,
                 :gate string,
                 :airportIataCode string},
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
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :localGateClosingDateTime string,
   :localBoardingDateTime string,
   :reviewStatus string,
   :boardingAndSeatingPolicy {:kind string,
                              :boardingPolicy string,
                              :seatClassPolicy string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :flightHeader {:operatingCarrier FlightCarrier,
                  :flightNumber string,
                  :kind string,
                  :carrier FlightCarrier,
                  :operatingFlightNumber string,
                  :flightNumberDisplayOverride string},
   :localEstimatedOrActualArrivalDateTime string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :locations [{:latitude number, :kind string, :longitude number}],
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
   :localEstimatedOrActualDepartureDateTime string,
   :review {:comments string},
   :localScheduledArrivalDateTime string,
   :id string,
   :kind string,
   :flightStatus string,
   :origin {:terminal string,
            :kind string,
            :airportNameOverride LocalizedString,
            :gate string,
            :airportIataCode string},
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :destination {:terminal string,
                 :kind string,
                 :airportNameOverride LocalizedString,
                 :gate string,
                 :airportIataCode string},
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
  
  Optional parameters: token, issuerId, maxResults
  
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/flightclass/addmessage
  
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
