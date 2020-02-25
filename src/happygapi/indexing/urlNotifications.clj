(ns happygapi.indexing.urlNotifications
  "Indexing API
  Notifies Google when your web pages change.
  See: https://developers.google.com/search/apis/indexing-api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "indexing_schema.edn"))))

(defn publish$
  "Required parameters: none
  
  Optional parameters: none
  
  Notifies that a URL has been updated or deleted."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: url
  
  Gets metadata about a Web Document. This method can _only_ be used to query
  URLs that were previously seen in successful Indexing API notifications.
  Includes the latest `UrlNotification` received via this API."
  {:scopes ["https://www.googleapis.com/auth/indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
