(ns happygapi.dfareporting.accounts
  "Campaign Manager 360 API: accounts.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accounts/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one account by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accounts/{+id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accounts/list
  
  Required parameters: profileId
  
  Optional parameters: ids, searchString, active, maxResults, pageToken, sortField, sortOrder
  
  Retrieves the list of accounts, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accounts"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accounts/update
  
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
   :reportsConfiguration {:reportGenerationTimeZoneId string,
                          :exposureToConversionEnabled boolean,
                          :lookbackConfiguration LookbackConfiguration},
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
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accounts"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/accounts/patch
  
  Required parameters: profileId, id
  
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
   :reportsConfiguration {:reportGenerationTimeZoneId string,
                          :exposureToConversionEnabled boolean,
                          :lookbackConfiguration LookbackConfiguration},
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
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/accounts"
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
