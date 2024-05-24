(ns happygapi.displayvideo.targetingTypes
  "Display & Video 360 API: targetingTypes.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/targetingTypes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn targetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/targetingTypes/targetingOptions/get
  
  Required parameters: targetingType, targetingOptionId
  
  Optional parameters: advertiserId
  
  Gets a single targeting option."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetingOptionId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/targetingTypes/{+targetingType}/targetingOptions/{+targetingOptionId}"
     #{:targetingOptionId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/targetingTypes/targetingOptions/list
  
  Required parameters: targetingType
  
  Optional parameters: advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists targeting options of a given type."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/targetingTypes/{+targetingType}/targetingOptions"
     #{:targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingOptions-search$
  "https://developers.google.com/display-video/api/reference/rest/v3/targetingTypes/targetingOptions/search
  
  Required parameters: targetingType
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :pageSize integer,
   :pageToken string,
   :poiSearchTerms {:poiQuery string},
   :businessChainSearchTerms {:businessChainQuery string,
                              :regionQuery string},
   :geoRegionSearchTerms {:geoRegionQuery string}}
  
  Searches for targeting options of a given type based on the given search terms."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/targetingTypes/{+targetingType}/targetingOptions:search"
     #{:targetingType}
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
