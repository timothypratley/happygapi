(ns happygapi.webmasters.sitemaps
  "Search Console API: sitemaps.
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/api/reference/rest/v3/sitemaps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sitemaps/delete
  
  Required parameters: feedpath, siteUrl
  
  Optional parameters: none
  Deletes a sitemap from this site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{:feedpath :siteUrl})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sitemaps/get
  
  Required parameters: feedpath, siteUrl
  
  Optional parameters: none
  Retrieves information about a specific sitemap."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:feedpath :siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sitemaps/list
  
  Required parameters: siteUrl
  
  Optional parameters: sitemapIndex
  Lists the sitemaps-entries submitted for this site, or included in the sitemap index file (if sitemapIndex is specified in the request)."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:siteUrl})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps"
     #{:siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/sitemaps/submit
  
  Required parameters: feedpath, siteUrl
  
  Optional parameters: none
  Submits a sitemap for a site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{:feedpath :siteUrl})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{:feedpath :siteUrl}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
