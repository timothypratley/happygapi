(ns happygapi.analyticsadmin.accountSummaries
  "Google Analytics Admin API: accountSummaries.
  
  See: http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accountSummaries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accountSummaries/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize
  
  Returns summaries of all accounts accessible by the caller."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/accountSummaries"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
