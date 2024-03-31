(ns happygapi.drivelabels.users
  "Drive Labels API: users.
  An API for managing Drive Labels
  See: https://developers.google.com/drive/labelsapi/reference/rest/v2/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getCapabilities$
  "https://developers.google.com/drive/labelsapi/reference/rest/v2/users/getCapabilities
  
  Required parameters: name
  
  Optional parameters: customer
  
  Gets the user capabilities."
  {:scopes ["https://www.googleapis.com/auth/drive.admin.labels"
            "https://www.googleapis.com/auth/drive.admin.labels.readonly"
            "https://www.googleapis.com/auth/drive.labels"
            "https://www.googleapis.com/auth/drive.labels.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://drivelabels.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
