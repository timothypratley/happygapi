(ns happygapi.doubleclicksearch.conversion
  "Search Ads 360 API
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "doubleclicksearch_schema.edn"))))

(defn get$
  "Required parameters: startDate, endDate, engineAccountId, advertiserId, startRow, agencyId, rowCount
  
  Optional parameters: adId, adGroupId, campaignId, criterionId
  
  Retrieves a list of conversions from a DoubleClick Search engine account."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"advertiserId"
            "startDate"
            "rowCount"
            "agencyId"
            "startRow"
            "endDate"
            "engineAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "agency/{agencyId}/advertiser/{advertiserId}/engine/{engineAccountId}/conversion"
     #{"advertiserId" "agencyId" "engineAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Optional parameters: none
  
  Inserts a batch of new conversions into DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn patch$
  "Required parameters: advertiserId, agencyId, endDate, engineAccountId, rowCount, startDate, startRow
  
  Optional parameters: none
  
  Updates a batch of conversions in DoubleClick Search. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"advertiserId"
            "startDate"
            "rowCount"
            "agencyId"
            "startRow"
            "endDate"
            "engineAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: none
  
  Optional parameters: none
  
  Updates a batch of conversions in DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn updateAvailability$
  "Required parameters: none
  
  Optional parameters: none
  
  Updates the availabilities of a batch of floodlight activities in DoubleClick Search."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "conversion/updateAvailability"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
