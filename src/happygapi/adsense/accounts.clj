(ns happygapi.adsense.accounts
  "AdSense Management API: accounts.
  The AdSense Management API allows publishers to access their inventory and run earnings and performance reports.
  See: http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Lists all accounts available to this user."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listChildAccounts$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/listChildAccounts
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all accounts directly managed by the given AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}:listChildAccounts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the selected AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-getAdcode$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/getAdcode
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the AdSense code for a given ad client. This returns what was previously known as the 'auto ad code'. This is only supported for ad clients with a product_code of AFC. For more information, see [About the AdSense code](https://support.google.com/adsense/answer/9274634)."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/adcode"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the ad clients available in an account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/adclients"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-adunits-getAdcode$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/getAdcode
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the AdSense code for a given ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/adcode"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-adunits-get$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an ad unit from a specified account and ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-adunits-listLinkedCustomChannels$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/listLinkedCustomChannels
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the custom channels available for an ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}:listLinkedCustomChannels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-adunits-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all ad units under a specified account and ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/adunits"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-customchannels-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the custom channels available in an ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/customchannels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-customchannels-get$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the selected custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-customchannels-listLinkedAdUnits$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/listLinkedAdUnits
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the ad units available for a custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}:listLinkedAdUnits"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-urlchannels-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/adclients/urlchannels/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists active url channels."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/urlchannels"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alerts-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/alerts/list
  
  Required parameters: parent
  
  Optional parameters: languageCode
  
  Lists all the alerts available in an account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/alerts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn payments-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/payments/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all the payments available for an account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/payments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generate$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/reports/generate
  
  Required parameters: account
  
  Optional parameters: dateRange, limit, filters, startDate.day, dimensions, reportingTimeZone, endDate.month, endDate.day, languageCode, startDate.year, currencyCode, startDate.month, metrics, endDate.year, orderBy
  
  Generates an ad hoc report."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+account}/reports:generate"
     #{:account}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generateCsv$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/reports/generateCsv
  
  Required parameters: account
  
  Optional parameters: dateRange, limit, filters, startDate.day, dimensions, reportingTimeZone, endDate.month, endDate.day, languageCode, startDate.year, currencyCode, startDate.month, metrics, endDate.year, orderBy
  
  Generates a csv formatted ad hoc report."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:account})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+account}/reports:generateCsv"
     #{:account}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-generateCsv$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/reports/saved/generateCsv
  
  Required parameters: name
  
  Optional parameters: dateRange, startDate.day, reportingTimeZone, endDate.month, endDate.day, languageCode, startDate.year, currencyCode, startDate.month, endDate.year
  
  Generates a csv formatted saved report."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/saved:generateCsv"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/reports/saved/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists saved reports."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/reports/saved"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-generate$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/reports/saved/generate
  
  Required parameters: name
  
  Optional parameters: dateRange, startDate.day, reportingTimeZone, endDate.month, endDate.day, languageCode, startDate.year, currencyCode, startDate.month, endDate.year
  
  Generates a saved report."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/saved:generate"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-list$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/sites/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the sites available in an account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/sites"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sites-get$
  "http://code.google.com/apis/adsense/management/api/reference/rest/v2/accounts/sites/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the selected site."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
