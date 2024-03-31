(ns happygapi.domainsrdap.v1
  "Domains RDAP API: v1.
  Read-only public API that lets users search for information about domain names.
  See: https://developers.google.com/domains/rdap/api/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/getHelp
  
  Required parameters: none
  
  Optional parameters: none
  
  Get help information for the RDAP API, including links to documentation."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/help"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/getIp
  
  Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/ip"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/getDomains
  
  Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/domains"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/getEntities
  
  Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/entities"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://developers.google.com/domains/rdap/api/reference/rest/v1/getNameservers
  
  Required parameters: none
  
  Optional parameters: none
  
  The RDAP API recognizes this command from the RDAP specification but does not support it. The response is a formatted 501 error."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://domainsrdap.googleapis.com/"
     "v1/nameservers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
