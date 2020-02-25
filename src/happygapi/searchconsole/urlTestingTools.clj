(ns happygapi.searchconsole.urlTestingTools
  "Google Search Console URL Testing Tools API
  Provides tools for running validation tests against single URLs
  See: https://developers.google.com/webmaster-tools/search-console-api/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "searchconsole_schema.edn"))))

(defn mobileFriendlyTest-run$
  "Required parameters: none
  
  Optional parameters: none
  
  Runs Mobile-Friendly Test for a given URL."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "v1/urlTestingTools/mobileFriendlyTest:run"
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
