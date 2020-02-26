(ns happygapi.adexchangebuyer2.bidders
  "Ad Exchange Buyer API II
  Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
  See: https://developers.google.com/authorized-buyers/apis/reference/rest/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adexchangebuyer2_schema.edn"))))

(defn filterSets-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the requested filter set from the account with the given account
  ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the requested filter set for the account with the given account
  ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-list$
  "Required parameters: ownerName
  
  Optional parameters: pageToken, pageSize
  
  Lists all filter sets for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"ownerName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{"ownerName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-create$
  "Required parameters: ownerName
  
  Optional parameters: isTransient
  
  Creates the specified filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"ownerName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{"ownerName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn filterSets-filteredBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bids were filtered, with the number of bids
  filtered for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBids-creatives-list$
  "Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageToken, pageSize
  
  List all creatives associated with a specific reason for which bids were
  filtered, with the number of bids filtered for each creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName" "creativeStatusId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives"
     #{"filterSetName" "creativeStatusId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBids-details-list$
  "Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageToken, pageSize
  
  List all details associated with a specific reason for which bids were
  filtered, with the number of bids filtered for each detail."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName" "creativeStatusId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details"
     #{"filterSetName" "creativeStatusId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-nonBillableWinningBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which winning bids were not billable, with the number
  of bids not billed for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/nonBillableWinningBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-losingBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bids lost in the auction, with the number of
  bids that lost for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/losingBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-impressionMetrics-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  Lists all metrics that are measured in terms of number of impressions."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/impressionMetrics"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidMetrics-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  Lists all metrics that are measured in terms of number of bids."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidMetrics"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidResponseErrors-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all errors that occurred in bid responses, with the number of bid
  responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponseErrors"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-bidResponsesWithoutBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bid responses were considered to have no
  applicable bids, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponsesWithoutBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn filterSets-filteredBidRequests-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons that caused a bid request not to be sent for an
  impression, with the number of bid requests not sent for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBidRequests"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes the requested filter set from the account with the given account
  ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Retrieves the requested filter set for the account with the given account
  ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-list$
  "Required parameters: ownerName
  
  Optional parameters: pageToken, pageSize
  
  Lists all filter sets for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"ownerName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{"ownerName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-create$
  "Required parameters: ownerName
  
  Optional parameters: isTransient
  
  Creates the specified filter set for the account with the given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"ownerName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+ownerName}/filterSets"
     #{"ownerName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn accounts-filterSets-losingBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bids lost in the auction, with the number of
  bids that lost for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/losingBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-impressionMetrics-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  Lists all metrics that are measured in terms of number of impressions."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/impressionMetrics"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidMetrics-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  Lists all metrics that are measured in terms of number of bids."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidMetrics"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidResponseErrors-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all errors that occurred in bid responses, with the number of bid
  responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponseErrors"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-bidResponsesWithoutBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bid responses were considered to have no
  applicable bids, with the number of bid responses affected for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/bidResponsesWithoutBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBidRequests-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons that caused a bid request not to be sent for an
  impression, with the number of bid requests not sent for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBidRequests"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which bids were filtered, with the number of bids
  filtered for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-creatives-list$
  "Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageToken, pageSize
  
  List all creatives associated with a specific reason for which bids were
  filtered, with the number of bids filtered for each creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName" "creativeStatusId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/creatives"
     #{"filterSetName" "creativeStatusId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-filteredBids-details-list$
  "Required parameters: filterSetName, creativeStatusId
  
  Optional parameters: pageToken, pageSize
  
  List all details associated with a specific reason for which bids were
  filtered, with the number of bids filtered for each detail."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName" "creativeStatusId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/filteredBids/{creativeStatusId}/details"
     #{"filterSetName" "creativeStatusId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn accounts-filterSets-nonBillableWinningBids-list$
  "Required parameters: filterSetName
  
  Optional parameters: pageToken, pageSize
  
  List all reasons for which winning bids were not billable, with the number
  of bids not billed for each reason."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"filterSetName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/{+filterSetName}/nonBillableWinningBids"
     #{"filterSetName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
