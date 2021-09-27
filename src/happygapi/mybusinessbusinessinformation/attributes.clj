(ns happygapi.mybusinessbusinessinformation.attributes
  "My Business Business Information API: attributes.
  The My Business Business Information API provides an interface for managing business information on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/attributes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/my-business/api/reference/rest/v1/attributes/list
  
  Required parameters: none
  
  Optional parameters: languageCode, pageSize, regionCode, categoryName, parent, showAll, pageToken
  
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
