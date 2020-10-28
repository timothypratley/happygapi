(ns happygapi.cloudasset.feeds
  "Cloud Asset API: feeds.
  The cloud asset API manages the history and inventory of cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:feedId string,
   :feed {:condition Expr,
          :assetNames [string],
          :feedOutputConfig FeedOutputConfig,
          :contentType string,
          :name string,
          :assetTypes [string]}}
  
  Creates a feed in a parent project/folder/organization to listen to its asset updates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}/feeds"
     #{:parent}
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about an asset feed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an asset feed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all asset feeds in a parent project/folder/organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}/feeds"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/feeds/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:feed {:condition Expr,
          :assetNames [string],
          :feedOutputConfig FeedOutputConfig,
          :contentType string,
          :name string,
          :assetTypes [string]},
   :updateMask string}
  
  Updates an asset feed configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
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
