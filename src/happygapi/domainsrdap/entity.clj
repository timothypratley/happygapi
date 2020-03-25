(ns happygapi.domainsrdap.entity
  "Domains RDAP API: entity.
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/api/reference/rest/v1/entity"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/entity/get
  
  Required parameters: entityId
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but
  does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:entityId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/entity/{entityId}"
     #{:entityId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
