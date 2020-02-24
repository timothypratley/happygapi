(ns happygapi.civicinfo.representatives
  "Google Civic Information API
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-information"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn representativeInfoByAddress$
  "Required parameters: none
  
  Looks up political geography and representative information for a single address."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  Looks up representative information for a single geographic division."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"ocdId"})]}
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
