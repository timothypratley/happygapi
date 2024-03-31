(ns happygapi.content.conversionsources
  "Content API for Shopping: conversionsources.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/create
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:conversionSourceId string,
   :googleAnalyticsLink {:propertyId string,
                         :attributionSettings AttributionSettings,
                         :propertyName string},
   :merchantCenterDestination {:destinationId string,
                               :attributionSettings AttributionSettings,
                               :displayName string,
                               :currencyCode string},
   :state string,
   :expireTime string}
  
  Creates a new conversion source."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources"
     #{:merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/patch
  
  Required parameters: merchantId, conversionSourceId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:conversionSourceId string,
   :googleAnalyticsLink {:propertyId string,
                         :attributionSettings AttributionSettings,
                         :propertyName string},
   :merchantCenterDestination {:destinationId string,
                               :attributionSettings AttributionSettings,
                               :displayName string,
                               :currencyCode string},
   :state string,
   :expireTime string}
  
  Updates information of an existing conversion source."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:conversionSourceId :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources/{conversionSourceId}"
     #{:conversionSourceId :merchantId}
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/delete
  
  Required parameters: merchantId, conversionSourceId
  
  Optional parameters: none
  
  Archives an existing conversion source. It will be recoverable for 30 days. This archiving behavior is not typical in the Content API and unique to this service."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:conversionSourceId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources/{conversionSourceId}"
     #{:conversionSourceId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn undelete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/undelete
  
  Required parameters: merchantId, conversionSourceId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Re-enables an archived conversion source."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:conversionSourceId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources/{conversionSourceId}:undelete"
     #{:conversionSourceId :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/get
  
  Required parameters: merchantId, conversionSourceId
  
  Optional parameters: none
  
  Fetches a conversion source."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:conversionSourceId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources/{conversionSourceId}"
     #{:conversionSourceId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/conversionsources/list
  
  Required parameters: merchantId
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Retrieves the list of conversion sources the caller has access to."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/conversionsources"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
