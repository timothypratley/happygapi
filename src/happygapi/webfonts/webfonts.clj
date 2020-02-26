(ns happygapi.webfonts.webfonts
  "Google Fonts Developer API
  Accesses the metadata for all families served by Google Fonts, providing a list of families currently available (including available styles and a list of supported script subsets).
  See: https://developers.google.com/fonts/docs/developer_api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "webfonts_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: sort
  
  Retrieves the list of fonts currently served by the Google Fonts Developer API"
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webfonts/v1/"
     "webfonts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
