(ns happygapi.factchecktools.pages
  "Fact Check Tools API
  
  See: https://developers.google.com/fact-check/tools/api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: name
  
  Get all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
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
  
  List the `ClaimReview` markup pages for a specific URL or for an
  organization."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  Update for all `ClaimReview` markup on a page
  
  Note that this is a full update. To retain the existing `ClaimReview`
  markup on a page, first perform a Get operation, then modify the returned
  markup, and finally call Update with the entire `ClaimReview` markup as the
  body."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
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
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Create `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
      :body body}
     auth))))

(defn delete$
  "Required parameters: name
  
  Delete all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
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
