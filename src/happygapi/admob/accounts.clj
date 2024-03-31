(ns happygapi.admob.accounts
  "AdMob API: accounts.
  The AdMob API allows publishers to programmatically get information about their AdMob account. 
  See: https://developers.google.com/admob/api/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the specified AdMob publisher account."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"
            "https://www.googleapis.com/auth/admob.report"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
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

(defn list$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists the AdMob publisher account that was most recently signed in to from the AdMob UI. For more information, see https://support.google.com/admob/answer/10243672."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"
            "https://www.googleapis.com/auth/admob.report"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn networkReport-generate$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/networkReport/generate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportSpec {:dateRange DateRange,
                :dimensions [string],
                :metrics [string],
                :dimensionFilters [NetworkReportSpecDimensionFilter],
                :sortConditions [NetworkReportSpecSortCondition],
                :localizationSettings LocalizationSettings,
                :maxReportRows integer,
                :timeZone string}}
  
  Generates an AdMob Network report based on the provided report specification. Returns result of a server-side streaming RPC. The result is returned in a sequence of responses."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"
            "https://www.googleapis.com/auth/admob.report"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/networkReport:generate"
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

(defn mediationReport-generate$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/mediationReport/generate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportSpec {:dateRange DateRange,
                :dimensions [string],
                :metrics [string],
                :dimensionFilters [MediationReportSpecDimensionFilter],
                :sortConditions [MediationReportSpecSortCondition],
                :localizationSettings LocalizationSettings,
                :maxReportRows integer,
                :timeZone string}}
  
  Generates an AdMob mediation report based on the provided report specification. Returns result of a server-side streaming RPC. The result is returned in a sequence of responses."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"
            "https://www.googleapis.com/auth/admob.report"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/mediationReport:generate"
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

(defn apps-list$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/apps/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the apps under the specified AdMob account."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/apps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adUnits-list$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/adUnits/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the ad units under the specified AdMob account."
  {:scopes ["https://www.googleapis.com/auth/admob.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/adUnits"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
