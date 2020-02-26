(ns happygapi.androidenterprise.storelayoutclusters
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
  "Required parameters: clusterId, enterpriseId, pageId
  
  Optional parameters: none
  
  Deletes a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId" "clusterId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{"pageId" "enterpriseId" "clusterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: clusterId, enterpriseId, pageId
  
  Optional parameters: none
  
  Retrieves details of a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId" "clusterId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{"pageId" "enterpriseId" "clusterId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Inserts a new cluster in a page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters"
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

(defn list$
  "Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Retrieves the details of all clusters on the specified page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters"
     #{"pageId" "enterpriseId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: clusterId, enterpriseId, pageId
  
  Optional parameters: none
  
  Updates a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"pageId" "enterpriseId" "clusterId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{"pageId" "enterpriseId" "clusterId"}
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
