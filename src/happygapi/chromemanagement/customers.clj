(ns happygapi.chromemanagement.customers
  "Chrome Management API: customers.
  The Chrome Management API is a suite of services that allows Chrome administrators to view, manage and gain insights on their Chrome OS and Chrome Browser devices.
  See: http://developers.google.com/chrome/management/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn reports-countInstalledApps$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/reports/countInstalledApps
  
  Required parameters: customer
  
  Optional parameters: orgUnitId, pageToken, pageSize, orderBy, filter
  
  Generate report of app installations."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countInstalledApps"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-countChromeVersions$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/reports/countChromeVersions
  
  Required parameters: customer
  
  Optional parameters: pageToken, orgUnitId, filter, pageSize
  
  Generate report of installed Chrome versions."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:countChromeVersions"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-findInstalledAppDevices$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/reports/findInstalledAppDevices
  
  Required parameters: customer
  
  Optional parameters: orderBy, pageToken, orgUnitId, appId, pageSize, appType, filter
  
  Generate report of devices that have a specified app installed."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.reports.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
     "v1/{+customer}/reports:findInstalledAppDevices"
     #{:customer}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-web-get$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/apps/web/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn apps-android-get$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/apps/android/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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

(defn apps-chrome-get$
  "http://developers.google.com/chrome/management/api/reference/rest/v1/customers/apps/chrome/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific app for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.appdetails.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromemanagement.googleapis.com/"
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
