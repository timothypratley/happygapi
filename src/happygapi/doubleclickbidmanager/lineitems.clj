(ns happygapi.doubleclickbidmanager.lineitems
  "DoubleClick Bid Manager API: lineitems.
  DoubleClick Bid Manager API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn downloadlineitems$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems/downloadlineitems
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:format string,
   :filterIds [string],
   :filterType string,
   :fileSpec string}
  
  Retrieves line items in CSV format. YouTube & partners line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "lineitems/downloadlineitems"
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

(defn uploadlineitems$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems/uploadlineitems
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:format string, :lineItems string, :dryRun boolean}
  
  Uploads line items in CSV format. YouTube & partners line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://doubleclickbidmanager.googleapis.com/doubleclickbidmanager/v1.1/"
     "lineitems/uploadlineitems"
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
