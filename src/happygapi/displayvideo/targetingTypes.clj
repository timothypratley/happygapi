(ns happygapi.displayvideo.targetingTypes
  "Display & Video 360 API: targetingTypes.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/targetingTypes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn targetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/targetingTypes/targetingOptions/get
  
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
     "v1/targetingTypes/{+targetingType}/targetingOptions/{+targetingOptionId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v1/targetingTypes/targetingOptions/list
  
  Required parameters: targetingType
  
  Optional parameters: pageSize, filter, pageToken, advertiserId, orderBy
  
  Lists targeting options of a given type."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/targetingTypes/{+targetingType}/targetingOptions"
     #{:targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
