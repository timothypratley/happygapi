(ns happygapi.discovery.apis
  "API Discovery Service: apis.
  Provides information about other Google APIs, such as what APIs are available, the resource, and method details for each API.
  See: https://developers.google.com/discovery/api/reference/rest/v1/apis"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getRest$
  "https://developers.google.com/discovery/api/reference/rest/v1/apis/getRest
  
  Required parameters: version, api
  
  Optional parameters: none
  
  Retrieve the description of a particular version of an api."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:api :version})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/discovery/v1/"
     "apis/{api}/{version}/rest"
     #{:api :version}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/discovery/api/reference/rest/v1/apis/list
  
  Required parameters: none
  
  Optional parameters: name, preferred
  
  Retrieve the list of APIs supported at this endpoint."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/discovery/v1/"
     "apis"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
