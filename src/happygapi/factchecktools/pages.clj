(ns happygapi.factchecktools.pages
  "Fact Check Tools API: pages.
  
  See: https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :claimReviewAuthor {:imageUrl string, :name string},
   :claimReviewMarkups [{:claimDate string,
                         :claimLocation string,
                         :claimReviewed string,
                         :url string,
                         :rating GoogleFactcheckingFactchecktoolsV1alpha1ClaimRating,
                         :claimAppearances [string],
                         :claimAuthor GoogleFactcheckingFactchecktoolsV1alpha1ClaimAuthor,
                         :claimFirstAppearance string}],
   :pageUrl string,
   :versionId string,
   :publishDate string}
  
  Update for all `ClaimReview` markup on a page Note that this is a full update. To retain the existing `ClaimReview` markup on a page, first perform a Get operation, then modify the returned markup, and finally call Update with the entire `ClaimReview` markup as the body."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
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

(defn create$
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :claimReviewAuthor {:imageUrl string, :name string},
   :claimReviewMarkups [{:claimDate string,
                         :claimLocation string,
                         :claimReviewed string,
                         :url string,
                         :rating GoogleFactcheckingFactchecktoolsV1alpha1ClaimRating,
                         :claimAppearances [string],
                         :claimAuthor GoogleFactcheckingFactchecktoolsV1alpha1ClaimAuthor,
                         :claimFirstAppearance string}],
   :pageUrl string,
   :versionId string,
   :publishDate string}
  
  Create `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/pages"
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

(defn delete$
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete all `ClaimReview` markup on a page."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/{+name}"
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
  "https://developers.google.com/fact-check/tools/api/api/reference/rest/v1alpha1/pages/list
  
  Required parameters: none
  
  Optional parameters: offset, pageSize, pageToken, url, organization
  
  List the `ClaimReview` markup pages for a specific URL or for an organization."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://factchecktools.googleapis.com/"
     "v1alpha1/pages"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
