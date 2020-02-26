(ns happygapi.factchecktools.pages
  "Fact Check Tools API
  
  See: https://developers.google.com/fact-check/tools/api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "factchecktools_schema.edn"))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Create `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/pages"
     #{}
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

(defn delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Delete all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Get all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: pageToken, organization, pageSize, url, offset
  
  List the `ClaimReview` markup pages for a specific URL or for an
  organization."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/pages"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: name
  
  Optional parameters: none
  
  Update for all `ClaimReview` markup on a page
  
  Note that this is a full update. To retain the existing `ClaimReview`
  markup on a page, first perform a Get operation, then modify the returned
  markup, and finally call Update with the entire `ClaimReview` markup as the
  body."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
     #{"name"}
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
