(ns happygapi.civicinfo.divisions
  "Google Civic Information API: divisions.
  Provides polling places, early vote locations, contest data, election officials, and government representatives for U.S. residential addresses.
  See: https://developers.google.com/civic-information/docs/reference/rest/v2/divisions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/civic-information/api/reference/rest/v2/divisions/search
  
  Required parameters: none
  
  Optional parameters: query
  
  Searches for political divisions by their natural name or OCD ID."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://civicinfo.googleapis.com/"
     "civicinfo/v2/divisions"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
