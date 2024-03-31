(ns happygapi.adexchangebuyer2.bidders
  "Ad Exchange Buyer API II: bidders.
  Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
  See: https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn accounts-filterSets-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/create
  
  Required parameters: ownerName
  
  Optional parameters: isTransient
  
  Body: 
  
  {:formats [string],
   :format string,
   :breakdownDimensions [string],
   :name string,
   :realtimeTimeRange {:startTimestamp string},
   :publisherIdentifiers [string],
   :timeSeriesGranularity string,
   :creativeId string,
   :environment string,
   :absoluteDateRange {:startDate Date, :endDate Date},
   :dealId string,
   :relativeDateRange {:offsetDays integer, :durationDays integer},
   :platforms [string],
   :sellerNetworkIds [integer]}
  
  Creates the specified filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:ownerName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{:ownerName}
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

(defn accounts-filterSets-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the requested filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/list
  
  Required parameters: ownerName
  
  Optional parameters: pageSize, pageToken
  
  Lists all filter sets for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ownerName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{:ownerName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-delete$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the requested filter set from the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-impressionMetrics-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/impressionMetrics/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  Lists all metrics that are measured in terms of number of impressions."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/impressionMetrics"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidMetrics-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/bidMetrics/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  Lists all metrics that are measured in terms of number of bids."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidMetrics"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBidRequests-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/filteredBidRequests/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons that caused a bid request not to be sent for an impression, with the number of bid requests not sent for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBidRequests"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidResponseErrors-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/bidResponseErrors/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all errors that occurred in bid responses, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponseErrors"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidResponsesWithoutBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/bidResponsesWithoutBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bid responses were considered to have no applicable bids, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponsesWithoutBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/filteredBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bids were filtered, with the number of bids filtered for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-details-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/filteredBids/details/list
  
  Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageSize, pageToken
  
  List all details associated with a specific reason for which bids were filtered, with the number of bids filtered for each detail."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:creativeStatusId :filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details"
     #{:creativeStatusId :filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-creatives-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/filteredBids/creatives/list
  
  Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageSize, pageToken
  
  List all creatives associated with a specific reason for which bids were filtered, with the number of bids filtered for each creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:creativeStatusId :filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives"
     #{:creativeStatusId :filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-losingBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/losingBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bids lost in the auction, with the number of bids that lost for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/losingBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-nonBillableWinningBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/accounts/filterSets/nonBillableWinningBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which winning bids were not billable, with the number of bids not billed for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/nonBillableWinningBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/create
  
  Required parameters: ownerName
  
  Optional parameters: isTransient
  
  Body: 
  
  {:formats [string],
   :format string,
   :breakdownDimensions [string],
   :name string,
   :realtimeTimeRange {:startTimestamp string},
   :publisherIdentifiers [string],
   :timeSeriesGranularity string,
   :creativeId string,
   :environment string,
   :absoluteDateRange {:startDate Date, :endDate Date},
   :dealId string,
   :relativeDateRange {:offsetDays integer, :durationDays integer},
   :platforms [string],
   :sellerNetworkIds [integer]}
  
  Creates the specified filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:ownerName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{:ownerName}
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

(defn filterSets-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the requested filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/list
  
  Required parameters: ownerName
  
  Optional parameters: pageSize, pageToken
  
  Lists all filter sets for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ownerName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{:ownerName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-delete$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the requested filter set from the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-impressionMetrics-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/impressionMetrics/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  Lists all metrics that are measured in terms of number of impressions."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/impressionMetrics"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidMetrics-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/bidMetrics/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  Lists all metrics that are measured in terms of number of bids."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidMetrics"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBidRequests-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/filteredBidRequests/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons that caused a bid request not to be sent for an impression, with the number of bid requests not sent for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBidRequests"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidResponseErrors-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/bidResponseErrors/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all errors that occurred in bid responses, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponseErrors"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidResponsesWithoutBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/bidResponsesWithoutBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bid responses were considered to have no applicable bids, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponsesWithoutBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/filteredBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bids were filtered, with the number of bids filtered for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBids-details-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/filteredBids/details/list
  
  Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageSize, pageToken
  
  List all details associated with a specific reason for which bids were filtered, with the number of bids filtered for each detail."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:creativeStatusId :filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details"
     #{:creativeStatusId :filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBids-creatives-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/filteredBids/creatives/list
  
  Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageSize, pageToken
  
  List all creatives associated with a specific reason for which bids were filtered, with the number of bids filtered for each creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:creativeStatusId :filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives"
     #{:creativeStatusId :filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-losingBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/losingBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which bids lost in the auction, with the number of bids that lost for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/losingBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-nonBillableWinningBids-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/bidders/filterSets/nonBillableWinningBids/list
  
  Required parameters: filterSetName
  
  Optional parameters: pageSize, pageToken
  
  List all reasons for which winning bids were not billable, with the number of bids not billed for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filterSetName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/nonBillableWinningBids"
     #{:filterSetName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
