(ns happygapi.doubleclickbidmanager.sdf
  "DoubleClick Bid Manager API: sdf.
  DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/sdf"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/sdf/download
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:filterType string,
   :version string,
   :fileTypes [string],
   :filterIds [string]}
  
  Retrieves entities in SDF format."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "sdf/download"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
