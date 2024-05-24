(ns happygapi.walletobjects.offerclass
  "Google Wallet API: offerclass.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/offerclass"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/list
  
  Required parameters: none
  
  Optional parameters: maxResults, token, issuerId
  
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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:id string,
             :uri string,
             :localizedDescription LocalizedString,
             :kind string,
             :description string},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :localizedTitle {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :titleImage {:sourceUri ImageUri,
                :kind string,
                :contentDescription LocalizedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :wideTitleImage {:sourceUri ImageUri,
                    :kind string,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :localizedDetails {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
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
  
  {:helpUri {:id string,
             :uri string,
             :localizedDescription LocalizedString,
             :kind string,
             :description string},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :localizedTitle {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :titleImage {:sourceUri ImageUri,
                :kind string,
                :contentDescription LocalizedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :wideTitleImage {:sourceUri ImageUri,
                    :kind string,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :localizedDetails {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
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

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:helpUri {:id string,
             :uri string,
             :localizedDescription LocalizedString,
             :kind string,
             :description string},
   :wordMark {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :reviewStatus string,
   :localizedFinePrint {:kind string,
                        :translatedValues [TranslatedString],
                        :defaultValue TranslatedString},
   :textModulesData [{:localizedHeader LocalizedString,
                      :header string,
                      :localizedBody LocalizedString,
                      :id string,
                      :body string}],
   :issuerName string,
   :localizedTitle {:kind string,
                    :translatedValues [TranslatedString],
                    :defaultValue TranslatedString},
   :redemptionChannel string,
   :securityAnimation {:animationType string},
   :multipleDevicesAndHoldersAllowedStatus string,
   :localizedProvider {:kind string,
                       :translatedValues [TranslatedString],
                       :defaultValue TranslatedString},
   :homepageUri {:id string,
                 :uri string,
                 :localizedDescription LocalizedString,
                 :kind string,
                 :description string},
   :titleImage {:sourceUri ImageUri,
                :kind string,
                :contentDescription LocalizedString},
   :callbackOptions {:updateRequestUrl string, :url string},
   :title string,
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
   :details string,
   :redemptionIssuers [string],
   :review {:comments string},
   :localizedShortTitle {:kind string,
                         :translatedValues [TranslatedString],
                         :defaultValue TranslatedString},
   :wideTitleImage {:sourceUri ImageUri,
                    :kind string,
                    :contentDescription LocalizedString},
   :id string,
   :kind string,
   :finePrint string,
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :classTemplateInfo {:detailsTemplateOverride DetailsTemplateOverride,
                       :listTemplateOverride ListTemplateOverride,
                       :cardTemplateOverride CardTemplateOverride,
                       :cardBarcodeSectionDetails CardBarcodeSectionDetails},
   :shortTitle string,
   :enableSmartTap boolean,
   :version string,
   :viewUnlockRequirement string,
   :infoModuleData {:showLastUpdateTime boolean,
                    :labelValueRows [LabelValueRow]},
   :provider string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :localizedDetails {:kind string,
                      :translatedValues [TranslatedString],
                      :defaultValue TranslatedString},
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/offerclass/addmessage
  
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
