(ns happygapi.readerrevenuesubscriptionlinking.publications
  "Reader Revenue Subscription Linking API: publications.
  readerrevenuesubscriptionlinking.googleapis.com API.
  See: https://developers.google.com/news/subscribe/subscription-linking/overviewdocs/reference/rest/v1/publications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn readers-getEntitlements$
  "https://developers.google.com/news/subscribe/subscription-linking/overviewapi/reference/rest/v1/publications/readers/getEntitlements
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the reader entitlements for a publication reader. - Returns PERMISSION_DENIED if the caller does not have access. - Returns NOT_FOUND if the reader does not exist."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://readerrevenuesubscriptionlinking.googleapis.com/"
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

(defn readers-get$
  "https://developers.google.com/news/subscribe/subscription-linking/overviewapi/reference/rest/v1/publications/readers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a reader of a publication. Returns NOT_FOUND if the reader does not exist."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://readerrevenuesubscriptionlinking.googleapis.com/"
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

(defn readers-delete$
  "https://developers.google.com/news/subscribe/subscription-linking/overviewapi/reference/rest/v1/publications/readers/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Removes a publication reader, effectively severing the association with a Google user. If `force` is set to true, any entitlements for this reader will also be deleted. (Otherwise, the request will only work if the reader has no entitlements.) - If the reader does not exist, return NOT_FOUND. - Return FAILED_PRECONDITION if the force field is false (or unset) and entitlements are present."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://readerrevenuesubscriptionlinking.googleapis.com/"
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

(defn readers-updateEntitlements$
  "https://developers.google.com/news/subscribe/subscription-linking/overviewapi/reference/rest/v1/publications/readers/updateEntitlements
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :entitlements [{:productId string,
                   :detail string,
                   :subscriptionToken string,
                   :expireTime string}]}
  
  Updates the reader entitlements for a publication reader. The entire reader entitlements will be overwritten by the new reader entitlements in the payload, like a PUT. - Returns PERMISSION_DENIED if the caller does not have access. - Returns NOT_FOUND if the reader does not exist."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://readerrevenuesubscriptionlinking.googleapis.com/"
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
