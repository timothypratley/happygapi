(ns happygapi.webmasters.sitemaps
  "Search Console API
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: feedpath,siteUrl
  
  Deletes a sitemap from this site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"feedpath" "siteUrl"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{"feedpath" "siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: feedpath,siteUrl
  
  Retrieves information about a specific sitemap."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"feedpath" "siteUrl"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{"feedpath" "siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: siteUrl
  
  Lists the sitemaps-entries submitted for this site, or included in the sitemap index file (if sitemapIndex is specified in the request)."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"siteUrl"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps"
     #{"siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn submit$
  "Required parameters: feedpath,siteUrl
  
  Submits a sitemap for a site."
  {:scopes ["https://www.googleapis.com/auth/webmasters"]}
  [auth args]
  {:pre [(util/has-keys? args #{"feedpath" "siteUrl"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/sitemaps/{feedpath}"
     #{"feedpath" "siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
