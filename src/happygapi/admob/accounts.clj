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
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  Lists the AdMob publisher account accessible with the client credential.
  Currently, all credentials have access to at most one AdMob account."
  {:scopes nil}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/accounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn networkReport-generate$
  "https://developers.google.com/admob/api/api/reference/rest/v1/accounts/networkReport/generate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reportSpec {:dateRange DateRange,
                :maxReportRows integer,
                :dimensionFilters [NetworkReportSpecDimensionFilter],
                :metrics [string],
                :localizationSettings LocalizationSettings,
                :sortConditions [NetworkReportSpecSortCondition],
                :timeZone string,
                :dimensions [string]}}
  
  Generates an AdMob Network report based on the provided report
  specification."
  {:scopes nil}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/networkReport:generate"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
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
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://admob.googleapis.com/"
     "v1/{+parent}/mediationReport:generate"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
