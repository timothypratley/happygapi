(ns happygapi.walletobjects.eventticketclass
  "Google Wallet API: eventticketclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/eventticketclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/list
  
  Required parameters: none
  
  Optional parameters: token, issuerId, maxResults
  
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :eventName {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customSectionLabel {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :doorsOpen string,
              :kind string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :doorsOpenLabel string},
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
   :sectionLabel string,
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:kind string,
           :name LocalizedString,
           :address LocalizedString},
   :customRowLabel {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :finePrint {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :confirmationCodeLabel string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :eventName {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customSectionLabel {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :doorsOpen string,
              :kind string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :doorsOpenLabel string},
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
   :sectionLabel string,
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:kind string,
           :name LocalizedString,
           :address LocalizedString},
   :customRowLabel {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :finePrint {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :confirmationCodeLabel string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/addmessage
  
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/eventticketclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :eventName {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :reviewStatus string,
   :rowLabel string,
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :customSeatLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :customSectionLabel {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :eventId string,
   :locations [{:latitude number, :kind string, :longitude number}],
   :dateTime {:start string,
              :doorsOpen string,
              :kind string,
              :end string,
              :customDoorsOpenLabel LocalizedString,
              :doorsOpenLabel string},
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
   :sectionLabel string,
   :localizedIssuerName {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :redemptionIssuers [string],
   :review {:comments string},
   :id string,
   :kind string,
   :venue {:kind string,
           :name LocalizedString,
           :address LocalizedString},
   :customRowLabel {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :finePrint {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :gateLabel string,
   :seatLabel string,
   :customConfirmationCodeLabel {:kind string,
                                 :translatedValues [TranslatedString],
                                 :defaultValue TranslatedString},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :confirmationCodeLabel string,
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :customGateLabel {:kind string,
                     :translatedValues [TranslatedString],
                     :defaultValue TranslatedString},
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
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
