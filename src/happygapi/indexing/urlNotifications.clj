(ns happygapi.indexing.urlNotifications
  "Web Search Indexing API: urlNotifications.
  Notifies Google Web Search when your web pages change.
  See: https://developers.google.com/search/apis/indexing-api/docs/reference/rest/v3/urlNotifications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn publish$
  "https://developers.google.com/search/apis/indexing-api/api/reference/rest/v3/urlNotifications/publish
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:url string, :type string, :notifyTime string}
  
  Notifies that a URL has been updated or deleted."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://indexing.googleapis.com/"
     "v3/urlNotifications:publish"
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

(defn getMetadata$
  "https://developers.google.com/search/apis/indexing-api/api/reference/rest/v3/urlNotifications/getMetadata
  
  Required parameters: none
  
  Optional parameters: url
  
  Gets metadata about a Web Document. This method can _only_ be used to query URLs that were previously seen in successful Indexing API notifications. Includes the latest `UrlNotification` received via this API."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://indexing.googleapis.com/"
     "v3/urlNotifications/metadata"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
