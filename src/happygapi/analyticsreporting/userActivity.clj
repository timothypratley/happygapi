(ns happygapi.analyticsreporting.userActivity
  "Analytics Reporting API
  Accesses Analytics report data.
  See: https://developers.google.com/analytics/devguides/reporting/core/v4/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string
   (slurp (io/resource "analyticsreporting_schema.edn"))))

(defn search$
  "Required parameters: none
  
  Optional parameters: none
  
  Returns User Activity data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsreporting.googleapis.com/"
     "v4/userActivity:search"
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
