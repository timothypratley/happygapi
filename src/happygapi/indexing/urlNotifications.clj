(ns happygapi.indexing.urlNotifications
  "Indexing API: urlNotifications.
  Notifies Google when your web pages change.
  See: https://developers.google.com/search/apis/indexing-api/api/reference/rest/v3/urlNotifications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn publish$
  "https://developers.google.com/search/apis/indexing-api/api/reference/rest/v3/urlNotifications/publish
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:url string, :notifyTime string, :type string}
  
  Notifies that a URL has been updated or deleted."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://indexing.googleapis.com/"
     "v3/urlNotifications:publish"
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

(defn getMetadata$
  "https://developers.google.com/search/apis/indexing-api/api/reference/rest/v3/urlNotifications/getMetadata
  
  Required parameters: none
  
  Optional parameters: url
  Gets metadata about a Web Document. This method can _only_ be used to query
  URLs that were previously seen in successful Indexing API notifications.
  Includes the latest `UrlNotification` received via this API."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://indexing.googleapis.com/"
     "v3/urlNotifications/metadata"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
