(ns happygapi.realtimebidding.bidders
  "Real-time Bidding API: bidders.
  Allows external bidders to manage their RTB integration with Google. This includes managing bidder endpoints, QPS quotas, configuring what ad inventory to receive via pretargeting, submitting creatives for verification, and accessing creative metadata such as approval status.
  See: https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn creatives-list$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/creatives/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view, filter
  
  Lists creatives."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-watch$
  "https://developers.google.com/authorized-buyers/apis/realtimebidding/reference/rest/api/reference/rest/v1/bidders/creatives/watch
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Watches all creatives pertaining to a bidder. It is sufficient to invoke this endpoint once per bidder. A Pub/Sub topic will be created and notifications will be pushed to the topic when any of the bidder's creatives change status. All of the bidder's service accounts will have access to read from the topic. Subsequent invocations of this method will return the existing Pub/Sub configuration."
  {:scopes ["https://www.googleapis.com/auth/realtime-bidding"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://realtimebidding.googleapis.com/"
     "v1/{+parent}/creatives:watch"
     #{:parent}
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
