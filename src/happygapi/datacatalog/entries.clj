(ns happygapi.datacatalog.entries
  "Google Cloud Data Catalog API
  A fully managed and highly scalable data discovery and metadata management service.
  
  See: https://cloud.google.com/data-catalog/docs/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "datacatalog_schema.edn"))))

(defn lookup$
  "Required parameters: none
  
  Optional parameters: linkedResource, sqlResource
  
  Get an entry by target resource name. This method allows clients to use
  the resource name from the source Google Cloud Platform service to get the
  Data Catalog Entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1beta1/entries:lookup"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
