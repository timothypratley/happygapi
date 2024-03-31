(ns happygapi.mybusinessplaceactions.placeActionTypeMetadata
  "My Business Place Actions API: placeActionTypeMetadata.
  The My Business Place Actions API provides an interface for managing place action links of a location on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/placeActionTypeMetadata"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/my-business/api/reference/rest/v1/placeActionTypeMetadata/list
  
  Required parameters: none
  
  Optional parameters: languageCode, pageSize, pageToken, filter
  
  Returns the list of available place action types for a location or country."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessplaceactions.googleapis.com/"
     "v1/placeActionTypeMetadata"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
