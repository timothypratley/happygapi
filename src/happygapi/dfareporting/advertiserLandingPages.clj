(ns happygapi.dfareporting.advertiserLandingPages
  "DCM/DFA Reporting And Trafficking API: advertiserLandingPages.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :url string,
   :kind string,
   :name string,
   :advertiserId string,
   :deepLinks [{:appUrl string,
                :mobileApp MobileApp,
                :remarketingListIds [string],
                :fallbackUrl string,
                :kind string}],
   :archived boolean}
  
  Updates an existing advertiser landing page. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertiserLandingPages"
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :url string,
   :kind string,
   :name string,
   :advertiserId string,
   :deepLinks [{:appUrl string,
                :mobileApp MobileApp,
                :remarketingListIds [string],
                :fallbackUrl string,
                :kind string}],
   :archived boolean}
  
  Updates an existing landing page."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertiserLandingPages"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :url string,
   :kind string,
   :name string,
   :advertiserId string,
   :deepLinks [{:appUrl string,
                :mobileApp MobileApp,
                :remarketingListIds [string],
                :fallbackUrl string,
                :kind string}],
   :archived boolean}
  
  Inserts a new landing page."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertiserLandingPages"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one landing page by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertiserLandingPages/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/advertiserLandingPages/list
  
  Required parameters: profileId
  
  Optional parameters: archived, campaignIds, ids, searchString, pageToken, sortField, advertiserIds, sortOrder, subaccountId, maxResults
  
  Retrieves a list of landing pages."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/advertiserLandingPages"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
