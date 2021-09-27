(ns happygapi.mybusinessbusinessinformation.locations
  "My Business Business Information API: locations.
  The My Business Business Information API provides an interface for managing business information on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn updateAttributes$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/updateAttributes
  
  Required parameters: name
  
  Optional parameters: attributeMask
  
  Body: 
  
  {:attributes [{:values [any],
                 :name string,
                 :repeatedEnumValue RepeatedEnumAttributeValue,
                 :uriValues [UriAttributeValue],
                 :valueType string}],
   :name string}
  
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

(defn clearLocationAssociation$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/clearLocationAssociation
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Clears an association between a location and its place ID. This operation is only valid if the location is unverified."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+name}:clearLocationAssociation"
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

(defn delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a location. If this location cannot be deleted using the API and it is marked so in the `google.mybusiness.businessinformation.v1.LocationState`, use the [Google My Business](https://business.google.com/manage/) website."
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

(defn patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
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

(defn associate$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/associate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:placeId string}
  
  Associates a location to a place ID. Any previous association is overwritten. This operation is only valid if the location is unverified. The association must be valid, that is, it appears in the list of `SearchGoogleLocations`."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/{+name}:associate"
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
