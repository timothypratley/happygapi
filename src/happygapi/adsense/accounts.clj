(ns happygapi.adsense.accounts
  "AdSense Management API: accounts.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/get
  
  Required parameters: accountId
  
  Optional parameters: tree
  
  Get information about the selected AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageToken, maxResults
  
  List all accounts available to this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedadstyles-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/savedadstyles/get
  
  Required parameters: accountId, savedAdStyleId
  
  Optional parameters: none
  
  List a specific saved ad style for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:savedAdStyleId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/savedadstyles/{savedAdStyleId}"
     #{:savedAdStyleId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn savedadstyles-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/savedadstyles/list
  
  Required parameters: accountId
  
  Optional parameters: pageToken, maxResults
  
  List all saved ad styles in the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/savedadstyles"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adunits/get
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: none
  
  Gets the specified ad unit in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adunits/list
  
  Required parameters: accountId, adClientId
  
  Optional parameters: includeInactive, pageToken, maxResults
  
  List all ad units in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-getAdCode$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adunits/getAdCode
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: none
  
  Get ad code for the specified ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-customchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adunits/customchannels/list
  
  Required parameters: accountId, adClientId, adUnitId
  
  Optional parameters: pageToken, maxResults
  
  List all custom channels which the specified ad unit belongs to."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adUnitId :adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/customchannels"
     #{:adUnitId :adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alerts-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/alerts/list
  
  Required parameters: accountId
  
  Optional parameters: locale
  
  List the alerts for the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/alerts"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alerts-delete$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/alerts/delete
  
  Required parameters: alertId, accountId
  
  Optional parameters: none
  
  Dismiss (delete) the specified alert from the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :alertId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/alerts/{alertId}"
     #{:accountId :alertId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/reports/generate
  
  Required parameters: startDate, endDate, accountId
  
  Optional parameters: locale, currency, filter, dimension, startIndex, metric, sort, useTimezoneReporting, maxResults
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:startDate :endDate :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports"
     #{:startDate :endDate :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/reports/saved/list
  
  Required parameters: accountId
  
  Optional parameters: maxResults, pageToken
  
  List all saved reports in the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports/saved"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/reports/saved/generate
  
  Required parameters: accountId, savedReportId
  
  Optional parameters: startIndex, locale, maxResults
  
  Generate an AdSense report based on the saved report ID sent in the query parameters."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :savedReportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports/{savedReportId}"
     #{:accountId :savedReportId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn urlchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/urlchannels/list
  
  Required parameters: accountId, adClientId
  
  Optional parameters: pageToken, maxResults
  
  List all URL channels in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/urlchannels"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn payments-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/payments/list
  
  Required parameters: accountId
  
  Optional parameters: none
  
  List the payments for the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/payments"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/customchannels/get
  
  Required parameters: accountId, adClientId, customChannelId
  
  Optional parameters: none
  
  Get the specified custom channel from the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adClientId :customChannelId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels/{customChannelId}"
     #{:adClientId :customChannelId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/customchannels/list
  
  Required parameters: accountId, adClientId
  
  Optional parameters: pageToken, maxResults
  
  List all custom channels in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-adunits-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/customchannels/adunits/list
  
  Required parameters: accountId, adClientId, customChannelId
  
  Optional parameters: pageToken, includeInactive, maxResults
  
  List all ad units in the specified custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adClientId :customChannelId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels/{customChannelId}/adunits"
     #{:adClientId :customChannelId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adclients/list
  
  Required parameters: accountId
  
  Optional parameters: pageToken, maxResults
  
  List all ad clients in the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-getAdCode$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/accounts/adclients/getAdCode
  
  Required parameters: accountId, adClientId
  
  Optional parameters: none
  
  Get Auto ad code for a given ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adClientId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adcode"
     #{:adClientId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
