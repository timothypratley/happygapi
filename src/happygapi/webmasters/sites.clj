(ns happygapi.webmasters.sites
  "Search Console API: sites.
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/api/reference/rest/v3/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn add$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sites/add
  
  Required parameters: siteUrl
  
  Optional parameters: none
  Adds a site to the set of the user's sites in Search Console."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{:siteUrl})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{:siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sites/delete
  
  Required parameters: siteUrl
  
  Optional parameters: none
  Removes a site from the set of the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{:siteUrl})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{:siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sites/get
  
  Required parameters: siteUrl
  
  Optional parameters: none
  Retrieves information about specific site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}"
     #{:siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sites/list
  
  Required parameters: none
  
  Optional parameters: none
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
