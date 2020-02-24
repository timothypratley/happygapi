(ns happygapi.content.datafeeds
  "Content API for Shopping
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-content"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn custombatch$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn delete$
  "Required parameters: datafeedId,merchantId
  
  Deletes a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"datafeedId" "merchantId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{"datafeedId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn fetchnow$
  "Required parameters: datafeedId,merchantId
  
  Invokes a fetch for the datafeed in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"datafeedId" "merchantId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}/fetchNow"
     #{"datafeedId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn get$
  "Required parameters: datafeedId,merchantId
  
  Retrieves a datafeed configuration from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"datafeedId" "merchantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{"datafeedId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: merchantId
  
  Registers a datafeed configuration with your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"merchantId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds"
     #{"merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: merchantId
  
  Lists the configurations for datafeeds in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"merchantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds"
     #{"merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: datafeedId,merchantId
  
  Updates a datafeed configuration of your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"datafeedId" "merchantId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/datafeeds/{datafeedId}"
     #{"datafeedId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
