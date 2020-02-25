(ns happygapi.iap.v1
  "Cloud Identity-Aware Proxy API
  Controls access to cloud applications running on Google Cloud Platform.
  See: https://cloud.google.com/iap"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas (edn/read-string (slurp (io/resource "iap_schema.edn"))))

(defn $
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy for an Identity-Aware Proxy protected
  resource. Replaces any existing policy.
  More information about managing access via IAP can be found at:
  https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn $
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that a caller has on the Identity-Aware Proxy protected
  resource.
  More information about managing access via IAP can be found at:
  https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn $
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates the IAP settings on a particular IAP protected resource. It
  replaces all fields unless the `update_mask` is set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}:iapSettings"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the IAP settings on a particular IAP protected resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+name}:iapSettings"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for an Identity-Aware Proxy protected
  resource.
  More information about managing access via IAP can be found at:
  https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iap.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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
