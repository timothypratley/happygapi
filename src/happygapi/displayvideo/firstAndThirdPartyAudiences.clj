(ns happygapi.displayvideo.firstAndThirdPartyAudiences
  "Display & Video 360 API: firstAndThirdPartyAudiences.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/firstAndThirdPartyAudiences"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v1/firstAndThirdPartyAudiences/get
  
  Required parameters: firstAndThirdPartyAudienceId
  
  Optional parameters: advertiserId, partnerId
  
  Gets a first and third party audience."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:firstAndThirdPartyAudienceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/firstAndThirdPartyAudiences/{+firstAndThirdPartyAudienceId}"
     #{:firstAndThirdPartyAudienceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/firstAndThirdPartyAudiences/list
  
  Required parameters: none
  
  Optional parameters: filter, pageSize, advertiserId, orderBy, partnerId, pageToken
  
  Lists first and third party audiences. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/firstAndThirdPartyAudiences"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
