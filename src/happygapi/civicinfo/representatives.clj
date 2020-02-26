(ns happygapi.civicinfo.representatives
  "Google Civic Information API
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-information"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "civicinfo_schema.edn"))))

(defn representativeInfoByAddress$
  "Required parameters: none
  
  Optional parameters: address, includeOffices, levels, roles
  
  Looks up political geography and representative information for a single address."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "representatives"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn representativeInfoByDivision$
  "Required parameters: ocdId
  
  Optional parameters: levels, recursive, roles
  
  Looks up representative information for a single geographic division."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"ocdId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "representatives/{ocdId}"
     #{"ocdId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
