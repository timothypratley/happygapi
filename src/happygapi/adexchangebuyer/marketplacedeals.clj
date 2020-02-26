(ns happygapi.adexchangebuyer.marketplacedeals
  "Ad Exchange Buyer API
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-rest"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adexchangebuyer_schema.edn"))))

(defn delete$
  "Required parameters: proposalId
  
  Optional parameters: none
  
  Delete the specified deals from the proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/delete"
     #{"proposalId"}
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

(defn insert$
  "Required parameters: proposalId
  
  Optional parameters: none
  
  Add new deals for the specified proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/insert"
     #{"proposalId"}
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

(defn list$
  "Required parameters: proposalId
  
  Optional parameters: pqlQuery
  
  List all the deals for a given proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals"
     #{"proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: proposalId
  
  Optional parameters: none
  
  Replaces all the deals in the proposal with the passed in deals"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/update"
     #{"proposalId"}
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
