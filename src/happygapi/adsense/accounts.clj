(ns happygapi.adsense.accounts
  "AdSense Management API: accounts.
  The AdSense Management API allows publishers to access their inventory and run earnings and performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v2/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/get
  
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

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/listChildAccounts
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn getAdBlockingRecoveryTag$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/getAdBlockingRecoveryTag
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the ad blocking recovery tag of an account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/adBlockingRecoveryTag"
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn adclients-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the ad client from the given resource name."
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/getAdcode
  
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

(defn adclients-adunits-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/get
  
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

(defn adclients-adunits-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn adclients-adunits-getAdcode$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/getAdcode
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the ad unit code for a given ad unit. For more information, see [About the AdSense code](https://support.google.com/adsense/answer/9274634) and [Where to place the ad code in your HTML](https://support.google.com/adsense/answer/9190028)."
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

(defn adclients-adunits-create$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :reportingDimensionId string,
   :displayName string,
   :state string,
   :contentAdsSettings {:size string, :type string}}
  
  Creates an ad unit. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method. Note that ad units can only be created for ad clients with an \"AFC\" product code. For more info see the [AdClient resource](/adsense/management/reference/rest/v2/accounts.adclients). For now, this method can only be used to create `DISPLAY` ad units. See: https://support.google.com/adsense/answer/9183566"
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/adunits"
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

(defn adclients-adunits-patch$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :reportingDimensionId string,
   :displayName string,
   :state string,
   :contentAdsSettings {:size string, :type string}}
  
  Updates an ad unit. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method. For now, this method can only be used to update `DISPLAY` ad units. See: https://support.google.com/adsense/answer/9183566"
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
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

(defn adclients-adunits-listLinkedCustomChannels$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/adunits/listLinkedCustomChannels
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn adclients-customchannels-listLinkedAdUnits$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/listLinkedAdUnits
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn adclients-customchannels-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/get
  
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

(defn adclients-customchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn adclients-customchannels-create$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :reportingDimensionId string,
   :displayName string,
   :active boolean}
  
  Creates a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+parent}/customchannels"
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

(defn adclients-customchannels-patch$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :reportingDimensionId string,
   :displayName string,
   :active boolean}
  
  Updates a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}"
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

(defn adclients-customchannels-delete$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/customchannels/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a custom channel. This method can be called only by a restricted set of projects, which are usually owned by [AdSense for Platforms](https://developers.google.com/adsense/platforms/) publishers. Contact your account manager if you need to use this method."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
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

(defn adclients-urlchannels-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/urlchannels/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the selected url channel."
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

(defn adclients-urlchannels-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/adclients/urlchannels/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/alerts/list
  
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/payments/list
  
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

(defn reports-getSaved$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/getSaved
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the saved report from the given resource name."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adsense.googleapis.com/"
     "v2/{+name}/saved"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reports-generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/generate
  
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/generateCsv
  
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

(defn reports-saved-generate$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/saved/generate
  
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

(defn reports-saved-generateCsv$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/saved/generateCsv
  
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
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/reports/saved/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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

(defn sites-get$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/sites/get
  
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

(defn sites-list$
  "https://developers.google.com/adsense/management/api/reference/rest/v2/accounts/sites/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
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
