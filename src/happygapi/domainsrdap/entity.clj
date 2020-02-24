(ns happygapi.domainsrdap.entity
  "Domains RDAP API
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: entityId
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"entityId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/entity/{entityId}"
     #{"entityId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
