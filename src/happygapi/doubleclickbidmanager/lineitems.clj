(ns happygapi.doubleclickbidmanager.lineitems
  "DoubleClick Bid Manager API: lineitems.
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn downloadlineitems$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems/downloadlineitems
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:fileSpec string,
   :filterIds [string],
   :filterType string,
   :format string}
  
  Retrieves line items in CSV format. TrueView line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "lineitems/downloadlineitems"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn uploadlineitems$
  "https://developers.google.com/bid-manager/api/reference/rest/v1.1/lineitems/uploadlineitems
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:dryRun boolean, :format string, :lineItems string}
  
  Uploads line items in CSV format. TrueView line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "lineitems/uploadlineitems"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
