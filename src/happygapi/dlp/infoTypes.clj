(ns happygapi.dlp.infoTypes
  "Sensitive Data Protection (DLP): infoTypes.
  Discover and protect your sensitive data. A fully managed service designed to help you discover, classify, and protect your valuable data assets with ease.
  See: https://cloud.google.com/sensitive-data-protection/docs/docs/reference/rest/v2/infoTypes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/infoTypes/list
  
  Required parameters: none
  
  Optional parameters: parent, languageCode, locationId, filter
  
  Returns a list of the sensitive information types that DLP API supports. See https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/infoTypes"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
