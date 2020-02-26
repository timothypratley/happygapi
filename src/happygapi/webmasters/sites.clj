(ns happygapi.webmasters.sites
  "Search Console API
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "webmasters_schema.edn"))))

(defn add$
  "Required parameters: siteUrl
  
  Optional parameters: none
  
  Adds a site to the set of the user's sites in Search Console."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"siteUrl"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{"siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn delete$
  "Required parameters: siteUrl
  
  Optional parameters: none
  
  Removes a site from the set of the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{"siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: siteUrl
  
  Optional parameters: none
  
  Retrieves information about specific site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{"siteUrl"}
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
  
  Optional parameters: none
  
  Lists the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
