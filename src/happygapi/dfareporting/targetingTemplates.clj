(ns happygapi.dfareporting.targetingTemplates
  "Campaign Manager 360 API: targetingTemplates.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing targeting template. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/targetingTemplates"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one targeting template by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/targetingTemplates/{+id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Inserts a new targeting template."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/targetingTemplates"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates/list
  
  Required parameters: profileId
  
  Optional parameters: ids, searchString, advertiserId, maxResults, pageToken, sortField, sortOrder
  
  Retrieves a list of targeting templates, optionally filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/targetingTemplates"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/targetingTemplates/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing targeting template."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/targetingTemplates"
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
