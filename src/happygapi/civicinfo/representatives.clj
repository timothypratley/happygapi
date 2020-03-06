(ns happygapi.civicinfo.representatives
  "Google Civic Information API: representatives.
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-informationapi/reference/rest/v2/representatives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn representativeInfoByAddress$
  "https://developers.google.com/civic-informationapi/reference/rest/v2/representatives/representativeInfoByAddress
  
  Required parameters: none
  
  Optional parameters: address, includeOffices, levels, roles
  
  Body: 
  
  {:contextParams {:clientProfile string}}
  
  Looks up political geography and representative information for a single address."
  {:scopes nil}
  [auth args body]
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn representativeInfoByDivision$
  "https://developers.google.com/civic-informationapi/reference/rest/v2/representatives/representativeInfoByDivision
  
  Required parameters: ocdId
  
  Optional parameters: levels, recursive, roles
  
  Body: 
  
  {:contextParams {:clientProfile string}}
  
  Looks up representative information for a single geographic division."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{:ocdId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "representatives/{ocdId}"
     #{:ocdId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
