(ns happygapi.admob.accounts
  "AdMob API: accounts.
  The Google AdMob API lets you programmatically get reports on earnings.
  
  See: https://developers.google.com/admob/api/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about the specified AdMob publisher account."
  {:scopes nil}
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
  
  Lists the AdMob publisher account accessible with the client credential.
  Currently, all credentials have access to at most one AdMob account."
  {:scopes nil}
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

(defn mediationReport-generate$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/mediationReport/generate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportSpec {:timeZone string,
                :dimensions [string],
                :dateRange DateRange,
                :maxReportRows integer,
                :dimensionFilters [MediationReportSpecDimensionFilter],
                :metrics [string],
                :localizationSettings LocalizationSettings,
                :sortConditions [MediationReportSpecSortCondition]}}
  
  Generates an AdMob Mediation report based on the provided report
  specification."
  {:scopes nil}
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

(defn networkReport-generate$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/networkReport/generate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportSpec {:timeZone string,
                :dimensions [string],
                :dateRange DateRange,
                :maxReportRows integer,
                :localizationSettings LocalizationSettings,
                :metrics [string],
                :dimensionFilters [NetworkReportSpecDimensionFilter],
                :sortConditions [NetworkReportSpecSortCondition]}}
  
  Generates an AdMob Network report based on the provided report
  specification."
  {:scopes nil}
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
