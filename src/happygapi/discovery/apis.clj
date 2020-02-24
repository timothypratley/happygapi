(ns happygapi.discovery.apis
  "API Discovery Service
  Provides information about other Google APIs, such as what APIs are available, the resource, and method details for each API.
  See: https://developers.google.com/discovery/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getRest$
  "Required parameters: api,version
  
  Retrieve the description of a particular version of an api."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{"api" "version"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/discovery/v1/"
     "apis/{api}/{version}/rest"
     #{"api" "version"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Retrieve the list of APIs supported at this endpoint."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/discovery/v1/"
     "apis"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
