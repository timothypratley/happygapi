(ns happygapi.domainsrdap.domain
  "Domains RDAP API
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "domainsrdap_schema.edn"))))

(defn get$
  "Required parameters: domainName
  
  Optional parameters: none
  
  Look up RDAP information for a domain by name."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"domainName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/domain/{+domainName}"
     #{"domainName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
