(ns happygapi.webrisk.threatLists
  "Web Risk API: threatLists.
  
  See: https://cloud.google.com/web-risk/api/reference/rest/v1/threatLists"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn computeDiff$
  "https://cloud.google.com/web-risk/api/reference/rest/v1/threatLists/computeDiff
  
  Required parameters: none
  
  Optional parameters: constraints.maxDatabaseEntries, constraints.maxDiffEntries, threatType, constraints.supportedCompressions, versionToken
  
  Gets the most recent threat list diffs. These diffs should be applied to a local database of hashes to keep it up-to-date. If the local database is empty or excessively out-of-date, a complete snapshot of the database will be returned. This Method only updates a single ThreatList at a time. To update multiple ThreatList databases, this method needs to be called once for each list."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://webrisk.googleapis.com/"
     "v1/threatLists:computeDiff"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
