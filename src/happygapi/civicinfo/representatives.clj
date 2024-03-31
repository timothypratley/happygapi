(ns happygapi.civicinfo.representatives
  "Google Civic Information API: representatives.
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-information/api/reference/rest/v2/representatives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn representativeInfoByDivision$
  "https://developers.google.com/civic-information/api/reference/rest/v2/representatives/representativeInfoByDivision
  
  Required parameters: ocdId
  
  Optional parameters: recursive, roles, levels
  
  Looks up representative information for a single geographic division."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ocdId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://civicinfo.googleapis.com/"
     "civicinfo/v2/representatives/{ocdId}"
     #{:ocdId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn representativeInfoByAddress$
  "https://developers.google.com/civic-information/api/reference/rest/v2/representatives/representativeInfoByAddress
  
  Required parameters: none
  
  Optional parameters: address, roles, levels, includeOffices
  
  Looks up political geography and representative information for a single address."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://civicinfo.googleapis.com/"
     "civicinfo/v2/representatives"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
