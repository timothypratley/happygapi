(ns happygapi.versionhistory.platforms
  "versionhistory.googleapis.com API: platforms.
  Version History API - Prod
  See: https://developers.chrome.com/versionhistoryapi/reference/rest/v1/platforms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.chrome.com/versionhistoryapi/reference/rest/v1/platforms/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns list of platforms that are available for a given product. The resource \"product\" has no resource name in its name."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://versionhistory.googleapis.com/"
     "v1/{+parent}/platforms"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-list$
  "https://developers.chrome.com/versionhistoryapi/reference/rest/v1/platforms/channels/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns list of channels that are available for a given platform."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://versionhistory.googleapis.com/"
     "v1/{+parent}/channels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-versions-list$
  "https://developers.chrome.com/versionhistoryapi/reference/rest/v1/platforms/channels/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Returns list of version for the given platform/channel."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://versionhistory.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-versions-releases-list$
  "https://developers.chrome.com/versionhistoryapi/reference/rest/v1/platforms/channels/versions/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Returns list of releases of the given version."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://versionhistory.googleapis.com/"
     "v1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
