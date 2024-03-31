(ns happygapi.mybusinessbusinessinformation.googleLocations
  "My Business Business Information API: googleLocations.
  The My Business Business Information API provides an interface for managing business information. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/googleLocations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/my-business/api/reference/rest/v1/googleLocations/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:location {:serviceItems [ServiceItem],
              :labels [string],
              :regularHours BusinessHours,
              :moreHours [MoreHours],
              :name string,
              :specialHours SpecialHours,
              :phoneNumbers PhoneNumbers,
              :serviceArea ServiceAreaBusiness,
              :title string,
              :categories Categories,
              :languageCode string,
              :relationshipData RelationshipData,
              :websiteUri string,
              :storeCode string,
              :adWordsLocationExtensions AdWordsLocationExtensions,
              :openInfo OpenInfo,
              :latlng LatLng,
              :metadata Metadata,
              :profile Profile,
              :storefrontAddress PostalAddress},
   :query string,
   :pageSize integer}
  
  Search all of the possible locations that are a match to the specified request."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/googleLocations:search"
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
