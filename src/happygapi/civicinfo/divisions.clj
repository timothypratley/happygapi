(ns happygapi.civicinfo.divisions
  "Google Civic Information API: divisions.
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-informationapi/reference/rest/v2/divisions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/civic-informationapi/reference/rest/v2/divisions/search
  
  Required parameters: none
  
  Optional parameters: query
  
  Body: 
  
  {:contextParams {:clientProfile string}}
  
  Searches for political divisions by their natural name or OCD ID."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/civicinfo/v2/"
     "divisions"
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
