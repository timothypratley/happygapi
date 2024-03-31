(ns happygapi.dfareporting.advertiserLandingPages
  "Campaign Manager 360 API: advertiserLandingPages.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one landing page by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertiserLandingPages/{+id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :url string,
   :archived boolean,
   :advertiserId string,
   :deepLinks [{:kind string,
                :appUrl string,
                :fallbackUrl string,
                :remarketingListIds [string],
                :mobileApp MobileApp}],
   :kind string}
  
  Inserts a new landing page."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertiserLandingPages"
     #{:profileId}
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages/list
  
  Required parameters: profileId
  
  Optional parameters: archived, campaignIds, ids, searchString, pageToken, sortField, advertiserIds, sortOrder, subaccountId, maxResults
  
  Retrieves a list of landing pages."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertiserLandingPages"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :url string,
   :archived boolean,
   :advertiserId string,
   :deepLinks [{:kind string,
                :appUrl string,
                :fallbackUrl string,
                :remarketingListIds [string],
                :mobileApp MobileApp}],
   :kind string}
  
  Updates an existing landing page."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertiserLandingPages"
     #{:profileId}
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/advertiserLandingPages/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :url string,
   :archived boolean,
   :advertiserId string,
   :deepLinks [{:kind string,
                :appUrl string,
                :fallbackUrl string,
                :remarketingListIds [string],
                :mobileApp MobileApp}],
   :kind string}
  
  Updates an existing advertiser. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/advertiserLandingPages"
     #{:id :profileId}
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
