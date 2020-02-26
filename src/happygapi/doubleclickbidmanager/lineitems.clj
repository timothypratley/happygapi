(ns happygapi.doubleclickbidmanager.lineitems
  "DoubleClick Bid Manager API
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "doubleclickbidmanager_schema.edn"))))

(defn downloadlineitems$
  "Required parameters: none
  
  Optional parameters: none
  
  Retrieves line items in CSV format. TrueView line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn uploadlineitems$
  "Required parameters: none
  
  Optional parameters: none
  
  Uploads line items in CSV format. TrueView line items are not supported."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))
