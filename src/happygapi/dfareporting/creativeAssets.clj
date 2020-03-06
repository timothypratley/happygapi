(ns happygapi.dfareporting.creativeAssets
  "DCM/DFA Reporting And Trafficking API: creativeAssets.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creativeAssets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/creativeAssets/insert
  
  Required parameters: advertiserId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:assetIdentifier {:name string, :type string},
   :clickTags [{:clickThroughUrl CreativeClickThroughUrl,
                :eventName string,
                :name string}],
   :detectedFeatures [string],
   :id string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :kind string,
   :warnedValidationRules [string]}
  
  Inserts a new creative asset."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:advertiserId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/creativeAssets/{advertiserId}/creativeAssets"
     #{:advertiserId :profileId}
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
