(ns happygapi.walletobjects.eventticketclass
  "Google Wallet API: eventticketclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the event ticket class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :eventName {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customSectionLabel {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:kind string,
              :doorsOpenLabel string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :start string,
              :doorsOpen string},
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
   :sectionLabel string,
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :address LocalizedString,
           :kind string},
   :customRowLabel {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :finePrint {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :confirmationCodeLabel string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string}
  
  Updates the event ticket class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :eventName {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customSectionLabel {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:kind string,
              :doorsOpenLabel string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :start string,
              :doorsOpen string},
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
   :sectionLabel string,
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :address LocalizedString,
           :kind string},
   :customRowLabel {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :finePrint {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :confirmationCodeLabel string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string}
  
  Updates the event ticket class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :eventName {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :customSeatLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :customSectionLabel {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :callbackOptions {:url string, :updateRequestUrl string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:kind string,
              :doorsOpenLabel string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :start string,
              :doorsOpen string},
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
   :sectionLabel string,
   :localizedIssuerName {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:name LocalizedString,
           :address LocalizedString,
           :kind string},
   :customRowLabel {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :finePrint {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:defaultValue TranslatedString,
                                 :translatedValues [TranslatedString],
                                 :kind string},
   :confirmationCodeLabel string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:defaultValue TranslatedString,
                     :translatedValues [TranslatedString],
                     :kind string},
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :countryCode string}
  
  Inserts an event ticket class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/list
  
  Required parameters: none
  
  Optional parameters: maxResults, issuerId, token
  
  Returns a list of all event ticket classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/addmessage
  
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
  
  Adds a message to the event ticket class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/eventTicketClass/{resourceId}/addMessage"
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
