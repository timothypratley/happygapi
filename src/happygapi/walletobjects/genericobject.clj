(ns happygapi.walletobjects.genericobject
  "Google Wallet API: genericobject.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:cardTitle {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
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
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :header {:defaultValue TranslatedString,
            :translatedValues [TranslatedString],
            :kind string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :notifications {:upcomingNotification UpcomingNotification,
                   :expiryNotification ExpiryNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :subheader {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string}}
  
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
  
  {:cardTitle {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
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
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :header {:defaultValue TranslatedString,
            :translatedValues [TranslatedString],
            :kind string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :notifications {:upcomingNotification UpcomingNotification,
                   :expiryNotification ExpiryNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :subheader {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string}}
  
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

(defn addmessage$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/addmessage
  
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

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/list
  
  Required parameters: none
  
  Optional parameters: classId, token, maxResults
  
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/genericobject/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:cardTitle {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string},
   :hasUsers boolean,
   :smartTapRedemptionValue string,
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
   :logo {:contentDescription LocalizedString,
          :kind string,
          :sourceUri ImageUri},
   :wideLogo {:contentDescription LocalizedString,
              :kind string,
              :sourceUri ImageUri},
   :groupingInfo {:groupingId string, :sortIndex integer},
   :state string,
   :header {:defaultValue TranslatedString,
            :translatedValues [TranslatedString],
            :kind string},
   :linksModuleData {:uris [Uri]},
   :imageModulesData [{:mainImage Image, :id string}],
   :validTimeInterval {:start DateTime, :kind string, :end DateTime},
   :notifications {:upcomingNotification UpcomingNotification,
                   :expiryNotification ExpiryNotification},
   :hexBackgroundColor string,
   :id string,
   :classId string,
   :passConstraints {:nfcConstraint [string],
                     :screenshotEligibility string},
   :appLinkData {:iosAppLinkInfo AppLinkDataAppLinkInfo,
                 :webAppLinkInfo AppLinkDataAppLinkInfo,
                 :androidAppLinkInfo AppLinkDataAppLinkInfo},
   :genericType string,
   :heroImage {:contentDescription LocalizedString,
               :kind string,
               :sourceUri ImageUri},
   :subheader {:defaultValue TranslatedString,
               :translatedValues [TranslatedString],
               :kind string}}
  
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
