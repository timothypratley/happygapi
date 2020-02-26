(ns happygapi.domainsrdap.autnum
  "Domains RDAP API
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "domainsrdap_schema.edn"))))

(defn get$
  "Required parameters: autnumId
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"autnumId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/autnum/{autnumId}"
     #{"autnumId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
