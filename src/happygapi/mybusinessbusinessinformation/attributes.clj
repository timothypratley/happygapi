(ns happygapi.mybusinessbusinessinformation.attributes
  "My Business Business Information API: attributes.
  The My Business Business Information API provides an interface for managing business information. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/attributes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/my-business/api/reference/rest/v1/attributes/list
  
  Required parameters: none
  
  Optional parameters: parent, categoryName, regionCode, languageCode, showAll, pageSize, pageToken
  
  Returns the list of attributes that would be available for a location with the given primary category and country."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessbusinessinformation.googleapis.com/"
     "v1/attributes"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
