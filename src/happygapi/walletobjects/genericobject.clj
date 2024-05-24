(ns happygapi.walletobjects.genericobject
  "Google Wallet API: genericobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/genericobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:cardTitle {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :hasUsers boolean,
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
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :groupingInfo {:sortIndex integer, :groupingId string},
   :state string,
   :header {:kind string,
            :translatedValues [TranslatedString],
            :defaultValue TranslatedString},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :notifications {:expiryNotification ExpiryNotification,
                   :upcomingNotification UpcomingNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :subheader {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString}}
  
  Updates the generic object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:cardTitle {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :hasUsers boolean,
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
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :groupingInfo {:sortIndex integer, :groupingId string},
   :state string,
   :header {:kind string,
            :translatedValues [TranslatedString],
            :defaultValue TranslatedString},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :notifications {:expiryNotification ExpiryNotification,
                   :upcomingNotification UpcomingNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :subheader {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString}}
  
  Inserts a generic object with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:cardTitle {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString},
   :hasUsers boolean,
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
   :logo {:sourceUri ImageUri,
          :kind string,
          :contentDescription LocalizedString},
   :wideLogo {:sourceUri ImageUri,
              :kind string,
              :contentDescription LocalizedString},
   :groupingInfo {:sortIndex integer, :groupingId string},
   :state string,
   :header {:kind string,
            :translatedValues [TranslatedString],
            :defaultValue TranslatedString},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:end DateTime, :kind string, :start DateTime},
   :notifications {:expiryNotification ExpiryNotification,
                   :upcomingNotification UpcomingNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:webAppLinkInfo AppLinkDataAppLinkInfo,
                 :iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:sourceUri ImageUri,
               :kind string,
               :contentDescription LocalizedString},
   :subheader {:kind string,
               :translatedValues [TranslatedString],
               :defaultValue TranslatedString}}
  
  Updates the generic object referenced by the given object ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/list
  
  Required parameters: none
  
  Optional parameters: classId, maxResults, token
  
  Returns a list of all generic objects for a given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the generic object with the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject/{resourceId}"
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/addmessage
  
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
  
  Adds a message to the generic object referenced by the given object ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/genericObject/{resourceId}/addMessage"
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
