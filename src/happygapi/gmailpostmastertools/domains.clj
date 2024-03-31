(ns happygapi.gmailpostmastertools.domains
  "Gmail Postmaster Tools API: domains.
  The Postmaster Tools API is a RESTful API that provides programmatic access to email traffic metrics (like spam reports, delivery errors etc) otherwise available through the Gmail Postmaster Tools UI currently.
  See: https://developers.google.com/gmail/postmasterapi/reference/rest/v1/domains"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/gmail/postmasterapi/reference/rest/v1/domains/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists the domains that have been registered by the client. The order of domains in the response is unspecified and non-deterministic. Newly created domains will not necessarily be added to the end of this list."
  {:scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmailpostmastertools.googleapis.com/"
     "v1/domains"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/gmail/postmasterapi/reference/rest/v1/domains/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a specific domain registered by the client. Returns NOT_FOUND if the domain does not exist."
  {:scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmailpostmastertools.googleapis.com/"
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

(defn trafficStats-list$
  "https://developers.google.com/gmail/postmasterapi/reference/rest/v1/domains/trafficStats/list
  
  Required parameters: parent
  
  Optional parameters: startDate.day, pageToken, endDate.month, endDate.day, startDate.year, pageSize, startDate.month, endDate.year
  
  List traffic statistics for all available days. Returns PERMISSION_DENIED if user does not have permission to access TrafficStats for the domain."
  {:scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmailpostmastertools.googleapis.com/"
     "v1/{+parent}/trafficStats"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn trafficStats-get$
  "https://developers.google.com/gmail/postmasterapi/reference/rest/v1/domains/trafficStats/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get traffic statistics for a domain on a specific date. Returns PERMISSION_DENIED if user does not have permission to access TrafficStats for the domain."
  {:scopes ["https://www.googleapis.com/auth/postmaster.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gmailpostmastertools.googleapis.com/"
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
