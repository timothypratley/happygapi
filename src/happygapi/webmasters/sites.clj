(ns happygapi.webmasters.sites
  "Search Console API
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn add$
  "Required parameters: siteUrl
  
  Adds a site to the set of the user's sites in Search Console."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})]}
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
      :as :json}
     auth))))

(defn delete$
  "Required parameters: siteUrl
  
  Removes a site from the set of the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})]}
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
  
  Retrieves information about specific site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})]}
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
  
  Lists the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
