(ns happygapi.searchconsole.sites
  "Google Search Console API: sites.
  The Search Console API provides access to both Search Console data (verified users only) and to public information on an URL basis (anyone)
  See: https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/sites/get
  
  Required parameters: siteUrl
  
  Optional parameters: none
  
   Retrieves information about specific site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}"
     #{:siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/sites/list
  
  Required parameters: none
  
  Optional parameters: none
  
   Lists the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/sites/delete
  
  Required parameters: siteUrl
  
  Optional parameters: none
  
   Removes a site from the set of the user's Search Console sites."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:siteUrl})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}"
     #{:siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn add$
  "https://developers.google.com/webmaster-tools/search-console-api/api/reference/rest/v1/sites/add
  
  Required parameters: siteUrl
  
  Optional parameters: none
  
   Adds a site to the set of the user's sites in Search Console."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:siteUrl})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://searchconsole.googleapis.com/"
     "webmasters/v3/sites/{siteUrl}"
     #{:siteUrl}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
