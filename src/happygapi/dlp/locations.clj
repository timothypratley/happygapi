(ns happygapi.dlp.locations
  "Sensitive Data Protection (DLP): locations.
  Discover and protect your sensitive data. A fully managed service designed to help you discover, classify, and protect your valuable data assets with ease.
  See: https://cloud.google.com/sensitive-data-protection/docs/docs/reference/rest/v2/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn infoTypes-list$
  "https://cloud.google.com/sensitive-data-protection/docs/api/reference/rest/v2/locations/infoTypes/list
  
  Required parameters: parent
  
  Optional parameters: locationId, languageCode, filter
  
  Returns a list of the sensitive information types that DLP API supports. See https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference to learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/{+parent}/infoTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
