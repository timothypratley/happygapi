(ns happygapi.domainsrdap.v1
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

(defn $
  "Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/domains"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/entities"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/nameservers"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Optional parameters: none
  
  Get help information for the RDAP API, including links to documentation."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/help"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/ip"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
