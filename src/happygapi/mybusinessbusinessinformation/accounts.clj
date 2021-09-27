(ns happygapi.mybusinessbusinessinformation.accounts
  "My Business Business Information API: accounts.
  The My Business Business Information API provides an interface for managing business information on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/locations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken, readMask, orderBy
  
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
  
  Optional parameters: requestId, validateOnly
  
  Body: 
  
  {:serviceItems [{:price Money,
                   :structuredServiceItem StructuredServiceItem,
                   :freeFormServiceItem FreeFormServiceItem}],
   :labels [string],
   :regularHours {:periods [TimePeriod]},
   :moreHours [{:periods [TimePeriod], :hoursTypeId string}],
   :name string,
   :specialHours {:specialHourPeriods [SpecialHourPeriod]},
   :phoneNumbers {:additionalPhones [string], :primaryPhone string},
   :serviceArea {:regionCode string,
                 :businessType string,
                 :places Places},
   :title string,
   :categories {:primaryCategory Category,
                :additionalCategories [Category]},
   :languageCode string,
   :relationshipData {:childrenLocations [RelevantLocation],
                      :parentLocation RelevantLocation,
                      :parentChain string},
   :websiteUri string,
   :storeCode string,
   :adWordsLocationExtensions {:adPhone string},
   :openInfo {:canReopen boolean, :status string, :openingDate Date},
   :latlng {:longitude number, :latitude number},
   :metadata {:duplicateLocation string,
              :canDelete boolean,
              :canOperateLocalPost boolean,
              :canOperateLodgingData boolean,
              :newReviewUri string,
              :hasPendingEdits boolean,
              :mapsUri string,
              :hasGoogleUpdated boolean,
              :canOperateHealthData boolean,
              :canModifyServiceList boolean,
              :canHaveFoodMenus boolean,
              :placeId string},
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
