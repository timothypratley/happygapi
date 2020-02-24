(ns happygapi.indexing.urlNotifications
  "Indexing API
  Notifies Google when your web pages change.
  See: https://developers.google.com/search/apis/indexing-api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn publish$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn getMetadata$
  "Required parameters: none
  
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
