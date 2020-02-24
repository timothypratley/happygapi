(ns happygapi.dlp.locations
  "Cloud Data Loss Prevention (DLP) API
  Provides methods for detection, risk analysis, and de-identification of privacy-sensitive fragments in text, images, and Google Cloud Platform storage repositories.
  See: https://cloud.google.com/dlp/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn infoTypes-list$
  "Required parameters: locationId
  
  Returns a list of the sensitive information types that the DLP API
  supports. See https://cloud.google.com/dlp/docs/infotypes-reference to
  learn more."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"locationId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dlp.googleapis.com/"
     "v2/locations/{locationId}/infoTypes"
     #{"locationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
