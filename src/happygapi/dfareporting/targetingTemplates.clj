(ns happygapi.dfareporting.targetingTemplates
  "DCM/DFA Reporting And Trafficking API: targetingTemplates.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one targeting template by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/targetingTemplates/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Inserts a new targeting template."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/targetingTemplates"
     #{:profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates/list
  
  Required parameters: profileId
  
  Optional parameters: advertiserId, ids, maxResults, pageToken, searchString, sortField, sortOrder
  Retrieves a list of targeting templates, optionally filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/targetingTemplates"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing targeting template. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/targetingTemplates"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/targetingTemplates/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :id string,
   :kind string,
   :listTargetingExpression {:expression string},
   :subaccountId string,
   :accountId string}
  
  Updates an existing targeting template."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/targetingTemplates"
     #{:profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
