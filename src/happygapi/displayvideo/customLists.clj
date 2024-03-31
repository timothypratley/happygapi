(ns happygapi.displayvideo.customLists
  "Display & Video 360 API: customLists.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/api/reference/rest/v3/customLists"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/customLists/get
  
  Required parameters: customListId
  
  Optional parameters: advertiserId
  
  Gets a custom list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customListId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customLists/{+customListId}"
     #{:customListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/customLists/list
  
  Required parameters: none
  
  Optional parameters: advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists custom lists. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/customLists"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
