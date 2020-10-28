(ns happygapi.displayvideo.customBiddingAlgorithms
  "Display & Video 360 API: customBiddingAlgorithms.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/customBiddingAlgorithms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/customBiddingAlgorithms/list
  
  Required parameters: none
  
  Optional parameters: orderBy, pageToken, partnerId, advertiserId, filter, pageSize
  
  Lists custom bidding algorithms that are accessible to the current user and can be used in bidding stratgies. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/customBiddingAlgorithms"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v1/customBiddingAlgorithms/get
  
  Required parameters: customBiddingAlgorithmId
  
  Optional parameters: advertiserId, partnerId
  
  Gets a custom bidding algorithm."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customBiddingAlgorithmId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/customBiddingAlgorithms/{+customBiddingAlgorithmId}"
     #{:customBiddingAlgorithmId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
