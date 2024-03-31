(ns happygapi.walletobjects.offerclass
  "Google Wallet API: offerclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/addmessage
  
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
  
  Adds a message to the offer class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}/addMessage"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString,
             :id string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedFinePrint {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :localizedTitle {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :titleImage {:contentDescription LocalizedString,
                :kind string,
                :sourceUri ImageUri},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :wideTitleImage {:contentDescription LocalizedString,
                    :kind string,
                    :sourceUri ImageUri},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :provider string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :localizedDetails {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :countryCode string}
  
  Updates the offer class referenced by the given class ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the offer class with the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString,
             :id string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedFinePrint {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :localizedTitle {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :titleImage {:contentDescription LocalizedString,
                :kind string,
                :sourceUri ImageUri},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :wideTitleImage {:contentDescription LocalizedString,
                    :kind string,
                    :sourceUri ImageUri},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :provider string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :localizedDetails {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :countryCode string}
  
  Inserts an offer class with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:kind string,
             :uri string,
             :description string,
             :localizedDescription LocalizedString,
             :id string},
   :wordMark {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :reviewStatus string,
   :localizedFinePrint {:defaultValue TranslatedString,
                        :translatedValues [TranslatedString],
                        :kind string},
   :textModulesData [{:id string,
                      :localizedBody LocalizedString,
                      :localizedHeader LocalizedString,
                      :body string,
                      :header string}],
   :issuerName string,
   :localizedTitle {:defaultValue TranslatedString,
                    :translatedValues [TranslatedString],
                    :kind string},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:defaultValue TranslatedString,
                       :translatedValues [TranslatedString],
                       :kind string},
   :homepageUri {:kind string,
                 :uri string,
                 :description string,
                 :localizedDescription LocalizedString,
                 :id string},
   :titleImage {:contentDescription LocalizedString,
                :kind string,
                :sourceUri ImageUri},
   :callbackOptions {:url string, :updateRequestUrl string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:defaultValue TranslatedString,
                         :translatedValues [TranslatedString],
                         :kind string},
   :wideTitleImage {:contentDescription LocalizedString,
                    :kind string,
                    :sourceUri ImageUri},
   :id string,
   :kind string,
   :finePrint string,
   :classTemplateInfo {:listTemplateOverride ListTemplateOverride,
                       :detailsTemplateOverride DetailsTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails,
                       :cardTemplateOverride CardTemplateOverride},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:labelValueRows [LabelValueRow],
                    :showLastUpdateTime boolean},
   :provider string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :localizedDetails {:defaultValue TranslatedString,
                      :translatedValues [TranslatedString],
                      :kind string},
   :countryCode string}
  
  Updates the offer class referenced by the given class ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/list
  
  Required parameters: none
  
  Optional parameters: issuerId, token, maxResults
  
  Returns a list of all offer classes for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/offerClass"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
