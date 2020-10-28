(ns happygapi.content.datafeeds
  "Content API for Shopping: datafeeds.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:format {:columnDelimiter string,
            :quotingMode string,
            :fileEncoding string},
   :name string,
   :fileName string,
   :fetchSchedule {:timeZone string,
                   :paused boolean,
                   :hour integer,
                   :minuteOfHour integer,
                   :password string,
                   :username string,
                   :dayOfMonth integer,
                   :weekday string,
                   :fetchUrl string},
   :targets [{:excludedDestinations [string],
              :language string,
              :includedDestinations [string],
              :country string}],
   :id string,
   :attributeLanguage string,
   :kind string,
   :contentType string}
  
  Registers a datafeed configuration with your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds"
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the configurations for datafeeds in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/get
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  
  Retrieves a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datafeedId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/delete
  
  Required parameters: merchantId, datafeedId
  
  Optional parameters: none
  
  Deletes a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datafeedId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:method string,
              :merchantId string,
              :batchId integer,
              :datafeedId string,
              :datafeed Datafeed}]}
  
  Deletes, fetches, gets, inserts and updates multiple datafeeds in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/datafeeds/batch"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/update
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:format {:columnDelimiter string,
            :quotingMode string,
            :fileEncoding string},
   :name string,
   :fileName string,
   :fetchSchedule {:timeZone string,
                   :paused boolean,
                   :hour integer,
                   :minuteOfHour integer,
                   :password string,
                   :username string,
                   :dayOfMonth integer,
                   :weekday string,
                   :fetchUrl string},
   :targets [{:excludedDestinations [string],
              :language string,
              :includedDestinations [string],
              :country string}],
   :id string,
   :attributeLanguage string,
   :kind string,
   :contentType string}
  
  Updates a datafeed configuration of your Merchant Center account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datafeedId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
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

(defn fetchnow$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/datafeeds/fetchnow
  
  Required parameters: merchantId, datafeedId
  
  Optional parameters: none
  
  Invokes a fetch for the datafeed in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datafeedId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/datafeeds/{datafeedId}/fetchNow"
     #{:datafeedId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
