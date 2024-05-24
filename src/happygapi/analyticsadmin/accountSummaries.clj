(ns happygapi.analyticsadmin.accountSummaries
  "Google Analytics Admin API: accountSummaries.
  Manage properties in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning.
  See: http://code.google.com/apis/analytics/docs/mgmt/home.htmldocs/reference/rest/v1beta/accountSummaries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1beta/accountSummaries/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Returns summaries of all accounts accessible by the caller."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1beta/accountSummaries"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
