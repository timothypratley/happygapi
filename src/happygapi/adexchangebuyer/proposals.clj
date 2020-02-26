(ns happygapi.adexchangebuyer.proposals
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

(defn get$
  "Required parameters: proposalId
  
  Optional parameters: none
  
  Get a proposal given its id"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}"
     #{"proposalId"}
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
  
  Create the given list of proposals"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/insert"
     #{}
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

(defn patch$
  "Required parameters: proposalId, revisionNumber, updateAction
  
  Optional parameters: none
  
  Update the given proposal. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"proposalId" "updateAction" "revisionNumber"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/{revisionNumber}/{updateAction}"
     #{"proposalId" "updateAction" "revisionNumber"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "Required parameters: none
  
  Optional parameters: pqlQuery
  
  Search for proposals using pql query"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setupcomplete$
  "Required parameters: proposalId
  
  Optional parameters: none
  
  Update the given proposal to indicate that setup has been completed."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/setupcomplete"
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

(defn update$
  "Required parameters: proposalId, revisionNumber, updateAction
  
  Optional parameters: none
  
  Update the given proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"proposalId" "updateAction" "revisionNumber"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/{revisionNumber}/{updateAction}"
     #{"proposalId" "updateAction" "revisionNumber"}
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
