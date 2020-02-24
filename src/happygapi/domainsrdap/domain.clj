(ns happygapi.domainsrdap.domain
  "Domains RDAP API
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: domainName
  
  Look up RDAP information for a domain by name."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"domainName"})]}
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
