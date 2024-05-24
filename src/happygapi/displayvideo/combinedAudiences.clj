(ns happygapi.displayvideo.combinedAudiences
  "Display & Video 360 API: combinedAudiences.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/combinedAudiences"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/combinedAudiences/get
  
  Required parameters: combinedAudienceId
  
  Optional parameters: partnerId, advertiserId
  
  Gets a combined audience."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:combinedAudienceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/combinedAudiences/{+combinedAudienceId}"
     #{:combinedAudienceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/combinedAudiences/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists combined audiences. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/combinedAudiences"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
