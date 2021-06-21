(ns happygapi.displayvideo.floodlightGroups
  "Display & Video 360 API: floodlightGroups.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/floodlightGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v1/floodlightGroups/get
  
  Required parameters: floodlightGroupId
  
  Optional parameters: partnerId
  
  Gets a Floodlight group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:floodlightGroupId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/floodlightGroups/{+floodlightGroupId}"
     #{:floodlightGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/floodlightGroups/patch
  
  Required parameters: floodlightGroupId
  
  Optional parameters: updateMask, partnerId
  
  Body: 
  
  {:floodlightGroupId string,
   :lookbackWindow {:impressionDays integer, :clickDays integer},
   :activeViewConfig {:minimumVolume string,
                      :minimumViewability string,
                      :displayName string,
                      :minimumDuration string,
                      :minimumQuartile string},
   :displayName string,
   :webTagType string,
   :customVariables {},
   :name string}
  
  Updates an existing Floodlight group. Returns the updated Floodlight group if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:floodlightGroupId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/floodlightGroups/{floodlightGroupId}"
     #{:floodlightGroupId}
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
