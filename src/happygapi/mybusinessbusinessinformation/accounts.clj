(ns happygapi.mybusinessbusinessinformation.accounts
  "My Business Business Information API: accounts.
  The My Business Business Information API provides an interface for managing business information. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/docs/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/locations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, readMask
  
  Lists the locations for the specified account."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+parent}/locations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-create$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/locations/create
  
  Required parameters: parent
  
  Optional parameters: validateOnly, requestId
  
  Body: 
  
  {:serviceItems [{:structuredServiceItem StructuredServiceItem,
                   :freeFormServiceItem FreeFormServiceItem,
                   :price Money}],
   :labels [string],
   :regularHours {:periods [TimePeriod]},
   :moreHours [{:hoursTypeId string, :periods [TimePeriod]}],
   :name string,
   :specialHours {:specialHourPeriods [SpecialHourPeriod]},
   :phoneNumbers {:primaryPhone string, :additionalPhones [string]},
   :serviceArea {:businessType string,
                 :places Places,
                 :regionCode string},
   :title string,
   :categories {:primaryCategory Category,
                :additionalCategories [Category]},
   :languageCode string,
   :relationshipData {:parentLocation RelevantLocation,
                      :childrenLocations [RelevantLocation],
                      :parentChain string},
   :websiteUri string,
   :storeCode string,
   :adWordsLocationExtensions {:adPhone string},
   :openInfo {:status string, :canReopen boolean, :openingDate Date},
   :latlng {:latitude number, :longitude number},
   :metadata {:duplicateLocation string,
              :canDelete boolean,
              :canOperateLocalPost boolean,
              :canOperateLodgingData boolean,
              :newReviewUri string,
              :hasPendingEdits boolean,
              :mapsUri string,
              :hasVoiceOfMerchant boolean,
              :hasGoogleUpdated boolean,
              :canOperateHealthData boolean,
              :canModifyServiceList boolean,
              :canHaveFoodMenus boolean,
              :placeId string,
              :canHaveBusinessCalls boolean},
   :profile {:description string},
   :storefrontAddress {:sortingCode string,
                       :locality string,
                       :revision integer,
                       :administrativeArea string,
                       :addressLines [string],
                       :organization string,
                       :recipients [string],
                       :languageCode string,
                       :regionCode string,
                       :postalCode string,
                       :sublocality string}}
  
  Creates a new Location that will be owned by the logged in user."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+parent}/locations"
     #{:parent}
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
