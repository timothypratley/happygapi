(ns happygapi.dfareporting.floodlightConfigurations
  "Campaign Manager 360 API: floodlightConfigurations.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightConfigurations/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:customViewabilityMetric {:id string,
                             :name string,
                             :configuration CustomViewabilityMetricConfiguration},
   :inAppAttributionTrackingEnabled boolean,
   :thirdPartyAuthenticationTokens [{:name string, :value string}],
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :userDefinedVariableConfigurations [{:variableType string,
                                        :dataType string,
                                        :reportName string}],
   :naturalSearchConversionAttributionOption string,
   :analyticsDataSharingEnabled boolean,
   :advertiserId string,
   :id string,
   :firstDayOfWeek string,
   :kind string,
   :omnitureSettings {:omnitureIntegrationEnabled boolean,
                      :omnitureCostDataEnabled boolean},
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :tagSettings {:imageTagEnabled boolean, :dynamicTagEnabled boolean},
   :subaccountId string,
   :accountId string,
   :exposureToConversionEnabled boolean}
  
  Updates an existing floodlight configuration."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightConfigurations"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightConfigurations/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:customViewabilityMetric {:id string,
                             :name string,
                             :configuration CustomViewabilityMetricConfiguration},
   :inAppAttributionTrackingEnabled boolean,
   :thirdPartyAuthenticationTokens [{:name string, :value string}],
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :userDefinedVariableConfigurations [{:variableType string,
                                        :dataType string,
                                        :reportName string}],
   :naturalSearchConversionAttributionOption string,
   :analyticsDataSharingEnabled boolean,
   :advertiserId string,
   :id string,
   :firstDayOfWeek string,
   :kind string,
   :omnitureSettings {:omnitureIntegrationEnabled boolean,
                      :omnitureCostDataEnabled boolean},
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :tagSettings {:imageTagEnabled boolean, :dynamicTagEnabled boolean},
   :subaccountId string,
   :accountId string,
   :exposureToConversionEnabled boolean}
  
  Updates an existing floodlight configuration. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightConfigurations"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightConfigurations/list
  
  Required parameters: profileId
  
  Optional parameters: ids
  
  Retrieves a list of floodlight configurations, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightConfigurations"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/floodlightConfigurations/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one floodlight configuration by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/floodlightConfigurations/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
