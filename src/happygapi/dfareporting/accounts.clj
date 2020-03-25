(ns happygapi.dfareporting.accounts
  "DCM/DFA Reporting And Trafficking API: accounts.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accounts/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one account by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accounts/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accounts/list
  
  Required parameters: profileId
  
  Optional parameters: active, ids, maxResults, pageToken, searchString, sortField, sortOrder
  
  Retrieves the list of accounts, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accounts"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accounts/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :activeViewOptOut boolean,
   :accountPermissionIds [string],
   :locale string,
   :name string,
   :activeAdsLimitTier string,
   :maximumImageSize string,
   :accountProfile string,
   :reportsConfiguration {:exposureToConversionEnabled boolean,
                          :lookbackConfiguration LookbackConfiguration,
                          :reportGenerationTimeZoneId string},
   :availablePermissionIds [string],
   :active boolean,
   :defaultCreativeSizeId string,
   :id string,
   :kind string,
   :currencyId string,
   :countryId string,
   :teaserSizeLimit string,
   :shareReportsWithTwitter boolean,
   :nielsenOcrEnabled boolean}
  
  Updates an existing account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accounts"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accounts/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :activeViewOptOut boolean,
   :accountPermissionIds [string],
   :locale string,
   :name string,
   :activeAdsLimitTier string,
   :maximumImageSize string,
   :accountProfile string,
   :reportsConfiguration {:exposureToConversionEnabled boolean,
                          :lookbackConfiguration LookbackConfiguration,
                          :reportGenerationTimeZoneId string},
   :availablePermissionIds [string],
   :active boolean,
   :defaultCreativeSizeId string,
   :id string,
   :kind string,
   :currencyId string,
   :countryId string,
   :teaserSizeLimit string,
   :shareReportsWithTwitter boolean,
   :nielsenOcrEnabled boolean}
  
  Updates an existing account."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accounts"
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
