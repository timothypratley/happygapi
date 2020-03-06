(ns happygapi.content.datafeeds
  "Content API for Shopping: datafeeds.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :datafeed Datafeed,
              :datafeedId string,
              :merchantId string,
              :method string}]}
  
  Deletes, fetches, gets, inserts and updates multiple datafeeds in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "datafeeds/batch"
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

(defn delete$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/delete
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  Deletes a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datafeedId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn fetchnow$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/fetchnow
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  Invokes a fetch for the datafeed in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datafeedId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}/fetchNow"
     #{:datafeedId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/get
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  Retrieves a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datafeedId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:format {:columnDelimiter string,
            :fileEncoding string,
            :quotingMode string},
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
   :targets [{:country string,
              :excludedDestinations [string],
              :includedDestinations [string],
              :language string}],
   :id string,
   :attributeLanguage string,
   :kind string,
   :contentType string}
  
  Registers a datafeed configuration with your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds"
     #{:merchantId}
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

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  Lists the configurations for datafeeds in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/datafeeds/update
  
  Required parameters: datafeedId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:format {:columnDelimiter string,
            :fileEncoding string,
            :quotingMode string},
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
   :targets [{:country string,
              :excludedDestinations [string],
              :includedDestinations [string],
              :language string}],
   :id string,
   :attributeLanguage string,
   :kind string,
   :contentType string}
  
  Updates a datafeed configuration of your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:datafeedId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{:datafeedId :merchantId}
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
