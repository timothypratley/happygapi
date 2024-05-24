(ns happygapi.displayvideo.floodlightGroups
  "Display & Video 360 API: floodlightGroups.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/floodlightGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/floodlightGroups/get
  
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
     "v3/floodlightGroups/{+floodlightGroupId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/floodlightGroups/patch
  
  Required parameters: floodlightGroupId
  
  Optional parameters: partnerId, updateMask
  
  Body: 
  
  {:name string,
   :floodlightGroupId string,
   :displayName string,
   :webTagType string,
   :lookbackWindow {:clickDays integer, :impressionDays integer},
   :customVariables {},
   :activeViewConfig {:displayName string,
                      :minimumViewability string,
                      :minimumVolume string,
                      :minimumDuration string,
                      :minimumQuartile string}}
  
  Updates an existing Floodlight group. Returns the updated Floodlight group if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:floodlightGroupId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/floodlightGroups/{floodlightGroupId}"
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

(defn floodlightActivities-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/floodlightGroups/floodlightActivities/get
  
  Required parameters: floodlightGroupId, floodlightActivityId
  
  Optional parameters: partnerId
  
  Gets a Floodlight activity."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:floodlightGroupId :floodlightActivityId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/floodlightGroups/{+floodlightGroupId}/floodlightActivities/{+floodlightActivityId}"
     #{:floodlightGroupId :floodlightActivityId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn floodlightActivities-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/floodlightGroups/floodlightActivities/list
  
  Required parameters: floodlightGroupId
  
  Optional parameters: partnerId, pageSize, pageToken, orderBy
  
  Lists Floodlight activities in a Floodlight group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:floodlightGroupId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/floodlightGroups/{+floodlightGroupId}/floodlightActivities"
     #{:floodlightGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
