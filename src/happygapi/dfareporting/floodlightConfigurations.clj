(ns happygapi.dfareporting.floodlightConfigurations
  "DCM/DFA Reporting And Trafficking API: floodlightConfigurations.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/floodlightConfigurations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/floodlightConfigurations/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one floodlight configuration by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/floodlightConfigurations/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/floodlightConfigurations/list
  
  Required parameters: profileId
  
  Optional parameters: ids
  
  Retrieves a list of floodlight configurations, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/floodlightConfigurations"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/floodlightConfigurations/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:customViewabilityMetric {:configuration CustomViewabilityMetricConfiguration,
                             :id string,
                             :name string},
   :inAppAttributionTrackingEnabled boolean,
   :thirdPartyAuthenticationTokens [{:name string, :value string}],
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :userDefinedVariableConfigurations [{:dataType string,
                                        :reportName string,
                                        :variableType string}],
   :naturalSearchConversionAttributionOption string,
   :analyticsDataSharingEnabled boolean,
   :advertiserId string,
   :id string,
   :firstDayOfWeek string,
   :kind string,
   :omnitureSettings {:omnitureCostDataEnabled boolean,
                      :omnitureIntegrationEnabled boolean},
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :tagSettings {:dynamicTagEnabled boolean, :imageTagEnabled boolean},
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
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/floodlightConfigurations"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/floodlightConfigurations/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:customViewabilityMetric {:configuration CustomViewabilityMetricConfiguration,
                             :id string,
                             :name string},
   :inAppAttributionTrackingEnabled boolean,
   :thirdPartyAuthenticationTokens [{:name string, :value string}],
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :userDefinedVariableConfigurations [{:dataType string,
                                        :reportName string,
                                        :variableType string}],
   :naturalSearchConversionAttributionOption string,
   :analyticsDataSharingEnabled boolean,
   :advertiserId string,
   :id string,
   :firstDayOfWeek string,
   :kind string,
   :omnitureSettings {:omnitureCostDataEnabled boolean,
                      :omnitureIntegrationEnabled boolean},
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :tagSettings {:dynamicTagEnabled boolean, :imageTagEnabled boolean},
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
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/floodlightConfigurations"
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
