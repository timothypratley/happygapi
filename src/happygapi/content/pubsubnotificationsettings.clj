(ns happygapi.content.pubsubnotificationsettings
  "Content API for Shopping: pubsubnotificationsettings.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/pubsubnotificationsettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pubsubnotificationsettings/get
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves a Merchant Center account's pubsub notification settings."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pubsubnotificationsettings"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pubsubnotificationsettings/update
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :cloudTopicName string, :registeredEvents [string]}
  
  Register a Merchant Center account for pubsub notifications. Note that cloud topic name shouldn't be provided as part of the request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pubsubnotificationsettings"
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
