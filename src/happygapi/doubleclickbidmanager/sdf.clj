(ns happygapi.doubleclickbidmanager.sdf
  "DoubleClick Bid Manager API
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn download$
  "Required parameters: none
  
  Retrieves entities in SDF format."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "sdf/download"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
