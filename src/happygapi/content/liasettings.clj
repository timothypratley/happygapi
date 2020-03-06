(ns happygapi.content.liasettings
  "Content API for Shopping: liasettings.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/get
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  Retrieves the LIA settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}"
     #{:accountId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setinventoryverificationcontact$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/setinventoryverificationcontact
  
  Required parameters: accountId, contactEmail, contactName, country, language, merchantId
  
  Optional parameters: none
  Sets the inventory verification contract for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:contactName
            :contactEmail
            :language
            :accountId
            :country
            :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/setinventoryverificationcontact"
     #{:contactName
       :contactEmail
       :language
       :accountId
       :country
       :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn requestinventoryverification$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/requestinventoryverification
  
  Required parameters: accountId, country, merchantId
  
  Optional parameters: none
  Requests inventory validation for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :country :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/requestinventoryverification/{country}"
     #{:accountId :country :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/update
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :countrySettings [{:about LiaAboutPageSettings,
                      :country string,
                      :hostedLocalStorefrontActive boolean,
                      :inventory LiaInventorySettings,
                      :onDisplayToOrder LiaOnDisplayToOrderSettings,
                      :posDataProvider LiaPosDataProvider,
                      :storePickupActive boolean}],
   :kind string}
  
  Updates the LIA settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}"
     #{:accountId :merchantId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn requestgmbaccess$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/requestgmbaccess
  
  Required parameters: accountId, gmbEmail, merchantId
  
  Optional parameters: none
  Requests access to a specified Google My Business account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:gmbEmail :accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/requestgmbaccess"
     #{:gmbEmail :accountId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  Lists the LIA settings of the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setposdataprovider$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/setposdataprovider
  
  Required parameters: accountId, country, merchantId
  
  Optional parameters: posDataProviderId, posExternalAccountId
  Sets the POS data provider for the specified country."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :country :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/setposdataprovider"
     #{:accountId :country :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listposdataproviders$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/listposdataproviders
  
  Required parameters: none
  
  Optional parameters: none
  Retrieves the list of POS data providers that have active settings for the all eiligible countries."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "liasettings/posdataproviders"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getaccessiblegmbaccounts$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/getaccessiblegmbaccounts
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  Retrieves the list of accessible Google My Business accounts."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/liasettings/{accountId}/accessiblegmbaccounts"
     #{:accountId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/liasettings/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:contactName string,
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
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "liasettings/batch"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
