(ns happygapi.content.liasettings
  "Content API for Shopping: liasettings.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/liasettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/get
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Retrieves the LIA settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setinventoryverificationcontact$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/setinventoryverificationcontact
  
  Required parameters: merchantId, accountId, country, language, contactName, contactEmail
  
  Optional parameters: none
  
  Sets the inventory verification contract for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:contactName
            :contactEmail
            :language
            :accountId
            :country
            :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/setinventoryverificationcontact"
     #{:contactName
       :contactEmail
       :language
       :accountId
       :country
       :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setomnichannelexperience$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/setomnichannelexperience
  
  Required parameters: merchantId, accountId
  
  Optional parameters: country, lsfType, pickupTypes
  
  Sets the omnichannel experience for the specified country. Only supported for merchants whose POS data provider is trusted to enable the corresponding experience. For more context, see these help articles [about LFP](https://support.google.com/merchants/answer/7676652) and [how to get started](https://support.google.com/merchants/answer/7676578) with it."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/setomnichannelexperience"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn requestinventoryverification$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/requestinventoryverification
  
  Required parameters: merchantId, accountId, country
  
  Optional parameters: none
  
  Requests inventory validation for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:accountId :country :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/requestinventoryverification/{country}"
     #{:accountId :country :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/update
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :countrySettings [{:country string,
                      :inventory LiaInventorySettings,
                      :onDisplayToOrder LiaOnDisplayToOrderSettings,
                      :hostedLocalStorefrontActive boolean,
                      :storePickupActive boolean,
                      :about LiaAboutPageSettings,
                      :posDataProvider LiaPosDataProvider,
                      :omnichannelExperience LiaOmnichannelExperience}],
   :kind string}
  
  Updates the LIA settings of the account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}"
     #{:accountId :merchantId}
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

(defn requestgmbaccess$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/requestgmbaccess
  
  Required parameters: merchantId, accountId, gmbEmail
  
  Optional parameters: none
  
  Requests access to a specified Business Profile."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:gmbEmail :accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/requestgmbaccess"
     #{:gmbEmail :accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the LIA settings of the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setposdataprovider$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/setposdataprovider
  
  Required parameters: merchantId, accountId, country
  
  Optional parameters: posDataProviderId, posExternalAccountId
  
  Sets the POS data provider for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:accountId :country :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/setposdataprovider"
     #{:accountId :country :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listposdataproviders$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/listposdataproviders
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves the list of POS data providers that have active settings for the all eiligible countries."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "liasettings/posdataproviders"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getaccessiblegmbaccounts$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/getaccessiblegmbaccounts
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Retrieves the list of accessible Business Profiles."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/accessiblegmbaccounts"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/liasettings/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:contactName string,
              :omnichannelExperience LiaOmnichannelExperience,
              :posDataProviderId string,
              :method string,
              :gmbEmail string,
              :posExternalAccountId string,
              :contactEmail string,
              :batchId integer,
              :accountId string,
              :country string,
              :merchantId string,
              :liaSettings LiaSettings}]}
  
  Retrieves and/or updates the LIA settings of multiple accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "liasettings/batch"
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
