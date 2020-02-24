(ns happygapi.doubleclickbidmanager.lineitems
  "DoubleClick Bid Manager API
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn downloadlineitems$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn uploadlineitems$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
