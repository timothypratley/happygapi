(ns happygapi.mybusinessbusinessinformation.locations
  "My Business Business Information API: locations.
  The My Business Business Information API provides an interface for managing business information. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn updateAttributes$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/updateAttributes
  
  Required parameters: name
  
  Optional parameters: attributeMask
  
  Body: 
  
  {:name string,
   :attributes [{:name string,
                 :valueType string,
                 :values [any],
                 :repeatedEnumValue RepeatedEnumAttributeValue,
                 :uriValues [UriAttributeValue]}]}
  
  Update attributes for a given location."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn getAttributes$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/getAttributes
  
  Required parameters: name
  
  Optional parameters: none
  
  Looks up all the attributes set for a given location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn get$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/get
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Returns the specified location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn getGoogleUpdated$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/getGoogleUpdated
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Gets the Google-updated version of the specified location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+name}:getGoogleUpdated"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
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
  
  Updates the specified location."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a location. If this location cannot be deleted using the API and it is marked so in the `google.mybusiness.businessinformation.v1.LocationState`, use the [Google Business Profile](https://business.google.com/manage/) website."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
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

(defn attributes-getGoogleUpdated$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/attributes/getGoogleUpdated
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Google-updated version of the specified location."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+name}:getGoogleUpdated"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
