(ns happygapi.drivelabels.limits
  "Drive Labels API: limits.
  An API for managing Drive Labels
  See: https://developers.google.com/drive/labelsapi/reference/rest/v2/limits"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getLabel$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/limits/getLabel
  
  Required parameters: none
  
  Optional parameters: name
  
  Get the constraints on the structure of a Label; such as, the maximum number of Fields allowed and maximum length of the label title."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/limits/label"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
