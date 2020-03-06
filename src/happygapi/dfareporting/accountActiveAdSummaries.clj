(ns happygapi.dfareporting.accountActiveAdSummaries
  "DCM/DFA Reporting And Trafficking API: accountActiveAdSummaries.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountActiveAdSummaries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/accountActiveAdSummaries/get
  
  Required parameters: profileId, summaryAccountId
  
  Optional parameters: none
  Gets the account's active ad summary by account ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:summaryAccountId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/accountActiveAdSummaries/{summaryAccountId}"
     #{:summaryAccountId :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
