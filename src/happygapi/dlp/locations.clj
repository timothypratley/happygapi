(ns happygapi.dlp.locations
  "Cloud Data Loss Prevention (DLP) API: locations.
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/api/reference/rest/v2/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn infoTypes-list$
  "https://cloud.google.com/dlp/docs/api/reference/rest/v2/locations/infoTypes/list
  
  Required parameters: parent
  
  Optional parameters: locationId, filter, languageCode
  
  Returns a list of the sensitive information types that the DLP API supports. See https://cloud.google.com/dlp/docs/infotypes-reference to learn more."
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
