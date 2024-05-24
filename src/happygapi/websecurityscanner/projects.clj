(ns happygapi.websecurityscanner.projects
  "Web Security Scanner API: projects.
  Scans your Compute and App Engine apps for common web vulnerabilities.
  See: https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn scanConfigs-create$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:schedule {:intervalDurationDays integer, :scheduleTime string},
   :maxQps integer,
   :displayName string,
   :name string,
   :riskLevel string,
   :managedScan boolean,
   :staticIpScan boolean,
   :exportToSecurityCommandCenter string,
   :startingUrls [string],
   :authentication {:googleAccount GoogleAccount,
                    :customAccount CustomAccount,
                    :iapCredential IapCredential},
   :userAgent string,
   :blacklistPatterns [string],
   :ignoreHttpStatusErrors boolean}
  
  Creates a new ScanConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/scanConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-delete$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing ScanConfig and its child resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-patch$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:schedule {:intervalDurationDays integer, :scheduleTime string},
   :maxQps integer,
   :displayName string,
   :name string,
   :riskLevel string,
   :managedScan boolean,
   :staticIpScan boolean,
   :exportToSecurityCommandCenter string,
   :startingUrls [string],
   :authentication {:googleAccount GoogleAccount,
                    :customAccount CustomAccount,
                    :iapCredential IapCredential},
   :userAgent string,
   :blacklistPatterns [string],
   :ignoreHttpStatusErrors boolean}
  
  Updates a ScanConfig. This method support partial update of a ScanConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-start$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Start a ScanRun according to the given ScanConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}:start"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-get$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ScanConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-list$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists ScanConfigs under a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/scanConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-stop$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a ScanRun. The stopped ScanRun is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}:stop"
     #{:name}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-get$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ScanRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-list$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists ScanRuns under a given ScanConfig, in descending order of ScanRun stop time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/scanRuns"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-findingTypeStats-list$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/findingTypeStats/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  List all FindingTypeStats under a given ScanRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/findingTypeStats"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-crawledUrls-list$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/crawledUrls/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List CrawledUrls under a given ScanRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/crawledUrls"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-findings-list$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/findings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  List Findings under a given ScanRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+parent}/findings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn scanConfigs-scanRuns-findings-get$
  "https://cloud.google.com/security-command-center/docs/concepts-web-security-scanner-overview/api/reference/rest/v1/projects/scanConfigs/scanRuns/findings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Finding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://websecurityscanner.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
