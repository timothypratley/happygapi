(ns happygapi.androidenterprise.storelayoutpages
  "Google Play EMM API
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidenterprise_schema.edn"))))

(defn delete$
  "Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Deletes a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{"pageId" "enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Retrieves details of a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{"pageId" "enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: enterpriseId
  
  Optional parameters: none
  
  Inserts a new store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages"
     #{"enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: enterpriseId
  
  Optional parameters: none
  
  Retrieves the details of all pages in the store."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages"
     #{"enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Updates the content of a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{"pageId" "enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
