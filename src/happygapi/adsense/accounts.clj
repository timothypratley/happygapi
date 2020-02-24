(ns happygapi.adsense.accounts
  "AdSense Management API
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: accountId
  
  Get information about the selected AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  List all accounts available to this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-getAdCode$
  "Required parameters: accountId,adClientId
  
  Get Auto ad code for a given ad client."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adcode"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adclients-list$
  "Required parameters: accountId
  
  List all ad clients in the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-get$
  "Required parameters: accountId,adClientId,adUnitId
  
  Gets the specified ad unit in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-getAdCode$
  "Required parameters: accountId,adClientId,adUnitId
  
  Get ad code for the specified ad unit."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/adcode"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-list$
  "Required parameters: accountId,adClientId
  
  List all ad units in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn adunits-customchannels-list$
  "Required parameters: accountId,adClientId,adUnitId
  
  List all custom channels which the specified ad unit belongs to."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adUnitId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/adunits/{adUnitId}/customchannels"
     #{"accountId" "adUnitId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn alerts-delete$
  "Required parameters: accountId,alertId
  
  Dismiss (delete) the specified alert from the specified publisher AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "alertId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/alerts/{alertId}"
     #{"accountId" "alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn alerts-list$
  "Required parameters: accountId
  
  List the alerts for the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/alerts"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-get$
  "Required parameters: accountId,adClientId,customChannelId
  
  Get the specified custom channel from the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "customChannelId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels/{customChannelId}"
     #{"accountId" "customChannelId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-list$
  "Required parameters: accountId,adClientId
  
  List all custom channels in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn customchannels-adunits-list$
  "Required parameters: accountId,adClientId,customChannelId
  
  List all ad units in the specified custom channel."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "customChannelId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/customchannels/{customChannelId}/adunits"
     #{"accountId" "customChannelId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn payments-list$
  "Required parameters: accountId
  
  List the payments for the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/payments"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generate$
  "Required parameters: startDate,endDate,accountId
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"startDate" "accountId" "endDate"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-generate$
  "Required parameters: accountId,savedReportId
  
  Generate an AdSense report based on the saved report ID sent in the query parameters."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "savedReportId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports/{savedReportId}"
     #{"accountId" "savedReportId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-saved-list$
  "Required parameters: accountId
  
  List all saved reports in the specified AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/reports/saved"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn savedadstyles-get$
  "Required parameters: accountId,savedAdStyleId
  
  List a specific saved ad style for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "savedAdStyleId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/savedadstyles/{savedAdStyleId}"
     #{"accountId" "savedAdStyleId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn savedadstyles-list$
  "Required parameters: accountId
  
  List all saved ad styles in the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/savedadstyles"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn urlchannels-list$
  "Required parameters: accountId,adClientId
  
  List all URL channels in the specified ad client for the specified account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "adClientId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "accounts/{accountId}/adclients/{adClientId}/urlchannels"
     #{"accountId" "adClientId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
