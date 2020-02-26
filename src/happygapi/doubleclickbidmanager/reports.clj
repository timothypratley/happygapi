(ns happygapi.doubleclickbidmanager.reports
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

(defn listreports$
  "Required parameters: queryId
  
  Optional parameters: pageSize, pageToken
  
  Retrieves stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{"queryId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "queries/{queryId}/reports"
     #{"queryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
